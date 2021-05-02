package gui;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.controllers.ControladorTipologiaSexo;
import model.entities.Tipologiasexo;


import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PanelDatosPersonal extends JPanel{

	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<Tipologiasexo> jcbSexo;
	private JScrollPane scrollPane;
	private JButton btnCambiarImagen;
	private JFileChooser jfileChooser;
	private byte[] arrayBytesImagen;
	private JLabel lblColor;
	private JTextField jtfColor;
	private JButton btnColor;
	private JColorChooser jColorChooser;
	private JPopupMenu menu;
	Color color;
	
	/**
	 * Método utilizado para cargar todos sexos en una lista para trabajarla en esta clase
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
		gridBagLayout.columnWidths = new int[]{0, 196, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		this.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 1;
		this.add(lblPrimerApellido, gbc_lblPrimerApellido);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 2;
		this.add(jtfApellido2, gbc_jtfApellido2);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridy = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		add(lblSexo, gbc_lblNewLabel_1);
		
		jcbSexo = new JComboBox<Tipologiasexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		this.add(jtfEmail, gbc_jtfEmail);
		
		btnCambiarImagen = new JButton("Cambiar");
		btnCambiarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaFichero();
			}
		});
		GridBagConstraints gbc_btnCambiarImagen = new GridBagConstraints();
		gbc_btnCambiarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiarImagen.gridx = 2;
		gbc_btnCambiarImagen.gridy = 6;
		add(btnCambiarImagen, gbc_btnCambiarImagen);
		
		JLabel lblNewLabel_6 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setColumns(10);
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		this.add(jtfTelefono, gbc_jtfTelefono);
		
		lblColor = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 8;
		add(lblColor, gbc_lblColor);
		
		jtfColor = new JTextField();
		jtfColor.setEnabled(false);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 8;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		btnColor = new JButton("Cambiar color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor(color);		
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 2;
		gbc_btnColor.gridy = 8;
		add(btnColor, gbc_btnColor);
		
		
		// Evento para mostrar el menú en las coordenadas que correspondan
		// Asignar el MouseListener al ScrollPane para que sólo funcione en este
		scrollPane.addMouseListener(new MouseAdapter() {
		 
			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}
			 
			@Override
			public void mouseReleased(MouseEvent e) {
			    showPopup(e);
			}
			 
			/**
			* M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
			* @param e
			*/
			private void showPopup(MouseEvent e) {
			    if (e.isPopupTrigger()) {
			    	JPopupMenu popup = getPopUpMenu();
			        popup.show(e.getComponent(),
			        e.getX(), e.getY());
			    }
			}
		});
		
		//Una vez colocados todos los elementos en el Panel, hay que cargar en el JComboBox
		//de sexo todos los elementos que hay en la base de datos
		cargarTipologiasSexo();
	}
	
	/**
	 * Método utilizado para poder cambiar el color favorito de los estudiantes o profesores
	 */
	private void seleccionaColor (Color color) {
		color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
		}
		setBackground(color);
	}
	
	/**
	 * Método utilizado para poder cambiar la imagen que tiene cada uno de los estudiantes y profesores
	 */
	private void seleccionaFichero () {
		this.jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Establecimiento de la carpeta de inicio
		this.jfileChooser.setCurrentDirectory(new File("C:\\"));
		
		// Tipo de selecci�n que se hace en el di�logo
		//this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros
		//this.jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // S�lo selecciona ficheros
		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Selecciona ficheros y carpetas
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().endsWith(".jpg") || f.getAbsolutePath().endsWith(".png")))) 
					return true;
				return false;
			}
		});
		
		// Abro el di�logo para la elecci�n del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = this.jfileChooser.getSelectedFile();
			//Asignar la imagen al Panel
			this.setImagen(leerContenidoFicheroBinario(fichero)); 
		}
	}
	
	/**
	 * Cargar en un array de bites el contenido de un fichero que será en este caso una imagen
	 * @param f
	 * @return
	 */
	private byte[] leerContenidoFicheroBinario (File f) {
		try {
			return Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[] {};
	}
	
	/**
	 * Una vez hecho click derecho sobre el ScrollPane se creará el JPopupMenu
	 * @return
	 */
	private JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		
		//Añadir las dimensiones
		menu.add(medidasImagenMenuItem("Dimensiones:"));
		menu.addSeparator(); //Separador
		//Añadir el botón para cambiar imagen
		menu.add(cambiarImagenMenuItem("Cambiar imagen"));
		
		return menu;
	}
	
	/**
	 * Menú Item para mostrar las medidas de la imagen
	 * @return
	 */
	private JMenuItem medidasImagenMenuItem (String titulo) {
		//Trabajaremos con un array de Bytes, por lo que obtendremos la imagen que haga en pantalla
		byte[] imagen = getImagen();
		//Transformar la imagen o array de bytes en un icono para poder obtener sus medidas
        ImageIcon image = new ImageIcon(imagen);
        //Hecho esto, crear el JMenu item con las medidas de la imagen
	    JMenuItem item = new JMenuItem(titulo + " " + image.getIconHeight() + " x " + image.getIconWidth());
        return item;
	}
	
	/**
	 * Menú Item para cambiar la imagen
	 * @return
	 */
	private JMenuItem cambiarImagenMenuItem (String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionaFichero();
            }
        });
        
        return item;
	}
	

	
	//Getters & Setters
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

	public String getColor() {
		return this.jtfColor.getText();
	}

	public void setColor(String color) {
		this.jtfColor.setText(color);
		this.setBackground(Color.decode(color));
	}

	public byte[] getImagen() {
		return this.arrayBytesImagen;
	}

	public void setImagen(byte[] imagen) {
		this.arrayBytesImagen = imagen;
		if (imagen != null) {
			ImageIcon image = new ImageIcon(imagen);
			JLabel lbl = new JLabel(image);
			this.scrollPane.setViewportView(lbl);
			this.scrollPane.revalidate();
			this.scrollPane.repaint();
		}
	}
}
