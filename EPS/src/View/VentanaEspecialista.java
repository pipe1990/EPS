package View;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEspecialista extends JFrame{
	//BOTONES
	private JButton  bt_salir,bt_guardar_imagen,bt_actualizar_diagnostico, bt_buscar_imagen, bt_enviar;
	
	//COMBO BOX
	private JComboBox<String> cbx_tipo_imagen;
	
	//ETIQUETAS
	private JLabel  nombre, imagenes,tipo_documento, diagnostico;
	
	//CAMPOS DE TEXTO
	private JTextField  txt_nombre, txt_imagenes,txt_diagnostico, txt_archivo;
	
	public VentanaEspecialista() {
		//TITULO
		setTitle("Consulta Especialista");
		
		//TAMAÑO DE LA VENTANA
		setSize(600, 500);
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(176, 216, 230)); 
		elementos();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	//CREAR LOS ELEMENTOS DE LA VENTANA
	public void elementos() {
		
		//BOTON BUSCAR IMAGEN
		bt_buscar_imagen = new JButton("Examinar Imagen");
		bt_buscar_imagen.setActionCommand("EXAMINAR2");
		bt_buscar_imagen.setBounds(50, 300, 150, 30);
		bt_buscar_imagen.setVisible(true);
		add(bt_buscar_imagen);

		//BOTON GUARDAR IMAGEN	
		bt_guardar_imagen = new JButton("Guardar Imagen");
		bt_guardar_imagen.setActionCommand("GIMAGEN2");
		bt_guardar_imagen.setBounds(200, 300, 130, 30);
		bt_guardar_imagen.setVisible(true);
		add(bt_guardar_imagen);
		
		//ETIQUETA ENVIAR IMAGENES
		tipo_documento = new JLabel("Enviar Imagenes:");
		tipo_documento.setBounds(50, 100, 140, 20);
		add(tipo_documento);
		
		//COMBO BOX TIPO DE IMAGENES
		cbx_tipo_imagen =  new JComboBox<String>();
		cbx_tipo_imagen.setBounds(200, 100, 200, 20);
		cbx_tipo_imagen.addItem("--Seleccione--");
		cbx_tipo_imagen.addItem("RAYOS X");
		cbx_tipo_imagen.addItem("TOMOGRAFIA");
		cbx_tipo_imagen.addItem("ECOGRAFIA");
		cbx_tipo_imagen.addItem("RESONANCIA MAGNETICA");
		cbx_tipo_imagen.setActionCommand("TIPOIMAGEN");
		add(cbx_tipo_imagen);
		
		//ETIQUETA NOMBRE DE PACIENTE
		nombre = new JLabel("Nombre Paciente:");
		nombre.setBounds(50, 150, 140, 20);
		add(nombre);
		
		//CAMPO DE TEXTO NOMBRE
		txt_nombre = new JTextField();
		txt_nombre.setBounds(200,150, 380, 20);
		txt_nombre.setEnabled(false);
		add(txt_nombre);
		
		//ETIQUETA IMAGENES PREVIAS
		imagenes = new JLabel("Imagenes Previas:");
		imagenes.setBounds(50, 200, 200, 20);
		add(imagenes);
		
		//CAMPO DE TEXTO IMAGENES PREVIAS
		txt_imagenes = new JTextField();
		txt_imagenes.setBounds(200, 200, 380, 20);
		txt_imagenes.setEnabled(false);
		add(txt_imagenes);
		
		//ETIQUETA DIAGNOSTICO
		diagnostico = new JLabel("Diagnostico:");
		diagnostico.setBounds(50, 250, 140, 20);
		add(diagnostico);
		
		//CAMPO DE TEXTO DIAGNOSTICO
		txt_diagnostico = new JTextField();
		txt_diagnostico.setBounds(200,250, 250, 20);
		add(txt_diagnostico);
		
		//BOTON ACTUALIZAR DIAGNOSTICO
		bt_actualizar_diagnostico = new JButton("Actualizar");
		bt_actualizar_diagnostico.setActionCommand("ACTUALIZARDIAGNOSTICO");
		bt_actualizar_diagnostico.setBounds(460, 250, 130, 30);
		bt_actualizar_diagnostico.setVisible(true);
		add(bt_actualizar_diagnostico);
		
		//BOTON ENVIAR EXAMEN
		bt_enviar = new JButton("Enviar Examen");
		bt_enviar.setActionCommand("ENVIAR");
		bt_enviar.setBounds(200, 400, 150, 30);
		bt_enviar.setVisible(true);
		add(bt_enviar);
		
		//BOTON SALIR
		bt_salir = new JButton("Salir");
		bt_salir.setActionCommand("SALIR2");
		bt_salir.setBounds(330, 4500, 100, 30);
		bt_salir.setVisible(true);
		add(bt_salir);
			
	}
	
	//GETTERS Y SETTERS

	public JButton getBt_actualizar_diagnostico() {
		return bt_actualizar_diagnostico;
	}

	public void setBt_actualizar_diagnostico(JButton bt_actualizar_diagnostico) {
		this.bt_actualizar_diagnostico = bt_actualizar_diagnostico;
	}

	public JTextField getTxt_diagnostico() {
		return txt_diagnostico;
	}

	public void setTxt_diagnostico(JTextField txt_diagnostico) {
		this.txt_diagnostico = txt_diagnostico;
	}

	public JButton getBt_enviar() {
		return bt_enviar;
	}

	public void setBt_enviar(JButton bt_enviar) {
		this.bt_enviar = bt_enviar;
	}

	public JButton getBt_guardar_imagen() {
		return bt_guardar_imagen;
	}

	public void setBt_guardar_imagen(JButton bt_guardar_imagen) {
		this.bt_guardar_imagen = bt_guardar_imagen;
	}

	public JButton getBt_buscar_imagen() {
		return bt_buscar_imagen;
	}

	public void setBt_buscar_imagen(JButton bt_buscar_imagen) {
		this.bt_buscar_imagen = bt_buscar_imagen;
	}

	public JTextField getTxt_archivo() {
		return txt_archivo;
	}

	public void setTxt_archivo(JTextField txt_archivo) {
		this.txt_archivo = txt_archivo;
	}

	public JButton getBt_salir() {
		return bt_salir;
	}

	public void setBt_salir(JButton bt_salir) {
		this.bt_salir = bt_salir;
	}

	public JComboBox<String> getCbx_tipo_imagen() {
		return cbx_tipo_imagen;
	}

	public void setCbx_tipo_imagen(JComboBox<String> cbx_tipo_imagen) {
		this.cbx_tipo_imagen = cbx_tipo_imagen;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getImagenes() {
		return imagenes;
	}

	public void setImagenes(JLabel imagenes) {
		this.imagenes = imagenes;
	}

	public JLabel getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(JLabel tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(JTextField txt_nombre) {
		this.txt_nombre = txt_nombre;
	}

	public JTextField getTxt_imagenes() {
		return txt_imagenes;
	}

	public void setTxt_imagenes(JTextField txt_imagenes) {
		this.txt_imagenes = txt_imagenes;
	}

	
	
	
}