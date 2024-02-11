package Ultilitarios;

import java.text.DecimalFormat;

public class FormatadordeDinheiro {

	public String formatarComoMoeda(double valor) {
	    DecimalFormat formatoMoeda = new DecimalFormat("R$ #,##0.00");
	    return formatoMoeda.format(valor);
	}
}
