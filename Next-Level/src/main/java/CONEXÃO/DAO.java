package CONEXÃO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	//VARIAVEL DO DRIVE
		private static final String drive = "com.mysql.cj.jdbc.Driver";

	//Caminho do banco de dados
		private static final String url = "jdbc:mysql://127.0.0.1:3306/cadastro?useTimezone=true&serverTimezone=UTC";

	//Nome do usuario do banco do dados
		private static final String usuario = "root";

	//Senha do Banco de dados
		private static final String senha = "";

	//AQUI ELE REALIZA UMA CONEXÃO COM O BANCO DE DADOS
		public static Connection createConnectionMysql() throws Exception {

			// ELE FAZ COM QUE A CLASSE SEJA CARREGADA PELA JVM

			Class.forName(drive);

			// AQUI CRIA A CONEXÃO COM O BANCO DE DADOS (IMPORTANDO AS CLASSES)
			Connection con = DriverManager.getConnection(url, usuario, senha);// AQUI ELE PEGA A CREDENCIAIS DO BANCO DE
																				// DADOS

			// RETORNA A CONEXÃO COM O BANCO DE DADOS
			return con;

		}

		// AQUI SERÁ FEITA UM TESTE DE CONEXÃO COM O BANCO DE DADOS

		public void testedeconexao() {
			try {
				Connection con = createConnectionMysql();

				System.out.println(con);

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	//AQUI ELE VAI VERIFICAR SE JÁ EXISTE ALGUMA CONEXÃO JÁ EXISTENTE SE EXISTIR ELE VAI ABRIR E FECHAR A NOVA PARA NÃO EXISTIREM DUAS CONEXÕES ATIVAS   

		public static void main(String[] args) throws Exception {
			Connection con  = createConnectionMysql();
			
			if (con != null) {
				System.out.println("CONEXÃO ESTABELECIDA COM SUCESSO");
				con.close();
			}
		}

}
