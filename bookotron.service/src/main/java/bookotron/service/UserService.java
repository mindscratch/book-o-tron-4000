package bookotron.service;

import bookotron.data.model.entity.impl.user.User;

public interface UserService {

	public User getUser(Long id);
	
	public User createUser(User newUser);
	
	public User updateUser(Long id, User updatedUser);
	
	public Boolean deleteUser(Long id);
}
