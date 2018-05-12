/*
 * usuario.h
 *
 *  Created on: 11/05/2018
 *      Author: Julian
 */

#ifndef TRABAJO_USUARIO_H_
#define TRABAJO_USUARIO_H_


#include<iostream>
#include<string>

using namespace std;



struct Point2
{
    int x;
    int y;
    Point2(int _x, int _y)
    {
        x = _x;
        y = _y;

    }
    Point2()
    {
        x = 0;
        y = 0;
     }
};




class usuario{

	// usuario
	struct user{

		string nombre;
		string materia;
		Point2 punto;

	};
	user US;

public:

	// Constructor
	usuario(const user &);
	~usuario();

	void Clear(void);
	void Clear(user *&);
	void AgregarNombre(string);
	void AgregarUbicacion(Point2);
	void AgregarMateria (string);
	string NomEst();
	string Materia();
	Point2 Ubicacion();


};

#endif /* TRABAJO_USUARIO_H_ */
#include "usuario.cpp"
