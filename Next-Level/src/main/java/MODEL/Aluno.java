package MODEL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;

public class Aluno implements IDS{

	
	protected String idcon;
	private String nome;
	private String cpf;
	private String genero;
	private String cidade;
	private String estado;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private String datadeNacimento;
	private String rg;
	private String cep;	
    private String statusaluno;
    private String senha;
    private String telefone;
    
    
	private double valorParaBoleto;
	
	
	
	
	
	
	
	
	

	
	

	



	public Aluno(String idcon, String nome, String cpf, String genero, String cidade, String estado, String bairro,
			String rua, String numero, String complemento, String datadeNacimento, String rg, String cep,
			String statusaluno, String senha, String telefone) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.datadeNacimento = datadeNacimento;
		this.rg = rg;
		this.cep = cep;
		this.statusaluno = statusaluno;
		this.senha = senha;
		this.telefone = telefone;
	}



	public Aluno() {
		super();
		
	}

	

	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	private double getValorParaBoleto() {
		return valorParaBoleto;
	}



	public void setValorParaBoleto(double valorParaBoleto) {
		this.valorParaBoleto = valorParaBoleto;
	}



	public String getStatusaluno() {
		return statusaluno;
	}



	public void setStatusaluno(String statusaluno) {
		this.statusaluno = statusaluno;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDatadeNacimento() {
		return datadeNacimento;
	}

	public void setDatadeNacimento(String datadeNacimento) {
		this.datadeNacimento = datadeNacimento;
	}
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	
	
	

	@Override
	public void id(String id) {
		this.idcon =  id;
		
		
	}


	@Override
	public String id() {
		
		return idcon;
	}



		
		// Defina a data atual como a data de criação do boleto
	    Date dataDeCriacao = new Date();

	    // Defina a quantidade de dias para o vencimento (por exemplo, 7 dias)
	    int diasParaVencimento = 14;

	    // Calcule a data de vencimento
	    long milissegundosParaVencimento = dataDeCriacao.getTime() + TimeUnit.DAYS.toMillis(diasParaVencimento);
	    Date dataDeVencimento = new Date(milissegundosParaVencimento);

public String DataPrazo() {
	return String.valueOf(dataDeVencimento);
}
	    
	    //Vencimento funcionando Perfeitamente
		
		
	    //3 Bacos Testados = Banco do Brasil , Bradesco , Itau
	    
	    public BoletoViewer  gerarBoleto() {

			
			Cedente cedente = new Cedente("Next-Level" , "123.456.789-09");//Nossa Empresa que está 
		                         											//disponibilizando  o Boleto
			
		Sacado sacado = new Sacado(getNome() ,cpf);//O Cpf deve conter 11 digitos e deve conter apenas numeros sem caracteres
		//Cliente que esta gerando o Boleto 
		Endereco endereco = new Endereco();//Instacia da classe para pegar os Endereços                       
		endereco.setBairro(getBairro());//Basirro
		endereco.setCep(getCep());//Cep
		endereco.setComplemento(getComplemento()); // Complemento	
		endereco.setLocalidade(getCidade()); //Nome da Cidade
		endereco.setLogradouro(getRua()); // Rua
		endereco.setNumero(getNumero()); // Numero
		endereco.setPais("Brasil"); // Pais
		endereco.setUF(UnidadeFederativa.RJ ); // Unidade Federativa(Estado)

		sacado.addEndereco(endereco);//Adiciona os dados de endereço ao Sacado

		ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_DO_BRASIL.create());

		contaBancaria.setNumeroDaConta(new NumeroDaConta(56789349, "2"));//Para o banco Santader aqui deve ter 6 digitos apenas
																		//Para o Itau aqui deve ter 5 digitos 
		            													//Banco do Bradesco  = 6
																		//Banco do Brasil  = 8
		
		contaBancaria.setCarteira(new Carteira(30));//Banco do Brasil =30 /Banco Bradesco = até 99 / Itau  = 30
		                                             //
		contaBancaria.setAgencia(new Agencia(9876, "1")); 	

	 
		Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
		titulo.setNumeroDoDocumento("123456");
		titulo.setNossoNumero("14243256256");// Bradesco = Aqui o numero deve ter no maximo até 11 numeros
		                                     //Banco do Brasil = deve ter no maximo até 11
		                                     // Banco do Itau = 8
		                               
		titulo.setValor(BigDecimal.valueOf(getValorParaBoleto()));
		titulo.setDataDoDocumento(new Date());
		titulo.setDataDoVencimento(dataDeVencimento);//Data de vencimento do Boleto
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(Titulo.EnumAceite.A);
		//titulo.setAcrecimo(null);//caso haja algum acrecimo
		//titulo.setDesconto(null);//Para gerar algum desconto
		//titulo.setMora(null);//Juros para algum local de moaradia
		//titulo.setTipoDeMoeda(null);//Para definir o tipo de moeda que sera utilizada
		//titulo.setValorCobrado(null);//Aqui pode-se definir um valor cobrado e ja ira sair automaticamente no boleto bancario
		
		org.jrimum.bopepo.Boleto boletos = new org.jrimum.bopepo.Boleto(titulo); 

		boletos.setLocalPagamento("Em qualquer Banco até o vencimento");
		boletos.setInstrucaoAoSacado("Mensagem para o sacado");
		boletos.setInstrucao1("Intruções (Texto de Responsabilidade do Beneficiario)");
		boletos.setInstrucao2("");
		boletos.setInstrucao3("Após o vencimento Cobrar:");
		boletos.setInstrucao4("Multa: R$30.");
		boletos.setInstrucao5("Juros: R$ 0,15 ao dia.");
		
		BoletoViewer boletovisao = new BoletoViewer(boletos);
		return new BoletoViewer(boletos);
		
		
		}


	    
	    
	   

}
