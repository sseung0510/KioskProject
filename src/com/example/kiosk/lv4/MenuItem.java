package com.example.kiosk.lv4;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    // 햄버거 메뉴
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 메인 메뉴
    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public String getAll(){
        if(description == null) {
            return name;
        } else {
            return name + " | w " + price + " | " + description;
        }
    }
}