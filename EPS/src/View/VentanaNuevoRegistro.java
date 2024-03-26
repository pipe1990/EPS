package View;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaNuevoRegistro extends JFrame{
	
	//ETIQUETA
	private JLabel documento;
	
	//CAMPO DE TEXTO
	private JTextField txt_documento;
	
	//BOTON
	private JButton bt_guardar;
	
	public VentanaNuevoRegistro() {
		//TITULO
		setTitle("EPS");
		
		//TAMAÑO DE LA VENTANA
		setSize(500, 400);
		
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
		
		//CAMPO DE TEXTO DOCUMENTO
		txt_documento = new JTextField();
		txt_documento.setBounds(200, 50, 170, 20);
		add(txt_documento);	
		
		//BOTON GUARDAR NUEVO REGISTRO
		bt_guardar = new JButton("Guardar");
		bt_guardar.setActionCommand("GUARDAR");
		bt_guardar.setBounds(200, 250, 100, 30);
		bt_guardar.setVisible(true);
		add(bt_guardar);		
		
	}

	//GETTERS Y SETTERS
	public JLabel getDocumento() {
		return documento;
	}

	public void setDocumento(JLabel documento) {
		this.documento = documento;
	}

	public JTextField getTxt_documento() {
		return txt_documento;
	}

	public void setTxt_documento(JTextField txt_documento) {
		this.txt_documento = txt_documento;
	}



	public JButton getBt_guardar() {
		return bt_guardar;
	}

	public void setBt_guardar(JButton bt_guardar) {
		this.bt_guardar = bt_guardar;
	}
	
	
}
