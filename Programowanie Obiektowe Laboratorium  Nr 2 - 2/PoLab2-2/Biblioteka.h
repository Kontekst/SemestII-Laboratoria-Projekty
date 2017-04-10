#pragma once
#include <iostream>
#include <string>

#include "KsiazkaC.h"
#include "KsiazkaCpp.h"

using namespace std;
class Biblioteka
{
public:
	int ilosc;
	Ksiazka ** zbior;
	//Ksiazka *wskaznik;
	//KsiazkaCpp test;
	//string nazwaTest;

	Biblioteka();
	Biblioteka(const Biblioteka &);
	~Biblioteka();

	void dodaj(Ksiazka &original);

	friend ostream& operator <<(ostream & out, Biblioteka& original);
	friend istream& operator >>(istream & in, Biblioteka& original);
	Biblioteka & operator=(const Biblioteka& original);

	friend class KsiazkaCpp;
	friend class KsiazkaC;
};

