package persistencia;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ContenedorSUI {
	
	SUsuario su;
	Instrumento inst;
	
	public ContenedorSUI(){}
	
	public ContenedorSUI(SUsuario su, Instrumento inst){
		this.su = su;
		this.inst = inst;
	}

	public SUsuario getSu() {
		return su;
	}

	public void setSu(SUsuario su) {
		this.su = su;
	}

	public Instrumento getInst() {
		return inst;
	}

	public void setInst(Instrumento inst) {
		this.inst = inst;
	}
	
	
	

}
