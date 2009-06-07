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

import bookotron.data.model.entity.impl.comment.Comment;
import bookotron.service.CommentService;

@Component
@Path("/comment")
public class CommentResource {

	
	CommentService commentService;
	
	
	@Autowired
	public CommentResource(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response getComment(@PathParam("id") String id) {
		Comment comment = commentService.getComment(Long.valueOf(id));
		return Response.ok().entity(comment).build();
    }
	
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
    public Response updateComment(@PathParam("id") String id, Comment comment) {
		Comment updatedComment = commentService.updateComment(Long.valueOf(id), comment);
		return Response.ok(updatedComment).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteComment(@PathParam("id") String id) {
		commentService.deleteComment(Long.valueOf(id));
		return Response.ok().build();
	}
}
