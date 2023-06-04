import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public String userName;
	public int width;
	public int height;
	public int alunosNum;
	public int bugsNum;
	public Plane p;
	public GameManager manager;
	Scanner i = new Scanner(System.in);

	public RoboAndador andador = new RoboAndador();
	public RoboPeao peao = new RoboPeao();
	public RoboTorre torre = new RoboTorre();
	public RoboBispo bispo = new RoboBispo();
	public RoboCavalo cavalo = new RoboCavalo();
	public RoboRei rei = new RoboRei();
	public RoboRainha rainha = new RoboRainha();

	public void loadPlane() {
	    System.out.println("seu nome: ");
	    this.userName = i.nextLine();  // Solicita e armazena o nome do usuário

	    System.out.println("largura do tabuleiro: ");
	    this.width = i.nextInt();  // Solicita e armazena a largura do tabuleiro

	    System.out.println("altura do tabuleiro: ");
	    this.height = i.nextInt();  // Solicita e armazena a altura do tabuleiro

	    System.out.println("quantos alunos para resgatar?: ");
	    this.alunosNum = i.nextInt();  // Solicita e armazena a quantidade de alunos

	    System.out.println("quantos bugs para evitar?: ");
	    this.bugsNum = i.nextInt();  // Solicita e armazena a quantidade de bugs

	    p = new Plane(width, height);  // Cria um novo objeto Plane com a largura e altura especificadas
	    p.buildPlane();  // Constrói o tabuleiro com base nas dimensões definidas

	    manager = new GameManager(p, alunosNum, bugsNum);  // Cria um novo objeto GameManager com o tabuleiro e as quantidades de alunos e bugs
	    manager.populatePlane();  // Preenche o tabuleiro com os alunos e bugs

	    manager.addRobo(andador);  // Adiciona o robô "andador" ao gerenciador
	    manager.addRobo(peao);  // Adiciona o robô "peão" ao gerenciador
	    manager.addRobo(torre);  // Adiciona o robô "torre" ao gerenciador
	    manager.addRobo(bispo);  // Adiciona o robô "bispo" ao gerenciador
	    manager.addRobo(cavalo);  // Adiciona o robô "cavalo" ao gerenciador
	    manager.addRobo(rei);  // Adiciona o robô "rei" ao gerenciador
	    manager.addRobo(rainha);  // Adiciona o robô "rainha" ao gerenciador
	}


	public void moveRobo(Robo robo, int numCelulasMaxima) {
	    int movement;
	    int CellsNum = 10;

	    // Solicita a ação desejada ao usuário (avançar ou retroceder)
	    movement = i.nextInt();

	    // Define a quantidade de células a serem movidas de acordo com o valor de numCelulasMaxima
	    if (numCelulasMaxima == 1) {
	        CellsNum = 1;
	    } else if (numCelulasMaxima == 2 || numCelulasMaxima == 4) {
	        // Solicita a quantidade de células, limitando ao valor máximo permitido
	        while (CellsNum > numCelulasMaxima) {
	            System.out.println("quantas celulas? (até " + numCelulasMaxima + ")");
	            CellsNum = i.nextInt();
	        }
	    } else {
	        // Solicita a quantidade de células normalmente
	        System.out.println("quantas celulas voce deseja mover?");
	        CellsNum = i.nextInt();
	    }

	    // Executa a ação escolhida pelo usuário (avançar ou retroceder)
	    switch (movement) {
	        case 1:
	            robo.advance(CellsNum);
	            break;
	        case 2:
	            robo.recede(CellsNum);
	            break;
	    }

	    // Atualiza a posição do robô e verifica colisões
	    manager.changeRoboPosition(robo);
	    manager.verifyCollision(robo);
	}



	public void Play() {
		
		this.loadPlane();

		String end = "n";

		while (end.equals("n") && manager.alunoNum != 0) {
			System.out.println("\n");
			
			System.out.println("@: significa objetos empilhados na mesma celula!\n");
			manager.plane.showPlane();
			
			System.out.print("\nquantidade de alunos: " + manager.alunoNum);
			System.out.println(", quantidade de bugs: " + manager.bugNum + "\n");
			
			
			ArrayList<Robo> listaDeRobos = new ArrayList<Robo>();
			listaDeRobos.add(andador);
			listaDeRobos.add(peao);
			listaDeRobos.add(torre);
			listaDeRobos.add(bispo);
			listaDeRobos.add(cavalo);
			listaDeRobos.add(rei);
			listaDeRobos.add(rainha);
			
			for (Robo robo : listaDeRobos) {
				System.out.println(robo.name + ": "+andador.pontuation+" pontos");
			}
			
			System.out.println();
			
			// Percorra todos os robôs e pergunte ao usuário qual ação deseja realizar para cada um
			for (Robo robo : listaDeRobos) {
				System.out.println("qual acao para o robo " + robo.name + "? ("+robo.showSymbol()+")");
				System.out.println("1: avancar e 2: retroceder\n");
			    this.moveRobo(robo, robo.maxNumCell);
			    System.out.println("-------------------------------------------");
			}
			
			i.nextLine();
			
			System.out.println("deseja parar de jogar? [s/n]");

			end = i.nextLine();
		}
		System.out.println("jogo finalizado.");
	}
}
