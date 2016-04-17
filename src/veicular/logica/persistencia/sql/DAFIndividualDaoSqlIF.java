package veicular.logica.persistencia.sql;

import java.sql.SQLException;
import java.text.ParseException;

import veicular.logica.dominio.DAFIndividual;

public interface DAFIndividualDaoSqlIF {

	public DAFIndividual buscarPlaca(String placa) throws ClassNotFoundException, SQLException, ParseException;

}
