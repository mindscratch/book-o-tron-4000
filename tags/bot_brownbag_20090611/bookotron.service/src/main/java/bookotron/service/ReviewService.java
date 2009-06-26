package bookotron.service;

import bookotron.data.model.entity.impl.review.Review;

public interface ReviewService {

	public Review getReview(Long id);
	
	public Review updateReview(Long id, Review review);
	
	public Boolean deleteReview(Long id);
	
}
