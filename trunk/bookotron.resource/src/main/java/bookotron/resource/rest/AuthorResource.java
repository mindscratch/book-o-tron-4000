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
import bookotron.model.error.Error;
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
		Response resultResponse;
		try {
			Author result = authorService.createAuthor(author);
			resultResponse = Response.ok().entity(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getAuthor(@PathParam("id") String id) {
		Response resultResponse;
		try {
			Author author = authorService.getAuthor(Long.valueOf(id));
			resultResponse = Response.ok().entity(author).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateAuthor(@PathParam("id") String id, Author author) {
		Response resultResponse;
		try {
			Author updatedAuthor = authorService.updateAuthor(Long.valueOf(id),author);
			resultResponse = Response.ok().entity(updatedAuthor).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@DELETE
	@Path("/{id}")
	public Response deleteAuthor(@PathParam("id") String id) {
		Response resultResponse;
		try {
			authorService.deleteAuthor(Long.valueOf(id));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

}
