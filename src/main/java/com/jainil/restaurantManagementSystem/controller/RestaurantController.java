package com.jainil.restaurantManagementSystem.controller;


import com.jainil.restaurantManagementSystem.entity.*;
import com.jainil.restaurantManagementSystem.service.*;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OfferService offerService;


    private final String UPLOAD_DIRECTORY_IMAGES = System.getProperty("user.dir") + "/uploads/products";
    private final String UPLOAD_DIRECTORY_COMPLAINTS = System.getProperty("user.dir") + "/uploads/complaints";

//    @GetMapping("/login")
//    public String showLoginPage(){
//        LOGGER.info("showLoginPage() Called");
//        return "login";
//    }
//
//    @GetMapping("/register")
//    public String showRegisterPage(){
//        LOGGER.info("showRegisterPage() Called");
//        return "register";
//    }

    @GetMapping("/restaurantDashboard")
    public String showRestaurantDashboard(){
        return "restaurantDashboard";
    }



    @GetMapping("/viewProduct")
    public String showProducts(Model model,HttpSession httpSession){

        List<Product> productList = productService.fetchAllProductsByProductRestaurant(httpSession.getAttribute("email").toString());
        model.addAttribute("products",productList);
        return "viewProduct";
    }


    @GetMapping("/addOffer")
    public String addOffers(Model model){
        LOGGER.info("addOffers() called");
        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);
        return "addOffer";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        LOGGER.info("addProduct() called");

        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);

        return "addProduct";
    }

    @GetMapping("/complaints")
    public String showRegisterComplaintPage(){
        return "addComplaint";
    }

//    @GetMapping("/viewProducts")
//    public String showComplaints(){
//        return "viewProduct";
//    }

    @GetMapping("/viewOffers")
    public String showOffers(Model model,HttpSession httpSession){
        LOGGER.info("showOffers() called");
        List<Offer> offerList = offerService.fetchAllOffersByRestaurant(httpSession.getAttribute("email").toString());
        model.addAttribute("offers",offerList);
        return "viewOffers";
    }

    @GetMapping("/viewOrder")
    public String showOrders(){
        LOGGER.info("showOrders() called");
        return "viewOrder";
    }

    @GetMapping("/viewProductImage/{filename:.+}")
    public ResponseEntity<Resource> showProductImage(@PathVariable String filename) throws MalformedURLException, FileNotFoundException {
        LOGGER.info("showProductImage() called");

        Path file = Paths.get(UPLOAD_DIRECTORY_IMAGES).resolve(filename).normalize();
        Resource resource = new UrlResource(file.toUri());


        if (!resource.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG) // Adjust content type based on your image type
                .body(resource);
    }

//    @GetMapping("/viewProductImage/{productImageUrl}")
//    public String showProductImage(@PathVariable String productImageUrl,Model model){
//        LOGGER.info("showProductImage() called");
//        model.addAttribute("imageUrl",productImageUrl);
//        System.out.println(productImageUrl);
//        return "viewImage";
//    }

    //Update GetMapping
    @GetMapping("/editOffer/{offerId}")
    public String showUpdateOfferPage(@PathVariable String offerId,Model model){
        LOGGER.info("updateOffer() called");
        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);

        Offer offer = offerService.fetchOfferById(Long.valueOf(offerId));
        model.addAttribute("offer", offer);
        return "editOffer";
    }

    @GetMapping("/editProduct/{productId}")
    public String showUpdateProductPage(@PathVariable String productId,Model model){
        LOGGER.info("updateProduct() called");

        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);

        Product product = productService.fetchProductById(Long.valueOf(productId));
        model.addAttribute("product", product);
        return "editProduct";
    }

    @GetMapping("/viewUserDetails")
    public String showUserDetails(HttpSession httpSession,Model model){
        Restaurant user = restaurantService.fetchByRestaurantEmail(httpSession.getAttribute("email").toString());
        model.addAttribute("user",user);
        return "viewUserDetails";
    }



    // Post Mappings
    @PostMapping("/registerComplaint")
    public String registerComplaint(@ModelAttribute Complaint complaint, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            Path filePath = Paths.get(UPLOAD_DIRECTORY_COMPLAINTS).resolve(filename);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


            complaint.setComplaintAttachmentUrl(filename);
        }

        if(!Objects.nonNull(complaint.getComplaintSubject()) ||"".equals(complaint.getComplaintSubject())){
            return "redirect:/restaurant/restaurantDashboard?error=Complaint_Subject_cannot_be_empty";
        }

        if(!Objects.nonNull(complaint.getComplaintDescription()) ||"".equals(complaint.getComplaintDescription())){
            return "redirect:/restaurant/restaurantDashboard?error=Complaint_Description_cannot_be_empty";
        }

        if(!Objects.nonNull(complaint.getComplaintAttachmentUrl()) ||"".equals(complaint.getComplaintAttachmentUrl())){
            return "redirect:/restaurant/restaurantDashboard?error=Complaint_Attachment_cannot_be_empty";
        }


        complaintService.saveComplaint(complaint);

        return "redirect:/restaurant/restaurantDashboard?added=Complaint";
    }

