public class RoboRainha extends Robo {

	public RoboRainha() {
		super();
		this.nome = "Rainha";
		this.id = 7;
	}

	public String mostrar() {
		return "Q";
	}

	public void avancar(int numCelulas) {
		posicaoY += numCelulas;
		posicaoX += numCelulas;
	}

	public void retroceder(int numCelulas) {
		posicaoY -= numCelulas;
		posicaoX -= numCelulas;
	}

}
