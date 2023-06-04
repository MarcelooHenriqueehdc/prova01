public class RoboRainha extends Robo {

	public RoboRainha() {
		super();
		this.name = "Rainha";
		this.maxNumCell = 4;
	}

	public void advance(int numCelulas) {
		Ypos += numCelulas;
		Xpos += numCelulas;
	}

	public void recede(int numCelulas) {
		Ypos -= numCelulas;
		Xpos -= numCelulas;
	}

	public String showSymbol() {
		return "Q";
	}

}
