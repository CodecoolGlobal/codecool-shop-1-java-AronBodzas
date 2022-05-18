



function setCartQty(prodId, plusMinus){
    fetch("/cart/change", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: `{
   "id": ${prodId},
   "plusMinus": ${plusMinus}
  }`,
    });
}