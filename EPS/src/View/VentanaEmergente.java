package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEmergente extends JFrame {
	//ETIQUETAS
	private JLabel mensaje;
	
	//BOTONES
	private JButton continuar, modificar;
	
	public VentanaEmergente() {
		
		setTitle("");
		
		//TAMAÑO DE LA VENTANA
		setSize(350, 200);
		getContentPane().setLayout(null);
			
		elementos();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);	
	}
	
	//CREAR LOS ELEMENTOS DE LA VENTANA
	public void elementos(){
		
		//ETIQUETA MENSAJE
		mensaje = new JLabel("¿Desea modificar algun dato o continuar al triage?");
		mensaje.setBounds(15, 30, 345, 20);
		add(mensaje);
		
		//BOTON MODIFICAR UN DATO DE LA PERSONA
		modificar = new JButton("Modificar");
		modificar.setActionCommand("MODIFICAR");
		modificar.setBounds(40, 70, 100, 30);
		modificar.setVisible(true);
		add(modificar);
		
		//BOTON  ONTINUAR CON LA PERSONA
		continuar = new JButton("Continuar");
		continuar.setActionCommand("CONTINUAR");
		continuar.setBounds(200, 70, 100, 30);
		continuar.setVisible(true);
		add(continuar);
		
	}

	//GETTERS Y SETTERS
	
	public JLabel getMensaje() {
		return mensaje;
	}

	public void setMensaje(JLabel mensaje) {
		this.mensaje = mensaje;
	}

	public JButton getContinuar() {
		return continuar;
	}

	public void setContinuar(JButton continuar) {
		this.continuar = continuar;
	}

	public JButton getModificar() {
		return modificar;
	}

	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}
	
}

