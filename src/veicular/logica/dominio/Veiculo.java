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
