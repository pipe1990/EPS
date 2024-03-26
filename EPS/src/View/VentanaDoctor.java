package View;

import java.awt.Color;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VentanaDoctor extends JFrame{
	//BOTONES
	private JButton bt_especialista,bt_consultar_imagen,bt_buscar_imagen,bt_guardar_imagen, bt_salir;
	
	//ETIQUETAS
	private JLabel consultas,lblfoto, especialista,diagnostico, nombre, imagenes, sintomas,temperatura, presion,frecuencia, pulso;
	
	//CAMPOS DE TEXTO
	private JTextField txt_consultas, txt_nombre,txt_diagnostico,txt_archivo, txt_imagenes, txt_sintomas,txt_frecuencia,txt_temperatura,txt_pulso, txt_presion;
	
	//COMBO BOX
	private JComboBox<String> cbx_tipo_especialista;
	
	
	public VentanaDoctor() {
		//TITULO
		setTitle("Consulta");
		
		//TAMAÑO DE LA VENTANA
		setSize(1200, 600);
		
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
		bt_buscar_imagen.setBounds(30, 50, 150, 30);
		bt_buscar_imagen.setVisible(true);
		add(bt_buscar_imagen);		
			
		//BOTON GUARDAR IMAGEN
		bt_guardar_imagen = new JButton("Guardar Imagen");
		bt_guardar_imagen.setActionCommand("GIMAGEN2");
		bt_guardar_imagen.setBounds(180, 50, 130, 30);
		bt_guardar_imagen.setVisible(true);
		add(bt_guardar_imagen);
		
		//ETIQUETA
		especialista = new JLabel("Especialista:");
		especialista.setBounds(30, 200, 140, 20);
		add(especialista);
		
		//COMBO BOX ESPECIALISTA
		cbx_tipo_especialista =  new JComboBox<String>();
		cbx_tipo_especialista.setBounds(160, 200, 200, 20);
		cbx_tipo_especialista.addItem("--Seleccione--");
		cbx_tipo_especialista.addItem("RADIOLOGO");
		cbx_tipo_especialista.addItem("CIRUJANO ORTOPEDICO");
		cbx_tipo_especialista.setActionCommand("TIPOIMAGEN");
		add(cbx_tipo_especialista);
		
		//ETIQUETA
		consultas = new JLabel("Consultas previas:");
		consultas.setBounds(30, 250, 140, 20);
		add(consultas);
		
		//CAMPO DE TEXTO CONSULTA
		txt_consultas = new JTextField();
		txt_consultas.setBounds(160, 250, 50, 20);
		txt_consultas.setEnabled(false);
		add(txt_consultas);
		
		//ETIQUETA
		presion = new JLabel("Presion Asistolica:");
		presion.setBounds(30, 300, 140, 20);
		add(presion);
		
		//CAMPO DE TEXTO PRESION
		txt_presion = new JTextField();
		txt_presion.setBounds(160, 300, 50, 20);
		add(txt_presion);
		
		//ETIQUETA
		pulso = new JLabel("Pulso:");
		pulso.setBounds(350, 300, 140, 20);
		add(pulso);
		
		//CAMPO DE TEXTO PULSO
		txt_pulso = new JTextField();
		txt_pulso.setBounds(410,300, 50, 20);
		add(txt_pulso);
		
		//ETIQUETA
		frecuencia = new JLabel("Frecuencia Respiratoria:");
		frecuencia.setBounds(620, 300, 200, 20);
		add(frecuencia);
		
		//CAMPO DE TEXTO FRECUENCIA
		txt_frecuencia = new JTextField();
		txt_frecuencia.setBounds(780, 300, 50, 20);
		add(txt_frecuencia);
		
		//ETIQUETA
		temperatura = new JLabel("Temperatura:");
		temperatura.setBounds(960, 300, 140, 20);
		add(temperatura);
		
		//CAMPO DE TEXTO TEMPERATURA
		txt_temperatura = new JTextField();
		txt_temperatura.setBounds(1060, 300, 50, 20);
		add(txt_temperatura);
		
		//ETIQUETA
		nombre = new JLabel("Nombre Paciente:");
		nombre.setBounds(30, 350, 140, 20);
		add(nombre);
		
		//CAMPO DE TEXTO NOMBRE
		txt_nombre = new JTextField();
		txt_nombre.setBounds(160,350, 150, 20);
		txt_nombre.setEnabled(false);
		add(txt_nombre);
		
		//ETIQUETA
		sintomas = new JLabel("Sintomas:");
		sintomas.setBounds(390, 350, 140, 20);
		add(sintomas);
		
		//CAMPO DE TEXTO SINTOMAS
		txt_sintomas = new JTextField();
		txt_sintomas.setBounds(470, 350, 640, 20);
		add(txt_sintomas);
		
		//ETIQUETA
		diagnostico = new JLabel("Diagnostico:");
		diagnostico.setBounds(30, 400, 140, 20);
		add(diagnostico);
		
		//CAMPO DE TEXTO DIAGNOSTICO
		txt_diagnostico = new JTextField();
		txt_diagnostico.setBounds(160,400, 950, 20);
		add(txt_diagnostico);
		
		//BOTON REMITIR A ESPECIALISTA
		bt_especialista = new JButton("Remitir");
		bt_especialista.setActionCommand("REMITIR");
		bt_especialista.setBounds(470, 500, 100, 30);
		bt_especialista.setVisible(true);
		add(bt_especialista);
		
		//BOTON SALIR Y GUARDAR
		bt_salir = new JButton("Salir y Guardar");
		bt_salir.setActionCommand("SALIR");
		bt_salir.setBounds(620, 500, 120, 30);
		bt_salir.setVisible(true);
		add(bt_salir);
		
		
	}
	
	//GETTERS Y SETTERS
	
	public JButton getBt_buscar_imagen() {
		return bt_buscar_imagen;
	}
	

	public JButton getBt_consultar_imagen() {
		return bt_consultar_imagen;
	}

	public void setBt_consultar_imagen(JButton bt_consultar_imagen) {
		this.bt_consultar_imagen = bt_consultar_imagen;
	}

	public void setBt_buscar_imagen(JButton bt_buscar_imagen) {
		this.bt_buscar_imagen = bt_buscar_imagen;
	}

	public JButton getBt_guardar_imagen() {
		return bt_guardar_imagen;
	}

	public void setBt_guardar_imagen(JButton bt_guardar_imagen) {
		this.bt_guardar_imagen = bt_guardar_imagen;
	}

	public JLabel getLblfoto() {
		return lblfoto;
	}

	public void setLblfoto(JLabel lblfoto) {
		this.lblfoto = lblfoto;
	}

	public JTextField getTxt_archivo() {
		return txt_archivo;
	}

	public void setTxt_archivo(JTextField txt_archivo) {
		this.txt_archivo = txt_archivo;
	}

	public JTextField getTxt_diagnostico() {
		return txt_diagnostico;
	}

	public void setTxt_diagnostico(JTextField txt_diagnostico) {
		this.txt_diagnostico = txt_diagnostico;
	}

	public JComboBox<String> getCbx_tipo_especialista() {
		return cbx_tipo_especialista;
	}

	public void setCbx_tipo_especialista(JComboBox<String> cbx_tipo_especialista) {
		this.cbx_tipo_especialista = cbx_tipo_especialista;
	}

	public JTextField getTxt_consultas() {
		return txt_consultas;
	}

	public void setTxt_consultas(JTextField txt_consultas) {
		this.txt_consultas = txt_consultas;
	}

	

	public JButton getBt_especialista() {
		return bt_especialista;
	}

	public void setBt_especialista(JButton bt_especialista) {
		this.bt_especialista = bt_especialista;
	}

	public JButton getBt_salir() {
		return bt_salir;
	}

	public void setBt_salir(JButton bt_salir) {
		this.bt_salir = bt_salir;
	}

	public JLabel getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(JLabel temperatura) {
		this.temperatura = temperatura;
	}

	public JLabel getPresion() {
		return presion;
	}

	public void setPresion(JLabel presion) {
		this.presion = presion;
	}

	public JLabel getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(JLabel frecuencia) {
		this.frecuencia = frecuencia;
	}

	public JLabel getPulso() {
		return pulso;
	}

	public void setPulso(JLabel pulso) {
		this.pulso = pulso;
	}

	public JTextField getTxt_frecuencia() {
		return txt_frecuencia;
	}

	public void setTxt_frecuencia(JTextField txt_frecuencia) {
		this.txt_frecuencia = txt_frecuencia;
	}

	public JTextField getTxt_temperatura() {
		return txt_temperatura;
	}

	public void setTxt_temperatura(JTextField txt_temperatura) {
		this.txt_temperatura = txt_temperatura;
	}

	public JTextField getTxt_pulso() {
		return txt_pulso;
	}

	public void setTxt_pulso(JTextField txt_pulso) {
		this.txt_pulso = txt_pulso;
	}

	public JTextField getTxt_presion() {
		return txt_presion;
	}

	public void setTxt_presion(JTextField txt_presion) {
		this.txt_presion = txt_presion;
	}

	public JLabel getConsultas() {
		return consultas;
	}

	public void setConsultas(JLabel consultas) {
		this.consultas = consultas;
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

	public JLabel getSintomas() {
		return sintomas;
	}

	public void setSintomas(JLabel sintomas) {
		this.sintomas = sintomas;
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

	public JTextField getTxt_sintomas() {
		return txt_sintomas;
	}

	public void setTxt_sintomas(JTextField txt_sintomas) {
		this.txt_sintomas = txt_sintomas;
	}

		


}
