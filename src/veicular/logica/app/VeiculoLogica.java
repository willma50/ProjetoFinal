package veicular.logica.app;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import veicular.logica.dominio.Aeronave;
import veicular.logica.dominio.Embarcacoes;
import veicular.logica.dominio.Terrestres;
import veicular.logica.dominio.Veiculo;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.logica.persistencia.sql.VeiculoDaoSql;


public class VeiculoLogica implements VeiculoLogicaIF{
	
	private VeiculoDaoIF VeiculoDao;

	@Override
	public void addVeiculo(String descricao, String placa, int anoFabricacao, int classe) throws Exception {
		
		if(classe == 0)
			this.addAeronave(descricao, placa, anoFabricacao);
		if(classe == 1)
			this.addEmbarcacoes(descricao, placa, anoFabricacao);
		if(classe == 2)
			this.addTerrestres(descricao, placa, anoFabricacao);
			
	}
	
	public void addAeronave(String descricao, String placa,
			int anoFabricacao) throws Exception{
		this.VeiculoDao = new VeiculoDaoSql();
		Aeronave aeronave = new Aeronave(descricao, placa, anoFabricacao);
		this.VeiculoDao.salvar(aeronave);
		
	}
	
	public void addEmbarcacoes(String descricao, String placa, int anoFabricacao) throws Exception{
		this.VeiculoDao = new VeiculoDaoSql();
		Embarcacoes embarcacoes = new Embarcacoes(descricao, placa, anoFabricacao);
		System.out.println(descricao);
		this.VeiculoDao.salvar(embarcacoes);
	}	
	
	
	public void addTerrestres(String descricao, String placa, int anoFabricacao) throws Exception {
		this.VeiculoDao = new VeiculoDaoSql();
		Terrestres terrestre = new Terrestres(descricao, placa, anoFabricacao);
		this.VeiculoDao.salvar(terrestre);
	}
	
	@Override
	public Collection<String> findAll() throws Exception { 
		Collection<Veiculo> veiculo = this.VeiculoDao.findAll();
		Set<String> placaVeiculo = new HashSet<String>();
		Iterator<Veiculo> itVeiculo = veiculo.iterator();
		
		while(itVeiculo.hasNext()){
			placaVeiculo.add(itVeiculo.next().getPlaca());
		}
		
		return placaVeiculo;
	}

	@Override
	public void setPersistencia(VeiculoDaoIF veiculoDAO) {
		this.VeiculoDao = veiculoDAO;
		
	}

	@Override
	public void removerVeiculo(String placa) throws Exception {
		this.VeiculoDao.remove(placa);
	}

}
