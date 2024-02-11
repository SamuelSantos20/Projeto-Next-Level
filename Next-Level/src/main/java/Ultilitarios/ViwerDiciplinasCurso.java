package Ultilitarios;

public class ViwerDiciplinasCurso {

	private String curso;
	private String dciplinas;
	
	public ViwerDiciplinasCurso(String curso, String dciplinas) {
		super();
		this.curso = curso;
		this.dciplinas = dciplinas;
	}
	
	public ViwerDiciplinasCurso() {
		super();
		
	}
	
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDciplinas() {
		return dciplinas;
	}
	public void setDciplinas(String dciplinas) {
		this.dciplinas = dciplinas;
	}
	
	
	
	
	
}
