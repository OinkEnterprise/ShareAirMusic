package persistencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class SUsuario implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private Long idSUsuario;
	 private String password;
	 private Usuario usuario;
	 
	 public SUsuario(){}
	 
	 public SUsuario(String password, Usuario usuario){
		 this.password = password;
		 this.usuario = usuario;
	 }
	 
	public Long getIdSUsuario() {
		return idSUsuario;
	}
	public void setIdSUsuario(Long idSUsuario) {
		this.idSUsuario = idSUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne
	public Usuario getUsuario() {
		return usuario;
	}
	
	@OneToOne
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	 

}
