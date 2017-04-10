package fabryka;
/**
 *
 * @author Kacper Łęgowski
 */
public class Figury
{
 public static void main(String[] args) throws Wyjatek 
 {
     try{
	 FabrykaObiektow fabryka = new FabrykaObiektow();
         Figura figura = fabryka.zwrocFigure("prostokat",10,20,0);
         Figura trojkat = fabryka.zwrocFigure("trojkat",10,10,10);
         Figura obj1 = fabryka.zwrocFigure("prostokat",90,21,0);
        Figura obj = fabryka.zwrocFigure("gasdsadsa",202,22,12);
        
         
         System.out.println(figura.toString());
         System.out.println(trojkat.toString());
         System.out.println(obj1.toString());
        System.out.println(obj.toString());
    }
     catch(Wyjatek w) {
         w.printStackTrace();
     }
 }
}