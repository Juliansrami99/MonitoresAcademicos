/*
 * monitor.cpp
 *
 *  Created on: 16/05/2018
 *      Author: vonnewmann
 */

#include<iostream>
#include<string>
#include "monitor.h"
#include"Punto.h"

#ifdef TRABAJO_MONITOR_H_


monitor::monitor(){
	nombre= "";
	celular=0;
	ubicacion=Punto(0,0);

}

monitor::monitor(string nom, int celular_, int x,int y, vector<string> mat ){

	nombre=nom;
	celular=celular_;
	ubicacion=Punto(x,y);
	materias=mat;
}
int monitor::cx(){
	return ubicacion.coorX();
}
int monitor::cy(){
	return ubicacion.coorY();
}



#endif /* TRABAJO_MONITOR_H_ */
