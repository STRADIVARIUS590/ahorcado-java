package ahorcado;
//Nombre: Cristian Joel Verdugo Verudgo
//Carrera: IDS
//Cuarto semestre TM
//Materia: Programacion 3
//Ejerrcicio 3: ahorcado
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 

public class EscuchaMenu implements ActionListener {
	PanelPrincipal ventana;
	public EscuchaMenu(PanelPrincipal ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()) {
			case "Nueva Palabra":{
				ventana.nuevaPalabra();
				break;
			}
			case "Pista":{
				ventana.mostrarPista();
				break;
			}
			case "Solucion":{
				ventana.mostrarSolucion();
				break;
			}
			
//			case "Nuevo Juego":{
//				ventana.inicializar();
//				ventana.nuevaPalabra();
//				break;
//			}
			default: 
//				System.exit(0);
				break;
		}
	}
	

}
