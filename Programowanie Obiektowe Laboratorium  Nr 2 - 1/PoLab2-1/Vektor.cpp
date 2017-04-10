#include "Vektor.h"

Vektor::Vektor()
{
	cout << "Dziala konstruktor bezparametrowy" << endl;
	liczby = new int[0];
	rozmiar = 0;
}

Vektor::Vektor(const int tablica[], int ilosc) {
	cout << "Dziala konstruktor podstawowy" << endl;
	rozmiar = ilosc;
	liczby = new int[rozmiar];
	for (int i = 0; i < rozmiar; i++) {
		liczby[i] = tablica[i];
	}
}

Vektor::Vektor(const Vektor & oryginal) {
	if (rozmiar != oryginal.rozmiar) {
		rozmiar = oryginal.rozmiar;
		delete[] liczby;
		liczby = new int[rozmiar];
	}
	for (int i = 0; i < rozmiar; i++) {
		liczby[i] = oryginal.liczby[i];
	}
}

void Vektor::wypisz(ostream &out) {
	out << "Dziala funkcja wypisz" << endl;
	for (int i = 0; i < rozmiar; i++) {
		out << "Element nr " << i << " wynosi = " << liczby[i] << endl;
	}
}

Vektor::~Vektor()
{
	cout << "Dziala destruktor vektor dla aderesu" << this << endl;
	delete[] liczby;
}

ostream & operator<<(ostream &out, const Vektor &oryginal) {
	out << "Adres = " << &oryginal;
	out << "Rozmiar = " << oryginal.rozmiar;
	for (int i = 0; i < oryginal.rozmiar; i++) {
		out << "Element nr " << i << " wynosi = " << oryginal.liczby[i] << endl;
	}
	return out;
}

istream & operator>>(istream &in, Vektor &oryginal) {
	cout << "Operator >> wpisywania dla vektor" << endl;
	cout << "Wprowadz liczbe danych w wektorze :";
	int zmienna;
	in >> zmienna;
	oryginal.rozmiar = zmienna;
	oryginal.liczby = new int[oryginal.rozmiar];
	for (int i = 0; i < oryginal.rozmiar; i++) {
		cout << "Wprowadz liczbe nr : " << i;
		in >> oryginal.liczby[i];
	}
	return in;
}

Vektor& Vektor::operator=(const Vektor &oryginal) {
	if (rozmiar != oryginal.rozmiar) {
		rozmiar = oryginal.rozmiar;
		delete[] liczby;
		liczby = new int[rozmiar];
	}
	for (int i = 0; i < rozmiar; i++) {
		liczby[i] = oryginal.liczby[i];
	}
	return *this;
}