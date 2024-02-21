package com.jainil.restaurantManagementSystem.controller;


import com.jainil.restaurantManagementSystem.entity.*;
import com.jainil.restaurantManagementSystem.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private final String UPLOAD_DIRECTORY_COMPLAINTS = System.getProperty("user.dir") + "/uploads/complaints";

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/adminDashboard")
    public String showAdminDashboard(){
        LOGGER.info("showAdminDashboard() called");
        return "adminDashboard";
    }

    @GetMapping("/viewCity")
    public String showCities(Model model){
        LOGGER.info("showCities() called");
        List<City> cityList = cityService.fetchAllCities();
        model.addAttribute("cities",cityList);
        return "viewCity";
    }

    @GetMapping("/viewRestaurant")
    public String showRestaurant(Model model){
        LOGGER.info("showRestaurant() called");
        List<Restaurant> restaurantList = restaurantService.fetchRestaurantsByRole(Role.ROLE_RESTAURANT);
        model.addAttribute("restaurants",restaurantList);
        return "viewRestaurant";
    }

    @GetMapping("/viewArea")
    public String showArea(Model model){
        LOGGER.info("showArea() called");
        List<Area> areaList = areaService.fetchAllAreas();
        model.addAttribute("areas", areaList);
        return "viewArea";
    }

    @GetMapping("/viewCategory")
    public String showCategory(Model model){
        LOGGER.info("showCategory() called");
        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);
        return "viewCategory";
    }

    @GetMapping("/viewComplaint")
    public String showComplaint(Model model){
        LOGGER.info("showComplaint() called");
        List<Complaint> complaintList = complaintService.fetchAllComplaints();
        model.addAttribute("complaints",complaintList);

        return "viewComplaint";
    }

    @GetMapping("/viewSubCategory")
    public String showSubCategory(Model model){
        LOGGER.info("showSubCategory() called");
        List<SubCategory> subCategoryList = subCategoryService.fetchAllSubCategories();
        model.addAttribute("subCategories",subCategoryList);
        return "viewSubCategory";
    }

    @GetMapping("/viewOffers")
    public String showOffers(Model model){
        LOGGER.info("showOffers() called");
        List<Offer> offerList = offerService.fetchAllOffers();
        model.addAttribute("offers",offerList);
        return "viewOffers";
    }

    @GetMapping("/viewUserDetails")
    public String showUserDetails(Model model, Principal principal){
        System.out.println("principal.getName : "  + principal.getName());

        Restaurant user = restaurantService.fetchByRestaurantEmail(principal.getName());
        model.addAttribute("user",user);
        return "viewUserDetails";
    }

    @GetMapping("/addArea")
    public String addArea(Model model){
        LOGGER.info("addArea() called");
        List<City> cityList = cityService.fetchAllCities();
        for (City city: cityList){
            System.out.println(city.toString());
        }
        model.addAttribute("cities",cityList);
        return "addArea";
    }

    @GetMapping("/addCategory")
    public String addCategory(){
        LOGGER.info("addCategory() called");
        return "addCategory";
    }

    @GetMapping("/addCity")
    public String addCity(){
        LOGGER.info("addCity() called");
        return "addCity";
    }

    @GetMapping("/addComplaint")
    public String addComplaint(){
        LOGGER.info("addComplaint() called");
        return "addComplaint";
    }


    @GetMapping("/addSubCategory")
    public String addSubCategory(Model model){
        LOGGER.info("addSubCategory() called");
        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);
        return "addSubCategory";
    }

    // Update Get Mapping
    @GetMapping("/editCity/{cityId}")
    public String showEditCityPage(@PathVariable String cityId, Model model){
        City city = cityService.fetchCityById(Long.valueOf(cityId));
        model.addAttribute("city",city);
        return "editCity";
    }

    @GetMapping("/editArea/{areaId}")
    public String showEditAreaPage(@PathVariable String areaId,Model model){
        LOGGER.info("editArea() called");
        Area area = areaService.fetchAreaById(Long.valueOf(areaId));
        List<City> cityList = cityService.fetchAllCities();
        model.addAttribute("cities",cityList);
        model.addAttribute("area",area);
        return "editArea";
    }

    @GetMapping("/editCategoryData/{categoryId}")
    public String showEditCategoryPage(@PathVariable String categoryId, Model model){
        LOGGER.info("showEditCategoryPage() called");
        Category category = categoryService.fetchByCategoryId(Long.valueOf(categoryId));
        model.addAttribute("category", category);
        return "editCategory";
    }

    @GetMapping("/editSubCategoryData/{subCategoryId}")
    public String showEditSubCategoryPage(@PathVariable String subCategoryId, Model model){
        LOGGER.info("showSubCategoryPage() called");
        SubCategory subCategory = subCategoryService.fetchSubCategoryById(Long.valueOf(subCategoryId));
        model.addAttribute("subCategory",subCategory);
        List<Category> categoryList = categoryService.fetchAllCategories();
        model.addAttribute("categories",categoryList);
        return "editSubCategory";
    }

    @GetMapping("/viewComplaintAttachment/{filename:.+}")
    public ResponseEntity<Resource> showComplaintAttachment(@PathVariable String filename, Model model) throws FileNotFoundException, MalformedURLException {
        LOGGER.info("showProductImage() called");

        Path file = Paths.get(UPLOAD_DIRECTORY_COMPLAINTS).resolve(filename).normalize();
        Resource resource = new UrlResource(file.toUri());


        if (!resource.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }


    // Get Mapping to Delete Data
    @GetMapping("deleteCity/{cityId}")
    public String deleteCity(@PathVariable String cityId){

        cityService.deleteCity(Long.valueOf(cityId));

        return "redirect:/admin/adminDashboard?delete=city";
    }

    @GetMapping("/deleteArea/{areaId}")
    public String deleteArea(@PathVariable String areaId){
        areaService.deleteArea(Long.valueOf(areaId));

        return "redirect:/admin/adminDashboard?delete=area";
    }

    @GetMapping("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable String categoryId){
        categoryService.deleteCategory(Long.valueOf(categoryId));

        return "redirect:/admin/adminDashboard?delete=category";
    }

    @GetMapping("/deleteSubCategory/{subCategoryId}")
    public String deleteSubCategory(@PathVariable String subCategoryId){
        subCategoryService.deleteSubCategory(Long.valueOf(subCategoryId));
        return "redirect:/admin/adminDashboard?delete=subCategory";
    }

    @GetMapping("/showReply/{complaintId}")
    public String showReplyPage(@PathVariable String complaintId, Model model){
        Complaint complaint = complaintService.fetchComplaintById(Long.valueOf(complaintId));

        model.addAttribute("complaint",complaint);

        return "replyComplaint";

    }

    //Post Mappings
    @PostMapping("/saveCityData")
    public String saveCityData(@ModelAttribute City city){
        LOGGER.info("saveCityDate() called");

        if(!!Objects.nonNull(city.getCityName()) || "".equals(city.getCityName())){
            System.out.println(city.toString());
            return "redirect:/admin/adminDashboard?error=City_Name_Cannot_be_Empty";
        }
        if(!!Objects.nonNull(city.getCityDescription()) || "".equals(city.getCityDescription())){
            return "redirect:/admin/adminDashboard?error=City_Description_Name_Cannot_be_Empty";
        }

        cityService.saveCity(city);
//       return "/adminDashboard?selected=viewCity";
        return "redirect:/admin/adminDashboard?added=city";
    }

    @PostMapping("/saveAreaData")
    public String saveAreaData(@ModelAttribute Area area){
        LOGGER.info("saveCityDate() called");

        if(!Objects.nonNull(area.getAreaCityName()) || "".equals(area.getAreaCityName())){
            return "redirect:/admin/adminDashboard?error=Area_Name_Cannot_be_Empty";
        }

        if(!Objects.nonNull(area.getAreaName()) || "".equals(area.getAreaName())){
            return "redirect:/admin/adminDashboard?error=Area_Description_Name_Cannot_be_Empty";
        }

        if(!Objects.nonNull(area.getAreaDescription()) || "".equals(area.getAreaDescription())){
            return "redirect:/admin/adminDashboard?error=Area_Description_Name_Cannot_be_Empty";
        }


        areaService.saveArea(area);
//       return "/adminDashboard?selected=viewCity";
        return "redirect:/admin/adminDashboard?added=area";
    }

    @PostMapping("/saveCategoryData")
    public String saveCategoryData(@ModelAttribute Category category){
        LOGGER.info("saveCategoryData() called");

        if(!Objects.nonNull(category.getCategoryName()) || "".equals(category.getCategoryName())){
            return "redirect:/admin/adminDashboard?error=Category_Name_Cannot_be_Empty";
        }

        if(!Objects.nonNull(category.getCategoryDescription()) || "".equals(category.getCategoryDescription())){
            return "redirect:/admin/adminDashboard?error=Category_Description_Name_Cannot_be_Empty";
        }

        categoryService.saveCategory(category);
        return "redirect:/admin/adminDashboard?added=category";
    }

    @PostMapping("/saveSubCategoryData")
    public String saveSubCategoryData(@ModelAttribute SubCategory subCategory){
        LOGGER.info("saveSubCategoryData() called");

        if(!Objects.nonNull(subCategory.getSubCategoryName()) || "".equals(subCategory.getSubCategoryName())){
            return "redirect:/admin/adminDashboard?error=Sub_Category_Name_Cannot_be_Empty";
        }

        if(!Objects.nonNull(subCategory.getSubCategoryCategoryName()) || "".equals(subCategory.getSubCategoryCategoryName())){
            return "redirect:/admin/adminDashboard?error=Sub_Category_Category_Name_Cannot_be_Empty";
        }


        if(!Objects.nonNull(subCategory.getSubCategoryDescription()) || "".equals(subCategory.getSubCategoryDescription())){
            return "redirect:/admin/adminDashboard?error=Sub_Category_Description_Name_Cannot_be_Empty";
        }

        subCategoryService.saveSubCategory(subCategory);
        return "redirect:/admin/adminDashboard?added=subCategory";
    }

    //Update Post Mapping
    @PostMapping("/updateCityData/{cityId}")
    public String updateCityData(@PathVariable String cityId,@ModelAttribute City city){
        LOGGER.info("updateCityData() called");
        cityService.update(Long.valueOf(cityId), city);
        return "redirect:/admin/adminDashboard?update=city";
    }

    @PostMapping("/updateAreaData/{areaId}")
    public String updateAreaData(@PathVariable String areaId,@ModelAttribute Area area){
        LOGGER.info("updateAreaData() called");

        areaService.update(Long.valueOf(areaId), area);

        return "redirect:/admin/adminDashboard?update=area";
    }

    @PostMapping("/updateCategoryData/{categoryId}")
    public String updateCategoryData(@PathVariable String categoryId,@ModelAttribute Category category){
        LOGGER.info("updateCategoryData() called");

        categoryService.update(Long.valueOf(categoryId), category);
        return "redirect:/admin/adminDashboard?update=category";
    }

    @PostMapping("/updateSubCategoryData/{subCategoryId}")
    public String updateSubCategoryData(@PathVariable String subCategoryId,@ModelAttribute SubCategory subCategory){
        LOGGER.info("updateSubCategoryData() called");

        subCategoryService.update(Long.valueOf(subCategoryId), subCategory);

        return "redirect:/admin/adminDashboard?update=Sub_Category";
    }

    @PostMapping("/addReplyToComplaint/{complaintId}")
    public String addComplaint(@RequestParam("complaintReply") String complaintReply,@PathVariable String complaintId) throws ParseException {
        LOGGER.info("addComplaint() called");
        Complaint complaint = complaintService.fetchComplaintById(Long.valueOf(complaintId));
        System.out.println(complaint.toString());

        if(complaintReply.equals("") || !Objects.nonNull(complaintReply)){
           return "redirect:/admin/adminDashboard?error=Reply_cannot_be_empty";
        }

        complaint.setComplaintReply(complaintReply);
        complaint.setComplaintStatus(ComplaintStatus.IN_PROGRESS);
        System.out.println("dasfhadjkfadsfjhl");
        System.out.println(complaint.toString());
        complaintService.updateComplaint(complaint);
        return "redirect:/admin/adminDashboard?added=Reply";
    }

}
