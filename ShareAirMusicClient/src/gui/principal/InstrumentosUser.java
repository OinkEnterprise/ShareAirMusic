package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import persistencia.Instrumento;
import cliente.Cliente;

public class InstrumentosUser extends Principal {

	
	private static final long serialVersionUID = 1L;
	private JLabel cabecera;
	private ListaInstrumentos lista;
	ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
	private JButton nuevo= new JButton("Nuevo",imagen);
	public JLabel error = new JLabel("No se puede borrar: Este instrumento está asociado a un set.");
	
	public InstrumentosUser(){
		super();
		
		cabecera = new JLabel("Mis Instrumentos");
		int h = GUI.trans(GUI.ratioH,100);
		cabecera.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,60)));
		cabecera.setBounds(GUI.trans(GUI.ratioW,100), h, GUI.trans(GUI.ratioW,1250), GUI.trans(GUI.ratioH,80));
		cabecera.setForeground(new Color(170,170,170));
		cabecera.setVisible(true);
		
		nuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		nuevo.setVerticalTextPosition(SwingConstants.CENTER);
		nuevo.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioW,24)));
		nuevo.setForeground(new Color(170,170,170));
		nuevo.setBounds(GUI.trans(GUI.ratioW,1000), GUI.trans(GUI.ratioH,120), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		nuevo.setOpaque(false);
		nuevo.setContentAreaFilled(false);
		nuevo.setBorderPainted(false);
		nuevo.setVisible(true);
		nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new NuevoInstrumento();
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        		GUI.getGui().repaint();
            }
        });
		
		List <Instrumento> i = Cliente.consultarInstrumentosUser(Cliente.su.getUsuario().getLogin());
		lista = new ListaInstrumentos(i,true);
		lista.setBounds(GUI.trans(GUI.ratioH,267), GUI.trans(GUI.ratioH,100+80+20), GUI.trans(GUI.ratioW,945), GUI.trans(GUI.ratioH,750));
		lista.setVisible(true);
		
		error.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,20)));
		error.setBounds(GUI.trans(GUI.ratioW,267), GUI.trans(GUI.ratioH,100+80+20+750), GUI.trans(GUI.ratioW,945), GUI.trans(GUI.ratioH,25));
		error.setForeground(new Color(200,0,0));
		error.setVisible(false);
		this.add(error);
		
		this.add(nuevo);
		this.add(cabecera);
		this.add(lista);
	}
}
