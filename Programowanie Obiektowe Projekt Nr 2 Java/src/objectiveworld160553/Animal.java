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
public class Animal extends Organism {

    public Animal(int x, int y, World world) {
        super(x, y, world);
    }

    @Override
    public int action(char animalBoard[][], int nx, int ny,Organism me) {
        return 1;
    }
}
