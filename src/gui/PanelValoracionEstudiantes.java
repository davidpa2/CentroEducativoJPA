package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class PanelValoracionEstudiantes extends JPanel {
	
	private JComboBox<Materia> jcbMaterias;
	private JComboBox<Profesor> jcbProfesor;
	private List<FichaEstudiante> listaFichas = new ArrayList<FichaEstudiante>();
	JScrollPane scrollPane;
	JPanel panelNotas;
	
	/**
	 * Método utilizado para cargar todos las materias en una lista para trabajarla en esta clase
	 */
	private void cargarMaterias() {
		List<Materia> materias = ControladorMateria.getInstance().findAll();
		
		for (Materia m: materias) {
			this.jcbMaterias.addItem(m);
		}
	}
	
	/**
	 * Método utilizado para cargar todos los profesores en una lista para trabajarla en esta clase
	 */
	private void cargarProfesores() {
		List<Profesor> profesores = ControladorProfesor.getInstance().findAll();
		
		for (Profesor p: profesores) {
			this.jcbProfesor.addItem(p);
		}
	}
	
	/**
	 * Para refescar los registros hay que comprobar la materia y profesor que se han seleccionado
	 */
	private void cargarEstudiantes() {
		panelNotas = new JPanel();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panelNotas.setLayout(gbl_panel_1);
		//Es importante limpiar la lista de fichas para que esté vacía y así mostrar sólo los nuevos
        //registros 
		this.listaFichas.clear();
		//Almacenar en una lista todos los estudiantes de la base de datos
		List<Estudiante> estudiantes = ControladorEstudiante.getInstance().findAll();
		//Ahora, para cada estuditante dentro de la lista se comprueba que profesor y materia hay seleccionado
		for (Estudiante e: estudiantes) {
			FichaEstudiante ficha = new FichaEstudiante(e,(Profesor) this.jcbProfesor.getSelectedItem()
					,(Materia) this.jcbMaterias.getSelectedItem());
			//Añadir a la lista de fichas cada uno de los registros obtenidos
			listaFichas.add(ficha);
		}
		
		//Hecho esto, hay que mostrar en pantalla todos los registros o fichas de alumnos.
		//Esto se hace en un GridBagLayout para poder ir aumentando el GridY e ir colocando una ficha
		//encima de otra
		for (int i = 0; i < listaFichas.size(); i++) {
			GridBagConstraints gbc_ficha = new GridBagConstraints();
			gbc_ficha.insets = new Insets(0, 0, 0, 5);
			gbc_ficha.anchor = GridBagConstraints.NORTH;
			gbc_ficha.gridx = 0;
			gbc_ficha.gridy = i;
			panelNotas.add(this.listaFichas.get(i), gbc_ficha);
		}
	
		this.scrollPane.setViewportView(panelNotas);//Asignar todo el tamaño del panel al scrollPane
		this.scrollPane.revalidate();
		this.scrollPane.repaint();
		
	}
	
	/**
	 * Guardar las valoraciones modificadas o añadidas
	 */
	private void guardarValoraciones() {
		boolean correcto = true;
		for (FichaEstudiante ficha : listaFichas) {
			correcto = ficha.guardar();
			if (correcto == false) {
				JOptionPane.showMessageDialog(this, "Error al guardar");
				break;
			}
		}
		if (correcto == true) {
			JOptionPane.showMessageDialog(this, "Registros guardados correctamente");
		}
	}

	/**
	 * Create the panel.
	 */
	public PanelValoracionEstudiantes() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 130, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 211, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMaterias = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMaterias = new GridBagConstraints();
		gbc_jcbMaterias.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMaterias.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMaterias.gridx = 1;
		gbc_jcbMaterias.gridy = 0;
		add(jcbMaterias, gbc_jcbMaterias);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JButton btnRefrescar = new JButton("Refrescar alumnado");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Al refescar el alumnado hay que mostrar todos los estudiantes con la nota que 
				//tengan según el profesor y materia
				cargarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.insets = new Insets(0, 0, 5, 0);
		gbc_btnRefrescar.gridx = 2;
		gbc_btnRefrescar.gridy = 1;
		add(btnRefrescar, gbc_btnRefrescar);
	
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGuardar = new JButton("Guardar notas de los alumnos");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarValoraciones();
			}
		});
		panel.add(btnGuardar);
		
		//Hay que cargar las materias y profesores en los JComboBox
		cargarMaterias();
		cargarProfesores();
	}
	
}
