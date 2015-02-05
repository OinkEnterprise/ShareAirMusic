package gui.sidebar;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cliente.Cliente;


public class Conectarse extends SideBar {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel usuario = new JLabel("Usuario:");
	private JTextField usuarioF = new JTextField();
	private JLabel pass = new JLabel("Contraseña:");
	private JPasswordField passF = new JPasswordField();
	private JButton entrar = new JButton("");
	private JLabel mensaje = new JLabel("No estoy registrado aún.");
	private JButton registrate = new JButton("Registrate!");
	private JLabel error = new JLabel("Usuario o contraseña erronea");
	
	
	public Conectarse(){
		super();
		
		int h = GUI.trans(GUI.ratioH,194);
		
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
		ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		entrar = new JButton("Entrar",imagen);
		entrar.setHorizontalTextPosition(SwingConstants.CENTER);
		entrar.setVerticalTextPosition(SwingConstants.CENTER);
		entrar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		entrar.setForeground(new Color(170,170,170));
		entrar.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		entrar.setOpaque(false);
		entrar.setContentAreaFilled(false);
		entrar.setBorderPainted(false);
		entrar.setVisible(true);
		
		entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String usuario = usuarioF.getText();
            	String password = String.valueOf(passF.getPassword());
            	if(usuario == null || password == null){
            		error.setVisible(true);
            	}else if(Cliente.conectarUsuario(usuario, password).equals("true")){
            		GUI.getGui().sideBar.setVisible(false);
            		GUI.getGui().sideBar = new MenuUsuario();
            		GUI.getGui().sideBar.setVisible(true);
            		GUI.getGui().add(GUI.getGui().sideBar);
            		GUI.getGui().repaint();            		
            	}else{
            		error.setVisible(true);
            	}
            }
        });
		
		h+=GUI.trans(GUI.ratioH,57)+5;
		mensaje.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,20)));
		mensaje.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,25));
		mensaje.setForeground(new Color(170,170,170));
		mensaje.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,25)+5;
		registrate.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,20)));
		registrate.setForeground(new Color(0,148,238));
		registrate.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,25));
		registrate.setOpaque(false);
		registrate.setContentAreaFilled(false);
		registrate.setBorderPainted(false);
		registrate.setVisible(true);
		
		registrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().sideBar.setVisible(false);
        		GUI.getGui().sideBar = new RegistrarUsuario();
        		GUI.getGui().sideBar.setVisible(true);
        		GUI.getGui().add(GUI.getGui().sideBar);
        		GUI.getGui().repaint();
            }
        });
		
		h+=GUI.trans(GUI.ratioH,57)+5;
		error.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,20)));
		error.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,350), GUI.trans(GUI.ratioH,25));
		error.setForeground(new Color(200,0,0));
		error.setVisible(false);
		
		this.add(usuario);
		this.add(usuarioF);
		this.add(pass);
		this.add(passF);
		this.add(entrar);
		this.add(mensaje);
		this.add(registrate);
		this.add(error);
	}

}
