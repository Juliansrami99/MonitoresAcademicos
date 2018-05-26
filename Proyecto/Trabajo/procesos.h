/*
 * procesos.h
 *
 *  Created on: 25/05/2018
 *      Author: vonnewmann
 */

#ifndef _PROCESOS_H_
#define _PROCESOS_H_



#include<iostream>
#include<vector>
#include "Punto.h"
#include "monitor.h"
#include "usuario.h"
#include "Q-tree.h"
#include <string>
#include <fstream>
#include <string>


vector<string> leerLinea(string linea);
vector<monitor>  lecturaBaseMonitor();
usuario lecturaArchivoUsuario();
monitor lecturaArchivoMonitor();
string crearLineaMonitor(monitor estudiante);
void escribirListaMonitores(vector<monitor> listaMonitores);
void escribirMonitor(monitor estudiante);
vector<monitor> procedimiento(usuario estudiante);



#endif /* _PROCESOS_H_ */
