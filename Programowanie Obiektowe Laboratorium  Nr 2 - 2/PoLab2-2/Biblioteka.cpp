#include "Biblioteka.h"

Biblioteka::Biblioteka()
{
	ilosc = 0;
	zbior = new Ksiazka*[125];
}


Biblioteka::Biblioteka(const Biblioteka & original) {
	this->ilosc = original.ilosc;
	zbior = new Ksiazka*[125];
	for (int i = 0; i < ilosc; i++) {
		zbior[i] = original.zbior[i];
	}
}

Biblioteka::~Biblioteka()
{
	cout << "Dziala destruktor biblioteki" << endl;
	delete[] zbior;
}

void Biblioteka::dodaj(Ksiazka &original) {
	cout << "Dodawanie do biblioteki ksiazki ";
	cout << original.stworzKsiazke() << " ";
	original.wypisz();
	zbior[ilosc] = &original;
	ilosc = ilosc + 1;
}

ostream& operator <<(ostream & out, Biblioteka& original) {
	for (int i = 0; i < original.ilosc; i++) {
		out << original.zbior[i]->dajNazwe() << endl;;
	}
	return out;
}
/*
istream& operator >>(istream & in, Biblioteka& original) {
cout << "Wpisz nazwe ksiazki" << endl;
string name;
cin >> name;
original.test.nazwa = name;
original.wskaznik = &original.test;
original.zbior[original.ilosc] = original.wskaznik;
original.ilosc++;

return in;
}*/
//Druga Opcja

istream& operator >>(istream & in, Biblioteka& original) {
	in >> original.ilosc;
	original.zbior = new Ksiazka*[125];
	for (int i = 0; i < original.ilosc; i++) {
		string nazwaalfa;
		in >> nazwaalfa;
		original.zbior[i] = new KsiazkaCpp(nazwaalfa);

	}

	return in;
}

Biblioteka & Biblioteka::operator=(const Biblioteka& original) {
	Biblioteka temp(original);
	swap(this->ilosc, temp.ilosc);
	swap(this->zbior, temp.zbior);
	return*this;
}

