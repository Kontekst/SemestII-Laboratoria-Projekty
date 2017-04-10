#pragma once
#include "Plant.h"
class DeadlyNightshade :public Plant
{
public:
	DeadlyNightshade(World& world, int x, int y);
	~DeadlyNightshade();
};