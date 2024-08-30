package com.hackathon.app.controller;


import com.hackathon.app.model.Business;
import com.hackathon.app.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/category/{category}")
    public List<Business> getBusinessesByCategory(@PathVariable String category) {
        return businessService.getBusinessesByCategory(category);
    }

    @GetMapping("/location/{location}")
    public List<Business> getBusinessesByLocation(@PathVariable String location) {
        return businessService.getBusinessesByLocation(location);
    }


    @PostMapping
    public Business createBusiness(@RequestBody Business business) {
        return businessService.saveBusiness(business);
    }
}