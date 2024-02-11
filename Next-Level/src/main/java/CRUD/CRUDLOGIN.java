package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import CONEXÃO.DAO;
import MODEL.Funcionario;
import MODEL.JavaBeans;

public class CRUDLOGIN {
DAO conect = new DAO();

	// CRIAÇÃO CRUD C = CREATE , AQUI COMEÇA A PARTE DE INSERIR OS DADOS DIGITADOS
	// NO BANCO DE DADOS
	public void Inserirdados(JavaBeans contatos) {

		// AQUI VAI SER CRIADO UMA VARIAVEL DO TIPO STRING EM QUE VAI SER PASSADO O
		// METODO QUE É USADO PARA INSERI OS NOVOS VALORE

		String repasse = "insert into credenciais (email , senha) values(? , ?)";

		// AQUI VAI SER ABERTA A CONEXÃO COM O BANCO DE DADOS
		try {

			// AQUI VAI SER CRIADA UMA CONEXÃO NO BANCO COMO NOS OUTROS
			Connection conexao = conect.createConnectionMysql();

			// AQUI A CONEXÃO VAI SER PREPARADA ATRAVÉS DO (PreparedStatement)
			PreparedStatement pstm = conexao.prepareStatement(repasse);

			// AQUI OS SINAIS DE INTERROGAÇÃO VÃO SER SUBSTITUIDOS PELOS VALORE COLOCADOS
			// DOS CLIENTES
			pstm.setString(1, contatos.getEmail());
			pstm.setString(2, contatos.getsenha());

			// É APARTIR DESSE METODO QUE OS DADOS VÃO SER DIRECIONADOS PARA O BANCO DE
			// DADOS
			pstm.executeUpdate();

			// APÓS O ENVIO DOS DADOS PARA O BANCO DE DADOS NÓS TEMOS QUE FECHAR A CONEXÃO
			// PARA QUE ELA NÃO FIQUE ABERTA DA PROXIMA VEZ QUE O USUARIO ENTRAR NO APP
			conexao.close();

		} catch (Exception e) {

			// SE CASO HOUVER ALGUMA EXESÃO NO CODIGO ELE VAI PRINTADO NO CONSOLE
			System.out.println(e);
		}

	}

	// CRUD READE = LISTAR OS DADOS QUE ESTÃO NO BANCO DE DADOS . AQUI ELE VAO SER
	// CRIADO UM METODO PARA LISTAR TODOS OS CONTATOS DO BANCO DE DADOS

	public ArrayList<JavaBeans> listarCadastros() {

		// AQUI VAI SER CRIADO UM METODO DE VALOR STRING QUE VAI TER O METOD DE
		// SELICIONAR CONTATO QUE SE USA NO MYSQL
		String listar = "select*from credenciais";

		ArrayList<JavaBeans> cadastros = new ArrayList<>();

		try {
			Connection conexao = conect.createConnectionMysql();

			PreparedStatement pst = conexao.prepareStatement(listar);

			// AQUI ESSE OBJETO VAI ARMAZENAR OS DADOS DA ARRAYLIST TEMPORARIAMENTE
			// EXECUTANDO ASSIM A QUERY
			ResultSet TS = pst.executeQuery();

			// AQUI VAI SE FEITO UM LAÇO DE REPETIÇÃO UTILIZANDO WHILE. ELE VAI CONTINUAR EM
			// EXECUSÃO ENQUANTO HOUVEREM CONTATOS EXISTENTES

			while (TS.next()) {
				// O METODOD NEXT FAZ PARTE DO METODO :(ResultSet) , ELE VAI CONTINUAR PASSANDO
				// PARA PROXMO VALOR ENQUANTO EXISTIREM VALORES NO OBJETO QUE ESTÁ ARMAZENANDO
				// OS DADOS E EXECUTANDO A QUERY O (TS).

				// AQUI SERÃO FEITAS VARIAVEIS DE APOIO QUE VÃO RECERBER OS DADOS REFERENTE AO
				// CAMPO DO BANCO DE DADOS ,
//POR EXEMPLO: 1: SE TRATA DA PRIMEIRA COLUNA DA TABELA O  IDCON  
//2: SE TRATA DA SEGUNDA COLUNA A COLUNA DOS EMAILS  
//3:  SE TRATA DA COLUNA DE SENHAS 
				String id = TS.getString(1);
				String usuario = TS.getString(2);
				String senha = TS.getString(3);

				// NESSA PARTE VAI "POPULAR A ARRAY" COLOCANDO OS DADOS DENTRO DELA

				cadastros.add(new JavaBeans(id, usuario, senha));

			}
			// APÓS O LAÇO DO WHILE FOR QUEBRADO ELE ENCERRAR A CONEXÃO COM O BANCO DE DADOS
			conexao.close();

			// AQUI ELE VAI RETORNAR O DADOS DA ARRAYLIST
			return cadastros;

		}
       
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	
	
	//VALIDAÇÃO DE EMAIL E SENHA 
	public ResultSet Validcao(JavaBeans java) {
		String sel = "select *from credenciais where email = ? and senha = ? ";
		
		try {
			Connection con = conect.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(sel);
			pst.setString(1, java.getEmail());
			pst.setString(2, java.getsenha());
			
			ResultSet rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
			
		}
	}
	
	
	
	
	
	//Validacao para login de funcionario
	public ResultSet inserirValidacao(Funcionario func) {
		String sel = "select * from opentabelas where Email = ? and Senha = ?";
		try {
			
			Connection con = conect.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(sel);
			
			pst.setString(1, func.getEmail());
			pst.setString(2, func.getsenha());
			
			ResultSet rs = pst.executeQuery();
			return rs;
			
		} catch (Exception e) {
			
			System.out.println(e);		
		     return null;	
		}
	}
	
	
	
	
}