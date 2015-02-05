package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class SetI implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] tipos = {"Techno","House","Electro","Disco","DrumNBass", "Real", "Personalizado"};
	
	@Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private Long idSet;
	 private String nombre;
	 private String tipo;
	 private List<Instrumento> instrumentos = new ArrayList<Instrumento>();
	 private Usuario usuario;
	 
	 public SetI(){}
	 
	 public SetI(String nombre, String tipo, List<Instrumento> instrumentos, Usuario usuario){
		 this.nombre = nombre;
		 this.tipo = tipo;
		 this.instrumentos = instrumentos;
		 this.usuario = usuario;
	 }
	 
	 public Long getIdSet() {
		   return idSet;
	 }

	 public void setIdSet(Long idSet) {
		   this.idSet = idSet;
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
	 
	 @ManyToOne
	 public Usuario getUsuario() {
		    return usuario;
	 }
	 
	 public void setUsuario(Usuario usuario) {
		    this.usuario=usuario;
	 }
	 
	 @ManyToMany
	 public List<Instrumento> getInstrumentos() {
		    return instrumentos;
	 }
	 
	 public void setInstrumentos(List<Instrumento> instrumentos) {
		    this.instrumentos=instrumentos;
	 }

	public void modificar(String nombre, String tipo,
			List<Instrumento> instrumentos) {
		this.nombre = nombre;
		 this.tipo = tipo;
		 this.instrumentos = instrumentos;
		
	}
	
	public String toString(){
		String str = "Nombre: " + nombre + " Tipo: " + tipo;
		for (Instrumento in: instrumentos){
			str = str + "   " + in.toString();
		}
		
		return str;
	}
} 