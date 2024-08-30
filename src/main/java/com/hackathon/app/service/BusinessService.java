package com.hackathon.app.service;


import com.hackathon.app.model.Business;
import com.hackathon.app.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;


    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business findById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    public Business updateBusiness(Long id, Business updatedBusiness) {
        Business business = findById(id);
        if (business != null) {
            business.setName(updatedBusiness.getName());
            business.setDescription(updatedBusiness.getDescription());
            business.setLocation(updatedBusiness.getLocation());
            business.setImage(updatedBusiness.getImage());
            business.setPrice(updatedBusiness.getPrice());
            return saveBusiness(business);
        }
        return null;
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }

    public void saveImage(Long businessId, MultipartFile file) throws IOException {
        Business business = findById(businessId);
        if (business != null && file != null && !file.isEmpty()) {
            business.setImage(file.getBytes());
            saveBusiness(business);
        }
    }

    public byte[] getImage(Long businessId) {
        Business business = findById(businessId);
        return business != null ? business.getImage() : null;
    }

    public void deleteImage(Long businessId) {
        Business business = findById(businessId);
        if (business != null) {
            business.setImage(null);
            saveBusiness(business);
        }
    }





    public List<Business> searchByName(String name) {
        return businessRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Business> searchByLocation(String location) {
        return businessRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Business> searchByDescription(String keyword) {
        return businessRepository.searchByDescriptionContaining(keyword);
        }
    }
