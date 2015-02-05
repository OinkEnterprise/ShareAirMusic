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
import persistencia.Instrumento;
import persistencia.SetI;
import cliente.Cliente;

public class ModificarSet extends Principal {

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
	private SetI seti;
	
	public ModificarSet(SetI set){
		super();
		
		this.seti = set;
		
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
		nombreF.setText(seti.getNombre());
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
		int sel=0;
		for (int i = 0; i < generoF.getItemCount(); i++){
			if(generoF.getItemAt(i).equals(seti.getTipo())){
				sel = i;
			}
		}
		generoF.setSelectedIndex(sel);
		generoF.setForeground(new Color(170,170,170));
		generoF.setBackground(new Color(60,60,60));
		generoF.setVisible(true);
		
		h+=GUI.trans(GUI.ratioH,100)+14;
		abajo.setFont(new Font("Helvetica Neue", Font.PLAIN, GUI.trans(GUI.ratioH,30)));
		abajo.setBounds(GUI.trans(GUI.ratioW,400), h, GUI.trans(GUI.ratioW,700), GUI.trans(GUI.ratioH,35));
		abajo.setForeground(new Color(170,170,170));
		abajo.setVisible(true);
		
		
		Instrumento ia, ii;
		if(seti.getInstrumentos().get(0).getPosicion().equals("Abajo")){
			ia = seti.getInstrumentos().get(0);
			ii = seti.getInstrumentos().get(1);
		}else{
			ia = seti.getInstrumentos().get(1);
			ii = seti.getInstrumentos().get(0);
		}
		
		la = Cliente.consultarInstrumentosUser(Cliente.su.getUsuario().getLogin(), "Abajo");
		
		sel = 0;
		int j = 0; 
		for (Instrumento i: la){
			abajoF.addItem(i.getNombre());
			if(i.getIdInstrumento()==ia.getIdInstrumento()) sel=j;
			j++;
		}
		
		abajoF.setSelectedIndex(sel);
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
		
		sel = 0;
		j = 0; 
		for (Instrumento i: li){
			izquierdaF.addItem(i.getNombre());
			if(i.getIdInstrumento()==ii.getIdInstrumento()) sel=j;
			j++;
		}
		
		izquierdaF.setSelectedIndex(sel);
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
            		seti.setNombre(nombreF.getText());
            		seti.setTipo((String)generoF.getSelectedItem());
            		seti.setInstrumentos(listaInst);
            		if(Cliente.modificarSetI(new ContenedorSUS(Cliente.su,seti)).equals("true")){
            			GUI.getGui().principal.setVisible(false);
                		GUI.getGui().principal = new SetsUser();
                		GUI.getGui().principal.setVisible(true);
                		GUI.getGui().add(GUI.getGui().principal);
            		}else{
            			error.setText("No se ha podido modificar el set");
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
