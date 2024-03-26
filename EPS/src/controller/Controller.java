package controller;

//IMPORTS
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.pixelmed.display.SourceImage;

import View.VentanaDoctor;
import View.VentanaEmergente;
import View.VentanaEspecialista;
import View.VentanaIngresar;
import View.VentanaModificar;
import View.VentanaNuevoRegistro;
import View.VentanaPrincipal;
import View.VentanaTriage;

public class Controller implements ActionListener{	

	//CONEXCIÓN A LA BASE DE DATOS DE POSGRESQL
	//URL DE LA DIRECCION DEL PROYECTO EN POSGRESQL
	public static final String URL = "jdbc:postgresql://localhost/Proyecto";
	//CREDENCIALES
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "";
	
	//DECLARACION PARA LA BASE DE DATOS
	PreparedStatement ps;
	//RESULTADO DE LA BASE DE DATOS
	ResultSet rs;
	
	//STREAM DE DATOS DEL ARCHVIO
	FileInputStream fis;
	
	//VENTANA NUEVO REGISTRO
	private VentanaNuevoRegistro vne;
	
	//VENTANA PRINCIPAL
	private VentanaPrincipal vp;
	
	//VENTANA INGRESAR PACIENTE
	private VentanaIngresar vi;
	
	//VENTANA EMERGENTE PARA MODIFICAR O CONTINUAR CON EL TRIAGE
	private VentanaEmergente ve;
	
	//VENTANA TRIAGE
	private VentanaTriage vt;
	
	//VENTANA MODIFICAR DATOS
	private VentanaModificar vm;
	
	//VENTANA DOCTOR 
	private VentanaDoctor vd;
	
	// VENTANA ESPECIALISTA
	private VentanaEspecialista ves;
	
	//FECHA PARA GUARDAR LOS EXAMENES
	private Date date;

	byte[] pixeldata;
	int longitudBytes;

	
	//CONSTRUCTOR
	public Controller() {
		vp = new VentanaPrincipal();
		vne = new VentanaNuevoRegistro();
		vi = new VentanaIngresar();
		ve = new VentanaEmergente();
		vm = new VentanaModificar();
		vt = new VentanaTriage();
		vd = new VentanaDoctor();
		ves = new VentanaEspecialista();
		date = new Date();
		initComponentes();
	}
	
