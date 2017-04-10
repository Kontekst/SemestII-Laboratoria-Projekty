/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectiveworld160553;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Kontekstowy
 */
public class MyKeyListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent event) {
        Frame father = (Frame) event.getSource();
        switch (event.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.out.println("A");
                return;

            case KeyEvent.VK_UP:
                System.out.println("B");
                break;

            case KeyEvent.VK_DOWN:
           System.out.println("C");

                break;

            case KeyEvent.VK_LEFT:
                    System.out.println("C");
                break;

            case KeyEvent.VK_RIGHT:
                break;

            case KeyEvent.VK_SPACE:
                break;

            case KeyEvent.VK_S:

                break;

            case KeyEvent.VK_L:

                break;
            default:
                System.out.println("X");
                        break;
                        
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }
}
