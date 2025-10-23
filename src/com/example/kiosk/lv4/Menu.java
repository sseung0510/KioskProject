package com.example.kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuList;

    // 기본 생성자
    public Menu() {}

    // 메뉴리스트를 외부에서 받아 초기화
    public Menu(List<MenuItem> menuItems) {
        menuList = menuItems;
    }

    // 메인 메뉴 생성
    public List<MenuItem> mainMenu() {
        List<MenuItem> mainMenu = new ArrayList<>();
        mainMenu.add(new MenuItem("1. 햄버거"));
        mainMenu.add(new MenuItem("2. 음료수"));
        mainMenu.add(new MenuItem("3. 디저트"));
        return mainMenu;
    }

    // 햄버거 메뉴 생성
    public List<MenuItem> burgerMenu() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("1. 쉑쉑버거", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("2. 새우버거", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("3. 치즈버거", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("4. 치킨버거", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        return menuItems;
    }

    // 음료수 메뉴 생성
    public List<MenuItem> drinkMenu() {
        List<MenuItem> drinkItems  = new ArrayList<>();
        drinkItems.add(new MenuItem("1. 콜라", 2.0, "톡 쏘는 콜라"));
        drinkItems.add(new MenuItem("2. 환타", 2.0, "톡 쏘는 파인애플맛"));
        drinkItems.add(new MenuItem("3. 사이다", 2.0, "톡 쏘는 사이다"));
        return drinkItems;
    }

    // 디저트 메뉴 생성
    public List<MenuItem> dessertItems() {
        List<MenuItem> dessertItems  = new ArrayList<>();
        dessertItems.add(new MenuItem("1. 푸딩", 3.5, "아이들이 좋아하는 푸딩"));
        dessertItems.add(new MenuItem("2. 파르페", 6.0, "바삭바삭 과자와 달달한 아이스크림"));
        dessertItems.add(new MenuItem("3. 아포카토", 5.0, "커피와 어울리는 달달한 아이스크림"));
        return dessertItems;
    }

    // 메뉴 리스트 출력
    public void showSeqMenu(int num) {

        for(int i = 0; i < menuList.size(); i++) {
            System.out.println(menuList.get(i).getAll());
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