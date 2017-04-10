
#include "Fox.h"

Fox::Fox(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->strength = 3;
	this->initiative = 7;
	this->sign = 'f';
}


Fox::~Fox()
{
}