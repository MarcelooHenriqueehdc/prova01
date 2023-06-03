
public class RoboCavalo extends Robo {

	public RoboCavalo() {
		super();
		this.nome = "Cavalo";
		this.id = 5;
	}

	public String mostrar() {
		return "c";
	}

	public void avancar(int numCelulas) {
		posicaoY += numCelulas;
		posicaoX += numCelulas;
	}

	public void retroceder(int numCelulas) {
		posicaoY += numCelulas;
		posicaoX -= numCelulas;
	}

}
