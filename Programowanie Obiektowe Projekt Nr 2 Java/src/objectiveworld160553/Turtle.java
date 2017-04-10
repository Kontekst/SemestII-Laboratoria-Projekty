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
public class Turtle extends Animal {

    public Turtle(int x, int y, World world) {
        super(x, y, world);
        this.name = "T";
        this.initiative = 1;
        this.strength = 2;
    }

         @Override
    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        switch (animalBoard[x + nx][y + ny]) {
            case '0':
                return 1;
            case 'T':
        //        System.out.println("Spotkaly sie 2 zolwie");
                return 4;
                case 'H':
                System.out.println("Zolw ginie atakujac czlowieka");
                return 3;
            case 'S':
                System.out.println("Owca zabija atakujacego zolwia");
                return 3;
            case 'N':
                System.out.println("Zolw zjada wilcze jagody i ginie");
                return 5;
            case 'W':
                System.out.println("Wilk zabija atakujacego zolwia");
                return 3;
            case 'F':
                System.out.println("Lis zabija atakujacego zolwia");
                return 3;
            case 'L':
                System.out.println("Lis zjada mlecz");
                return 2;
            case '#':
                System.out.println("Lis zjada trawe");
                return 2;
            case 'G':
                System.out.println("Lis zjadla guaraney");
                return 2;
        }

        return 0;
    }

}
