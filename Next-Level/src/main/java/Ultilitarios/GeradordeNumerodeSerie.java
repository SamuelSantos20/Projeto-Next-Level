package Ultilitarios;
import java.util.Random;

public class GeradordeNumerodeSerie {



	    public static void main(String[] args) {
	    	GeradordeNumerodeSerie g = new GeradordeNumerodeSerie();
	    	
	        String numeroSerieGerado = g.gerarNumeroSerie();
	        String senha = g.gerardordeSenha();
	        System.out.println("Número de Série Gerado: " + numeroSerieGerado);
	        System.out.println(senha);
	        
	    }

	    
	    public  String gerarNumeroSerie() {
	        Random random = new Random();
	        String numeroSerie = "";

	        for (int i = 0; i < 12; i++) {
	            int digito = random.nextInt(10);
	            numeroSerie += digito;
	        }

	        return numeroSerie;
	    }
	





public  String gerardordeSenha() {
	Random random = new Random();
	String numeroSerie = "";
	
	for (int i = 0; i < 6; i++) {
		int digito = random.nextInt(4);
		numeroSerie += digito;
	}
	
	return "NextLevel"+numeroSerie;
}
}


