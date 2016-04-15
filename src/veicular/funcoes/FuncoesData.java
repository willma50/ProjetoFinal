package veicular.funcoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FuncoesData {

	public String getDate() throws ParseException{
		
		Date data1 = new Date(System.currentTimeMillis()); // teste1
		
		Date data2 = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); //teste2
		System.out.print(formatarDate.format(data2));
		
		String data = new java.text.SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());//teste3 
		
		return data;
	}
	
	public int getAno(){
		Calendar c = Calendar.getInstance(); //teste4
		return Calendar.DAY_OF_YEAR;
	}
	
	//dataAtual = new java.text.SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());
}
