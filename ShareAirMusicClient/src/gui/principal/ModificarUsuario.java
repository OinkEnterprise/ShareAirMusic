package gui.principal;

import gui.GUI;
import gui.sidebar.MenuUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import persistencia.ContenedorSUSU;
import persistencia.SUsuario;
import persistencia.Usuario;
import cliente.Cliente;

public class ModificarUsuario extends Principal {

	private static final long serialVersionUID = 1L;

	ImageIcon imageIco;
	JLabel imageIcoL = new JLabel("",SwingConstants.CENTER);

	private JLabel usuario = new JLabel();
	private JLabel nombre = new JLabel("Nombre:");
	private JTextField nombreF = new JTextField();
	private JLabel passN = new JLabel("Nueva contraseña:");
	private JPasswordField passNF = new JPasswordField();
	private JLabel passNC = new JLabel("Repita contraseña:");
	private JPasswordField passNFC = new JPasswordField();
	private JLabel image = new JLabel("Imagen:");
	private JButton registrar = new JButton("");
	private JTextField imageF = new JTextField();
	private JButton seleccionar = new JButton("");
	private JLabel error = new JLabel("Error: ");
	
	public ModificarUsuario(){
		super();
		
		imageIco = new ImageIcon(Cliente.su.getUsuario().getImage());
		BufferedImage bi = new BufferedImage(imageIco.getIconWidth(),imageIco.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		imageIco.paintIcon(null, g, 0,0);
		g.dispose();
		imageIcoL.setBounds(GUI.trans(GUI.ratioW,300), GUI.trans(GUI.ratioH,25), GUI.trans(GUI.ratioW,300), GUI.trans(GUI.ratioH,300));
		imageIcoL.setIcon(new ImageIcon(GUI.resize(bi, GUI.trans(GUI.ratioH,250), GUI.trans(GUI.ratioH,250))));
		imageIcoL.setVisible(true);	
		
		int h = GUI.trans(GUI.ratioH,100);
		usuario = new JLabel(Cliente.su.getUsuario().getLogin(),SwingConstants.CENTER);
		usuario.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,80)));
		usuario.setBounds(GUI.trans(GUI.ratioW,500), h, GUI.trans(GUI.ratioW,739), GUI.trans(GUI.ratioH,100));
		usuario.setForeground(new Color(170,170,170));
		usuario.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,220)+14;
		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		nombreF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombreF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		nombreF.setForeground(new Color(170,170,170));
		nombreF.setBackground(new Color(60,60,60));
		nombreF.setText(Cliente.su.getUsuario().getNombre());
		nombreF.setVisible(true);
				
		h+=GUI.trans(GUI.ratioH,100)+14;
		passN.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		passN.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		passN.setForeground(new Color(170,170,170));
		passN.setVisible(true);
		
		passNF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		passNF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		passNF.setForeground(new Color(170,170,170));
		passNF.setBackground(new Color(60,60,60));
		passNF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		passNC.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		passNC.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		passNC.setForeground(new Color(170,170,170));
		passNC.setVisible(true);
		
		passNFC.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		passNFC.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		passNFC.setForeground(new Color(170,170,170));
		passNFC.setBackground(new Color(60,60,60));
		passNFC.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		image.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		image.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		image.setForeground(new Color(170,170,170));
		image.setVisible(true);
		
		imageF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		imageF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		imageF.setForeground(new Color(170,170,170));
		imageF.setBackground(new Color(60,60,60));
		imageF.setVisible(true);
		
		ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		seleccionar = new JButton("Seleccionar",imagen);
		seleccionar.setHorizontalTextPosition(SwingConstants.CENTER);
		seleccionar.setVerticalTextPosition(SwingConstants.CENTER);
		seleccionar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,19)));
		seleccionar.setForeground(new Color(170,170,170));
		seleccionar.setBounds(GUI.trans(GUI.ratioW,1200), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		seleccionar.setOpaque(false);
		seleccionar.setContentAreaFilled(false);
		seleccionar.setBorderPainted(false);
		seleccionar.setVisible(true);
		
		seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes .jpg", "jpg");
            	JFileChooser chooser = new JFileChooser();
            	chooser.setFileFilter(filter);
        	    chooser.showOpenDialog(null);
        	    String path = chooser.getSelectedFile().toPath().toString();
        	    if(path.endsWith(".jpg")){
        	    	imageF.setText(path);
        	    }else{
        	    	error.setText("Imagen debe ser .jpg. ");
        	    	error.setVisible(true);
        	    	imageF.setText("");
        	    }

            }
        });
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		registrar = new JButton("Modificar",imagen);
		registrar.setHorizontalTextPosition(SwingConstants.CENTER);
		registrar.setVerticalTextPosition(SwingConstants.CENTER);
		registrar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,22)));
		registrar.setForeground(new Color(170,170,170));
		registrar.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		registrar.setOpaque(false);
		registrar.setContentAreaFilled(false);
		registrar.setBorderPainted(false);
		registrar.setVisible(true);

		registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
				try {       	
            	
	            	String nombre = nombreF.getText();
	            	String usuario = Cliente.su.getUsuario().getLogin();
	            	String passwordC = Cliente.su.getPassword();
	            	String passwordN = String.valueOf(passNF.getPassword());
	            	String passwordNC = String.valueOf(passNFC.getPassword());
	            	
	            	Usuario u = null;	            	
            		if(!imageF.getText().equals("")){
            			File im = new File(imageF.getText());
            			FileInputStream fileInputStream;
						fileInputStream = new FileInputStream(im);
	        		    byte[] bufferIm = new byte[(int) im.length()];
	        		    fileInputStream.read(bufferIm);
	        		    fileInputStream.close();
	        			u = new Usuario(nombre,bufferIm,usuario);
            		}else{
            			u = new Usuario(nombre,Cliente.su.getUsuario().getImage(),usuario);
            		}
            		
            		//Cambio de la contrasenia
            		SUsuario su = new SUsuario();
            		if(!(passwordN.equals("") || passwordNC.equals(""))){
            			if(passwordN.equals(passwordNC)){
		        			su = new SUsuario(passwordN,u);
            			}else{
            				su = new SUsuario(passwordC,u);
                	    	error.setText("Contraseña nueva erronea.");
                	    	error.setVisible(true);
            			}
            		}else{
        				su = new SUsuario(passwordC,u);
            		}
            		
        			ContenedorSUSU susu = new ContenedorSUSU(Cliente.su, su);
            		if(Cliente.modificarUsuario(susu).equals("false")){
            	    	error.setText("Error en la modificación de usuario.");
            	    	error.setVisible(true);            			
            		}else{       		
            			if(Cliente.conectarUsuario(usuario, passwordC).equals("false")){
            				error.setText("No se ha podido conectar con el servidor.");
                	    	error.setVisible(true);
            			}
            		}
            		
            		GUI.getGui().principal.setVisible(false);
            		GUI.getGui().principal = new Inicio();
            		GUI.getGui().principal.setVisible(true);
            		GUI.getGui().add(GUI.getGui().principal);
            		
            		GUI.getGui().sideBar.setVisible(false);
            		GUI.getGui().sideBar = new MenuUsuario();
            		GUI.getGui().sideBar.setVisible(true);
            		GUI.getGui().add(GUI.getGui().sideBar);
            		GUI.getGui().repaint();
	            		
            		
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
		
		this.add(nombre);	
		this.add(nombreF);		
		this.add(usuario);
		this.add(imageIcoL);	
		this.add(passN);
		this.add(passNF);
		this.add(passNC);
		this.add(passNFC);
		this.add(image);
		this.add(imageF);
		this.add(seleccionar);
		this.add(registrar);
		this.add(error);
	}

}
