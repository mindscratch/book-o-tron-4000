package bookotron.resource.rest;

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
import org.springframework.stereotype.Component;

import bookotron.data.model.entity.impl.author.Author;
import bookotron.service.AuthorService;

@Component
@Path("/author")
public class AuthorResource {

	private AuthorService authorService;
	
	
	@Autowired
	public AuthorResource(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Response createAuthor(Author author) {
		
		Author result = authorService.createAuthor(author);
		return Response.ok().entity(result).build();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getAuthor(@PathParam("id") String id) {
		Author author = authorService.getAuthor(Long.valueOf(id));
		return Response.ok().entity(author).build();
    }
	
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response updateAuthor(@PathParam("id") String id, Author author) {
		Author updatedAuthor = authorService.updateAuthor(Long.valueOf(id), author);
		return Response.ok().entity(updatedAuthor).build();
    }
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteAuthor(@PathParam("id") String id) {
		authorService.deleteAuthor(Long.valueOf(id));
		return Response.ok().build();
	}
	
	
	
	
}
