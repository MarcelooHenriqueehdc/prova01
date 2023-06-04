import java.util.ArrayList;

public class Plane {

	int width;
	int height;
	public ArrayList<Cell> cellList;

	public Plane(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void buildPlane() {
		cellList = new ArrayList<Cell>();

		int counter = 1;
		for (int j = height; j >= 1; j--) {
			for (int i = 1; i <= width; i++) {
				Cell cell = new Cell(counter, i, j);
				counter++;
				cellList.add(cell);
			}
		}
	}
	
	public void showPlane() {
		int cont = 0;

		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				System.out.print(cellList.get(cont).showCell());
				cont++;
			}
			System.out.print("\n");
		}
	}
	
	public Cell showSpecificCell(int x, int y) {

		for (int i = 0; i < cellList.size(); i++) {
			if (cellList.get(i).X == x && cellList.get(i).Y == y) {
				return cellList.get(i);
			}
		}
		return null;
	}

	public void showCells() {
		for (int i = 0; i < cellList.size(); i++) {
			System.out.println(cellList.get(i).showCell());
		}
	}



}
