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
public class Wolf extends Animal {

    public Wolf(int x, int y, World world) {
        super(x, y, world);
        this.name = "W";
        this.initiative = 5;
        this.strength = 9;
    }

    @Override
    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        switch (animalBoard[x + nx][y + ny]) {
            case '0':
                return 1;
            case 'W':
          //      System.out.println("Spotkaly sie 2 wilki");
                return 4;
            case 'S':
                System.out.println("Wilk zabija owce");
                return 2;
            case 'N':
                System.out.println("Wilk zjada wilcze jagody i ginie");
                return 5;
            case 'T':
                System.out.println("Wilk zabija zolwia");
                return 2;
            case 'F':
                System.out.println("Wilk zabija lisa");
                return 2;
            case 'L':
                System.out.println("Wilk zjada mlecz");
                return 2;
            case '#':
                System.out.println("Wilk zjada trawe");
                return 2;
            case 'G':
                System.out.println("Wilk zjadla guaraney");
                return 2;
            case 'H':
                System.out.println("Wilk zabija czlowieka");
                return 2;
        }

        return 0;
    }
}
