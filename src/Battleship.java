import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		
		final MapShip mapShip = new MapShip();
		Scanner r = new Scanner(System.in);
		
		while (mapShip.isWin==false) {
			mapShip.showMap();
			
			if (mapShip.currentPlayer==1) {
				System.out.println("Jogador 1, fa�a sua jogada");
			} else {
				System.out.println("Jogador 2, fa�a sua jogada");
			}
		
			int isValidMove = -1;
			do {
				if (isValidMove!=-1) {
					if (isValidMove==1) {
						System.out.println("Campo j� destru�do, selecione outra coordenada");
					} else {
						System.out.println("Voc� n�o pode atirar no seu pr�prio barco, selecione outra coordenada");
					}
				}
				
				System.out.print("Informe a linha: ");
				mapShip.currentX = r.nextInt();
				
				System.out.println("Informe a coluna: ");
				mapShip.currentY = r.nextInt();
				
				isValidMove = mapShip.isValidMove();
			} while (isValidMove!=0);
			
			mapShip.makeMove();
			mapShip.ifWin();
		}
		
		System.out.println("Parab�ns, o jogador "+ mapShip.whosWIn + " ganhou!!");
		
	}

}
