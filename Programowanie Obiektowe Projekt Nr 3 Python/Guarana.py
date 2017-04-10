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
from Plant import Plant
from random import randint
class Guarana(Plant):
    def __init__(self,xx,yy,world,numberx,tempSign):
        Plant.__init__(self,xx,yy,world,numberx,tempSign)
        self._initiative=1
        self._strength=0
        self._sign='G'

    def action(self,animalBoard,nx,ny,animalContainer,board):
        if animalBoard[self._x  + nx][self._y +ny] == -1:
            multiplication=randint(0,15)
            if multiplication==1:
                if nx !=0 and ny !=0:
                    return 4
                else:
                    return 0
