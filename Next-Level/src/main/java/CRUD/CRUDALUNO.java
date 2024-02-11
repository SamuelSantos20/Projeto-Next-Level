package CRUD;

import MODEL.Aluno;
import MODEL.Cursos;
import MODEL.JavaBeans;
import MODEL.matricula;
import Ultilitarios.FormatadordeCEP;
import Ultilitarios.FormatadordeRG;
import Ultilitarios.FormatadoresdeCPF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import CONEXÃO.DAO;

public class CRUDALUNO {
	DAO conect = new DAO();
	


	public void inseriCadastros(Aluno matricula) {
		String in = "insert into Aluno(nome ,cpf , genero , cidade ,estado ,bairro , rua , numero , complemento , datadeNacimento , rg , cep , statusaluno , senha , telefone) values (?,?,?,?,?,?,?,?,?,?,?,?,null,?,?)";

		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(in);

			pst.setString(1, matricula.getNome());
			pst.setString(2, matricula.getCpf());
			pst.setString(3, matricula.getGenero());
			pst.setString(4, matricula.getCidade());
			pst.setString(5, matricula.getEstado());
			pst.setString(6, matricula.getBairro());
			pst.setString(7, matricula.getRua());
			pst.setString(8, matricula.getNumero());
			pst.setString(9, matricula.getComplemento());
			pst.setString(10, matricula.getDatadeNacimento());
			pst.setString(11, matricula.getRg());
			pst.setString(12, matricula.getCep());
            pst.setString(13, matricula.getSenha());
            pst.setString(14, matricula.getTelefone());
            
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public ResultSet validacaoporSenha(Aluno mat ) {
		String ve = "select*from credenciais where  senha = ?";
		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(ve);
			pst.setString(1, mat.getSenha());
			ResultSet rs = pst.executeQuery();
			return rs;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	public ArrayList<Aluno> listagem() {
		String iserir = "select*from Aluno";
		ArrayList<Aluno> adicionar = new ArrayList<>();
		FormatadoresdeCPF mat = new FormatadoresdeCPF();
		FormatadordeCEP cepf = new FormatadordeCEP();
		FormatadordeRG rgf = new FormatadordeRG();
		// (nome , cpf , genero , cidade , estado , bairro , rua , numero
		// ,complemento , datadeNacimento ,rg , cep , curso , turno ,statusaluno ,
		// matricula , dataAtivacao )
		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(iserir);
			ResultSet rs = pst.executeQuery();
 
			while (rs.next()) {

				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = mat.format(rs.getString(3));
				String genero = rs.getString(4);
				String cidade = rs.getString(5);
				String estado = rs.getString(6);
				String bairro = rs.getString(7);
				String rua = rs.getString(8);
				String numero = rs.getString(9);
				String complemento = rs.getString(10);
				String datadeNacimento = rs.getString(11);
				String rg =rgf.formatRG(rs.getString(12));
				String cep =cepf.formatCEP(rs.getString(13));			
				String status = rs.getString(14);
				String senha = rs.getString(15);
				String telefone = rs.getString(16);
				adicionar.add(new Aluno(idcon, nome,cpf, genero, cidade, estado, bairro, rua,
						numero, complemento, datadeNacimento, rg, cep,status,senha , telefone));

			}

			con.close();
			return adicionar;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// AQUI SERÁ CRIADO O METODO PARA A EDIÇÃO DAS MATRICULAS
	// A EDIÇÃO DA MATRICULA É SEPARADO EM DOIS METODOS UM PARA SELECIONAR O ID E O
	// OUTRO PARA EFETIVAMENTE ALTERAR A MATRICULA

	

	public void selection(Aluno matriculas) {
		String edit = "select*from Aluno where cpf = ?";

		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(edit);
			pst.setString(1, matriculas.getCpf());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				matriculas.id(rs.getString(1));
				matriculas.setNome(rs.getString(2));
				matriculas.setCpf(rs.getString(3));
				matriculas.setGenero(rs.getString(4));
				matriculas.setCidade(rs.getString(5));
				matriculas.setEstado(rs.getString(6));
				matriculas.setBairro(rs.getString(7));
				matriculas.setRua(rs.getString(8));
				matriculas.setNumero(rs.getString(9));
				matriculas.setComplemento(rs.getString(10));
				matriculas.setDatadeNacimento(rs.getString(11));
				matriculas.setRg(rs.getString(12));
				matriculas.setCep(rs.getString(13));
				matriculas.setStatusaluno(rs.getString(14));
				matriculas.setSenha(rs.getString(15));
				matriculas.setTelefone(rs.getString(16));

			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Update(Aluno matricula) {
		String up = "update cadastros set nome = ?  , telefone = ? , cpf = ? , genero = ? where id = ?";

		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(up);

			pst.setString(1, matricula.getNome());
			pst.setString(3, matricula.getCpf());
			pst.setString(4, matricula.getGenero());
			pst.setString(5, matricula.id());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//Ativar Matricula

	

	public void PesquisarCpf(Aluno mat) {
		String matri = "select*from Aluno where cpf = ?";
		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(matri);
			pst.setString(1, mat.getCpf());			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				mat.id(rs.getString(1));
				mat.setNome(rs.getString(2));
				mat.setCpf(rs.getString(3));
				mat.setGenero(rs.getString(4));
				mat.setCidade(rs.getString(5));
				mat.setEstado(rs.getString(6));
				mat.setBairro(rs.getString(7));
				mat.setRua(rs.getString(8));
				mat.setNumero(rs.getString(9));
				mat.setComplemento(rs.getString(10));
				mat.setDatadeNacimento(rs.getString(11));
				mat.setRg(rs.getString(12));
				mat.setCep(rs.getString(13));
				mat.setStatusaluno(rs.getString(16));
				
				
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void Nomeusuario(JavaBeans mod , Aluno matriculas) {
		String usu = "select*from Aluno where senha = ?";
	
		try {
			Connection con = conect.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(usu);
			pst.setString(1, mod.getsenha());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				matriculas.id(rs.getString(1));
				matriculas.setNome(rs.getString(2));
				matriculas.setCpf(rs.getString(4));
				matriculas.setGenero(rs.getString(5));
				matriculas.setCidade(rs.getString(6));
				matriculas.setEstado(rs.getString(7));
				matriculas.setBairro(rs.getString(8));
				matriculas.setRua(rs.getString(9));
				matriculas.setNumero(rs.getString(10));
				matriculas.setComplemento(rs.getString(11));
				matriculas.setDatadeNacimento(rs.getString(12));
				matriculas.setRg(rs.getString(13));
				matriculas.setCep(rs.getString(14));
				matriculas.setStatusaluno(rs.getString(15));
				
				
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
