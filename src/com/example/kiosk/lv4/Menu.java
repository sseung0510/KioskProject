package com.example.kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 속성
    private String category;
    private List<MenuItem> menuList = new ArrayList<>();

    // 생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        for(MenuItem menuItem : menuItems) {
            this.menuList.add(menuItem);
        }
    }

    // 기능
    public String getCategory(int mainNum) {
        return category;
    }

    // 값 저장 메서드
    void addItem(MenuItem item) {
        menuList.add(item);
    }

    // 메뉴 리스트 출력
    public int showSeqMenu(int num) {

        for(int i = 0; i < menuList.size(); i++) {
            System.out.println(menuList.get(i).getAll());
        }
        if(num == 0){
            System.out.println("0. 종료    | 종료");
        } else {
            System.out.println("0. 뒤로가기 | 뒤로가기");
        }
        return num;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }
}