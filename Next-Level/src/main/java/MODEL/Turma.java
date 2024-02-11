package MODEL;

import java.util.Date;

public class Turma {
	
private String id;
private String sala;
private String turno;
private String data_inicio;
private String data_fim;








public Turma(String id, String sala, String turno, String data_inicio, String data_fim) {
	super();
	this.id = id;
	this.sala = sala;
	this.turno = turno;
	this.data_inicio = data_inicio;
	this.data_fim = data_fim;
}


public Turma() {
	super();
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTurno() {
	return turno;
}
public void setTurno(String turno) {
	this.turno = turno;
}
public String getSala() {
	return sala;
}
public void setSala(String sala) {
	this.sala = sala;
}


public String getData_inicio() {
	return data_inicio;
}


public void setData_inicio(String data_inicio) {
	this.data_inicio = data_inicio;
}


public String getData_fim() {
	return data_fim;
}


public void setData_fim(String data_fim) {
	this.data_fim = data_fim;
}



}