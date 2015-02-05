package persistencia;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ContenedorSUSU {
	
	SUsuario actual;
	SUsuario modificado;
	
	public ContenedorSUSU(){}
	
	public ContenedorSUSU(SUsuario actual, SUsuario modificado){
		this.actual = actual;
		this.modificado = modificado;
	}

	public SUsuario getActual() {
		return actual;
	}

	public void setActual(SUsuario actual) {
		this.actual = actual;
	}

	public SUsuario getModificado() {
		return modificado;
	}

	public void setModificado(SUsuario modificado) {
		this.modificado = modificado;
	}
	

}
