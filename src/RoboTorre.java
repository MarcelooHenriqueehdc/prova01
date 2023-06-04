public class RoboTorre extends Robo {

	public RoboTorre() {
		super();
		this.name = "Torre";
		this.maxNumCell = 2;
	}

	public void advance(int numCelulas) {
		Ypos += numCelulas;
	}

	public void recede(int numCelulas) {
		Ypos -= numCelulas;
	}

	public String showSymbol() {
		return "T";
	}

}
