package com.example.kioskChallenge.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 장바구니 기능
 */
public class Cart {

    // 속성
    private List<String> cartMenu = new ArrayList<>(); // 장바구니 메뉴
    private List<Double> cartPrice = new ArrayList<>(); // 장바구니 가격
    private List<Integer> cartCount = new ArrayList<>(); // 물건 개수


    // 기능
    public List<Double> getCartPrice() {
        return cartPrice;
    }

    public List<Integer> getCartCount(){
        return cartCount;
    }

    /**
     * 장바구니에 추가 기능
     */
    public void addCart(String menuItem, double price, int count) {
        cartMenu.add(menuItem);
        cartPrice.add(price);
        cartCount.add(count);
    }

    /**
     * 장바구니 비우기
     */
    public void clearCart() {
        cartMenu.clear();
        cartPrice.clear();
        cartCount.clear();
    }

    /**
     * 장바구니가 비었는지 확인 기능
     */
    public boolean isCartEmpty() {
        return cartMenu.isEmpty();
    }

    /**
     * 장바구니 출력하는 기능
     */
    public void printCart() {
        for(int i = 0; i < cartMenu.size(); i++) {
            System.out.println((i + 1) + ". " + cartMenu.get(i) + "  \t" + "| " + cartCount.get(i) + "개");
        }
    }

    /**
     * 장바구니에서 특정 메뉴 빼기 기능
     */
    public void deleteMenu(int menuItem) {

        cartMenu = IntStream.range(0, cartMenu.size())
                .filter(i -> i != menuItem-1)
                .mapToObj(cartMenu::get)
                .collect(Collectors.toList());

        cartPrice = IntStream.range(0, cartPrice.size())
                .filter(i -> i != menuItem-1)
                .mapToObj(cartPrice::get)
                .collect(Collectors.toList());

        cartCount = IntStream.range(0, cartCount.size())
                .filter(i -> i != menuItem-1)
                .mapToObj(cartCount::get)
                .collect(Collectors.toList());
    }

}
