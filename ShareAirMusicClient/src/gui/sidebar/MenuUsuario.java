package gui.sidebar;

import gui.GUI;
import gui.principal.Inicio;
import gui.principal.ModificarUsuario;
import gui.principal.InstrumentosUser;
import gui.principal.SetsUser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cliente.Cliente;

public class MenuUsuario extends SideBar {
	
	private static final long serialVersionUID = 1L;

	ImageIcon image;
	JLabel nombre = new JLabel();
	JLabel login = new JLabel();
	
	JButton perfil = new JButton("Mi Perfil");
	JButton instrumentos = new JButton("Mis Instrumentos");
	JButton sets = new JButton("Mis Sets");
	JButton exit = new JButton("Cerrar Sesión");
	public JButton sel;
	JLabel imageL = new JLabel("",SwingConstants.CENTER);
	
	
	
	public MenuUsuario(){
		super();
		
		image = new ImageIcon(Cliente.su.getUsuario().getImage());
		
		BufferedImage bi = new BufferedImage(image.getIconWidth(),image.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
			// paint the Icon to the BufferedImage.
		image.paintIcon(null, g, 0,0);
			g.dispose();
		
		imageL.setBounds(0, 5, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,200));
		imageL.setIcon(new ImageIcon(GUI.resize(bi, GUI.trans(GUI.ratioH,200), GUI.trans(GUI.ratioH,200))));
		imageL.setVisible(true);
		this.add(imageL);	
		
		nombre = new JLabel(Cliente.su.getUsuario().getNombre(),SwingConstants.CENTER);
		login = new JLabel(Cliente.su.getUsuario().getLogin(),SwingConstants.CENTER);
		
		int h = GUI.trans(GUI.ratioH,216);
		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,0), h, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,35));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,35)+5;
		login.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,25)));
		login.setBounds(GUI.trans(GUI.ratioW,0), h, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,35));
		login.setForeground(new Color(170,170,170));
		login.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,35)+45;
		perfil.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		perfil.setBounds(GUI.trans(GUI.ratioW,0), h, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,35));
		perfil.setHorizontalAlignment(SwingConstants.LEFT);
		perfil.setForeground(new Color(170,170,170));
		perfil.setOpaque(false);
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setVisible(true);
		perfil.setVisible(true);
		perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (sel!=null)sel.setForeground(new Color(170,170,170));
            	perfil.setForeground(new Color(0,148,238));
            	sel=perfil;
            	GUI.getGui().principal.setVisible(false);
            	GUI.getGui().principal = new ModificarUsuario();
            	GUI.getGui().principal.setVisible(true);
            	GUI.getGui().add(GUI.getGui().principal);
            	GUI.getGui().repaint();
            }
        });
		
		h+=GUI.trans(GUI.ratioH,35)+15;
		instrumentos.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		instrumentos.setBounds(GUI.trans(GUI.ratioW,0), h, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,35));
		instrumentos.setHorizontalAlignment(SwingConstants.LEFT);
		instrumentos.setForeground(new Color(170,170,170));
		instrumentos.setOpaque(false);
		instrumentos.setContentAreaFilled(false);
		instrumentos.setBorderPainted(false);
		instrumentos.setVisible(true);
		instrumentos.setVisible(true);
		instrumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (sel!=null)sel.setForeground(new Color(170,170,170));
            	instrumentos.setForeground(new Color(0,148,238));
            	sel=instrumentos;
            	GUI.getGui().principal.setVisible(false);
            	GUI.getGui().principal = new InstrumentosUser();
            	GUI.getGui().principal.setVisible(true);
            	GUI.getGui().add(GUI.getGui().principal);
            	GUI.getGui().repaint();
            }
        });
		
		h+=GUI.trans(GUI.ratioH,35)+15;
		sets.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		sets.setBounds(GUI.trans(GUI.ratioW,0), h, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,35));
		sets.setHorizontalAlignment(SwingConstants.LEFT);
		sets.setForeground(new Color(170,170,170));
		sets.setOpaque(false);
		sets.setContentAreaFilled(false);
		sets.setBorderPainted(false);
		sets.setVisible(true);
		sets.setVisible(true);
		sets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (sel!=null)sel.setForeground(new Color(170,170,170));
            	sets.setForeground(new Color(0,148,238));
            	sel=sets;
            	GUI.getGui().principal.setVisible(false);
            	GUI.getGui().principal = new SetsUser();
            	GUI.getGui().principal.setVisible(true);
            	GUI.getGui().add(GUI.getGui().principal);
            	GUI.getGui().repaint();
            	
            }
        });
		
		h+=GUI.trans(GUI.ratioH,35)+15;
		exit.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		exit.setBounds(GUI.trans(GUI.ratioW,0), h, GUI.trans(GUI.ratioW,444), GUI.trans(GUI.ratioH,35));
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		exit.setForeground(new Color(170,170,170));
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setVisible(true);
		exit.setVisible(true);
		exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cliente.Cliente.cerrarSesion();
            	GUI.getGui().sideBar.setVisible(false);
            	GUI.getGui().sideBar = new Conectarse();
            	GUI.getGui().sideBar.setVisible(true);
            	GUI.getGui().add(GUI.getGui().sideBar);
            	
            	GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new Inicio();
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        		GUI.getGui().repaint();
            }
        });
		
		
		this.add(nombre);
		this.add(login);
		this.add(perfil);
		this.add(instrumentos);
		this.add(sets);
		this.add(exit);
	}

}
