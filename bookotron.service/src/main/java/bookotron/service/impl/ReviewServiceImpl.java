package bookotron.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.review.Review;
import bookotron.data.model.entity.impl.user.User;
import bookotron.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	@Override
	public Boolean deleteReview(Long id) {
		return true;
	}

	@Override
	public Review getReview(Long id) {
		Review review = new Review();
		review.setId(id);
		review.setAddDate(new Date());
		User user = new User();
		user.setName("username");
		review.setAddedBy(user);
		return review;
	}

	@Override
	public Review updateReview(Long id, Review updatedReview) {
		updatedReview.setId(id);
		return updatedReview;
	}

}
