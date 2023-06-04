public abstract class Robo implements Positional {

	public String name;
	public int id;
	public int Xpos = 1;
	public int Ypos = 1;
	public int pontuation = 0;
	public int maxNumCell = 0;

	public void alunoColision() {
		pontuation = pontuation + 10;
	}

	public void bugColision() {
		pontuation = pontuation - 15;
	}

	public int getType() {
		return 100;
	}

	public abstract void advance(int cellsNum);

	public abstract void recede(int cellsNum);

}