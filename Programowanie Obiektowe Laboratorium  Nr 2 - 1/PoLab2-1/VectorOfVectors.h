#pragma once
#include <iostream>
#include<fstream>
#include "Vektor.h"
using namespace std;
class VectorOfVectors
{
public:
	Vektor *vektory;
	int rozmiarb;
	VectorOfVectors();
	VectorOfVectors(int size);
	VectorOfVectors(const VectorOfVectors &oryginal);
	~VectorOfVectors();
	VectorOfVectors& operator=(const VectorOfVectors &oryginal);
	friend ostream & operator<<(ostream &out, const VectorOfVectors &oryginal);
	friend istream & operator>>(istream &in, VectorOfVectors &oryginal);
	friend class vektor;
};

