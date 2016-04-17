package veicular.logica.app;

import java.sql.SQLException;
import java.text.ParseException;

public interface DAFIndividualLogicaIF {
	public void imprimir(String placa) throws ClassNotFoundException, SQLException, ParseException;

}
