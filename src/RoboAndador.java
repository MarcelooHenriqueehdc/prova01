public class RoboAndador extends Robo {
	
	public RoboAndador() {
		super();
		this.name = "Andador";
		this.maxNumCell = 0;
	}

	public void advance(int numCelulas) {
		Ypos += numCelulas;
	}

	public void recede(int numCelulas) {
		Ypos -= numCelulas;
	}
	
	public String showSymbol() {
		return "r";
	}
}
