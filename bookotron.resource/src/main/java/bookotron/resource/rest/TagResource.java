package bookotron.resource.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookotron.data.model.entity.impl.tag.Tag;
import bookotron.service.TagService;


@Component
@Path("/tag")
@Produces(MediaType.APPLICATION_XML)
public class TagResource {
	
	
	TagService tagService;
	
	
	@Autowired
	public TagResource(TagService tagService) {
		this.tagService = tagService;
	}

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getTag(@PathParam("id") String id) {
		Tag tag = tagService.getTag(Long.valueOf(id));
		return Response.ok().entity(tag).build();
    }
	
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response updateTag(@PathParam("id") String id, Tag tag) {
		Tag updatedTag = tagService.updateTag(Long.valueOf(id), tag);
		return Response.ok(updatedTag).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteTag(@PathParam("id") String id) {
		tagService.deleteTag(Long.valueOf(id));
		return Response.ok().build();
	}
}
