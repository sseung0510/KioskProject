package com.example.kiosk.lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<MenuItem> mainMenu = new ArrayList<>();
        mainMenu.add(new MenuItem("1. 햄버거"));
        mainMenu.add(new MenuItem("2. 음료수"));
        mainMenu.add(new MenuItem("3. 디저트"));

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("1. 쉑쉑버거", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("2. 새우버거", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("3. 치즈버거", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("4. 치킨버거", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<MenuItem> drinkItems  = new ArrayList<>();
        drinkItems.add(new MenuItem("1. 콜라"));
        drinkItems.add(new MenuItem("2. 환타"));
        drinkItems.add(new MenuItem("3. 사이다"));

        List<MenuItem> dessertItems  = new ArrayList<>();
        dessertItems.add(new MenuItem("1. 푸딩"));
        dessertItems.add(new MenuItem("2. 커피"));
        dessertItems.add(new MenuItem("3. 파르페"));

        Kiosk mainKiosk = new Kiosk(mainMenu);
        Kiosk menuKiosk = new Kiosk(menuItems);
        Kiosk drinkKiosk = new Kiosk(drinkItems);
        Kiosk dessertiosk = new Kiosk(dessertItems);


        while(true){
            int num = mainKiosk.mainStart(0, "[ MAIN MENU ]");
            switch(num){
                case 1:
                    menuKiosk.mainStart(1, "[ 햄버거 MENU ]"); // 햄버거
                    break;
                case 2:
                    drinkKiosk.mainStart(2, "[ 음료수 MENU ]"); // 음료수
                    break;
                case 3:
                    dessertiosk.mainStart(2, "[ 디저트 MENU ]"); // 음료수
                    break;
                default:
                    System.out.println("없는 메뉴입니다. 다시 입력해주세요: ");
            }
        }
    }
}