package com.codecool.shop.controller;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.UserDaoMem;
import com.codecool.shop.model.Address;
import com.codecool.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/checkout"})
    public class CheckoutFetch extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UserDao userDataStore = UserDaoMem.getInstance();
            CartDao cartDataStore = CartDaoMem.getInstance();
            userDataStore.add(new User(req.getParameter("first_name"
            ), req.getParameter("last_name"), req.getParameter("phone_number"), req.getParameter("email_address"),
                    new Address(req.getParameter("country"), req.getParameter("address"), req.getParameter("city"),
                            req.getParameter("state"), req.getParameter("zip_code"))));
            //System.out.println(userDataStore.getUser(0).getFirstName());
            resp.sendRedirect("/");
            cartDataStore.emptyCart();
        }

    }
