#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <windows.h>
#include <stdio.h>

#include "World.h"
#include "MyException.h"

using namespace std;

void clearBuffer() {
	cin.clear();
	cin.ignore(10000, '\n');
}

//Tomasz Kontek 160553 grupa nr 4

int main()
{
	SetConsoleTitle(TEXT("World Simulation - Tomasz Kontek 160553"));
	int lines, columns, gameOption, optionSecond = 1;
	do {
		cout << "Witaj w symulacji swiata :D" << endl;
		cout << "Wcisnij klawisz 1 jesli chcesz zaczac nowa gre" << endl;
		cout << "Wcisnij klawisz 2 jesli chcesz wczytac gre" << endl;
		do {
			cin >> gameOption;
			if (gameOption != 1 && gameOption != 2) {
				cout << "Wpisales nieodpowiednia liczbe, wpisz 1 aby zaczac nowa gre lub wpisz 2 aby wczytac" << endl;
				clearBuffer();
			}
		} while (gameOption != 1 && gameOption != 2);
		system("cls");
		/////
		if (gameOption == 1) {
			cout << "Wpisz liczbe wierszy planszy na ktorej bedziesz gral (min. 5 , max. 20)" << endl;
			do {
				cin.clear();
				cin >> lines;
				if (lines < 5 || lines> 20) {
					cout << "Wpisales nieodpowiednia liczbe, powinna ona sie zawierac w przedziale <5,20> " << endl;
					clearBuffer();
				}
			} while (lines < 5 || lines > 20);
			system("cls");
			/////
			cout << "Wpisz liczbe kolumn planszy na ktorej bedziesz gral (min. 10, max. 65)" << endl;
			do {
				cin >> columns;
				if (columns < 10 || columns > 65) {
					cout << "Wpisales nieodpowiednia liczbe, powinna ona sie zawierac w przedziale <10,65> " << endl;
					clearBuffer();
				}
			} while (columns < 10 || columns > 65);
			system("cls");
		}

		/////
		try {
			string name;
			if (gameOption == 2) {
				FILE * pFile;
				cout << "Podaj nazwe pliku:\n";
				cin >> name;
				pFile = fopen(name.c_str(), "r");
				if (pFile != NULL)
				{
					fscanf(pFile, "%d", &lines);
					fscanf(pFile, "%d", &columns);
					cout << "Linie " << lines << endl;
					cout << "Kolumny" << columns << endl;
					fclose(pFile);
					getchar();
					getchar();
				}
			}
			World myWorld(lines, columns, gameOption, name);

			int play = 1;

			do {
				play = myWorld.doTurn();

			} while (play == 1);
		}
		catch (MyException& w) {
			cout << "Zlapano wyjatek - mapa ktora chcesz stworzyc lub wczytac ma za maly rozmiar" << endl;
			getchar();
			getchar();
		}
		system("cls");
		cout << "Wcisnij klawisz 1 jesli chcesz kontynuowac" << endl;
		cout << "Wcisnij klawisz 2 jesli chcesz przerwac gre" << endl;
		do {
			cin >> optionSecond;
			if (optionSecond != 1 && optionSecond != 2) {
				cout << "Wpisales nieodpowiednia liczbe, wpisz 1 aby zaczac nowa gre lub wpisz 2 aby zakonczyc" << endl;
				clearBuffer();
			}
		} while (optionSecond != 1 && optionSecond != 2);
	} while (optionSecond != 2);
	cout << "Dziekuje za skorzystanie z mojej aplikacji, wcisnij ENTER aby zakonczyc" << endl;
	getchar();
	return 0;
}
