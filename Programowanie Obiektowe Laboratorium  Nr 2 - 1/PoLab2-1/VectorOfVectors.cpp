#include "VectorOfVectors.h"

VectorOfVectors::VectorOfVectors()
{
	vektory = NULL;
	rozmiarb = NULL;
}


VectorOfVectors::VectorOfVectors(int size) {
	cout << "Standardowy konstruktor wektorow" << endl;
	int tab[] = { 0 };
	rozmiarb = size;
	vektory = new Vektor[rozmiarb];
	for (int i = 0; i < rozmiarb; i++) {
		vektory[i] = Vektor(tab, 1);
	}
}

VectorOfVectors::VectorOfVectors(const VectorOfVectors & oryginal) {
	if (rozmiarb != oryginal.rozmiarb) {
		delete[]vektory;
		rozmiarb = oryginal.rozmiarb;
		vektory = new Vektor[rozmiarb];
	}
	for (int i = 0; i < rozmiarb; i++) {
		vektory[i] = Vektor(oryginal.vektory[i].liczby, oryginal.rozmiarb);
	}
}

VectorOfVectors::~VectorOfVectors()
{
	cout << "Destruktor wektora wektorow" << this << endl;
	delete[] vektory;
}

VectorOfVectors& VectorOfVectors:: operator=(const VectorOfVectors &oryginal) {
	VectorOfVectors temp(oryginal);
	swap(this->rozmiarb, temp.rozmiarb);
	swap(this->vektory, temp.vektory);

	return *this;
}
ostream & operator<<(ostream &out, const VectorOfVectors &oryginal) {
	out << "Rozmiar " << oryginal.rozmiarb << endl;
	for (int i = 0; i < oryginal.rozmiarb; i++) {
		out << "Obiekt vector nr" << i << " " << oryginal.vektory[i];
	}
	return out;
}
istream & operator>>(istream &in, VectorOfVectors &oryginal) {
	cout << "Wpisz liczbe " << endl;
	int liczba = 0;
	in >> liczba;
	oryginal.rozmiarb = liczba;
	oryginal.vektory = new Vektor[oryginal.rozmiarb];
	for (int i = 0; i < oryginal.rozmiarb; i++) {
		in >> oryginal.vektory[i];
	}
	return in;
}
