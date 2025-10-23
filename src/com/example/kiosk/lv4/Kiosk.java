package com.example.kiosk.lv4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // Kiosk가 관리할 메뉴 목록
    List<MenuItem> kioskItems;

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.kioskItems = menuItems;
    }

    // 키오스크 시작 메서드
    public int start(int num, String menuName) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu(kioskItems); // 현재 키오스크가 보여줄 리스트를 Menu 객체로 관리

        System.out.println();
        System.out.println(menuName); // 메뉴 제목 출력
        menu.showSeqMenu(num); // 메뉴리스트 출력

        while(true) {
            System.out.print("원하시는 메뉴를 골라주세요: ");

            if(!sc.hasNextInt()) { // 문자가 들어올 경우 실행
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();
                continue;
            }
            int menuNum = sc.nextInt();

            if(menuNum == 0){ // 0 입력 시 실행
                if(num == 0){ // num이 0일 경우 메인 메뉴의 종료 메시지 출력
                    System.out.println("0. 종료");
                    System.exit(0); // 프로그램 강제 종료
                } else { // 햄버거, 음료수, 디저트 일 경우 뒤로가기 메시지 출력
                    System.out.println("0. 뒤로가기");
                    return 0;
                }
            } else if(menuNum > menu.getMenuList().size() || menuNum < 0){ // 없는 메뉴 선택할 시 실행
                System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
            } else {
                if(num == 0){ // 메인 메뉴일 경우 선택 번호 반환 => Main의 스위치문으로 이동
                    return menuNum;
                } else { // 그 외의 경우 해당 메뉴의 상세 정보 출력
                    MenuItem menuItem = menu.getMenuList().get(menuNum - 1);
                    System.out.println("선택한 메뉴: " + menuItem.getAll());
                }
            }
        }
    }
}
