package com.example.kiosk.lv4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuData menuData = new MenuData();
        List<Menu> menuList = menuData.selectData();

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}