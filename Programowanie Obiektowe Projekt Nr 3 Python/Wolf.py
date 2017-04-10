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
class Wolf(Animal):
    def __init__(self,xx,yy,world,numberx,tempSign):
        Animal.__init__(self,xx,yy,world,numberx,tempSign)
        self._initiative=5
        self._strength=9
        self._sign='W'
    def action(self,animalBoard,nx,ny,animalContainer,board):
        if animalBoard[self._x  + nx][self._y +ny] == -1:
            return 1
        if animalBoard[self._x + nx][self._y + ny] != -1:
            if animalBoard[self._x + nx][self._y + ny] == 'F':
                print("Wilk zabija lisa")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'T':
                print("Wilka zabija zolwia")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'W':
                if nx !=0 and ny !=0:
                    return 4
                else:
                    return 0
            if animalBoard[self._x + nx][self._y + ny] == 'A':
                print("Wilk zabija antylope")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'H':
                print("Wilk zabija czlowieka")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == '#':
                print("Wilk zjada trawe")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'G':
                print("Wilk zjada Guarane")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'N':
                print("Wilk zjada trujace wilcze jagody i ginie")
                return 5
            if animalBoard[self._x + nx][self._y + ny] == 'L':
                print("Wilk zjada mleczyk")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'S':
                print("Wilk zjada owce")
                return 2