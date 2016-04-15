package veicular.logica.dominio;


public abstract class Veiculo {
	
	private int id;
	private String descricao;
	private String placa;
	private int anoFabricacao;
	
	public Veiculo(){
		
	}
	
	public Veiculo(String descricao, String placa, int anoFabricacao){
		this.setDescricao(descricao);
		this.setPlaca(placa);
		this.setAnoFabricacao(anoFabricacao);		
	}
	
	public abstract double setImpostoDevido();
	
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
