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
class Antelope(Animal):
    def __init__(self,xx,yy,world,numberx,tempSign):
        Animal.__init__(self,xx,yy,world,numberx,tempSign)
        self._initiative=4
        self._strength=4
        self._sign='A'

    def action(self,animalBoard,nx,ny,animalContainer,board):
        if animalBoard[self._x  + nx][self._y +ny] == -1:
            return 1
        if animalBoard[self._x + nx][self._y + ny] != -1:
            if animalBoard[self._x + nx][self._y + ny] == 'F':
                print("Antylopa zabija lisa")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'T':
                print("Zolw odpiera antylope")
                return 0
            if animalBoard[self._x + nx][self._y + ny] == 'A':
                if nx !=0 and ny !=0:
                    return 4
                else:
                    return 0
            if animalBoard[self._x + nx][self._y + ny] == 'W':
                print("Antylopa atakuje wilka lecz nie udaje sie to jej")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == 'H':
                print("Antylopa atakuje czlowieka lecz nie udaje sie to jej")
                return 3
            if animalBoard[self._x + nx][self._y + ny] == '#':
                print("Antylop zjada trawe")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'G':
                print("Antylopa zjada Guarane")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'N':
                print("Antylopa zjada trujace wilcze jagody i ginie")
                return 5
            if animalBoard[self._x + nx][self._y + ny] == 'L':
                print("Antylopa zjada mleczyk")
                return 2
            if animalBoard[self._x + nx][self._y + ny] == 'S':
                print("Antylopa zjada owce")
                return 2