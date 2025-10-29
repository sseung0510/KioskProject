package com.example.kioskChallenge.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 여러 개의 MenuItem를 리스트로 묶어서 하나의 메뉴로 관리하는 기능
 */
public class Menu {

    // 속성
    private final String category;
    private final List<MenuItem> menuItemList = new ArrayList<>();

    // 생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItemList.addAll(menuItems); // 리스트로 한번에 들어온 값을 menuItemList 추가
    }

    // 기능
    /**
     * category를 가져오는 getter
     */
    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuList() {
        return menuItemList;
    }

    /**
     * 메뉴 아이템 리스트 출력 기능
     */
    public void showMenuItemList() {
        AtomicInteger index = new AtomicInteger(1);

         menuItemList.stream().forEach(menuItem -> {
             int currentIndex = index.getAndIncrement();
             System.out.println(currentIndex + ". " + menuItem.getAll());
         });

        System.out.println("0. 뒤로가기 | 뒤로가기");
    }
}