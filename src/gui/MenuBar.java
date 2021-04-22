package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	/**
	 * Constructor MenuBar
	 */
	public MenuBar() {
		//Crear un JMenu que se llamará Archivo
		JMenu menuArchivo = new JMenu("Archivo");
		this.add(menuArchivo); //Añadirlo al JMenuBar
		
		//Declarar un Array de tipo String con el valor de todos los elementos que habrá en el JMenu
		String entidades[] = new String[] {"", "", "", "", ""};
		
		//Recorrer el array comprobando cuado se hace click, en cual se ha hecho
		for (int i = 0; i < entidades.length; i++) {
			/*Para poder trabajar en la clase anónima con el valor de i del for hay que asignarselo a una 
			 *variable final. De esta manera, cada vez que se ejecute el for, conseguiremos cambiar el valor
			 *de iFinal*/
			final int iFinal = i;
			JMenuItem item = new JMenuItem(entidades[i]);
			item.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaPrincipal.getInstance().getjTabbedPane().setSelectedIndex(iFinal);	
				}
			});
			menuArchivo.add(item);
		}	
	}

}
