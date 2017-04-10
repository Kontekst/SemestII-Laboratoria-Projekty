package fabryka;
/**
 *
 * @author Kacper Łęgowski
 */
class Prostokat extends Figura
{
 double a, b;
 public Prostokat(float a, float b) throws Wyjatek // Ta metoda rzuca wyjątek
 {
 name = "Prostokat";
       if (weryfikacja(a, b))
        {
            this.a = a;
            this.b = b;
        }
 }
 public double pole()
 {
    return a * b;
 }
 public double obwod()
 {
    return 2 * (a + b);
 }

 private boolean weryfikacja(float a,float b) throws Wyjatek // Ta też
 {
    boolean ok = (a > 0) && (b > 0);
    if (!ok)
    throw new Wyjatek(name);
    return ok;
 }
}