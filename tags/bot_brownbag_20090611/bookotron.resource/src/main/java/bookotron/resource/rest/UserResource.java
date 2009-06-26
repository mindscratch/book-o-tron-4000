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

import bookotron.data.model.entity.impl.user.User;
import bookotron.model.error.Error;
import bookotron.service.UserService;

@Component
@Path("/user")
public class UserResource {

	UserService userService;

	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Response createUser(User user) {
		Response resultResponse;
		try {
			User result = userService.createUser(user);
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
	public Response getUser(@PathParam("id") String id) {
		Response resultResponse;
		try {
			User result = userService.getUser(Long.valueOf(id));
			resultResponse = Response.ok(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateUser(@PathParam("id") String id, User user) {
		Response resultResponse;
		try {
			User result = userService.updateUser(Long.valueOf(id), user);
			resultResponse = Response.ok(result).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteUser(@PathParam("id") String id) {
		Response resultResponse;
		try {
			userService.deleteUser(Long.valueOf(id));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

}
