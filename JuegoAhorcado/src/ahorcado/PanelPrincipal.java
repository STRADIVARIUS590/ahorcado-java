package ahorcado;
//Nombre: Cristian Joel Verdugo Verudgo
//Carrera: IDS
//Cuarto semestre TM
//Materia: Programacion 3
//Ejerrcicio 3: ahorcado
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import config.Words;


public class PanelPrincipal  extends JFrame implements ActionListener, KeyListener {

	//labels
	private JLabel cuadroImagen;
	private JLabel labelPalabra;
	private JLabel labelIntentos;
	
	//paneles
	private JPanel panelTeclado;
	private JPanel panelImagen;
	private JPanel panel; 

	//elememtos del juego
	private char letra; 
	private int intentos;
	private boolean juegoTerminado;
	private boolean []letrasParaMostrar;  
	private String palabraEscogida;
	String[] arregloPalabras = this.inicializar();
	//private String []arregloPalabras = {"ELEMENTO", "SECUENCIA", "MANZANA","GATO","ESTADIO","MESA","PERRO","GUITARRA",
	//"ORTOGONAL","TEMBLOR","CANTERA", "ORBITA", "TABLERO", "BATERIA","CUERDA","GALLO","MARTILLO","MACETA","PERICO","VOLCAN"};
	private JButton[] arregloBotones = new JButton[26];
	private int numAleatorio;
	public PanelPrincipal() {
	
		agregarElementos();
		addKeyListener(this);
	    this.setSize(650,400);
	    this.setResizable(false);
        this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
	    /**/
		this.setVisible(true);
		
	}

