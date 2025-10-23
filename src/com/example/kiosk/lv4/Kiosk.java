package com.example.kiosk.lv4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int mainStart(int num, String menuName) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(menuItems);

        System.out.println(menuName);
        menu.showSeqMenu(num);

        while(true) {
            System.out.print("원하시는 메뉴를 골라주세요: ");
            int menuNum = sc.nextInt();

            if(menuNum == 0){
                if(num == 0){
                    System.out.println("0. 종료");
                    System.exit(0);
                } else {
                    System.out.println("0. 뒤로가기");
                    return 0;
                }
            } else if(menuNum > menuItems.size() || menuNum < 0){
                System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
            } else {
                if(num == 0){
                    return menuNum;
                } else {
                    MenuItem menuItem = menuItems.get(menuNum - 1);
                    System.out.println("선택한 메뉴: " + menuItem.getAll());
                }
            }
        }
    }
}
