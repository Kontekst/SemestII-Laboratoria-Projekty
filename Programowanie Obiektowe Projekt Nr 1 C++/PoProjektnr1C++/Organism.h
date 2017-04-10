
#pragma once
#include "World.h"
class Organism
{
public:
	Organism(World&, int, int);
	virtual ~Organism();
	virtual int move(int, int, int, char **, Organism*) = 0;
	virtual void actionMove(int, int, int, char **) = 0;
	virtual int actionFight(Organism*, int, int, char **, int, int, Organism*) = 0;
	char getSign();
	void addAge();
	int getX();
	int getY();
	int getStrength();
	int getInitiative();
	int getAge();
	void setX(int);
	void setY(int);
	void setStrength(int);
	void setInitiative(int);
	void setAge(int);
	void setSign(char);
protected:
	int initiative;
	int position[2];
	int strength;
	int age;
	char sign;
private:
	World& world;
};