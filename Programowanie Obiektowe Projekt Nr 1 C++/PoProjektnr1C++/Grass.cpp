
#include "Grass.h"

Grass::Grass(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->strength = 0;
	this->initiative = 1;
	this->sign = 'g';
}

Grass::~Grass() {

}