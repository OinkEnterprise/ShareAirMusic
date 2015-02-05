package persistencia;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ContenedorSUS {
	
	SUsuario su;
	SetI seti;
	
	public ContenedorSUS(){}
	
	public ContenedorSUS(SUsuario su, SetI seti){
		this.su = su;
		this.seti = seti;
	}

	public SUsuario getSu() {
		return su;
	}

	public void setSu(SUsuario su) {
		this.su = su;
	}

	public SetI getInst() {
		return seti;
	}

	public void setInst(SetI seti) {
		this.seti = seti;
	}
	
	
	

}
