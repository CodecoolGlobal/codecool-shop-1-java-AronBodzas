package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDaoMem implements CartDao {
    private List<Product> cart = new ArrayList<>();
    private static CartDaoMem instance = null;

    @Override
    public void add(Product product) {
        cart.add(product);
    }

    @Override
    public List<Product> getAll() {
        return cart;
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }
}
