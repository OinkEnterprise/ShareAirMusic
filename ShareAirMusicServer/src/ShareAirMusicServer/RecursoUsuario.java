package ShareAirMusicServer;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import persistencia.*;

//Esta clase solo devuelve una instancia de la clase Todo
@Path("/user")
public class RecursoUsuario {
// Este metodo se llamara si existe una peticion XML desde el cliente
	
  @GET
  @Path("/{login}")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public Usuario consultar(@PathParam("login") String login) {
	  return Manejador.consultarUsuario(login);
  }
  
  @POST
  @Path("/registrar")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_XML)
  public String registrar(JAXBElement<SUsuario> u) { 
	  return Manejador.registrarUsuario(u.getValue());
  }
  
  @POST
  @Path("/conectar")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Usuario conectar(@FormParam("login") String login, @FormParam("password") String password) { 
	  return Manejador.conectarUsuario(login, password);
  }
  
  
  @POST
  @Path("/modificar")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_XML)
  public String modificar(JAXBElement<ContenedorSUSU> u) { 
	  return Manejador.modificarUsuario(u.getValue().getActual(),u.getValue().getModificado());
  }
  
  
  @GET
  @Path("/buscar/{nombre}")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public List<Usuario> buscar(@PathParam("nombre") String nombre) {
	  //return (Usuario[]) Manejador.buscarUsuario(nombre).toArray();
	  return Manejador.buscarUsuario(nombre);

  }
  
  
  
  
  
  
  
  
}