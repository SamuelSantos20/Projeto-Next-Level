package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jrimum.bopepo.view.BoletoViewer;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import CONEXÃO.DAO;
import CRUD.CRUDLOGIN;
import CRUD.CRUDMATRICULAS;
import CRUD.CRUDCARTAO;
import CRUD.CRUDCOMPRAS;
import CRUD.CRUDCURSOS;
import CRUD.CRUDDICIPLINAS;
import CRUD.CRUDALUNO;
import CRUD.CRUDTURMAS;
import MODEL.Aluno;
import MODEL.Cursos;
import MODEL.Diciplinas;
import MODEL.Funcionario;
import MODEL.JavaBeans;
import MODEL.Pagamentos;
import MODEL.Turma;

import MODEL.cartao;
import Ultilitarios.FormatadordeData;
import Ultilitarios.Geradordematricula;
import Ultilitarios.ViwerDiciplinasCurso;
import Ultilitarios.ViwerMatriculados;

//AQUI SÃO COLCADOS OS LINKS DOS BOSTÕES. O SERVELT VAI O REDIRECIONAMENTO PARA AS PAGINAS/ EXISTE ALGUNS PEQUENOS ADENDOS JÁ QUE ELE TAMBÉM PODE RECEBER DADOS DE OUTRO LUGAR POR EXEMPLO DOS FORMULARIO O "/INSERT" TRAZ A OS DADOS DA CAMADA QUE CRIA UMA NOVA SENHA. O URL... É OBRIGATORIO PARA O FUNCIONAMENTO. OUTRA COISA IMPORTANTE É NÃO ESQUECER DAS  {}  

@WebServlet(urlPatterns = { "/controller", "/new", "/matricula", "/main3", "/select", "/main4", "/Ativar", "/entrar",
		"/relatorio", "/boleto", "/cartao", "/relatorioCartao", "/matricularCurso", "/envio", "/levar", "/linkar",
		"/Inativar", "/redirect", "/inserir", "/processar_alteracoes", "/relatorioCurso", "/confirme", "/atiavar",
		"/cart", "/relatorioPagamentos", "/alunopesquisa", "/Excluirpagamento" , "/relatorioDiciplinas" , "/relatorioTurmas","/relatoriomatriculados","/addTurma" })

