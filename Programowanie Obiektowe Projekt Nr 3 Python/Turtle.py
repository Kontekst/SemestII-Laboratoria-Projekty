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
class Turtle(Animal):
    def __init__(self,xx,yy,world,numberx,tempSign):
        Animal.__init__(self,xx,yy,world,numberx,tempSign)
        self._initiative=1
        self._strength=2
        self._sign='T'

    def action(self,animalBoard,nx,ny,animalContainer,board):
        if animalBoard[self._x  + nx][self._y +ny] == -1:
            return 1
        if animalBoard[self._x + nx][self._y + ny] != -1:
            if animalBoard[self._x + nx][self._y + ny] == 'W':
                print("Zolw ginie atakujac wilka")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == 'F':
                print("Zolw ginie atakujac lisa")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == 'T':
                if nx !=0 and ny !=0:
                    return 4
                else:
                    return 0
            if animalBoard[self._x + nx][self._y + ny] == 'A':
                print("Zolw ginie atakujac antylope")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == 'H':
                print("Zolw ginie atakujac czlowieka")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == '#':
                print("Zolw zjada trawe")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'G':
                print("Zolw zjada Guarane")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'N':
                print("Zolw zjada trujace wilcze jagody i ginie")
                return 5
            if animalBoard[self._x + nx][self._y + ny] == 'L':
                print("Zolw zjada mleczyk")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'S':
                print("Zolw zjada owce")
                return 2