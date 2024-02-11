package MODEL;


public class matricula {
private String id_matricula;
private String matricula;
private String data;
private int id_Turma;
private int id_Aluno;
private int id_Curso;










public matricula(String id_matricula, String matricula, String data, int id_Turma, int id_Aluno, int id_Curso) {
	super();
	this.id_matricula = id_matricula;
	this.matricula = matricula;
	this.data = data;
	this.id_Turma = id_Turma;
	this.id_Aluno = id_Aluno;
	this.id_Curso = id_Curso;
}




public matricula() {
	super();
	
}




public String getId_matricula() {
	return id_matricula;
}
public void setId_matricula(String id_matricula) {
	this.id_matricula = id_matricula;
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}

public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}




public int getId_Turma() {
	return id_Turma;
}




public void setId_Turma(int id_Turma) {
	this.id_Turma = id_Turma;
}




public int getId_Aluno() {
	return id_Aluno;
}




public void setId_Aluno(int id_Aluno) {
	this.id_Aluno = id_Aluno;
}




public int getId_Curso() {
	return id_Curso;
}




public void setId_Curso(int id_Curso) {
	this.id_Curso = id_Curso;
}



}
