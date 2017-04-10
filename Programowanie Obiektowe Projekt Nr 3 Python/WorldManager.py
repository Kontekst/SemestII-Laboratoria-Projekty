#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kontekstowy
#
# Created:     22-05-2016
# Copyright:   (c) Kontekstowy 2016
# Licence:     <your licence>
#-------------------------------------------------------------------------------
from pygame.locals import *
import re
from Organism import Organism
from Animal import Animal
from Plant import Plant
from Human import Human
from Sheep import Sheep
from Wolf import Wolf
from Turtle import Turtle
from Fox import Fox
from Antelope import Antelope
from Grass import Grass
from Guarana import Guarana
from DeadlyNightshade import DeadlyNightshade
from SowThistle import SowThistle
from OrganismContainer import OrganismContainer
from random import randint
import pygame,sys
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
class WorldManager():
    _x=0
    _y=0
    _organismAmount=22
    board = ([[]])# W niej trzymam numer organizmu ktory znajduje sie na tym polu ||| -1 oznacza ze nie ma tu zadnego oganizmu
    animalBoard=([[]])# W niej trzymam litere z oznaczeniem organizmu ||| -1 oznacza ze nie ma tu zadnego organizmu
    animalContainer=([None])# Tu trzymam obiekty organizmow
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
    def __init__(self,xx,yy,gameOption):
        print('Konstrukcja swiata')
        if xx==0 or yy==0:
            raise ValueError("Za mala plansza")
        if gameOption==1:
            print('Nowy swiat, wymiary ' , xx ,' na ',yy)
            self._x=xx
            self._y=yy

            if self._x<=0 or self._y<=0:
                print('Blad! Wiersze lub liczba kolumn <= 0')

            for i in range (self._x):
                for j in range (self._y):
                    self.board[i].append(-1)
                if(i!=self._x-1):
                    self.board.append([])

            for i in range (self._x):
                for j in range (self._y):
                    self.animalBoard[i].append(-1)
                if(i!=self._x-1):
                    self.animalBoard.append([])

            for i in range (self._x * self._y - 1 ): #CHECK !!!
                self.animalContainer.append(None)

            px=-1
            py=-1
