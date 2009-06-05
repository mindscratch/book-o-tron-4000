package bookotron.resource.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.activation.MimeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.content.text.book.BaseBookTextContent;

@Path("/book")
@Service
@Scope("request")
public class BookResource {

	
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public Response getBook() throws URISyntaxException {
		BaseBookTextContent book = new BaseBookTextContent();
		book.setId(Long.valueOf(1));
		
		return Response.ok().entity(book).build();
    }
}
