package servlet;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.AutoreDao;
import dao.LibroDao;
import model.Libro;
import model.Autore;


@Stateless

@Path("rest")
public class RestController {

	@Inject
	private AutoreDao autoreDao;
	
	@Inject
	private LibroDao libroDao;


	// --- http://localhost:8080/progettoejb2/api/rest/all ---
	// http protocollo /locale/ nome maven /nome server(in rest) /nome path all'inizio classe/ nome metodo
	// 127.0.0.1 : dove risiede il mio server
	// 8080 porta default di esposizione protocollo application server
	// progettoEjb2 = nome progetto definito in maven
	// api = servlet
	// rest = ejb contenitore di servizi esposti
	// all = il nome del metodo
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("{id}") //variabile {}
	public Autore getById(@PathParam("id") int id) {
		return autoreDao.get(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("allAutori") //variabile {}
	public List<Autore> getEvryone() {
		return autoreDao.getAll();
	}
	
	// creare il metodo per ottenere TUTTI i libri
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("allLibri") //variabile {}
	public List<Libro> getAllLibri() {
		return libroDao.getAll();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("insertAutore")
	public String insertPadrone(
			@QueryParam("eta") int eta,
			@QueryParam("nome") String nome, 
			@QueryParam("cognome") String cognome,
			@QueryParam("id") String id) {
		autoreDao.save(
				cognome,
				nome, 
				eta, 
				Integer.parseInt(id));
		return "Insert finished with success!";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("insertAutore")
	public Autore insertAutore(Autore nuovoAutore) {
		autoreDao.save(nuovoAutore);
		return nuovoAutore;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("insertLibro")
	public Autore insertLibro(Autore nuovoLibro) {
		LibroDao.save(nuovoLibro);
		return nuovoLibro;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("generaTreAutori")
	public List<Autore> generaPadrones(){
		AtomicInteger count = new AtomicInteger(1);
		Autore aut1 = new Autore();
		List<Autore> autoriList = Arrays
				.asList(new Autore(),
						new Autore(),
						new Autore());
		autoriList.stream()
		.forEach(persona -> {
			persona.setNome("nome"+count.get());
			persona.setCognome("cognome"+count.getAndIncrement());

		});
		aut1.setCognome("asd");
		aut1.setNome("das");
		aut1.setId(3);
		autoriList.stream()
		.forEach(persona ->{
			autoreDao.save(persona);
		});
		//


		//terzo inserimento illegale test
		return autoriList;
	}
	
}
