package com.example.kiosk.lv4;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자에게 메뉴 번호를 입출력 받는 클래스
 */
public class Kiosk {

    // Kiosk가 관리할 메뉴 목록
    // 속성
    private List<Menu> kioskList;
    private Scanner sc = new Scanner(System.in);

    // 생성자
    public Kiosk(List<Menu> menuList) {
        this.kioskList = menuList;
    }

    // 기능
    // 키오스크 시작 메서드
    public void start() {
        // 반복문 시작
        while(true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println();
            System.out.println("[ 메인 메뉴 ]");
            kioskList.get(0).showSeqMenu(0);

            // 숫자 입력 받기
            System.out.print("원하시는 메뉴를 골라주세요: ");
            int mainNum = sc.nextInt();

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            if(mainNum == 0) { // 종료
                break; // 상위 반복문 탈출
            } else if(mainNum < 0 || mainNum >= kioskList.size()) { // 없는 메뉴 선택시 다시 반복
                System.out.println("없는 메뉴입니다.");
                continue; // 위로 돌아감
            }

            // List<Menu>에 인덱스로 접근하면 Menu만 추출
            Menu menu = kioskList.get(mainNum); // mainNum이 인덱스
            System.out.println();
            System.out.println("[ " + menu.getCategory(mainNum) + " 메뉴 ]");

            menu.showSeqMenu(1);

            while(true) {
                System.out.print("메뉴를 골라주세요: ");
                int menuNum = sc.nextInt();

                if(menuNum == 0) {
                    break;
                } else if(menuNum < 0 || mainNum >= kioskList.size()) {
                    System.out.println("없는 메뉴입니다.");
                } else {
                    MenuItem menuItem = menu.getMenuList().get(menuNum - 1);
                    System.out.println("선택한 메뉴: " + menuItem.getAll());
                }
            }
        }
    }
}