//    @PostMapping("/saveProductData")
//    public String registerProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file,HttpSession httpSession) throws IOException {
//        StringBuilder fileNames = new StringBuilder();
//        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY_IMAGES, file.getOriginalFilename());
//        fileNames.append(file.getOriginalFilename());
//        Files.write(fileNameAndPath, file.getBytes());
//
//        product.setProductImageUrl(fileNameAndPath.toString());
//        product.setProductRestaurant(httpSession.getAttribute("email").toString());
//
//        productService.saveProduct(product);
//
//        return "redirect:/restaurant/restaurantDashboard";
//    }

    @PostMapping("/saveProductData")
    public String registerProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file, HttpSession httpSession) throws IOException {

        if (!file.isEmpty()) {
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            Path filePath = Paths.get(UPLOAD_DIRECTORY_IMAGES).resolve(filename);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


            product.setProductImageUrl(filename);
        }

        if(!Objects.nonNull(product.getProductName()) || "".equals(product.getProductName())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Name_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductDescription()) || "".equals(product.getProductDescription())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Description_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductPrice()) || "".equals(product.getProductPrice())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Price_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductCategoryName()) || "".equals(product.getProductCategoryName())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Category_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductSubCategoryName()) || "".equals(product.getProductSubCategoryName())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Sub_Category_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductPrice()) || "".equals(product.getProductPrice())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Price_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductImageUrl()) || "".equals(product.getProductImageUrl())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Image_URL_cannot_be_empty";
        }

        if(!Objects.nonNull(product.getProductName()) || "".equals(product.getProductName())){
            return "redirect:/restaurant/restaurantDashboard?error=Product_Name_cannot_be_empty";
        }



        product.setProductRestaurant(httpSession.getAttribute("email").toString());

        productService.saveProduct(product);

        return "redirect:/restaurant/restaurantDashboard?added=Product";
    }

    @PostMapping("/saveOfferData")
    public String registerOffer(@ModelAttribute Offer offer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpSession httpSession) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        offer.setOfferStartDate(dateFormat.parse(startDate));
        offer.setOfferEndDate(dateFormat.parse(endDate));
        offer.setOfferRestaurant(httpSession.getAttribute("email").toString());
        System.out.println(offer.toString());


        if(!Objects.nonNull(offer.getOfferName()) || "".equals(offer.getOfferName())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Name_cannot_be_empty";
        }else if(!Objects.nonNull(offer.getOfferDescription()) || "".equals(offer.getOfferDescription())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Description_cannot_be_empty";
        }else if(!Objects.nonNull(offer.getOfferDiscount()) || "".equals(offer.getOfferDiscount())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Discount_cannot_be_empty";
        }

        if(!Objects.nonNull(offer.getOfferCategoryName()) || "".equals(offer.getOfferCategoryName())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Category_cannot_be_empty";
        }

        if(!Objects.nonNull(offer.getOfferSubCategoryName()) || "".equals(offer.getOfferSubCategoryName())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Sub_Category_cannot_be_empty";
        }

        if(!Objects.nonNull(offer.getOfferStartDate()) || "".equals(offer.getOfferStartDate())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Start_Date_cannot_be_empty";
        }


        if(!Objects.nonNull(offer.getOfferEndDate()) || "".equals(offer.getOfferEndDate())){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_End_Date_cannot_be_empty";
        }

        if(offer.getOfferStartDate().after(new Date(String.valueOf(LocalDateTime.now()))) ){
            return "redirect:/restaurant/restaurantDashboard?error=Offer_Start_Date_cannot_be_in_past";
        }

        offerService.saveOffer(offer);

        return "redirect:/restaurant/restaurantDashboard?added=Offer";
    }

    @PostMapping("/updateOfferData/{offerId}")
    public String updateOffer(@ModelAttribute Offer offer,@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,@PathVariable String offerId) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        offer.setOfferStartDate(dateFormat.parse(startDate));
        offer.setOfferEndDate(dateFormat.parse(endDate));
        System.out.println(offer.toString());
        offerService.updateOffer(Long.valueOf(offerId),offer);

        return "redirect:/restaurant/restaurantDashboard?update=Offer";
    }


    @GetMapping("/deleteOffer/{offerId}")
    public String deleteOffer(@PathVariable String offerId){

        offerService.deleteOffer(Long.valueOf(offerId));

        return "redirect:/restaurant/restaurantDashboard?delete=Offer";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable String productId){

        productService.deleteProduct(Long.valueOf(productId));

        return "redirect:/restaurant/restaurantDashboard?delete=Offer";
    }

    @PostMapping("/updateProductData/{prdouctId}")
    public String updateProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file,@PathVariable String prdouctId) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY_IMAGES, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        product.setProductImageUrl(fileNameAndPath.toString());

        productService.updateProduct(Long.valueOf(prdouctId), product);


        return "redirect:/restaurant/restaurantDashboard?update=Product";
    }

}
