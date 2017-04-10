#include <iostream>
#include <fstream>

#include "stdafx.h"
#include "Biblioteka.h"
#include "KsiazkaC.h"
#include "KsiazkaCpp.h"

using namespace std;

int main()
{
	ifstream wejscie("we.txt");
	ofstream wyjscie("wy.txt");
	if (!wyjscie) {
		cout << "Blad otwierania pliku!!!!!!!!!" << endl;
	}
	if (!wyjscie) {
		cout << "Blad otwierania pliku!!!!!!!!!" << endl;
	}
	{
		Ksiazka *wskaznik;
		KsiazkaCpp A("Metrologia");
		KsiazkaCpp B("LOTR");
		KsiazkaCpp C("Harry Potter");
		KsiazkaCpp D("Stra¿ Nocna");
		KsiazkaCpp E("Pieklo Pocztowe");
		KsiazkaC F("Alfa i Omega");
		KsiazkaC G("Przygody Beniamina");
		KsiazkaC H("Mount & Blade");
		KsiazkaC I(H);

		cout << "||||||||" << endl;
		cout << "Wypisanie nazw czterech ksiazek" << endl;
		A.wypisz();
		B.wypisz();
		G.wypisz();
		H.wypisz();
		cout << "||||||||" << endl;


		Biblioteka ETI;
		wskaznik = &A;
		ETI.dodaj(A);
		wskaznik = &B;
		ETI.dodaj(B);
		wskaznik = &C;
		ETI.dodaj(C);
		wskaznik = &D;
		ETI.dodaj(D);
		wskaznik = &F;
		ETI.dodaj(F);
		wskaznik = &G;
		ETI.dodaj(G);
		cout << "||||||||" << endl;
		cout << "A teraz wypisanie ETI" << endl;
		cout << ETI;
		cout << "||||||||" << endl;

		Biblioteka EIA;
		EIA = ETI;
		cout << "||||||||" << endl;
		cout << "A teraz wypisanie EIA :" << endl;
		cout << EIA;
		cout << "||||||||" << endl;

		Biblioteka OIO(ETI);
		wskaznik = &I;
		OIO.dodaj(I);
		cout << "||||||||" << endl;
		cout << "A teraz wypisanie OIO :" << endl;
		cout << OIO;
		cout << "||||||||" << endl;
		cout << "Kolejne wypisanie ETI" << endl;
		cout << ETI;

		cout << "||||||||" << endl;
		cout << "Wpisanie biblioteki do pliku tekstowego" << endl;
		wyjscie << ETI;
		cout << "||||||||" << endl;

		wejscie >> ETI;
		cout << "Nowa ilosc z CINa " << ETI.ilosc << endl;;
		cout << ETI;
		cout << "||||||||" << endl;

		cout << "KONIEC PROGRAMU" << endl;
	}
	cout << "Wcisnij dowolny klawisz aby zakonczyc dzialanie programu" << endl;
	getchar();
	getchar();
	return 0;
}

