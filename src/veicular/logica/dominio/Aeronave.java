package veicular.logica.dominio;

public class Aeronave extends Veiculo{

	private static final double aliquota = 2.5;
	
	public Aeronave(String placa,
			int anoFabricacao, double  valorCompra, Proprietario proprietario) {
		super(placa, anoFabricacao, valorCompra, proprietario);
	}

	@Override
	public double setImpostoDevido() {
		return Aeronave.aliquota * this.getBaseCalculo();
	}

}
