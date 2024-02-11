<%@page import="Ultilitarios.FormatadordeDinheiro"%>
<%@page import="Ultilitarios.FormatadordeData"%>
<%@page import="Ultilitarios.ViwerDiciplinasCurso"%>
<%@page import="Ultilitarios.ViwerMatriculados"%>
<%@page import="MODEL.matricula"%>
<%@page import="MODEL.Turma"%>
<%@page import="MODEL.Aluno"%>
<%@page import="MODEL.Diciplinas"%>
<%@page import="MODEL.Pagamentos"%>
<%@page import="MODEL.Cursos"%>
<%@page import="MODEL.cartao"%>
<%@page import="MODEL.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Aluno> lista = (ArrayList<Aluno>) request.getAttribute("alunos");

ArrayList<JavaBeans> listar = (ArrayList<JavaBeans>) request.getAttribute("dados");

ArrayList<cartao> listcarte = (ArrayList<cartao>) request.getAttribute("cartao");

ArrayList<Cursos> listarCursos = (ArrayList<Cursos>) request.getAttribute("cursos");

ArrayList<Pagamentos> listarpagamentos = (ArrayList<Pagamentos>) request.getAttribute("pagamentos");

ArrayList<Turma> listarTurmas = (ArrayList<Turma>) request.getAttribute("turmas");

ArrayList<ViwerDiciplinasCurso> listardiciplinas = (ArrayList<ViwerDiciplinasCurso>) request.getAttribute("diciplinas");

ArrayList<ViwerMatriculados> listarmatriculas = (ArrayList<ViwerMatriculados>) request.getAttribute("matriculas");
FormatadordeDinheiro format = new FormatadordeDinheiro();
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tabela de Dados</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
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
	margin-right: 10px;
	padding: 10px;
}
/* Estilizando o botão verde */
.green-button {
	background-color: #4CAF50; /* Cor de fundo verde */
	color: white; /* Cor do texto branco */
	padding: 10px 10px; /* Espaçamento interno */
	text-align: center; /* Alinhamento do texto */
	text-decoration: none; /* Removendo sublinhado padrão */
	display: inline-block; /* Tornando um elemento de linha */
	font-size: 16px; /* Tamanho da fonte */
	margin: 4px 2px; /* Margem externa */
	cursor: pointer; /* Cursor do mouse */
	border-radius: 10px; /* Borda arredondada */
}

.search-container {
	text-align: center;
}

.search-box {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 200px;
}

