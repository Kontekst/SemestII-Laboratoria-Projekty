#include "Liczba.h"
#include <ostream>
class Complex : public WartoscLiczbowa
{
protected:
	double re;
	double im; //czesc urojona
public:
	~Complex(void);
	Complex(double re = 0, double im = 0);
	Complex operator +(Complex &);
	friend std::ostream & operator<< (std::ostream &out, Complex &l);
	double modul();
	void wypisz(std::ostream &out)
	{
		out << *this;
	}
};