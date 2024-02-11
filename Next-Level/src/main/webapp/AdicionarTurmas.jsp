<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Turma</title>
   <style type="text/css">
   body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 500px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

h2 {
    text-align: center;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    font-weight: bold;
}

input[type="text"],
select,
input[type="date"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
}

button:hover {
    background-color: #45a049;
}
   
   
   
   </style>
</head>
<body>
    <div class="container">
        <h2>Adicionar Turma</h2>
        <form action="addTurma" >
            <div class="form-group">
                <label for="sala">Sala:</label>
                <input type="text" id="sala" name="sala" required>
            </div>
            <div class="form-group">
                <label for="turno">Turno:</label>
                <select id="turno" name="turno" required>
                    <option value="">Selecione o turno</option>
                    <option value="manhã">Manha</option>
                    <option value="tarde">Tarde</option>
                    <option value="noite">Noite</option>
                </select>
            </div>
            <div class="form-group">
                <label for="dataInicio">Data de Início:</label>
                <input type="date" id="dataInicio" name="dataInicio" required>
            </div>
            <div class="form-group">
                <label for="dataFim">Data de Fim:</label>
                <input type="date" id="dataFim" name="dataFim" required>
            </div>
            <button type="submit">Adicionar Turma</button>
        </form>
    </div>
</body>
</html>
