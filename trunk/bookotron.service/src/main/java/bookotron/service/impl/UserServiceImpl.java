package bookotron.service.impl;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.user.User;
import bookotron.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User createUser(User newUser) {
		User user = new User();
		user.setId(0);
		user.setName("username");
		return user;
	}

	@Override
	public Boolean deleteUser(Long id) {
		return true;
	}

	@Override
	public User getUser(Long id) {
		User user = new User();
		user.setId(id);
		user.setName("username");
		user.setId(id);
		return user;
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		updatedUser.setId(id);
		return updatedUser;
	}

}
