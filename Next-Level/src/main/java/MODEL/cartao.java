package MODEL;

public class cartao implements IDS {
private String id;
private String numerocartao;
private String nomecartao;
private String mesdeVencimnto;
private String AnoVencimento;
private String cvc; 








	public cartao() {
	super();
	
}

	public cartao(String id, String numerocartao, String nomecartao, String mesdeVencimnto, String anoVencimento,
		String cvc) {
	super();
	this.id = id;
	this.numerocartao = numerocartao;
	this.nomecartao = nomecartao;
	this.mesdeVencimnto = mesdeVencimnto;
	this.AnoVencimento = anoVencimento;
	this.cvc = cvc;
}

	public String getNumerocartao() {
	return numerocartao;
}

public void setNumerocartao(String numerocartao) {
	this.numerocartao = numerocartao;
}

public String getNomecartao() {
	return nomecartao;
}

public void setNomecartao(String nomecartao) {
	this.nomecartao = nomecartao;
}

public String getMesdeVencimnto() {
	return mesdeVencimnto;
}

public void setMesdeVencimnto(String mesdeVencimnto) {
	this.mesdeVencimnto = mesdeVencimnto;
}

public String getAnoVencimento() {
	return AnoVencimento;
}

public void setAnoVencimento(String anoVencimento) {
	AnoVencimento = anoVencimento;
}

public String getCvc() {
	return cvc;
}

public void setCvc(String cvc) {
	this.cvc = cvc;
}

	@Override
	public void id(String id) {
	this.id =  id;

	}

	@Override
	public String id() {
		
		return id;
	}

}
