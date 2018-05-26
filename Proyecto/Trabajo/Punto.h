/*
 * Punto.h
 *
 *  Created on: 16/05/2018
 *      Author: vonnewmann
 */

#ifndef PUNTO_H_
#define PUNTO_H_

#include <iostream>

class Punto{

public:
	int x;
	int y;
	// constructor
	Punto();
	Punto(int x, int y);
	Punto operator=(Punto x);
	int coorX();
	int coorY();
};



#endif /* TRABAJO_PUNTO_H_ */
