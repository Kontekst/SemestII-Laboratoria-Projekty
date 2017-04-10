
#pragma once
#include <iostream>
#include <string>
#include <ctime>
#include <fstream>

#include <windows.h>

class Organism;
class OrganismContainer;

using namespace std;

class World : public std::exception
{
public:
	int doTurn();
	World(int, int, int, string);
	~World();
private:
	void save();
	void drawWorld();
	void gotoxy(int, int);
	void addCounter(int);;
	string logs;
	OrganismContainer ** container;
	Organism *firstObject;
	Organism *secondObject;
	int *priority;
	char **board;
	int **animalBoard;
	int lines, columns;
	int organismAmount;
	int realOrganismAmount;
	int **InitiativeAgeBoard;
	int logsCounter;
};
