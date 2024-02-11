
package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import CONEXÃO.DAO;
import MODEL.Aluno;
import MODEL.matricula;
import Ultilitarios.ViwerMatriculados;

public class CRUDMATRICULAS {

	DAO conn = new DAO();
	public void inserirdados(matricula mat) {
		String matri = "insert into matricula (data_matricula , matricula , id_curso , id_aluno,id_turma) values (null, null ,? , null , ?)";
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(matri);
			pst.setInt(1,mat.getId_Curso());
			pst.setInt(2,mat.getId_Turma());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<matricula> listarmat(){
		String mat="select*from matricula";
		ArrayList<matricula> matricular = new ArrayList<matricula>();
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(mat);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				String id_matricula = rs.getString(1);
				String data_matricula = rs.getString(2);
				String matricula = rs.getString(3);
				int id_curso = rs.getInt(4);
				int id_aluno = rs.getInt(5);
				int id_turma = rs.getInt(6);
				
				matricular.add(new matricula(id_matricula , data_matricula ,matricula,  id_curso , id_aluno ,id_turma ));
				
			}
			con.close();
			return matricular;
					
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public void UpdateMatricula(matricula mat) {
		String up = "update matricula set id_aluno = ?  , matricula = ? ,data_matricula = ?  where id_matricula = ?";
		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(up);
			pst.setInt(1, mat.getId_Aluno());
			pst.setString(2, mat.getMatricula());
			pst.setString(3, mat.getData());
			pst.setInt(4, Integer.parseInt(mat.getId_matricula()));
			
			pst.executeUpdate();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void Ativacao(Aluno mat) {
		String situacao = "update Aluno set  statusaluno ='ATIVO' where id =?";
		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(situacao);
			pst.setString(1, mat.id());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inativacaodeMatricula(Aluno mat) {
		String situacao = "update Aluno set  statusaluno ='INATIVO' where id =?";
		try {
			Connection con = DAO.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(situacao);
			pst.setString(1, mat.id());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ResultSet validaocao( matricula mat) {
		String valid = "select*from matricula where matricula = ?";
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst= con.prepareStatement(valid);
			pst.setString(1, mat.getMatricula());
			ResultSet rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	/*Viwer de Matriculados*/
	
	public ArrayList<ViwerMatriculados> listarmatriculados(){
		String viwer = "select*from MATRICULADOS";
		
		ArrayList<ViwerMatriculados> listar = new ArrayList<>();
		try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(viwer);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			
			String nome = rs.getString(1);
			String curso = rs.getString(2);
			String sala = rs.getString(3);
			
			listar.add(new ViwerMatriculados(nome ,curso ,sala));
		}
		con.close();
		return listar;
		} catch (Exception e) {
			
		System.out.println(e);
		return null;
		
		}
		
	}
	
	
	
}
