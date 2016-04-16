package veicular.logica.app;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import veicular.funcoes.FuncoesData;
import veicular.logica.dominio.Aeronave;
import veicular.logica.dominio.Embarcacoes;
import veicular.logica.dominio.Proprietario;
import veicular.logica.dominio.Terrestres;
import veicular.logica.dominio.Veiculo;
import veicular.logica.persistencia.sql.ProprietarioDaoIF;
import veicular.logica.persistencia.sql.ProprietarioDaoSql;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.logica.persistencia.sql.VeiculoDaoSql;


public class VeiculoLogica implements VeiculoLogicaIF{
	
	private VeiculoDaoIF veiculoDao;
	private ProprietarioDaoIF ProprietarioDao;
	private FuncoesData funcao;

	@Override
	public void addVeiculo(String placa, int anoFabricacao, int classe, double valorCompra, String nomeProprietario) throws Exception {
		
		if(classe == 0)
			this.addAeronave(placa, anoFabricacao, valorCompra, nomeProprietario);
		if(classe == 1)
			this.addEmbarcacoes(placa, anoFabricacao, valorCompra, nomeProprietario);
		if(classe == 2)
			this.addTerrestres(placa, anoFabricacao, valorCompra, nomeProprietario);
			
	}
	
	public void addAeronave(String placa, int anoFabricacao, double valorCompra, String nomeProprietario) throws Exception{
		this.veiculoDao = new VeiculoDaoSql();
		this.ProprietarioDao = new ProprietarioDaoSql();
		Proprietario proprietario = this.ProprietarioDao.findByNome(nomeProprietario);
		Aeronave aeronave = new Aeronave(placa, anoFabricacao, valorCompra, proprietario);
		System.out.println("anos: "+aeronave.getBaseCalculo());
		this.veiculoDao.salvar(aeronave);
		
	}
	
	public void addEmbarcacoes(String placa, int anoFabricacao, double valorCompra, String nomeProprietario) throws Exception{
		this.veiculoDao = new VeiculoDaoSql();
		this.ProprietarioDao = new ProprietarioDaoSql();
		Proprietario proprietario = this.ProprietarioDao.findByNome(nomeProprietario);
		Embarcacoes embarcacoes = new Embarcacoes(placa, anoFabricacao, valorCompra, proprietario);
		System.out.println("base de calculo: "+embarcacoes.getBaseCalculo());
		this.veiculoDao.salvar(embarcacoes);
	}	
	
	
	public void addTerrestres(String placa, int anoFabricacao, double valorCompra, String nomeProprietario) throws Exception {
		this.veiculoDao = new VeiculoDaoSql();
		this.ProprietarioDao = new ProprietarioDaoSql();
		Proprietario proprietario = this.ProprietarioDao.findByNome(nomeProprietario);
		Terrestres terrestre = new Terrestres(placa, anoFabricacao, valorCompra, proprietario);
		System.out.println("base : "+terrestre.getBaseCalculo());
		this.veiculoDao.salvar(terrestre);
	}
	
	@Override
	public Collection<String> findAll() throws Exception { 
		Collection<Veiculo> veiculo = this.veiculoDao.findAll();
		Set<String> placaVeiculo = new HashSet<String>();
		Iterator<Veiculo> itVeiculo = veiculo.iterator();
		
		while(itVeiculo.hasNext()){
			placaVeiculo.add(itVeiculo.next().getPlaca());
		}
		
		return placaVeiculo;
	}

	@Override
	public void setPersistencia(VeiculoDaoIF veiculoDAO) {
		this.veiculoDao = veiculoDAO;
		
	}

	@Override
	public void removerVeiculo(String placa) throws Exception {
		this.veiculoDao.remove(placa);
	}

	@Override
	public int buscaAno() {	
		return (new FuncoesData().getAno());
	}

}
