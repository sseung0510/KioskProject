package com.example.kioskChallenge.lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니 기능
 */
public class Cart {

    // 속성
    private final List<String> cartMenu = new ArrayList<>(); // 장바구니 메뉴
    private final List<Double> cartPrice = new ArrayList<>(); // 장바구니 가격
    private final List<Integer> cartCount = new ArrayList<>(); // 물건 개수


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
            System.out.println(cartMenu.get(i) + "\t" + cartPrice.get(i) + "\t" + cartCount.get(i));
        }
    }
}
