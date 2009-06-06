package bookotron.resource.rest;

import java.net.URISyntaxException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookotron.data.model.entity.impl.content.text.book.BookTextContent;
import bookotron.service.BookService;




@Component
@Path("/book")
public class BookResource {

	@Autowired
	BookService bookService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getBook(@PathParam("id") String id) throws URISyntaxException {
		
		BookTextContent book = bookService.getBook(Long.valueOf(id));
		return Response.ok().entity(book).build();
    }
	
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Response createBook(BookTextContent book) {
		
		return Response.ok().entity(book).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateBook(@PathParam("id") String id, BookTextContent book) {
		
		return Response.ok().entity(book).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteBook(@PathParam("id") String id) {
		return Response.ok().build();
	}
}