	private void agregarElementos() {
		
		panel = new JPanel();
		panelImagen = new JPanel();
		panel.setLayout(new GridLayout(3,1,0,0));
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		labelPalabra = new JLabel("");	
		labelPalabra.setFont(new Font("Times New Roman", Font.BOLD,30));
		labelPalabra.setHorizontalAlignment(JLabel.CENTER);
		cuadroImagen = new JLabel();
		panelImagen.setBackground(Color.WHITE);
		labelIntentos = new JLabel("Intentos: 10" );
		labelIntentos.setFont(new Font("Times New Roman",Font.BOLD,15));
		panelImagen.add(labelIntentos);
		cuadroImagen = new JLabel(crearImagen("../imagenes/10.png"));
		cuadroImagen.setPreferredSize(new Dimension(100,100));
		panelImagen.add(cuadroImagen);
	    panel.add(labelPalabra);
		panel.add(panelImagen);
		panelTeclado = new JPanel();
		panelTeclado.setLayout(new GridLayout(5,6,0,0));
		panel.add(panelTeclado);
		this.add(panel);
		agregarBotones();
		nuevaPalabra();
	
	}
	
	
	private void agregarBotones() {
		for(int i = 0 ; i<26; i++) {
			arregloBotones[i] = new JButton(String.valueOf((Character.valueOf((char)(i+65)))));
			arregloBotones[i].addActionListener(this);
			arregloBotones[i].addKeyListener(this);
		    arregloBotones[i].setEnabled(true);
			panelTeclado.add(arregloBotones[i]);	    
		}	  
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!juegoTerminado) {
			letra = e.getActionCommand().charAt(0);
			validarLetra(letra);
		    arregloBotones[Integer.valueOf((e.getActionCommand().charAt(0)-65))].setEnabled(false);
		}else {
			System.out.println("El juego ha terminado");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(!juegoTerminado) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
			if(e.getKeyCode()>64 && e.getKeyCode()<91) {
				if(arregloBotones[Integer.valueOf(e.getKeyCode()-65)].isEnabled() ){
					arregloBotones[Integer.valueOf(e.getKeyCode()-65)].setEnabled(false);
					validarLetra(e.getKeyChar());
				}
				 		// System.out.println( Integer.decode("1234.45"));
			            
			}			
		}
//		else {
//			System.out.println("Se ha terminado el juego!");
//		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	private String escogerPalabra() {
		if (hayPalabrasDisponibles()) {
			do {
				numAleatorio = (int)(Math.random()*arregloPalabras.length);
				palabraEscogida =  arregloPalabras[numAleatorio];
			}while(palabraEscogida==null);
			System.out.println("Palabra num:  "+numAleatorio);
			return palabraEscogida;			 		
		}else {
			return null;
		}
	}
	
	
	private void validarLetra(char letraEscogida){
         
		 if(!palabraEscogida.contains(""+letraEscogida)) { // SI LA CADENA  NO CONTIENE LA ETRA INGRESADA
			 if(intentos>1) {
 				 cuadroImagen.setIcon(crearImagen("../imagenes/"+String.valueOf(intentos-1)+".png"));
// 				 System.out.println("imagen numero    "+(intentos-1));
			 }
			 else {
				 juegoTerminado = true;
//				 System.out.println("has perdido!");
			     cuadroImagen.setIcon(crearImagen("../imagenes/0.png"));
			     labelIntentos.setText("Fallaste! (Nuevo Juego: Ctrl+Alt+6)");
				 return;
			 } 
		     labelIntentos.setText("Intentos: " + (intentos-1));
		     intentos--;
//		System.out.println("No contiene esa letra.   INTENTOS: " + (intentos));	
		 }
		 else{
			 labelPalabra.setText("");
			 for(int i = 0; i<palabraEscogida.length(); i++) {
				 if (letrasParaMostrar[i] || (palabraEscogida.charAt(i) == letraEscogida) ) {
					 letrasParaMostrar[i] = true;
					 labelPalabra.setText(labelPalabra.getText() + " "+palabraEscogida.charAt(i)+" ");
				 }else {
					 letrasParaMostrar[i] = false;
					 labelPalabra.setText(labelPalabra.getText() + " _ ");	 
				 } 
			 }
		 }
		System.out.println("palabra en el tablero:   @"+labelPalabra.getText().replace(" ", "").replace("_", "")+"@");
		if(palabraEscogida.equals(labelPalabra.getText().replace(" ", "").replace("_", ""))) {
//		System.out.println("Se ha adivinado la palabra!");
		
			labelIntentos.setText("Adivinaste!  (Nuevo Juego :Ctrl+Alt+6) ");
			juegoTerminado = true;
			System.out.println("Se ha eliminado la palabra " +arregloPalabras[numAleatorio] );
			arregloPalabras[numAleatorio] = null;
			
		}
	}
	public void nuevaPalabra() {
		this.palabraEscogida = escogerPalabra();
		if(palabraEscogida == null) {
//			System.out.println("                            No hay palabras disponibles ");
			this.juegoTerminado = true;
			deshabilitarTeclado();
			return;
		}
		this.juegoTerminado = false;
		this.labelPalabra.setText("");
		System.out.println("Palabra : " + palabraEscogida);
		intentos = 10;
		cuadroImagen.setIcon((crearImagen("../imagenes/"+(String.valueOf(intentos))+".png")));
		labelIntentos.setText("");
		labelIntentos.setText("Intentos: " + intentos );
		letrasParaMostrar = new boolean[palabraEscogida.length()];
		for(int i = 0; i<palabraEscogida.length(); i++) {
			letrasParaMostrar[i] = false;
			labelPalabra.setText(labelPalabra.getText()+" _ ");
		}
		for(int i = 0; i<arregloBotones.length; i++) {
			if(arregloBotones[i]==null)
				continue;
			arregloBotones[i].setEnabled(true);
		}
	}
	
	private ImageIcon crearImagen(String ruta) {
		Image icono = null;
		try {
			icono = ImageIO.read(getClass().getResource(ruta));
			icono = icono.getScaledInstance(100,100, Image.SCALE_SMOOTH);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new  ImageIcon(icono);
	}
	
	private boolean hayPalabrasDisponibles() {
		for(int i = 0 ; i< arregloPalabras.length; i++) {
			if (arregloPalabras[i]!= null)
				return true;
		}
		labelPalabra.setText("No hay palabras disponibles!");
//		System.out.println("No hay palabras dispoibles");
		return false;
	}
	
	private  void deshabilitarTeclado() {
		for (JButton i: arregloBotones) {
			if(i!=null && i.isEnabled())
				i.setEnabled(false);
		}
	}
	public void mostrarPista() {
		int numAleatorio2;
		if(!juegoTerminado) {
			do {
				numAleatorio2 = (int)(Math.random()*palabraEscogida.length());
			}while(labelPalabra.getText().contains((palabraEscogida).charAt(numAleatorio2)+""));
//			System.out.println(Integer.valueOf(palabraEscogida.charAt(numAleatorio)-65));
			arregloBotones[Integer.valueOf(palabraEscogida.charAt(numAleatorio2)-65)].setEnabled(false);
			validarLetra(palabraEscogida.charAt(numAleatorio2));				
		}
	}
	public void mostrarSolucion() {
		
		this.labelPalabra.setText(palabraEscogida.replace(""," "));	
		juegoTerminado = true;
	}
	
	public String[] inicializar(){
		
		 Words wordsArray[] = Words.values();
		 
		 return wordsArray[0].getArray();
	}
}