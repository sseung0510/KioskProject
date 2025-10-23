package com.example.kiosk.lv4;

import java.util.List;

public class Menu {
    List<MenuItem> menuItems;


    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> showSeqMenu(int num) {

        for(int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i).getAll());
        }
        if(num == 0){
            System.out.println("0. 종료    | 종료");
        } else {
            System.out.println("0. 뒤로가기 | 뒤로가기");

        }

        return menuItems;
    }
}