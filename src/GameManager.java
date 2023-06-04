import java.util.ArrayList;
import java.util.Random;

public class GameManager {

    public Plane plane;
    public int alunoNum;
    public int bugNum;

    public GameManager(Plane plano, int qtdAlunos, int qtdBugs) {
        this.plane = plano;
        this.alunoNum = qtdAlunos;
        this.bugNum = qtdBugs;
    }

    // Gera um número aleatório entre dois valores
    private int randomNumberBetween(int min, int max) {
        Random r;
        r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    // Popula o tabuleiro com alunos e bugs em posições aleatórias
    public void populatePlane() {
        ArrayList<int[]> randomPositions = new ArrayList<int[]>();

        // Gera posições aleatórias para alunos e bugs
        for (int i = 1; i <= (this.alunoNum + this.bugNum); i++) {
            int[] randomCord = new int[3];
            randomCord[2] = (i <= this.alunoNum) ? 1 : 2; // Define o tipo (aluno ou bug)

            boolean sameCoord;
            do {
                randomCord[0] = randomNumberBetween(1, this.plane.width);
                randomCord[1] = randomNumberBetween(1, this.plane.height);
                sameCoord = false;

                // Verifica se a posição gerada já está ocupada
                for (int[] c : randomPositions) {
                    if (randomCord[0] == c[0] && randomCord[1] == c[1] ) {
                        sameCoord = true;
                        break;
                    }
                }
            } while (sameCoord);

            randomPositions.add(randomCord);
        }

        // Adiciona os alunos e bugs às posições geradas
        for (int[] position : randomPositions) {
            int targetX = position[0];
            int targetY = position[1];
            int targetType = position[2];

            for (int j = 0; j < this.plane.cellList.size(); j++) {
                Cell cell = this.plane.cellList.get(j);
                if (cell.X == targetX && cell.Y == targetY) {
                    if (targetType == 1) {
                        Aluno novoAluno = new Aluno();
                        cell.add(novoAluno);
                    } else if (targetType == 2) {
                        Bug novoBug = new Bug();
                        cell.add(novoBug);
                    }
                    break;
                }
            }
        }
    }

    // Move o robô para uma nova posição no tabuleiro
    public void changeRoboPosition(Robo robo) {
        // Remove o robô da posição anterior
        for (Cell cell : this.plane.cellList) {
            cell.remove(robo);
        }

        // Adiciona o robô na nova posição
        for (Cell cell : this.plane.cellList) {
            if (cell.X == robo.Xpos && cell.Y == robo.Ypos) {
                cell.add(robo);
            }
        }
    }

    // Adiciona um robô à posição inicial
    public void addRobo(Robo robo) {
        for (int i = 0; i < this.plane.cellList.size(); i++) {
            if (this.plane.cellList.get(i).X == 1 && this.plane.cellList.get(i).Y == 1) {
                this.plane.cellList.get(i).add(robo);
            }
        }
    }

    // Verifica colisões do robô com objetos no tabuleiro
    public void verifyCollision(Robo robo) {
        for (int i = 0; i < this.plane.cellList.size(); i++) {
            if (this.plane.cellList.get(i).X == robo.Xpos && this.plane.cellList.get(i).Y == robo.Ypos) {
                for (int j = 0; j < this.plane.cellList.get(i).objects.size(); j++) {
                    if (this.plane.cellList.get(i).objects.get(j).getType() == 1) {
                        this.plane.cellList.get(i).removeFirst();
                        robo.alunoColision();
                        this.alunoNum--;
                    } else if (this.plane.cellList.get(i).objects.get(j).getType() == 2) {
                        this.plane.cellList.get(i).removeFirst();
                        robo.bugColision();
                        this.bugNum--;
                    }
                }
            }
        }
    }

}