public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// AQUI CRIA UMA EXTENSÃO DA CLASSE DAO
	DAO conexao = new DAO();
	JavaBeans valores = new JavaBeans();
	CRUDLOGIN Crud = new CRUDLOGIN();
	CRUDALUNO matricula = new CRUDALUNO();
	Aluno matriculasalunos = new Aluno();
	Funcionario func = new Funcionario();
	cartao cart = new cartao();
	CRUDCARTAO cartao = new CRUDCARTAO();
	Cursos curso = new Cursos();
	CRUDCURSOS cur = new CRUDCURSOS();
	Pagamentos pag = new Pagamentos();
	CRUDCOMPRAS compra = new CRUDCOMPRAS();
	CRUDDICIPLINAS dici = new CRUDDICIPLINAS();
	FormatadordeData dataformat = new FormatadordeData();
	Geradordematricula geradormat = new Geradordematricula();
	CRUDTURMAS turma = new CRUDTURMAS();
	Turma turmas = new Turma();
	MODEL.matricula Matricula = new MODEL.matricula();
	CRUDMATRICULAS matriculas = new CRUDMATRICULAS();
	Diciplinas Dici = new Diciplinas();

	public controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ESSA INSTACIA ARMAZENA AS REQUIZIÇÕES DO SERVLET ="/CONTROLLER" , "/MAIN"...
		// TODAS AS REQUZIÇÕES . O GETSERVLETPATH É EXTREMAMENTE IMPORTANTE PARA ISSO.
		String action = request.getServletPath();

		// VAI IMPRIMIR AS REQUIZIÇÕES ="/controller" "/main"...
		System.out.println(action);

		// ESSE PEDAÇO SIGNIFICA QUE ELE VAI ANALISAR QUAL É A REQUIZIÇÃO , E A RESPOSTA
		// VAI SER DE ACORDO COM O METODO

		// A REALIZAÇÃO DE UM NOVO CADASTRO

		// FAZ A REALIZAÇÃO DE UMA NOVA MATRICULA
		if (action.equals("/matricula")) {

			response.sendRedirect("envio");
			NovaMatricula(request, response);

		}

		// REALIZAÇÃO DE UMA NOVA MATRICULA
		else if (action.equals("/matricularCurso")) {
			NovaMatricula(request, response);
			response.sendRedirect("levar");
		}

		// ENVIA OS DADOS DO CLIENTE PARA O CARRINHO
		else if (action.equals("/levar")) {

			Carrinho(request, response);
			response.sendRedirect("Carrinho.jsp");
		}

		// ENVIAR OS DADOS PARA A PAGINA DA TABELA
		else if (action.equals("/main3")) {
			ListarDados(request, response);

		}

		// ATUALIZAR OS DADOS DE ALGUM ALUNO
		else if (action.equals("/main4")) {

			Updadte(request, response);

		}
		// ATIVAR ALGUM ALUNO
		else if (action.equals("/Ativar")) {

			Ativacao(request, response);

		}

		// INITATIVAR ALGUM ALUNO
		else if (action.equals("/Inativar")) {

			Initivacao(request, response);
		}

		// EDITAR ALGUMA MATRICULA
		else if (action.equals("/select")) {
			EditarMatricula(request, response);

		}

		// REALIZAR A VALIDAÇÃO PARA ACESSAR A TABELA OU ENTRAR EM SUA CONTA
		else if (action.equals("/entrar")) {
			Validacao(request, response);

		}

		// GERA UM RELATORIO DA TABELA DE MATRICULAS
		else if (action.equals("/relatorio")) {
			GeraçãodeRelatorio(request, response);

		}

		// GERAR UM RELATORIO DA TABELA DE CARTÕES ADICIONADOS
		else if (action.equals("/relatorioCartao")) {
			RelatorioCartao(request, response);
		}
		// CRIAR O BOLETO
		else if (action.equals("/boleto")) {
			Boleto(request, response);
			response.sendRedirect("/atiavar");

		}

		// REALIZAR UM PAGAMENTO COM O CARTÃO
		else if (action.equals("/cartao")) {
			Cartão(request, response);

		}
		// ENVIAR OS CURSOS PARA A PAGINA DE ESCOLHA
		else if (action.equals("/envio")) {
			AddListaCursos(request, response);
			response.sendRedirect("SistemaCursos.jsp");
		}

		// PAGINA COM AS OPÇÕES DE PAGAMENTO
		else if (action.equals("/linkar")) {
			RedirecinamentoPagamento(request, response);
			response.sendRedirect("Pagamento.jsp");
		}

		// ADICIONAR UM CURSOE O SEU VALOR
		else if (action.equals("/inserir")) {

			AddCurso(request, response);
		}

		// ALTERAR O VALOR DO CURSO
		else if (action.equals("/redirect")) {

			AlterarValor(request, response);
		}

		// ATUALIZAR OS PREÇOS
		else if (action.equals("/processar_alteracoes")) {

			AtualizarPreco(request, response);
		}
		// GERAR UM RELATORIO DOS CURSOS
		else if (action.equals("/relatorioCurso")) {

			RelatorioCurso(request, response);
		}
		// CONFIRMAÇÃO DE PAGAMENTO
		else if (action.equals("/confirme")) {

			ConfirmacaodePagamento(request, response);
		} else if (action.equals("/Excluirpagamento")) {

			Excluircomprasnaoefetuadas(request, response);
		}

		else if (action.equals("/cart")) {

			Redirecinamencartao(request, response);
		}

		else if (action.equals("/relatorioPagamentos")) {

			RelatorioPagmentos(request, response);
		} else if (action.equals("/alunopesquisa")) {

			PesquisarDados(request, response);
		}
	  else if (action.equals("/relatorioDiciplinas")) {
		
		RelatorioDeDiciplinas(request, response);
	}
	  else if (action.equals("/relatorioTurmas")) {
		  
		  RelatorioDeTurmas(request, response);
	  }
	  else if (action.equals("/relatoriomatriculados")) {
		  
		  RelatorioDeMatriculados(request, response);
	  }
	  else if (action.equals("/addTurma")) {
		  
		  NovaTurma(request, response);
	  }

		// RETORNAR PARA PAGINA INICIAL
		else {
			response.sendRedirect("index2.jsp");
		}

		// TESTE DE CONEXÃO
		conexao.testedeconexao();

	}

//REQUEST TRATA DAS REQUISIÇÕES QUE SÃO FEITAS PARA O SERVTLET = OS PEDIDOS QUE SÃO FEITOS

