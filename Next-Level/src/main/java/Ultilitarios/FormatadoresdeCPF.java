package Ultilitarios;

public class FormatadoresdeCPF {

	
	
	public boolean isFormatted(String cpf) {
        // Implemente a lógica para verificar se o CPF está formatado
        // Exemplo simplificado: verifica se o CPF tem pontos e traço
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public String Desformatador(String cpf) {
        // Implemente a lógica para desformatar o CPF
        // Exemplo simplificado: remove pontos e traço
        return cpf.replaceAll("[\\.\\-]", "");
    }

    public boolean canBeFormatted(String cpf) {
        // Implemente a lógica para verificar se o CPF pode ser formatado
        // Exemplo simplificado: verifica se o CPF não está formatado e tem 11 dígitos
        return !isFormatted(cpf) && cpf.matches("\\d{11}");
    }
    
//Gera um cpf formatado 
    
    public String format(String cpf) {
        // Implemente a lógica para formatar o CPF
        // Exemplo simplificado: adiciona pontos e traço
    	if(canBeFormatted(cpf)==true) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    	}
    	return null;
    }

}
