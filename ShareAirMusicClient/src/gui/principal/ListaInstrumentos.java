package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import persistencia.Instrumento;

public class ListaInstrumentos extends JPanel{

	private static final long serialVersionUID = 1L;

	private List<InstrumentoGUI> instG;
	
	public ListaInstrumentos(List<Instrumento> inst, boolean mod){
		super(null);
		this.setBackground(new Color(60,60,60));
		instG = new ArrayList<InstrumentoGUI>();
		int x = GUI.trans(GUI.ratioH,15);
		for(Instrumento i : inst){
			instG.add(new InstrumentoGUI(i,mod));
			instG.get(instG.size()-1).setBounds(GUI.trans(GUI.ratioW,15),GUI.trans(GUI.ratioH,x),GUI.trans(GUI.ratioH,915),GUI.trans(GUI.ratioH,120));
			instG.get(instG.size()-1).setVisible(true);
			this.add(instG.get(instG.size()-1));
			x+=GUI.trans(GUI.ratioH,15)+GUI.trans(GUI.ratioH,120);
		}
	}
}
