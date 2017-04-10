
#include "SowThistle.h"

SowThistle::SowThistle(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->strength = 0;
	this->initiative = 1;
	this->sign = '#';
}

SowThistle::~SowThistle()
{
}