//RESPONSE ENVIA AS RESPOSTAS PARA ESSAS REQUISIÇÕES  = ENVIA AS RESPOSTAS PARA OS PEDIDOS

	/* PARTE DAS REALIZAÇÕES DAS MATRICULAS */

	protected void NovaMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/matricula")) {

			// Teste de recibimento dos dados

			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("cpf"));
			System.out.println(request.getParameter("genero"));
			System.out.println(request.getParameter("cep"));
			System.out.println(request.getParameter("cidade"));
			System.out.println(request.getParameter("estado"));
			System.out.println(request.getParameter("bairro"));
			System.out.println(request.getParameter("rua"));
			System.out.println(request.getParameter("numero"));
			System.out.println(request.getParameter("complemento"));
			System.out.println(request.getParameter("cidade"));
			System.out.println(request.getParameter("data"));
			System.out.println(request.getParameter("rg"));

			matriculasalunos.setNome((request.getParameter("nome")));
			matriculasalunos.setCpf(request.getParameter("cpf"));
			matriculasalunos.setGenero(request.getParameter("genero"));
			matriculasalunos.setCep(request.getParameter("cep"));
			matriculasalunos.setCidade(request.getParameter("cidade"));
			matriculasalunos.setEstado(request.getParameter("estado"));
			matriculasalunos.setBairro(request.getParameter("bairro"));
			matriculasalunos.setRua(request.getParameter("rua"));
			matriculasalunos.setNumero(request.getParameter("numero"));
			matriculasalunos.setComplemento(request.getParameter("complemento"));
			matriculasalunos.setCidade(request.getParameter("cidade"));
			matriculasalunos.setDatadeNacimento(request.getParameter("data"));
			matriculasalunos.setRg(request.getParameter("rg"));
			matriculasalunos.setSenha(request.getParameter("senha"));
			matriculasalunos.setTelefone(request.getParameter("telefone"));

			// ESSE METODO FUNCIONA DA MESMA MANEIRA DO METODO ACIMA

			// AQUI VAI SER FEITO UM TESTE PARA SABER SE OS PEDIDOS ESTÃO CHEGANDO PARA O
			// SERVTLET
			System.out.println(request.getParameter("email"));
			System.out.println(request.getParameter("senha"));

			// AQUI ELE VAI ENVIAR PRA CLASSE JAVABEANS AS SENHAS QUE FORAM ENVIADAS PARA O
			// FORMULARIO
			valores.setEmail(request.getParameter("email"));
			valores.setsenha(request.getParameter("senha"));

			// AGORA VAI SER PASSADO OS DADOS DO OBJETO CONTATOS PARA PARA O METODO DA
			// CLASSE DAO QUE ACABOU DE SER CRIADO

			Crud.Inserirdados(valores);
		}

		// AQUI APÓS O METODO SER ACIONADO ELE VAI REDIRECIONAR PARA CLASSE (MAIN) QUE
		// VAI ACIONAR E ENVIAR PARA O DOCUMENTO (CADASTRO.JSP).

		if (action.equals("/matricularCurso")) {

			System.out.println(request.getParameter("curso"));
			System.out.println(request.getParameter("turma"));

			String cursos = request.getParameter("curso");
			String Turma = request.getParameter("turma");

			cursos = cursos.trim();
			Turma = Turma.trim();
			Matricula.setId_Curso(Integer.parseInt(cursos));
			Matricula.setId_Turma(Integer.parseInt(Turma));

			turma.Requestdados(turmas);

			matriculas.inserirdados(Matricula);

			curso.id(cursos);

			cur.RequestCurso(curso);

		}

		if (action.equals("/matricularCurso")) {
			matricula.inseriCadastros(matriculasalunos);
		}

	}

	protected void ListarDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Aluno> lista = matricula.listagem();

		ArrayList<JavaBeans> listar = Crud.listarCadastros();

		ArrayList<cartao> listcart = cartao.listarcart();

		ArrayList<Cursos> listarcursos = cur.listarCurso();

		ArrayList<Pagamentos> listarpagamnetos = compra.listarCompras();

		ArrayList<ViwerDiciplinasCurso> listarDiciplinas = dici.listardicplinas();

		ArrayList<Turma> listarTurmas = turma.listarTurmas();

		ArrayList<ViwerMatriculados> listarmatriculas = matriculas.listarmatriculados();

		// Envia os dados dos logins
		request.setAttribute("dados", listar);

		// ENVIA PARA O DOCUMENTO JSP
		request.setAttribute("alunos", lista);

		// Envia os dados dos cartoes
		request.setAttribute("cartao", listcart);
		// Envia os Cursos e seus valores
		request.setAttribute("cursos", listarcursos);
		// Envia os pagamentos
		request.setAttribute("pagamentos", listarpagamnetos);

		// Envia as diciplinas de cada curso para a tabela
		request.setAttribute("diciplinas", listarDiciplinas);
		// Envia todas as turmas para a tabela
		request.setAttribute("turmas", listarTurmas);
		// Envia todas as matriculas efetuadas
		request.setAttribute("matriculas", listarmatriculas);
		RequestDispatcher rd = request.getRequestDispatcher("Tabelas.jsp");

		rd.forward(request, response);

		for (int i = 0; i < lista.size(); i++) {

			// TESTE DE RECEBIMENTO DE RECEBIMENTO DOS DADOS

			System.out.println(lista.get(i).id());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getCpf());

		}

		for (int i = 0; i < listar.size(); i++) {

			System.out.println(listar.get(i).id());
			System.out.println(listar.get(i).getEmail());
			System.out.println(listar.get(i).getsenha());

		}
		for (int i = 0; i < listcart.size(); i++) {
			System.out.println(listcart.get(i).getNumerocartao());
			System.out.println(listcart.get(i).getNomecartao());
			System.out.println(listcart.get(i).getMesdeVencimnto());
			System.out.println(listcart.get(i).getAnoVencimento());
			System.out.println(listcart.get(i).getCvc());

		}
		for (int i = 0; i < listarpagamnetos.size(); i++) {
			System.out.println(listarpagamnetos.get(i).getId());
			System.out.println(listarpagamnetos.get(i).getNome());
			System.out.println(listarpagamnetos.get(i).getCpf());
			System.out.println(listarpagamnetos.get(i).getCurso());
			System.out.println(listarpagamnetos.get(i).getValor());
			System.out.println(listarpagamnetos.get(i).getStatusdacompra());
			System.out.println(listarpagamnetos.get(i).getDatacompra());

		}

		for (int i = 0; i < listarDiciplinas.size(); i++) {

			System.out.println(listarDiciplinas.get(i).getCurso());
			System.out.println(listarDiciplinas.get(i).getDciplinas());

		}

	}

	// METODO QUE SERA UILIZADO PARA EDITAR OS CONTATOS

	protected void EditarMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// AQUI É FEITO UM TESTE PARA SABER SE O SERVELET(CLASSE CONTROLLER) ESTÁ
		// RECEBENDO O IDCON DO DOCUMENTO
		// TABELAMATRICULAS.JSP

		String id = request.getParameter("id");
		System.out.println(id);

		// AQUI O ID SERÁ PASSADO PARA A CLASSE MATRICULABEANS
		matriculasalunos.id(id);
		// E AQUI SERÁ SELECIONADO E ENVIADO PARA A CLASSE DO CRUDMATRICULA
		matricula.selection(matriculasalunos);

		// AQUI VAI HAVER UM TESTE DE RECEBIMENTO DOS DADOS DO BANCO DE DADOS
		System.out.println(matriculasalunos.id());
		System.out.println(matriculasalunos.getNome());
		System.out.println(matriculasalunos.getGenero());

		// RESGATAR OS DADOS DO SISTEMA
		request.setAttribute("id", matriculasalunos.id());
		request.setAttribute("nome", matriculasalunos.getNome());
		request.setAttribute("data", matriculasalunos.getDatadeNacimento());
		request.setAttribute("cep", matriculasalunos.getCep());

		// ENVIANDO OS DADOS PARA O DOCUMENTO JSP

		// ESSE REQUESTDISPATCHER FUNCIONA COMO UM LINK TAMBÉM
		RequestDispatcher rd = request.getRequestDispatcher("Alteraçãodecadastro.jsp");
		rd.forward(request, response);

	}

	protected void Updadte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//AQUI É GERADO UM TESTE PARA SABER SE OS DADOS ESTÃO REALMENTE CHEGANDO NA CLASSE 	
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("sobrenome"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("cpf"));
		// AQUI OS DADOS SÃO ENVIADOS PARA A CLASSE MODEL

		matriculasalunos.setNome(request.getParameter("nome"));
		matriculasalunos.setCep(request.getParameter("cep"));
		matriculasalunos.setDatadeNacimento(request.getParameter("data"));
		matriculasalunos.setGenero(request.getParameter("genero"));
		matriculasalunos.id(request.getParameter("id"));

		// AQUI OS DADOS SÃO ENVIADOS PARA A CLASSE CRUD E O METODO DE LÁ ENVIA ESSES
		// DADOS PARA O BANCO DE DADOS
		matricula.Update(matriculasalunos);

		response.sendRedirect("main3");

	}

	// AQUI SERÁ A ATIVAÇÃO DAS MATRICULAS
	protected void Ativacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtém a data atual
		Date dataAtual = new Date();

		// Cria um formato para o padrão brasileiro (dd/MM/yyyy)
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));

		// Formata a data conforme o padrão brasileiro
		String dataFormatada = formatoBrasileiro.format(dataAtual);

		// Exibe a data formatada
		System.out.println(dataFormatada);

		String ativar = request.getParameter("id");

		System.out.println(ativar);
		System.out.println(dataFormatada);
		System.out.println(geradormat.gerarMatricula());

		matriculasalunos.id(ativar);
		matricula.selection(matriculasalunos);

		if (Matricula.getMatricula() == null) {

			matricula.selection(matriculasalunos);
			Matricula.setData(dataFormatada);
			Matricula.setId_Aluno(Integer.parseInt(matriculasalunos.id()));
			Matricula.setMatricula(geradormat.gerarMatricula());
			Matricula.setId_matricula(matriculasalunos.id());
			System.out.println(Matricula.getId_matricula());
			System.out.println(Matricula.getId_Aluno());
			System.out.println(Matricula.getMatricula());
			System.out.println(Matricula.getData());
			matriculas.UpdateMatricula(Matricula);

		}

		if (Matricula.getData() == null) {

			Matricula.setData(dataFormatada);

		}

		System.out.println(ativar);
		System.out.println(Matricula.getData());
		matriculas.Ativacao(matriculasalunos);

		response.sendRedirect("main3");
	}

	protected void Initivacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String inativar = request.getParameter("id");
		System.out.println(inativar);
		matriculasalunos.id(inativar);
		matricula.selection(matriculasalunos);
		matriculas.inativacaodeMatricula(matriculasalunos);
		response.sendRedirect("main3");

	}

