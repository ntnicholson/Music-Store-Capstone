function hideShoppingCart(role) 
{
	alert("I am an alert box!");
  var x = document.getElementById("ShoppingCart");

  if (role == "ROLE_ADMIN") {
    x.style.visibility = "hidden";
alert("admin");
  } else {
    x.style.display = "none";
  }
}
