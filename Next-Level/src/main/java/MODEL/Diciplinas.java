package MODEL;

public class Diciplinas {

	private String id_diciplina;
	private String nome;
	
	
	
	public Diciplinas(String id_dilina, String nome) {
		super();
		this.id_diciplina= id_dilina;
		this.nome = nome;
	}

	public Diciplinas() {
		super();
		
	}
	
	public String getId_diciplina() {
		return id_diciplina;
	}
	public void setId_diciplina(String id_dilina) {
		this.id_diciplina = id_dilina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
