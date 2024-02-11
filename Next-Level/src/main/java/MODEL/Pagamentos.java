package MODEL;

public class Pagamentos{
	// (nome,cpf , cep , rg , curso  , turno , valor , metododepagamento , statusdaCompra)
private String id;	
private String nome;
private long cpf;
private String curso;
private double valor;
private String statusdacompra;
private String datacompra;
private String metodopagamentos;
private String DateVencimento;









public String getDateVencimento() {
	return DateVencimento;
}





public void setDateVencimento(String dateVencimento) {
	DateVencimento = dateVencimento;
}





public Pagamentos(String id, String nome, long cpf, String curso, double valor,
		String statusdacompra, String datacompra, String metodopagamentos) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.curso = curso;
	this.valor = valor;
	this.statusdacompra = statusdacompra;
	this.datacompra = datacompra;
	this.metodopagamentos = metodopagamentos;
}





public Pagamentos() {
	super();
	
}





public String getMetodopagamentos() {
	return metodopagamentos;
}




public void setMetodopagamentos(String metodopagamentos) {
	this.metodopagamentos = metodopagamentos;
}




public String getDatacompra() {
	return datacompra;
}




public void setDatacompra(String datacompra) {
	this.datacompra = datacompra;
}

public String getId() {
	return id;
}




public void setId(String id) {
	this.id = id;
}




public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public long getCpf() {
	return cpf;
}
public void setCpf(long cpf) {
	this.cpf = cpf;
}

public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}

public String getStatusdacompra() {
	return statusdacompra;
}
public void setStatusdacompra(String statusdacompra) {
	this.statusdacompra = statusdacompra;
}

}
