public class RoboBispo extends Robo {

	public RoboBispo() {
		super();
		this.name = "Bispo";
		this.maxNumCell = 2;
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
		return "+";
	}

}
