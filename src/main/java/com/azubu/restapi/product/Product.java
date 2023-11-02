package com.azubu.restapi.product;

public class Product {

    private int id;

    private String name;

    private String mainGroup;

    private String tag;

    private String expirationDate;

    private double price;

    private int weightInGrams;

    public Product() {
    }

    public Product(int id, String name, String mainGroup, String tag, String expirationDate, double price, int weightInGrams) {
        this.id = id;
        this.name = name;
        this.mainGroup = mainGroup;
        this.tag = tag;
        this.expirationDate = expirationDate;
        this.price = price;
        this.weightInGrams = weightInGrams;
    }

    public Product(int id, String name, String mainGroup, String tag, String expirationDate, double price) {
        this.id = id;
        this.name = name;
        this.mainGroup = mainGroup;
        this.tag = tag;
        this.expirationDate = expirationDate;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMainGroup() {
        return mainGroup;
    }

    public void setMainGroup(String mainGroup) {
        this.mainGroup = mainGroup;
    }


    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }
}
