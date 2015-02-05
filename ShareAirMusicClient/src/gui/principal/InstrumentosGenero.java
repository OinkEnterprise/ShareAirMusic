package gui.principal;


import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;

import gui.GUI;
import persistencia.Instrumento;
import cliente.Cliente;

public class InstrumentosGenero extends Principal {

	private static final long serialVersionUID = 1L;
	private JLabel cabecera;
	private ListaInstrumentos lista;
	
	public InstrumentosGenero(String genero){
		super();
		
		cabecera = new JLabel("Instrumentos del género " + genero);
		int h = GUI.trans(GUI.ratioH,100);
		cabecera.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,60)));
		cabecera.setBounds(GUI.trans(GUI.ratioW,100), h, GUI.trans(GUI.ratioW,1250), GUI.trans(GUI.ratioH,80));
		cabecera.setForeground(new Color(170,170,170));
		cabecera.setVisible(true);
		
		List <Instrumento> i = Cliente.consultarInstrumentos(genero);
		lista = new ListaInstrumentos(i,false);
		lista.setBounds(GUI.trans(GUI.ratioH,267), GUI.trans(GUI.ratioH,100+80+20), GUI.trans(GUI.ratioW,945), GUI.trans(GUI.ratioH,750));
		
		lista.setVisible(true);
		this.add(cabecera);
		this.add(lista);
	}

}
