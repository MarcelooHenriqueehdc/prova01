public class RoboRei extends Robo {

	public RoboRei() {
		super();
		this.name = "Rei";
		this.maxNumCell = 4;
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
		return "R";
	}
}
