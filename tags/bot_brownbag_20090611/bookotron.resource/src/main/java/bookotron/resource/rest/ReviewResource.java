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

import bookotron.data.model.entity.impl.review.Review;
import bookotron.model.error.Error;
import bookotron.service.ReviewService;

@Component
@Path("/review")
@Produces(MediaType.APPLICATION_XML)
public class ReviewResource {

	ReviewService reviewService;

	@Autowired
	public ReviewResource(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getReview(@PathParam("id") String id) {
		Response resultResponse;
		try {
			Review review = reviewService.getReview(Long.valueOf(id));
			resultResponse = Response.ok().entity(review).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateReview(@PathParam("id") String id, Review review) {
		Response resultResponse;
		try {
			Review updatedreview = reviewService.updateReview(Long.valueOf(id),
					review);
			resultResponse = Response.ok(updatedreview).build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

	@DELETE
	@Path("/{id}")
	public Response deleteReview(@PathParam("id") String id) {
		Response resultResponse;
		try {
			reviewService.deleteReview(Long.valueOf(id));
			resultResponse = Response.ok().build();
		} catch (Exception e) {
			Error error = new Error("Server error...");
			resultResponse = Response.serverError().entity(error).build();
		}
		return resultResponse;
	}

}
