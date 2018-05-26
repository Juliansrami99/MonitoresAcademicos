/*
 * usuario.h
 *
 *  Created on: 11/05/2018
 *      Author: Julian
 */


#ifndef USUARIO_H_
#define USUARIO_H_


#include<iostream>
#include<string>
#include "Punto.h"

using namespace std;


class usuario{


public:

	string nombre;
	int celular;
	Punto ubicacion;
	// Constructor
	usuario();
	usuario(string nom,int celular, int x, int y);
	int cx();
	int cy();


};


#endif /* TRABAJO_USUARIO_H_ */

