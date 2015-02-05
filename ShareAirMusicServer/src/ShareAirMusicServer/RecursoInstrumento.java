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

import com.sun.jersey.spi.container.ParamQualifier;

import persistencia.*;

//Esta clase solo devuelve una instancia de la clase Todo
@Path("/instrumento")
public class RecursoInstrumento {
// Este metodo se llamara si existe una peticion XML desde el cliente
	
  @GET
  @Path("/{id}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Instrumento consultar(@PathParam("id") Long id) {
	  return Manejador.consultarInstrumento(id);
  }
  
  @POST
  @Path("/aniadir")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_XML)
  public String registrar(JAXBElement<ContenedorSUI> u) { 
	  return Manejador.aniadirInstrumento(u.getValue().getInst(),u.getValue().getSu());
  }
  
  @GET
  @Path("/all")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Instrumento> consultarInstrumentos() {
	  return Manejador.consultarInstrumentos();
  }
  
  @GET
  @Path("/tipo/{tipo}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Instrumento> consultarInstrumentos(@PathParam("tipo") String tipo) {
	  return Manejador.consultarInstrumentos(tipo);
  }
  
  @GET
  @Path("/user/{login}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Instrumento> consultarInstrumentosUser(@PathParam("login") String login) {
	  return Manejador.consultarInstrumentosUser(login);
  }
  
  @GET
  @Path("/user/{login}/{posicion}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Instrumento> consultarInstrumentosUser(@PathParam("login") String login, @PathParam("posicion") String posicion) {
	  return Manejador.consultarInstrumentosUser(login, posicion);
  }
  
  @POST
  @Path("/modificar")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_XML)
  public String modificar(JAXBElement<ContenedorSUI> u) { 
	  return Manejador.modificarInstrumento(u.getValue().getInst(),u.getValue().getSu());
  }
  
  @POST
  @Path("/eliminar")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_XML)
  public String eliminar(JAXBElement<ContenedorSUI> u) { 
	  return Manejador.eliminarInstrumento(u.getValue().getInst(),u.getValue().getSu());
  }
  
  @GET
  @Path("/buscar/{nombre}")
  @Consumes(MediaType.APPLICATION_XML)
  public List<Instrumento> buscar(@PathParam("nombre") String nombre) {
	  return Manejador.buscarInstrumentos(nombre);
  }
  
}