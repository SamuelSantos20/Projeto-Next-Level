package Ultilitarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatadordeData {
	
	    public String formatarDataPadraoBrasileiro(Date data) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));
	        return sdf.format(data);
	    }
	    
	    /* METODO PARA A FORMATAÇÃO DA DATA DE NASCIMENTO */

		
		public String formatarData(String dataStr) {
			SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

			try {
				Date data = formatoEntrada.parse(dataStr);

				return formatoSaida.format(data);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

		// reverter
		public static String formatarDatareverso(String dataStr) {
			SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date data = formatoEntrada.parse(dataStr);

				return formatoSaida.format(data);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

	    
	    
	    
	    
	}


