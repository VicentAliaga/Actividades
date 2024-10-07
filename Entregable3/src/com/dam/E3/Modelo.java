package com.dam.E3;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Modelo {
	
	File file = new File("C:\\Users\\Vicent AG\\Documents\\Clase\\DAM2\\AccesoADatos\\Tema1\\Entregable3\\AE_02_T1_2_Streams_Material\\AE_02_T1_2_Streams_Material\\AE02_T1_2_Streams_Groucho.txt");
    public Modelo () {
    	this.file = file;
    }
	public ArrayList<String> leerTexto() {
		ArrayList<String> texto = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea = br.readLine();
			while (br.readLine() != null) {
				texto.add(linea);
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return texto;
	}
	
	public int buscarPalabras(String palabraBuscar) {
		int contador = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea = br.readLine();
			while (linea != null) {
				String[] palabras = linea.split("\\s+");
				linea = br.readLine();
				for (String palabra : palabras) {
                    if (palabra.equalsIgnoreCase(palabraBuscar)) {
                        contador++;
                    }
				}
			}
			
		} catch (IOException e) {
			e.getMessage();
		}
		return contador;
	}
	
	public static void reemplazarPalabraEnArchivo(String rutaArchivo, String palabraVieja, String palabraNueva) throws IOException {
        File archivoOriginal = new File(rutaArchivo);
        File archivoTemporal = new File(rutaArchivo + ".tmp");

        try (
            BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String nuevaLinea = linea.replace(palabraVieja, palabraNueva);
                bw.write(nuevaLinea);
                bw.newLine();
            }
        }
    }
}
