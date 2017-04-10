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
from Organism import Organism
class Plant(Organism):
    def __init__(self,xx,yy,world,numberx,tempSign):
        Organism.__init__(self,xx,yy,world,numberx,tempSign)

    def action(self,animalBoard,nx,ny,animalContainer,board):
        return 0