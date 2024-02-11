package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import CONEXÃO.DAO;
import MODEL.Diciplinas;
import Ultilitarios.ViwerDiciplinasCurso;

public class CRUDDICIPLINAS {

	DAO conn = new DAO();
	
	public ArrayList<Diciplinas> ListDiciplinas(){
		String sel = "select*from diciplinas";
		ArrayList<Diciplinas> pg = new ArrayList<Diciplinas>();
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(sel);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getNString(2);
				
		pg.add(new Diciplinas(id , nome));		
			}
			con.close();
			return pg;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public ArrayList<ViwerDiciplinasCurso> listardicplinas(){
		String dic = "select*from diciplinascursos";
		ArrayList<ViwerDiciplinasCurso> listar = new ArrayList<>();
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(dic);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String curso = rs.getString(1);
				String diciplina = rs.getString(2);
				
				listar.add(new ViwerDiciplinasCurso(curso ,diciplina));
				
			}
			con.close();
			return listar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}







}