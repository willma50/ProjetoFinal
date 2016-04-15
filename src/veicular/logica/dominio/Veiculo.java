package veicular.logica.dominio;

import veicular.funcoes.FuncoesData;

public abstract class Veiculo {
	
	private int id;
	private String descricao;
	private String placa;
	private int anoFabricacao;
	private double valorCompra;
	
	private FuncoesData funcao;
	
	public Veiculo(){
		
	}
	
	public Veiculo(String descricao, String placa, int anoFabricacao, double valorCompra){
		this.setDescricao(descricao);
		this.setPlaca(placa);
		this.setAnoFabricacao(anoFabricacao);		
		this.setValorCompra(valorCompra);
	}
	
	public Veiculo(String descricao, String placa, int anoFabricacao){
		this.setDescricao(descricao);
		this.setPlaca(placa);
		this.setAnoFabricacao(anoFabricacao);		
	}
	
	public abstract double setImpostoDevido();
	
	public double getBaseCalculo(){
		//a base de cálculo é o valor de compra do bem, amortizado à taxa de 5% ao ano.
		//2014 - 2016 = 2anos  // pegar ano atual em java e fazer um while com o ano
		double base = 0;
		int i = 0;
		while(new FuncoesData().getAno() > i){
			base += this.getValorCompra() - (5/100);
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	
}
