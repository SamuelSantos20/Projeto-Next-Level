package Ultilitarios;

public class ViwerMatriculados {
private String  nome;
private String curso;
private String sala;




public ViwerMatriculados(String nome, String curso, String sala) {
	super();
	this.nome = nome;
	this.curso = curso;
	this.sala = sala;
}


public ViwerMatriculados() {
	super();
	
}




public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}
public String getSala() {
	return sala;
}
public void setSala(String sala) {
	this.sala = sala;
}


}
