package com.hackathon.app.repository;


import com.hackathon.app.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findByCategory(String category);

    List<Business> findByNaslovContainingIgnoreCase(String naslov);


    List<Business> findByType(String type);


    @Query("SELECT b FROM Business b WHERE b.description LIKE %:keyword%")

    List<Business> searchByDescriptionContaining(@Param("keyword") String keyword);
}