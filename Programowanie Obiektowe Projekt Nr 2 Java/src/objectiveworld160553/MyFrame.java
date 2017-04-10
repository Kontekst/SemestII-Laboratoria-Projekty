package objectiveworld160553;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Kontekstowy
 */
public class MyFrame extends JFrame {

    JButton[][] buttons;

    MyFrame(int x, int y, World myWorld) {
        JButton component = new JButton();
        // component.setBounds(0, 0, 0, 0);
        //component.addKeyListener(new MyKeyListener());

        //super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // pack();
        
        setResizable(false);
       setSize(750,750);
        setVisible(true);
        setLayout(null);
        buttons = new JButton[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int d = i;
                int e = j;
                buttons[i][j] = new JButton();
                buttons[i][j].setBounds(48 * i, 40 * j, 48, 40);
                buttons[i][j].addKeyListener(new KeyListener() {

                    public void keyTyped(KeyEvent e) {

                    }

                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {

                            case KeyEvent.VK_UP:
                                myWorld.runGame(1);
                                break;

                            case KeyEvent.VK_DOWN:
                                myWorld.runGame(2);

                                break;

                            case KeyEvent.VK_LEFT:
                                myWorld.runGame(3);
                                break;

                            case KeyEvent.VK_RIGHT:
                                myWorld.runGame(4);
                                break;

                            case KeyEvent.VK_SPACE:
                                myWorld.runGame(5);
                                break;

                            case KeyEvent.VK_S:
                                myWorld.save();
                                break;
                            default:
                                break;
                        }
                    }

                    public void keyReleased(KeyEvent e) {

                    }
                });

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Wcisnales klawiesz numer " +d+" "+e);
                        int ii = d;
                        int jj = e;
                        myWorld.addOrganism(d, e);
                    }
                });
                add(buttons[i][j]);
            }
        }
        add(component);
    }

}
