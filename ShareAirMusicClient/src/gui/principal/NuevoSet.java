package gui.principal;

import gui.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import persistencia.ContenedorSUS;
import persistencia.SetI;
import persistencia.Instrumento;
import cliente.Cliente;

public class NuevoSet extends Principal {

	private static final long serialVersionUID = 1L;
	private JLabel cabecera = new JLabel();
	private JLabel nombre = new JLabel("Nombre:");
	private JTextField nombreF = new JTextField();
	private JLabel genero = new JLabel("Género:");
	private JComboBox<String> generoF = new JComboBox<String>();
	private JLabel abajo = new JLabel("Abajo:");
	private JComboBox<String> abajoF = new JComboBox<String>();
	private JLabel izquierda = new JLabel("Izquierda:");
	private JComboBox<String> izquierdaF = new JComboBox<String>();
	private JButton registrar = new JButton("");
	
	private JLabel error = new JLabel("Error: ");
	
	private List<Instrumento> la;
	private List<Instrumento> li;
	
	public NuevoSet(){
		super();
		
		cabecera = new JLabel("Nuevo Set");
		int h = GUI.trans(GUI.ratioH,100);
		cabecera.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,60)));
		cabecera.setBounds(GUI.trans(GUI.ratioW,100), h, GUI.trans(GUI.ratioW,1250), GUI.trans(GUI.ratioH,80));
		cabecera.setForeground(new Color(170,170,170));
		cabecera.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,220)+14;
		nombre.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombre.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		nombre.setForeground(new Color(170,170,170));
		nombre.setVisible(true);
		
		nombreF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		nombreF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		nombreF.setForeground(new Color(170,170,170));
		nombreF.setBackground(new Color(60,60,60));
		nombreF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		genero.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		genero.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		genero.setForeground(new Color(170,170,170));
		genero.setVisible(true);
		
		generoF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		generoF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		generoF.addItem("Techno");
		generoF.addItem("House");  
		generoF.addItem("Electro");  
		generoF.addItem("Disco");  
		generoF.addItem("DrumNBass");  
		generoF.addItem("Real");  
		generoF.addItem("Personalizado");
		generoF.setForeground(new Color(170,170,170));
		generoF.setBackground(new Color(60,60,60));
		generoF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		abajo.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		abajo.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		abajo.setForeground(new Color(170,170,170));
		abajo.setVisible(true);
		
		
		
		la = Cliente.consultarInstrumentosUser(Cliente.su.getUsuario().getLogin(), "Abajo");
		for (Instrumento i: la){
			abajoF.addItem(i.getNombre());
		}
		abajoF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		abajoF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		abajoF.setForeground(new Color(170,170,170));
		abajoF.setBackground(new Color(60,60,60));
		abajoF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		izquierda.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		izquierda.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		izquierda.setForeground(new Color(170,170,170));
		izquierda.setVisible(true);
		
		
		li = Cliente.consultarInstrumentosUser(Cliente.su.getUsuario().getLogin(), "Izquierda");
		for (Instrumento i: li){
			izquierdaF.addItem(i.getNombre());
		}
		izquierdaF.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		izquierdaF.setBounds(GUI.trans(GUI.ratioW,700), h, GUI.trans(GUI.ratioW,450), GUI.trans(GUI.ratioH,50));
		izquierdaF.setForeground(new Color(170,170,170));
		izquierdaF.setBackground(new Color(60,60,60));
		izquierdaF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		ImageIcon imagen = new ImageIcon(GUI.resize(GUI.class.getClass().getResource("/images/general/boton.png"), GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57)));
		registrar = new JButton("Modificar",imagen);
		registrar.setHorizontalTextPosition(SwingConstants.CENTER);
		registrar.setVerticalTextPosition(SwingConstants.CENTER);
		registrar.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,22)));
		registrar.setForeground(new Color(170,170,170));
		registrar.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,134), GUI.trans(GUI.ratioH,57));
		registrar.setOpaque(false);
		registrar.setContentAreaFilled(false);
		registrar.setBorderPainted(false);
		registrar.setVisible(true);

		registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int a, i;
            	a = abajoF.getSelectedIndex();
            	i = izquierdaF.getSelectedIndex();
            	if(!nombreF.getText().equals("")){
            		List<Instrumento> listaInst = new ArrayList<Instrumento>();
            		listaInst.add(la.get(a));
            		listaInst.add(li.get(i));
            		SetI s =  new SetI(nombreF.getText(),(String)generoF.getSelectedItem(),listaInst,Cliente.su.getUsuario());
            		if(Cliente.aniadirSetI(new ContenedorSUS(Cliente.su,s)).equals("true")){
            			GUI.getGui().principal.setVisible(false);
                		GUI.getGui().principal = new SetsUser();
                		GUI.getGui().principal.setVisible(true);
                		GUI.getGui().add(GUI.getGui().principal);
            		}else{
            			error.setText("No se ha podido introducir el set");
            	    	error.setVisible(true);
            		}
            	}else{
            		error.setText("Han de estar todos los campos completos");
        	    	error.setVisible(true);
            	}
            }
        });
		
		h+=GUI.trans(GUI.ratioH,57)+5;
		error.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,20)));
		error.setBounds(GUI.trans(GUI.ratioW,48), h, GUI.trans(GUI.ratioW,600), GUI.trans(GUI.ratioH,25));
		error.setForeground(new Color(200,0,0));
		error.setVisible(false);
		
		this.add(cabecera);
		this.add(nombre);	
		this.add(nombreF);
		this.add(genero);	
		this.add(generoF);
		this.add(abajo);	
		this.add(abajoF);
		this.add(izquierda);	
		this.add(izquierdaF);
		this.add(registrar);
		this.add(error);
	}

}
