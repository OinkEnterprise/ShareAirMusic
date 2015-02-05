package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;

import persistencia.Instrumento;
import persistencia.SetI;
import cliente.Cliente;

public class Buscar extends Principal {

	private static final long serialVersionUID = 1L;
	
	private JLabel seti = new JLabel();
	private JLabel instrumentos = new JLabel();
	private ListaSets listaS;
	private ListaInstrumentos lista;

	public Buscar(String campo){
		super();
		
		seti = new JLabel("Set");
		seti.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,70)));
		seti.setBounds(GUI.trans(GUI.ratioW,35), GUI.trans(GUI.ratioH,75), GUI.trans(GUI.ratioW,500), GUI.trans(GUI.ratioH,85));
		seti.setForeground(new Color(170,170,170));
		seti.setVisible(true);
		
		List <SetI> i = Cliente.buscarSetIs(campo);
		listaS = new ListaSets(i,true);
		listaS.setBounds(GUI.trans(GUI.ratioH,267), GUI.trans(GUI.ratioH,75+85+20), GUI.trans(GUI.ratioW,945), GUI.trans(GUI.ratioH,300));
		
		instrumentos = new JLabel("Instrumentos");
		instrumentos.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,70)));
		instrumentos.setBounds(GUI.trans(GUI.ratioW,35), GUI.trans(GUI.ratioH,550), GUI.trans(GUI.ratioW,500), GUI.trans(GUI.ratioH,85));
		instrumentos.setForeground(new Color(170,170,170));
		instrumentos.setVisible(true);
		
		List <Instrumento> il = Cliente.buscarInstrumentos(campo);
		lista = new ListaInstrumentos(il,false);
		lista.setBounds(GUI.trans(GUI.ratioH,267), GUI.trans(GUI.ratioH,550+85+20), GUI.trans(GUI.ratioW,945), GUI.trans(GUI.ratioH,300));
		lista.setVisible(true);
		

		this.add(seti);
		this.add(instrumentos);
		this.add(listaS);
		this.add(lista);
		
	}
}
