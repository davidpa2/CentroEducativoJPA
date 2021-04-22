package gui;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.controllers.ControladorTipologiaSexo;
import model.entities.Tipologiasexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;

public class PanelDatosPersonal extends JPanel{

	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<Tipologiasexo> jcbSexo;
	
	/**
	 * Método utilizado para cargar todos los coches en una lista para trabajarla en esta clase
	 */
	private void cargarTipologiasSexo() {
		List<Tipologiasexo> sexos = ControladorTipologiaSexo.getInstance().findAll();
		
		for (Tipologiasexo t: sexos) {
			this.jcbSexo.addItem(t);
		}
	}
	

	/**
	 * Create the application.
	 */
	public PanelDatosPersonal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNombre, gbc_lblNewLabel);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 1;
		this.add(lblPrimerApellido, gbc_lblPrimerApellido);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 1;
		this.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 2;
		this.add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		jtfApellido2 = new JTextField();
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 2;
		this.add(jtfApellido2, gbc_jtfApellido2);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		add(lblSexo, gbc_lblNewLabel_1);
		
		jcbSexo = new JComboBox<Tipologiasexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 3;
		add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblDni = new JLabel("DNI:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		this.add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		this.add(jtfDni, gbc_jtfDni);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 5;
		this.add(lblDireccion, gbc_lblDireccion);
		
		jtfDireccion = new JTextField();
		jtfDireccion.setColumns(10);
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		this.add(jtfDireccion, gbc_jtfDireccion);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		this.add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		this.add(jtfEmail, gbc_jtfEmail);
		
		JLabel lblNewLabel_6 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setColumns(10);
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		this.add(jtfTelefono, gbc_jtfTelefono);
		
		cargarTipologiasSexo();
	}

	public String getNombre() {
		return this.jtfNombre.getText();
	}

	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}

	public String getApellido1() {
		return this.jtfApellido1.getText();
	}

	public void setApellido1(String apellido1) {
		this.jtfApellido1.setText(apellido1);
	}

	public String getApellido2() {
		return this.jtfApellido2.getText();
	}

	public void setApellido2(String apellido1) {
		this.jtfApellido2.setText(apellido1);
	}

	/*public int getSexo() {
		return this.jcbSexo.getSelectedIndex();
	}

	public void setSexo(int idSexo) {
		for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
			if (idSexo == this.jcbSexo.getItemAt(i).getId()) {
				this.jcbSexo.setSelectedIndex(i);
			}
		}
	}*/
	
	public JComboBox<Tipologiasexo> getJcbSexo() {
		return jcbSexo;
	}	
	
	public void setJcbSexo(JComboBox<Tipologiasexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	public String getDni() {
		return this.jtfDni.getText();
	}

	public void setDni(String dni) {
		this.jtfDni.setText(dni);;
	}

	public String getDireccion() {
		return this.jtfDireccion.getText();
	}

	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);;
	}

	public String getEmail() {
		return this.jtfEmail.getText();
	}

	public void setEmail(String email) {
		this.jtfEmail.setText(email);;
	}

	public String getTelefono() {
		return this.jtfTelefono.getText();
	}

	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);;
	}

}
