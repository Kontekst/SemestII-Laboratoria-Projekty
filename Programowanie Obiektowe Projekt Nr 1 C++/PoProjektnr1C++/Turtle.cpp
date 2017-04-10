
#include "Turtle.h"



Turtle::Turtle(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->strength = 2;
	this->initiative = 1;
	this->sign = 't';
}


Turtle::~Turtle()
{
}