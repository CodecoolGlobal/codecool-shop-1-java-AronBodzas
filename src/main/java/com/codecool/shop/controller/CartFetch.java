package com.codecool.shop.controller;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/cart/item"})
public class CartFetch extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productDetails = req.getReader().lines().collect(Collectors.joining());
        JsonObject jsonObject = new JsonParser().parse(productDetails).getAsJsonObject();
        String id = jsonObject.get("id").toString();
        System.out.println(id);

        ProductDao productDataStore = ProductDaoMem.getInstance();
        CartDao cartDataStore = CartDaoMem.getInstance();

        cartDataStore.add(productDataStore.find(1));

//        System.out.println(cartDataStore.getAll());
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Setting respone content type
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        // Asking for query parameter
//        String product = req.getParameter("product");
//        URL url;
//        // Checking if there was any query parameter
//
////        url = new URL();
//
//        // Setting up connection with the hacker api
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        // getting the input Buffer from the connection
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        // Adding the lines to the string builder to build the json response as a string
//        StringBuilder content = new StringBuilder();
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
//        }
//        in.close();
//}
}
