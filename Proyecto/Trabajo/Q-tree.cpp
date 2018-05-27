/*
 * Q-tree.cpp
 *
 *  Created on: 11/05/2018
 *      Author: vonnewmann
 */

#include "Q-tree.h"
#include<vector>

#ifdef Q_TREE_H_



const std::size_t CAPACIDAD =4;


// Constructor QuadTree
Quad::Quad(){
	raiz=NULL;
}
// Creamos un quad tree a partir de un rectangulo que cre un usuario
Quad::Quad(Rectangulo r){
	raiz=new node;
	raiz->boundary=r;
	raiz->divided=false;
	raiz->botLeftTree=NULL;
	raiz->botRightTree=NULL;
	raiz->topLeftTree=NULL;
	raiz->topRightTree=NULL;

}

// Insertar
void Quad::insertar(monitor m){
	insert(raiz, m);

}

void Quad::insert(node *&raiz,monitor persona){
// Si no exisite raiz, se crea un nuevo quad con un rectangulo predefinifo por los diseñadores de la aplicacion
	if(raiz==NULL){
		Rectangulo r;
		r.x=50;
		r.y=50;
		r.w=50;
		r.h=50;

		raiz=new node;
		raiz->botLeftTree=NULL;
		raiz->botRightTree=NULL;
		raiz->topLeftTree=NULL;
		raiz->topRightTree=NULL;
		raiz->divided=false;
		raiz->boundary= r;
	}

	else{
		// Revisamos si el elemento a insertar esta dentro del rectangulo
		if(inBoundary(raiz,persona)){
			// Selleccionamos los tamaños del rectangulo de la raiz
			Rectangulo bound=raiz->boundary;
			int nx=bound.x;
			int ny=bound.y;
			int nw=bound.w;
			int nh= bound.h;
			// revisamos si esta dividida, en caso de estarlo revisamos en que hijo podemos insertar el monitor
			if(raiz->divided==true){
				insert(raiz->botLeftTree,persona);
				insert(raiz->botRightTree,persona);
				insert(raiz->topLeftTree,persona);
				insert(raiz->topRightTree,persona);
			}
			else{
				// En caso tal de que el queda tenga el numero maximo de monitores entonces didvidimos el rectangulo
				if (raiz->personas.size()>CAPACIDAD){
					//Primera division
					Rectangulo primero;
					primero.x=nx-nw/2;
					primero.y=ny-nh/2;
					primero.w=nw/2;
					primero.h=nh/2;
					node* a=new node;
					raiz->topLeftTree=a;
					a->divided=false;
					a->botLeftTree=NULL;
					a->botRightTree=NULL;
					a->topLeftTree=NULL;
					a->topRightTree=NULL;


					a->boundary=primero;

					//Segunda division
					Rectangulo segundo;
					segundo.x=nx-nw/2;
					segundo.y=ny+nh/2;
					segundo.w=nw/2;
					segundo.h=nh/2;
					node *b= new node;
					b->divided=false;
					raiz->botLeftTree=b;
					b->botLeftTree=NULL;
					b->botRightTree=NULL;
					b->topLeftTree=NULL;
					b->topRightTree=NULL;
					b->boundary=segundo;


					//Tercera division
					Rectangulo tercero;
					tercero.x=nx+nw/2;
					tercero.y=ny-nh/2;
					tercero.w=nw/2;
					tercero.h=nh/2;
					node *c= new node;
					raiz->topRightTree=c;
					c->divided=false;
					c->botLeftTree=NULL;
					c->botRightTree=NULL;
					c->topLeftTree=NULL;
					c->topRightTree=NULL;
					c->boundary=tercero;

					//Cuarta division
					Rectangulo cuarto;
					cuarto.x=nx+nw/2;
					cuarto.y=ny+nh/2;
					cuarto.w=nw/2;
					cuarto.h=nh/2;
					node *d= new node;
					raiz->botRightTree=d;
					d->divided=false;
					d->botLeftTree=NULL;
					d->botRightTree=NULL;
					d->topLeftTree=NULL;
					d->topRightTree=NULL;
					d->boundary=cuarto;


					raiz->divided=true;
					
					// Todos los monitores que estan en la raiz los pasamos a sus hijos
					for (std::size_t i=0; i<raiz->personas.size(); i++){ // REvisar si falta un igual
						insert(b,raiz->personas[i]);
						insert(d,raiz->personas[i]);
						insert(a,raiz->personas[i]);
						insert(c,raiz->personas[i]);


					}
					// qitamos los elementos de la raiz
					raiz->personas.clear();
					insert(b,persona);
					insert(d,persona);
					insert(a,persona);
					insert(c,persona);
				}

			    raiz->personas.push_back(persona);
			}
		}
	}
}


