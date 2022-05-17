package com.codecool.shop.model;

import java.util.List;

public class Cart {
    private List<Product> cart;

    public Cart(List<Product> cart) {
        this.cart = cart;
    }

    private void addToCart(Product product){ cart.add(product); }
}
