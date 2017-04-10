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
public class Human extends Animal {

    public Human(int x, int y, World world) {
        super(x, y, world);
        this.name = "H";
        this.initiative = 4;
        this.strength = 5;
    }

    @Override
    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        switch (animalBoard[x + nx][y + ny]) {
            case '0':
                return 1;
            case 'S':
                System.out.println("Czlowiek zabija owce");
                return 2;
            case 'A':
                System.out.println("Czlowiek zabija antylope");
                return 2;
            case 'T':
                System.out.println("Czlowiek zabija zolwia");
                return 2;
            case 'N':
                System.out.println("Czlowiek zjada wilcze jagody i ginie");
                return 5;
            case 'W':
                System.out.println("Wilk zabija czlowieka");
                return 3;
            case 'F':
                System.out.println("Czlowiek zabija lisa");
                return 2;
            case 'L':
                System.out.println("Czlowiek zjada mlecz");
                return 2;
            case '#':
                System.out.println("czlowiek zjada trawe");
                return 2;
            case 'G':
                System.out.println("Czlowiek zjadla guaraney");
                return 2;
        }
        return 0;
    }
}
