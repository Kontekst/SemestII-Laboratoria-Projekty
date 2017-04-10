
#include "Animal.h"

Animal::Animal(World& world, int x, int y) :
	Organism(world, x, y) {

}

Animal::~Animal() {

}

int Animal::move(int mode, int lines, int columns, char ** board, Organism* Character) {
	int dx, dy, vectorX, vectorY, humanMove;
	bool flag = 1;
	if (mode == 1 && Character->getSign() == 'H') {
		cout << "Twoj ruch" << endl;
		do {

			HANDLE hInput = GetStdHandle(STD_INPUT_HANDLE);
			DWORD NumInputs = 0;
			DWORD InputsRead = 0;
			bool run = true;

			INPUT_RECORD irInput;

			GetNumberOfConsoleInputEvents(hInput, &NumInputs);

			while (run)
			{

				ReadConsoleInput(hInput, &irInput, 1, &InputsRead);
				switch (irInput.Event.KeyEvent.wVirtualKeyCode)
				{
				case 0x1B:
					return 500;
					break;
				case 0x53:
					cout << "Zapisywanie do pliku" << endl;
					return 99;
					break;
				case VK_LEFT:
					vectorX = 0;
					vectorY = -1;
					run = false;
					break;
				case VK_UP:
					vectorX = -1;
					vectorY = 0;
					run = false;
					break;
				case VK_RIGHT:
					vectorX = 0;
					vectorY = 1;
					run = false;
					break;
				case VK_DOWN:
					vectorX = 1;
					vectorY = 0;
					run = false;
					break;
				}
				if (run == false) {//Kontrola aby czlowiek nie wyszedl za plansze
					dx = position[0] + vectorX;
					dy = position[1] + vectorY;
					if ((dx > 0) && (dx < (lines - 1)) && (dy>0) && (dy < (columns - 1))) {
						run = false;
					}
					else
					{
						run = true;
					}
				}
			}

			dx = position[0] + vectorX;
			dy = position[1] + vectorY;
			if ((dx > 0) && (dx < (lines - 1)) && (dy>0) && (dy < (columns - 1))) {
				flag = 0;
			}
			return (10 * vectorX) + vectorY;
		} while (flag == 1);

	}
	else if (mode == 1) {
		do {
			if (Character->getSign() == 'a') {
				vectorX = rand() % 5 - 2;
				vectorY = rand() % 5 - 2;
				dx = position[0] + vectorX;
				dy = position[1] + vectorY;
				if ((dx > 0) && (dx < (lines - 2)) && (dy>0) && (dy < (columns - 2))) {
					flag = 0;
				}
			}
			else {
				vectorX = rand() % 3 - 1;
				vectorY = rand() % 5 - 2;
				dx = position[0] + vectorX;
				dy = position[1] + vectorY;
				if ((dx > 0) && (dx < (lines - 1)) && (dy>0) && (dy < (columns - 1))) {
					flag = 0;
				}
			}
		} while (flag == 1);
		return (10 * vectorX) + vectorY;
	}
	return 0;
}

int Animal::actionFight(Organism* Attacker, int lines, int columns, char ** board, int xEnemy, int yEnemy, Organism* Enemy) {

	if (Enemy->getSign() == 'a') {
		int random = rand() % 2;
		if (random == 1) {
			return 1;
		}
		//TODO
	}
	if ((Enemy->getSign() == 't') && (Attacker->getStrength() < 5)) {
		//TODO
		return 1;
	}
	else if (this->getStrength() >= Enemy->getStrength()) {
		board[position[0]][position[1]] = ' ';
		this->position[0] += xEnemy;
		this->position[1] += yEnemy;
		board[position[0]][position[1]] = this->sign;
		return 0;
	}
	else if (Attacker->getSign() == 'f') {
		return 1;
	}
	else {
		board[position[0]][position[1]] = ' ';
		return 2;
	}
}

void Animal::actionMove(int mode, int xEnemy, int yEnemy, char ** board) {
	board[position[0]][position[1]] = ' ';
	this->position[0] += xEnemy;
	this->position[1] += yEnemy;
	board[position[0]][position[1]] = this->sign;
}