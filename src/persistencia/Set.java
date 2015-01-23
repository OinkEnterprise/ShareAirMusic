package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Set implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] tipos = {"",""};
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idSet;
	 private String nombre;
	 private String tipo;
	 private List<Instrumento> empleos = new ArrayList<Instrumento>();
	 private Usuario user;
	 
	 public Set(){}
	 
	 public Set(String nombre, byte[] image, String login, String password){
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