// Metodo el cual sirve para ver si el rango de un usuario se intersecta con algun quad tree
bool Quad::intersects(node *raiz,Rectangulo range){
	bool a;
	a=(range.x-range.w>raiz->boundary.x+raiz->boundary.w ||
		range.x+range.w<raiz->boundary.x-raiz->boundary.w||
		range.y-range.h>raiz->boundary.y+raiz->boundary.h||
		range.y+range.h<raiz->boundary.y-raiz->boundary.h);
	return !(a);
}

// Metodo que encuentra los monitoes que esta  cerca del usuario
vector<monitor> Quad::searchNear(node *raiz,usuario p, vector<monitor> &x){ //Tengo duda si es necesario el &

	Rectangulo area;
	area.x=p.cx();
	area.y=p.cy();
	area.w=50;
	area.h=50;
		// Revisamos si se intersectan
		if(!intersects(raiz,area)){
			return x;
		}else{
			// Si el queda esta divido buscamos en cada uno de sus hijos
			if(raiz->divided==true){


				vector<monitor> c;
				searchNear(raiz->topRightTree,p,c);
				for(std::size_t i=0;i<c.size();i++){
					x.push_back(c[i]);
				}

				vector<monitor> d;
				searchNear(raiz->botLeftTree,p,d);
				for(std::size_t i=0;i<d.size();i++){
					x.push_back(d[i]);
				}
				vector<monitor> e;
				searchNear(raiz->botRightTree,p,e);
				for(std::size_t i=0;i<e.size();i++){
					x.push_back(e[i]);
				}
				vector<monitor>K;
				searchNear(raiz->topLeftTree,p,K);
				for(std::size_t j=0;j<K.size();j++){
					x.push_back(K[j]);
				}
			}else{
				// sino lo esta verificamos en los monitores que estan en la raiz
				for (std::size_t i=0;i<raiz->personas.size();i++){
					if(inBoundary1(area,raiz->personas[i])){
						x.push_back(raiz->personas[i]);

					}
				}
			}
		}
		return x;
	}

vector<monitor> Quad::searchNear(usuario p){
	vector<monitor> final;
	searchNear(raiz, p,final);
	return final;
}

// Verificamoes si monitor esta en el quad

bool Quad::inBoundary(node *raiz,monitor p){
	bool a;
	a=(p.cx()>=raiz->boundary.x - raiz->boundary.w &&
	   p.cx()<= raiz->boundary.x + raiz->boundary.w &&
	   p.cy()>= raiz->boundary.y - raiz->boundary.h &&
	   p.cy()<= raiz->boundary.y  +raiz->boundary.h);
	return a;
}



bool Quad::inBoundary1(Rectangulo raiz,monitor p){
	bool a;
	a=(p.cx()>=raiz.x - raiz.w &&
	   p.cx()<= raiz.x + raiz.w &&
	   p.cy()>= raiz.y - raiz.h &&
	   p.cy()<= raiz.y  +raiz.h);
	return a;
}


// Imprimimos el quad tree
void Quad::imprimir(std::ostream& out){
	imprimir(raiz,out);
}

void Quad::imprimir(node *nodo, std::ostream& out){
	if(nodo->divided==true){
		imprimir(nodo->botLeftTree,out);
		imprimir(nodo->botRightTree,out);
		imprimir(nodo->topLeftTree,out);
		imprimir(nodo->topRightTree,out);
	}
	else{
		for (std::size_t i=0;i<nodo->personas.size();i++){
			monitor x;
			x=nodo->personas[i];
			cout<<"monitor: "<<x.nombre<<endl;

		}
		cout<<"---------------"<<endl;
	}

}




#endif /* Q_TREE_H_*/
