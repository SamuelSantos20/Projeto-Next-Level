package Ultilitarios;

import java.util.Random;

public class Geradordematricula {

	
	 public String gerarMatricula() {
	        int tamanhoMatricula = 12; // Tamanho fixo da matrícula
	        String matricula = "";
	        Random random = new Random();

	        for (int i = 0; i < tamanhoMatricula; i++) {
	            matricula += random.nextInt(10);
	        }

	        return matricula;
	    }
	 
	   
}
