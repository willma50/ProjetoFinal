package veicular.logica.dominio;

public class Adaptados extends Veiculo{

	public Adaptados(){
		super();
	}
	
	//isento
	@Override
	public double setImpostoDevido() {
		return 0;
	}

}
