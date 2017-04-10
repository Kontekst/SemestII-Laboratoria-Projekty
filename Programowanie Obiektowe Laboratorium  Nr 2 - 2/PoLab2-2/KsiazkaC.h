#pragma once
#include <iostream>

#include "Ksiazka.h"

using namespace std;

class KsiazkaC : public Ksiazka
{
public:
	char * nazwa;
	void wypisz();
	char * dajNazwe();
	KsiazkaC();
	KsiazkaC(char*);
	KsiazkaC(const KsiazkaC &);
	~KsiazkaC();
	KsiazkaC * stworzKsiazke();
};

