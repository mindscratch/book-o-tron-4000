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

import bookotron.data.model.entity.impl.publisher.Publisher;
import bookotron.service.PublisherService;

@Component
@Path("/publisher")
@Produces(MediaType.APPLICATION_XML)
public class PublisherResource {

	
	PublisherService publisherService;
	
	
	@Autowired
	public PublisherResource(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
    public Response createPublisher(Publisher newPublisher) {
		Publisher publisher = publisherService.createPublisher(newPublisher);
		return Response.ok().entity(publisher).build();
    }
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getPublisher(@PathParam("id") String id) {
		Publisher publisher = publisherService.getPublisher(Long.valueOf(id));
		return Response.ok().entity(publisher).build();
    }
	
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response updatePublisher(@PathParam("id") String id, Publisher updatedPublisher) {
		Publisher publisher = publisherService.updatePublisher(Long.valueOf(id), updatedPublisher);
		return Response.ok().entity(publisher).build();
    }
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteAuthor(@PathParam("id") String id) {
		publisherService.deletePublisher(Long.valueOf(id));
		return Response.ok().build();
	}
}
