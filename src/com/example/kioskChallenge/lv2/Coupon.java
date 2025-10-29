package com.example.kioskChallenge.lv2;

import java.util.function.Function;

public enum Coupon {

    NATIONALHERO(price -> price * (1 - 0.1)),
    SOLDIER(price -> price * (1 - 0.05)),
    STUDENT(price -> price * (1 - 0.03)),
    NORMAL(price -> price);

    private final Function<Double, Double> discountFunction;

    Coupon(Function<Double, Double> discountFunction) {
        this.discountFunction = discountFunction;
    }

    public double applyDiscount(double price) {
        return discountFunction.apply(price);
    }
}
