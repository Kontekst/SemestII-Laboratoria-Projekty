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
public class Fox extends Animal {

    public Fox(int x, int y, World world) {
        super(x, y, world);
        this.name = "F";
        this.initiative = 7;
        this.strength = 3;
    }

    @Override
    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        switch (animalBoard[x + nx][y + ny]) {
            case '0':
                return 1;
            case 'F':
           //     System.out.println("Spotkaly sie 2 lisy");
                return 4;
            case 'T':
                System.out.println("Zolw odpiera lisa");
                return 0;
            case 'N':
                System.out.println("Lis o malo co nie zjadl wilczych jagod");
                return 0;
            case 'W':
                System.out.println("Wilk prawie zabil");
                return 0;
            case 'A':
                System.out.println("Antylopa zprawie zabila lisa");
                return 0;
            case 'L':
                System.out.println("Lis zjada mlecz");
                return 2;
            case '#':
                System.out.println("Lis zjada trawe");
                return 2;
            case 'G':
                System.out.println("Lis zjadla guaraney");
                return 2;
            case 'S':
                System.out.println("Owca prawie zabila lisa");
                return 0;
            case 'H':
                System.out.println("Lis o malo nie zginal przez czlowieka)");
                return 0;
        }

        return 0;
    }
}
