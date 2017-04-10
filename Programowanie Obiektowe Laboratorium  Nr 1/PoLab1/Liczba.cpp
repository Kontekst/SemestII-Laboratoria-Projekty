#include "Liczba.h"
#include <iostream>
using namespace std;
Liczba::Liczba(double re)
{
	cout << "Konstruktor Liczba = " << re << endl;
	this->re = re;
}
Liczba::~Liczba(void)
{
	cout << "Destruktor " << *this << endl;
	cout << re << endl;
}
double Liczba::modul()
{
	if (this->re < 0) return this->re* (-1);
	else return this->re;
}
std::ostream & operator<<(std::ostream &out, Liczba &l)
{
	out << "Liczba rzeczywista: " << l.re << endl;
	return out;
}