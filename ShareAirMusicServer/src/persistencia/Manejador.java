package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sound.sampled.AudioInputStream;

import java.util.ArrayList;
import java.util.List;

public class Manejador {
	
	private static final String PERSISTENCE_UNIT_NAME = "user";
	private static EntityManagerFactory factoria;
	
	static {
		factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	/*-------------------------------------
	 	USUARIO
	 --------------------------------------*/
	
	public static Usuario consultarUsuario(String login) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
        q.setParameter("login", login);
        List<Usuario> u = q.getResultList();
        em.close();
        if (u.isEmpty()){ return new Usuario(); }
        else{ return u.get(0);}
        
    }
	
	public static String registrarUsuario(SUsuario su){
		
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
        q.setParameter("login", su.getUsuario().getLogin());
        boolean m = q.getResultList().size()==0;
        if (m){
        	em.persist(su.getUsuario());
        	em.persist(su);
        	em.getTransaction().commit();
            em.close();
            return "true";
        }else{
        	em.close();
        	return "false";
        }
		
	}
	
	public static Usuario conectarUsuario(String login, String password) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
        q.setParameter("login", login).setParameter("password", password);
        List<SUsuario> su = q.getResultList();
        em.close();
        if (su.isEmpty()){ return new Usuario(); }
        else{ return su.get(0).getUsuario();}
        
    }
	
	public static String modificarUsuario(SUsuario actual, SUsuario modificado) {

		String res = "false";
		
		if (actual.getUsuario().getLogin().equals(modificado.getUsuario().getLogin())){
		
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
        q.setParameter("login", actual.getUsuario().getLogin()).setParameter("password", actual.getPassword());
        List<SUsuario> lsu = q.getResultList();
        if (!lsu.isEmpty()){
        	SUsuario su = lsu.get(0);
        	
        	su.setPassword(modificado.getPassword());
        	su.getUsuario().setNombre(modificado.getUsuario().getNombre());
        	su.getUsuario().setImage(modificado.getUsuario().getImage());
        	
        	em.merge(su.getUsuario());
        	em.merge(su);
        	em.getTransaction().commit();
        	res = "true";
        }
        
        em.close();
        
		}
        
		return res;
    }
	
	
	public static List<Usuario> buscarUsuario(String nombre){
		
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE UPPER(u.login) LIKE UPPER(:nombre) OR UPPER(u.nombre) LIKE UPPER(:login)");
        q.setParameter("nombre", '%'+nombre+'%');
        q.setParameter("login", '%'+nombre+'%');
        List<Usuario> u = q.getResultList();
        em.close();
		
        return u;
	}
	
	/*-------------------------------------
 		INSTRUMENTO
 	--------------------------------------*/
	
	public static Instrumento consultarInstrumento(Long id){
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT i FROM Instrumento i WHERE i.idInstrumento = :id");
        q.setParameter("id", id);
        List<Instrumento> l = q.getResultList();
        em.close();

        if (l.isEmpty()) return new Instrumento();
        else return l.get(0);
	}
	
	public static String aniadirInstrumento(Instrumento inst, SUsuario su) {
		
		String res = "false";
		
		if(inst.getUsuario().getLogin().equals(su.getUsuario().getLogin())){
			EntityManager em = factoria.createEntityManager();
	        em.getTransaction().begin();
	        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
	        q.setParameter("login", su.getUsuario().getLogin()).setParameter("password", su.getPassword());
	        List<SUsuario> lsu = q.getResultList();
	        if (!lsu.isEmpty()){
	        	SUsuario su2 = lsu.get(0);
	        	inst.setUsuario(su2.getUsuario());
	        	em.persist(inst.getSonido1());
	        	em.persist(inst.getSonido2());
	        	em.persist(inst);
	        	em.getTransaction().commit();
	        	em.close();
	        	res = "true";
	        }
		}
		
		return res;
	}
	
	public static List<Instrumento> consultarInstrumentos() {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT i FROM Instrumento i");
        List<Instrumento> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static List<Instrumento> consultarInstrumentos(String tipo) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT i FROM Instrumento i WHERE i.tipo = :tipo");
        q.setParameter("tipo", tipo);
        List<Instrumento> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static List<Instrumento> consultarInstrumentosUser(String login) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
        q.setParameter("login", login);
        Usuario u = (Usuario) q.getSingleResult();
        q = em.createQuery("SELECT i FROM Instrumento i WHERE i.usuario = :usuario");
        q.setParameter("usuario", u);
        List<Instrumento> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static List<Instrumento> consultarInstrumentosUser(String login, String posicion) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
        q.setParameter("login", login);
        Usuario u = (Usuario) q.getSingleResult();
        q = em.createQuery("SELECT i FROM Instrumento i WHERE i.usuario = :usuario AND i.posicion = :posicion");
        q.setParameter("usuario", u).setParameter("posicion", posicion);
        List<Instrumento> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static String modificarInstrumento(Instrumento inst, SUsuario su){
		
		String res = "false";
		
		if(inst.getUsuario().getLogin().equals(su.getUsuario().getLogin())){
			EntityManager em = factoria.createEntityManager();
	        em.getTransaction().begin();
	        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
	        q.setParameter("login", su.getUsuario().getLogin()).setParameter("password", su.getPassword());
	        List<SUsuario> lsu = q.getResultList();
	        if (!lsu.isEmpty()){
	        	SUsuario su2 = lsu.get(0);
	        	inst.setUsuario(su2.getUsuario());
	        	q = em.createQuery("SELECT u FROM Instrumento u WHERE u.idInstrumento = :id AND u.usuario.login = :login");
		        q.setParameter("id", inst.getIdInstrumento()).setParameter("login", inst.getUsuario().getLogin()); 
		        List<Instrumento> li = q.getResultList();
		        if(!li.isEmpty()){
		        	em.merge(inst.getSonido1());
		        	em.merge(inst.getSonido2());
		        	li.get(0).setNombre(inst.getNombre());
		        	li.get(0).setPosicion(inst.getPosicion());
		        	li.get(0).setTipo(inst.getTipo());
		        	em.merge(li.get(0));
		        	em.getTransaction().commit();
		        	em.close();
		        	res = "true";
		        }
	        }
		}
		
		return res;
	}
	
	
	public static String eliminarInstrumento(Instrumento inst, SUsuario su){
		
		String res = "false";
		
		if(inst.getUsuario().getLogin().equals(su.getUsuario().getLogin())){
			EntityManager em = factoria.createEntityManager();
	        em.getTransaction().begin();
	        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
	        q.setParameter("login", su.getUsuario().getLogin()).setParameter("password", su.getPassword());
	        List<SUsuario> lsu = q.getResultList();
	        if (!lsu.isEmpty()){
	        	SUsuario su2 = lsu.get(0);
	        	inst.setUsuario(su2.getUsuario());
	        	
	        	List<SetI> ls = consultarSetIsUser(su2.getUsuario().getLogin());
	        	
	        	 boolean b = false;
	             for (SetI seti: ls){
	              for (Instrumento i:seti.getInstrumentos()){
	               b = b || i.getIdInstrumento()==inst.getIdInstrumento();
	              }
	             }
	             
	        	if(!b){
		        	q = em.createQuery("SELECT u FROM Instrumento u WHERE u.idInstrumento = :id AND u.usuario.login = :login");
			        q.setParameter("id", inst.getIdInstrumento()).setParameter("login", inst.getUsuario().getLogin());
			        List<Instrumento> li = q.getResultList();
			        if(!li.isEmpty()){
			        	em.remove(li.get(0).getSonido1());
			        	em.remove(li.get(0).getSonido2());
			        	em.remove(li.get(0));
			        	em.getTransaction().commit();
			        	em.close();
			        	res = "true";
			        }
		        }
	        }
		}
		
		return res;
	}
	
	public static List<Instrumento> buscarInstrumentos(String nombre){
		
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Instrumento u WHERE UPPER(u.nombre) LIKE UPPER(:nombre)");
        q.setParameter("nombre", '%'+nombre+'%');
        List<Instrumento> u = q.getResultList();
        em.close();
		
        return u;
	}
	
	/*-------------------------------------
		SETS
	--------------------------------------*/
	
	public static SetI consultarSetI(Long id){
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT i FROM SetI i WHERE i.idSet = :id");
        q.setParameter("id", id);
        List<SetI> l = q.getResultList();
        em.close();

        if (l.isEmpty()) return new SetI();
        else return l.get(0);
	}
	
	public static String aniadirSetI(SetI inst, SUsuario su) {
		
		String res = "false";
		
		if(inst.getUsuario().getLogin().equals(su.getUsuario().getLogin())){
			EntityManager em = factoria.createEntityManager();
	        em.getTransaction().begin();
	        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
	        q.setParameter("login", su.getUsuario().getLogin()).setParameter("password", su.getPassword());
	        List<SUsuario> lsu = q.getResultList();
	        if (!lsu.isEmpty()){
	        	SUsuario su2 = lsu.get(0);
	        	inst.setUsuario(su2.getUsuario());
	        	em.persist(inst);
	        	em.getTransaction().commit();
	        	em.close();
	        	res = "true";
	        }
		}
		
		return res;
	}
	
	public static List<SetI> consultarSetIs() {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT i FROM SetI i");
        List<SetI> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static List<SetI> consultarSetIs(String tipo) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT i FROM SetI i WHERE i.tipo = :tipo");
        q.setParameter("tipo", tipo);
        List<SetI> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static List<SetI> consultarSetIsUser(String login) {

		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
        q.setParameter("login", login);
        Usuario u = (Usuario) q.getSingleResult();
        q = em.createQuery("SELECT i FROM SetI i WHERE i.usuario = :usuario");
        q.setParameter("usuario", u);
        List<SetI> l = q.getResultList();
        em.close();

        return l;
    }
	
	public static String eliminarSetI(SetI inst, SUsuario su){
		
		String res = "false";
		
		if(inst.getUsuario().getLogin().equals(su.getUsuario().getLogin())){
			EntityManager em = factoria.createEntityManager();
	        em.getTransaction().begin();
	        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
	        q.setParameter("login", su.getUsuario().getLogin()).setParameter("password", su.getPassword());
	        List<SUsuario> lsu = q.getResultList();
	        if (!lsu.isEmpty()){
	        	SUsuario su2 = lsu.get(0);
	        	inst.setUsuario(su2.getUsuario());
		        q = em.createQuery("SELECT u FROM SetI u WHERE u.idSet = :id");
			    q.setParameter("id", inst.getIdSet());
			    List<Instrumento> li = q.getResultList();
			        if(!li.isEmpty()){
			        	em.remove(li.get(0));
			        	em.getTransaction().commit();
			        	em.close();
			        	res = "true";
		        }
	        }
		}
		
		return res;
	}
	
	public static String modificarSetI(SetI inst, SUsuario su){
		
		String res = "false";
		
		if(inst.getUsuario().getLogin().equals(su.getUsuario().getLogin())){
			EntityManager em = factoria.createEntityManager();
	        em.getTransaction().begin();
	        Query q = em.createQuery("SELECT u FROM SUsuario u WHERE u.usuario.login = :login AND u.password = :password");
	        q.setParameter("login", su.getUsuario().getLogin()).setParameter("password", su.getPassword());
	        List<SUsuario> lsu = q.getResultList();
	        if (!lsu.isEmpty()){
	        	SUsuario su2 = lsu.get(0);
	        	inst.setUsuario(su2.getUsuario());
	        	q = em.createQuery("SELECT u FROM SetI u WHERE u.idSet = :id");
		        q.setParameter("id", inst.getIdSet());
		        if(!q.getResultList().isEmpty()){
		        	em.merge(inst);
		        	em.getTransaction().commit();
		        	em.close();
		        	res = "true";
		        }
	        }
		}
		
		return res;
	}
	
	public static List<SetI> buscarSetIs(String nombre){
		
		EntityManager em = factoria.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM SetI u WHERE UPPER(u.nombre) LIKE UPPER(:nombre)");
        q.setParameter("nombre", '%'+nombre+'%');
        List<SetI> u = q.getResultList();
        em.close();
		
        return u;
	}

}
