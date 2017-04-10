#include "KsiazkaC.h"


KsiazkaC::KsiazkaC() {
	nazwa = NULL;
}

KsiazkaC::KsiazkaC(char * newNazwa)
{
	nazwa = newNazwa;
}

KsiazkaC::KsiazkaC(const KsiazkaC & original) {
	nazwa = original.nazwa;
}

KsiazkaC::~KsiazkaC()
{
	cout << "Dziala destruktor KsiazkiC" << endl;
}

void KsiazkaC::wypisz() {
	cout << nazwa << endl;
}

char* KsiazkaC::dajNazwe() {
	return nazwa;
}
KsiazkaC * KsiazkaC::stworzKsiazke() {
	return new KsiazkaC(*this);
}