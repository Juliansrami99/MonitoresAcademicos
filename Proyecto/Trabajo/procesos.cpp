/*
 * procesos.cpp
 *
 *  Created on: 25/05/2018
 *      Author: vonnewmann
 */


#include<iostream>
#include<vector>
#include "Punto.h"
#include "monitor.h"
#include "usuario.h"
#include "Q-tree.h"
#include "procesos.h"
#include <string>
#include <fstream>
#include <string>
using namespace std;

#ifdef _PROCESOS_H_



vector<string> leerLinea(string linea){
	vector<string> reg=vector<string>();
	string word;
	for (std::size_t i=0; i<linea.length();i++){
//	if (linea[i]=='\n'){
//		if(!word.empty()){
//			reg.push_back(word);
//			word.clear();
//	}
//	}
		if  (linea[i]!='/'){
			word.push_back(linea[i]);
		} else if(linea[i]=='/'){
			if(!word.empty()){
				reg.push_back(word);
				word.clear();
			}
		}


	}

	reg.push_back(word);
	return reg;
}


vector<monitor> lecturaBaseMonitor(){

	ifstream inputFile;
	inputFile.open("monitores.txt");
	vector<monitor> registros;
	string linea;

	while(!inputFile.eof()){
		getline(inputFile, linea);
		if(linea!=""){
			monitor a=monitor();
			vector<string> reg=leerLinea(linea);
			a.nombre=reg[0];
			a.celular=stoi(reg[1]);
			int x=stoi(reg[2]);
			int y=stoi(reg[3]);
			a.ubicacion= Punto(x,y);
			vector<string> mat;
			for(std::size_t i=4; i<reg.size();i++){
				mat.push_back(reg[i]);
			}
			a.materias=mat;
			registros.push_back(a);
		}
	}
	return registros;
}

usuario lecturaArchivoUsuario(){
	ifstream inputFile;
	inputFile.open("estudiante.txt");
	string linea;
	getline(inputFile, linea);
	usuario a=usuario();
	vector<string> reg=leerLinea(linea);
	a.nombre=reg[0];
	a.celular=stoi(reg[1]);
	int x=stoi(reg[2]);
	int y=stoi(reg[3]);
	a.ubicacion= Punto(x,y);
	return a;

}

string crearLineaMonitor(monitor estudiante){
	string a=estudiante.nombre;
	string b=to_string(estudiante.celular);
	Punto e=estudiante.ubicacion;
	string c=to_string(e.x);
	string d=to_string(e.y);
	string linea=a+"/"+b+"/"+c+"/"+d;
	vector<string> mat= estudiante.materias;
	for(std::size_t i=0; i<mat.size();i++){
		string y=mat[i];
		linea=linea+"/";
		linea=linea+y;

			}
	//linea=linea;
	return linea;
}
void escribirListaMonitores(vector<monitor> listaMonitores){
	ofstream archivo;
	archivo.open("lista.txt",ios::out);
	if(archivo.fail()){
		exit(1);
	}
	for(std::size_t i=0; i<listaMonitores.size();i++){
		string linea=crearLineaMonitor(listaMonitores[i]);
		archivo<<linea<<endl;
	}
	archivo.close();
}

vector<monitor> procedimiento (usuario estudiante){
	vector<monitor> x;
	x=lecturaBaseMonitor();
	Rectangulo y;
	y.h=50;
	y.w=50;
	y.x=50;
	y.y=50;
	Quad a= Quad(y);
	for (std::size_t i=0; i<x.size();i++){
		monitor h=x[i];
		a.insertar(h);
	}
	estudiante=lecturaArchivoUsuario();
	cout<<"USUARIO:";
	cout<<estudiante.nombre<<endl;
	vector<monitor> x2;
	x2=a.searchNear(estudiante);
	escribirListaMonitores(x2);
	return x2;

	}








monitor lecturaArchivoMonitor(){
	ifstream inputFile;
	inputFile.open("Monitor.txt");
	string linea;
	getline(inputFile, linea);
	monitor a=monitor();
	vector<string> reg=leerLinea(linea);
	a.nombre=reg[0];
	a.celular=stoi(reg[1]);
	int x=stoi(reg[2]);
	int y=stoi(reg[3]);
	a.ubicacion= Punto(x,y);
	vector<string> mat;
	for(std::size_t i=3; i<reg.size();i++){
		mat.push_back(reg[1]);
	}
	a.materias=mat;


	return a;

}



void escribirMonitor(monitor estudiante){
	ofstream archivo;
	archivo.open("lista.txt",ios::app);
	if(archivo.fail()){
		exit(1);
	}
	string linea=crearLineaMonitor(estudiante);
	archivo<<linea<<endl;
	archivo.close();

}



#endif /*_PROCESOS_H_ */


