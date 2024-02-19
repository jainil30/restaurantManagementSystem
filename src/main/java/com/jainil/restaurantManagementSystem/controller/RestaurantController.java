package com.jainil.restaurantManagementSystem.controller;


import com.jainil.restaurantManagementSystem.entity.*;
import com.jainil.restaurantManagementSystem.service.*;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @GetMapping("/viewProducts")
    public String showComplaints(){
        return "viewProduct";
    }

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

    @GetMapping("/viewProductImage/{productImageUrl}")
    public String showProductImage(@PathVariable String productImageUrl,Model model){
        LOGGER.info("showProductImage() called");
        model.addAttribute("imageUrl",productImageUrl);
        return "viewImage";
    }

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




    // Post Mappings
    @PostMapping("/registerComplaint")
    public String registerComplaint(@ModelAttribute Complaint complaint, @RequestParam("file") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY_COMPLAINTS, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        complaint.setComplaintAttachmentUrl(fileNameAndPath.toString());
        complaintService.saveComplaint(complaint);

        return "redirect:/restaurant/restaurantDashboard";
    }

    @PostMapping("/saveProductData")
    public String registerProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file,HttpSession httpSession) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY_IMAGES, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        product.setProductImageUrl(fileNameAndPath.toString());
        product.setProductRestaurant(httpSession.getAttribute("email").toString());

        productService.saveProduct(product);

        return "redirect:/restaurant/restaurantDashboard";
    }

    @PostMapping("/saveOfferData")
    public String registerOffer(@ModelAttribute Offer offer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpSession httpSession) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        offer.setOfferStartDate(dateFormat.parse(startDate));
        offer.setOfferEndDate(dateFormat.parse(endDate));
        offer.setOfferRestaurant(httpSession.getAttribute("email").toString());
        System.out.println(offer.toString());

        offerService.saveOffer(offer);

        return "redirect:/restaurant/restaurantDashboard";
    }

    @PostMapping("/updateOfferData/{offerId}")
    public String updateOffer(@ModelAttribute Offer offer,@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,@PathVariable String offerId) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        offer.setOfferStartDate(dateFormat.parse(startDate));
        offer.setOfferEndDate(dateFormat.parse(endDate));

        System.out.println(offer.toString());
        offerService.updateOffer(Long.valueOf(offerId),offer);

        return "redirect:/restaurant/restaurantDashboard";
    }


    @GetMapping("/deleteOffer/{offerId}")
    public String deleteOffer(@PathVariable String offerId){

        offerService.deleteOffer(Long.valueOf(offerId));

        return "redirect:/restaurant/restaurantDashboard";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable String productId){

        productService.deleteProduct(Long.valueOf(productId));

        return "redirect:/restaurant/restaurantDashboard";
    }

    @PostMapping("/updateProductData/{prdouctId}")
    public String updateProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file,@PathVariable String prdouctId) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY_IMAGES, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        product.setProductImageUrl(fileNameAndPath.toString());

        productService.updateProduct(Long.valueOf(prdouctId), product);


        return "redirect:/restaurant/restaurantDashboard";
    }

}
