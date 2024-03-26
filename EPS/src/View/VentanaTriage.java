package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaTriage extends JFrame{
	//BOTON
	private JButton bt_ok;
	
	//ETIQUETAS
	private JLabel presion, pulso, frecuencia, temperatura;
	
	//CAMPOS DE TEXTO
	private JTextField txt_presion, txt_pulso, txt_frecuencia, txt_temperatura;
	
	public VentanaTriage() {
		//TITULO
		setTitle("Triage");
		
		//TAMAÑO DE LA VENTANA
		setSize(800, 250);
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
		
		//ETIQUETA
		presion = new JLabel("Presion Asistolica:");
		presion.setBounds(30, 50, 140, 20);
		add(presion);
		
		//CAMPO DE TEXTO PRESION
		txt_presion = new JTextField();
		txt_presion.setBounds(160, 50, 50, 20);
		add(txt_presion);
		
		//ETIQUETA
		pulso = new JLabel("Pulso:");
		pulso.setBounds(220, 50, 140, 20);
		add(pulso);
		
		//CAMPO DE TEXTO PULSO
		txt_pulso = new JTextField();
		txt_pulso.setBounds(270,50, 50, 20);
		add(txt_pulso);
		
		//ETIQUETA
		frecuencia = new JLabel("Frecuencia Respiratoria:");
		frecuencia.setBounds(350, 50, 200, 20);
		add(frecuencia);
		
		//CAMPO DE TEXTO FRECUENCIA
		txt_frecuencia = new JTextField();
		txt_frecuencia.setBounds(510, 50, 50, 20);
		add(txt_frecuencia);
		
		//ETIQUETA
		temperatura = new JLabel("Temperatura:");
		temperatura.setBounds(590, 50, 140, 20);
		add(temperatura);
		
		//CAMPO DE TEXTO TEMPERATURA
		txt_temperatura = new JTextField();
		txt_temperatura.setBounds(690, 50, 50, 20);
		add(txt_temperatura);
		
		//BOTON LISTO
		bt_ok = new JButton("Ok");
		bt_ok.setActionCommand("OK");
		bt_ok.setBounds(350, 150, 100, 30);
		bt_ok.setVisible(true);
		add(bt_ok);		
	}

	//GETTERS Y SETTERS
	
	public JButton getBt_ok() {
		return bt_ok;
	}

	public void setBt_ok(JButton bt_ok) {
		this.bt_ok = bt_ok;
	}

	public JLabel getPresion() {
		return presion;
	}

	public void setPresion(JLabel presion) {
		this.presion = presion;
	}

	public JLabel getPulso() {
		return pulso;
	}

	public void setPulso(JLabel pulso) {
		this.pulso = pulso;
	}

	public JLabel getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(JLabel frecuencia) {
		this.frecuencia = frecuencia;
	}

	public JLabel getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(JLabel temperatura) {
		this.temperatura = temperatura;
	}

	public JTextField getTxt_presion() {
		return txt_presion;
	}

	public void setTxt_presion(JTextField txt_presion) {
		this.txt_presion = txt_presion;
	}

	public JTextField getTxt_pulso() {
		return txt_pulso;
	}

	public void setTxt_pulso(JTextField txt_pulso) {
		this.txt_pulso = txt_pulso;
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
	
}
