import java.util.Scanner;
import console.ConsoleTools;

public class Application {
	
	public static Scanner ext = new Scanner(System.in);
	public static ConsoleTools tools = new ConsoleTools();
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Cellule Map[][] = factory();
		Map = initialize(Map);
		welcome();
		
		//Map = userInputs(Map);
		
		print(Map);
		tools.pause();
		while (true) {
			Map = interaction(Map);
			print(Map);
			tools.pause();
		}
	}

	private static Cellule[][] userInputs(Cellule[][] map) {
		// TODO Auto-generated method stub
		System.out.println("\nInforme as coordenadas para inserir uma nova célula viva");
		int lin, col;
		String r = "s";
		
		do {
			System.out.print("Linha: "); lin = ext.nextInt(); 		
			System.out.print("Coluna: "); col = ext.nextInt();
			ext.nextLine();
			System.out.println();
			
			if (lin >= 0 && col >= 0 && lin < map.length && col < map[lin].length) map[lin][col].live();
			else System.out.println("Coordenadas fora da área!");
			
			System.out.println("Deseja inserir mais células? (S/N)");
			r = ext.nextLine();
			
			if( r.compareToIgnoreCase("n") != 0 && r.compareToIgnoreCase("s") != 0  )
				System.out.println("Opção inválida!");
		}while ( r.compareToIgnoreCase("n") != 0); 
		
		return map;
	}

	private static Cellule[][] initialize(Cellule[][] map) {
		// TODO Auto-generated method stub
		map[0][0].live();
		map[0][1].live();
		map[1][1].live();
		map[2][2].live();
		map[2][3].live();
		map[3][0].live();
		map[3][2].live();
		map[3][3].live();
		return map;
	}
	
	

	private static void print(Cellule[][] map) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print("[" + map[i][j] + "]");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
	}

	private static Cellule[][] interaction(Cellule[][] map) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Cellule[][] newMap = factory();
		
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[i].length; j++) {
				newMap[i][j] = (Cellule) map[i][j].clone();
			}
		}
		
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[i].length; j++) {
				int neighbors = countNeighborsAlive(map, i, j);
				
				if (map[i][j].getState() == State.ALIVE && !(neighbors == 2 || neighbors == 3)) {
					newMap[i][j].die();
				}
				else if (map[i][j].getState() == State.DEAD && neighbors == 3 ) {
					newMap[i][j].live();
				}
			}
		}		
		
		/*System.out.println("mapa antigo");
		print(map);
		
		System.out.println("mapa novo");
		print(newMap);*/
		
		
		return newMap;
			
	}
	
	private static Cellule[][] factory() {
		// TODO Auto-generated method stub
		Cellule map[][] = new Cellule[4][4];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Cellule();
			}
		}
		return map;
	}

	private static Cellule[][] process(Cellule[][] map, int i, int j) {
		
		int neighbors = countNeighborsAlive(map, i, j);
		
		if (map[i][j].getState() == State.ALIVE && !(neighbors == 2 || neighbors == 3)) {
			map[i][j].die();
		}
		else if (map[i][j].getState() == State.DEAD && neighbors == 3 ) {
			map[i][j].live();
		}
		
		return map;
	}

	private static Cellule[][] extinguish(Cellule[][] map) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int neighbors = countNeighborsAlive(map, i, j);
				
				if( map[i][j].getState() == State.ALIVE && !(neighbors == 2 || neighbors == 3) ) {
					map[i][j].die();				
				}
								
			}
		}
		
		return map;
	}

	private static Cellule[][] proliferate(Cellule[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int neighbors = countNeighborsAlive(map, i, j);
				
				if (map[i][j].getState() == State.DEAD && neighbors == 3 ) {
					map[i][j].live();
				}
				
			}
		}
		return map;
	}

	private static int countNeighborsAlive(Cellule[][] map, int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		int k, l;
		
		//checks northwest
		k = i -1; l = j -1;
		if ( k >= 0 && l >= 0 && map[k][l].getState() == State.ALIVE ) count++;
		
		//checks north
		k = i - 1; l = j;
		if ( k >= 0 && map[k][l].getState() == State.ALIVE) count++;
		
		//checks northeast
		k = i - 1; l = j + 1;
		if ( k >= 0 && l < map[i].length && map[k][l].getState() == State.ALIVE) count++;
		
		//checks west
		k = i; l = j - 1;
		if ( l >= 0 && map[k][l].getState() == State.ALIVE) count++;
		
		//checks east
		k = i; l = j + 1;
		if ( l < map[i].length && map[k][l].getState() == State.ALIVE) count++;
		
		//checks southwest
		k = i + 1; l = j - 1;
		if ( k < map.length && l >= 0 && map[k][l].getState() == State.ALIVE) count++;
		
		//checks south
		k = i + 1; l = j;
		if ( k < map.length && map[k][l].getState() == State.ALIVE) count++;
		
		//checks southeast
		k = i + 1; l = j + 1;
		if ( k < map.length && l < map[i].length && map[k][l].getState() == State.ALIVE) count++;
		
		return count;
	}

	
	public static void welcome() {
		System.out.println("Bem vindo ao Jogo da Vida!");
		System.out.println("Você pode criar células vivas dentro de uma area 40x40");
		System.out.println("O objetivo do jogo é distribuir as células de tal forma que elas sobrevivam e se proliferem.");
	}

	
}