//VALIDAÇÃO DE EMAIL E SENHA 
	protected void Validacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (request.getParameter("emailentrar") != null) {
				valores.setEmail(request.getParameter("emailentrar"));
				System.out.println(request.getParameter("emailentrar"));

			}

			valores.setsenha(request.getParameter("senhaentrar"));

			if (request.getParameter("matriculaentrar") != null) {

				Matricula.setMatricula(request.getParameter("matriculaentrar"));

			}

			func.setsenha(request.getParameter("senhaentrar"));

			if (request.getParameter("emailentrar") != null) {
				func.setEmail(request.getParameter("emailentrar"));
			}

			System.out.println(request.getParameter("senhaentrar"));

			ResultSet rs = Crud.Validcao(valores);
			ResultSet Rs = Crud.inserirValidacao(func);

			if (rs.next()) {
				matricula.Nomeusuario(valores, matriculasalunos);
				System.out.println(matriculasalunos.getNome());
				HttpSession session = request.getSession();

				session.setAttribute("usuario", matriculasalunos.getNome());
				request.setAttribute("usuario", matriculasalunos.getNome());

				response.sendRedirect("index2.jsp");

			}

			if (request.getParameter("matriculaentrar") != null) {

				ResultSet rsd = matricula.validacaoporSenha(matriculasalunos);
				ResultSet rsd2 = matriculas.validaocao(Matricula);

				if (rsd.next() && rsd2.next()) {
					matricula.selection(matriculasalunos);
					HttpSession session = request.getSession();
					session.setAttribute("usuario", matriculasalunos.getNome());

					response.sendRedirect("index2.jsp");
				}

			}

			else if (Rs.next()) {

				response.sendRedirect("main3");

			}

			else {

				response.sendRedirect("login.jsp");

			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void GeraçãodeRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Aqui ele pega a ArrayList que possui os dados do banco de dados
			ArrayList<Aluno> lista = matricula.listagem();

			PdfWriter.getInstance(documento, response.getOutputStream());

			// aqui o documento é aberto
			documento.open();
			documento.add(new Paragraph("Lista de Matriculas:"));
			// Aqui é adiciona um paragrafo vazio para dar um espaço entre o titulo e a
			// tabela
			documento.add(new Paragraph("  "));

			// Aqui é criada tabela e é dito o numero de colunas que ela possuir
			PdfPTable tabela = new PdfPTable(5);

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("cpf"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Genero"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Status"));

			// Aqui é adicionado todas as colunas que a tabela vai ter
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// AQUI É AONDE A TABELA VAI SER PRENCHIDA
			// obs:É BOM SEGUIR O MES PADRÃO DO CABESALHO DA TABELA
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getStatusaluno() != null) {
					tabela.addCell(lista.get(i).getNome());
					tabela.addCell(lista.get(i).getCpf());
					tabela.addCell(lista.get(i).getGenero());
					tabela.addCell(lista.get(i).getTelefone());

					tabela.addCell(lista.get(i).getStatusaluno());
				}

			}
			// Aqui é aonde a tabela é adicionada ao documento
			documento.add(tabela);

			// Após toda execusão o documento é fechado
			documento.close();

		} catch (Exception e) {
			// caso haja algum erro ele vai imprimir o erro e vai fechar o documento
			System.out.println(e);
			documento.close();
		}

	}

	protected void Boleto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("cpf");
		System.out.println(id);
		matriculasalunos.setCpf(id);
		matricula.selection(matriculasalunos);
        
	
		matriculasalunos.setCpf(matriculasalunos.getCpf());
		System.out.println(matriculasalunos.getCpf());
		pag.setMetodopagamentos("BOLETO");
		System.out.println(pag.getMetodopagamentos());

		pag.setCpf(Long.parseLong(matriculasalunos.getCpf()));
		compra.MetododepagamentoUtilizado(pag);
		System.out.println(id);
		System.out.println(pag.getMetodopagamentos());

		if (matriculasalunos.getNome() != null && matriculasalunos.getCpf() != null) {
			// Gera o boleto
			BoletoViewer boletoViewer = matriculasalunos.gerarBoleto();

			// Configura a resposta HTTP para PDF
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline;filename=boleto.pdf");

			// Obtém o ServletOutputStream da resposta para enviar o PDF
			try (ServletOutputStream out = response.getOutputStream()) {
				// Obtém os bytes do PDF
				byte[] pdfBytes = boletoViewer.getPdfAsByteArray();

				// Escreve os bytes no ServletOutputStream
				out.write(pdfBytes);
			}
		} else {
			response.sendRedirect("index2.jsp");

		}

	}

	protected void RelatorioCartao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {

			ArrayList<cartao> lista = cartao.listarcart();

			PdfWriter.getInstance(documento, response.getOutputStream());

			documento.open();
			documento.add(new Paragraph("Lista de Cartões:"));

			documento.add(new Paragraph("  "));

			PdfPTable tabela = new PdfPTable(4);

			PdfPCell col1 = new PdfPCell(new Paragraph("Numero do Cartão"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome do Cartao"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
			PdfPCell col4 = new PdfPCell(new Paragraph("CCV"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNumerocartao());
				tabela.addCell(lista.get(i).getNomecartao());
				tabela.addCell(lista.get(i).getMesdeVencimnto() + "/" + lista.get(i).getAnoVencimento());
				tabela.addCell(lista.get(i).getCvc());

			}

			documento.add(tabela);

			documento.close();

		} catch (Exception e) {

			System.out.println(e);
			documento.close();
		}

	}

	protected void Redirecinamencartao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		matriculasalunos.setCpf(id);

		response.sendRedirect("cartao.html");

	}

	protected void Cartão(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("number"));
		System.out.println(request.getParameter("number2"));
		System.out.println(request.getParameter("number3"));
		System.out.println(request.getParameter("number4"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("mesemqueExpira"));
		System.out.println(request.getParameter("AnoemqueExpira"));
		System.out.println(request.getParameter("cvc"));

		cart.setNumerocartao(request.getParameter("number") + request.getParameter("number2")
				+ request.getParameter("number3") + request.getParameter("number4"));
		cart.setNomecartao(request.getParameter("nome"));
		cart.setMesdeVencimnto(request.getParameter("mesemqueExpira"));
		cart.setAnoVencimento(request.getParameter("AnoemqueExpira"));
		cart.setCvc(request.getParameter("cvc"));

		cartao.inserirInformacoes(cart);
		// PARTE DO METODO DE PAGAMENTO
		pag.setMetodopagamentos("CARTAO");

		System.out.println(matriculasalunos.getCpf());
		pag.setCpf(Long.parseLong(matriculasalunos.getCpf()));
		compra.MetododepagamentoUtilizado(pag);

		response.sendRedirect("index2.jsp");

	}

	protected void AddCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nomeCurso"));
		System.out.println(request.getParameter("valorCurso"));

		curso.setNomeCurso(request.getParameter("nomeCurso"));
		curso.setValor(Double.parseDouble(request.getParameter("valorCurso")));
		cur.inserirCurso(curso);
		response.sendRedirect("main3");
	}

	protected void AlterarValor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Cursos> listar = cur.listarCurso();
		request.setAttribute("troca", listar);
		RequestDispatcher rd = request.getRequestDispatcher("formulariodePrecos.jsp");
		rd.forward(request, response);
		response.sendRedirect("formulariodePrecos.jsp");

	}

	protected void AddListaCursos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Cursos> listar = cur.listarCurso();
		ArrayList<Turma> lista = turma.listarTurmas();
		request.setAttribute("cursos", listar);
		request.setAttribute("Turmas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("SistemaCursos.jsp");
		rd.forward(request, response);
		for (int i = 0; i < listar.size(); i++) {

			System.out.println(listar.get(i).id());
			System.out.println(listar.get(i).getNomeCurso());

		}
		for (int i = 0; i < lista.size(); i++) {

			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getTurno());

		}

	}

	protected void Carrinho(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		request.setAttribute("curso", curso.getNomeCurso());

		request.setAttribute("valor", curso.formatarComoMoeda(curso.getValor()));

		// Enviar o valor do curso Para o Boleto
		matriculasalunos.setValorParaBoleto(curso.getValor());

		System.out.println(matriculasalunos.id());

		request.setAttribute("id", matriculasalunos.id());
		request.setAttribute("rua", matriculasalunos.getRua());
		request.setAttribute("bairro", matriculasalunos.getBairro());
		request.setAttribute("numero", matriculasalunos.getNumero());
		request.setAttribute("nome", matriculasalunos.getNome());
		request.setAttribute("cpf", matriculasalunos.getCpf());
		request.setAttribute("cep", matriculasalunos.getCep());
		request.setAttribute("cidade", matriculasalunos.getCidade());
		request.setAttribute("estado", matriculasalunos.getEstado());

		RequestDispatcher rd = request.getRequestDispatcher("Carrinho.jsp");
		rd.forward(request, response);

		// INFORMAÇÕES PARA O PAGAMNETO

		// Obtém a data atual
		Date dataAtual = new Date();

		// Cria um formato para o padrão brasileiro (dd/MM/yyyy)
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));

		// Formata a data conforme o padrão brasileiro
		String dataFormatada = formatoBrasileiro.format(dataAtual);

		// Exibe a data formatada
		System.out.println(dataFormatada);

		pag.setNome(matriculasalunos.getNome());
		pag.setCpf(Long.parseLong(matriculasalunos.getCpf()));
		pag.setCurso(curso.getNomeCurso());
		pag.setValor(curso.getValor());
		pag.setDatacompra(dataFormatada);
		compra.InserirComapras(pag);

		System.out.println(pag.getNome());
		System.out.println(pag.getCurso());
		System.out.println(pag.getCpf());
		System.out.println(pag.getValor());
		System.out.println(pag.getDatacompra());

	}

	protected void AtualizarPreco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("escolha"));
		System.out.println(request.getParameter("novo_preco"));

		curso.id(request.getParameter("escolha"));
		curso.setValor(Double.parseDouble(request.getParameter("novo_preco")));
		cur.Atualizarpreço(curso);
		response.sendRedirect("main3");

	}

	protected void RelatorioCurso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Aqui ele pega a ArrayList que possui os dados do banco de dados
			ArrayList<Cursos> lista = cur.listarCurso();

			PdfWriter.getInstance(documento, response.getOutputStream());

			// aqui o documento é aberto
			documento.open();
			documento.add(new Paragraph("Tabela de Cursos e Preços:"));
			// Aqui é adiciona um paragrafo vazio para dar um espaço entre o titulo e a
			// tabela
			documento.add(new Paragraph("  "));

			// Aqui é criada tabela e é dito o numero de colunas que ela possuir
			PdfPTable tabela = new PdfPTable(2);

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Cursos"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Valores"));

			// Aqui é adicionado todas as colunas que a tabela vai ter
			tabela.addCell(col1);
			tabela.addCell(col2);

			// AQUI É AONDE A TABELA VAI SER PRENCHIDA
			// obs:É BOM SEGUIR O MES PADRÃO DO CABESALHO DA TABELA
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNomeCurso());
				tabela.addCell(String.valueOf(lista.get(i).getValor()));

			}
			// Aqui é aonde a tabela é adicionada ao documento
			documento.add(tabela);

			// Após toda execusão o documento é fechado
			documento.close();

		} catch (Exception e) {
			// caso haja algum erro ele vai imprimir o erro e vai fechar o documento
			System.out.println(e);
			documento.close();
		}

	}

	protected void RedirecinamentoPagamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("Pagamento.jsp");
		rd.forward(request, response);
	}

	protected void ConfirmacaodePagamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		String id = request.getParameter("id");
		System.out.println(id);
		pag.setId(id);
		compra.AtualizaroStatus(pag);
		if (action.equals("/confirme")) {

			response.sendRedirect("main3");

		} else {
			response.sendRedirect("index2.jsp");
		}
	}

	protected void Excluircomprasnaoefetuadas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		pag.setId(id);
		compra.PagamentoNaoefetuadoMat(pag);
		compra.PagamentoNaoefetuado2(pag);
		response.sendRedirect("main3");
		;

	}

	protected void RelatorioPagmentos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Aqui ele pega a ArrayList que possui os dados do banco de dados
			ArrayList<Pagamentos> lista = compra.listarCompras();

			PdfWriter.getInstance(documento, response.getOutputStream());

			// aqui o documento é aberto
			documento.open();
			documento.add(new Paragraph("Tabela de Compras:"));
			// Aqui é adiciona um paragrafo vazio para dar um espaço entre o titulo e a
			// tabela
			documento.add(new Paragraph("  "));

			// Aqui é criada tabela e é dito o numero de colunas que ela possuir
			PdfPTable tabela = new PdfPTable(7);

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Cpf"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Curso"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Valor"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Status"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Data da Compra"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Metodo de Pagmento"));

			// Aqui é adicionado todas as colunas que a tabela vai ter
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);

			// AQUI É AONDE A TABELA VAI SER PRENCHIDA
			// obs:É BOM SEGUIR O MES PADRÃO DO CABESALHO DA TABELA
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(String.valueOf(lista.get(i).getCpf()));
				tabela.addCell(lista.get(i).getCurso());
				tabela.addCell(String.valueOf(lista.get(i).getValor()));
				tabela.addCell(lista.get(i).getStatusdacompra());
				tabela.addCell(lista.get(i).getDatacompra());
				tabela.addCell(lista.get(i).getMetodopagamentos());
			}
			// Aqui é aonde a tabela é adicionada ao documento
			documento.add(tabela);

			// Após toda execusão o documento é fechado
			documento.close();

		} catch (Exception e) {
			// caso haja algum erro ele vai imprimir o erro e vai fechar o documento
			System.out.println(e);
			documento.close();
		}

	}

	protected void PesquisarDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("pesquisa"));
		matriculasalunos.setCpf(request.getParameter("pesquisa"));
		matricula.PesquisarCpf(matriculasalunos);

		request.setAttribute("data", dataformat.formatarData(matriculasalunos.getDatadeNacimento()));
		request.setAttribute("id", matriculasalunos.id());
		request.setAttribute("rua", matriculasalunos.getRua());
		request.setAttribute("bairro", matriculasalunos.getBairro());
		request.setAttribute("numero", matriculasalunos.getNumero());
		request.setAttribute("nome", matriculasalunos.getNome());
		request.setAttribute("cpf", matriculasalunos.getCpf());
		request.setAttribute("cep", matriculasalunos.getCep());
		request.setAttribute("cidade", matriculasalunos.getCidade());
		request.setAttribute("estado", matriculasalunos.getEstado());

		RequestDispatcher rd = request.getRequestDispatcher("InformeAluno.jsp");
		rd.forward(request, response);
	}
	
	
	protected void RelatorioDeDiciplinas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Aqui ele pega a ArrayList que possui os dados do banco de dados
			ArrayList<ViwerDiciplinasCurso> lista = dici.listardicplinas();

			PdfWriter.getInstance(documento, response.getOutputStream());

			// aqui o documento é aberto
			documento.open();
			documento.add(new Paragraph("Tabela de Diciplinas:"));
			// Aqui é adiciona um paragrafo vazio para dar um espaço entre o titulo e a
			// tabela
			documento.add(new Paragraph("  "));

			// Aqui é criada tabela e é dito o numero de colunas que ela possuir
			PdfPTable tabela = new PdfPTable(2);

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Cursos"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Diciplinas"));
			

			// Aqui é adicionado todas as colunas que a tabela vai ter
			tabela.addCell(col1);
			tabela.addCell(col2);
			

			// AQUI É AONDE A TABELA VAI SER PRENCHIDA
			// obs:É BOM SEGUIR O MES PADRÃO DO CABESALHO DA TABELA
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getCurso());
				tabela.addCell(lista.get(i).getDciplinas());
			}
			// Aqui é aonde a tabela é adicionada ao documento
			documento.add(tabela);

			// Após toda execusão o documento é fechado
			documento.close();

		} catch (Exception e) {
			// caso haja algum erro ele vai imprimir o erro e vai fechar o documento
			System.out.println(e);
			documento.close();
		}
		
		
	}
	
	protected void RelatorioDeTurmas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Aqui ele pega a ArrayList que possui os dados do banco de dados
			ArrayList<Turma> lista = turma.listarTurmas();

			PdfWriter.getInstance(documento, response.getOutputStream());

			// aqui o documento é aberto
			documento.open();
			documento.add(new Paragraph("Tabela de Turmas:"));
			// Aqui é adiciona um paragrafo vazio para dar um espaço entre o titulo e a
			// tabela
			documento.add(new Paragraph("  "));

			// Aqui é criada tabela e é dito o numero de colunas que ela possuir
			PdfPTable tabela = new PdfPTable(4);

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Sala"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Turno"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data de inicio"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data de fim"));
			

			// Aqui é adicionado todas as colunas que a tabela vai ter
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			

			// AQUI É AONDE A TABELA VAI SER PRENCHIDA
			// obs:É BOM SEGUIR O MES PADRÃO DO CABESALHO DA TABELA
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getSala());
				tabela.addCell(lista.get(i).getTurno());
				tabela.addCell(lista.get(i).getData_inicio());
				tabela.addCell(lista.get(i).getData_fim());
				
				
			}
			// Aqui é aonde a tabela é adicionada ao documento
			documento.add(tabela);

			// Após toda execusão o documento é fechado
			documento.close();

		} catch (Exception e) {
			// caso haja algum erro ele vai imprimir o erro e vai fechar o documento
			System.out.println(e);
			documento.close();
		}
		
	}
	
	protected void RelatorioDeMatriculados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Document documento = new Document();
		try {
			// Aqui ele pega a ArrayList que possui os dados do banco de dados
			ArrayList<ViwerMatriculados> lista = matriculas.listarmatriculados();

			PdfWriter.getInstance(documento, response.getOutputStream());

			// aqui o documento é aberto
			documento.open();
			documento.add(new Paragraph("Tabela de Alunos Matriculados:"));
			// Aqui é adiciona um paragrafo vazio para dar um espaço entre o titulo e a
			// tabela
			documento.add(new Paragraph("  "));

			// Aqui é criada tabela e é dito o numero de colunas que ela possuir
			PdfPTable tabela = new PdfPTable(3);

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Curso"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Sala"));
			
			

			// Aqui é adicionado todas as colunas que a tabela vai ter
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			

			// AQUI É AONDE A TABELA VAI SER PRENCHIDA
			// obs:É BOM SEGUIR O MES PADRÃO DO CABESALHO DA TABELA
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getCurso());
				tabela.addCell(lista.get(i).getSala());
				
				
				
			}
			// Aqui é aonde a tabela é adicionada ao documento
			documento.add(tabela);

			// Após toda execusão o documento é fechado
			documento.close();

		} catch (Exception e) {
			// caso haja algum erro ele vai imprimir o erro e vai fechar o documento
			System.out.println(e);
			documento.close();
		}
	}
	
	
	protected void NovaTurma(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	System.out.println(request.getParameter("sala"));
	System.out.println(request.getParameter("turno"));
	System.out.println(request.getParameter("dataInicio"));
	System.out.println(request.getParameter("dataFim"));
	
	turmas.setSala(request.getParameter("sala"));
	turmas.setTurno(request.getParameter("turno"));
	turmas.setData_inicio(request.getParameter("dataInicio"));
	turmas.setData_fim(request.getParameter("dataFim"));
	
	turma.insertTurma(turmas);
	response.sendRedirect("main3");
	}
}
