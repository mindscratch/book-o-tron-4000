package bookotron.service;

import bookotron.data.model.entity.impl.tag.Tag;

public interface TagService {

	public Tag getTag(Long id);
	
	public Tag updateTag(Long id, Tag updatedTag);
	
	public Boolean deleteTag(Long id);
}
