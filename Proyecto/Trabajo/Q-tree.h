/*
 * Q-tree.h
 *
 *  Created on: 9/05/2018
 *      Author: vonnewmann
 */

#ifndef Q_TREE_H_
#define Q_TREE_H_

#include<iostream>
#include "Punto.h"
#include "monitor.h"
#include "usuario.h"
#include<vector>
#include<algorithm>




using namespace std;



struct Rectangulo{

	int x;
	int y;
	int w;
	int h;



};

class Quad{

// COLOQUE UNA ESTRUCTURA
struct node{

	node *topLeftTree;
	node *topRightTree;
	node *botLeftTree;
	node *botRightTree;

	vector<monitor> personas ;
	Rectangulo boundary;
	bool divided;
};

	void insert(node *&raiz, monitor Persona);


    bool inBoundary(node *a,monitor p);

    bool intersects(node *a,Rectangulo range);

    bool inBoundary1(Rectangulo raiz,monitor p);

    vector<monitor> searchNear(node *,usuario p, vector<monitor>&);

    void imprimir (node *, std::ostream &);
public:
    node *raiz;

	Quad();
	Quad(Rectangulo r);
	void insertar(monitor p);
	vector<monitor> searchNear(usuario p);
	//~Quad();
	void imprimir(std::ostream& =std::cout);






};


#endif /*Q_TREE_H_*/

