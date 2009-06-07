package bookotron.service;

import bookotron.data.model.entity.impl.comment.Comment;

public interface CommentService {

	
	public Comment getComment(Long id);
	
	public Comment updateComment(Long id, Comment comment);
	
	public Boolean deleteComment(Long id);
}
