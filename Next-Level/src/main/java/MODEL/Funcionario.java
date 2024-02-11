package MODEL;

public class Funcionario implements EmailSenha{
   private String  usuario;
   private String senha;
public Funcionario(String usuario, String senha) {
	super();
	this.usuario = usuario;
	this.senha = senha;
}
public Funcionario() {
	super();
	
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
	this.usuario = email;
	
}
@Override
public String getEmail() {
	
	return usuario;
}

   
}
