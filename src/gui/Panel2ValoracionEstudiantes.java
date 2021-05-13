package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValoracionEstudiante;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel2ValoracionEstudiantes extends JPanel {
	
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Integer> jcbNota;
	
	JScrollPane scrollPaneNoSelected;
	JScrollPane scrollPaneSelected;
	
	JList<Estudiante> jListNoSelected;
	JList<Estudiante> jListSelected;
	
	private DefaultListModel<Estudiante> listModelNoSelected = null;
	private DefaultListModel<Estudiante> listModelSelected = null;
	
	private List<Estudiante> listaEstudiantesEvaluados = new ArrayList<Estudiante>();
	private List<Estudiante> listaEstudiantesNoEvaluados = new ArrayList<Estudiante>();
	
	/**
	 * Create the panel.
	 */
	public Panel2ValoracionEstudiantes() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{140, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//JComboBox en el que se introducen las notas
		jcbNota = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizar = new JButton("Actualizar alumnado");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarAlumnado();
			}
		});
		btnActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{120,0,0};
		gbl_panel_1.rowHeights = new int[]{0, 1};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnos no seleccionados:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		/**
		 * JList de los alumnos no seleccionados
		 */	
		JLabel lblNewLabel_4 = new JLabel("Alumnos seleccionados:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		jListNoSelected = new JList<Estudiante>(getDLMNoSelected());
		jListNoSelected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//Introducir la JList en un ScrollPane
		scrollPaneNoSelected = new JScrollPane(jListNoSelected);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPaneNoSelected, gbc_scrollPane);
		
		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 1;
		panel_1.add(panelBotones, gbc_panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0};
		gbl_panelBotones.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelBotones.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnTodosIzquierda = new JButton("");
		btnTodosIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarTodosEstudiantes();
			}
		});
		btnTodosIzquierda.setIcon(new ImageIcon(Panel2ValoracionEstudiantes.class.getResource("/images/primero.png")));
		GridBagConstraints gbc_btnTodosIzquierda = new GridBagConstraints();
		gbc_btnTodosIzquierda.insets = new Insets(0, 0, 5, 5);
		gbc_btnTodosIzquierda.gridx = 2;
		gbc_btnTodosIzquierda.gridy = 1;
		panelBotones.add(btnTodosIzquierda, gbc_btnTodosIzquierda);
		
		JButton btnIzquierda = new JButton("");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarEstudiantesSeleccionados();
			}
		});
		btnIzquierda.setIcon(new ImageIcon(Panel2ValoracionEstudiantes.class.getResource("/images/anterior.png")));
		GridBagConstraints gbc_btnIzquierda = new GridBagConstraints();
		gbc_btnIzquierda.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzquierda.gridx = 2;
		gbc_btnIzquierda.gridy = 2;
		panelBotones.add(btnIzquierda, gbc_btnIzquierda);
		
		JButton btnDerecha = new JButton("");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEstudiantesSeleccionados();
			}
		});
		btnDerecha.setIcon(new ImageIcon(Panel2ValoracionEstudiantes.class.getResource("/images/siguiente.png")));
		GridBagConstraints gbc_btnDerecha = new GridBagConstraints();
		gbc_btnDerecha.insets = new Insets(0, 0, 5, 5);
		gbc_btnDerecha.gridx = 2;
		gbc_btnDerecha.gridy = 3;
		panelBotones.add(btnDerecha, gbc_btnDerecha);
		
		JButton btnTodosDerecha = new JButton("");
		btnTodosDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				agregarTodosEstudiantes();
			}
		});
		btnTodosDerecha.setIcon(new ImageIcon(Panel2ValoracionEstudiantes.class.getResource("/images/ultimo.png")));
		GridBagConstraints gbc_btnTodosDerecha = new GridBagConstraints();
		gbc_btnTodosDerecha.insets = new Insets(0, 0, 0, 5);
		gbc_btnTodosDerecha.gridx = 2;
		gbc_btnTodosDerecha.gridy = 4;
		panelBotones.add(btnTodosDerecha, gbc_btnTodosDerecha);
		
		/**
		 * JList de los alumnos seleccionados
		 */	
		jListSelected = new JList<Estudiante>(getDLMSelected());
		jListSelected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//Introducir la JList en un ScrollPane
		scrollPaneSelected = new JScrollPane(jListSelected);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPaneSelected, gbc_scrollPane_1);
			
		JButton btnNewButton = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		cargarMaterias();//Cargar las materias en su JComboBox
		cargarProfesores();//Cargar los profesores en su JComboBox
		cargarNotas();//Cargar las notas en su JComboBox

	}
	
	/**
	 * Método que construye el modelo de JList, a utilizar para apartar los estudiantes no evaluados
	 */
	private DefaultListModel<Estudiante> getDLMNoSelected () {
		this.listModelNoSelected = new DefaultListModel<Estudiante>();
		return this.listModelNoSelected;
	}
	
	/**
	 * Método que construye el modelo de JList, a utilizar para evaluar estudiantes
	 */
	private DefaultListModel<Estudiante> getDLMSelected () {
		this.listModelSelected = new DefaultListModel<Estudiante>();
		return this.listModelSelected;
	}
	
	/**
	 * Método utilizado para cargar todos las materias en una lista para trabajarla en esta clase
	 */
	private void cargarMaterias() {
		List<Materia> materias = ControladorMateria.getInstance().findAll();
		
		for (Materia m: materias) {
			this.jcbMateria.addItem(m);
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
	 * Método utilizado para cargar todos notas del 0 al 10 en el JComboBox de las notas
	 */
	private void cargarNotas() {
		for (int i = 0; i <= 10 ; i++) {
			this.jcbNota.addItem(i);
		}
	}
	
	/**
	 * Método utilizado para buscar los alumnos que existan con el profesor, materia y nota
	 * seleccionados 
	 */
	private void refrescarAlumnado() {
		//Cada vez que se refesque el alumnado hay que vaciar las JLists para que no se acumulen
		listModelSelected.clear();
		listModelNoSelected.clear();
		
		//Guardar en variables la materia, profesor y nota que se haya seleccionado para pasárselo a
		//findValoracionMateria y findMateriasNoEvaluadas y poder hacer la consulta
		Materia materia = (Materia) this.jcbMateria.getSelectedItem();
		Profesor profesor = (Profesor) this.jcbProfesor.getSelectedItem();
		int nota = (int) this.jcbNota.getSelectedItem();
		
		//Recibir los registros obtenidos en la lista listaEstudiantesEvaluados
		listaEstudiantesEvaluados = ControladorValoracionEstudiante.getInstance().findValoracionMateria(materia, profesor, nota);
		//Añadir al listModelSelected todos los registros que hay en la lista
		for (Estudiante e : listaEstudiantesEvaluados) {
			listModelSelected.addElement(e);
		}
		//Igual con los estudiantes no evaluados
		listaEstudiantesNoEvaluados = ControladorValoracionEstudiante.getInstance().findMateriasNoEvaluadas(materia, profesor, nota);
		
		for (Estudiante e : listaEstudiantesNoEvaluados) {
			listModelNoSelected.addElement(e);
		}
	}
	
	/**
	 * Para eliminar todos los estudiantes seleccionados en la lista de los seleccionados y pasarlos
	 * a la lista de evaluados(jListSelected)
	 */
	private void eliminarEstudiantesSeleccionados () {
		for (int i = 0; i < this.jListSelected.getSelectedIndices().length; i++) {
			this.listModelNoSelected.addElement(this.listModelSelected.getElementAt(this.jListSelected.getSelectedIndices()[i]));
		}
		 //Al quitarlos de la lista de no evaluados debemos comenzar desde la última e ir haciendo el 
		 //barrido hasta la primera.
		for (int i = this.jListSelected.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelSelected.removeElementAt(this.jListSelected.getSelectedIndices()[i]);
		}

	}
	
	/**
	 * Para eliminar todos los estudiantes seleccionados en la lista de los no seleccionados y pasarlos
	 * a la lista de evaluados(jListSelected)
	 */
	private void agregarEstudiantesSeleccionados () {
		for (int i = 0; i < this.jListNoSelected.getSelectedIndices().length; i++) {
			this.listModelSelected.addElement(this.listModelNoSelected.getElementAt(this.jListNoSelected.getSelectedIndices()[i]));
		}
		//Al quitarlos de la lista de evaluados debemos comenzar desde la última e ir haciendo el 
		 //barrido hasta la primera.
		for (int i = this.jListNoSelected.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelNoSelected.removeElementAt(this.jListNoSelected.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * Agregar todos los estudiantes a lista de los seleccionados
	 */
	private void agregarTodosEstudiantes() {	
		for (int i = 0; i < this.listModelNoSelected.size(); i++) {
			this.listModelSelected.addElement(this.listModelNoSelected.elementAt(i));
		}
		//Una vez pasados todos a una JList hay que vaciar la otra
		this.listModelNoSelected.clear();
	}
	
	/**
	 * Agregar todos los estudiantes a la lista de los No seleccionados
	 */
	private void eliminarTodosEstudiantes() {
		for (int i = 0; i < this.listModelSelected.size(); i++) {
			this.listModelNoSelected.addElement(this.listModelSelected.elementAt(i));
		}
		//Una vez pasados todos a una JList hay que vaciar la otra
		this.listModelSelected.clear();
	}
	
	/**
	 * Método utilizado para guardar los registros según el Profesor, Materia y Nota seleccionados.
	 * Puede ser que se introduzca un nuevo registro o que se modifique tan solo la nota de un alumnos 
	 */
	private void guardar() {
		//Guardar en variables la materia, profesor y nota que se haya seleccionado para pasárselo a
		//findValoracionMateria y findMateriasNoEvaluadas y poder hacer la consulta
		Materia materia = (Materia) this.jcbMateria.getSelectedItem();
		Profesor profesor = (Profesor) this.jcbProfesor.getSelectedItem();
		int nota = (int) this.jcbNota.getSelectedItem();
		
		//Recorrer el JList de los alumnos seleccionados para evaluar
		for (int i=0; i < listModelSelected.getSize(); i++) {
			//Tomamos una referencia del estudiante que haya con cada iteración
			Estudiante e = this.listModelSelected.elementAt(i);
			//Buscar la valoración que tiene cada estudiante mediante un objeto ValoracionMateria
			ValoracionMateria vm = ControladorValoracionEstudiante.getInstance().findValoracionMateria(profesor, e, materia);
			//Si el estudiante no tiene valoración, significa que va a se evaluado por primera vez 
			//con el profesor y la materia seleccionada
			//Entonces hay que ponerle todos sus campos para luego introducirlos
			if (vm == null) {
				vm = new ValoracionMateria();
				vm.setEstudiante(e);
				vm.setMateria(materia);
				vm.setProfesor(profesor);
				vm.setValoracion(nota);
				
			} else { //Si ya tenía valoración, tan solo hay que cambiarla con la nueva seleccionada
				vm.setValoracion(nota);
			}
			
			//Es el momento de guardar el registro en la base de datos, por tanto llamamos a guardar
			//del controlador pasándole el objeto ValoracionMateria que hemos modificado o añadido 
			boolean resultado = ControladorValoracionEstudiante.getInstance().guardar(vm);
			
			//El método guardar del controlador devuelve un campo booleano, por tanto nos sirve para
			//comprobar que se ha guardado correctamente
			if (resultado == true && vm != null && vm.getId() > 0) {
				JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al guardar");
			}
		}
	}
	
}
