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
public class Plant extends Organism{
    public Plant(int x,int y, World world)
    {
        super(x,y,world);
        this.strength=0;
        this.initiative=0;
    }
    
     @Override
    public boolean multiply(int board[][],int x,int beta,int nx,int ny)
    {
        boolean ok=false;
        
        return ok;
    }
    
}