/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectiveworld160553;

import java.util.Random;

/**
 *
 * @author Kontekstowy
 */
public class SowThistle extends Plant {

    public SowThistle(int x, int y, World world) {
        super(x, y, world);
        this.name = "L";
    }
    
     @Override
    public boolean multiply(int board[][], int x, int beta, int nx, int ny) {
        Random rand = new Random();
        int l = rand.nextInt(5);
        if (l == 1) {
            if (board[x + nx][y + ny] == 0) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }
}
