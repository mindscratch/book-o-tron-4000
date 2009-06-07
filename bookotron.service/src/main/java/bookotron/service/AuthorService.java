package bookotron.service;

import bookotron.data.model.entity.impl.author.Author;

public interface AuthorService {

	public Author getAuthor(Long id);
	
	public Author createAuthor(Author newAuthor);
	
	public Author updateAuthor(Long id, Author updatedAuthor);
	
	public Boolean deleteAuthor(Long id);
}
