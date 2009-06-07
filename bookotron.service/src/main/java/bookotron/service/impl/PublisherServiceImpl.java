package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.publisher.Publisher;
import bookotron.service.PublisherService;

@Service("publisherService")
public class PublisherServiceImpl implements PublisherService {

	private IBaseDao<Publisher> publisherDao;
	
	
	@Autowired
	public PublisherServiceImpl(@Qualifier("publisherDao")IBaseDao<Publisher> publisherDao) {
		this.publisherDao = publisherDao;
	}
	
	
	@Override
	public Publisher createPublisher(Publisher newPublisher) {
		return publisherDao.insert(newPublisher);
	}

	@Override
	public Boolean deletePublisher(Long id) {
		Publisher publisher = publisherDao.find(id);
		publisherDao.remove(publisher);
		return Boolean.TRUE;
	}

	@Override
	public Publisher getPublisher(Long id) {
		return publisherDao.find(id);
	}

	@Override
	public Publisher updatePublisher(Long id, Publisher publisher) {
		publisher.setId(id);
		Publisher updatedPublisher = publisherDao.update(publisher);
		return updatedPublisher;
	}

}
