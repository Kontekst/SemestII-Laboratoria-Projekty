
#include "Plant.h"



Plant::Plant(World& world, int x, int y) :
	Organism(world, x, y) {

}


Plant::~Plant()
{
}

int Plant::move(int mode, int lines, int columns, char ** board, Organism* Character) {

	int doMultiply = rand() % 5;
	if (doMultiply == 0 || doMultiply == 1)
	{
		int dx, dy, vectorX, vectorY, humanMove;
		bool flag = 1;
		vectorX = rand() % 3 - 1;
		vectorY = rand() % 3 - 1;
		dx = position[0] + vectorX;
		dy = position[1] + vectorY;
		if ((dx > 0) && (dx < (lines - 1)) && (dy>0) && (dy < (columns - 1))) {
			flag = 0;
		} while (flag == 1);
		return (10 * vectorX) + vectorY;
	}
	else {
		return 0;
	}
}

int  Plant::actionFight(Organism* Attacker, int lines, int columns, char ** board, int xEnemy, int yEnemy, Organism* Enemy) {
	return 1;
}

void  Plant::actionMove(int mode, int xEnemy, int yEnemy, char ** board) {

}