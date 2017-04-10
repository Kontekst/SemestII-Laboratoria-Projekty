#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kontekstowy
#
# Created:     24-05-2016
# Copyright:   (c) Kontekstowy 2016
# Licence:     <your licence>
#-------------------------------------------------------------------------------
from Animal import Animal
class Sheep(Animal):
    #print(self._x)
    def __init__(self,xx,yy,world,numberx,tempSign):
        Animal.__init__(self,xx,yy,world,numberx,tempSign)
        self._initiative=4
        self._strength=4
        self._sign='S'

    def action(self,animalBoard,nx,ny,animalContainer,board):
        if animalBoard[self._x  + nx][self._y +ny] == -1:
            return 1
        if animalBoard[self._x + nx][self._y + ny] != -1:
            if animalBoard[self._x + nx][self._y + ny] == 'F':
                print("Owca zabija lisa")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'T':
                print("Owca atakuje zolwia , ale zostala odparta")
                return 0
            if animalBoard[self._x + nx][self._y + ny] == 'W':
                print("Owca atakuje wilka , ale zostala zabita")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == 'A':
                print("Owca atakuje antylope i ja zabija")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'H':
                print("Owca atakuje czlowieka , ale zostala zabita")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == '#':
                print("Owca zjada trawe")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'G':
                print("Owca zjada Guarane")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'N':
                print("Owca zjada trujace wilcze jagody i ginie")
                return 5
            if animalBoard[self._x + nx][self._y + ny] == 'L':
                print("Owca zjada mleczyk")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'S':
                if nx !=0 and ny !=0:
                    return 4
                else:
                    return 0