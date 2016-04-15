package veicular.logica.dominio;

public class Embarcacoes extends Veiculo{

	
	public Embarcacoes(String descricao, String placa,
			int anoFabricacao) {
		super(descricao, placa, anoFabricacao);
	}

	@Override
	public double setImpostoDevido() {
		// TODO Auto-generated method stub
		return 0;
	}

}
