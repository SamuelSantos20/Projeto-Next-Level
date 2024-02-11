package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import CONEXÃO.DAO;
import MODEL.cartao;

public class CRUDCARTAO {
    DAO conn = new DAO();
	public void inserirInformacoes(cartao cart) {
		String in = "insert into cartao(numerocartao , nome , MesdeVencimento , AnoVencimento ,cvc) values (? , ? , ? , ?, ?)";
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(in);
			pst.setString(1, cart.getNumerocartao());
			pst.setString(2, cart.getNomecartao());
			pst.setString(3, cart.getMesdeVencimnto());
			pst.setString(4, cart.getAnoVencimento());
			pst.setString(5, cart.getCvc());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	
	public ArrayList<cartao> listarcart(){
		String list = "select*from cartao";
		ArrayList<cartao> listar = new ArrayList<cartao>();
		try {
			Connection con = conn.createConnectionMysql();
			PreparedStatement pst = con.prepareStatement(list);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String numerocartao = rs.getString(2);
				String nomecartao = rs.getString(3);
				String mesdeVencimento = rs.getString(4);
				String AnodeVencimento = rs.getString(5);
				String cvc = rs.getString(6);
				
				listar.add(new cartao(id , numerocartao , nomecartao , mesdeVencimento , AnodeVencimento , cvc));
			}
			con.close();
			return listar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
