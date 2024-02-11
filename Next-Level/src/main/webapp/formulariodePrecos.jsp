<%@page import="MODEL.Cursos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%ArrayList<Cursos> listar = (ArrayList<Cursos>) request.getAttribute("troca"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formul�rio de Altera��o de Cursos e Pre�os</title>
   <link rel="stylesheet" href="css/FormulariodePrecos.css">
</head>
<body>

<h2>Formul�rio de Altera��o de Cursos e Pre�os</h2>

<form action="processar_alteracoes">

    <label for="curso">Selecione o curso:</label>
    <select id="curso" name="escolha" required>
    <%for(int i = 0 ; i<listar.size() ; i++){%>
        <option value="<%=listar.get(i).id()%>"><%=listar.get(i).getNomeCurso()+" - R$: "+listar.get(i).getValor() %></option>
        <%}%>
    </select>

    <br>

    <label for="novo_preco">Novo pre�o:</label>
    <input type="text" id="novo_preco" name="novo_preco" placeholder="Digite o novo pre�o" required>

    <br>

    <input type="submit" value="Alterar">
</form>

</body>
</html>
