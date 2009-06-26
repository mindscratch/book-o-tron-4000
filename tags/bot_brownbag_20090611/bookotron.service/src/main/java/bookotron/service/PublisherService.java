package bookotron.service;

import bookotron.data.model.entity.impl.publisher.Publisher;

public interface PublisherService {

	
	public Publisher getPublisher(Long id);
	
	public Publisher createPublisher(Publisher newPublisher);
	
	public Publisher updatePublisher(Long id, Publisher publisher);
	
	public Boolean deletePublisher(Long id);
}
