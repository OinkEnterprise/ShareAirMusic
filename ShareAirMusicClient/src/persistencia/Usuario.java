package persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Usuario implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private Long idUsuario;
	 private String nombre;
	 private String login;
	 private byte[] image;
	 
	 public Usuario(){}
	 
	 public Usuario(String nombre, byte[] image, String login){
		 this.nombre = nombre;
		 this.login = login;
		 this.image = image;
	 }
	 
	 public Long getIdUsuario() {
		   return idUsuario;
		 }

	 public void setIdUsuario(Long idUsuario) {
		   this.idUsuario = idUsuario;
		   }

	 public String getNombre() {
	   return nombre;
	 }

	 public void setNombre(String nombre) {
	   this.nombre = nombre;
	 }
	
	public String getLogin() {
		   return login;
	}

	public void setLogin(String login) {
		   this.login = login;
	}
	
	 public byte[] getImage() {
		   return image;
	 }

	 public void setImage(byte[] image) {
		   this.image = image;
	 }
	
	public String toString(){
		return "Nombre: " + nombre + " Login: " + login ;  
	}
	
} 