package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Principal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int x;
	public static int y;
	public static int w;
	public static int h;
	
	public static void setBoundsStatic(int x1, int y1, int w1, int h1){
		x=x1;y=y1;w=w1;h=h1;
	}
	
	
	public JLabel borde = new JLabel("");
	public JLabel logo = new JLabel("");
	public JButton exit, home;
	private JTextField buscarF = new JTextField();
	private JButton buscarB = new JButton("");
	
	public Principal(){
		super(null);
		setBounds(x,y,w,h);
		int w,h;
		this.setBackground(new Color(35,35,35));
		
		w=GUI.trans(50, GUI.ratioW);
		h=GUI.trans(50, GUI.ratioH);
		home = new JButton("");
		home.setBounds(GUI.trans(GUI.ratioW,15), GUI.trans(GUI.ratioW,20), w, h);
		home.setIcon(new ImageIcon(GUI.resize(getClass().getResource("/images/general/HomeIcon.png"),w,h)));
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		
		
		home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new Inicio();
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        		GUI.getGui().repaint();	
            }
        });
		
		borde.setBounds(0, 0, 10, GUI.screenSize.height);
		borde.setIcon(new ImageIcon(GUI.class.getResource("/images/tracks/borde.png")));
		borde.setVisible(true);
		
		w=GUI.trans(203, GUI.ratioW);
		h=GUI.trans(64, GUI.ratioH);
		logo.setBounds(GUI.prinSize.width-w, GUI.prinSize.height-h, w, h);
		logo.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/logo.png"),w,h)));
		logo.setVisible(true);
		
		w=GUI.trans(24, GUI.ratioW);
		h=GUI.trans(36, GUI.ratioH);
		exit = new JButton("");
		exit.setBounds(GUI.prinSize.width-w-10, 5, w, h);
		exit.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/exit.png"),w,h)));
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		
		exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
		
		buscarF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		buscarF.setBounds(GUI.trans(GUI.ratioW,850), GUI.trans(GUI.ratioH,20), GUI.trans(GUI.ratioW,250), GUI.trans(GUI.ratioH,55));
		buscarF.setForeground(new Color(170,170,170));
		buscarF.setBackground(new Color(60,60,60));
		buscarF.setVisible(true);
		
		ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		buscarB = new JButton("Buscar",imagen);
		buscarB.setHorizontalTextPosition(SwingConstants.CENTER);
		buscarB.setVerticalTextPosition(SwingConstants.CENTER);
		buscarB.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,22)));
		buscarB.setForeground(new Color(170,170,170));
		buscarB.setBounds(GUI.trans(GUI.ratioW,1150), GUI.trans(GUI.ratioH,20), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		buscarB.setOpaque(false);
		buscarB.setContentAreaFilled(false);
		buscarB.setBorderPainted(false);
		buscarB.setVisible(true);
		
		buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             String  s = buscarF.getText();
             if (s != null && !s.equals("")){
              GUI.getGui().principal.setVisible(false);
              GUI.getGui().principal = new Buscar(s);
              GUI.getGui().principal.setVisible(true);
              GUI.getGui().add(GUI.getGui().principal);
              GUI.getGui().repaint(); 
             }
            }
        });

		this.add(borde);
		this.add(logo);
		this.add(exit);
		this.add(home);
		this.add(buscarF);		
		this.add(buscarB);

	}
	

}
