package gui;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import model.controllers.ControladorEstudiante;
import model.entities.Estudiante;
import model.entities.Tipologiasexo;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;

public class PanelEstudiantes extends JPanel {

	PanelDatosPersonal panelDatos = new PanelDatosPersonal();
	Estudiante actual = null;

	
	/**
	 * Create the panel.
	 */
	public PanelEstudiantes() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0,0,5,0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth = 2;
		add(panelDatos, gbc_lblNewLabel);

		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.gridwidth = 2;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/añadir.png")));
		toolBar.add(btnNuevo);
		
		JButton btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/primero.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/anterior.png")));
		toolBar.add(btnAnterior);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/siguiente.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("Último");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/ultimo.png")));
		toolBar.add(btnUltimo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/images/eliminar.png")));
		toolBar.add(btnEliminar);
		
		//De primeras buscar el primer registro y mostrarlo en pantalla
		this.actual = ControladorEstudiante.getInstance().findPrimero();
		cargarActualEnPantalla();
	}

	/**
	 * Método utilizado para asignar los valores del registro en el que se esté a los TextField 
	 * en pantalla
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			panelDatos.setNombre(this.actual.getNombre());
			panelDatos.setApellido1(this.actual.getApellido1());
			panelDatos.setApellido2(this.actual.getApellido2());
			
			//Hay que recorrer los elementos del JComboBox de sexo para saber cual está seleccionado
			for (int i = 0; i < this.panelDatos.getJcbSexo().getItemCount(); i++) {		
				if (this.actual.getTipologiasexo().getId() == panelDatos.getJcbSexo().getItemAt(i).getId()) {
					this.panelDatos.getJcbSexo().setSelectedIndex(i);
				}
			}
			
			panelDatos.setDni(this.actual.getDni());
			panelDatos.setDireccion(this.actual.getDireccion());
			panelDatos.setEmail(this.actual.getEmail());
			panelDatos.setTelefono(this.actual.getTelefono());
			panelDatos.setImagen(this.actual.getImagen());
			panelDatos.setColor(this.actual.getColorPreferido());
		}
	}
	
	/**
	 * Método utilizado para almacenar los datos que hay en pantalla
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setNombre(panelDatos.getNombre());
		this.actual.setApellido1(panelDatos.getApellido1());
		this.actual.setApellido2(panelDatos.getApellido2());
		
		this.actual.setTipologiasexo((Tipologiasexo) panelDatos.getJcbSexo().getSelectedItem());
		
		this.actual.setDni(panelDatos.getDni());
		this.actual.setDireccion(panelDatos.getDireccion());
		this.actual.setEmail(panelDatos.getEmail());
		this.actual.setTelefono(panelDatos.getTelefono());
		this.actual.setImagen(panelDatos.getImagen());
		this.actual.setColorPreferido(panelDatos.getColor());
	}

	/**
	 * Método utilizado para dos situaciones, guardar un registro modificado o guardar uno nuevo
	 */
	private void guardar() {
		//Primero comprobar qué registro hay en pantalla
		cargarActualDesdePantalla();
		//Comprobar que el registro se ha guardado correctamente
		boolean resultado = ControladorEstudiante.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	
	/**
	 * Método utilizado para vaciar los campos de los JTextField para poder añadir un registro nuevo
	 */
	private void vaciarCampos() {
		this.actual = new Estudiante();
		this.panelDatos.setNombre("");
		this.panelDatos.setApellido1("");
		this.panelDatos.setApellido2("");
		this.panelDatos.setDni("");
		this.panelDatos.setDireccion("");
		this.panelDatos.setEmail("");
		this.panelDatos.setTelefono("");
		this.panelDatos.setImagen(null);
	}
	
	/**
	 * Método utilizado para borrar un registro
	 */
	private void borrar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión Centro Educativo", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	//Si se elige la primera opción "Sí" 
	    	ControladorEstudiante.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    }
	}
	
}
