
public class MapShip {

	public boolean isWin = false;
	public int whosWIn;
	public int currentPlayer = 1;
	
	public int currentX;
	public int currentY;
	
	private String mapShip[][] = {
			{"A0", "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "J2", "J2", "J2", "J2", "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "J1", "A0",  "A0",  "A0",  "A0"},
			{"A0", "J1", "J1", "J1", "A0",  "J1", "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "J1", "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "J1", "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "A0"},
			{"A0", "A0",  "A0",  "A0",  "A0",  "A0",  "A0",  "J2", "J2", "J2"},
	};
	
	private int mapHit[][] = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	};

	public MapShip() {
	}
	
	public void showMap() {
		System.out.println("  0  1  2  3  4  5  6  7  8  9");
		for (int line=0; line<10; line++) {
			System.out.print(line + " ");
			for (int col=0; col<10; col++) {
				if (mapHit[line][col]==0) {
					System.out.print("NH ");
				} else {
					System.out.print(mapShip[line][col] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public int isValidMove () {
		// Verifica se a posição já foi acertada
		if (mapHit[currentX][currentY]==1) {
			return 1;
		}
		
		// Verifica se o jogador atirou no próprio barco
		if (currentPlayer==1) {
			if (mapShip[currentX][currentY]=="J1") {
				return 2;
			}
		} else {
			if (mapShip[currentX][currentY]=="J2") {
				return 2;
			}
		}
		
		return 0;
	}
	
	public void makeMove() {
		mapHit[currentX][currentY] = 1;
		if (currentPlayer==1) {
			currentPlayer = 2;
		} else {
			currentPlayer = 1;
		}
	}
	
	public void ifWin() {
		boolean j1Win = true;
		boolean j2Win = true;
		
		for(int x = 0; x<10; x++) {
			for(int y = 0; y<10; y++) {
				if (mapShip[x][y] == "J2" && mapHit[x][y] == 0) {
					j1Win = false;
				}
				
				if (mapShip[x][y] == "J1" && mapHit[x][y] == 0) {
					j2Win = false;
				}
			}
		}
		
		if(j1Win==true) {
			isWin = true;
			whosWIn = 1;
		} else if (j2Win==true) {
			isWin = true;
			whosWIn = 2;
		}
	}

}
