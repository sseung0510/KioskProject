package com.example.kiosk.lv4;

public class MenuItem {
    private String name;
    private double price;
    private String description;


    // 햄버거, 음료, 디저트 메뉴용 생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 메인 메뉴 생성자
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

    // 메뉴 정보를 문자열로 반환
    public String getAll(){
        if(description == null) { // 설명이 없으면 name만 반환
            return name;
        } else {
            return name + " | w " + price + " | " + description;
        }
    }
}