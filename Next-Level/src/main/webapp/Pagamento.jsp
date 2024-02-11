<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tela de Pagamento</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
      margin: 0;
      background-color: #111; /* Dark background color */
      color: #00ff00; /* Green neon text color */
    }
    .payment-options {
      display: flex;
      justify-content: space-around;
      align-items: center;
      flex-wrap: wrap; /* Permite que os itens quebrem para a próxima linha se o espaço for insuficiente */
      width: 50%;
      margin: 20px;
    }
    .payment-option {
      text-align: center;
      margin-bottom: 20px;
    }
    .payment-option img {
      max-width: 100px;
      max-height: 100px;
      margin-bottom: 10px;
    }
    .payment-button {
      padding: 10px 20px;
      font-size: 16px;
      cursor: pointer;
      background-color: #00ff00; /* Green neon button color */
      color: #111; /* Dark button text color */
      border: none;
      border-radius: 5px;
      margin-top: 10px;
    }
    .payment-input {
      padding: 10px 20px;
      font-size: 16px;
      cursor: pointer;
      background-color: #00ff00; /* Green neon input color */
      color: #111; /* Dark input text color */
      border: none;
      border-radius: 5px;
      margin-top: 10px;
      text-decoration: none; /* Remover sublinhado padrão */
      display: inline-block; /* Garantir que o estilo de bloco não afete o layout */
      text-align: center;
    }
  </style>
</head>
<body>

<div class="payment-options">

  <div class="payment-option">
    <label for="boletoCheckbox">
      <img src="img/imgPagamento/boleto-simbolo-1.png" alt="Ícone Boleto">
      <p>Boleto Bancário</p>
    </label>
    <a href="boleto?cpf=<%=request.getAttribute("id")%>"><input type="button" class="payment-input" value="Gerar Boleto"></a>
  </div>

  <div class="payment-option">
    <label for="cartaoCheckbox">
      <img src="img/imgPagamento/images (1).png" alt="Ícone Cartão">
      <p>Cartão de Crédito</p>
    </label>
    <a href="cart?cpf=<%=request.getAttribute("id")%>"><input type="button" class="payment-input" value="Confirmar Cartão"></a>
  </div>

  <!-- Adicione mais opções de pagamento conforme necessário -->

</div>

</body>
</html>
