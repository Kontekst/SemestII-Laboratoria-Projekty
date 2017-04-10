/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectiveworld160553;

import java.awt.event.KeyListener;

/**
 *
 * @author Kontekstowy
 */
public class Organism {

    protected int x;
    protected int y;
    protected int initiative;
    protected int age;
    protected int strength;
    protected int number;
    protected String name;
    World actualWorld;

    Organism(int xx, int yy, World world) {
        this.x = xx;
        this.y = yy;
        this.actualWorld = world;
    }

    public int returnX() {
        return x;
    }

    public int returnY() {
        return y;
    }

    public int returnNumber() {
        return number;
    }

    public int returnStrength() {
        return strength;
    }

    public String returnName() {
        return name;
    }

    public int returnAge() {
        return age;
    }

    public int returnInitiative() {
        return initiative;
    }
    
    public void setX(int xx) {
        this.x=xx;
    }

    public void setY(int yy) {
        this.y=yy;
    }

    public void setNumber(int num) {
        this.number=num;
    }

    public void setStrength(int str) {
        this.strength=str;
    }

    public void setName(String tempName) {
        this.name=tempName;
    }

    public void setAge(int tempAge) {
        this.age=tempAge;
    }

    public void setInitiative(int tempInit) {
        this.initiative=tempInit;
    }

    public int action(char animalBoard[][], int nx, int ny, Organism me) {
        return 1;
    }

    public boolean multiply(int board[][], int x, int y, int nx, int ny) {
        boolean alfa = false;
        return alfa;
    }

    void addKeyListener(KeyListener keyListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
