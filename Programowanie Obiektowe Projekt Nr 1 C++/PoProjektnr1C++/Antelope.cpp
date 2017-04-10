
#include "Antelope.h"



Antelope::Antelope(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->strength = 4;
	this->initiative = 4;
	this->sign = 'a';
}

Antelope::~Antelope()
{
}