package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import CONEXÃO.DAO;
import MODEL.Turma;
import Ultilitarios.FormatadordeData;

public class CRUDTURMAS {
	
	

	DAO conn = new DAO();
FormatadordeData format = new FormatadordeData();
	public void insertTurma(Turma tur) {
		String in = "insert into turma(sala , turno , data_inicio ,data_fim) values (?,?,?,?)";
		try {
			
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(in);
			pst.setString(1,tur.getSala());
			pst.setString(2, tur.getTurno());
			pst.setString(3,format.formatarData(tur.getData_inicio()));
			pst.setString(4,format.formatarData( tur.getData_fim()));
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	public ArrayList<Turma> listarTurmas(){
		String sel = "select*from Turma";
		ArrayList<Turma> listar = new ArrayList<Turma>();
		try {
			Connection con= conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(sel);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString(1);
				String sala = rs.getString(2);
				String turno = rs.getString(3);
				String data_inicio = rs.getString(4);
				String data_fim = rs.getString(5);
				
				listar.add(new Turma(id ,sala , turno ,data_inicio ,data_fim));
				
			}
			con.close();
			return listar;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public void Requestdados(Turma turma) {
		String req = "select*from Turma where id = ?";
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(req);
			pst.setString(1, turma.getId());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				turma.setId(rs.getString(1));
				turma.setSala(rs.getString(2));
				turma.setTurno(rs.getString(3));
				turma.setData_inicio(rs.getString(4));
				turma.setData_fim(rs.getString(5));
				
			}
					
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
