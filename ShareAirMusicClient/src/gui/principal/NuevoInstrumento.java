package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import persistencia.ContenedorSUI;
import persistencia.Instrumento;
import persistencia.Sonido;
import cliente.Cliente;

public class NuevoInstrumento extends Principal {

	private static final long serialVersionUID = 1L;

	ImageIcon imageIco;
	JLabel imageIcoL = new JLabel("",SwingConstants.CENTER);

	private JLabel cabecera;
	private JLabel nombre = new JLabel("Nombre:");
	private JTextField nombreF = new JTextField();
	private JLabel tipo = new JLabel("Estilo de música:");
	private JComboBox<String> tipoCB = new JComboBox<String>();
	private JLabel posicion = new JLabel("Posicion:");
	private JComboBox<String> posicionCB = new JComboBox<String>();
	private JLabel sonido1 = new JLabel("Sonido 1º:");
	private JTextField sonido1F = new JTextField();
	private JButton seleccionarS1 = new JButton("");
	private JLabel sonido2 = new JLabel("Sonido 2º:");
	private JTextField sonido2F = new JTextField();
	private JButton seleccionarS2 = new JButton("");
	private JButton aniadir = new JButton("");
	private JLabel error = new JLabel("Error: ");
	
	public NuevoInstrumento(){
		super();
		
		cabecera = new JLabel("Nuevo Instrumento");
		int h = GUI.trans(GUI.ratioH,100);
		cabecera.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,60)));
		cabecera.setBounds(GUI.trans(GUI.ratioW,100), h, GUI.trans(GUI.ratioW,1250), GUI.trans(GUI.ratioH,80));
		cabecera.setForeground(new Color(170,170,170));
		cabecera.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,220)+14;
		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		nombreF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombreF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		nombreF.setForeground(new Color(170,170,170));
		nombreF.setBackground(new Color(60,60,60));
		nombreF.setVisible(true);	
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		tipo.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		tipo.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		tipo.setForeground(new Color(170,170,170));
		tipo.setVisible(true);
		
		tipoCB.addItem("Techno");
		tipoCB.addItem("House");		
		tipoCB.addItem("Electro");		
		tipoCB.addItem("Disco");		
		tipoCB.addItem("DrumNBass");		
		tipoCB.addItem("Real");		
		tipoCB.addItem("Personalizado");		
		tipoCB.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		tipoCB.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		tipoCB.setForeground(new Color(170,170,170));
		tipoCB.setBackground(new Color(60,60,60));
		tipoCB.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		posicion.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		posicion.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		posicion.setForeground(new Color(170,170,170));
		posicion.setVisible(true);
		
		posicionCB.addItem("Abajo");
		posicionCB.addItem("Izquierda");
		posicionCB.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		posicionCB.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		posicionCB.setForeground(new Color(170,170,170));
		posicionCB.setBackground(new Color(60,60,60));
		posicionCB.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		sonido1.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		sonido1.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		sonido1.setForeground(new Color(170,170,170));
		sonido1.setVisible(true);
		
		sonido1F.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		sonido1F.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		sonido1F.setForeground(new Color(170,170,170));
		sonido1F.setBackground(new Color(60,60,60));
		sonido1F.setVisible(true);
		
		ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		seleccionarS1 = new JButton("Seleccionar",imagen);
		seleccionarS1.setHorizontalTextPosition(SwingConstants.CENTER);
		seleccionarS1.setVerticalTextPosition(SwingConstants.CENTER);
		seleccionarS1.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,19)));
		seleccionarS1.setForeground(new Color(170,170,170));
		seleccionarS1.setBounds(GUI.trans(GUI.ratioW,1200), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		seleccionarS1.setOpaque(false);
		seleccionarS1.setContentAreaFilled(false);
		seleccionarS1.setBorderPainted(false);
		seleccionarS1.setVisible(true);
		
		seleccionarS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("Sonidos .wav", "wav");
            	JFileChooser chooser = new JFileChooser();
            	chooser.setFileFilter(filter);
        	    chooser.showOpenDialog(null);
        	    String path = chooser.getSelectedFile().toPath().toString();
        	    if(path.endsWith(".wav")){
        	    	sonido1F.setText(path);
        	    }else{
        	    	error.setText("El sonido debe ser .wav. ");
        	    	error.setVisible(true);
        	    	sonido1F.setText("");
        	    }

            }
        });
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		sonido2.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		sonido2.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		sonido2.setForeground(new Color(170,170,170));
		sonido2.setVisible(true);
		
		sonido2F.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		sonido2F.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		sonido2F.setForeground(new Color(170,170,170));
		sonido2F.setBackground(new Color(60,60,60));
		sonido2F.setVisible(true);
		
		imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		seleccionarS2 = new JButton("Seleccionar",imagen);
		seleccionarS2.setHorizontalTextPosition(SwingConstants.CENTER);
		seleccionarS2.setVerticalTextPosition(SwingConstants.CENTER);
		seleccionarS2.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,19)));
		seleccionarS2.setForeground(new Color(170,170,170));
		seleccionarS2.setBounds(GUI.trans(GUI.ratioW,1200), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		seleccionarS2.setOpaque(false);
		seleccionarS2.setContentAreaFilled(false);
		seleccionarS2.setBorderPainted(false);
		seleccionarS2.setVisible(true);
		
		seleccionarS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("Sonidos .wav", "wav");
            	JFileChooser chooser = new JFileChooser();
            	chooser.setFileFilter(filter);
        	    chooser.showOpenDialog(null);
        	    String path = chooser.getSelectedFile().toPath().toString();
        	    if(path.endsWith(".wav")){
        	    	sonido2F.setText(path);
        	    }else{
        	    	error.setText("El sonido debe ser .wav. ");
        	    	error.setVisible(true);
        	    	sonido2F.setText("");
        	    }

            }
        });
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		aniadir = new JButton("Añadir",imagen);
		aniadir.setHorizontalTextPosition(SwingConstants.CENTER);
		aniadir.setVerticalTextPosition(SwingConstants.CENTER);
		aniadir.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,22)));
		aniadir.setForeground(new Color(170,170,170));
		aniadir.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		aniadir.setOpaque(false);
		aniadir.setContentAreaFilled(false);
		aniadir.setBorderPainted(false);
		aniadir.setVisible(true);

		aniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String nuevo_nombre, tipo, posicion;
            	Sonido s1 = null, s2 = null;
				try {
	            	if(!nombreF.getText().equals("")){
	            		nuevo_nombre = nombreF.getText();
	            		tipo = (String) tipoCB.getSelectedItem();
	            		posicion = (String) posicionCB.getSelectedItem();
	            		if(!sonido1F.getText().equals("")){
	            			File soundFile = new File(sonido1F.getText());
	            			AudioInputStream is;
	            			is = AudioSystem.getAudioInputStream(soundFile);	
	            			s1 = new Sonido(is, (int) soundFile.length());
	            			
	            			if(!sonido2F.getText().equals("")){
		            			soundFile = new File(sonido2F.getText());
		            			is = AudioSystem.getAudioInputStream(soundFile);	
		            			s2 = new Sonido(is, (int) soundFile.length());
		            			
			            		Instrumento i2 = new Instrumento(nuevo_nombre, tipo, posicion, s1, s2, Cliente.su.getUsuario());
			        			ContenedorSUI sui = new ContenedorSUI(Cliente.su,i2);
			        			Cliente.aniadirInstrumento(sui);  
			        			
			                	GUI.getGui().principal.setVisible(false);
			                	GUI.getGui().principal = new InstrumentosUser();
			                	GUI.getGui().principal.setVisible(true);
			                	GUI.getGui().add(GUI.getGui().principal);
			                	GUI.getGui().repaint();
		                	}else{
			        	    	error.setText("Seleccione sonido 2");
			        	    	error.setVisible(true);
			        	    	sonido2F.setText("");
		            		}
	            		}else{
		        	    	error.setText("Seleccione sonido 1");
		        	    	error.setVisible(true);
		        	    	sonido1F.setText("");
	            		}	
	            	}else{
	        	    	error.setText("Introduzca un nombre para el instrumento");
	        	    	error.setVisible(true);
	            	}
            	
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		h+=GUI.trans(GUI.ratioH,57)+5;
		error.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,20)));
		error.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,350), GUI.trans(GUI.ratioH,25));
		error.setForeground(new Color(200,0,0));
		error.setVisible(false);
		
		this.add(cabecera);	
		this.add(nombre);	
		this.add(nombreF);	
		this.add(tipo);	
		this.add(tipoCB);
		this.add(posicion);	
		this.add(posicionCB);
		this.add(sonido1);	
		this.add(sonido1F);	
		this.add(seleccionarS1);	
		this.add(sonido2);	
		this.add(sonido2F);	
		this.add(seleccionarS2);
		this.add(aniadir);
		this.add(error);

	}

}
