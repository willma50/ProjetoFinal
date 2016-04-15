package veicular.logica.dominio;

public class Terrestres extends Veiculo{

	private static final double aliquota = 1.0; 
	
	public Terrestres(String descricao, String placa, int anoFabricacao, double valorCompra) {
		super(descricao, placa, anoFabricacao, valorCompra);
	}

	@Override
	public double setImpostoDevido() {
		return Terrestres.aliquota * this.getAnoFabricacao();
	}

}
