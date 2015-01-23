package persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idUsuario;
	 private String nombre;
	 private byte[] image;
	 private String login;
	 private String password;
	 
	 public Usuario(){}
	 
	 public Usuario(String nombre, byte[] image, String login, String password){
		 this.nombre = nombre;
		 this.image = image;
		 this.login = login;
		 this.password = password;
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
	 
	 public byte[] getImage() {
		   return image;
	 }

	public void setImage(byte[] image) {
		   this.image = image;
	}
	
	public String getLogin() {
		   return login;
	}

	public void setLogin(String login) {
		   this.login = login;
	}
	
	public String getPassword() {
		   return password;
	}

	public void setPassword(String password) {
		   this.password = password;
	}
	
	
} 