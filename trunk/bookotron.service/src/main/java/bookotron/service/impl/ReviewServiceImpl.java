package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.review.Review;
import bookotron.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	
	private IBaseDao<Review> reviewDao;
	
	
	@Autowired
	public ReviewServiceImpl(@Qualifier("reviewDao")IBaseDao<Review> reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public Boolean deleteReview(Long id) {
		Review review = reviewDao.find(id);
		reviewDao.remove(review);
		return Boolean.TRUE;
	}

	@Override
	public Review getReview(Long id) {
		return reviewDao.find(id);
	}

	@Override
	public Review updateReview(Long id, Review review) {
		review.setId(id);
		Review updatedReview = reviewDao.update(review);
		return updatedReview;
	}

}
