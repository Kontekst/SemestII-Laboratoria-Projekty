#include <iostream>
#include <fstream>
#include "Vektor.h"
#include "VectorOfVectors.h"

using namespace std;

int main()
{
	int tab1[] = { 1,2,3,4,5 };
	int tab2[] = { 6,7,8,9,10,11,15 };
	ifstream wejscie("C:\\we.txt");
	ofstream wyjscie("C:\\wy.txt");
	{
		Vektor v1(tab1, 5);
		Vektor v2(tab2, 7);
		Vektor v3;
		Vektor v4(v2);
		v3 = v1;
		cout << "Koniec tworzenia wektorow pojedynczych i nadawania im wartosci" << endl;
		cout << "Wypisywanie" << endl;
		v1.wypisz();
		v2.wypisz();
		v3.wypisz();
		v4.wypisz();
	}
	cout << endl << endl << endl << "A teraz czas na wektory wektorow" << endl;
	{
		VectorOfVectors v5(2);
		VectorOfVectors v6;
		VectorOfVectors v7(v5);
		VectorOfVectors v8;
		cin >> v5;
		v8 = v5;
		wejscie >> v6;
		cout << v5;
		cout << "A teraz z pliku" << endl;
		cout << v6;
	}
	cout << "KONIEC" << endl;
	getchar();
	getchar();
	return 0;
}

