package gui.principal;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import gui.GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cliente.Cliente;
import persistencia.ContenedorSUI;
import persistencia.Instrumento;

public class InstrumentoGUI extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
	private Instrumento inst;

	private JLabel nombre;
	private JLabel autor;
	private JLabel generoL = new JLabel("Género: ");
	private JLabel genero;
	private JLabel posicionL = new JLabel("Posición: ");
	private JLabel posicion;
	private JButton sonido1= new JButton("Sonido 1",imagen);
	private JButton sonido2=  new JButton("Sonido 2",imagen);
	
	private JButton eliminar= new JButton(new ImageIcon(GUI.class.getClass().getResource("/images/general/cubo.png")));
	private JButton modificar=  new JButton(new ImageIcon(GUI.class.getClass().getResource("/images/general/lapiz.png")));
	
	public InstrumentoGUI(Instrumento inst1, boolean mod){
		super(null);
		this.inst=inst1;
		
		//this.setBackground(new Color(60,60,60));
		this.setBackground(new Color(35,35,35));
		
		nombre = new JLabel(inst.getNombre());
		autor = new JLabel(inst.getUsuario().getLogin());
		genero = new JLabel(inst.getTipo());
		posicion = new JLabel(inst.getPosicion());
		
		int x = 15,s1,s2;
		
		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,10), GUI.trans(GUI.ratioW,300), GUI.trans(GUI.ratioH,35));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		autor.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		autor.setBounds(GUI.trans(GUI.ratioW,x+10), GUI.trans(GUI.ratioH,55), GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,30));
		autor.setForeground(new Color(170,170,170));
		autor.setVisible(true);
		
		x+=300;s1 = x;
		generoL.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		generoL.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,15), GUI.trans(GUI.ratioW,100), GUI.trans(GUI.ratioH,30));
		generoL.setForeground(new Color(170,170,170));
		generoL.setVisible(true);
		
		x+=100;
		genero.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		genero.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,15), GUI.trans(GUI.ratioW,160), GUI.trans(GUI.ratioH,30));
		genero.setForeground(new Color(170,170,170));
		genero.setVisible(true);
		
		x+=160+20;s2 = x;
		posicionL.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		posicionL.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,15), GUI.trans(GUI.ratioW,115), GUI.trans(GUI.ratioH,30));
		posicionL.setForeground(new Color(170,170,170));
		posicionL.setVisible(true);
		
		x+=115;
		posicion.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		posicion.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,15), GUI.trans(GUI.ratioW,150), GUI.trans(GUI.ratioH,30));
		posicion.setForeground(new Color(170,170,170));
		posicion.setVisible(true);
		
		x+=160;
		modificar.setHorizontalTextPosition(SwingConstants.CENTER);
		modificar.setVerticalTextPosition(SwingConstants.CENTER);
		modificar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		modificar.setForeground(new Color(170,170,170));
		modificar.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,15), GUI.trans(GUI.ratioW,30), GUI.trans(GUI.ratioH,30));
		modificar.setOpaque(false);
		modificar.setContentAreaFilled(false);
		modificar.setBorderPainted(false);
		modificar.setVisible(mod);
		
		eliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		eliminar.setVerticalTextPosition(SwingConstants.CENTER);
		eliminar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		eliminar.setForeground(new Color(170,170,170));
		eliminar.setBounds(GUI.trans(GUI.ratioW,x), GUI.trans(GUI.ratioH,55), GUI.trans(GUI.ratioW,30), GUI.trans(GUI.ratioH,30));
		eliminar.setOpaque(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorderPainted(false);
		eliminar.setVisible(mod);
		
		
		sonido1.setHorizontalTextPosition(SwingConstants.CENTER);
		sonido1.setVerticalTextPosition(SwingConstants.CENTER);
		sonido1.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		sonido1.setForeground(new Color(170,170,170));
		sonido1.setBounds(GUI.trans(GUI.ratioW,s1), GUI.trans(GUI.ratioH,55), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		sonido1.setOpaque(false);
		sonido1.setContentAreaFilled(false);
		sonido1.setBorderPainted(false);
		sonido1.setVisible(true);
		
		sonido2.setHorizontalTextPosition(SwingConstants.CENTER);
		sonido2.setVerticalTextPosition(SwingConstants.CENTER);
		sonido2.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		sonido2.setForeground(new Color(170,170,170));
		sonido2.setBounds(GUI.trans(GUI.ratioW,s2), 55, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		sonido2.setOpaque(false);
		sonido2.setContentAreaFilled(false);
		sonido2.setBorderPainted(false);
		sonido2.setVisible(true);
		
		
		
		sonido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	AudioInputStream os = inst.getSonido1().toAudioInputStream();
				try {
					Clip clip = AudioSystem.getClip();
	    		    //clip.addLineListener(this);
	    		    clip.open(os);
	    		    //clip.open(AudioFileFormat.Type.WAVE, buffer, offset, buffer.length);
	    		    clip.start();
				} catch (LineUnavailableException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		sonido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	AudioInputStream os = inst.getSonido2().toAudioInputStream();
            	try {
					Clip clip = AudioSystem.getClip();
	    		    //clip.addLineListener(this);
	    		    clip.open(os);
	    		    //clip.open(AudioFileFormat.Type.WAVE, buffer, offset, buffer.length);
	    		    clip.start();
				} catch (LineUnavailableException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(Cliente.eliminarInstrumento(new ContenedorSUI(Cliente.su,inst)).equals("true")){
            		GUI.getGui().principal.setVisible(false);
            		GUI.getGui().principal = new InstrumentosUser();
            		GUI.getGui().principal.setVisible(true);
            		GUI.getGui().add(GUI.getGui().principal);
            		GUI.getGui().repaint(); 
            	}
            	else{
            		((InstrumentosUser)GUI.getGui().principal).error.setVisible(true);
            		GUI.getGui().repaint(); 
            	}
            }
        });
		
		modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new ModificarInstrumento(inst);
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        		GUI.getGui().repaint(); 
            }
        });

		this.add(nombre);
		this.add(autor);		
		this.add(generoL);
		this.add(genero);
		this.add(posicionL);
		this.add(posicion);
		this.add(sonido1);
		this.add(sonido2);
		this.add(modificar);
		this.add(eliminar);	
		
	}
	
	
}
