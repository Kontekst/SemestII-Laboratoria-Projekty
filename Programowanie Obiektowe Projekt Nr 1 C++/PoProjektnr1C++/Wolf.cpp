
#include "Wolf.h"



Wolf::Wolf(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->strength = 9;
	this->initiative = 5;
	this->sign = 'w';
}


Wolf::~Wolf()
{
}