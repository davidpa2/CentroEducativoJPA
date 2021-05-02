package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.controllers.ControladorValoracionEstudiante;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import java.awt.Insets;
import javax.swing.JLabel;

public class FichaEstudiante extends JPanel {
	
	private JTextField jtfNota;
	private JLabel lblEstudiante;
	
	ValoracionMateria actual;
	private Estudiante estudiante;
	private Profesor profesor;
	private Materia materia;
	
	/**
	 * Cargar el estudiante actual a partir del profesor y materia seleccionados
	 */
	public void cargarActual () {
		//Intentar asignar a la ficha actual una valoración según el profesor, materia y alumno
		try { 
			this.actual = ControladorValoracionEstudiante.getInstance().findValoracionMateria(profesor, estudiante, materia);
			jtfNota.setText("" + actual.getValoracion());
		} catch (Exception e) {
			//Si no tiene una valoración creada, la valoración se mostrará en pantalla como -1
			this.actual = new ValoracionMateria();
			this.actual.setEstudiante(this.estudiante);
			this.actual.setProfesor(this.profesor);
			this.actual.setMateria(this.materia);
			jtfNota.setText("-1");
		}
	}
	
	/**
	 * Guardar los registros introducidos una vez calificados los estudiantes
	 * @return
	 */
	public boolean guardar() {
		boolean resultado = true;
		float nota = Float.parseFloat(jtfNota.getText());
		if (nota >= 0) {
			this.actual.setValoracion(nota);
			resultado = ControladorValoracionEstudiante.getInstance().guardar(this.actual);
			if (resultado == true && this.actual != null && this.actual.getId() > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if (nota < 0 && this.actual.getId() > 0) {
			this.actual.setValoracion(nota);
			resultado = ControladorValoracionEstudiante.getInstance().eliminar(this.actual);
		}
		return resultado;
	}
	

	/**
	 * Create the panel.
	 */
	public FichaEstudiante(Estudiante es, Profesor prof, Materia mat) {
		this.estudiante = es;
		this.profesor = prof;
		this.materia = mat;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{250, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblEstudiante = new JLabel(getNombre());
		GridBagConstraints gbc_lblEstudiante = new GridBagConstraints();
		gbc_lblEstudiante.insets = new Insets(20, 0, 20, 0);
		gbc_lblEstudiante.anchor = GridBagConstraints.EAST;
		gbc_lblEstudiante.gridx = 0;
		gbc_lblEstudiante.gridy = 0;
		add(lblEstudiante, gbc_lblEstudiante);
		
		jtfNota = new JTextField();
		GridBagConstraints gbc_jtfNota = new GridBagConstraints();
		gbc_jtfNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNota.gridx = 1;
		gbc_jtfNota.gridy = 0;
		add(jtfNota, gbc_jtfNota);
		jtfNota.setColumns(10);
		
		//Una vez colocado todos los elementos, hay que cargar la ficha creada con su nota
		cargarActual();

	}

	/**
	 * @return the actual
	 */
	public ValoracionMateria getActual() {
		return actual;
	}

	/**
	 * @param actual the actual to set
	 */
	public void setActual(ValoracionMateria actual) {
		this.actual = actual;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.estudiante + ":";
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.lblEstudiante.setText(nombre);
	}

	public JLabel getEstudiante() {
		return lblEstudiante;
	}

	public void setEstudiante(JLabel lblEstudiante) {
		this.lblEstudiante = lblEstudiante;
	}

	
}
