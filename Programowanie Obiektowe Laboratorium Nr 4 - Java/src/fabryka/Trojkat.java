/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabryka;
import java.lang.Math;
/**
 *
 * @author Kacper Łęgowski
 */
public class Trojkat extends Figura
{
    double a,b,c;
    
    Trojkat(float a, float b, float c)
	{
		this.name="Trojkat";
		try
		{
			if(weryfikacja(a,b,c));
			this.a=a;
			this.b=b;
			this.c=c;
		}
		catch (Wyjatek w)
		{
			w.printStackTrace();
		}
	}
    
    public double pole(){
        double p = (a+b+c)/2;
        return Math.sqrt((p-a)*(p-b)*(p-c));
    }
    
    public double obwod()
    {
        return a+b+c;
    }
    
    private boolean weryfikacja(float a,float b, float c) throws Wyjatek 
	 {
	 boolean ok = false;
               if(  (a > 0) && (b > 0) && (c>0)){
                   ok = true;
               }
               
	 if (!ok){
	 throw new Wyjatek(name);
         }
	 return ok;
	 }
}
