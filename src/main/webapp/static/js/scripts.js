/*!
* Start Bootstrap - Shop Homepage v5.0.5 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project



let cartButtons = document.getElementsByClassName("add-cart");
let cartSize = 0;

function addToCart(){
    for (let i = 0; i < cartButtons.length; i++) {
        let prodId = cartButtons[i].getAttribute("data-id")
        cartButtons[i].addEventListener('click',getCartSize)
        cartButtons[i].addEventListener('click',countCartItems)
        cartButtons[i].addEventListener('click',() => addCart(prodId))
        console.log(prodId)
    }
}


function countCartItems(){
    let countCart = document.getElementById("count-cart")
    // let cartSize = getCartSize()
    countCart.innerText =''
    countCart.innerText += " " + cartSize;
}

function addCart(prodId){
    fetch("/cart/item", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: `{
   "id": ${prodId}
  }`,
    });
}


function getCartSize(){
    fetch("/cart/size")
        .then(response => response.text())
        .then(data => cartSize = data)
}


addToCart()

