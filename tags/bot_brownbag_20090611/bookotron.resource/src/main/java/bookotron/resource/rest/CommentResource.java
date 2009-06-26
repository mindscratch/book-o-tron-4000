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
import bookotron.model.error.Error;
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
		Response resultResponse;
		try {
			Comment comment = commentService.getComment(Long.valueOf(id));
			resultResponse = Response.ok().entity(comment).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateComment(@PathParam("id") String id, Comment comment) {
		Response resultResponse;
		try {
			Comment updatedComment = commentService.updateComment(Long
					.valueOf(id), comment);
			resultResponse = Response.ok(updatedComment).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@DELETE
	@Path("/{id}")
	public Response deleteComment(@PathParam("id") String id) {
		Response resultResponse;
		try {
			commentService.deleteComment(Long.valueOf(id));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}
}
