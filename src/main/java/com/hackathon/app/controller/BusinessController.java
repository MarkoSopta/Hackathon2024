package com.hackathon.app.controller;


import com.hackathon.app.model.Business;
import com.hackathon.app.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/businesses")
@CrossOrigin(origins = "http://localhost:8081/")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping
    public Business createBusiness(@RequestBody Business business) {
        return businessService.saveBusiness(business);
    }
    @GetMapping("/type/{type}")
    public List<Business> getBusinessesByType(@PathVariable String type) {
        return businessService.findBusinessesByType(type);
    }
    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public Business getBusiness(@PathVariable Long id) {
        return businessService.findById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Business>> searchBusinesses(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String description) {

        if (name != null) {
            return ResponseEntity.ok(businessService.searchByName(name));
        }  else if (type != null) {
            return ResponseEntity.ok(businessService.findBusinessesByType(type));
        } else if (category != null) {
            return ResponseEntity.ok(businessService.searchByCategory(category));
        } else if (description != null) {
            return ResponseEntity.ok(businessService.searchByDescription(description));
        } else {
            return ResponseEntity.badRequest().body(null); //
        }
    }



    @PutMapping("/{id}")
    public Business updateBusiness(@PathVariable Long id, @RequestBody Business business) {
        return businessService.updateBusiness(id, business);
    }

    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }

    @PostMapping("/{id}/uploadImage")
    public String uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        businessService.saveImage(id, file);
        return "Image uploaded successfully.";
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] image = businessService.getImage(id);
        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/image")
    public String deleteImage(@PathVariable Long id) {
        businessService.deleteImage(id);
        return "Image deleted successfully.";
    }

}