	//INICIALIZANDO COMPNENTES
	private void initComponentes() {
		//VENTANA PRINCIPAL
		//BOTON INGRESAR NUEVO REGISTROS
		vp.getBtingresar().addActionListener(this);
		//BOTON INGRESAR PACIENTO
		vp.getBtpaciente().addActionListener(this);
		
		//VENTANA NUEVO REGISTRO
		//BOTON GUARDAR
		vne.getBt_guardar().addActionListener(this);
		
		//VENTANA EMERGENTE
		//CONTINUAR AL TRIAGE
		ve.getContinuar().addActionListener(this);
		//MODIFICAR ALGUN DATO
		ve.getModificar().addActionListener(this);
		
		
		//VENTANA INGRESA
		//BOTON LISTO
		vi.getBt_listo().addActionListener(this);
		
		//VENTANA MODIFICAR
		//BOTON MODIFICAR ALGUN DATO
		vm.getBt_modificar().addActionListener(this);
		
		//VENTANA TRIAGE
		//BOTON LISTO
		vt.getBt_ok().addActionListener(this);
		
		//VENTANA DOCTOR
		//BOTON DE SALIR
		vd.getBt_salir().addActionListener(this);
		//BOTON CONTINUAR CON EL ESPECIALISTA
		vd.getBt_especialista().addActionListener(this);
		//BOTON PARA BUSCAR UNA IMAGEN
		vd.getBt_buscar_imagen().addActionListener(this);
		//BOTON PARA GUARDAR IMAGEN
		vd.getBt_guardar_imagen().addActionListener(this);
		
		//VENTANA ESPECIALISTA
		//BOTON DE SALIR
		ves.getBt_salir().addActionListener(this);
		//BOTON DE BUSCAR IMAGEN
		ves.getBt_buscar_imagen().addActionListener(this);
		//BOTON PARA GUARGAR IMAGEN
		ves.getBt_guardar_imagen().addActionListener(this);
		//BOTON PARA ENVIAR EL EXAMEN
		ves.getBt_enviar().addActionListener(this);
		//BOTON PARA ACTUALIZAR DIAGNOSTICO
		ves.getBt_actualizar_diagnostico().addActionListener(this);
	}

	
	//CUANDO SE PRESIONE UN BOTON
	public void actionPerformed(ActionEvent e) {
		
		//CUANDO SE INGRESA SE MUESTRA LA VENTANA DE NUEVO REGISTRO
		if((e.getActionCommand().equals("INGRESAR"))) {
			 vp.setVisible(false);
			 vne.setVisible(true);		 
		}
		
		//SALIR
		if((e.getActionCommand().equals("SALIR2"))) {
			 System.exit(0);
		}
		
		
		//SE MUESTRA LA VENTANA DE INGRESAR UN PACIENTE
		if((e.getActionCommand().equals("PACIENTE"))) {
			 vp.setVisible(false);
			 vi.setVisible(true);
		}
		
		//CONTINUAR A LA VENTANA TRIAGE
		if((e.getActionCommand().equals("CONTINUAR"))) {
			 vi.setVisible(false);
			 ve.setVisible(false);
			 vt.setVisible(true);
		}
		
		//EXAINAR UN ARCHIVO EN LA VENTANA DOCTOR Y LA VENTANA ESPECIALISTA
		if((e.getActionCommand().equals("EXAMINAR2"))) {
			JFileChooser j=new JFileChooser();
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "dcm");
	        j.setFileFilter(filter);
	    
	        int estado=j.showOpenDialog(null);
	        if(estado== JFileChooser.APPROVE_OPTION){
	            try{
	                fis=new FileInputStream(j.getSelectedFile());
	            
	                this.longitudBytes=(int)j.getSelectedFile().length();
	               
	                File selectedFile = j.getSelectedFile();
	                
	                String filePath = selectedFile.getAbsolutePath();
	                              
	                try {
	    	            SourceImage sImg = new SourceImage(filePath); 
	    	            ImageIcon icon = new ImageIcon(sImg.getBufferedImage());
	    	            JFrame frame = new JFrame();
	    	            frame.getContentPane().add(new JLabel(icon));
	    	            frame.pack();
	    	            frame.setVisible(true);
	    	        } catch (Exception d) {
	    	            d.printStackTrace();
	    	        }
	                
	            }catch(IOException ex){
	                ex.printStackTrace();
	            } 
	        }      
			 
		}
		
