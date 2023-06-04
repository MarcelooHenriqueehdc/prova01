public class RoboCavalo extends Robo {

	public RoboCavalo() {
		super();
		this.name = "Cavalo";
		this.maxNumCell = 2;
	}

	public void advance(int numCelulas) {
		Ypos += numCelulas;
		Xpos += numCelulas;
	}

	public void recede(int numCelulas) {
		Ypos += numCelulas;
		Xpos -= numCelulas;
	}

	public String showSymbol() {
		return "c";
	}

}
