package com.hackathon.app.service;


import com.hackathon.app.model.Business;
import com.hackathon.app.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public List<Business> getBusinessesByCategory(String category) {
        return businessRepository.findByCategory(category);
    }
    public List<Business> getBusinessesByLocation(String location) {
        return businessRepository.findByLocation(location);
    }

    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }
}