package veicular.logica.app;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import veicular.funcoes.FuncoesData;
import veicular.logica.dominio.Aeronave;
import veicular.logica.dominio.Embarcacoes;
import veicular.logica.dominio.Terrestres;
import veicular.logica.dominio.Veiculo;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.logica.persistencia.sql.VeiculoDaoSql;


public class VeiculoLogica implements VeiculoLogicaIF{
	
	private VeiculoDaoIF VeiculoDao;
	private FuncoesData funcao;

	@Override
	public void addVeiculo(String descricao, String placa, int anoFabricacao, int classe, double valorCompra) throws Exception {
		
		if(classe == 0)
			this.addAeronave(descricao, placa, anoFabricacao, valorCompra);
		if(classe == 1)
			this.addEmbarcacoes(descricao, placa, anoFabricacao, valorCompra);
		if(classe == 2)
			this.addTerrestres(descricao, placa, anoFabricacao, valorCompra);
			
	}
	
	public void addAeronave(String descricao, String placa,
			int anoFabricacao, double valorCompra) throws Exception{
		this.VeiculoDao = new VeiculoDaoSql();
		Aeronave aeronave = new Aeronave(descricao, placa, anoFabricacao, valorCompra);
		System.out.println("anos: "+aeronave.getBaseCalculo());
		this.VeiculoDao.salvar(aeronave);
		
	}
	
	public void addEmbarcacoes(String descricao, String placa, int anoFabricacao, double valorCompra) throws Exception{
		this.VeiculoDao = new VeiculoDaoSql();
		Embarcacoes embarcacoes = new Embarcacoes(descricao, placa, anoFabricacao, valorCompra);
		System.out.println("base de calculo: "+embarcacoes.getBaseCalculo());
		this.VeiculoDao.salvar(embarcacoes);
	}	
	
	
	public void addTerrestres(String descricao, String placa, int anoFabricacao, double valorCompra) throws Exception {
		this.VeiculoDao = new VeiculoDaoSql();
		Terrestres terrestre = new Terrestres(descricao, placa, anoFabricacao, valorCompra);
		System.out.println("base : "+terrestre.getBaseCalculo());
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

	@Override
	public int buscaAno() {	
		return (new FuncoesData().getAno());
	}

}
