<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSP-Hello World</title>
</head>
<body>
<%@ page import = "pegas.Cart"%>
    <%Cart cart = (Cart)session.getAttribute("cart");%>
    <p>Name<%=cart.getName()%></p>
    <p>Quantity<%=cart.getQuantity()%></p>
</body>
</html>