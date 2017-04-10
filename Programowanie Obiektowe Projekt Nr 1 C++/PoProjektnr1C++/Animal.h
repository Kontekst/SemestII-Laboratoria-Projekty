#pragma once

#include "Organism.h"

using namespace std;

class Animal : public Organism
{
public:
	Animal(World&, int, int);
	~Animal();
	int move(int, int, int, char **, Organism*);
	void actionMove(int, int, int, char **);
	int actionFight(Organism*, int, int, char **, int, int, Organism*);
};