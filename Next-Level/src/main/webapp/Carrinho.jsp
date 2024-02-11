
<%@page import="java.util.ArrayList"%>
<%@page import="MODEL.Cursos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Carrinho de Compras</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    header {
      background-color: #333;
      color: #fff;
      text-align: center;
      padding: 1em;
    }

    .cart-container {
      max-width: 800px;
      margin: 20px auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .product-item {
      display: flex;
      margin-bottom: 20px;
      border-bottom: 1px solid #ddd;
      padding-bottom: 10px;
    }

    .product-image {
      max-width: 100px;
      margin-right: 20px;
    }

    .product-details {
      flex-grow: 1;
    }

    .product-name {
      font-size: 18px;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .total-price {
      margin-top: 20px;
      font-size: 20px;
      font-weight: bold;
    }

    .customer-info {
      margin-top: 20px;
    }

    footer {
      background-color: #333;
      color: #fff;
      text-align: center;
      padding: 1em;
      position: fixed;
      bottom: 0;
      width: 100%;
    }

    .checkout-button {
      margin-top: 20px;
      background-color: #4caf50;
      color: #fff;
      padding: 10px 20px;
      font-size: 16px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .checkout-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

 
<!--     <h1>Carrinho de Compras</h1> -->
  <div class="cart-container">


    <div class="product-item">
     
      <div class="product-details">
        <div class="product-name"><%out.print(request.getAttribute("curso")); %></div>
        <div></div> 
      </div>
      
      <div class="product-price"><%out.print(request.getAttribute("valor")); %>
      
     
      </div>
     
    </div>
      
    <div class="customer-info">
      <h2>Informações do Cliente</h2>
      <p>Nome:<%out.print(request.getAttribute("nome"));%></p>
      <p>CPF:<%out.print(request.getAttribute("cpf"));%></p>
      <p>CEP:<%out.print(request.getAttribute("cep"));%></p>
       <p>Rua:<%out.print(request.getAttribute("rua"));%></p>
       <p>Bairro:<%out.print(request.getAttribute("bairro"));%></p>
       <p>Numero:<%out.print(request.getAttribute("numero"));%></p>
      <p>Cidade:<%out.print(request.getAttribute("cidade"));%></p>
      <p>Estado:<%out.print(request.getAttribute("estado"));%></p>
      
     
      
      
      
     
    </div>

    <div class="total-price">
      <h2>Total:  <%out.print(request.getAttribute("valor"));%></h2>
    </div>

    <a href="linkar?id=<%=request.getAttribute("cpf")%>"><button class="checkout-button">Confirmar Curso</button></a>

  </div>

  

</body>
</html>
