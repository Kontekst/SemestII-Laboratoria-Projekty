
#include "Human.h"



Human::Human(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->strength = 5;
	this->initiative = 4;
	this->sign = 'H';
}


Human::~Human()
{
}