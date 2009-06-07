package bookotron.resource.rest;

import java.util.Date;

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

import bookotron.data.model.entity.impl.content.text.book.BookTextContent;
import bookotron.data.model.entity.impl.content.text.pdf.PdfTextContent;
import bookotron.service.BookService;


@Component
@Path("/book")
public class BookResource {

	BookService bookService;
	
	
	@Autowired
	public BookResource(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GET
	@Path("/text/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getTextBook(@PathParam("id") String id) {
		
		BookTextContent book = bookService.getTextBook(Long.valueOf(id));
		book.setAcquiredDate(new Date());
		book.setDeleted(false);
		book.setEdition("new edition");
		return Response.ok().entity(book).build();
    }
	
	
	@GET
	@Path("/pdf/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getPdfBook(@PathParam("id") String id) {
		
		PdfTextContent book = bookService.getPdfBook(Long.valueOf(id));
		return Response.ok().entity(book).build();
    }
	
	
	@POST
	@Path("/text")
	@Produces(MediaType.APPLICATION_XML)
	public Response createTextBook(BookTextContent book) {
		
		BookTextContent result = bookService.createTextBook(book);
		return Response.ok().entity(result).build();
	}
	
	
	@POST
	@Path("/pdf")
	@Produces(MediaType.APPLICATION_XML)
	public Response createPdfBook(PdfTextContent book) {
		PdfTextContent result = bookService.createPdfBook(book);
		return Response.ok().entity(result).build();
	}
	
	
	@PUT
	@Path("/text/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateTextBook(@PathParam("id") String id, BookTextContent book) {
		
		BookTextContent result = bookService.updateTextBook(Long.valueOf(id), book);
		return Response.ok().entity(result).build();
	}
	
	
	@PUT
	@Path("/pdf/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updatePdfBook(@PathParam("id") String id, PdfTextContent book) {
		PdfTextContent result = bookService.updatePdfBook(Long.valueOf(id), book);
		return Response.ok().entity(result).build();
	}
	
	
	@DELETE
	@Path("/text/{id}")
	public Response deleteTextBook(@PathParam("id") String id) {
		bookService.deleteTextBook(Long.valueOf(id));
		return Response.ok().build();
	}
	
	
	@DELETE
	@Path("/pdf/{id}")
	public Response deletePdfBook(@PathParam("id") String id) {
		bookService.deleteTextBook(Long.valueOf(id));
		return Response.ok().build();
	}
}
