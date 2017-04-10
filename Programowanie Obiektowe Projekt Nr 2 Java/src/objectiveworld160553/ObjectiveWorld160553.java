package objectiveworld160553;

import java.util.Scanner;

/**
 * Tomasz Kontek 160553
 *
 * @author Kontekstowy
 */
public class ObjectiveWorld160553 {

    public static void main(String[] args) {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Jesli chcesz zaczac nowa gre wpisz 1 jesli chcesz wczytac wpisz 2");
        int option = sc.nextInt();
        if (option == 1) {
            do {
                System.out.println("Wpisz x zawierajace sie w zakresie<5,20>");
                x = sc.nextInt();
            } while (x < 5 || x > 20);
            do {
                System.out.println("Wpisz y zawierajace sie w zakresie<5,20>");
                y = sc.nextInt();
            } while (y < 5 || y > 20);
        } else {
            //TODO wczytanie gry
            x = 0;
            y = 0;
        }
        try {
            World GameWorld = new World(x, y, option);
            GameWorld.runGame(0);
        } catch (MyException e) {
            System.out.println("BLAD!");
        }

    }
}
