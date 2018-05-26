/*
 * usuario.cpp
 *
 *  Created on: 11/05/2018
 *      Author: Julian
 */

#include<iostream>
#include<string>
#include "usuario.h"
using namespace std;



#ifdef USUARIO_H_

usuario::usuario(){
	nombre="";
	celular=0;
	ubicacion=Punto(0,0);

}

usuario::usuario(string n, int cel, int a, int b){

	nombre=n;
	celular=cel;
	ubicacion= Punto(a,b);

}
int usuario::cx(){
	return ubicacion.coorX();
}
int usuario::cy(){
	return ubicacion.coorY();
}



#endif /* TRABAJO_USUARIO_H_ */

