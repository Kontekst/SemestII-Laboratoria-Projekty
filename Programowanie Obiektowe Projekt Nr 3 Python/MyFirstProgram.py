#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kontekstowy
#
# Created:     22-05-2016
# Copyright:   (c) Kontekstowy 2016
# Licence:     <your licence>++++++++++++++++++++++++++++++++++++
#-------------------------------------------------------------------------------
import Tkinter,sys
from WorldManager import WorldManager
def choose1(main,gameOption):
    main.destroy()
    gameOption[0]=1

def choose2(main,gameOption):
    main.destroy()
    gameOption[0]=2

def main():
    gameOption=['1']
    main=Tkinter.Tk()
    def fce1(main=main, gameOption=gameOption):
        choose1(main,gameOption)
    def fce2(main=main, gameOption=gameOption):
        choose2(main,gameOption)
    l=Tkinter.Label(main,text="Wcisnij przycisk ponizej")
    p1=Tkinter.Button(main,text="Nowa Gra", command = fce1 )
    p2=Tkinter.Button(main,text="Wczytaj", command = fce2 )
    l.pack()
    p1.pack()
    p2.pack()
    main.mainloop()
    print(gameOption)
    try:
        world = WorldManager(9,7,gameOption[0])
    except ValueError as e:
        print('Blad- szerokosc lub wysokosc plansy nie moze rownac sie zero')
    while True:
        world.play()
if __name__ == '__main__':
    main()