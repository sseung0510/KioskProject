package com.example.kiosk.lv5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 메뉴 데이터 초기화 클래스
 */
public class MenuData {

    // 속성
    private final List<Menu> menuList;

    // 생성자
    public MenuData() {
        menuList = addData(); // addData 리스트를 menuList에 대입
    }

    // 기능
    /**
     * 데이터 생성 기능
     */
    private List<Menu> addData() {
        List<Menu> menuList = new ArrayList<>();

        Menu burger = new Menu("햄버거"
                , Arrays.asList(
                new MenuItem("쉑쉑버거", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("새우버거", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("치즈버거", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("치킨버거", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"))
        );

        Menu drink = new Menu("음료수"
                , Arrays.asList(
                new MenuItem("콜라", 2.0, "톡 쏘는 콜라"),
                new MenuItem("환타", 2.0, "톡 쏘는 파인애플맛"),
                new MenuItem("사이다", 2.0, "톡 쏘는 사이다"))
        );

        Menu dessert = new Menu("디저트"
                , Arrays.asList(
                new MenuItem("푸딩", 3.5, "아이들이 좋아하는 푸딩"),
                new MenuItem("파르페", 6.0, "바삭바삭 과자와 달달한 아이스크림"),
                new MenuItem("아포카토", 5.0, "커피와 어울리는 달달한 아이스크림"))
        );

        menuList.add(burger);
        menuList.add(drink);
        menuList.add(dessert);

        return menuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
