package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.user.User;
import bookotron.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private IBaseDao<User> userDao;
	
	
	@Autowired
	public UserServiceImpl(@Qualifier("userDao")IBaseDao<User> userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User createUser(User newUser) {
		User user = userDao.insert(newUser);
		return user;
	}

	@Override
	public Boolean deleteUser(Long id) {
		User user = userDao.find(id);
		userDao.remove(user);
		return Boolean.TRUE;
	}

	@Override
	public User getUser(Long id) {
		return userDao.find(id);
	}

	@Override
	public User updateUser(Long id, User user) {
		user.setId(id);
		User updatedUser = userDao.update(user);
		return updatedUser;
	}

}
