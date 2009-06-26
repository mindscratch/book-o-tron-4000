package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.author.Author;
import bookotron.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private IBaseDao<Author> authorDao;

    
    @Autowired
	public AuthorServiceImpl(@Qualifier("authorDao")IBaseDao<Author> authorDao) {
		this.authorDao = authorDao;
	}
	
	@Override
	public Author createAuthor(Author newAuthor) {
		Author createdAuthor = authorDao.insert(newAuthor);
		return createdAuthor;
	}

	@Override
	public Boolean deleteAuthor(Long id) {
		Author author = authorDao.find(id);
		authorDao.remove(author);
		return Boolean.TRUE;
	}

	@Override
	public Author getAuthor(Long id) {
		Author author = authorDao.find(id);
		return author;
	}

	@Override
	public Author updateAuthor(Long id, Author updatedAuthor) {
		updatedAuthor.setId(id);
		Author author = authorDao.update(updatedAuthor);
		return author;
	}

}
