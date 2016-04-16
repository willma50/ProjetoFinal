package veicular.logica.dominio;

import veicular.funcoes.FuncoesData;

public abstract class Veiculo {
	
	private int id;
	private String placa;
	private int anoFabricacao;
	private double valorCompra;
	private Proprietario proprietario;
	
	private FuncoesData funcao;
	
	public Veiculo(){
		
	}
	
	public Veiculo(String placa, int anoFabricacao, double valorCompra, Proprietario proprietario){
		this.setPlaca(placa);
		this.setAnoFabricacao(anoFabricacao);		
		this.setValorCompra(valorCompra);
		this.proprietario = proprietario;
	}
	
	public Veiculo(String placa, int anoFabricacao){
		this.setPlaca(placa);
		this.setAnoFabricacao(anoFabricacao);		
	}
	
	public abstract double setImpostoDevido();
	
	public double getBaseCalculo(){
		double base = 0, valor = this.getValorCompra();
		int i = 0;
		int qtdAno = (new FuncoesData().getAno()) - this.getAnoFabricacao();
		while(qtdAno > i){
			base = valor - (valor * (0.05));
			valor = base;
			i++;
		}
		return base;
	}
	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	
}
