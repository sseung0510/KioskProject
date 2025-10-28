package com.example.kioskChallenge.lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 사용자에게 실제로 메뉴를 보여주고 메뉴 번호를 입출력 받는 클래스
 */
public class Kiosk {

    // 속성
    private final List<Menu> menuList;
    private final Scanner sc = new Scanner(System.in);
    private final Cart cart = new Cart();

    // 생성자
    public Kiosk(List<Menu> menuItemList) {
        this.menuList = menuItemList;
    }

    // 기능
    /**
     * 메뉴 선택을 처리하는 메서드
     */
    public void start() {
        // 반복문 시작
        FIRST:
        while(true) {
            showMenuList(); // 메뉴 조회 메서드

            int menuNum = inputNumException("메뉴판의 번호만 선택해주세요: "); // 숫자 제외 예외처리 메서드

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            if(menuNum == 0) { // 종료
                break; // 상위 반복문 탈출
            } else if((menuNum == 4 || menuNum == 5) && cart.isCartEmpty()) {
                System.out.println("없는 메뉴입니다.");
                continue;
            } else if(menuNum == 4) {
                orderMenu();
                continue;
            } else if(menuNum == 5) {
                cart.clearCart();
                continue;
            } else if (menuNum < 1 || menuNum > menuList.size()) {
                System.out.println("없는 메뉴입니다.");
                continue;
            }

            // List<Menu>에 인덱스로 접근하면 Menu만 추출
            Menu menu = menuList.get(menuNum - 1);
            System.out.println("\n[ " + menu.getCategory() + " 메뉴 ]");
            menu.showMenuItemList();

            while(true) {
                // 숫자 제외 예외처리 메서드
                int menuItemNum = inputNumException("메뉴판의 번호만 선택해주세요: ");

                if(menuItemNum == 0) {
                    break;
                } else if(menuItemNum < 1 || menuItemNum > menu.getMenuList().size()) {
                    System.out.println("없는 메뉴입니다.");
                    continue;
                }
                MenuItem menuItem = menu.getMenuList().get(menuItemNum - 1);
                System.out.println("선택한 메뉴: " + menuItem.getAll());

                int menuCount = inputNumException("수량 선택: ");

                if(menuCount <= 0) {
                    System.out.println("1개 이상부터 주문이 가능합니다.");
                    continue;
                }

                System.out.println();
                System.out.println('"' + menuItem.getAll() + '"' + "\t" + menuCount + "개 \n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인    |    2. 취소");
                int choiceNum = sc.nextInt();
                if(choiceNum == 1) {
                    cart.addCart(menuItem.getAll(), menuItem.getPrice(), menuCount);
                    System.out.println(menuItem.getName() + "(이)가 장바구니에 추가되었습니다.");
                    continue FIRST;
                } else if(choiceNum == 2) {
                    break;
                } else {
                    System.out.println("없는 선택지입니다.");
                }
            }
        }
    }

    /**
     * 메뉴 주문 기능
     */
    private void orderMenu() {
        double totalPay = 0;

        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ 주문 ]");
        cart.printCart();

        for(int i = 0; i < cart.getCartPrice().size(); i++) {
            totalPay += cart.getCartPrice().get(i) * cart.getCartCount().get(i);
        }

        System.out.println("\n[ 총 ]");
        System.out.println("w " + totalPay);

        System.out.println("\n1. 주문    |    2. 메뉴판");
        int choiceNum = inputNumException("해당 번호만 선택해주세요: ");

        if(choiceNum == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 w" + totalPay + "입니다.");
            cart.clearCart();
        } else if(choiceNum == 2) {
            System.out.println();
        } else {
            System.out.println("없는 선택지입니다.");
        }
    }

    /**
     * 메뉴 리스트 조회 기능(cart에 값이 있으면 ORDER MENU 노출)
     */
    public void showMenuList(){
        System.out.println("\n[ 메인 메뉴 ]");
        for(int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
        }
        System.out.println("0. 종료    | 종료");
        if(!cart.isCartEmpty()) {
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    /**
     * 숫자 제외 입력 예외처리 기능
     */
    public int inputNumException(String message) {
        int num;
        while(true){ // 숫자만 입력받을때까지 반복
            try { // 숫자가 아닌 값이 들어오면 예외처리
                System.out.print(message);
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