.search-button {
	padding: 10px;
	background-color: #4caf50;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>

</head>
<body>

	<div>
		<button onclick="mostrarTabela('tabela1')">Tabela Alunos</button>
		<button onclick="mostrarTabela('tabela2')">Tabela logins</button>
		<button onclick="mostrarTabela('tabela4')">Tabela cartões</button>
		<button onclick="mostrarTabela('tabela3')">Tabela compras</button>
		<button onclick="mostrarTabela('tabela5')">Tabela Cursos</button>
		<button onclick="mostrarTabela('tabela6')">Tabela Diciplinas</button>
		<button onclick="mostrarTabela('tabela7')">Tabela Turmas</button>
		<button onclick="mostrarTabela('tabela8')">Tabela matriculados</button>


	</div>

	<table id="tabela1">
		<thead>


			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>CEP</th>
				<th>Gênero</th>
				<th>Status</th>
				<th>
					<form action="alunopesquisa" class="search-container">

						<input type="text" autocomplete="off" class="search-box"
							placeholder="Informe o CPF..." name="pesquisa">
						<button type="submit" class="search-button">Pesquisar</button>


					</form>
				</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<td><%=lista.get(i).id()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getCep()%></td>
				<td><%=lista.get(i).getGenero()%></td>
				<td><%=lista.get(i).getStatusaluno()%></td>



				<td><a href="select?id=<%=lista.get(i).id()%>">
						<button type="button" class="btn btn-primary">Editar</button>
				</a></td>

				<td><a href="Ativar?id=<%=lista.get(i).id()%>"><button
							class="green-button">Ativar</button></a></td>
				<td><a href="Inativar?id=<%=lista.get(i).id()%>"><button
							type="button" class="btn btn-danger">Inativar</button></a></td>

				<td><a href="relatorio"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>



			</tr>
			<%
			}
			%>

		</tbody>
	</table>

	<table id="tabela2">
		<thead>


			<tr>
				<th>ID</th>
				<th>E-MAIL</th>
				<th>SENHA</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<%
				for (int i = 0; i < listar.size(); i++) {
				%>
				<td><%=listar.get(i).id()%></td>
				<td><%=listar.get(i).getEmail()%></td>
				<td><%=listar.get(i).getsenha()%></td>



			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<table id="tabela4">
		<thead>
			<tr>
				<th>id</th>
				<th>Numero cartão</th>
				<th>Nome cartão</th>
				<th>Data de Vencimento</th>
				<th>CVC</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<%
				for (int i = 0; i < listcarte.size(); i++) {
				%>
				<td><%=listcarte.get(i).id()%></td>
				<td><%=listcarte.get(i).getNumerocartao()%></td>
				<td><%=listcarte.get(i).getNomecartao()%></td>
				<td><%=listcarte.get(i).getMesdeVencimnto() + "/" + listcarte.get(i).getAnoVencimento()%></td>
				<td><%=listcarte.get(i).getCvc()%></td>

				<td><a href="relatorioCartao"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<table id="tabela5">
		<thead>
			<tr>
				<th>id</th>
				<th>Cursos Disponiblizados</th>
				<th>Valores</th>


			</tr>
		</thead>
		<tbody>

			<tr>
				<%
				for (int i = 0; i < listarCursos.size(); i++) {
				%>
				<td><%=listarCursos.get(i).id()%></td>
				<td><%=listarCursos.get(i).getNomeCurso()%></td>
				<td><%=format.formatarComoMoeda(listarCursos.get(i).getValor())%></td>


				<td><a href="AddCurso.jsp"><button class="green-button">Novo
							Curso</button></a></td>
				<td><a href="redirect"><button type="button"
							class="btn btn-primary">Alterar valor</button></a></td>
				<td><a href="relatorioCurso"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<table id="tabela3">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Curso</th>
				<th>Valor</th>
				<th>Data da Compra</th>
				<th>Status da Compra</th>
				<th>Metodo de Pagamento</th> 


			</tr>
		</thead>
		<tbody>

			<tr>
				<%
				for (int i = 0; i < listarpagamentos.size(); i++) {
				%>
				<td><%=listarpagamentos.get(i).getId()%></td>
				<td><%=listarpagamentos.get(i).getNome()%></td>
				<td><%=listarpagamentos.get(i).getCpf()%></td>
				<td><%=listarpagamentos.get(i).getCurso()%></td>
				<td><%=format.formatarComoMoeda(listarpagamentos.get(i).getValor())%></td>
				<td><%=listarpagamentos.get(i).getDatacompra()%></td>
				<td><%=listarpagamentos.get(i).getStatusdacompra()%></td>
				<td><%=listarpagamentos.get(i).getMetodopagamentos()%></td> 






				<td><a href="confirme?id=<%=listarpagamentos.get(i).getId()%>"><button
							class="green-button">ConfirmarPagamento</button></a></td>
				<td><a href="relatorioPagamentos"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>
				<td><a
					href="Excluirpagamento?id=<%=listarpagamentos.get(i).getId()%>"><button
							type="button" class="btn btn-danger">DeleteNaoCompra</button></a></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>


	<table id="tabela6">
		<thead>
			<tr>
				<th>Curso</th>
				<th>Diciplina</th>

			</tr>
		</thead>
		<tbody>

			<tr>
				<%
				for (int i = 0; i < listardiciplinas.size(); i++) {
				%>
				<td><%=listardiciplinas.get(i).getCurso()%></td>
				<td><%=listardiciplinas.get(i).getDciplinas()%></td>

<td><a href="relatorioDiciplinas"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>

</tr>
				<%
				}
				%>
			
		</tbody>
	</table>
	<table id="tabela7">
		<thead>
			<tr>
				<th>ID</th>
				<th>Sala</th>
				<th>Turno</th>
				<th>Data de Inicio</th>
				<th>Data de Termino</th>


			</tr>
		</thead>
		<tbody>

			<tr>
				<%
				for (int i = 0; i < listarTurmas.size(); i++) {
				%>
				<td><%=listarTurmas.get(i).getId()%></td>
				<td><%=listarTurmas.get(i).getSala()%></td>
				<td><%=listarTurmas.get(i).getTurno()%></td>
				<td><%=listarTurmas.get(i).getData_inicio()%></td>
				<td><%=listarTurmas.get(i).getData_fim()%></td>

				<td><a href="AdicionarTurmas.jsp"><button class="green-button">Nova Turma</button></a></td>				
<td><a href="relatorioTurmas"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>
</tr>
				<%
				}
				%>
			
		</tbody>
	</table>

	<table id="tabela8">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Curso</th>
				<th>Sala</th>

			</tr>
		</thead>
		<tbody>

			<tr>
				<%
				for (int i = 0; i < listarmatriculas.size(); i++) {
				%>
				<td><%=listarmatriculas.get(i).getNome()%></td>
				<td><%=listarmatriculas.get(i).getCurso()%></td>
				<td><%=listarmatriculas.get(i).getSala()%></td>

<td><a href="relatoriomatriculados"><button type="button"
							class="btn btn-danger">Relatorio</button></a></td>
</tr>
				<%
				}
				%>
			
		</tbody>
	</table>



	<!-- Adicione tabelas adicionais conforme necessário -->

	<script>
        function mostrarTabela(tabelaId) {
            // Oculta todas as tabelas
            const tabelas = document.querySelectorAll('table');
            tabelas.forEach(tabela => {
                tabela.style.display = 'none';
            });

            // Exibe a tabela desejada
            document.getElementById(tabelaId).style.display = 'table';
        }
    </script>
</body>
</html>
