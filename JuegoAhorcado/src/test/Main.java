package test;
//Nombre: Cristian Joel Verdugo Verudgo
//Carrera: IDS
//Cuarto semestre TM
//Materia: Programacion 3
//Ejerrcicio 3: ahorcado
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ahorcado.EscuchaMenu;
import ahorcado.PanelPrincipal;

public class Main {
    static PanelPrincipal panel;
    static EscuchaMenu escucha;
	public static void main(String[] args) {
		 
    panel = new PanelPrincipal(); 
    panel.setTitle("Ahorcado");
	escucha = new EscuchaMenu(panel);
	panel.setJMenuBar(barraMenu(panel));
	 
	}
	public static JMenuBar barraMenu(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		JMenu opciones = new JMenu("Opciones");	
		
		
		JMenuItem reiniciarJuego = new JMenuItem("Reiniciar");
		reiniciarJuego.addActionListener(escucha);
		opciones.add(reiniciarJuego);
		
		
		
		JMenuItem nuevaPalabra = new JMenuItem("Nueva Palabra");
		nuevaPalabra.setMnemonic(KeyEvent.VK_6);
		nuevaPalabra.addActionListener(escucha);
		nuevaPalabra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		opciones.add(nuevaPalabra);
		
		
		JMenuItem pista = new JMenuItem("Pista");
		pista.setMnemonic(KeyEvent.VK_7);
		pista.addActionListener(escucha);
		pista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		opciones.add(pista);
		
		
		JMenuItem solucion = new JMenuItem("Solucion");
		solucion.setMnemonic(KeyEvent.VK_8);
		solucion.addActionListener(escucha);
		solucion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		opciones.add(solucion);

		
		JMenuItem salir = new JMenuItem("Salir");
		salir.setMnemonic(KeyEvent.VK_9);
		salir.addActionListener(escucha);
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		opciones.add(salir);
		menuBar.add(opciones);
		return menuBar;
		
	}
	
}
