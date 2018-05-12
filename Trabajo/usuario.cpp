/*
 * usuario.cpp
 *
 *  Created on: 11/05/2018
 *      Author: Julian
 */

#include<iostream>
#include<string>
using namespace std;



#ifdef TRABAJO_USUARIO_H_

usuario::usuario(const user  & us){
	user US= us;
}
usuario::~usuario(){
	Clear();

}

void usuario::Clear(){
	Clear(*& US);
}

void usuario::Clear(user *& US){
	if(US!=NULL){
		delete US;
	}
	US==NULL;
	cout<<"Usuario no existe"<< endl;
}


void usuario::AgregarNombre(string n){
	if(US!=NULL){
		US.nombre=n;
	}else{
		cout<<"usuario no existe"<<endl;
	}

}
void usuario::AgregarMateria(string n){
	if(US!=NULL){
		US.materia=n;
	}else{
		cout<<"usuario no existe"<<endl;
	}
}

void usuario::AgregarUbicacion(Point2 punt){
	if(US==NULL){
			US.punto=punt;
		}else{
			cout<<"usuario no existe"<<endl;
		}
	}


string usuario::NomEst(){
	if(US==NULL){
		string x="nada";
		return x;
	}else{
		return US.nombre;
	}

}

string usuario::Materia(){

	if(US==NULL){
			cout<<"no existe"<<endl;
		}else{
			return US.materia;
		}

}

Point2 usuario::Ubicacion(){
	if(US==NULL){
				cout<<"no existe"<<endl;
		}else{
				return US.punto;
			}
}




#endif /* TRABAJO_USUARIO_H_ */
