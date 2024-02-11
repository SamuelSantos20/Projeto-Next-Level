package MODEL;



public class JavaBeans implements IDS , EmailSenha{
	private String idcon;
	private String email;
	private String senha;
	
	
	
	public JavaBeans(String id, String email , String senha) {
		super();
		this.email = email;
		this.senha = senha;
		this.idcon = id;
	}

	public JavaBeans() {
		super();

	}
	
		@Override
	public void id(String id) {
		this.idcon = id;
	}

	@Override
	public String id() {
		
		return idcon;
	}

	@Override
	public void setsenha(String senha) {
		this.senha = senha;
		
	}

	@Override
	public String getsenha() {
		
		return senha;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
		
		
	}

	@Override
	public String getEmail() {

		return email;
	}

}
