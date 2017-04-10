#define _CRT_SECURE_NO_WARNINGS
#include "World.h"
#include "Organism.h"
#include "OrganismContainer.h"
#include "Sheep.h"
#include "Wolf.h"
#include "Fox.h"
#include "Human.h"
#include "Turtle.h"
#include "Antelope.h"
#include "MyException.h"
#include "Grass.h"
#include "SowThistle.h"
#include "Guarana.h"
#include "DeadlyNightshade.h"

World::World(int linesX, int columnsX, int gameOption, string fileName)
{
	logsCounter = 0;
	if (gameOption == 1) {
		//Stworzenie pola gry
		lines = linesX;
		columns = columnsX;

		if (lines == 0 || columns == 0) {

			throw MyException("Powazny blad danych wejsiocwych");
			cout << "Rzucam";
			//	return 1;
		}
		animalBoard = new int*[lines];
		board = new char*[lines];
		for (int i = 0; i < lines; i++) {
			board[i] = new char[columns];
			animalBoard[i] = new int[columns];
		}

		//Wyzerowanie pola gry
		for (int i = 0; i < lines; i++) {
			for (int k = 0; k < columns; k++) {
				board[i][k] = ' ';
				animalBoard[i][k] = NULL;
			}
		}

		//Obramowanie pola gry
		for (int i = 0; i < columns; i++) {
			board[0][i] = 'X';
			board[lines - 1][i] = 'X';
		}
		for (int i = 0; i < lines; i++) {
			board[i][0] = 'X';
			board[i][columns - 1] = 'X';
		}

		//Ustalenie poczatkowej liczby stworzen ( min 20 stworzen poczatkowych)
		realOrganismAmount = 20;
		realOrganismAmount += (lines*columns / 50);
		organismAmount = realOrganismAmount;
		//Inicjacja kntenera organizmow, tablic uzywanych do obliczenia priorytetu (kolejnosci) ruchu
		container = new OrganismContainer*[lines*columns];
		InitiativeAgeBoard = new int*[lines*columns];
		priority = new int[lines*columns];


		for (int i = 0; i < lines*columns; i++) {
			InitiativeAgeBoard[i] = new int[2];
		}

		for (int i = 0; i < lines*columns; i++) {
			container[i] = NULL;
		}

		for (int i = 0; i < lines*columns; i++) {
			for (int k = 0; k < 2; k++) {
				InitiativeAgeBoard[i][k] = 0;
			}
		}

		//Tworzenie poczatkowych stworzen
		srand(time(NULL));
		bool flag = 1;
		int px, py;

		for (int i = 0; i < realOrganismAmount; i++) {
			flag = 1;
			//3 Owce poczatkowe
			if (i == 0) {
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);//Dodaje na pomocnicza mape numer zwierzecia
				board[px][py] = 'H';
				firstObject = new Human(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;
			}
			//3 Owce poczatkowe
			if ((i > 0 && i < 4) || (i >= 28 && i < realOrganismAmount)) { //TODO 3
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);//Dodaje na pomocnicza mape numer zwierzecia
				board[px][py] = 's';
				firstObject = new Sheep(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;

			}
			//3 wilki poczatkowe
			if (i >= 4 && i < 7) {
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);
				board[px][py] = 'w';
				firstObject = new Wolf(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;
			}
			//3 lisy poczatkowe
			if (i >= 7 && i < 10) {
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);
				board[px][py] = 'f';
				firstObject = new Fox(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;
			}//3 zolwie poczatkowe
			if (i >= 10 && i < 13) {
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);
				board[px][py] = 't';
				firstObject = new Turtle(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;
			}
			//3 antylopy poczatkowe
			if (i >= 13 && i < 16) {
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);
				board[px][py] = 'a';
				firstObject = new Antelope(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;
			}
			//3 trawy poczatkowe
			/*if (i >= 16 && i < 19) {
				while (flag) {
					px = rand() % lines;
					py = rand() % columns;
					if (board[px][py] == ' ') {
						flag = 0;
					}
				}
				animalBoard[px][py] = (i + 1);
				board[px][py] = 'g';
				firstObject = new Grass(*this, px, py);
				container[i] = new OrganismContainer;
				container[i]->organism = firstObject;
			}
			//3 mlecze poczatkowe
			if (i >= 19 && i < 22) {
			while (flag) {
			px = rand() % lines;
			py = rand() % columns;
			if (board[px][py] == ' ') {
			flag = 0;
			}
			}
			board[px][py] = '#';
			firstObject = new SowThistle(*this, px, py);
			container[i] = new OrganismContainer;
			container[i]->organism = firstObject;
			animalBoard[px][py] = (i + 1);
			}
			//3 guarany poczatkowe
			if (i >= 22 && i < 25) {
			while (flag) {
			px = rand() % lines;
			py = rand() % columns;
			if (board[px][py] == ' ') {
			flag = 0;
			}
			}
			animalBoard[px][py] = (i + 1);
			board[px][py] = '%';
			firstObject = new Guarana(*this, px, py);
			container[i] = new OrganismContainer;
			container[i]->organism = firstObject;
			}
			//3 wilcze jagody poczatkowe
			if (i >= 25 && i < 28) {
			while (flag) {
			px = rand() % lines;
			py = rand() % columns;
			if (board[px][py] == ' ') {
			flag = 0;
			}
			}
			animalBoard[px][py] = (i + 1);
			board[px][py] = '!';
			firstObject = new DeadlyNightshade(*this, px, py);
			container[i] = new OrganismContainer;
			container[i]->organism = firstObject;
			}
			*/
		}

	}

	if (gameOption == 2) {
		if (gameOption == 2) {
			FILE * pFile;
			pFile = fopen(fileName.c_str(), "r");
			if (pFile != NULL)
			{
				int temp1;
				fscanf(pFile, "%d", &temp1);
				fscanf(pFile, "%d", &temp1);
				fscanf(pFile, "%d", &organismAmount);
				fscanf(pFile, "%d", &realOrganismAmount);
				fscanf(pFile, "%d", &logsCounter);
			}
			lines = linesX;
			columns = columnsX;
			if (lines == 0 || columns == 0) {
				throw MyException("Powazny blad danych wejsiocwych");
			}
			animalBoard = new int*[lines];
			board = new char*[lines];
			for (int i = 0; i < lines; i++) {
				board[i] = new char[columns];
				animalBoard[i] = new int[columns];
			}

			//Wyzerowanie pola gry
			for (int i = 0; i < lines; i++) {
				for (int k = 0; k < columns; k++) {
					board[i][k] = ' ';
					animalBoard[i][k] = 0;
				}
			}

			//Obramowanie pola gry
			for (int i = 0; i < columns; i++) {
				board[0][i] = 'X';
				board[lines - 1][i] = 'X';
			}
			for (int i = 0; i < lines; i++) {
				board[i][0] = 'X';
				board[i][columns - 1] = 'X';
			}

			container = new OrganismContainer*[lines*columns];
			InitiativeAgeBoard = new int*[lines*columns];
			priority = new int[lines*columns];

			for (int i = 0; i < lines*columns; i++) {
				InitiativeAgeBoard[i] = new int[2];
			}

			for (int i = 0; i < lines*columns; i++) {
				container[i] = NULL;
			}

			for (int i = 0; i < lines*columns; i++) {
				for (int k = 0; k < 2; k++) {
					InitiativeAgeBoard[i][k] = 0;
				}
			}

			for (int i = 0; i < organismAmount; i++)
			{
				int temp = 0, tempX = 0, tempY = 0;
				fgetc(pFile);
				char tempSign = fgetc(pFile);
				if (tempSign != '0') {
					cout << "Sign" << tempSign << endl;
					fgetc(pFile);
					fscanf(pFile, "%d", &tempX);
					cout << "X" << tempX << endl;
					fgetc(pFile);
					fscanf(pFile, "%d", &tempY);
					cout << "Y" << tempY << endl;
					fgetc(pFile);
					switch (tempSign) {
					case 'H':
						container[i] = new OrganismContainer;
						firstObject = new Human(*this, tempX, tempY);
						container[i]->organism = firstObject;
						break;
					case 'a':
						container[i] = new OrganismContainer;
						firstObject = new Antelope(*this, tempX, tempY);
						container[i]->organism = firstObject;
						break;
					case 'f':
						container[i] = new OrganismContainer;
						firstObject = new Fox(*this, tempX, tempY);
						container[i]->organism = firstObject;
						break;
					case 't':
						container[i] = new OrganismContainer;
						firstObject = new Turtle(*this, tempX, tempY);
						container[i]->organism = firstObject;
						break;
					case 's':
						container[i] = new OrganismContainer;
						firstObject = new Sheep(*this, tempX, tempY);
						container[i]->organism = firstObject;
						break;
					case 'w':
						container[i] = new OrganismContainer;
						firstObject = new Wolf(*this, tempX, tempY);
						container[i]->organism = firstObject;
						break;
					case 'g':
						container[i] = new OrganismContainer;
						firstObject = new Grass(*this, tempX, tempY);
						container[i]->organism = firstObject;
					case '#':
						container[i] = new OrganismContainer;
						firstObject = new SowThistle(*this, tempX, tempY);
						container[i]->organism = firstObject;
					case '%':
						container[i] = new OrganismContainer;
						firstObject = new Guarana(*this, tempX, tempY);
						container[i]->organism = firstObject;
					case '!':
						container[i] = new OrganismContainer;
						firstObject = new DeadlyNightshade(*this, tempX, tempY);
						container[i]->organism = firstObject;
					}
					//container[i]->organism->setSign(tempSign);
					fscanf(pFile, "%d", &temp);
					fgetc(pFile);
					cout << "Age" << temp << endl;
					if (container[i]->organism != NULL)
						container[i]->organism->setAge(temp);
					fscanf(pFile, "%d", &temp);
					fgetc(pFile);
					cout << "Strength" << temp << endl;
					if (container[i]->organism != NULL)
						container[i]->organism->setStrength(temp);
					fscanf(pFile, "%d", &temp);
					cout << "Inicjatywa" << temp << endl;
					fgetc(pFile);
					if (container[i]->organism != NULL) {
						container[i]->organism->setInitiative(temp);
						animalBoard[tempX][tempY] = (i + 1);
						board[tempX][tempY] = tempSign;
					}
				}
			}
			fclose(pFile);
		}
	}
}

