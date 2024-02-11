package Ultilitarios;

public class FormatadordeCEP {

	    public String formatCEP(String cepNumber) {
	        // Verifica se o número do CEP é válido
	        if (cepNumber == null || cepNumber.length() != 8 || !cepNumber.matches("\\d+")) {
	            System.out.println("Número de CEP inválido");
	            return cepNumber; // Retorna o número original se for inválido
	        }

	        // Formata o número do CEP com hífen
	        return cepNumber.substring(0, 5) + "-" + cepNumber.substring(5);
	    }
	}


