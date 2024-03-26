package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;


public class VentanaPrincipal extends JFrame {
	
	//BOTONES
	private JButton btingresar, btpaciente;

	
	public VentanaPrincipal() {
		//TITULO
		setTitle("Bienvenidos");
		
		//TAMAÑO DE LA VENTANA
		setSize(500, 100);
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(176, 216, 230)); 
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	
	}
	
	//CREAR LOS ELEMENTOS DE LA VENTANA
	public void inicializarComponentes() {
		
		//BOTON INGRESAR UN NUEVO REGISTRO
		btingresar = new JButton("Ingresar Nuevo Registro");
		btingresar.setActionCommand("INGRESAR");
		btingresar.setBounds(20, 20, 200, 30);
		btingresar.setVisible(true);
		add(btingresar);
		
		//BOTON INGRESAR UN PACIENTE
		btpaciente = new JButton("Ingresar Paciente");
		btpaciente.setActionCommand("PACIENTE");
		btpaciente.setBounds(250, 20, 200, 30);
		btpaciente.setVisible(true);
		add(btpaciente);
		
	}

	//GETTERS Y SETTERS
	public JButton getBtingresar() {
		return btingresar;
	}

	public void setBtingresar(JButton btingresar) {
		this.btingresar = btingresar;
	}

	public JButton getBtpaciente() {
		return btpaciente;
	}

	public void setBtpaciente(JButton btpaciente) {
		this.btpaciente = btpaciente;
	}

	
	
	
	
}
