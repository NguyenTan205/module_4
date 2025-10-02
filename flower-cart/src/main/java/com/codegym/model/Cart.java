package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) { // check xem sp có trong giỏ hàng chưa
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product) { // thêm sp vào giỏ hàng
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                if (entry.getKey().getId().equals(product.getId())) {
                    Integer newQuantity = entry.getValue() + 1;
                    products.replace(entry.getKey(), newQuantity);
                    break;
                }
            }
        }
    }

    public Integer countProductQuantity() { // đếm tổng số lượng sp trong giỏ hàng
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() { // đếm tổng số mặt hàng trong giỏ hàng
        return products.size();
    }

    public Float countTotalPayment() { // tính tổng tiền phải thanh toán
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}