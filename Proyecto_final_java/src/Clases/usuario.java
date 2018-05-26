package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class usuario {

	String nombre;
	Double celular;
	Integer ubicacionX;
	Integer ubicacionY;
	String materia;
	
	
	
	
	public usuario() {
		super();
		
	}
	public usuario(String nombre, Double celular, String materia) {
		super();
		this.nombre = nombre;
		this.celular = celular;
		this.materia=materia;
	}
	public usuario(String nombre, Double celular, Integer ubicacionX, Integer ubicacionY, String materia) {
		super();
		this.nombre = nombre;
		this.celular = celular;
		this.ubicacionX = ubicacionX;
		this.ubicacionY = ubicacionY;
		this.materia=materia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCelular(Double celular) {
		this.celular = celular;
	}
	public int getUbicacionX() {
		return ubicacionX;
	}
	public void setUbicacionX(Integer ubicacionX) {
		this.ubicacionX = ubicacionX;
	}
	public int getUbicacionY() {
		return ubicacionY;
	}
	public void setUbicacionY(Integer ubicacionY) {
		this.ubicacionY = ubicacionY;
	}
	public void EscribirEstudiante() {
		String filename="..//..//julian//Proyecto//estudiante.txt";
		try {
			FileWriter fWriter = new FileWriter(filename, false);
			PrintWriter pwriter=new PrintWriter(fWriter);
			pwriter.print(nombre);
			pwriter.print('/');
			pwriter.print(celular);
			pwriter.print('/');
			pwriter.print(ubicacionX);
			pwriter.print('/');
			pwriter.print(ubicacionY);
			pwriter.print('/');
			pwriter.print(materia);
			pwriter.println();
			pwriter.close();
		}catch(IOException e) {
			
		}
		
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Double getCelular() {
		return celular;
	}
	
	
	
}
