/*
 * Q-tree.cpp
 *
 *  Created on: 11/05/2018
 *      Author: vonnewmann
 */



#ifdef Q_TREE_H_

#include<vector>

int CAPACIDAD =4;


// Constructor QuadTree
Quad::Quad(Rectangulo rec){

	boundary=rec;
	topLeftTree=NULL;
	topRightTree=NULL;
	botLeftTree=NULL;
	botRightTree=NULL;
	divided=false;
	personas= new vector<int>;
}



void Quad::insert(Punto persona){

	if (!inBoundary(persona))
	        return;
	if (personas.size()>=CAPACIDAD){
		topLeftTree = new Quad(Rectangulo(boundary.x-boundary.w/2,
							boundary.y-boundary.h/2,boundary.w/2,boundary.h/2));

		botLeftTree = new Quad(Rectangulo(boundary.x-boundary.w/2,
							boundary.y+boundary.h/2,boundary.w/2,boundary.h/2));

		topRightTree = new Quad(Rectangulo(boundary.x+boundary.w/2,
							boundary.y-boundary.h/2,boundary.w/2,boundary.h/2));

		botRightTree = new Quad(Rectangulo(boundary.x+boundary.w/2,
							boundary.y+boundary.h/2,boundary.w/2,boundary.h/2));
		divided=true;

		for (int i=0; i<personas.size(); i++){
		topRightTree->insert(personas[i]);
		botLeftTree->insert(personas[i]);
		botRightTree->insert(personas[i]);
		topLeftTree->insert(personas[i]);

			personas.clear();
		}
		topRightTree->insert(persona);
		botLeftTree->insert(persona);
		botRightTree->insert(persona);
		topLeftTree->insert(persona);
	}else{
		personas.push_back(persona);
	}
}

bool Quad::intersects(Rectangulo range){
	bool a;
	a=(range.x-range.w>boundary.x+boundary.w ||
		range.x+range.w<boundary.x-boundary.w||
		range.y-range.h>boundary.y+boundary.h||
		range.y+range.h<boundary.y-boundary.h);
	return !(a);
}

vector<Punto> Quad::searchNear(Punto p,vector<Punto> lista){

	Rectangulo area= Rectangulo(p.x,p.y,100,100);
		if(!intersects(area)){
			return lista;
		}
		if(divided==true){
			vector<Punto> c=topRightTree->searchNear(p,lista);
			for (int i=0;i<=c.size();i++){
				lista.push_back(c[i]);
			}

			vector<Punto> d=botLeftTree->searchNear(p,lista);
			for (int i=0;i<=d.size();i++){
				lista.push_back(d[i]);
			}
			vector<Punto> e=botRightTree->searchNear(p,lista);
			for (int i=0;i<=e.size();i++){
				lista.push_back(e[i]);
			}
			vector<Punto> f=topLeftTree->searchNear(p,lista);
			for (int i=0;i<=f.size();i++){
				lista.push_back(f[i]);
			}
		}
		return lista;
	}

vector<Punto> Quad::searchNear(Punto p){
	vector<Punto> lista= NULL;
	Rectangulo area= Rectangulo(p.x,p.y,100,100);
	if(!intersects(area)){
		return lista;
	}
	if(divided==true){
		vector<Punto> c=topRightTree->searchNear(p,lista);
		for (int i=0;i<=c.size();i++){
			lista.push_back(c[i]);
		}

		vector<Punto> d=botLeftTree->searchNear(p,lista);
		for (int i=0;i<=d.size();i++){
			lista.push_back(d[i]);
		}
		vector<Punto> e=botRightTree->searchNear(p,lista);
		for (int i=0;i<=e.size();i++){
			lista.push_back(e[i]);
		}
		vector<Punto> f=topLeftTree->searchNear(p,lista);
		for (int i=0;i<=f.size();i++){
			lista.push_back(f[i]);
		}
	}
	return lista;

}


bool Quad::inBoundary(Punto p)
{
    return (p.x >= boundary.x-boundary.w &&
        p.x <= boundary.x+boundary.w  &&
        p.y >= boundary.y-boundary.h  &&
        p.y <= boundary.y+boundary.h );
}


#endif  Q_TREE_H_
