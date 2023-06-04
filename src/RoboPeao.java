public class RoboPeao extends Robo {

	public RoboPeao() {
		super();
		this.name = "Peao";
		this.maxNumCell = 1;
	}

	public void advance(int numCelulas) {
		Xpos++;
	}

	public void recede(int numCelulas) {
		Xpos--;
	}

	public String showSymbol() {
		return "#";
	}
}