World::~World()
{
	delete[]container;
}

int World::doTurn() {

	drawWorld();//Rysowanie swiata
	cout << endl << endl << logs;//Wypisanie zdarzen (logow) z gry
	gotoxy(1, 1);
	gotoxy(1, lines + 1);
	cout << "Wcisnij enter aby zaczac nowa ture" << endl;
	getchar(); //Rozpoczecie nowej tury
	gotoxy(1, lines + 1);
	cout << "                                  " << endl;
	gotoxy(1, lines + 1);
	logs.clear();//Czyszczenie logow


				 //   gotoxy( 1 , lines+ 1);
				 //getchar();
				 //	logs.clear();

				 //Pobranie inicjatyw i wiekow do tablicyu z ktorej bede wyliczal kolejnosc ruchow
	for (int i = 0; i < lines*columns; i++) {
		if (container[i] != NULL) {
			firstObject = container[i]->organism;
			InitiativeAgeBoard[i][0] = firstObject->getInitiative();
			InitiativeAgeBoard[i][1] = firstObject->getAge();
		}
		else {
			InitiativeAgeBoard[i][0] = 0;
			InitiativeAgeBoard[i][1] = 0;
		}
	}

	//Znalezienie najwiekszej inicjatywy
	int max = InitiativeAgeBoard[0][0];
	for (int i = 0; i < (lines*columns); i++) {
		priority[i] = 0;
		if (InitiativeAgeBoard[i][0]>max) {
			max = InitiativeAgeBoard[i][0];
		}
	}

	//Sortowanie inicjatyw
	int init = 1;
	for (max; max > 0; max--) {
		for (int j = 0; j < (lines*columns); j++) {
			if (InitiativeAgeBoard[j][0] == max) {
				priority[j] = init;
				init++;
			}
		}
	}
	//Sortowanie wedlug wieku przy tej samej inicjatywie
	//TODO sortuje z tym ze ich kolejnosc nie jest dokladna , ale najpierw decyduje inicjatywa poten wiek, a potem losowo
	for (int i = 0; i < (organismAmount); i++) {
		for (int j = 0; j < organismAmount; j++) {
			if ((InitiativeAgeBoard[i][1] < InitiativeAgeBoard[j][1]) && (InitiativeAgeBoard[i][0] == InitiativeAgeBoard[j][0]) && (j != i) && (priority[j]>priority[i] && (j > i)))
			{
				int temp = priority[i];
				priority[i] = priority[j];
				priority[j] = temp;
			}
			if ((InitiativeAgeBoard[i][1] > InitiativeAgeBoard[j][1]) && (InitiativeAgeBoard[i][0] == InitiativeAgeBoard[j][0]) && (j != i) && (priority[j] < priority[i]) && (j > i))
			{
				int temp = priority[i];
				priority[i] = priority[j];
				priority[j] = temp;
			}
			if ((InitiativeAgeBoard[i][1] > InitiativeAgeBoard[j][1]) && (InitiativeAgeBoard[i][0] == InitiativeAgeBoard[j][0]) && (j != i) && (priority[j] < priority[i]) && (i > j))
			{
				int temp = priority[i];
				priority[i] = priority[j];
				priority[j] = temp;
			}
			if ((InitiativeAgeBoard[i][1] < InitiativeAgeBoard[j][1]) && (InitiativeAgeBoard[i][0] == InitiativeAgeBoard[j][0]) && (j != i) && (priority[j] > priority[i]) && (i > j))
			{
				int temp = priority[i];
				priority[i] = priority[j];
				priority[j] = temp;
			}
		}
	}

	//Ruchy organizmow
	int number = 0, modeAction = 0, stregthEnemy = 0, xEnemy = 0, yEnemy = 0;
	int numberPriority = 1;
	for (int i = 0; i < organismAmount; i++) {
		number = organismAmount + 1;
		for (int k = 0; k < organismAmount + 1; k++) {//Znalezienie organizmu o najwiekszym priorytecie
			if (priority[k] == numberPriority) {
				number = k;
			}
		}
		numberPriority++;

		if (container[number] != NULL) {
			secondObject = container[animalBoard[container[number]->organism->getX()][container[number]->organism->getY()] - 1]->organism;
			int newPosition;
			do {
				newPosition = container[number]->organism->move(1, lines, columns, board, secondObject); //Obliczanie nowej pozycji
				if (newPosition == 99) {
					save();
				}
			} while (newPosition == 99);
			if (newPosition == 500) {
				return 0;
			}

			if (container[number]->organism->getSign() == 't') {//75% szansw ze zolw nie ruszy
				int temp = rand() % 4;
				if (temp > 0 && temp < 4) {
					newPosition - 0;
				}
			}
			//Przeprowadzenie walki / rozmana¿ania /ruchu
			switch (newPosition) {
				//Wspolczynniki o jekie organizm sie przesunie
			case (-11) : xEnemy = -1; yEnemy = -1; break;
			case (-10) : xEnemy = -1; yEnemy = 0; break;
			case (-9) : xEnemy = -1; yEnemy = 1; break;
			case (-1) : xEnemy = 0; yEnemy = -1; break;
			case (0) : xEnemy = 0; yEnemy = 0; break;
			case (1) : xEnemy = 0; yEnemy = 1; break;
			case (9) : xEnemy = 1; yEnemy = -1; break;
			case (10) : xEnemy = 1; yEnemy = 0; break;
			case (11) : xEnemy = 1; yEnemy = 1; break;

			case (-22) : xEnemy = -2; yEnemy = -2; break;
			case (-21) : xEnemy = -2; yEnemy = -1; break;
			case (-20) : xEnemy = -2; yEnemy = 0; break;
			case (-19) : xEnemy = -2; yEnemy = 1; break;
			case (-18) : xEnemy = -2; yEnemy = 2; break;
			case (-8) : xEnemy = -1; yEnemy = 2; break;
			case (-12) : xEnemy = -1; yEnemy = -2; break;
			case (-2) : xEnemy = 0; yEnemy = -2; break;
			case (2) : xEnemy = 0; yEnemy = 2; break;
			case (8) : xEnemy = 1; yEnemy = -2; break;
			case (12) : xEnemy = 1; yEnemy = 2; break;
			case (22) : xEnemy = 2; yEnemy = 2; break;
			case (21) : xEnemy = 2; yEnemy = -1; break;
			case (20) : xEnemy = 2; yEnemy = 0; break;
			case (19) : xEnemy = 2; yEnemy = -1; break;
			case (18) : xEnemy = 2; yEnemy = -2; break;
			}
			int p = container[number]->organism->getX();//Do zerowania poprzedniego pola
			int q = container[number]->organism->getY();//DO zerowania poprzedniego pola

														//Walka lub rozmnazanie
			if (container[number] != NULL) {
				if (board[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy] != ' ' &&  container[animalBoard[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy] - 1] != NULL) {

					//Rozmnazanie
					if ((container[number]->organism->getSign()) == (board[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy])) {

						int dx, dy, freeNumber = (-1);
						bool happen = 0;
						for (int k = -1; k < 2; k++) {
							for (int j = -1; j < 2; j++) {
								if (board[container[number]->organism->getX() + k][container[number]->organism->getY() + j] == ' ') {
									dx = k; dy = j;
									happen = 1;
								}
							}
						}
						if (happen == 1) {
							for (int z = 0; z < lines*columns; z++) {
								if (container[z] == NULL) {
									freeNumber = z;
									if (freeNumber >= organismAmount) {
										organismAmount++;
									}
									break;
								}
							}if (freeNumber != (-1)) {
								realOrganismAmount++;
								container[freeNumber] = new OrganismContainer;
								switch (container[number]->organism->getSign()) {
								case 's':
									firstObject = new Sheep(*this, container[number]->organism->getX() + dx, container[number]->organism->getY() + dy);
									animalBoard[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = (freeNumber + 1);
									board[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = 's';
									container[freeNumber]->organism = firstObject;
									logs += "Powstala nowa owca.  ";
									break;
								case 'w':
									firstObject = new Wolf(*this, container[number]->organism->getX() + dx, container[number]->organism->getY() + dy);
									animalBoard[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = (freeNumber + 1);
									board[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = 'w';
									container[freeNumber]->organism = firstObject;
									logs += "Powstal nowy wilk.  ";
									break;
								case 'f':
									firstObject = new Fox(*this, container[number]->organism->getX() + dx, container[number]->organism->getY() + dy);
									animalBoard[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = (freeNumber + 1);
									board[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = 'f';
									container[freeNumber]->organism = firstObject;
									logs += "Powstal nowy lis. ";
									break;
								case 't':
									firstObject = new Turtle(*this, container[number]->organism->getX() + dx, container[number]->organism->getY() + dy);
									animalBoard[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = (freeNumber + 1);
									board[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = 't';
									container[freeNumber]->organism = firstObject;
									logs += "Powstal nowy zolw. ";
									break;
								case 'a':
									firstObject = new Antelope(*this, container[number]->organism->getX() + dx, container[number]->organism->getY() + dy);
									animalBoard[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = (freeNumber + 1);
									board[container[number]->organism->getX() + dx][container[number]->organism->getY() + dy] = 'a';
									container[freeNumber]->organism = firstObject;
									logs += "Powstala nowa antylopa. ";
									break;
								}
								addCounter(2);
							}
						}
					}
					//Walka
					else {
						char tempSign[2];
						tempSign[0] = firstObject->getSign();
						tempSign[1] = container[number]->organism->getSign();
						int enemyNumber = animalBoard[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy];
						firstObject = container[animalBoard[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy] - 1]->organism;
						int myNumber = animalBoard[container[number]->organism->getX()][container[number]->organism->getY()];
						int zmienna = animalBoard[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy];//Pobieram numer organimzu ktroy atakuje
						int doDelete = container[number]->organism->actionFight(secondObject, lines, columns, board, xEnemy, yEnemy, firstObject);//Sumylacja walki
						if (doDelete == 0) {
						//	if (tempSign[0] != tempSign[1]) 
							logs = logs + "W walce ginie broniac sie " + tempSign[0] + " zabity przez " + tempSign[1];
							animalBoard[p][q] = 0;//Zeruje poprzednie pole
							animalBoard[container[number]->organism->getX()][container[number]->organism->getY()] = myNumber;
							container[enemyNumber - 1] = NULL;
							realOrganismAmount--;
						}
						if (doDelete == 2) {
						//	if (tempSign[0] != tempSign[1])
							logs = logs + "Probujac zaatakowac ginie " + tempSign[1] + " zabita/-y przez " + tempSign[0];
							animalBoard[p][q] = 0;
							container[myNumber - 1] = NULL;
							realOrganismAmount--;
						}
						
						addCounter(1);
					}
				}
				else
					if (board[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy] == ' ' && animalBoard[container[number]->organism->getX() + xEnemy][container[number]->organism->getY() + yEnemy] == 0) {
						//Ruch na pusta pozycje
						animalBoard[container[number]->organism->getX()][container[number]->organism->getY()] = 0;
						container[number]->organism->actionMove(1, xEnemy, yEnemy, board);
						animalBoard[container[number]->organism->getX()][container[number]->organism->getY()] = number + 1;
					}
			}
		}
	}

	//Dodanie wieku 
	for (int r = 0; r < (organismAmount); r++) {
		if (container[r] != NULL) {
			container[r]->organism->addAge();
		}
	}

	//Wyzerowanie pola gry
	for (int i = 1; i < (lines - 1); i++) {
		for (int k = 1; k < (columns - 1); k++) {
			board[i][k] = ' ';
		}
	}

	//Pobranie znakow do planszy
	for (int i = 0; i < (lines*columns); i++) {
		if (container[i] != NULL) {
			firstObject = container[i]->organism;
			int x = firstObject->getX();
			int y = firstObject->getY();
			char sign = firstObject->getSign();
			board[x][y] = sign;
		}
	}

	return 1;
}

void World::drawWorld() {
	//Rysowanie planszy
	system("cls");
	for (int i = 0; i < lines; i++) {
		for (int k = 0; k < columns; k++) {
			cout << board[i][k];
		}
		switch (i) {
		case 0:
			cout << " ENTER = tura";
			break;
		case 1:
			cout << " k = koniec";
			break;
		default:
			break;
		}
		cout << endl;
	}
}

void World::gotoxy(int x, int y)
{
	COORD c;
	c.X = x - 1;
	c.Y = y - 1;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), c);
}

void World::addCounter(int num) {
	logsCounter++;
	if (logsCounter >= num)
	{
		logsCounter = 0;
		logs += "\n";
	}
}

void World::save() {
	fstream file;
	cout << "Podaj nazwe pliku:\n";
	string name;
	cin >> name;
	file.open(name, std::ios::out);
	file << lines << "\n";
	file << columns << "\n";
	file << organismAmount << "\n";
	file << realOrganismAmount << "\n";
	file << logsCounter << "\n";
	for (int i = 0; i < organismAmount; i++)
	{
		if (this->container[i] != NULL)
		{
			file << container[i]->organism->getSign() << " ";
			file << container[i]->organism->getX() << " ";
			file << container[i]->organism->getY() << " ";
			file << container[i]->organism->getAge() << " ";
			file << container[i]->organism->getStrength() << " ";
			file << container[i]->organism->getInitiative() << " ";
			file << "\n";
		}
		else
		{
			file << "0\n";
		}
	}
}