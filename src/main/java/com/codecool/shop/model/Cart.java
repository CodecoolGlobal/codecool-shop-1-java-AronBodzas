package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product product){ cart.add(product); }

    public int size(){return cart.size();}

    public Product get(int index){return cart.get(index);}
}
