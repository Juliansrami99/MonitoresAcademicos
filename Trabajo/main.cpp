/*
 * main.cpp
 *
 *  Created on: 11/05/2018
 *      Author: Julian
 */


#include<iostream>
#include<string>
#include "usuario.h"

using namespace std;

int main(){

	usuario x;
	x.AgregarMateria("algebra");
	x.AgregarNombre("Julian");

	cout<<x.Materia<<endl;

}

