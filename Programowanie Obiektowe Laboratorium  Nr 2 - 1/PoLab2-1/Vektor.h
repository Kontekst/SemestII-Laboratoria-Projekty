#pragma once
#include <iostream>
#include <fstream>
using namespace std;

class Vektor
{
public:
	int *liczby;
	int rozmiar;
	Vektor();
	Vektor(const int tablica[], int size);
	Vektor(const Vektor &oryginal);
	~Vektor();
	void wypisz(ostream &out = cout);
	Vektor& operator=(const Vektor &oryginal);
	friend ostream & operator<<(ostream &out, const Vektor &oryginal);
	friend istream & operator>>(istream &in, Vektor &oryginal);
};

