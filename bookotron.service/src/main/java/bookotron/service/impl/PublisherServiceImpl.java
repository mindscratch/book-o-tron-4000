package bookotron.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.publisher.Publisher;
import bookotron.data.model.entity.impl.user.User;
import bookotron.service.PublisherService;

@Service("publisherService")
public class PublisherServiceImpl implements PublisherService {

	@Override
	public Publisher createPublisher(Publisher newPublisher) {
		newPublisher.setId(0);
		return newPublisher;
	}

	@Override
	public Boolean deletePublisher(Long id) {
		return true;
	}

	@Override
	public Publisher getPublisher(Long id) {
		Publisher publisher = new Publisher();
		publisher.setId(id);
		publisher.setAddDate(new Date());
		User user = new User();
		user.setName("username");
		publisher.setAddedBy(user);
		return publisher;
	}

	@Override
	public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
		updatedPublisher.setId(id);
		return updatedPublisher;
	}

}
