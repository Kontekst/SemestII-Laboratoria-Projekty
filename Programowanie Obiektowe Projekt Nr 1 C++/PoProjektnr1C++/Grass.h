#pragma once
#include "Plant.h"
class Grass :public Plant
{
public:
	Grass(World& world, int x, int y);
	~Grass();
};