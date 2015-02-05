package ShareAirMusicServer;

import java.util.List;

import javax.ws.rs.Consumes;
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
@Path("/set")
public class RecursoSet {
// Este metodo se llamara si existe una peticion XML desde el cliente
	
	// Este metodo se llamara si existe una peticion XML desde el cliente
	
	  @GET
	  @Path("/{id}")
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public SetI consultar(@PathParam("id") Long id) {
		  return Manejador.consultarSetI(id);
	  }
	  
	  @POST
	  @Path("/aniadir")
	  @Produces(MediaType.TEXT_PLAIN)
	  @Consumes(MediaType.APPLICATION_XML)
	  public String registrar(JAXBElement<ContenedorSUS> u) { 
		  return Manejador.aniadirSetI(u.getValue().getInst(),u.getValue().getSu());
	  }
	  
	  @GET
	  @Path("/all")
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<SetI> consultarSetIs() {
		  return Manejador.consultarSetIs();
	  }
	  
	  @GET
	  @Path("/tipo/{tipo}")
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<SetI> consultarSetIs(@PathParam("tipo") String tipo) {
		  return Manejador.consultarSetIs(tipo);
	  }
	  
	  @GET
	  @Path("/user/{login}")
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<SetI> consultarSetIsUser(@PathParam("login") String login) {
		  return Manejador.consultarSetIsUser(login);
	  }
	  
	  @POST
	  @Path("/modificar")
	  @Produces(MediaType.TEXT_PLAIN)
	  @Consumes(MediaType.APPLICATION_XML)
	  public String modificar(JAXBElement<ContenedorSUS> u) { 
		  return Manejador.modificarSetI(u.getValue().getInst(),u.getValue().getSu());
	  }
	  
	  @POST
	  @Path("/eliminar")
	  @Produces(MediaType.TEXT_PLAIN)
	  @Consumes(MediaType.APPLICATION_XML)
	  public String eliminar(JAXBElement<ContenedorSUS> u) { 
		  return Manejador.eliminarSetI(u.getValue().getInst(),u.getValue().getSu());
	  }
	  
	  @GET
	  @Path("/buscar/{nombre}")
	  @Consumes(MediaType.APPLICATION_XML)
	  public List<SetI> buscar(@PathParam("nombre") String nombre) {
		  return Manejador.buscarSetIs(nombre);
	  }
}