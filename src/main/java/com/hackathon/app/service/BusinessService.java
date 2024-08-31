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
            if (updatedBusiness.getNaslov() != null) {
                business.setNaslov(updatedBusiness.getNaslov());
            }
            if (updatedBusiness.getDescription() != null) {
                business.setDescription(updatedBusiness.getDescription());
            }
            if (updatedBusiness.getCategory() != null) {
                business.setCategory(updatedBusiness.getCategory());
            }
            if (updatedBusiness.getImage() != null) {
                business.setImage(updatedBusiness.getImage());
            }
            if (updatedBusiness.getPrice() != null) {
                business.setPrice(updatedBusiness.getPrice());
            }
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



    public List<Business> findBusinessesByType(String type) {
        return businessRepository.findByType(type);
    }

    public List<Business> searchByName(String naslov) {
        return businessRepository.findByNaslovContainingIgnoreCase(naslov);
    }

    public List<Business> searchByCategory(String category) {
        return businessRepository.findByCategory(category);
    }


    public List<Business> searchByDescription(String keyword) {
        return businessRepository.searchByDescriptionContaining(keyword);
        }
}
