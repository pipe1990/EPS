package View;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaModificar extends JFrame{
	
	//ETIQUETAS
	private JLabel telefono, correo,direccion, documento, nombre;
	
	//CAMPOS DE TEXTO
	private JTextField txt_correo,txt_eps, txt_documento,  txt_nombre,  txt_salario;
	
	//BOTON
	private JButton  bt_modificar;
	
	public VentanaModificar() {
		
		//TITULO
		setTitle("Modificar");
		
		//TAMAÑO DE LA VENTANA
		setSize(500, 700);
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
		
		//ETIQUETA DOCUMENTO
		documento = new JLabel("Documento:");
		documento.setBounds(50, 50, 140, 20);
		add(documento);
		
		//ETIQUETA NOMBRE
		nombre = new JLabel("Nombre completo:");
		nombre.setBounds(50, 100, 140, 20);
		add(nombre);
		
		//ETIQUETA TELEFONO
		telefono = new JLabel("Telefono:");
		telefono.setBounds(50, 150, 140, 20);
		add(telefono);
		
		//ETIQUETA DIRECCION
		direccion = new JLabel("Direccion:");
		direccion.setBounds(50, 200, 140, 20);
		add(direccion);
		
		//ETIQUETA EPS
		correo = new JLabel("EPS:");
		correo.setBounds(50, 250, 140, 20);
		add(correo);
		
		//CAMPO DE TEXTO DOCUMENTO
		txt_documento = new JTextField();
		txt_documento.setBounds(200, 50, 170, 20);
		txt_documento.setEnabled(false);
		add(txt_documento);
		
		//CAMPO DE TEXTO NOMBRE
		txt_nombre = new JTextField();
		txt_nombre.setBounds(200, 100, 170, 20);
		txt_nombre.setEnabled(false);
		add(txt_nombre);
		
		//CAMPO DE TEXTO TELEFONO
		txt_salario = new JTextField();
		txt_salario.setBounds(200, 150, 170, 20);
		add(txt_salario);
		
		//CAMPO DE TEXTO DIRECCION
		txt_correo = new JTextField();
		txt_correo.setBounds(200, 200, 170, 20);
		add(txt_correo);
		
		//CAMPO DE TEXTO EPS
		txt_eps = new JTextField();
		txt_eps.setBounds(200, 250, 170, 20);
		txt_eps.setEnabled(false);
		add(txt_eps);
		
		//BOTON MODIFICAR DATOS
		bt_modificar = new JButton("Modificar");
		bt_modificar.setActionCommand("MODIFICAR2");
		bt_modificar.setBounds(200, 400, 100, 30);
		bt_modificar.setVisible(true);
		add(bt_modificar);
		
	}
	
	//GETTERS Y SETTERS

	public JLabel getTelefono() {
		return telefono;
	}

	public void setTelefono(JLabel telefono) {
		this.telefono = telefono;
	}

	public JLabel getCorreo() {
		return correo;
	}

	public void setCorreo(JLabel correo) {
		this.correo = correo;
	}

	public JLabel getDireccion() {
		return direccion;
	}

	public void setDireccion(JLabel direccion) {
		this.direccion = direccion;
	}


	public JLabel getDocumento() {
		return documento;
	}

	public void setDocumento(JLabel documento) {
		this.documento = documento;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}


	public JTextField getTxt_correo() {
		return txt_correo;
	}

	public void setTxt_correo(JTextField txt_correo) {
		this.txt_correo = txt_correo;
	}

	public JTextField getTxt_eps() {
		return txt_eps;
	}

	public void setTxt_eps(JTextField txt_eps) {
		this.txt_eps = txt_eps;
	}


	public JTextField getTxt_documento() {
		return txt_documento;
	}

	public void setTxt_documento(JTextField txt_documento) {
		this.txt_documento = txt_documento;
	}

	
	
	public JTextField getTxt_nombre() {
		return txt_nombre;
	}

	public void setTxt_nombre(JTextField txt_nombre) {
		this.txt_nombre = txt_nombre;
	}

	public JTextField getTxt_salario() {
		return txt_salario;
	}

	public void setTxt_salario(JTextField txt_salario) {
		this.txt_salario = txt_salario;
	}

	public JButton getBt_modificar() {
		return bt_modificar;
	}

	public void setBt_modificar(JButton bt_modificar) {
		this.bt_modificar = bt_modificar;
	}
	
	
	
	
	
}
