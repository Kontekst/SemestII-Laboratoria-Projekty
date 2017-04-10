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
#from WorldManager import WorldManager
class Organism():
    _x=0
    _y=0
    _number=0
    _initiative=0
    _age=0
    _strength=0
    _sign=0
    #_WorldManager=world
    def __init__(self,xx,yy,world,numberx,tempSign):
        self._number=numberx
        self._x=xx
        self._y=yy
        self.world=world
        self._sign=tempSign

    def action(self,animalBoard,nx,ny,animalContainer,board):
        return 0

    def returnX():
        return self._x

    def returnY():
        return self._y

    def returnNumber():
        return self._number

    def returnInitiative():
        return self._Initiative

    def returnAge():
        return self._age

    def returnStrength():
        return self._strength

    def returnSign():
        return self._sign
