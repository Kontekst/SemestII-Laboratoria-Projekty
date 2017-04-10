#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kontekstowy
#
# Created:     27-05-2016
# Copyright:   (c) Kontekstowy 2016
# Licence:     <your licence>
#-------------------------------------------------------------------------------
from Animal import Animal
class Fox(Animal):
    def __init__(self,xx,yy,world,numberx,tempSign):
        Animal.__init__(self,xx,yy,world,numberx,tempSign)
        self._initiative=7
        self._strength=3
        self._sign='F'

    def action(self,animalBoard,nx,ny,animalContainer,board):
        if animalBoard[self._x  + nx][self._y +ny] == -1:
            return 1
        if animalBoard[self._x + nx][self._y + ny] != -1:
            if animalBoard[self._x + nx][self._y + ny] == 'W':
                print("Lis spotkal wilka, ale zdazyl uciec")
                return 0
            if animalBoard[self._x + nx][self._y + ny] == 'T':
                print("Lis spotkal zolwia, ale zostal odparty")
                return 0
            if animalBoard[self._x + nx][self._y + ny] == 'F':
                if nx !=0 and ny !=0:
                    return 4
                else:
                    return 0
            if animalBoard[self._x + nx][self._y + ny] == 'A':
                print("Lis spotkal antylope, ale zdazyl uciec")
                return 0
            if animalBoard[self._x + nx][self._y + ny] == 'H':
                print("Lis spotkal czlowieka, ale zdazyl uciec")
                return 0
            if animalBoard[self._x + nx][self._y + ny] == '#':
                print("Lis zjada trawe")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'G':
                print("Lis zjada Guarane")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'N':
                print("Lis zjada trujace wilcze jagody i ginie")
                return 5
            if animalBoard[self._x + nx][self._y + ny] == 'L':
                print("Lis zjada mleczyk")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'S':
                print("Lis zjada owce")
                return 2
