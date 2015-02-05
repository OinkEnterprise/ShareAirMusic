package persistencia;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import persistencia.Sonido;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Instrumento implements Serializable{
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final String[] tipos = {"Techno","House","Electro","Disco","DrumNBass", "Real", "Personalizado"};
		private static final String[] posiciones = {"Izquierda","Abajo"};
		@Id
		 @GeneratedValue(strategy = GenerationType.TABLE)
		 private Long idInstrumento;
		 private String nombre;
		 private String tipo;
		 private String posicion;
		 private Sonido sonido1;
		 private Sonido sonido2;
		 private Usuario usuario;
		 
		 
		 public Instrumento(){}
		 
		 public Instrumento(String nombre, String tipo, String posicion, Sonido sonido1, Sonido sonido2, Usuario usuario){
			 this.nombre=nombre;
			 this.tipo=tipo;
			 this.posicion=posicion;
			 this.sonido1=sonido1;
			 this.sonido2=sonido2;
			 this.usuario=usuario;
		 }
		 
		 
		 
		 public Long getIdInstrumento() {
			   return idInstrumento;
		 }

		 public void setIdInstrumento(Long idInstrumento) {
			   this.idInstrumento = idInstrumento;
		 }
		 
		 public String getNombre() {
			   return nombre;
		 }

		 public void setNombre(String nombre) {
			   this.nombre = nombre;
		 }
			 
		 public String getTipo() {
				   return tipo;
		 }

		 public void setTipo(String tipo) {
				   this.tipo = tipo;
		 }
		 
		 public String getPosicion() {
			   return posicion;
		 }

		 public void setPosicion(String posicion) {
			   this.posicion = posicion;
		 }
		 
		 @OneToMany
		 public Sonido getSonido1() {
			   return sonido1;
		 }

		 public void setSonido1(Sonido sonido1) {
			   this.sonido1 = sonido1;
		 }
		 
		 @OneToMany
		 public Sonido getSonido2() {
			   return sonido2;
		 }

		 public void setSonido2(Sonido sonido2) {
			   this.sonido2 = sonido2;
		 }
			 
			 @ManyToOne
			 public Usuario getUsuario() {
				    return usuario;
			 }
			 
			 public void setUsuario(Usuario usuario) {
				    this.usuario=usuario;
			 }



			public void modificar(String nombre, String tipo,
					String posicion, Sonido sonido1,Sonido sonido2) {
				 this.nombre=nombre;
				 this.tipo=tipo;
				 this.posicion=posicion;
				 this.sonido1=sonido1;
				 this.sonido2=sonido2;
				
			}
			
			public String toString(){
				return "Nombre: " + nombre + " Tipo: " + tipo + " Posicion: " + posicion + " sonido1: " + sonido1+ " sonido1: " + sonido1 + "    Usuario: " + usuario.toString();  
			}
			 

}
