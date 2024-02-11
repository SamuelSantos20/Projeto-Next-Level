<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Alteração</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        form {
            width: 50%;
            margin: 20px auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            padding: 10px;
        }
    </style>
</head>
<body>

    <form id="alterarForm" action="main4">
        <label for="id">ID:</label>
        <input type="text" value="<%out.print(request.getAttribute("id")); %>" id="id" name="id" readonly>

        <label for="nome">Nome:</label>
        <input type="text" value="<%out.print(request.getAttribute("nome")); %>" id="nome" name="nome">

        <label for="telefone">Data de Nascimento:</label>
        <input type="date" value="<%out.print(request.getAttribute("data")); %>" id="telefone" name="data">

        <label for="cpf">CEP:</label>
        <input type="text" value="<%out.print(request.getAttribute("cep")); %>" id="cpf" name="cep">

        <label for="genero">Gênero:</label>
        <select id="genero" name="genero">
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
            <option value="outro">Outro</option>
        </select>

        <button type="submit">Alterar Dados</button>
    </form>

</body>
</html>
