package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaIngresar extends JFrame{
	
	//BOTON
	private JButton bt_listo;
	
	//ETIQUETA
	private JLabel ingresar;
	
	//CAMPO DE TEXT0
	private JTextField txt_ingresar;
	
	public VentanaIngresar() {
		
		//TITULO
		setTitle("Ingresar Paciente");
		
		//TAMAÑO DE LA VENTANA
		setSize(400, 250);
		
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
		
		//ETIQUETA INGRESAR DOCUMENTO
		ingresar = new JLabel("Ingresar Documento:");
		ingresar.setBounds(30, 50, 140, 20);
		add(ingresar);
		
		//CAMPO DE TEXTO INGRESAR
		txt_ingresar = new JTextField();
		txt_ingresar.setBounds(170, 50, 170, 20);
		add(txt_ingresar);
		
		//BOTON LISTO
		bt_listo = new JButton("Listo");
		bt_listo.setActionCommand("LISTO");
		bt_listo.setBounds(150, 100, 100, 30);
		bt_listo.setVisible(true);
		add(bt_listo);
		
	}

	//GETTERS Y SETTERS
	
	public JButton getBt_listo() {
		return bt_listo;
	}

	public void setBt_listo(JButton bt_listo) {
		this.bt_listo = bt_listo;
	}

	public JTextField getTxt_ingresar() {
		return txt_ingresar;
	}

	public void setTxt_ingresar(JTextField txt_ingresar) {
		this.txt_ingresar = txt_ingresar;
	}
	
	

}
