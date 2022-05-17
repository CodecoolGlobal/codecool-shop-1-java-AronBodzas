/*!
* Start Bootstrap - Shop Homepage v5.0.5 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

// $('#playButton').click(function () {
//     $('#homeCarousel').carousel('cycle');
// });
// $('#pauseButton').click(function () {
//     $('#homeCarousel').carousel('pause');
// });


let cartList = [];
let countCart = document.getElementById("count-cart")

function addToCart(){
    let cartButtons = document.getElementsByClassName("add-cart");
    for (let i = 0; i < cartButtons.length; i++) {
        let prodId = cartButtons[i].getAttribute("data-id")
        cartButtons[i].addEventListener('click',()=>cartList.push(prodId))
        cartButtons[i].addEventListener('click',countCartItems)
    }
}


function countCartItems(){
    countCart.innerText =''
    countCart.innerText += " " + cartList.length
}


addToCart()

