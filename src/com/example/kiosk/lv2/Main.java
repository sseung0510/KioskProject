package com.example.kiosk.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("쉑쉑버거  ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("스모크버거 ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("치즈버거  ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("햄버거    ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("[ SHAKESHACK MENU ]");

            for(int i = 0; i < menuItems.size()+1; i++) {
                if(i < menuItems.size()){
                    System.out.println(i+1 + ". " + menuItems.get(i).getName() + "| w " + menuItems.get(i).getPrice() + "| " + menuItems.get(i).getDescription());
                } else {
                    System.out.println("0. 종료     | 종료");
                }
            }

            System.out.print("원하시는 메뉴를 골라주세요: ");
            int menuNum = sc.nextInt();

            switch (menuNum) {
                case 1:
                    System.out.println("1. 쉑쉑버거");
                    break;
                case 2:
                    System.out.println("2. 스모크버거");
                    break;
                case 3:
                    System.out.println("3. 치즈버거");
                    break;
                case 4:
                    System.out.println("4. 햄버거");
                    break;
                case 0:
                    System.out.println("0. 종료");
                    break;
                default:
                    System.out.print("없는 메뉴입니다. 다시 입력해주세요: ");

            }
            break;
        }
    }
}