
#include "Sheep.h"



Sheep::Sheep(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->strength = 4;
	this->initiative = 4;
	this->sign = 's';
}

Sheep::~Sheep()
{

}