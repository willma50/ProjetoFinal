package veicular.logica.dominio;

public class Aeronave extends Veiculo{

	private static final double aliquota = 2.5;
	
	public Aeronave(String descricao, String placa,
			int anoFabricacao, double  valorCompra) {
		super(descricao, placa, anoFabricacao, valorCompra);
	}

	@Override
	public double setImpostoDevido() {
		return Aeronave.aliquota * this.getBaseCalculo();
	}

}
