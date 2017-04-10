#include "KsiazkaCpp.h"

KsiazkaCpp::KsiazkaCpp() {
};

KsiazkaCpp::KsiazkaCpp(string newNazwa)
{
	nazwa = newNazwa;
}

KsiazkaCpp::KsiazkaCpp(const KsiazkaCpp &original) {
	nazwa = original.nazwa;
};

KsiazkaCpp::~KsiazkaCpp()
{
	cout << "Dziala destruktor KsiazkiCpp" << endl;
}

void KsiazkaCpp::wypisz() {
	cout << nazwa << endl;
}
char * KsiazkaCpp::dajNazwe() {

	char *alfa;

	alfa = (char *)malloc(nazwa.size() + 1);
	memcpy(alfa, nazwa.c_str(), nazwa.size() + 1);

	return alfa;
}

KsiazkaCpp * KsiazkaCpp::stworzKsiazke() {
	return new KsiazkaCpp(*this);
}