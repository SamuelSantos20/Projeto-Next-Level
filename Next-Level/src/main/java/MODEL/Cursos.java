package MODEL;

import java.text.DecimalFormat;

public class Cursos implements IDS{
private String id;
private String nomeCurso;
private double valor;




public Cursos(String id, String nomeCurso, double valor) {
	super();
	this.id = id;
	this.nomeCurso = nomeCurso;
	this.valor = valor;
	
}


public Cursos() {
	super();
}


public double getValor() {
	return valor;
}

public String formatarComoMoeda(double valor) {
    DecimalFormat formatoMoeda = new DecimalFormat("R$ #,##0.00");
    return formatoMoeda.format(valor);
}

public void setValor(double valor) {
	this.valor = valor;
}



	public String getNomeCurso() {
	return nomeCurso;
}







public void setNomeCurso(String nomeCurso) {
	this.nomeCurso = nomeCurso;
}







	@Override
	public void id(String id) {
	     this.id = id;	
	}

	@Override
	public String id() {
	
		return id;
	}
	
	
	


}
