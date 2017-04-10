package fabryka;
/**
 *
 * @author Kacper Łęgowski
 */
abstract class Figura
{
 String name;
 abstract double pole();
 abstract double obwod();
 @Override
 public String toString()
    {
        String info = new String(name+"-> pole: "+pole()+", obwód: "+obwod());
        return info;
    }
}
