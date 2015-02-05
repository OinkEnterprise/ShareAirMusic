package gui.sidebar;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;
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

import persistencia.SUsuario;
import persistencia.Usuario;
import cliente.Cliente;

public class RegistrarUsuario extends SideBar {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel nombre = new JLabel("Nombre:");
	private JTextField nombreF = new JTextField();
	private JLabel usuario = new JLabel("Usuario:");
	private JTextField usuarioF = new JTextField();
	private JLabel pass = new JLabel("Contraseña:");
	private JPasswordField passF = new JPasswordField();
	private JPasswordField passFC = new JPasswordField();
	private JLabel image = new JLabel("Imagen:");
	private JButton registrar = new JButton("");
	private JTextField imageF = new JTextField();
	private JButton seleccionar = new JButton("");
	private JLabel error = new JLabel("Error: ");
	
	public RegistrarUsuario(){
		super();
		
		int h = GUI.trans(GUI.ratioH,194);
		
		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,24));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		h+=5+GUI.trans(GUI.ratioH,24);
		nombreF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombreF.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,57));
		nombreF.setForeground(new Color(170,170,170));
		nombreF.setBackground(new Color(35,35,35));
		nombreF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,57)+14;
		usuario.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		usuario.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,24));
		usuario.setForeground(new Color(170,170,170));
		usuario.setVisible(true);
		
		h+=5+GUI.trans(GUI.ratioH,24);
		usuarioF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		usuarioF.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,57));
		usuarioF.setForeground(new Color(170,170,170));
		usuarioF.setBackground(new Color(35,35,35));
		usuarioF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,57)+14;
		pass.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		pass.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,24));
		pass.setForeground(new Color(170,170,170));
		pass.setVisible(true);
		
		h+=5+GUI.trans(GUI.ratioH,24);
		passF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		passF.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,57));
		passF.setForeground(new Color(170,170,170));
		passF.setBackground(new Color(35,35,35));
		passF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,57)+14;
		passFC.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		passFC.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,57));
		passFC.setForeground(new Color(170,170,170));
		passFC.setBackground(new Color(35,35,35));
		passFC.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,57)+14;
		image.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		image.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,35));
		image.setForeground(new Color(170,170,170));
		image.setVisible(true);
		
		h+=10+GUI.trans(GUI.ratioH,24);
		imageF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		imageF.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,200), GUI.trans(GUI.ratioH,57));
		imageF.setForeground(new Color(170,170,170));
		imageF.setBackground(new Color(35,35,35));
		imageF.setVisible(true);
		
		
		//h+=GUI.trans(GUI.ratioH,57)+14;
		ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		seleccionar = new JButton("Seleccionar",imagen);
		seleccionar.setHorizontalTextPosition(SwingConstants.CENTER);
		seleccionar.setVerticalTextPosition(SwingConstants.CENTER);
		seleccionar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,19)));
		seleccionar.setForeground(new Color(170,170,170));
		seleccionar.setBounds(GUI.trans(GUI.ratioW,250), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
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
		registrar = new JButton("Registrar",imagen);
		registrar.setHorizontalTextPosition(SwingConstants.CENTER);
		registrar.setVerticalTextPosition(SwingConstants.CENTER);
		registrar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,22)));
		registrar.setForeground(new Color(170,170,170));
		registrar.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		registrar.setOpaque(false);
		registrar.setContentAreaFilled(false);
		registrar.setBorderPainted(false);
		registrar.setVisible(true);

		registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String nombre = nombreF.getText();
            	String usuario = usuarioF.getText();
            	String password = String.valueOf(passF.getPassword());
            	String passwordC = String.valueOf(passFC.getPassword());
            	
            	if (password.equals(passwordC) && imageF.getText() != null){
            		File im = new File(imageF.getText());
        			FileInputStream fileInputStream;
					try {
						fileInputStream = new FileInputStream(im);
	        		    byte[] bufferIm = new byte[(int) im.length()];
	        		    fileInputStream.read(bufferIm);
	        		    fileInputStream.close();
	        			Usuario u = new Usuario(nombre,bufferIm,usuario);
	        			SUsuario su = new SUsuario(password,u);
	        			if(Cliente.registrarUsuario(su).equals("false")){
	            	    	error.setText(error.getText()+"Usuario existente. ");
	            	    	error.setVisible(true);
	        			}else{
	        				Cliente.conectarUsuario(usuario, password);
	                		GUI.getGui().sideBar.setVisible(false);
	                		GUI.getGui().sideBar = new MenuUsuario();
	                		GUI.getGui().sideBar.setVisible(true);
	                		GUI.getGui().add(GUI.getGui().sideBar);
	                		GUI.getGui().repaint(); 
	        			}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}else{
        	    	error.setText(error.getText()+"Contraseña erronea. ");
        	    	error.setVisible(true);
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
		this.add(usuarioF);
		this.add(pass);
		this.add(passF);
		this.add(passFC);
		this.add(image);
		this.add(imageF);
		this.add(seleccionar);
		this.add(registrar);
		this.add(error);
	}

}
