/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kula;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Kacper Łęgowski
 */
public class MaszynaLosujaca {
    Kula[] kule = new Kula[49];
    private Random rand = new Random();
    private Timer timer  = new Timer();
    
    public MaszynaLosujaca(){
        boolean trigger = false;
        int iter = 0; //ilosc kul oszukanych 
        for(int i = 0; i < kule.length; i++){
            if(iter <= 6){
                trigger = rand.nextBoolean();
                if(iter == 6){
                    trigger = false;
                    iter++;
                }
                if(trigger) iter++;
            }
            kule[i] = new Kula(i + 1, trigger);
        }
    }
    
    public void start(){
        MyTimerTask timer1_task = new MyTimerTask();
        timer.schedule(timer1_task, 10);
    }
    
    public Kula[] stop(){
        timer.cancel();
        Kula[] koniec = new Kula[6];
        for(int i = 0; i < koniec.length; i++){
            koniec[i] = kule[i];
        }
        return koniec;
    }
    
    private class MyTimerTask extends TimerTask{
        @Override
        public void run(){
            zamiana();
        }
    
    }
    
    private void zamiana(){
       int a,b;
       Kula tmp;
        
        a = rand.nextInt(48);
        b = rand.nextInt(48);
        tmp = kule[a];
        kule[a] = kule[b];
        kule[b] = tmp;
        
        for(int i = 0; i < kule.length; i++){
            if(kule[i].oszukana && i > 0){
                tmp = kule[i];
                kule[i] = kule[i - 1];
                kule[i - 1] = tmp;
            }
        }
    }
}

