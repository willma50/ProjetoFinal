package veicular.logica.app;

import veicular.logica.dominio.DAFIndividual;
import veicular.logica.persistencia.sql.DAFIndividualDaoSql;

public class DAFIndividualLogica implements DAFIndividualLogicaIF{	
	
	
	
	public void imprimir(String placa) throws Exception{
		DAFIndividualDaoSql dafSql = new DAFIndividualDaoSql();
		DAFIndividual v = dafSql.buscarPlaca(placa);
		System.out.println(v.toString());
	}
	
	/*
	public static void main(String[] args) throws Exception {
        DAFIndividualLogica dafI= new DAFIndividualLogica();
		dafI.imprimir("pqr-123");
	}
*/
}
	