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
import persistencia.ContenedorSUS;
import persistencia.Instrumento;
import persistencia.SetI;

public class SetGUI extends JPanel{

	private static final long serialVersionUID = 1L;
	ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
	private SetI set;

	private JLabel nombre;
	private JLabel autor;
	private JLabel generoL = new JLabel("");
	private JLabel posicionL1 = new JLabel("Posición: ");
	private JLabel posicionL2 = new JLabel("Posición: ");
	private JButton sonido11= new JButton("Sonido 1",imagen);
	private JButton sonido21=  new JButton("Sonido 2",imagen);
	private JButton sonido12= new JButton("Sonido 1",imagen);
	private JButton sonido22=  new JButton("Sonido 2",imagen);
	
	private JButton eliminar= new JButton(new ImageIcon(GUI.class.getClass().getResource("/images/general/cubo.png")));
	private JButton modificar=  new JButton(new ImageIcon(GUI.class.getClass().getResource("/images/general/lapiz.png")));
	private Instrumento inst1;
	private Instrumento inst2;
	
	public SetGUI(SetI seti, boolean mod){
		super(null);
		this.set=seti;
		
		this.setBackground(new Color(35,35,35));
		
		nombre = new JLabel(set.getNombre());
		autor = new JLabel(set.getUsuario().getLogin());
		generoL = new JLabel(generoL.getText()+set.getTipo());
		inst1 = set.getInstrumentos().get(0);
		inst2 = set.getInstrumentos().get(1);
		posicionL1 = new JLabel(inst1.getNombre()+": "+inst1.getPosicion());
		posicionL2 = new JLabel(inst2.getNombre()+": "+inst2.getPosicion());

		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,15), GUI.trans(GUI.ratioH,10), GUI.trans(GUI.ratioW,300), GUI.trans(GUI.ratioH,35));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		autor.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		autor.setBounds(GUI.trans(GUI.ratioW,23), GUI.trans(GUI.ratioH,45), GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,30));
		autor.setForeground(new Color(170,170,170));
		autor.setVisible(true);
		
		generoL.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,25)));
		generoL.setBounds(GUI.trans(GUI.ratioW,23), GUI.trans(GUI.ratioH,75), GUI.trans(GUI.ratioW,287), GUI.trans(GUI.ratioH,30));
		generoL.setForeground(new Color(170,170,170));
		generoL.setVisible(true);
		
		posicionL1.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,30)));
		posicionL1.setBounds(GUI.trans(GUI.ratioW,220), GUI.trans(GUI.ratioH,10), GUI.trans(GUI.ratioW,300), GUI.trans(GUI.ratioH,35));
		posicionL1.setForeground(new Color(170,170,170));
		posicionL1.setVisible(true);
		
		sonido11.setHorizontalTextPosition(SwingConstants.CENTER);
		sonido11.setVerticalTextPosition(SwingConstants.CENTER);
		sonido11.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		sonido11.setForeground(new Color(170,170,170));
		sonido11.setBounds(GUI.trans(GUI.ratioW,220), GUI.trans(GUI.ratioH,55), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		sonido11.setOpaque(false);
		sonido11.setContentAreaFilled(false);
		sonido11.setBorderPainted(false);
		sonido11.setVisible(true);
		
		
		sonido11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	AudioInputStream os = inst1.getSonido1().toAudioInputStream();
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
		
		sonido21.setHorizontalTextPosition(SwingConstants.CENTER);
		sonido21.setVerticalTextPosition(SwingConstants.CENTER);
		sonido21.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		sonido21.setForeground(new Color(170,170,170));
		sonido21.setBounds(GUI.trans(GUI.ratioW,370), 55, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		sonido21.setOpaque(false);
		sonido21.setContentAreaFilled(false);
		sonido21.setBorderPainted(false);
		sonido21.setVisible(true);
		
		sonido21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	AudioInputStream os = inst1.getSonido2().toAudioInputStream();
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
		
		posicionL2.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,30)));
		posicionL2.setBounds(GUI.trans(GUI.ratioW,525), GUI.trans(GUI.ratioH,10), GUI.trans(GUI.ratioW,300), GUI.trans(GUI.ratioH,35));
		posicionL2.setForeground(new Color(170,170,170));
		posicionL2.setVisible(true);
		
		sonido12.setHorizontalTextPosition(SwingConstants.CENTER);
		sonido12.setVerticalTextPosition(SwingConstants.CENTER);
		sonido12.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		sonido12.setForeground(new Color(170,170,170));
		sonido12.setBounds(GUI.trans(GUI.ratioW,525), GUI.trans(GUI.ratioH,55), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		sonido12.setOpaque(false);
		sonido12.setContentAreaFilled(false);
		sonido12.setBorderPainted(false);
		sonido12.setVisible(true);
		
		
		sonido12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	AudioInputStream os = inst2.getSonido1().toAudioInputStream();
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
		
		sonido22.setHorizontalTextPosition(SwingConstants.CENTER);
		sonido22.setVerticalTextPosition(SwingConstants.CENTER);
		sonido22.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		sonido22.setForeground(new Color(170,170,170));
		sonido22.setBounds(GUI.trans(GUI.ratioW,675), 55, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		sonido22.setOpaque(false);
		sonido22.setContentAreaFilled(false);
		sonido22.setBorderPainted(false);
		sonido22.setVisible(true);
		
		sonido22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	AudioInputStream os = inst2.getSonido2().toAudioInputStream();
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
		
		modificar.setHorizontalTextPosition(SwingConstants.CENTER);
		modificar.setVerticalTextPosition(SwingConstants.CENTER);
		modificar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		modificar.setForeground(new Color(170,170,170));
		modificar.setBounds(GUI.trans(GUI.ratioW,875), GUI.trans(GUI.ratioH,15), GUI.trans(GUI.ratioW,30), GUI.trans(GUI.ratioH,30));
		modificar.setOpaque(false);
		modificar.setContentAreaFilled(false);
		modificar.setBorderPainted(false);
		modificar.setVisible(mod);
		
		modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new ModificarSet(set);
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        		GUI.getGui().repaint(); 
            }
        });
		
		eliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		eliminar.setVerticalTextPosition(SwingConstants.CENTER);
		eliminar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		eliminar.setForeground(new Color(170,170,170));
		eliminar.setBounds(GUI.trans(GUI.ratioW,875), GUI.trans(GUI.ratioH,55), GUI.trans(GUI.ratioW,30), GUI.trans(GUI.ratioH,30));
		eliminar.setOpaque(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorderPainted(false);
		eliminar.setVisible(mod);
		
		eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(Cliente.eliminarSetI(new ContenedorSUS(Cliente.su,set)).equals("true")){
            		GUI.getGui().principal.setVisible(false);
            		GUI.getGui().principal = new SetsUser();
            		GUI.getGui().principal.setVisible(true);
            		GUI.getGui().add(GUI.getGui().principal);
            		GUI.getGui().repaint(); 
            	}
            	else{
            		((SetsUser)GUI.getGui().principal).error.setVisible(true);
            		GUI.getGui().repaint(); 
            	}
            }
        });
		
		this.add(nombre);
		this.add(autor);		
		this.add(generoL);
		this.add(posicionL1);
		this.add(sonido11);
		this.add(sonido21);
		this.add(posicionL2);
		this.add(sonido12);
		this.add(sonido22);
		this.add(modificar);
		this.add(eliminar);	
		
	}
	
	
}
