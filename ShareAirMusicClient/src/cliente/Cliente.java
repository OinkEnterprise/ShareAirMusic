package cliente;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import persistencia.*;

public class Cliente {

	static ClientConfig config = new DefaultClientConfig();
	static Client client = Client.create(config);
	static WebResource service = client.resource(getBaseURI());
	public static SUsuario su = null;
	
	/************************/
	/* FUNCIONALIDAD BÁSICA */
	/************************/
	
	private static URI getBaseURI() {
	    //return UriBuilder.fromUri("http://localhost:8080/ShareAirMusicServer/").build();
	    return UriBuilder.fromUri("http://share-airmusic.rhcloud.com/ShareAirMusicServer/").build();
	}
	
	/*************************/
	/* FUNCIONALIDAD USUARIO */
	/*************************/
	
	public static String registrarUsuario(SUsuario susu){
	    return service.path("user").path("registrar").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, susu);
	}
	
	public static String conectarUsuario(String login, String password){
		Form form = new Form();
		form.add("login", login);
		form.add("password", password);
		Usuario u = service.path("user").path("conectar").type(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_XML).post(Usuario.class, form);

		if (u.getLogin() == null){
			return "false";
		}else{
			su = new SUsuario(password, u);
			return "true";
		}
	}
	
	public static void cerrarSesion(){
		su = null;
	}
	
	public static Usuario consultarUsuario(String login){
	    return service.path("user").path(login).accept(MediaType.APPLICATION_XML).get(Usuario.class);
	}
	
	public static ArrayList<Usuario> buscarUsuarios(String nombre){
		return new ArrayList<Usuario>(Arrays.asList(service.path("user").path("buscar").path(nombre).accept(MediaType.APPLICATION_XML).get(Usuario[].class)));
	}
	
	public static String modificarUsuario(ContenedorSUSU susu ){
		if(service.path("user").path("modificar").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, susu).equals("true")){
	    	su = susu.getModificado();
	    	return "true";
	    }else{
	    	return "false";
	    }
	}
	
	/*****************************/
	/* FUNCIONALIDAD INSTRUMENTO */
	/*****************************/
	
	public static String aniadirInstrumento(ContenedorSUI i){
	    return service.path("instrumento").path("aniadir").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, i);
	}
	
	public static Instrumento consultarInstrumento(String id){
	    return service.path("instrumento").path(id).accept(MediaType.APPLICATION_XML).get(Instrumento.class);
	}
	
	public static ArrayList<Instrumento> consultarInstrumentos(){
		return new ArrayList<Instrumento>(Arrays.asList(service.path("instrumento").path("all").accept(MediaType.APPLICATION_XML).get(Instrumento[].class)));
	}
	
	public static ArrayList<Instrumento> consultarInstrumentos(String tipo){
		return new ArrayList<Instrumento>(Arrays.asList(service.path("instrumento").path("tipo").path(tipo).accept(MediaType.APPLICATION_XML).get(Instrumento[].class)));
	}
	
	public static ArrayList<Instrumento> consultarInstrumentosUser(String user){
		return new ArrayList<Instrumento>(Arrays.asList(service.path("instrumento").path("user").path(user).accept(MediaType.APPLICATION_XML).get(Instrumento[].class)));
	}
	
	public static ArrayList<Instrumento> consultarInstrumentosUser(String user,String pos){
		return new ArrayList<Instrumento>(Arrays.asList(service.path("instrumento").path("user").path(user).path(pos).accept(MediaType.APPLICATION_XML).get(Instrumento[].class)));
	 }
	
	public static ArrayList<Instrumento> buscarInstrumentos(String nombre){
		return new ArrayList<Instrumento>(Arrays.asList(service.path("instrumento").path("buscar").path(nombre).accept(MediaType.APPLICATION_XML).get(Instrumento[].class)));
	}
	
	public static String modificarInstrumento(ContenedorSUI i){
	    return service.path("instrumento").path("modificar").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, i);
	}
	
	public static String eliminarInstrumento(ContenedorSUI i){
	    return service.path("instrumento").path("eliminar").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, i);
	}
	
	/*********************/
	/* FUNCIONALIDAD SET */
	/*********************/
	
	public static SetI consultarSetI(String id){
	    return service.path("set").path(id).accept(MediaType.APPLICATION_XML).get(SetI.class);
	}
	
	public static String aniadirSetI(ContenedorSUS i){
	    return service.path("set").path("aniadir").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, i);
	}
	
	public static ArrayList<SetI> consultarSetIs(){
		return new ArrayList<SetI>(Arrays.asList(service.path("set").path("all").accept(MediaType.APPLICATION_XML).get(SetI[].class)));
	}
	
	public static ArrayList<SetI> consultarSetIs(String tipo){
		return new ArrayList<SetI>(Arrays.asList(service.path("set").path("tipo").path(tipo).accept(MediaType.APPLICATION_XML).get(SetI[].class)));
	}
	
	public static ArrayList<SetI> consultarSetIsUser(String login){
		return new ArrayList<SetI>(Arrays.asList(service.path("set").path("user").path(login).accept(MediaType.APPLICATION_XML).get(SetI[].class)));
	}
	
	public static ArrayList<SetI> buscarSetIs(String nombre){
		return new ArrayList<SetI>(Arrays.asList(service.path("set").path("buscar").path(nombre).accept(MediaType.APPLICATION_XML).get(SetI[].class)));
	}
	
	public static String modificarSetI(ContenedorSUS i){
	    return service.path("set").path("modificar").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, i);
	}
	
	public static String eliminarSetI(ContenedorSUS i){
	    return service.path("set").path("eliminar").type(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(String.class, i);
	}
	
}
