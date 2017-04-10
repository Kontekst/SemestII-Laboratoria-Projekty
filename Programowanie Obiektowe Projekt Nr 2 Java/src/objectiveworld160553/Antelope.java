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
public class Antelope extends Animal {

    public Antelope(int x, int y, World world) {
        super(x, y, world);
        this.name = "A";
        this.initiative = 4;
        this.strength = 4;
    }

    @Override
    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        switch (animalBoard[x + nx][y + ny]) {
            case '0':
                return 1;
            case 'A':
            //    System.out.println("Spotkaly sie 2 antylopy");
                return 4;
            case 'T':
                System.out.println("Zolw odpiera antylope");
                return 0;
            case 'N':
                System.out.println("Antylopa zjada wilcze jagody i ginie");
                return 5;
            case 'W':
                System.out.println("Wilk zabija antylope");
                return 3;
            case 'F':
                System.out.println("Antylopa zabija lisa");
                return 2;
            case 'L':
                System.out.println("Antylopa zjada mlecz");
                return 2;
            case '#':
                System.out.println("Antylopa zjada trawe");
                return 2;
            case 'G':
                System.out.println("Antylopa zjadla guaraney");
                return 2;
            case 'S':
                System.out.println("Spotyka sie antylopa z owca");
                return 0;
            case 'H':
                System.out.println("Antylopa atakuje czlowieka i ginie)");
                return 3;
        }

        return 0;
    }
}
