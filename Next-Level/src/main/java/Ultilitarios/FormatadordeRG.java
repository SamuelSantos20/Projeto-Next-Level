package Ultilitarios;

public class FormatadordeRG {
	    public String formatRG(String rgNumber) {
	        // Verifica se o número do RG é válido
	        if (rgNumber == null || rgNumber.length() != 9 || !rgNumber.matches("\\d+")) {
	            System.out.println("Número de RG inválido");
	            return rgNumber; // Retorna o número original se for inválido
	        }

	        // Formata o número do RG com pontos e traço
	        return rgNumber.substring(0, 2) + "." + rgNumber.substring(2, 5) + "." + rgNumber.substring(5, 8) + "-" + rgNumber.substring(8);
	    }
	}


