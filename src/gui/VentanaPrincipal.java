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
		//jTabbedPane.add("",new ());
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
		
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
		EntityManager em = factory.createEntityManager();
		
		Curso c = em.find(Curso.class, 1);
		
		System.out.println("Curso: " + c.getDescripcion());
		em.close();
		*/
	}

}
