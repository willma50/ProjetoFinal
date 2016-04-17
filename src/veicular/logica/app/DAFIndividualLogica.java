package veicular.logica.app;

import java.sql.SQLException;
import java.text.ParseException;

import veicular.logica.dominio.DAFIndividual;
import veicular.logica.persistencia.sql.DAFIndividualDaoSql;

public class DAFIndividualLogica implements DAFIndividualLogicaIF{	
	
	public void imprimir(String placa) throws ClassNotFoundException, SQLException, ParseException{
		DAFIndividualDaoSql dafSql = new DAFIndividualDaoSql();
		DAFIndividual v = dafSql.buscarPlaca(placa);
		System.out.println(v.toString());
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		DAFIndividualLogica DAFI = new DAFIndividualLogica();
		DAFI.imprimir("krt-123");
	}
}

