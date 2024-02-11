package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import CONEXÃO.DAO;
import MODEL.Pagamentos;
import Ultilitarios.FormatadordeCEP;
import Ultilitarios.FormatadordeRG;

public class CRUDCOMPRAS {
	DAO conn = new DAO();
	Pagamentos pag = new Pagamentos();
	
	FormatadordeRG rgf = new FormatadordeRG();
	FormatadordeCEP cepf = new FormatadordeCEP();
	
	public void InserirComapras(Pagamentos pg) {
	String inserir = "insert into RegistrodeCompras  (nome,cpf ,curso, valor ,statusdaCompra , datacompra , metododepagamento) values (?,?,?,?,'PAGAMENTO NÃO CONFIRMADO',?,null)";
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(inserir);
		pst.setString(1, pg.getNome());
		pst.setLong(2, pg.getCpf());
		pst.setString(3,pg.getCurso());
		pst.setDouble(4, pg.getValor());
		pst.setString(5, pg.getDatacompra());
		
		pst.executeUpdate();
		con.close();
	} catch (Exception e) {
		System.out.println(e);	
	}
}
	
	


public ArrayList<Pagamentos> listarCompras(){
	String rec = "select*from RegistrodeCompras";
	ArrayList<Pagamentos> lista = new ArrayList<Pagamentos>();
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(rec);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {		
			String id = rs.getString(1);
			String nome = rs.getString(2);
			long cpf = rs.getLong(3);
			String curso = rs.getString(4);
			double valor = rs.getDouble(5);
			String status = rs.getString(6);
			String data = rs.getString(7);
			String metodo = rs.getString(8);
		
			
			lista.add(new Pagamentos(id, nome, cpf, curso , valor, status , data , metodo));
			
		}
		con.close();
		
		return lista;
		
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
}

public void MetododepagamentoUtilizado(Pagamentos mat) {
	String atu = "update RegistrodeCompras set metododepagamento = ? where cpf = ?";
	
	try {
		Connection con = conn.createConnectionMysql();
	    PreparedStatement pst = con.prepareStatement(atu);
	    pst.setString(1, mat.getMetodopagamentos());
	    pst.setLong(2, mat.getCpf());
	    pst.executeUpdate();
	    con.close();
	    
	} catch (Exception e) {
		System.out.println(e);
	}
}

public void PagamentoNaoefetuadoMat(Pagamentos id) {
	String del = "delete from Matricula where id = ?";
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(del);
		pst.setString(1, id.getId());
		pst.executeUpdate();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
public void PagamentoNaoefetuado2(Pagamentos id) {
	String del = "delete from RegistrodeCompras where id = ?";
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(del);
		pst.setString(1, id.getId());
		pst.executeUpdate();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
public void AtualizaroStatus(Pagamentos pg) {
	String confirm = "update RegistrodeCompras  set statusdaCompra = 'Pagamento Confirmado' where id = ?";
	
	try {
		Connection con = conn.createConnectionMysql();
		PreparedStatement pst = con.prepareStatement(confirm);
		pst.setString(1,pg.getId());
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
}

	

}
