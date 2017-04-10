#pragma once
#include <iostream>
#include <string>

#include "Ksiazka.h"

using namespace std;

class KsiazkaCpp : public Ksiazka
{
public:
	string nazwa;
	void wypisz();
	char * dajNazwe();
	KsiazkaCpp();
	KsiazkaCpp(string);
	KsiazkaCpp(const KsiazkaCpp &);
	~KsiazkaCpp();
	KsiazkaCpp * stworzKsiazke();
};

