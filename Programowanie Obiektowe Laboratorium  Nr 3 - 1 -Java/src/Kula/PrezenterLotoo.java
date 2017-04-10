/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kacper Łęgowski
 */
package Kula;
import java.util.Scanner;


public class PrezenterLotoo {
    
    public static void main(String[] args) {
        PrezenterLotoo tadzio_sznuk = new PrezenterLotoo();
        MaszynaLosujaca maszyna = new MaszynaLosujaca();
       
 
        Kula[] koniec = new Kula[6];
        
        int czas = tadzio_sznuk.witaj();
        maszyna.start();
        
        try{
            Thread.sleep(czas*1000);
        } catch(InterruptedException e){
            
        }
        
        koniec = maszyna.stop();
        tadzio_sznuk.pokazWynik(koniec);
        
    }
    
        public int witaj(){
        System.out.println("Witamy, tutaj Tadzio Sznuk i to nie będzie 1 z 10 tylko losownaie LOTTO!!!!!!!!");
        Scanner scan = new Scanner(System.in);
            System.out.print("Proszę podać czas losowania :");
        int x = scan.nextInt();
        return x;
        }
        
        public void pokazWynik(Kula koniec[]){
            System.out.println("Wyniki losowania :");
        for(int i = 0; i < koniec.length; i++){
            System.out.print(koniec[i].numer);
            if(koniec[i].oszukana){ 
               System.out.println("(oszukana)"); //oznaczenie kuli oszukanej
            }
            else{
                System.out.println();
            }
        }
        }
}