/*
 * Q-tree.h
 *
 *  Created on: 9/05/2018
 *      Author: vonnewmann
 */

#ifndef Q_TREE_H_
#define Q_TREE_H_

#include<iostream>
#include<vector>


using namespace std;

struct Punto
{
    int x;
    int y;
    int *dato;
  // como convertir el dato en un template

    Punto(int _x, int _y, int *_dato)
    {
        x = _x;
        y = _y;
        dato= _dato;
    }
    Punto()
    {
        x = 0;
        y = 0;
        dato=NULL;
    }
};

struct Rectangulo{

	int x;
	int y;
	int w;
	int h;
	Rectangulo(int _x, int _y, int _w, int _h){
	x= _x;
	y= _y;
	w= _w;
	h= _h;
}
};

class 	Quad{

public:


	Quad *topLeftTree;
	Quad *topRightTree;
	Quad *botLeftTree;
	Quad *botRightTree;

	Rectangulo boundary;

	bool divided;

	vector<Punto> personas ;

    Quad(Rectangulo Rec);

    ~Quad();

    void insert(Punto Persona);

    vector<Punto> searchNear(Punto p, vector<Punto> lista);

    vector<Punto> searchNear(Punto p);

private:

    bool inBoundary(Punto p);

    bool intersects(Rectangulo range);


};

#include "Q-tree.cpp"
#endif Q_TREE_H_