#####################################################
            for i in range(self._organismAmount): # Poczatkowe tworzenie organizmow
                continueRandom=True
                while(continueRandom==True):
                    px=randint(0,self._x -1)
                    py=randint(0,self._y -1)
                    if self.animalBoard[px][py]== -1:
                        continueRandom=False
                if i==0:
                    print("Stworzono czlowieka na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'H'
                    newOrganism = Human(px, py, self,i,'H')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==1 or i ==2 or i ==3:
                    print("Stworzono owce na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'S'
                    newOrganism = Sheep(px, py, self,i,'S')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==4 or i ==5 or i==6:
                    print("Stworzono wilka na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'W'
                    newOrganism = Wolf(px, py, self,i,'W')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==7 or i ==8:
                    print("Stworzono zolwia na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'T'
                    newOrganism = Turtle(px, py, self,i,'T')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==9 or i ==10:
                    print("Stworzono lisa na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'F'
                    newOrganism = Fox(px, py, self,i,'F')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==11 or i ==12 or i ==13:
                    print("Stworzono antylope na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'A'
                    newOrganism = Antelope(px, py, self,i,'A')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==14 or i ==15:
                    print("Stworzono trawe na koordynatach (" , px , "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = '#'
                    newOrganism = Grass(px, py, self,i,'#')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==16 or i ==17:
                    print("Stworzono guarane na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'G'
                    newOrganism = Guarana(px, py, self,i,'G')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==18 or i ==19:
                    print("Stworzono wilcze jagody na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'N'
                    newOrganism = DeadlyNightshade(px, py, self,i,'N')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
                if i==20 or i ==21:
                    print("Stworzono mleczyk na koordynatach (" , px, "," , py , ")")
                    self.board[px][py] = i
                    self.animalBoard[px][py] = 'L'
                    newOrganism = SowThistle(px, py, self,i,'L')
                    box = OrganismContainer(newOrganism)
                    self.animalContainer[i] = box
        if gameOption==2:
            number=0
            przebieg=0
            plik = open("save.txt", "r")
            lines = plik.readlines()
            plik.close()
            serie=-1
            organismNumber=0
            for x in lines:
                serie=serie+1
                if serie==0:
                    x = x[:-1]
                    self._x=int(x)
                    print("X wynosi " + str(self._x))
                if serie==1:
                    x = x[:-1]
                    self._y=int(x)
                    print("Y wynosi " + str(self._y))
                    for i in range (self._x):
                        for j in range (self._y):
                            self.board[i].append(-1)
                        if(i!=self._x-1):
                            self.board.append([])

                    for i in range (self._x):
                        for j in range (self._y):
                            self.animalBoard[i].append(-1)
                        if(i!=self._x-1):
                            self.animalBoard.append([])

                    for i in range (self._x * self._y - 1 ): #CHECK
                        self.animalContainer.append(None)

                if serie ==2:
                    x = x[:-1]
                    number=int(x)
                    print("Number wynosi " + str(number))
                if serie > 2:
                    x = x[:-1]
                    x.split()
                    wordList = re.sub("[^\w]", " ",  x).split()
                    tempChar=wordList[0]
                    px=int(wordList[1])
                    py=int(wordList[2])
                    initiatitvex=int(wordList[3])
                   #age=int(wordList[4])
                    if tempChar=='H':
                         print("Stworzono czlowieka na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'H'
                         newOrganism = Human(px, py, self,organismNumber,'H')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='S':
                         print("Stworzono owce na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'S'
                         newOrganism = Sheep(px, py, self,organismNumber,'S')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='W':
                         print("Stworzono wilka na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'W'
                         newOrganism = Wolf(px, py, self,organismNumber,'W')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='T':
                         print("Stworzono zolwia na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'T'
                         newOrganism = Turtle(px, py, self,organismNumber,'T')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='A':
                         print("Stworzono antylope na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'A'
                         newOrganism = Antelope(px, py, self,organismNumber,'A')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='F':
                         print("Stworzono lisa na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'F'
                         newOrganism = Fox(px, py, self,organismNumber,'F')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='#':
                         print("Stworzono trawe na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = '#'
                         newOrganism = Grass(px, py, self,organismNumber,'#')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='G':
                         print("Stworzono guarane na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'G'
                         newOrganism = Guarana(px, py, self,organismNumber,'G')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='N':
                         print("Stworzono wilcze jagody na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'N'
                         newOrganism = DeadlyNightshade(px, py, self,organismNumber,'N')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1
                    if tempChar=='L':
                         print("Stworzono mlecz na koordynatach (" , px, "," , py , ")")
                         self.board[px][py] = organismNumber
                         self.animalBoard[px][py] = 'L'
                         newOrganism = SowThistle(px, py, self,organismNumber,'L')
                         box = OrganismContainer(newOrganism)
                         self.animalContainer[organismNumber] = box
                         organismNumber=organismNumber+1

            print("|||||||||||||||||")

# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
    def drawWorld(self,screen):
        for x in range(self._x):
            for y in range (self._y):
                if self.animalBoard[x][y]!= 0:
                    if self.animalBoard[x][y] =='H':
                        pygame.draw.rect(screen,(0,0,102),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='S':
                        pygame.draw.rect(screen,(255,153,51),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='W':
                        pygame.draw.rect(screen,(102,51,0),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='T':
                        pygame.draw.rect(screen,(0,255,255),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='F':
                        pygame.draw.rect(screen,(255,0,0),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='A':
                        pygame.draw.rect(screen,(102,0,102),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='#':
                        pygame.draw.rect(screen,(51,204,51),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='G':
                        pygame.draw.rect(screen,(0,51,0),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='N':
                        pygame.draw.rect(screen,(0,0,0),[y*25,x*25,25,25])
                    if self.animalBoard[x][y] =='L':
                        pygame.draw.rect(screen,(255,225,102),[y*25,x*25,25,25])
        pygame.display.update()
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
    def play(self):
        pygame.init()
        screen=pygame.display.set_mode((self._y*25,self._x*25))
        pygame.display.set_caption('160553 programowanie obiektowe - World')
        screen.fill((200,235,225))
        px=0
        py=0
        for i in range(self._x * self._y):
#####################################################
            if i==0 and self.animalContainer[i] == None:
                  self.drawWorld(screen) # Aktualizowanie planszy i ocekiwanie na przycisk w momecie gdy czlowiek nie zyje
                  humanMove=True
                  while humanMove==True:
                      for event in pygame.event.get():
                        if event.type==QUIT:
                            pygame.quit()
                            sys.exit()
                        if event.type ==pygame.KEYDOWN:
                            if event.key ==pygame.K_LEFT:
                                    humanMove=False
                                    break
                            if event.key==pygame.K_RIGHT:
                                    humanMove=False
                                    break
                            if event.key==pygame.K_DOWN:
                                    humanMove=False
                                    break
                            if event.key==pygame.K_UP:
                                    humanMove=False
                                    break
#####################################################
            if i==0 and self.animalContainer[i] != None: # Aktualizowanie planszy i ocekiwanie na przycisk w momecie gdy czlowiek nie zyje
                if self.animalContainer[i].organism._sign!='H':
                    self.drawWorld(screen)
                    humanMove=True
                    while humanMove==True:
                        for event in pygame.event.get():
                          if event.type==QUIT:
                              pygame.quit()
                              sys.exit()
                          if event.type ==pygame.KEYDOWN:
                              if event.key ==pygame.K_LEFT:
                                      humanMove=False
                                      break
                              if event.key==pygame.K_RIGHT:
                                      humanMove=False
                                      break
                              if event.key==pygame.K_DOWN:
                                      humanMove=False
                                      break
                              if event.key==pygame.K_UP:
                                      humanMove=False
                                      break
#####################################################
            if i==0 and self.animalContainer[i] != None: # Ruch czlowieka
                if self.animalContainer[i].organism._sign=='H':
                    self.drawWorld(screen)
                    humanMove=True
                    while humanMove==True:
                        for event in pygame.event.get():
                            if event.type==QUIT:
                                pygame.quit()
                                sys.exit()
                            if event.type ==pygame.KEYDOWN:
                                if event.key ==pygame.K_s:
                                    plik=open("save.txt","w")
                                    plik.write(str(self._x) + "\n")
                                    plik.write(str(self._y) + "\n")
                                    number=0

                                    for t in range(self._x*self._y):
                                        if self.animalContainer[t] != None:
                                            number=number  +1
                                    plik.write(str(number))

                                    for t in range(self._x*self._y):
                                        if self.animalContainer[t] != None:
                                            plik.write( "\n" + str(self.animalContainer[t].organism._sign) + " " + str(self.animalContainer[t].organism._x) + " " + str(self.animalContainer[t].organism._y) + " " + str(self.animalContainer[t].organism._initiative) + " " + str(self.animalContainer[t].organism._age))
                                    print("Zapisano do pliku")
                                    plik.close()

                                if event.key ==pygame.K_LEFT:
                                    if self.animalContainer[i].organism._y != 0:
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalContainer[i].organism._y -= 1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = 'H'
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = i
                                        humanMove = False
                                if event.key==pygame.K_RIGHT:
                                    if self.animalContainer[i].organism._y != self._y -1 :
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalContainer[i].organism._y +=1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y]='H'
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y]= i
                                        humanMove = False
                                if event.key==pygame.K_DOWN:
                                   if self.animalContainer[i].organism._x != self._x -1 :
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalContainer[i].organism._x +=1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = 'H'
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = i
                                        humanMove = False
                                if event.key==pygame.K_UP:
                                    if self.animalContainer[i].organism._x != 0 :
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                                        self.animalContainer[i].organism._x -=1
                                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = 'H'
                                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = i
                                        humanMove = False



#####################################################
            if self.animalContainer[i]!=None and self.animalContainer[i].organism._sign!='H':# Poczatek ruchu innych organizmow
                 nx = 1000
                 ny = 1000
                 if self.animalContainer[i].organism._sign == 'A': # Wylosowanie ruchu o '2' pola dla antylopy
                     while self.animalContainer[i].organism._x + nx < 0 or self.animalContainer[i].organism._x + nx > (self._x - 1) or self.animalContainer[i].organism._y + ny < 0 or self.animalContainer[i].organism._y + ny > self._y - 1:
                         nx = randint(0,4) - 2
                         ny = randint(0,4) - 2
                 else: # Wylosowanie ruchu/kierunku rozmnazania roslin dla innych organizmow niz antylopa
                     while self.animalContainer[i].organism._x + nx < 0 or self.animalContainer[i].organism._x + nx > (self._x - 1) or self.animalContainer[i].organism._y + ny < 0 or self.animalContainer[i].organism._y + ny > self._y - 1:
                         nx = randint(0,2) - 1
                         ny = randint(0,2) - 1
                 tempSign = self.animalContainer[i].organism._sign
                 if tempSign == 'S' or tempSign == 'W' or tempSign == 'F' or tempSign == 'A' or tempSign == 'T':
                     option = self.animalContainer[i].organism.action(self.animalBoard, nx, ny, self.animalContainer,self.board)
# # #
                     if option == 1: # Przejscie na nowe puste pole
                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1 # Czysczenie dawnej pozycji
                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                        self.animalContainer[i].organism._x = self.animalContainer[i].organism._x + nx
                        self.animalContainer[i].organism._y = self.animalContainer[i].organism._y + ny
                        self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = self.animalContainer[i].organism._number
                        self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = self.animalContainer[i].organism._sign
# # #
                     if option == 2: # Zwierze przechodzi na nowe pole i zabija tam bedacy organizm
                         self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1 # Czysczenie dawnej pozycji
                         self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                         self.animalContainer[self.board[self.animalContainer[i].organism._x +nx][self.animalContainer[i].organism._y +ny]] = None
                         self.animalContainer[i].organism._x = self.animalContainer[i].organism._x + nx
                         self.animalContainer[i].organism._y = self.animalContainer[i].organism._y + ny
                         self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = self.animalContainer[i].organism._number
                         self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = self.animalContainer[i].organism._sign
# # #
                     if option == 3: # Smierc organizmu w wyniku nieudanego ataku
                         self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1 # Czysczenie dawnej pozycji
                         self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                         self.animalContainer[i] = None
# # #
                     if option == 4: # Rozmnazanie
                         freeNumber = -1
                         for z in range (self._x*self._y):
                            if self.animalContainer[z] == None:
                                freeNumber = z
                                break

                         if freeNumber != -1:
                            freePlace = False
                            ne = 0
                            nw = 0

                         freePlace=False
                         for e in range (-1,2):
                            for w in range(-1,2):
                                if self.animalContainer[i].organism._x + e > -1 and self.animalContainer[i].organism._x + e < self._x  and self.animalContainer[i].organism._y + w> -1 and self.animalContainer[i].organism._y + w < self._y:
                                    if self.animalBoard[self.animalContainer[i].organism._x + e][self.animalContainer[i].organism._y + w] == -1:
                                        freePlace = True;
                                        ne=e
                                        nw=w

                         if freePlace == True:
                            self.drawWorld(screen)

                            if self.animalContainer[freeNumber] == None:
                                if self.animalContainer[i].organism._sign=='S':
                                    print("Stworzono owce na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                    self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                    self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'S'
                                    newOrganism = Sheep(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'S')
                                    box = OrganismContainer(newOrganism)
                                    self.animalContainer[freeNumber] = box
                                if self.animalContainer[i].organism._sign=='W':
                                    print("Stworzono wilka na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                    self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                    self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'W'
                                    newOrganism = Wolf(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'W')
                                    box = OrganismContainer(newOrganism)
                                    self.animalContainer[freeNumber] = box
                                if self.animalContainer[i].organism._sign=='T':
                                    print("Stworzono zolwia na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                    self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                    self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'T'
                                    newOrganism = Turtle(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'T')
                                    box = OrganismContainer(newOrganism)
                                    self.animalContainer[freeNumber] = box
                                if self.animalContainer[i].organism._sign=='A':
                                    print("Stworzono antylope na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                    self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                    self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'A'
                                    newOrganism = Antelope(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'A')
                                    box = OrganismContainer(newOrganism)
                                    self.animalContainer[freeNumber] = box
                                if self.animalContainer[i].organism._sign=='F':
                                    print("Stworzono lisa na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                    self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                    self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'F'
                                    newOrganism = Fox(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'F')
                                    box = OrganismContainer(newOrganism)
                                    self.animalContainer[freeNumber] = box
# # #
                     if option == 5: # Zwierze zjadlo wilcza jagode i oboje gina
                         self.board[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1 # Czysczenie dawnej pozycji
                         self.animalBoard[self.animalContainer[i].organism._x][self.animalContainer[i].organism._y] = -1
                         self.board[self.animalContainer[i].organism._x + nx ][self.animalContainer[i].organism._y + ny] = -1
                         self.animalBoard[self.animalContainer[i].organism._x + nx ][self.animalContainer[i].organism._y + ny] = -1
                         self.animalContainer[self.board[self.animalContainer[i].organism._x +nx][self.animalContainer[i].organism._y +ny]] = None
                         self.animalContainer[i] = None

                 if tempSign == '#' or tempSign == 'G' or tempSign == 'N' or tempSign == 'L':
                    option = self.animalContainer[i].organism.action(self.animalBoard, nx, ny, self.animalContainer,self.board)
# # #

                    if option == 4:# Rozmnazanie
                        freeNumber = -1
                        for z in range (self._x*self._y):
                           if self.animalContainer[z] == None:
                               freeNumber = z
                               break

                        if freeNumber != -1:
                           freePlace = False
                           ne = 0
                           nw = 0

                        freePlace=False
                        for e in range (-1,2):
                           for w in range(-1,2):
                               if self.animalContainer[i].organism._x + e > -1 and self.animalContainer[i].organism._x + e < self._x  and self.animalContainer[i].organism._y + w> -1 and self.animalContainer[i].organism._y + w < self._y:
                                   if self.animalBoard[self.animalContainer[i].organism._x + e][self.animalContainer[i].organism._y + w] == -1:
                                       freePlace = True;
                                       ne=e
                                       nw=w

                        if freePlace == True:
                           self.drawWorld(screen)

                           if self.animalContainer[freeNumber] == None:
                               if self.animalContainer[i].organism._sign=='#':
                                   print("Stworzono trawe na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                   self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                   self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = '#'
                                   newOrganism = Grass(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'#')
                                   box = OrganismContainer(newOrganism)
                                   self.animalContainer[freeNumber] = box
                           if self.animalContainer[freeNumber] == None:
                               if self.animalContainer[i].organism._sign=='G':
                                   print("Stworzono guarane na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                   self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                   self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'G'
                                   newOrganism = Guarana(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'G')
                                   box = OrganismContainer(newOrganism)
                                   self.animalContainer[freeNumber] = box
                           if self.animalContainer[freeNumber] == None:
                               if self.animalContainer[i].organism._sign=='N':
                                   print("Stworzono wilcze jagody na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                   self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                   self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'N'
                                   newOrganism = DeadlyNightshade(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'N')
                                   box = OrganismContainer(newOrganism)
                                   self.animalContainer[freeNumber] = box
                           if self.animalContainer[freeNumber] == None:
                               if self.animalContainer[i].organism._sign=='L':
                                   print("Stworzono mleczyk na koordynatach (" , self.animalContainer[i].organism._x + ne, "," , self.animalContainer[i].organism._y + nw , ")")
                                   self.board[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = freeNumber
                                   self.animalBoard[self.animalContainer[i].organism._x + ne][self.animalContainer[i].organism._y + nw] = 'L'
                                   newOrganism = SowThistle(self.animalContainer[i].organism._x + ne, self.animalContainer[i].organism._y + nw, self,freeNumber,'L')
                                   box = OrganismContainer(newOrganism)
                                   self.animalContainer[freeNumber] = box
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

    pass
 #print event