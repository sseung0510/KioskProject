package com.example.kiosk.lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");

        for(int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i).getAll());
        }
        System.out.println("0. 종료    | 종료");

        while(true) {
            System.out.print("원하시는 메뉴를 골라주세요: ");
            int menuNum = sc.nextInt();

            if(menuNum == 0){
                System.out.println("0. 종료");
                break;
            } else if(menuNum > menuItems.size() || menuNum < 0){
                System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
                continue;
            } else {
                MenuItem menuItem = menuItems.get(menuNum - 1);
                System.out.println("선택한 메뉴: " + menuItem.getAll());
            }

            if(menuNum == 0){
                break;
            }
        }
        return menuItems;
    }










}
