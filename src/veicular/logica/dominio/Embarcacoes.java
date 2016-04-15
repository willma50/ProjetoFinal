package veicular.logica.dominio;

public class Embarcacoes extends Veiculo{

	private static final double aliquota = 3.5;
	
	public Embarcacoes(String descricao, String placa,
			int anoFabricacao, double  valorCompra) {
		super(descricao, placa, anoFabricacao, valorCompra);
	}

	@Override
	public double setImpostoDevido() {
		return Embarcacoes.aliquota * this.getBaseCalculo();
	}

}
