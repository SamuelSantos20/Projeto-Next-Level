package MODEL;

public class Diciplina_Curso {
private String iddiciplina_curso;
private int id_diciplina;
private int id_curso;




public Diciplina_Curso(String iddiciplina_curso, int id_diciplina, int id_curso) {
	super();
	this.iddiciplina_curso = iddiciplina_curso;
	this.id_diciplina = id_diciplina;
	this.id_curso = id_curso;
}

public Diciplina_Curso() {
	super();
	
}


public String getIddiciplina_curso() {
	return iddiciplina_curso;
}
public void setIddiciplina_curso(String iddiciplina_curso) {
	this.iddiciplina_curso = iddiciplina_curso;
}
public int getId_diciplina() {
	return id_diciplina;
}
public void setId_diciplina(int id_diciplina) {
	this.id_diciplina = id_diciplina;
}
public int getId_curso() {
	return id_curso;
}
public void setId_curso(int id_curso) {
	this.id_curso = id_curso;
}


}
