package veicular.logica.app;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import veicular.funcoes.FuncoesData;
import veicular.logica.dominio.DAFFrota;
import veicular.logica.dominio.Proprietario;
import veicular.logica.dominio.Veiculo;
import veicular.logica.persistencia.sql.VeiculoDaoSql;

public class DAFFrotaLogica implements DAFFrotaLogicaIF{

	
	public void imprimir(String numCSProprietario) throws Exception{
		
		ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();
		VeiculoDaoSql vSql = new VeiculoDaoSql();
		listVeiculos = vSql.findByProprietario(numCSProprietario);
		String data=FuncoesData.getDate();
		Double totalImposto; 
		VeiculoLogica vl = new VeiculoLogica();
		totalImposto = vl.valorTotalImpostoFrota(numCSProprietario);
		Iterator<Veiculo> itV = listVeiculos.iterator();
		ArrayList<String> placas = new ArrayList<String>();
		String aux;
		String proprietario = numCSProprietario;
		do{
	//		Proprietario p = itV.next().getProprietario();
//			p.setNome(numCSProprietario);
			Veiculo v =itV.next();
			aux = v.getPlaca() + "\n";
			placas.add(aux);
		}while(itV.hasNext());
					
		DAFFrota dafF = new DAFFrota(proprietario, placas, data, totalImposto); 
		
		System.out.println(dafF.toString());
	}
	

	

}
