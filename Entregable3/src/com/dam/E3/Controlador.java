package com.dam.E3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador {
	 Vista vista;
	 Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		initEventHandlers();
	}
	
	//JOptionPane.showMessageDialog(null, textoBuscar);

	public void initEventHandlers(){
		vista.btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String textoBuscar = vista.getTextFieldBuscar().getText();
			int numPalabras = modelo.buscarPalabras(textoBuscar);
			JOptionPane.showMessageDialog(vista.getTextAreaOriginal(), "Se encontraron " + numPalabras + "palabras que coinciden", "Numero palabras", JOptionPane.INFORMATION_MESSAGE);
		}
		});
	
		}

}