		//SE GUARDA LA IMAGEN EN LA TABLA IMAGENES
		if((e.getActionCommand().equals("GIMAGEN2"))) {
			Connection con = null;		
			try {
						       
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                pixeldata = baos.toByteArray();
                System.out.println(fis);
                System.out.println(pixeldata);
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO imagenes (numero_documento, imagen) VALUES(?,?)");
				ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
				ps.setBytes(2, pixeldata);
									
				int res = ps.executeUpdate();
				
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Imagen Guardada");				
					
				}else {
					JOptionPane.showMessageDialog(null, "Error al guardar imagen");
				
				}
				
				con.close();
				
			}catch(Exception d) {
			
			JOptionPane.showMessageDialog(null, "No se puede guardar.");
			}
		}
		
			
		//SE ACTUALIZA EL DIAGNOSTICO EN LA VETNANA ESPECILISTA
		if(e.getActionCommand().equals("ACTUALIZARDIAGNOSTICO")) {
			Connection con = null;	
			try {
				con = getConnection();
				 ps =  con.prepareStatement("SELECT id_consulta FROM consulta ORDER BY id_consulta DESC LIMIT 1");	 
				 rs = ps.executeQuery();
				 
				 if(rs.next()) {
					 
					 try {
							con = getConnection();
							 ps =  con.prepareStatement("UPDATE consulta SET diagnostico_consulta=? WHERE numero_documento=? and id_consulta=?");
								ps.setString(1, ves.getTxt_diagnostico().getText());
								ps.setInt(2, Integer.parseInt(vi.getTxt_ingresar().getText()));
								ps.setInt(3, Integer.parseInt(rs.getString("id_consulta")));
										 
										
							int res = ps.executeUpdate();
							
							if(res > 0) {
								JOptionPane.showMessageDialog(null, "Diagnostico Modificado");
							
							}else {
								JOptionPane.showMessageDialog(null, "Error al modificar diagnostico");
								
							}
							
							con.close();
							
						 }catch(Exception d) {
							System.err.println(d);
						}
					 
					 	
				 }else {
					 JOptionPane.showMessageDialog(null, "Error");
					 
				 }
				 
			}catch(Exception d) {
				System.err.println(d);
			}	
		}
			
		
		//SE ENVIA EL EXAMEN EN LA VENTANA ESPECIALISTA
		if((e.getActionCommand().equals("ENVIAR"))) {
			Connection con = null;
			
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
             String strDate = dateFormat.format(date);  
			
			try {
				con = getConnection();
				 ps =  con.prepareStatement("SELECT id_consulta FROM consulta ORDER BY id_consulta DESC LIMIT 1");	 
				 rs = ps.executeQuery();
				 
				 if(rs.next()) {
					 
					 try {
							con = getConnection();
							ps = con.prepareStatement("INSERT INTO examen (id_consulta, numero_documento, examen, fecha) VALUES(?,?,?,?)");
							ps.setInt(1, Integer.parseInt(rs.getString("id_consulta")));
							ps.setInt(2, Integer.parseInt(vi.getTxt_ingresar().getText()));
							ps.setString(3, ves.getCbx_tipo_imagen().getSelectedItem().toString());
							ps.setString(4, strDate);
							
										
							if(ves.getCbx_tipo_imagen().getSelectedItem().toString() == "--Seleccione--") {
								JOptionPane.showMessageDialog(null, "Escoja un examen.");
								
							}else {
								int res = ps.executeUpdate();
								 
								if(res > 0) {							
									JOptionPane.showMessageDialog(null, "Examen Enviado.");
									 System.exit(0);
									
								}else {
									JOptionPane.showMessageDialog(null, "Error al enviar examen.");
								}
								
								con.close();
							}			
							}catch(Exception d) {
						
								JOptionPane.showMessageDialog(null, "No se puede enviar el examen.");
							}		 	
				 }else {
					 JOptionPane.showMessageDialog(null, "Error");
					 
				 }		 
			}catch(Exception d) {
				System.err.println(d);
			}
			
		}
		
		//DESDE LA VENTANA DOCTOR SE REMITE A LA PERSONA AL ESPECIALISTA Y GUARDA LA CONSULTA
		if((e.getActionCommand().equals("REMITIR"))) {
			Connection con = null;
		
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO consulta (numero_documento, presion, pulso, frecuencia, temperatura, sintomas_consulta, diagnostico_consulta, especialista) VALUES(?,?,?,?,?,?,?,?)");
				ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
				ps.setString(2, vd.getTxt_presion().getText());
				ps.setString(3, vd.getTxt_pulso().getText());
				ps.setString(4, vd.getTxt_frecuencia().getText());
				ps.setString(5, vd.getTxt_temperatura().getText());
				ps.setString(6, vd.getTxt_sintomas().getText());
				ps.setString(7, vd.getTxt_diagnostico().getText());
				ps.setString(8, vd.getCbx_tipo_especialista().getSelectedItem().toString());
							
				if(vd.getCbx_tipo_especialista().getSelectedItem().toString() == "--Seleccione--") {
					JOptionPane.showMessageDialog(null, "Escoja un especialista.");
				}else {
					int res = ps.executeUpdate();
					 
					if(res > 0) {
						JOptionPane.showMessageDialog(null, "Consulta Guardada");
						 vd.setVisible(false);
						 ves.setVisible(true);
						 
							try {
								con = getConnection();
								 ps =  con.prepareStatement("SELECT nombres, apellidos FROM persona_gobierno INNER JOIN eps ON persona_gobierno.numero_documento  = eps.numero_documento where persona_gobierno.numero_documento=?");
								 ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
								 
								 rs = ps.executeQuery();
								 
								 if(rs.next()) {
									 String nombres =  rs.getString("nombres");
									 String apellidos = rs.getString("apellidos");
									 ves.getTxt_nombre().setText(nombres + " " + apellidos);
									 
								 }else {
									 JOptionPane.showMessageDialog(null, "No existe una una persona con ese id");
									 limpiarCajas();
								 }
								 
							}catch(Exception d) {
								System.err.println(d);
							}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al guardar consulta");
						limpiarCajas();
					}
					
					con.close();
				}		
				}catch(Exception d) {
			
					JOptionPane.showMessageDialog(null, "No se puede guardar.");
				}	
		}
		
		//DESDE LA VENTANA DOCTOR SE SALE  Y GUARDA LA CONSULTA
		if((e.getActionCommand().equals("SALIR"))) {
			Connection con = null;
			
			try {
				con = getConnection();
				ps = con.prepareStatement("INSERT INTO consulta (numero_documento, presion, pulso, frecuencia, temperatura, sintomas_consulta, diagnostico_consulta, especialista) VALUES(?,?,?,?,?,?,?,?)");
				ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
				ps.setString(2, vd.getTxt_presion().getText());
				ps.setString(3, vd.getTxt_pulso().getText());
				ps.setString(4, vd.getTxt_frecuencia().getText());
				ps.setString(5, vd.getTxt_temperatura().getText());
				ps.setString(6, vd.getTxt_sintomas().getText());
				ps.setString(7, vd.getTxt_diagnostico().getText());
				ps.setString(8, "NO");
							
				int res = ps.executeUpdate();
				
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Consulta Guardada");
					 System.exit(0);
						
				}else {
					JOptionPane.showMessageDialog(null, "Error al guardar consulta");
					limpiarCajas();
				}
				
				con.close();
				
			}catch(Exception d) {
			
			JOptionPane.showMessageDialog(null, "No se puede guardar.");
			}
			 
		}
		
		//LOGICA PARA VER QUE TIPO DE TRIAGE SE VA A ASIGNAR A LA PERSONA
		if((e.getActionCommand().equals("OK"))) {
			 
			if(isNumeric(vt.getTxt_presion().getText()) && isNumeric(vt.getTxt_pulso().getText()) && isNumeric(vt.getTxt_frecuencia().getText()) && isNumeric(vt.getTxt_temperatura().getText())) {
				int presion = Integer.parseInt(vt.getTxt_presion().getText()); 
				int pulso = Integer.parseInt(vt.getTxt_pulso().getText()) ;
				int frecuencia = Integer.parseInt(vt.getTxt_frecuencia().getText());
				int temperatura = Integer.parseInt(vt.getTxt_temperatura().getText());
				
				if((presion < 80 || presion > 200) && (pulso < 50 || pulso > 150) && (frecuencia < 10 || frecuencia > 30) && (temperatura < 35 || temperatura > 41)) {
					
					JOptionPane.showMessageDialog(null, "TRIAGE 1 - ATENCION INMEDIATA");
					JOptionPane.showMessageDialog(null, "SERA ASIGNADO A UN DOCTOR INMEDIATAMENTE");
					vt.setVisible(false);
					vd.setVisible(true);
					Connection con = null;
					
					try {
						con = getConnection();
						 ps =  con.prepareStatement("SELECT nombres, apellidos, consultas FROM persona_gobierno INNER JOIN eps ON persona_gobierno.numero_documento  = eps.numero_documento WHERE persona_gobierno.numero_documento = ?");
						 ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
						 
						 rs = ps.executeQuery();
						 
						 if(rs.next()) {
							 int consult = 0;
							 consult = Integer.parseInt(rs.getString("consultas"));
							 vd.getTxt_consultas().setText(rs.getString("consultas"));
							 String nombres =  rs.getString("nombres");
							 String apellidos = rs.getString("apellidos");
							 vd.getTxt_nombre().setText(nombres + " " + apellidos);				
							 
							 try {
								 	con = getConnection();
									ps = con.prepareStatement("UPDATE eps SET consultas=? WHERE numero_documento=?");
									int consult2 = 1 + consult;
									ps.setInt(1,consult2);
									ps.setInt(2, Integer.parseInt(vi.getTxt_ingresar().getText()));
												
									int res = ps.executeUpdate();
				
									if(res > 0) {		
								
									}else {
										
									}
									con.close();
									
								 }catch(Exception d) {
									System.err.println(d);
								}
							 
						 }else {
							 JOptionPane.showMessageDialog(null, "No existe una una persona con ese id");
							 limpiarCajas();
						 }
						 
					}catch(Exception d) {
						System.err.println(d);
					}
				 
					
				}else if((presion < 100 || presion > 180) && (pulso < 60 || pulso > 140) && (frecuencia < 12 || frecuencia > 28) && (temperatura < 35 || temperatura > 40)) {
					JOptionPane.showMessageDialog(null, "TRIAGE 2 - ATENCION EN MENOS DE 30 MINS");
					JOptionPane.showMessageDialog(null, "SERA ASIGNADO A EN UN MOMENTO");
					vt.setVisible(false);
					vd.setVisible(true);
					
					Connection con = null;
					
					try {
						con = getConnection();
						 ps =  con.prepareStatement("SELECT nombres, apellidos, consultas FROM persona_gobierno INNER JOIN eps ON persona_gobierno.numero_documento  = eps.numero_documento WHERE persona_gobierno.numero_documento = ?");
						 ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
						 
						 rs = ps.executeQuery();
						 
						 if(rs.next()) {
							 int consult = 0;
							 consult = Integer.parseInt(rs.getString("consultas"));
							 vd.getTxt_consultas().setText(rs.getString("consultas"));
							 String nombres =  rs.getString("nombres");
							 String apellidos = rs.getString("apellidos");
							 vd.getTxt_nombre().setText(nombres + " " + apellidos);					
							 
							 try {
								 	con = getConnection();
									ps = con.prepareStatement("UPDATE eps SET consultas=? WHERE numero_documento=?");
									int consult2 = 1 + consult;
									ps.setInt(1,consult2);
									ps.setInt(2, Integer.parseInt(vi.getTxt_ingresar().getText()));
												
									int res = ps.executeUpdate();
				
									if(res > 0) {		
								
									}else {
										
									}
									con.close();
									
								 }catch(Exception d) {
									System.err.println(d);
								}
			
						 }else {
							 JOptionPane.showMessageDialog(null, "No existe una una persona con ese id");
							 limpiarCajas();
						 }
						 
					}catch(Exception d) {
						System.err.println(d);
					}
					
				}else if((presion < 120 || presion > 160) && (pulso < 80 || pulso > 120) && (frecuencia < 14 || frecuencia > 26) && (temperatura < 35 || temperatura > 39)) {
					JOptionPane.showMessageDialog(null, "TRIAGE 3 - NO URGENCIA, ATENCION EN 120 MINS ");
					JOptionPane.showMessageDialog(null, "SERA ASIGNADO A EN UN MOMENTO");
					vt.setVisible(false);
					vd.setVisible(true);
					Connection con = null;
					
					try {
						con = getConnection();
						 ps =  con.prepareStatement("SELECT nombres, apellidos, consultas FROM persona_gobierno INNER JOIN eps ON persona_gobierno.numero_documento  = eps.numero_documento WHERE persona_gobierno.numero_documento = ?");
						 ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
						 
						 rs = ps.executeQuery();
						 
						 if(rs.next()) {
							 int consult = 0;
							 consult = Integer.parseInt(rs.getString("consultas"));
							 vd.getTxt_consultas().setText(rs.getString("consultas"));
							 String nombres =  rs.getString("nombres");
							 String apellidos = rs.getString("apellidos");
							 vd.getTxt_nombre().setText(nombres + " " + apellidos);
					
							 
							 try {
								 	con = getConnection();
									ps = con.prepareStatement("UPDATE eps SET consultas=? WHERE numero_documento=?");
									int consult2 = 1 + consult;
									ps.setInt(1,consult2);
									ps.setInt(2, Integer.parseInt(vi.getTxt_ingresar().getText()));
												
									int res = ps.executeUpdate();
				
									if(res > 0) {		
								
									}else {
										
									}
									con.close();
									
								 }catch(Exception d) {
									System.err.println(d);
								}
			
						 }else {
							 JOptionPane.showMessageDialog(null, "No existe una una persona con ese id");
							 limpiarCajas();
						 }
						 
					}catch(Exception d) {
						System.err.println(d);
					}
					
				}else if((presion < 130 || presion > 150) && (pulso < 90 || pulso > 110) && (frecuencia < 16 || frecuencia > 22) && (temperatura < 36 || temperatura > 38)) {
					JOptionPane.showMessageDialog(null, "TRIAGE 4 - CONSULTA PRIORITARIA");
					JOptionPane.showMessageDialog(null, "NECESITA SACAR CITA");

				}else if((presion <=140  || presion >= 140) && (pulso <= 100 || pulso >= 100) && (frecuencia <= 20 || frecuencia >= 20) && (temperatura <= 37 || temperatura >= 37)) {
					JOptionPane.showMessageDialog(null, "TRIAGE 5 - CONSULTA EXTERNA");
					JOptionPane.showMessageDialog(null, "NECESITA SACAR CITA");
				}
				
					
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
			}
		}
		
		//SE PASA A LA VENTANA MODIFICAR 
				if((e.getActionCommand().equals("MODIFICAR"))) {
					 vi.setVisible(false);
					 ve.setVisible(false);
					 vm.setVisible(true);
					 
					 Connection con = null;
						
						try {
							con = getConnection();
							 ps =  con.prepareStatement("SELECT * FROM persona_gobierno WHERE numero_documento = ?");
							 ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
							 
							 rs = ps.executeQuery();
							 
							 if(rs.next()) {
								 vm.getTxt_documento().setText(rs.getString("numero_documento"));
								 String nombres =  rs.getString("nombres");
								 String apellidos = rs.getString("apellidos");
								 vm.getTxt_nombre().setText(nombres + " " + apellidos);
								 vm.getTxt_salario().setText(rs.getString("tel_celular"));
								 vm.getTxt_correo().setText(rs.getString("direccion"));
								 vm.getTxt_eps().setText(rs.getString("eps"));

								 
							 }else {
								 JOptionPane.showMessageDialog(null, "No existe una una persona con ese id");
								 limpiarCajas();
							 }
							 
						}catch(Exception d) {
							System.err.println(d);
						}
					 
				}
				
		//SE MODIFICA UN DATO DE LA PERSONA
		if((e.getActionCommand().equals("MODIFICAR2"))) {
			Connection con = null;
			
			try {
				con = getConnection();
				ps = con.prepareStatement("UPDATE persona_gobierno SET tel_celular=?, direccion=? WHERE numero_documento=?");
				ps.setString(1, vm.getTxt_salario().getText());
				ps.setString(2, vm.getTxt_correo().getText());
				ps.setInt(3, Integer.parseInt(vm.getTxt_documento().getText()));		
							
				int res = ps.executeUpdate();
				
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Persona Modificada");
					vm.setVisible(false);
					vt.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Error al modificar persona");
					limpiarCajas();
				}
				
				con.close();
				
			 }catch(Exception d) {
				System.err.println(d);
			}
		}
		
		//VENTANA PARA INGRESAR PACIENTE Y VALIDAR SI ESTA EN LA BASE DE DATOS
		if((e.getActionCommand().equals("LISTO"))) {	
	 		Connection con = null;
			
			try {
				con = getConnection();
				ps = con.prepareStatement("SELECT * FROM eps WHERE numero_documento = ?");
				ps.setInt(1, Integer.parseInt(vi.getTxt_ingresar().getText()));
					
				rs = ps.executeQuery();
				 
				 if(rs.next()) {
					 ve.setVisible(true);
			
				}else {
					JOptionPane.showMessageDialog(null, "No existe una una persona con esa cedula");
					limpiarCajas();
				}				
				con.close();
				
			}catch(Exception d) {
			
			JOptionPane.showMessageDialog(null, "No se puede guardar.");
			}		
		}
		
		//SE GUARDA UNA PERSONA NUEVA EN LA BASE DE DATOS DE LA EPS
		if((e.getActionCommand().equals("GUARDAR"))) {
	 		Connection con = null;
	 		int consultas = 0;
	 		
	 		try {
				con = getConnection();
				ps = con.prepareStatement("SELECT eps FROM persona_gobierno WHERE numero_documento = ?");
				ps.setInt(1, Integer.parseInt(vne.getTxt_documento().getText()));
				
				
				rs = ps.executeQuery();
				
				 
				 if(rs.next()) {
					String hola = rs.getString("eps");
				
					 try {
							con = getConnection();
							ps = con.prepareStatement("INSERT INTO eps (numero_documento, consultas, eps) VALUES(?,?,?)");
							ps.setInt(1, Integer.parseInt(vne.getTxt_documento().getText()));
							ps.setInt(2, consultas);
							ps.setString(3, hola);
						
										
							int res = ps.executeUpdate();
							
							if(res > 0) {
								JOptionPane.showMessageDialog(null, "Persona Guardada");
								limpiarCajas();
								vne.setVisible(false);
								vp.setVisible(true);
																
							}else {
								JOptionPane.showMessageDialog(null, "Error al guardar persona");
								limpiarCajas();
							}						
							con.close();
							
						}catch(Exception d) {
						
						JOptionPane.showMessageDialog(null, "No se puede guardar.");
						}			
					
				}else {
					JOptionPane.showMessageDialog(null, "No existe una una persona con esa cedula");
					limpiarCajas();
				}
				
				con.close();
				
			}catch(Exception d) {
			
			JOptionPane.showMessageDialog(null, "No se puede guardar.");
			}	
		}
		
		
		if((e.getActionCommand().equals("LIMPIAR"))) {
			 limpiarCajas();
		}
		
	}

	//METODO PARA LIMPIAR CAJAS
	private void limpiarCajas() {		
		vne.getTxt_documento().setText(null);
		
	}
	
	//METODO PARA SABER SU UN STRING ES NUMERICO
	public static boolean isNumeric(String str) { 
	    try {  
	      Double.parseDouble(str);  
	      return true;
	    } catch(NumberFormatException e){  
	      return false;  
	    }  
	  }
	
	//METODO PARA CONECTARSE A LA BASE DE DATOS
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//JOptionPane.showMessageDialog(null, "Conexion exitosa");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return con;	
	}
	
}
