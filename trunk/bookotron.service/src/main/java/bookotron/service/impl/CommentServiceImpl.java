package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.comment.Comment;
import bookotron.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	private IBaseDao<Comment> commentDao;
	
	@Autowired
	public CommentServiceImpl(@Qualifier("commentDao")IBaseDao<Comment> commentDao) {
		this.commentDao = commentDao;
	}
	
	
	@Override
	public Boolean deleteComment(Long id) {
		Comment comment = commentDao.find(id);
		commentDao.remove(comment);
		return Boolean.TRUE;
	}

	@Override
	public Comment getComment(Long id) {
		return commentDao.find(id);
	}

	@Override
	public Comment updateComment(Long id, Comment comment) {
		comment.setId(id);
		Comment updatedComment = commentDao.update(comment);
		return updatedComment;
	}

	
	
}
