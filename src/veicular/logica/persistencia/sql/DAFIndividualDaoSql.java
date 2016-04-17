package veicular.logica.persistencia.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import veicular.logica.persistencia.sql.DBDAO;
import veicular.funcoes.FuncoesData;
import veicular.logica.dominio.DAFIndividual;
import veicular.logica.dominio.Veiculo;


public class DAFIndividualDaoSql extends DBDAO{
		
		private static final String FINDBYPLACA = "select CLASSE, PLACA, ANOFABRICACAO, valorCompra from veiculo where PLACA = ?";
		
		public DAFIndividual buscarPlaca(String placa) throws ClassNotFoundException, Exception, SQLException, ParseException {
			DAFIndividual dafI = null;
			VeiculoDaoIF VSql = new VeiculoDaoSql();
			Veiculo v = VSql.findByPlaca(placa);
			
			Double aliquota = v.getAliquota();
			Double baseCalculo = v.getBaseCalculo();
			Double impostoDevido = v.getimpostoDevido();
			Connection conn = this.getConnection();
			PreparedStatement pstam = conn.prepareStatement(FINDBYPLACA);
			pstam.setString(1, placa);
			ResultSet rs = pstam.executeQuery();
			if(rs.next()){
				String data=FuncoesData.getDate();
				int classe = rs.getInt("CLASSE");
				int anoFabricacao = rs.getInt("ANOFABRICACAO");
				dafI = new DAFIndividual(placa, anoFabricacao, data, classe, baseCalculo, aliquota, impostoDevido);
			}	
			
			//
				
			rs.close();
			pstam.close();
			conn.close();
		    
			return dafI;
		} 

}
