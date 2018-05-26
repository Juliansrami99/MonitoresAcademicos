/*
 * monitor.h
 *
 *  Created on: 16/05/2018
 *      Author: vonnewmann
 */

#ifndef TRABAJO_MONITOR_H_
#define TRABAJO_MONITOR_H_

#include <iostream>
#include <vector>
#include <list>
#include "Punto.h"
#include <string>

using namespace std;


class monitor{


public:
	vector<string> materias ;
	string nombre;
	int celular;
	Punto ubicacion;

	// constructor
	monitor();
	monitor(string nom, int celular, int x, int y, vector<string> mat );
	int cx();
	int cy();


};


#endif /* TRABAJO_MONITOR_H_ */
