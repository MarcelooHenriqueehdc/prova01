import java.util.ArrayList;

public class Cell {

	public int X;
	public int Y;
	public int id;
	public ArrayList<Positional> objects;

	public Cell(int id, int x, int y) {
		this.X = x;
		this.Y = y;
		this.id = id;
		objects = new ArrayList<>();
	}
	
	public void remove(Positional toRemove) {
		if (this.objects.size() > 0) {
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) == toRemove) {
					objects.remove(i);
					break;
				}
			}
		}
	}

	public void removeFirst() {
		if (this.objects.size() > 0) {
			objects.remove(0);
		}
	}


	public void add(Positional elemento) {
		this.objects.add(elemento);
	}


	public String showCell() {
		if (objects.size() > 0) {
			if (objects.size() > 1) {
				return "|@|";
			} else {
				return "|" + this.objects.get(objects.size() - 1).showSymbol() + "|";
			}
		} else {
			return "| |";
		}
	}
}
