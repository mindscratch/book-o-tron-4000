package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.tag.Tag;
import bookotron.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {

	private IBaseDao<Tag> tagDao;
	
	
	@Autowired
	public TagServiceImpl(@Qualifier("tagDao")IBaseDao<Tag> tagDao) {
		this.tagDao = tagDao;
	}
	
	
	@Override
	public Boolean deleteTag(Long id) {
		Tag tag = tagDao.find(id);
		tagDao.remove(tag);
		return Boolean.TRUE;
	}

	@Override
	public Tag getTag(Long id) {
		return tagDao.find(id);
	}

	@Override
	public Tag updateTag(Long id, Tag tag) {
		Tag updatedTag = tagDao.update(tag);
		return updatedTag;
	}

}
