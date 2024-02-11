package CRUD; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import CONEXÃO.DAO;
import MODEL.Cursos;

public class CRUDCURSOS {
	DAO conn = new DAO(); 
	
public void inserirCurso(Cursos curso) {
String in = "insert into cursos (curso , valor) value (?,?)";
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(in);
		pst.setString(1, curso.getNomeCurso());
		pst.setDouble(2, curso.getValor());	
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}

public void Atualizarpreço(Cursos cur) {
	String alt = "update cursos set valor = ? where id =?";
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst =  con.prepareStatement(alt);
		pst.setDouble(1, cur.getValor());
		pst.setString(2, cur.id());
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}


public ArrayList<Cursos> listarCurso(){
	String in = "select*from cursos";
	
	ArrayList<Cursos> lista = new ArrayList<Cursos>();
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(in);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			
			String id = rs.getString(1);
			String nome = rs.getString(2);
			double valor = rs.getDouble(3); 	
			lista.add(new Cursos(id , nome , valor));
		}
		con.close();
		return lista;
		
	} catch (Exception e) {
		System.out.println(e);
		return null;
		
	}
}


public void RequestCurso(Cursos curso) {
	String cursos = "select*from cursos where id = ? ";
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(cursos);
		pst.setString(1, curso.id());
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			curso.id(rs.getString(1));
			curso.setNomeCurso(rs.getString(2));
			curso.setValor(rs.getDouble(3));
			
		}
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}




	
	
	
}