/*
 * prueba.cpp
 *
 *  Created on: 24/05/2018
 *      Author: vonnewmann
 */



#include <unistd.h>
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <cstring>
#include<vector>
#include "Punto.h"
#include "monitor.h"
#include "usuario.h"
#include "Q-tree.h"
#include "procesos.h"


#define PORT 9002
int main(int argc, char const *argv[])
{
    int server_fd, new_socket, valread;
    struct sockaddr_in address;
    int opt = 1;
    int addrlen = sizeof(address);
    char buffer[1024] = {0};
    char *hello = "Hello from server";

    // Creating socket file descriptor
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
    {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    // Forcefully attaching socket to the port 8080
    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEPORT, &opt, sizeof(opt)))
    {
        perror("setsockopt");
        exit(EXIT_FAILURE);
    }
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons( PORT );

    // Forcefully attaching socket to the port 8080
    if (bind(server_fd, (struct sockaddr *)&address,
                                 sizeof(address))<0)
    {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }
    if (listen(server_fd, 3) < 0)
    {
        perror("listen");
        exit(EXIT_FAILURE);
    }
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address,
                       (socklen_t*)&addrlen))<0)
    {
        perror("accept");
        exit(EXIT_FAILURE);
    }

    valread = read( new_socket , buffer, 1024);
    vector<string> reg=leerLinea(buffer);
    if(reg[0]=="s"){
        usuario a;

        	a.nombre=reg[1];
        	a.celular=stoi(reg[2]);
        	int x=stoi(reg[3]);
        	int y=stoi(reg[4]);
        	a.ubicacion= Punto(x,y);


        vector<string> mensaje;
        vector<monitor> lista =procedimiento(a);
        string linea;
        for(std::size_t i=0; i<lista.size();i++){
        		linea=crearLineaMonitor(lista[i]);
        		mensaje.push_back(linea);
        	}
        for(std::size_t i=0; i<mensaje.size();i++){
        		string linea=mensaje.at(i);
        		std::cout << linea << std::endl;

        }
        char *cstr = new char[linea.length() + 1];
		for(int i=0;i<linea.length();i++){
			cstr[i]=linea[i];
		}

		hello=cstr;
		printf(hello);
		cout << hello << std::endl;
		send(new_socket , hello , strlen(hello) , 0 );

    }else if(reg[0]=="m"){
    	string linea=buffer;
		char *cstr = new char[linea.length() + 1];
		for(int i=0;i<linea.length();i++){
			cstr[i]=linea[i];
		}
		hello=cstr;
		printf(hello);
		cout << hello << std::endl;
	    send(new_socket , hello , strlen(hello) , 0 );
	    valread = read( new_socket , buffer, 1024);
	    if("mc"==reg[0]){
			string linea=buffer;
			char *cstr = new char[linea.length() + 1];
			for(int i=3;i<linea.length();i++){
				cstr[i]=linea[i];
			}
			hello=cstr;
			printf(hello);
			cout << hello << std::endl;
			send(new_socket , hello , strlen(hello) , 0 );


	        }
    }





    hello="Hello from server";
    send(new_socket , hello , strlen(hello) , 0 );
    printf("Hello message sent\n");
    return 0;
}
