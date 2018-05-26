/*
 * Punto.cpp
 *
 *  Created on: 16/05/2018
 *      Author: vonnewmann
 */

#include<iostream>
#include "Punto.h"

#ifdef PUNTO_H_

// Constructor
Punto::Punto(){
	x=0;
	y=0;
}

Punto::Punto(int a, int b){
	x=a;
	y=b;
}

Punto Punto::operator =(Punto p){
	x=p.x;
	y=p.y;
	return *this;
}
int Punto::coorX(){
	return x;
}
int Punto::coorY(){
	return y;
}
#endif /* TRABAJO_PUNTO_H_ */

