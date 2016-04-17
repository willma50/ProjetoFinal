package veicular.logica.dominio;

import java.io.FileReader;
import java.util.Properties;

import veicular.init.InicioApp;
import veicular.logica.app.VeiculoLogicaIF;
import veicular.logica.persistencia.sql.DAFIndividualDaoSql;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.ui.VeiculoUIIF;

public class DAFIndividual {
	private long numDAFIndividual=0;
	private String placa;
	private int anoFabricacao;
	private String data;
	private int classe;
	private Double baseCalculo;
	private Double aliquota;
	private Double impostoDevido;

	public DAFIndividual(String placa, int anoFabricacao, String data, int classe, Double baseCalculo, Double aliquota, Double impostoDevido) {
		this.numDAFIndividual++;
		this.setPlaca(placa);
		this.setAnoFabricacao(anoFabricacao);
		this.setData(data);
		this.setClasse(classe);		
		this.setBaseCalculo(baseCalculo);
		this.setAliquota(aliquota);
		this.setImpostoDevido(impostoDevido);
		
	}

	public long getNumDAFIndividual() {
		return numDAFIndividual;
	}

	public void setNumDAFIndividual(long numDAFIndividual) {
		this.numDAFIndividual = numDAFIndividual;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public Double getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(Double baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}

	public Double getImpostoDevido() {
		return impostoDevido;
	}

	public void setImpostoDevido(Double impostoDevido) {
		this.impostoDevido = impostoDevido;
	}
	
	public String toString(){
		String imprime =  "Cod de emiss�o: " + this.numDAFIndividual + '\n';
		imprime+= "Placa :" + this.placa + "\n";
		imprime+= "Ano de fabrica��o :" + this.anoFabricacao + "\n";
		imprime+= "Data de pagamento: " + this.data + "\n";
		imprime+= "Classe do ve�culo" + this.classe + "\n";
		imprime+= "Base de calculo" +  this.baseCalculo + "\n";
		imprime+= "Aliquota :" + this.aliquota + "\n";
		imprime+= "Imposto :" + this.impostoDevido + "\n";
		
		return imprime;
	}

}



