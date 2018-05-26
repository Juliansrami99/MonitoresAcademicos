package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class monitor {
	
	
	
	String nombre;
	Double celular;
	int ubicacionX;
	int ubicacionY;
	ArrayList <String> materias;
	
	
	
	public monitor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public monitor(String nombre, Double celular, int ubicacionX, int ubicacionY, ArrayList<String> materias) {
		super();
		this.nombre = nombre;
		this.celular = celular;
		this.ubicacionX = ubicacionX;
		this.ubicacionY = ubicacionY;
		this.materias = materias;
	}
	public monitor(String nombre, Double celular, ArrayList<String> materias) {
		this.nombre = nombre;
		this.celular = celular;
		this.materias = materias;
		this.ubicacionX = 0;
		this.ubicacionY =0;
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



	public void setUbicacionX(int ubicacionX) {
		this.ubicacionX = ubicacionX;
	}



	public int getUbicacionY() {
		return ubicacionY;
	}



	public void setUbicacionY(int ubicacionY) {
		this.ubicacionY = ubicacionY;
	}



	public ArrayList<String> getMaterias() {
		return materias;
	}



	public void setMaterias(ArrayList<String> materias) {
		this.materias = materias;
	}
	public void EscribirMonitor() {
		String filename="..//..//julian//Proyecto//nuevomonitor.txt";
		try {
			FileWriter fWriter = new FileWriter(filename,false);
			PrintWriter pwriter=new PrintWriter(fWriter);
			pwriter.print(nombre);
			pwriter.print('/');
			pwriter.print(celular);
			pwriter.print('/');
			pwriter.print(ubicacionX);
			pwriter.print('/');
			pwriter.print(ubicacionY);
		
			for(int i=0; i<materias.size();i++) {
				pwriter.print('/');
				pwriter.print(materias.get(i));
				
			}
			pwriter.println();
			
			pwriter.close();
		}catch(IOException e) {
			
		}
		
	}
	
	public void leerLineaMonitor(String linea) {
		String parts[]=linea.split("/");
		this.setNombre(parts[0]);
		this.setCelular(Double.valueOf(parts[1]));
		this.setUbicacionX(Integer.valueOf(parts[2]));
		this.setUbicacionY(Integer.valueOf(parts[3]));
		ArrayList <String> mat= new ArrayList <String>();
		for(int i=4; i<parts.length; i++) {
			mat.add(parts[i]);
		}
		this.setMaterias(mat);
		
		
	}
	
	public ArrayList<monitor> leerMonitor() {
		ArrayList<monitor> monitores=new ArrayList<monitor>();
		String filename="..//..//julian//Proyecto//lista.txt";
		try {
			FileReader fReader = new FileReader(filename);
			BufferedReader bufReader = new BufferedReader(fReader);
			String linea = bufReader.readLine();
			while(linea!=null) {
				monitor lov=new monitor();
				String parts[]=linea.split("/");
				lov.setNombre(parts[0]);
				lov.setCelular(Double.valueOf(parts[1]));
				lov.setUbicacionX(Integer.valueOf(parts[2]));
				lov.setUbicacionY(Integer.valueOf(parts[3]));
				ArrayList <String> mat= new ArrayList <String>();
				for(int i=4; i<parts.length; i++) {
					mat.add(parts[i]);
				}
				lov.setMaterias(mat);
				linea= bufReader.readLine();
				monitores.add(lov);
			}
			
			bufReader.close();
		}catch(Exception e){
			
		}
		
		
		return monitores;
	}
	public ArrayList<monitor> filtro( ArrayList<monitor> lista, String materia){
		ArrayList<monitor> lista_reducida= new ArrayList<monitor>();
		for(int i=0;i<lista.size();i++) {
			monitor a=lista.get(i);
			ArrayList<String> materias=a.getMaterias();
			for(int j=0;j<materias.size();j++) {
				String mat=materias.get(j);
				if(mat.equals(materia)) {
					lista_reducida.add(a);
				}
			}
			
		}
		
		
		
		
		return lista_reducida;
	}



	public Double getCelular() {
		return celular;
	}
	
	
	

}
