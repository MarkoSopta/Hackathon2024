package com.hackathon.app.model;

import com.hackathon.app.enums.BusinessType;
import jakarta.persistence.*;


@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naslov;
    private String category;
    private String description;
    private Double price;
    @Enumerated(EnumType.STRING)
    private BusinessType type;

    @Lob
    private byte[] image;

    public Business() {
    }

    public Business(Long id, String naslov, String category, String description, BusinessType type, byte[] image, Double price) {
        this.id = id;
        this.naslov = naslov;
        this.category = category;
        this.description = description;
        this.image = image;
        this.price = price;
        this.type=type;

    }

    public BusinessType getType() {
        return type;
    }

    public void setType(BusinessType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
