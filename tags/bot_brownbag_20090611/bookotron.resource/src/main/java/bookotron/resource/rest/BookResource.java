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
import bookotron.model.error.Error;
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
		Response resultResponse;
		try {
			BookTextContent book = bookService.getTextBook(Long.valueOf(id));
			book.setAcquiredDate(new Date());
			book.setDeleted(false);
			book.setEdition("new edition");
			resultResponse = Response.ok().entity(book).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@GET
	@Path("/pdf/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPdfBook(@PathParam("id") String id) {
		Response resultResponse;
		try {

			PdfTextContent book = bookService.getPdfBook(Long.valueOf(id));
			resultResponse = Response.ok().entity(book).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@POST
	@Path("/text")
	@Produces(MediaType.APPLICATION_XML)
	public Response createTextBook(BookTextContent book) {
		Response resultResponse;
		try {

			BookTextContent result = bookService.createTextBook(book);
			resultResponse = Response.ok().entity(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@POST
	@Path("/pdf")
	@Produces(MediaType.APPLICATION_XML)
	public Response createPdfBook(PdfTextContent book) {
		Response resultResponse;
		try {
			PdfTextContent result = bookService.createPdfBook(book);
			resultResponse = Response.ok().entity(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@POST
	@Path("/pdf/{book_id}/checkout/{user_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response checkOutPdfBook(@PathParam("book_id") String bookId,
			@PathParam("user_id") String userId) {
		Response resultResponse;
		try {
			bookService.checkOutPdfBook(Long.valueOf(bookId), Long
					.valueOf(userId));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@POST
	@Path("/text/{book_id}/checkout/{user_id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response checkOutTextBook(@PathParam("book_id") String bookId,
			@PathParam("user_id") String userId) {
		Response resultResponse;
		try {
			bookService.checkOutTextBook(Long.valueOf(bookId), Long
					.valueOf(userId));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@PUT
	@Path("/text/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateTextBook(@PathParam("id") String id,
			BookTextContent book) {
		Response resultResponse;
		try {

			BookTextContent result = bookService.updateTextBook(Long
					.valueOf(id), book);
			resultResponse = Response.ok().entity(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@PUT
	@Path("/pdf/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updatePdfBook(@PathParam("id") String id,
			PdfTextContent book) {
		Response resultResponse;
		try {
			PdfTextContent result = bookService.updatePdfBook(Long.valueOf(id),
					book);
			resultResponse = Response.ok().entity(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@DELETE
	@Path("/text/{id}")
	public Response deleteTextBook(@PathParam("id") String id) {
		Response resultResponse;
		try {
			bookService.deleteTextBook(Long.valueOf(id));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@DELETE
	@Path("/pdf/{id}")
	public Response deletePdfBook(@PathParam("id") String id) {
		Response resultResponse;
		try {
			bookService.deleteTextBook(Long.valueOf(id));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}
}
