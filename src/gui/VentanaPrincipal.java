package gui;

import java.awt.BorderLayout;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VentanaPrincipal extends JFrame {
	
	static {
		setApariencia(); //Por estética, pondremos en la ventana la apariencia de Windows
	}

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
	 * Constructor de Ventana Principal, a partir de aquí se ejecuta todo el programa
	 */
	public VentanaPrincipal() {
		super("Gestion Centro Educativo"); //Asignar el nombre de la ventana pasándole al JFrame un String
		this.setBounds(200, 100, 600, 400); //Asignar unas coordenadas y medidas
		
		//Añadir un JMenuBar llamando al constructor de la clase MenuBar
		this.setMenuBar(new MenuBar());
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
		jTabbedPane.add("Estudiantes", new PanelEstudiantes());
		jTabbedPane.add("Profesores",new PanelProfesores());
		jTabbedPane.add("Valoracion Estudiantes",new PanelValoracionEstudiantes());
		//jTabbedPane.add("",new ());
		//jTabbedPane.add("",new ());
		
		return jTabbedPane;
	}
	
	/**
	 * Es necesario establecer un getter del JTabbedPane para poder trabajar con el en el JMenuBar
	 * @return
	 */
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal.getInstance().setVisible(true);
		
		//Primera consulta para comprobar que se ha establecido la conexión con la BBDD
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
		EntityManager em = factory.createEntityManager();
		
		Curso c = em.find(Curso.class, 1);
		
		System.out.println("Curso: " + c.getDescripcion());
		em.close();
		*/
	}

	/**
	 * Método que incorpora la apariencia de las interfaces gráficas de Windows
	 */
	public static void setApariencia() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
