package gui;

import java.awt.BorderLayout;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	private JTabbedPane jTabbedPane = null;
	private static VentanaPrincipal instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static VentanaPrincipal getInstance() {
		if (instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Gestion de venta de coches"); //Asignar el nombre de la ventana pasándole al JFrame un String
		this.setBounds(200, 100, 600, 400); //Asignar unas coordenadas y medidas
		
		//Añadir un JMenuBar llamando al constructor de la clase MenuBar
		this.setJMenuBar(new MenuBar());
		//Añadir un BorderLayout
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
	}
	
	/**
	 * Creación de un una ventana con pestañas para añadir los distintos paneles
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		//Añadir los distintos paneles
		//jTabbedPane.add("", new ());
		//jTabbedPane.add("",new ());
		//jTabbedPane.add("",new ());
		//jTabbedPane.add("",new ());
		//jTabbedPane.add("",new ());
		
		return jTabbedPane;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
