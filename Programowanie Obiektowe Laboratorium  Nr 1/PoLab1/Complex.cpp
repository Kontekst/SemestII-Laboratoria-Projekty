#include "Complex.h"
#include <iostream>
using namespace std;

Complex::Complex(double xx, double yy)
{
	re = xx;
	im = yy;
}


Complex::~Complex()
{
}

double Complex::modul() {
	return sqrt((re * re) + (im * im));
}

std::ostream & operator<<(std::ostream &out, Complex &l) {
	out << l.re << " " << l.im << endl;
	return out;
}

Complex Complex::operator +(Complex & right) {
	return Complex(this->re + right.re, this->im + right.im);
}