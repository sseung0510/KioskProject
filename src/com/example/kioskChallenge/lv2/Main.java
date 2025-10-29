package com.example.kioskChallenge.lv2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuData menuData = new MenuData(); // MenuData 객체 생성
        List<Menu> menuList = menuData.getMenuList(); // 메뉴리스트 조회
        Kiosk kiosk = new Kiosk(menuList); // Kiosk 객체 생성 및 menuList 전달
        kiosk.start(); // start메서드 호출
    }
}