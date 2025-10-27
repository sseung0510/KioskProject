package com.example.kiosk.lv4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 사용자에게 실제로 메뉴를 보여주고 메뉴 번호를 입출력 받는 클래스
 */
public class Kiosk {

    // 속성
    private final List<Menu> kioskList;
    private final Scanner sc = new Scanner(System.in);

    // 생성자
    public Kiosk(List<Menu> menuList) {
        this.kioskList = menuList;
    }

    // 기능

    /**
     * 메뉴 선택을 처리하는 메서드
     */
    public void start() {
        // 반복문 시작
        while(true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println();
            System.out.println("[ 메인 메뉴 ]");
            kioskList.get(0).showSeqMenu(0);

            // 숫자 제외 예외처리 메서드
            int mainNum = inputNumException();

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
            System.out.println("[ " + menu.getCategory() + " 메뉴 ]");

            menu.showSeqMenu(1);

            while(true) {
                // 숫자 제외 예외처리 메서드
                int menuNum = inputNumException();

                if(menuNum == 0) {
                    break;
                } else if(menuNum < 0 || menuNum >= kioskList.size()) {
                    System.out.println("없는 메뉴입니다.");
                    continue;
                }
                    MenuItem menuItem = menu.getMenuList().get(menuNum - 1);
                    System.out.println("선택한 메뉴: " + menuItem.getAll());
            }
        }
    }

    /**
     * 숫자 제외 입력 예외처리 기능
     */
    public int inputNumException() {
        int num;
        while(true){ // 숫자만 입력받을때까지 반복
            try { // 숫자가 아닌 값이 들어오면 예외처리
                System.out.print("원하시는 메뉴를 골라주세요: ");
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("메뉴에 있는 숫자로만 입력해주세요.");
                sc.next();// 초기화
            }
        }
        return num;
    }
}
