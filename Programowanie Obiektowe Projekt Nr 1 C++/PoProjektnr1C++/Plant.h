#pragma once
#include "Organism.h"
class Plant : public Organism
{
public:
	Plant(World&, int, int);
	int move(int, int, int, char **, Organism*);
	void actionMove(int, int, int, char **);
	int actionFight(Organism*, int, int, char **, int, int, Organism*);
	~Plant();
};