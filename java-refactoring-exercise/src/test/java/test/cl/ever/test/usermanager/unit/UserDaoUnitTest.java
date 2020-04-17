package test.cl.ever.test.usermanager.unit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import cl.ever.test.usermanager.User;
import cl.ever.test.usermanager.UserDao;

public class UserDaoUnitTest {

	UserDao userDao;

	@Before
	public void before() {
		userDao = UserDao.getUserDao();
	}

	@Test
	public void saveUserTest() {
		

		User user = new User();
		user.setName("Fake Name");
		user.setEmail("fake@email.com");
		user.setRoles(Arrays.asList("admin", "master"));

		userDao.saveUser(user);
		
		assertTrue(userDao.getUsers().contains(user));
	}

	@Test
	public void deleteUserTest() {
		//userDao = UserDao.getUserDao();

		User user = new User();
		user.setName("Fake Name");
		user.setEmail("fake@email.com");
		user.setRoles(Arrays.asList("admin", "master"));

		try {
			userDao.deleteUser(user);
		} catch (NullPointerException e) {
			System.err.println("" + e);
		}
	}
}