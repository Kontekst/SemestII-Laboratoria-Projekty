
#include "Organism.h"

Organism::Organism(World& worldRef, int x, int y) :
	world(worldRef)
{
	this->age = 0;
	this->position[0] = x;
	this->position[1] = y;
}


Organism::~Organism() {

}

char Organism::getSign() {
	return sign;
}

int Organism::move(int mode, int lines, int columns, char ** board, Organism* Character) {
	return 0;
}

int Organism::actionFight(Organism* Attacker, int lines, int columns, char ** board, int xEnemy, int yEnemy, Organism* Enemy) {
	return 1;
}

void Organism::actionMove(int, int, int, char **) {

}

int Organism::getX() {
	return position[0];
}

int Organism::getStrength() {
	return strength;
}

void Organism::addAge() {
	this->age = this->age + 1;
}

int Organism::getY() {
	return position[1];
}

int Organism::getInitiative() {
	return initiative;
}

int Organism::getAge() {
	return age;
}

void Organism::setX(int z) {
	position[0] = z;
}

void Organism::setStrength(int z) {
	strength = z;
}

void Organism::setY(int z) {
	position[1] = z;
}

void Organism::setInitiative(int z) {
	initiative = z;
}

void Organism::setAge(int z) {
	age = z;
}
void Organism::setSign(char z) {
	sign = z;
}