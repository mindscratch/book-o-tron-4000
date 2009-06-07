package bookotron.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.tag.Tag;
import bookotron.data.model.entity.impl.user.User;
import bookotron.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {

	@Override
	public Boolean deleteTag(Long id) {
		return true;
	}

	@Override
	public Tag getTag(Long id) {
		Tag tag = new Tag();
		tag.setId(id);
		tag.setAddDate(new Date());
		User user = new User();
		user.setName("username");
		tag.setAddedBy(user);
		return tag;
	}

	@Override
	public Tag updateTag(Long id, Tag updatedTag) {
		updatedTag.setId(id);
		return updatedTag;
	}

}
