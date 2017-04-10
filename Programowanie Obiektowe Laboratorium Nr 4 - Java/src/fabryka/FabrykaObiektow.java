package fabryka;
/**
 *
 * @author Kacper Łęgowski
 */
public class FabrykaObiektow implements Fabryka{
	public Figura zwrocFigure(String typ, int a, int b, int c) throws Wyjatek
	{
            if(typ == "trojkat"){
                        return new Trojkat(a,b,c);
                    }
             else if(typ == "prostokat") {
                    return new Prostokat(a,b);
                }
             else {
                 throw new Wyjatek(typ);
             }
        }
}
