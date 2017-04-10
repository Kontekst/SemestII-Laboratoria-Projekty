#pragma once
class Ksiazka
{
public:
	Ksiazka();
	~Ksiazka();
	virtual void wypisz() = 0;
	virtual char* dajNazwe() = 0;
	virtual Ksiazka* stworzKsiazke() = 0;
};

