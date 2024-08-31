package com.hackathon.app.model;

import com.hackathon.app.enums.BusinessType;
import jakarta.persistence.*;


@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String description;
    private String location;
    private Double price;
    @Enumerated(EnumType.STRING)
    private BusinessType type;

    @Lob
    private byte[] image;

    public Business() {
    }

    public Business(Long id, String name, String category, String description, BusinessType type,String location,byte[] image, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.location = location;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
