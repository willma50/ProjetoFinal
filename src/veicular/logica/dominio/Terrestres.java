package veicular.logica.dominio;

public class Terrestres extends Veiculo{

	private static final double aliquota = 1.0; 
	
	public Terrestres(String placa, int anoFabricacao, double valorCompra, Proprietario proprietario) {
		super(placa, anoFabricacao, valorCompra, proprietario);
	}

	@Override
	public double setImpostoDevido() {
		return Terrestres.aliquota * this.getAnoFabricacao();
	}

}
