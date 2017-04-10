#include "DeadlyNightshade.h"



DeadlyNightshade::DeadlyNightshade(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->strength = 99;
	this->initiative = 1;
	this->sign = '!';
}


DeadlyNightshade::~DeadlyNightshade()
{
}