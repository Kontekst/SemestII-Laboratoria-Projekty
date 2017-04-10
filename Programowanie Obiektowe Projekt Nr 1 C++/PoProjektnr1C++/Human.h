#pragma once
#include "Animal.h"

class Human :public Animal
{
public:
	Human(World& world, int x, int y);
	~Human();
};