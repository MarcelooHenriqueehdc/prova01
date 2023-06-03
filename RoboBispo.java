
public class RoboBispo extends Robo {

	public RoboBispo() {
		super();
		this.nome = "Bispo";
		this.id = 4;
	}

	public String mostrar() {
		return "+";
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
