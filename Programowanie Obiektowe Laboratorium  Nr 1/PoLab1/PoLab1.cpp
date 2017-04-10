#include <iostream>

#include "stdafx.h"
#include "Liczba.h"
#include "WartoscLiczbowa.h"
#include "Complex.h"

using namespace std;

int main()
{
	{
		cout << "Start" << endl;
		Liczba foxtrot(5);
		cout << foxtrot;
	}

	cout << "Przerwa" << endl;
	Liczba denna(5);
	Complex alfa(5, 4);
	Complex beta(7, 5);
	Complex *gamma = new Complex(5, 4);

	cout << endl << "|||" << endl;

	WartoscLiczbowa *epsilon;
	epsilon = &alfa;
	cout << alfa.modul();
	cout << endl << "|||" << endl;
	epsilon = &denna;
	cout << denna.modul();

	cout << endl << "|||" << endl;

	cout << alfa << endl;
	alfa = alfa + beta;
	cout << alfa;
	cout << "Koniec" << endl;
	cout << gamma;
	getchar();
	getchar();
	return 0;
}