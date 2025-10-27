package com.example.kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

/**
 * 여러 개의 MenuItem를 리스트로 묶어서 하나의 메뉴로 관리하는 기능
 */
public class Menu {

    // 속성
    private final String category;
    private final List<MenuItem> menuList = new ArrayList<>();

    // 생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        for(MenuItem menuItem : menuItems) { // 리스트로 한번에 들어온 값을 menuList에 추가
            this.menuList.add(menuItem);
        }
    }

    // 기능
    /**
     * category를 가져오는 getter
     */
    public String getCategory() {
        return category;
    }

    /**
     * 메뉴 리스트 출력 기능
     */
    public void showSeqMenu(int num) {

        for(int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getAll());
        }
        if(num == 0){
            System.out.println("0. 종료    | 종료");
        } else {
            System.out.println("0. 뒤로가기 | 뒤로가기");
        }
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }
}