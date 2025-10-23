package com.example.kiosk.lv4;

public class Main {
    public static void main(String[] args) {

        // Menu 객체 생성
        Menu menu = new Menu();

        // 메뉴 리스트를 전달해서 kiosk 객체 생성
        Kiosk mainKiosk = new Kiosk(menu.mainMenu()); // 메인
        Kiosk menuKiosk = new Kiosk(menu.burgerMenu());  // 햄버거
        Kiosk drinkKiosk = new Kiosk(menu.drinkMenu()); // 음료수
        Kiosk dessertKiosk = new Kiosk(menu.dessertItems()); // 디저트


        while(true){
            int num = mainKiosk.start(0, "[ MAIN MENU ]");
            switch(num){
                case 1:
                    menuKiosk.start(1, "[ 햄버거 MENU ]"); // 햄버거
                    break;
                case 2:
                    drinkKiosk.start(2, "[ 음료수 MENU ]"); // 음료수
                    break;
                case 3:
                    dessertKiosk.start(3, "[ 디저트 MENU ]"); // 디저트
                    break;
                default:
                    System.out.println("없는 메뉴입니다. 다시 입력해주세요: ");
            }
        }
    }
}