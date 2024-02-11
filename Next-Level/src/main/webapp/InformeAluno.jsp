<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dados do Aluno</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
         button {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h2>Dados do Aluno</h2>
<a href="main3"><button>Retornar</button></a>
<table>
    <tr>
        <th>Propriedades</th>
        <th>Informações</th>
    </tr>
    <tr>
        <td>ID</td>
        <td id="alunoId" readonly><%out.print(request.getAttribute("id"));%></td>
    </tr>
    <tr>
        <td>Nome</td>
        <td id="alunoNome"><%out.print(request.getAttribute("nome"));%></td>
    </tr>

    <tr>
       
    <tr>
        <td>Data de Nacnimento</td>
        <td id="alunoCurso"><%out.print(request.getAttribute("data"));%></td>
    </tr>
    <tr>
        <td>Cpf</td>
        <td id="alunoCurso"><%out.print(request.getAttribute("cpf"));%></td>
    </tr>
    <tr>
        <td>Cep</td>
        <td id="alunoCurso"><%out.print(request.getAttribute("cep"));%></td>
    </tr>
    
</table>



</body>
</html>
