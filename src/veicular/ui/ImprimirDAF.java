package veicular.ui;

import java.sql.SQLException;
import java.text.ParseException;

import veicular.logica.dominio.DAFIndividual;
import veicular.logica.persistencia.sql.DAFIndividualDaoSql;

public class ImprimirDAF{
	
	public void imprimir(String placa) throws ClassNotFoundException, SQLException, ParseException{
		DAFIndividualDaoSql fdg = new DAFIndividualDaoSql();
		DAFIndividual v = fdg.buscarPlaca(placa);
		v.toString();
	}
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
		ImprimirDAF i = new ImprimirDAF();
		i.imprimir("krt-123");
	
	}

}
