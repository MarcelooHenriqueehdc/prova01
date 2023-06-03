import java.util.Scanner;

public class Jogo {
	public String nome;
	public int tamanhoX;
	public int tamanhoY;
	public int qtdAlunos;
	public int qtdBugs;
	public Plano p;
	public ServicosJogo servicos;
	Scanner input = new Scanner(System.in);
	
	public RoboAndador andador = new RoboAndador();
	public RoboPeao peao = new RoboPeao();
	public RoboTorre torre = new RoboTorre();
	public RoboBispo bispo = new RoboBispo();
	public RoboCavalo cavalo = new RoboCavalo();
	public RoboRei rei = new RoboRei();
	public RoboRainha rainha = new RoboRainha();
	
	public void prepararJogo() {
		System.out.print("Nome do jogador: ");
		this.nome = input.next();
		System.out.print("Quant de Linhas: ");
		this.tamanhoX = input.nextInt();
		System.out.print("Quant de Colunas: ");
		this.tamanhoY = input.nextInt();
		System.out.print("Quant de Alunos: ");
		this.qtdAlunos = input.nextInt();
		System.out.print("Quant de Bugs: ");
		this.qtdBugs = input.nextInt();
		p = new Plano(tamanhoX, tamanhoY);
		p.montarPlano();
		servicos = new ServicosJogo(p, qtdAlunos, qtdBugs);
		servicos.povoarPlano();

		
		servicos.adicionarRobo(andador);
		servicos.adicionarRobo(peao);
		servicos.adicionarRobo(torre);
		servicos.adicionarRobo(bispo);
		servicos.adicionarRobo(cavalo);
		servicos.adicionarRobo(rei);
		servicos.adicionarRobo(rainha);
	}
	
	public void acaoRobo(Robo robo, int numCelulasMaxima) {
		int acao;
		int qtdCelulas = 5;
		
		System.out.println("Voce deseja avancar[1] ou retroceder[2]? [1/2]");
		acao = input.nextInt();
		
		switch(numCelulasMaxima) {
			case 1:
				qtdCelulas = 1;
				break;
			case 2:
				while(qtdCelulas > 2) {
					System.out.println("Quantas celulas voce deseja mover? (Até 2)");
					qtdCelulas = input.nextInt();
				}
				break;
			case 4:
				while(qtdCelulas > 4) {
					System.out.println("Quantas celulas voce deseja mover? (Até 4)");
					qtdCelulas = input.nextInt();
				}
				break;
			default:
				System.out.println("Quantas celulas voce deseja mover?");
				qtdCelulas = input.nextInt();
				break;
		}
		
		
		switch(acao) {
			case 1:
				robo.avancar(qtdCelulas);
				break;
			case 2:
				robo.retroceder(qtdCelulas);
				break;
			default:
				System.out.println("Digite uma opcao valida! [1/2]:");
				break;
		}
	
		servicos.atualizarPosicaoRobo(robo);
		servicos.verificarColisao(robo);
		
	}

	public void Jogar() {
		this.prepararJogo();
		
		String sair = "n";
		
		while(sair.equals("n")&&servicos.qtdAlunos!=0) {
			System.out.println("\n====================================");
			servicos.plano.retornarCelulasMontadas();
			System.out.println("====================================\n");
			System.out.println("Alunos restantes: " + servicos.qtdAlunos);
			System.out.println("Bugs restantes: " + servicos.qtdBugs + "\n");
			System.out.println("QUAL ROBO VOCE DESEJA USAR?");
			System.out.println("|1| Robo Andador |r| ("+ andador.posicaoX +", "+ andador.posicaoY +") ("+ andador.pontos +" pontos)");
			System.out.println("|2| Robo Peao    |#| ("+ peao.posicaoX +", "+ peao.posicaoY +") ("+ peao.pontos +" pontos)");
			System.out.println("|3| Robo Torre   |T| ("+ torre.posicaoX +", "+ torre.posicaoY +") ("+ torre.pontos +" pontos)");
			System.out.println("|4| Robo Bispo   |+| ("+ bispo.posicaoX +", "+ bispo.posicaoY +") ("+ bispo.pontos + " pontos)");
			System.out.println("|5| Robo Cavalo  |c| ("+ cavalo.posicaoX +", "+ cavalo.posicaoY +") ("+ cavalo.pontos +" pontos)");
			System.out.println("|6| Robo Rei     |R| ("+ rei.posicaoX +", "+ rei.posicaoY +") ("+ rei.pontos +" pontos)");
			System.out.println("|7| Robo Rainha  |Q| ("+ rainha.posicaoX +", "+ rainha.posicaoY +") ("+ rainha.pontos +" pontos)");
			
			
			int resposta = 0;
			System.out.print("\nSua resposta: ");
			resposta = input.nextInt();
			input.nextLine(); // Consumir nova linha em branco para evitar erros
			
			switch(resposta) {
				case 1:
					this.acaoRobo(andador, 0);
					break;
				case 2:
					this.acaoRobo(peao, 1);
					break;
				case 3:
					this.acaoRobo(torre, 2);
					break;
				case 4:
					this.acaoRobo(bispo, 2);
					break;
				case 5:
					this.acaoRobo(cavalo, 2);
					break;
				case 6:
					this.acaoRobo(rei, 4);
					break;
				case 7:
					this.acaoRobo(rainha, 4);
					break;
				default:
					System.out.println("O Robô inserido não existe!");
					break;
			}
			input.nextLine(); // Consumir nova linha em branco para evitar erros
			
			System.out.println("Deseja parar de jogar? [s/n]");

			sair = input.nextLine();	
			
		}
		System.out.println("Jogo finalizado.");
	}
}
