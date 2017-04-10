package objectiveworld160553;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Kontekstowy
 */
public class World extends JFrame {

    int x;
    int y;
    int[][] board;
    char[][] animalBoard;
    OrganismContainer[] AnimalContainer;
    JButton[][] buttons;
    int organismAmount;
    MyFrame GameFrame;

    World(int xx, int yy, int option) throws MyException {
        if (option == 1) {
            this.x = xx;
            this.y = yy;
            GameFrame = new MyFrame(x, y, this);//Okno gry z przyciskami
            MyKeyListener escExit = new MyKeyListener();
            addKeyListener(escExit);
            board = new int[x][y]; //W niej trzymam numer organizmu ktory znajduje sie na tym polu ||| 0 oznacza że nie ma tu żadnego oganizmu
            animalBoard = new char[x][y];//W niej trzymam litere z oznaczeniem organizmu ||| 0 oznacza że nie ma tu żadnego organizmu
            AnimalContainer = new OrganismContainer[x * y];//Tu trzymam obiekty organizmow
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    animalBoard[i][j] = '0';
                    board[i][j] = 0;
                }
            }
            organismAmount = 24;
            Random myRandom = new Random();
            int px, py;
            boolean continueRadnom;
            for (int i = 0; i < 24; i++) {
                Organism newOrganism;
                continueRadnom = true;
                do {
                    px = myRandom.nextInt(x);
                    py = myRandom.nextInt(y);
                    if (animalBoard[px][py] == '0') {
                        continueRadnom = false;
                    }
                } while (continueRadnom == true);

                if (i == 0) {
                    System.out.println("Stworzono czlowieka na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Human(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    animalBoard[px][py] = 'H';
                    GameFrame.buttons[px][py].setText("H");
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 1 || i == 2 || i == 3) {
                    System.out.println("Stworzono owce na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Sheep(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    animalBoard[px][py] = 'S';
                    GameFrame.buttons[px][py].setText("S");
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 4 || i == 5 || i == 6) {
                    System.out.println("Stworzono wilka na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Wolf(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    animalBoard[px][py] = 'W';
                    GameFrame.buttons[px][py].setText("W");
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 7 || i == 8 || i == 9) {
                    System.out.println("Stworzono lisa na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Fox(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    animalBoard[px][py] = 'F';
                    GameFrame.buttons[px][py].setText("F");
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 10 || i == 11 || i == 12) {
                    System.out.println("Stworzono zolwia na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Turtle(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    animalBoard[px][py] = 'T';
                    GameFrame.buttons[px][py].setText("T");
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 13 || i == 14 || i == 15) {
                    System.out.println("Stworzono antylopy na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Antelope(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    animalBoard[px][py] = 'A';
                    GameFrame.buttons[px][py].setText("A");
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 16 || i == 17) {
                    System.out.println("Stworzono trawe na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Grass(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    GameFrame.buttons[px][py].setText("#");
                    animalBoard[px][py] = '#';
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 18 || i == 19) {
                    System.out.println("Stworzono wilcze jagody na koordynatach (" + px + "," + py + ")");
                    newOrganism = new DeadlyNightshade(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    GameFrame.buttons[px][py].setText("N");
                    animalBoard[px][py] = 'N';
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 20 || i == 21) {
                    System.out.println("Stworzono guarane na koordynatach (" + px + "," + py + ")");
                    newOrganism = new Guarana(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    GameFrame.buttons[px][py].setText("G");
                    animalBoard[px][py] = 'G';
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
                if (i == 22 || i == 23) { //TODO i powinno wynosic okolo 10,11
                    System.out.println("Stworzono mlecz na koordynatach (" + px + "," + py + ")");
                    newOrganism = new SowThistle(px, py, this);
                    newOrganism.number = (i + 1);
                    board[px][py] = (i + 1);
                    GameFrame.buttons[px][py].setText("L");
                    animalBoard[px][py] = 'L';
                    AnimalContainer[i] = new OrganismContainer();
                    AnimalContainer[i].organism = newOrganism;
                }
            }
        } else if (option == 2) {
            try {
                System.out.println("WCZYTUJEMY");
                InputStream myInput = new FileInputStream("data.txt");
                Scanner myInputFile = new Scanner(myInput);

                x = myInputFile.nextInt();
                y = myInputFile.nextInt();
                if (x == 0 || y == 0) {
                    MyException alfa = new MyException();
                    throw alfa;
                }
                organismAmount = myInputFile.nextInt();
                System.out.println("Liczba kolumn x " + x);
                System.out.println("Liczba linii y " + y);
                System.out.println("Liczba zwierzat " + organismAmount);
                organismAmount = organismAmount - 3;
                String tempChar;
                board = new int[x][y]; //W niej trzymam numer organizmu ktory znajduje sie na tym polu ||| 0 oznacza że nie ma tu żadnego oganizmu
                animalBoard = new char[x][y];//W niej trzymam litere z oznaczeniem organizmu ||| 0 oznacza że nie ma tu żadnego organizmu
                AnimalContainer = new OrganismContainer[x * y];
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        animalBoard[i][j] = '0';
                        board[i][j] = 0;
                    }
                }
                GameFrame = new MyFrame(x, y, this);//Okno gry z przyciskami

                for (int o = 0; o < organismAmount; o++) {
                    Organism newOrganism;
                    int tempAge = 0, tempX = 0, tempY = 0, tempInitiative = 0;
                    tempChar = myInputFile.next();
                    System.out.print("ADASD ");
                    System.out.print(tempChar + " ");
                    if (tempChar != "0") {
                        tempX = myInputFile.nextInt();
                        System.out.print(tempX + " ");
                        tempY = myInputFile.nextInt();
                        System.out.print(tempY + " ");
                        tempInitiative = myInputFile.nextInt();
                        System.out.print(tempInitiative + " ");
                        tempAge = myInputFile.nextInt();
                        System.out.println(tempAge + " ");
                        switch (tempChar) {
                            case "H":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Human(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;

                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'H';
                                GameFrame.buttons[tempX][tempY].setText("H");
                                break;
                            case "A":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Antelope(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'A';
                                GameFrame.buttons[tempX][tempY].setText("A");
                                break;
                            case "F":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Fox(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'F';
                                GameFrame.buttons[tempX][tempY].setText("F");
                                break;
                            case "T":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Turtle(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'T';
                                GameFrame.buttons[tempX][tempY].setText("T");
                                break;
                            case "S":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Sheep(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'S';
                                GameFrame.buttons[tempX][tempY].setText("S");
                                break;
                            case "W":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Wolf(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'W';
                                GameFrame.buttons[tempX][tempY].setText("W");
                                break;
                            case "#":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Grass(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = '#';
                                GameFrame.buttons[tempX][tempY].setText("#");
                                break;
                            case "L":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new SowThistle(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'L';
                                GameFrame.buttons[tempX][tempY].setText("L");
                                break;
                            case "G":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new Guarana(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'G';
                                GameFrame.buttons[tempX][tempY].setText("G");
                                break;
                            case "N":
                                AnimalContainer[o] = new OrganismContainer();
                                newOrganism = new DeadlyNightshade(tempX, tempY, this);
                                AnimalContainer[o].organism = newOrganism;
                                AnimalContainer[o].organism.x = tempX;
                                AnimalContainer[o].organism.y = tempY;
                                AnimalContainer[o].organism.age = tempAge;
                                AnimalContainer[o].organism.initiative = tempInitiative;
                                AnimalContainer[o].organism.number = (o + 1);
                                animalBoard[tempX][tempY] = 'N';
                                GameFrame.buttons[tempX][tempY].setText("N");
                                break;
                        }

                        board[tempX][tempY] = (o + 1);
                    }

                }

                organismAmount = myInputFile.nextInt() + 3;

            } catch (Exception E1) {

            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    JButton button = new JButton();
                    button.setVisible(true);
                    button.setBounds(20, 20, 15, 15);
                    GameFrame.add(button);
                    add(button);
                }

            }
        }
    }

    public void save() {
        try {
            System.out.println("ZAPISUJEMY");
            OutputStream myFile = new FileOutputStream("data1.txt");
            PrintStream myOutputFile = new PrintStream(myFile);
            myOutputFile.println(this.x);
            myOutputFile.println(this.y);
            myOutputFile.println(this.organismAmount);

            for (int i = 0; i < organismAmount; i++) {
                if (AnimalContainer[i] != null) {
                    myOutputFile.println(AnimalContainer[i].organism.name + " " + AnimalContainer[i].organism.x + " " + AnimalContainer[i].organism.y + " " + " " + AnimalContainer[i].organism.initiative + " " + " " + AnimalContainer[i].organism.age);
                }
            }

            myFile.close();
        } catch (Exception ex) {

        }

    }

    public void runGame(int optionKey) {
        Random rand = new Random();
        int nx, ny;
        for (int i = 0; i < organismAmount; i++) {
            if (AnimalContainer[i] != null) {
                if (i == 0 && AnimalContainer[i].organism.name == "H") {
                    System.out.println("RUSZA CZLOWIEK");
                    GameFrame.repaint();
                    System.out.println("Zzaczeto ture ruchow");
                    nx = 0;
                    ny = 0;
                    if (optionKey == 1) {
                        ny = -1;
                    }
                    if (optionKey == 2) {
                        ny = 1;
                    }
                    if (optionKey == 3) {
                        nx = -1;
                    }
                    if (optionKey == 4) {
                        nx = 1;
                    }
                    int option = 0;
                    if (AnimalContainer[i].organism.returnX() + nx > 0 && AnimalContainer[i].organism.returnX() + nx < x && AnimalContainer[i].organism.returnY() + ny > 0 && AnimalContainer[i].organism.returnY() + ny < y) {
                        option = AnimalContainer[i].organism.action(animalBoard, nx, ny, AnimalContainer[i].organism);
                        if (option == 0) {
                            //NIC
                        }
                        if (option == 1) {
                            //przejscie na nowe pole
                            GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                            board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                            animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';
                            AnimalContainer[i].organism.x = AnimalContainer[i].organism.returnX() + nx;
                            AnimalContainer[i].organism.y = AnimalContainer[i].organism.returnY() + ny;
                            board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = AnimalContainer[i].organism.returnNumber();
                            char tempChar = AnimalContainer[i].organism.returnName().charAt(0);
                            animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = tempChar;
                            GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText(AnimalContainer[i].organism.returnName());
                        }
                        if (option == 2) {
                            //zabicie wroga iprzejscie na jego pozycje
                            GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                            board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                            animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';
                            AnimalContainer[board[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny]] = null; //Rzuca wyjatek TODO CHECK??????????????
                            AnimalContainer[i].organism.x = AnimalContainer[i].organism.returnX() + nx;
                            AnimalContainer[i].organism.y = AnimalContainer[i].organism.returnY() + ny;
                            board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = AnimalContainer[i].organism.returnNumber();
                            char tempChar = AnimalContainer[i].organism.returnName().charAt(0);
                            animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = tempChar;
                            GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText(AnimalContainer[i].organism.returnName());
                        }
                        if (option == 3) {
                            // smierc wlasna w wyniku nieudanego ataku
                            GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                            board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                            animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';
                            AnimalContainer[i] = null;
                        }
                        if (option == 5) {
                            //zabicie wroga i wlasna smierc
                            GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                            board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                            animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';

                            board[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny] = 0;
                            animalBoard[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny] = '0';
                            GameFrame.buttons[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny].setText("");

                            AnimalContainer[board[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny]] = null;
                            AnimalContainer[i] = null;
                        }
                    }
                } else {
                    GameFrame.repaint();//???????????????
                    do {
                        nx = rand.nextInt(3) - 1;
                        ny = rand.nextInt(3) - 1;
                    } while (AnimalContainer[i].organism.returnX() + nx < 0 || AnimalContainer[i].organism.returnX() + nx > (x - 1) || AnimalContainer[i].organism.returnY() + ny < 0 || AnimalContainer[i].organism.returnY() + ny > (y - 1));
                }
                char tempName = AnimalContainer[i].organism.returnName().charAt(0);

                if (tempName == 'S' || tempName == 'W' || tempName == 'F' || tempName == 'A' || tempName == 'T') {

                    int option = 0;
                    option = AnimalContainer[i].organism.action(animalBoard, nx, ny, AnimalContainer[i].organism);
                    if (option == 0) {
                        //NIC
                    }
                    if (option == 1) {
                        //przejscie na nowe pole
                        GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                        board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                        animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';
                        AnimalContainer[i].organism.x = AnimalContainer[i].organism.returnX() + nx;
                        AnimalContainer[i].organism.y = AnimalContainer[i].organism.returnY() + ny;
                        board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = AnimalContainer[i].organism.returnNumber();
                        char tempChar = AnimalContainer[i].organism.returnName().charAt(0);
                        animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = tempChar;
                        GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText(AnimalContainer[i].organism.returnName());
                    }
                    if (option == 2) {
                        //zabicie wroga iprzejscie na jego pozycje
                        GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                        board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                        animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';
                        AnimalContainer[board[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny]] = null; //Rzuca wyjatek TODO CHECK??????????????
                        AnimalContainer[i].organism.x = AnimalContainer[i].organism.returnX() + nx;
                        AnimalContainer[i].organism.y = AnimalContainer[i].organism.returnY() + ny;
                        board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = AnimalContainer[i].organism.returnNumber();
                        char tempChar = AnimalContainer[i].organism.returnName().charAt(0);
                        animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = tempChar;
                        GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText(AnimalContainer[i].organism.returnName());
                    }
                    if (option == 3) {
                        // smierc wlasna w wyniku nieudanego ataku
                        GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                        board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                        animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';
                        AnimalContainer[i] = null;
                    }
                    if (option == 4) {
                        //rozmanazanie
                        Organism newOrganism;
                        int freeNumber = -1;
                        for (int z = 0; z < x * y; z++) {
                            if (AnimalContainer[z] == null) {
                                freeNumber = z;
                                break;
                            }
                        }
                        if (freeNumber != -1) {
                            boolean freePlace = false;
                            int ne = 0, nw = 0;

                            for (int e = -1; e < 2; e++) {
                                for (int w = -1; w < 2; w++) {
                                    if (AnimalContainer[i].organism.returnX() + e > 0 && AnimalContainer[i].organism.returnX() + e < x && AnimalContainer[i].organism.returnY() + w > 0 && AnimalContainer[i].organism.returnY() + w < y) {
                                        if (animalBoard[AnimalContainer[i].organism.returnX() + e][AnimalContainer[i].organism.returnY() + w] == '0') { ////////////////////////Blad wywalalo ale chyba naprawilem
                                            {
                                                freePlace = true;
                                                ne = e;
                                                nw = w;
                                            }
                                        }
                                    }
                                }
                            }
                            if (freePlace == true) {
                                if (AnimalContainer[freeNumber] == null) { ///?? POTRZEBNE CZY KRZYWDZACE
                                    {
                                        AnimalContainer[freeNumber] = new OrganismContainer();
                                    }
                                    switch (tempName) {
                                        case 'S':
                                            System.out.println("Stworozno owce");
                                            newOrganism = new Sheep(AnimalContainer[i].organism.x + ne, AnimalContainer[i].organism.y + nw, this);
                                            newOrganism.number = freeNumber;
                                            AnimalContainer[freeNumber].organism = newOrganism;
                                            animalBoard[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw] = 'S';
                                            GameFrame.buttons[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw].setText("S");// CHECK //nx ny???
                                            AnimalContainer[freeNumber].organism.name = "S";
                                            break;
                                        case 'W':
                                            System.out.println("Stworozno wilka");
                                            newOrganism = new Wolf(AnimalContainer[i].organism.x + ne, AnimalContainer[i].organism.y + nw, this);
                                            newOrganism.number = freeNumber;
                                            AnimalContainer[freeNumber].organism = newOrganism;
                                            animalBoard[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw] = 'W';
                                            GameFrame.buttons[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw].setText("W");
                                            AnimalContainer[freeNumber].organism.name = "W";
                                            break;
                                        case 'F':
                                            System.out.println("Stworozno lisa");
                                            newOrganism = new Fox(AnimalContainer[i].organism.x + ne, AnimalContainer[i].organism.y + nw, this);
                                            newOrganism.number = freeNumber;
                                            AnimalContainer[freeNumber].organism = newOrganism;
                                            animalBoard[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw] = 'F';
                                            GameFrame.buttons[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw].setText("F");
                                            AnimalContainer[freeNumber].organism.name = "F";
                                            break;
                                        case 'T':
                                            System.out.println("Stworozno zolwia");
                                            newOrganism = new Turtle(AnimalContainer[i].organism.x + ne, AnimalContainer[i].organism.y + nw, this);
                                            newOrganism.number = freeNumber;
                                            AnimalContainer[freeNumber].organism = newOrganism;
                                            animalBoard[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw] = 'T';
                                            GameFrame.buttons[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw].setText("T");
                                            AnimalContainer[freeNumber].organism.name = "T";
                                            break;
                                        case 'A':
                                            System.out.println("Stworozno antylope");
                                            newOrganism = new Antelope(AnimalContainer[i].organism.x + ne, AnimalContainer[i].organism.y + nw, this);
                                            newOrganism.number = freeNumber;
                                            AnimalContainer[freeNumber].organism = newOrganism;
                                            animalBoard[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw] = 'A';
                                            GameFrame.buttons[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw].setText("A");
                                            AnimalContainer[freeNumber].organism.name = "A";
                                            break;
                                    }
                                    board[AnimalContainer[i].organism.x + ne][AnimalContainer[i].organism.y + nw] = freeNumber;
                                    if (organismAmount != x * y) {
                                        organismAmount++;
                                    }
                                }
                            }
                        }
                    }
                    if (option == 5) {
                        //zabicie wroga i wlasna smierc
                        GameFrame.buttons[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()].setText("");
                        board[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = 0;
                        animalBoard[AnimalContainer[i].organism.returnX()][AnimalContainer[i].organism.returnY()] = '0';

                        board[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny] = 0;
                        animalBoard[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny] = '0';
                        GameFrame.buttons[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny].setText("");

                        AnimalContainer[board[AnimalContainer[i].organism.returnX() + nx][AnimalContainer[i].organism.returnY() + ny]] = null;
                        AnimalContainer[i] = null;
                    }
                }

                if (tempName == '#' || tempName == 'G' || tempName == 'N' || tempName == 'L') {
                    if (AnimalContainer[i].organism.multiply(board, AnimalContainer[i].organism.x, AnimalContainer[i].organism.y, nx, ny) != false) {
                        Organism newOrganism;
                        int freeNumber = -1;
                        for (int z = 0; z < x * y; z++) {
                            if (AnimalContainer[z] == null) {
                                freeNumber = z;
                                break;
                            }

                        }
                        if (freeNumber != -1) {
                            if (AnimalContainer[freeNumber] == null) { ///?? POTRZEBNE CZY KRZYWDZACE
                                AnimalContainer[freeNumber] = new OrganismContainer();
                            }
                            switch (tempName) {

                                case '#':
                                    System.out.println("Stworozno trawe");
                                    newOrganism = new Grass(AnimalContainer[i].organism.x + nx, AnimalContainer[i].organism.y + ny, this);
                                    newOrganism.number = freeNumber;
                                    AnimalContainer[freeNumber].organism = newOrganism;
                                    AnimalContainer[freeNumber].organism.name = "#";
                                    animalBoard[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny] = '#';
                                    GameFrame.buttons[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny].setText("#");
                                    break;
                                case 'G':
                                    newOrganism = new Guarana(AnimalContainer[i].organism.x + nx, AnimalContainer[i].organism.y + ny, this);
                                    System.out.println("Stworozno guarane");
                                    newOrganism.number = freeNumber;
                                    AnimalContainer[freeNumber].organism = newOrganism;
                                    AnimalContainer[freeNumber].organism.name = "G";
                                    animalBoard[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny] = 'G';
                                    GameFrame.buttons[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny].setText("G");
                                    break;
                                case 'N':
                                    newOrganism = new DeadlyNightshade(AnimalContainer[i].organism.x + nx, AnimalContainer[i].organism.y + ny, this);
                                    newOrganism.number = freeNumber;
                                    System.out.println("Stworozno wilcze jagody");
                                    AnimalContainer[freeNumber].organism = newOrganism;
                                    AnimalContainer[freeNumber].organism.name = "N";
                                    animalBoard[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny] = 'N';
                                    GameFrame.buttons[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny].setText("N");
                                    break;
                                case 'L':
                                    newOrganism = new SowThistle(AnimalContainer[i].organism.x + nx, AnimalContainer[i].organism.y + ny, this);
                                    newOrganism.number = freeNumber;
                                    System.out.println("Stworozno mleczyk");
                                    AnimalContainer[freeNumber].organism = newOrganism;
                                    AnimalContainer[freeNumber].organism.name = "L";
                                    animalBoard[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny] = 'L';
                                    GameFrame.buttons[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny].setText("L");
                                    break;
                            }
                            board[AnimalContainer[i].organism.x + nx][AnimalContainer[i].organism.y + ny] = freeNumber;//>>>>>>>>>>>>??????????????????????????????????? anie frree number???????

                            if (organismAmount != x * y) {
                                organismAmount++;
                            }

                        }
                    }
                }
            }
        }
    }

    void addOrganism(int xx, int yy) {
        if (board[xx][yy] == 0) {
            Organism newOrganism;

            int freeNumber = -1;
            for (int z = 0; z < x * y;
                    z++) {
                if (AnimalContainer[z] == null) {
                    freeNumber = z;
                    break;
                }
            }

            if (freeNumber != -1) {

                ChoiceDialog beta = new ChoiceDialog(xx, yy, this);

            }
        }
    }

    void addNewest(int i, int yy, int xx) {
        Organism newOrganism;
        int freeNumber = -1;
        for (int z = 0; z < x * y;
                z++) {
            if (AnimalContainer[z] == null) {
                freeNumber = z;
                break;
            }
        }
        switch (i) {

            case 0:
                if (freeNumber != -1) {

                    //ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno antylope");
                    newOrganism = new Antelope(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'A';
                    GameFrame.buttons[xx][yy].setText("A");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "A";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 1:
                if (freeNumber != -1) {

                    //ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworzono lisa");
                    newOrganism = new Fox(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'F';
                    GameFrame.buttons[xx][yy].setText("F");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "F";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 2:
                if (freeNumber != -1) {

                    //ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno owce");
                    newOrganism = new Sheep(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'S';
                    GameFrame.buttons[xx][yy].setText("S");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "S";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 3:
                if (freeNumber != -1) {

                    //ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno zolwia");
                    newOrganism = new Turtle(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'T';
                    GameFrame.buttons[xx][yy].setText("T");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "T";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 4:
                if (freeNumber != -1) {

                    // ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno wilka");
                    newOrganism = new Wolf(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'W';
                    GameFrame.buttons[xx][yy].setText("W");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "W";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 5:
                if (freeNumber != -1) {

                    // ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno trawe");
                    newOrganism = new Grass(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = '#';
                    GameFrame.buttons[xx][yy].setText("#");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "#";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 6:
                if (freeNumber != -1) {

                    // ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno guarane");
                    newOrganism = new Guarana(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'G';
                    GameFrame.buttons[xx][yy].setText("G");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "G";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 7:
                if (freeNumber != -1) {

                    // ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno mleczyk");
                    newOrganism = new SowThistle(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'L';
                    GameFrame.buttons[xx][yy].setText("L");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "L";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;
            case 8:
                if (freeNumber != -1) {

                    // ChoiceDialog beta = new ChoiceDialog(xx, yy, this);
                    System.out.println("Stworozno wilcze jagody");
                    newOrganism = new DeadlyNightshade(xx, yy, this);
                    newOrganism.number = freeNumber;
                    AnimalContainer[freeNumber] = new OrganismContainer();
                    AnimalContainer[freeNumber].organism = newOrganism;
                    animalBoard[xx][yy] = 'N';
                    GameFrame.buttons[xx][yy].setText("N");
                    GameFrame.repaint();

                    AnimalContainer[freeNumber].organism.name = "N";
                    board[xx][yy] = freeNumber;
                    if (organismAmount != x * y) {
                        organismAmount++;
                    }
                }
                break;

        }
    }
}
