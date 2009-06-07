package bookotron.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.comment.Comment;
import bookotron.data.model.entity.impl.user.User;
import bookotron.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Override
	public Boolean deleteComment(Long id) {
		return true;
	}

	@Override
	public Comment getComment(Long id) {
		Comment comment = new Comment();
		comment.setId(id);
		comment.setAddDate(new Date());
		User user = new User();
		user.setName("username");
		comment.setAddedBy(user);
		return comment;
	}

	@Override
	public Comment updateComment(Long id, Comment updatedComment) {
		updatedComment.setId(id);
		return updatedComment;
	}

	
	
}
