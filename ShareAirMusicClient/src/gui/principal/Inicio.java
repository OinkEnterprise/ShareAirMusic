package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Inicio extends Principal {

	private static final long serialVersionUID = 1L;
	
	private JLabel seti = new JLabel();
	private JLabel instrumentos = new JLabel();
	public JButton DiscoIcon, DrumIcon, ElectroIcon, HouseIcon, PersonalizadaIcon, RealIcon, TechnoIcon;
	public JButton DiscoIconI, DrumIconI, ElectroIconI, HouseIconI, PersonalizadaIconI, RealIconI, TechnoIconI;

	public Inicio(){
		super();

		seti = new JLabel("Sets");
		seti.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,70)));
		seti.setBounds(GUI.trans(GUI.ratioW,35), GUI.trans(GUI.ratioH,75), GUI.trans(GUI.ratioW,500), GUI.trans(GUI.ratioH,85));
		seti.setForeground(new Color(170,170,170));
		seti.setVisible(true);
		
		int w=GUI.trans(175, GUI.ratioW);
		int h=GUI.trans(175, GUI.ratioH);
		int des =  GUI.trans(GUI.ratioW,250);
		DiscoIcon = new JButton("");
		DiscoIcon.setBounds(des, GUI.trans(GUI.ratioH,175), w, h);
		DiscoIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/DiscoIcon.png"),w,h)));
		DiscoIcon.setOpaque(false);
		DiscoIcon.setContentAreaFilled(false);
		DiscoIcon.setBorderPainted(false);
		
		DiscoIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("Disco");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des += GUI.trans(GUI.ratioW,275);
		DrumIcon = new JButton("");
		DrumIcon.setBounds(des, GUI.trans(GUI.ratioH,175), w, h);
		DrumIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/DrumIcon.png"),w,h)));
		DrumIcon.setOpaque(false);
		DrumIcon.setContentAreaFilled(false);
		DrumIcon.setBorderPainted(false);
		
		DrumIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("DrumNBass");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des += GUI.trans(GUI.ratioW,275);
		ElectroIcon = new JButton("");
		ElectroIcon.setBounds(des, GUI.trans(GUI.ratioH,175), w, h);
		ElectroIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/ElectroIcon.png"),w,h)));
		ElectroIcon.setOpaque(false);
		ElectroIcon.setContentAreaFilled(false);
		ElectroIcon.setBorderPainted(false);
		
		ElectroIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("Electro");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des += GUI.trans(GUI.ratioW,275);
		HouseIcon = new JButton("");
		HouseIcon.setBounds(des, GUI.trans(GUI.ratioH,175), w, h);
		HouseIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/HouseIcon.png"),w,h)));
		HouseIcon.setOpaque(false);
		HouseIcon.setContentAreaFilled(false);
		HouseIcon.setBorderPainted(false);
		
		HouseIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("House");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des =  GUI.trans(GUI.ratioW,385);
		PersonalizadaIcon = new JButton("");
		PersonalizadaIcon.setBounds(des, GUI.trans(GUI.ratioH,375), w, h);
		PersonalizadaIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/PersonalizadaIcon.png"),w,h)));
		PersonalizadaIcon.setOpaque(false);
		PersonalizadaIcon.setContentAreaFilled(false);
		PersonalizadaIcon.setBorderPainted(false);
		
		PersonalizadaIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("Personalizado");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des +=  GUI.trans(GUI.ratioW,275);
		RealIcon = new JButton("");
		RealIcon.setBounds(des, GUI.trans(GUI.ratioH,375), w, h);
		RealIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/RealIcon.png"),w,h)));
		RealIcon.setOpaque(false);
		RealIcon.setContentAreaFilled(false);
		RealIcon.setBorderPainted(false);
		
		RealIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("Real");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des +=  GUI.trans(GUI.ratioW,275);
		TechnoIcon = new JButton("");
		TechnoIcon.setBounds(des, GUI.trans(GUI.ratioH,375), w, h);
		TechnoIcon.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/TechnoIcon.png"),w,h)));
		TechnoIcon.setOpaque(false);
		TechnoIcon.setContentAreaFilled(false);
		TechnoIcon.setBorderPainted(false);
		
		TechnoIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new SetsGenero("Techno");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		instrumentos = new JLabel("Instrumentos");
		instrumentos.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,70)));
		instrumentos.setBounds(GUI.trans(GUI.ratioW,35), GUI.trans(GUI.ratioH,550), GUI.trans(GUI.ratioW,500), GUI.trans(GUI.ratioH,85));
		instrumentos.setForeground(new Color(170,170,170));
		instrumentos.setVisible(true);
		
		w=GUI.trans(175, GUI.ratioW);
		h=GUI.trans(175, GUI.ratioH);
		des =  GUI.trans(GUI.ratioW,250);
		DiscoIconI = new JButton("");
		DiscoIconI.setBounds(des, GUI.trans(GUI.ratioH,650), w, h);
		DiscoIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/DiscoIcon.png"),w,h)));
		DiscoIconI.setOpaque(false);
		DiscoIconI.setContentAreaFilled(false);
		DiscoIconI.setBorderPainted(false);
		
		DiscoIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("Disco");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des += GUI.trans(GUI.ratioW,275);
		DrumIconI = new JButton("");
		DrumIconI.setBounds(des, GUI.trans(GUI.ratioH,650), w, h);
		DrumIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/DrumIcon.png"),w,h)));
		DrumIconI.setOpaque(false);
		DrumIconI.setContentAreaFilled(false);
		DrumIconI.setBorderPainted(false);
		
		DrumIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("DrumNBass");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des += GUI.trans(GUI.ratioW,275);
		ElectroIconI = new JButton("");
		ElectroIconI.setBounds(des, GUI.trans(GUI.ratioH,650), w, h);
		ElectroIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/ElectroIcon.png"),w,h)));
		ElectroIconI.setOpaque(false);
		ElectroIconI.setContentAreaFilled(false);
		ElectroIconI.setBorderPainted(false);
		
		ElectroIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("Electro");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des += GUI.trans(GUI.ratioW,275);
		HouseIconI = new JButton("");
		HouseIconI.setBounds(des, GUI.trans(GUI.ratioH,650), w, h);
		HouseIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/HouseIcon.png"),w,h)));
		HouseIconI.setOpaque(false);
		HouseIconI.setContentAreaFilled(false);
		HouseIconI.setBorderPainted(false);
		
		HouseIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("House");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des =  GUI.trans(GUI.ratioW,385);
		PersonalizadaIconI = new JButton("");
		PersonalizadaIconI.setBounds(des, GUI.trans(GUI.ratioH,850), w, h);
		PersonalizadaIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/PersonalizadaIcon.png"),w,h)));
		PersonalizadaIconI.setOpaque(false);
		PersonalizadaIconI.setContentAreaFilled(false);
		PersonalizadaIconI.setBorderPainted(false);
		
		PersonalizadaIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("Personalizado");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des +=  GUI.trans(GUI.ratioW,275);
		RealIconI = new JButton("");
		RealIconI.setBounds(des, GUI.trans(GUI.ratioH,850), w, h);
		RealIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/RealIcon.png"),w,h)));
		RealIconI.setOpaque(false);
		RealIconI.setContentAreaFilled(false);
		RealIconI.setBorderPainted(false);
		
		RealIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("Real");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });
		
		des +=  GUI.trans(GUI.ratioW,275);
		TechnoIconI = new JButton("");
		TechnoIconI.setBounds(des, GUI.trans(GUI.ratioH,850), w, h);
		TechnoIconI.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/TechnoIcon.png"),w,h)));
		TechnoIconI.setOpaque(false);
		TechnoIconI.setContentAreaFilled(false);
		TechnoIconI.setBorderPainted(false);
		
		TechnoIconI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		GUI.getGui().principal.setVisible(false);
        		GUI.getGui().principal = new InstrumentosGenero("Techno");
        		GUI.getGui().principal.setVisible(true);
        		GUI.getGui().add(GUI.getGui().principal);
        	}
        });

		this.add(seti);
		this.add(instrumentos);
		this.add(DiscoIcon);
		this.add(DrumIcon);
		this.add(ElectroIcon);
		this.add(HouseIcon);
		this.add(PersonalizadaIcon);
		this.add(RealIcon);
		this.add(TechnoIcon);
		this.add(DiscoIconI);
		this.add(DrumIconI);
		this.add(ElectroIconI);
		this.add(HouseIconI);
		this.add(PersonalizadaIconI);
		this.add(RealIconI);
		this.add(TechnoIconI);

		
		/*
		Instrumento setprueba = Cliente.consultarInstrumentos("Disco").get(0);
		InstrumentoGUI prueba = new InstrumentoGUI(setprueba,true);
		prueba.setBounds(50, 500, 915, 120);
		prueba.setVisible(true);
		this.add(prueba);
		
		
		SetI setprueba = Cliente.consultarSetIs("Personalizado").get(0);
		SetGUI prueba = new SetGUI(setprueba,true);
		prueba.setBounds(50, 500, 915, 120);
		prueba.setVisible(true);
		this.add(prueba);*/		
	}

}
