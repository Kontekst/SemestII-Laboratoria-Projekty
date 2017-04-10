/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectiveworld160553;

/**
 *
 * @author Kontekstowy
 */
public class Sheep extends Animal {

    public Sheep(int x, int y, World world) {
        super(x, y, world);
        this.name = "S";
        this.initiative = 4;
        this.strength = 4;
    }

    @Override
    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        switch (animalBoard[x + nx][y + ny]) {
            case '0':
                return 1;
            case 'S':
             //   System.out.println("Spotkaly sie 2 owce");
                return 4;
            case 'T':
                System.out.println("Zolw odpiera owce");
                return 0;
            case 'N':
                System.out.println("Owca zjada wilcze jagody i ginie");
                return 5;
            case 'W':
                System.out.println("Wilk zabija atakujaca owce");
                return 3;
            case 'F':
                System.out.println("Spotyka sie antylopa z owca");
                return 0;
            case 'L':
                System.out.println("Owca zjada mlecz");
                return 2;
            case '#':
                System.out.println("Owca zjada trawe");
                return 2;
            case 'G':
                System.out.println("Owca zjadla guaraney");
                return 2;
            case 'H':
                System.out.println("Owca ginie atakujac czlowieka");
                return 3;
        }

        return 0;
    }
}
