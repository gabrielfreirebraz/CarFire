package carfire.web.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncoesData {

	public static String dataAtual(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date());
	}
	
	public static String horaAtual(){
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		return hourFormat.format(new Date());
	}
}
