package bookotron.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.author.Author;
import bookotron.data.model.entity.impl.user.User;
import bookotron.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Override
	public Author createAuthor(Author newAuthor) {
		newAuthor.setId(0);
		return newAuthor;
	}

	@Override
	public Boolean deleteAuthor(Long id) {
		return true;
	}

	@Override
	public Author getAuthor(Long id) {
		Author author = new Author();
		author.setId(id);
		author.setAddDate(new Date());
		User user = new User();
		user.setName("username");
		author.setAddedBy(user);
		User modifiedByUser = new User();
		modifiedByUser.setName("username");
		author.setModifiedBy(modifiedByUser);
		return author;
	}

	@Override
	public Author updateAuthor(Long id, Author updatedAuthor) {
		updatedAuthor.setId(id);
		return updatedAuthor;
	}

}
