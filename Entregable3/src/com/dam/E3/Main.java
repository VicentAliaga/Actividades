package com.dam.E3;

public class Main {

	public static void main(String[] args) {
		
		Vista v = new Vista();
		Modelo m = new Modelo();
		Controlador c = new Controlador(v, m);
	}

}
