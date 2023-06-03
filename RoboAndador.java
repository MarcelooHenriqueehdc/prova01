public class RoboAndador extends Robo {

	public RoboAndador() {
		super();
		this.nome = "Andador";
		this.id = 1;
	}

	public String mostrar() {
		return "r";
	}

	public void avancar(int numCelulas) {
		posicaoY += numCelulas;
	}

	public void retroceder(int numCelulas) {
		posicaoY -= numCelulas;
	}
}
