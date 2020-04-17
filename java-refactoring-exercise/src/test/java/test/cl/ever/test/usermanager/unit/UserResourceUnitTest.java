package test.cl.ever.test.usermanager.unit;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import cl.ever.test.usermanager.User;
import cl.ever.test.usermanager.UserDao;
import cl.ever.test.usermanager.web.UserResource;
import junit.framework.Assert;

public class UserResourceUnitTest {

    UserResource userResource;
    UserDao userDao;

    @Before
    public void before() {
    	
    }
    	
    
    @Test
    public void getUsersTest() {
    	userResource = new UserResource();
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("fake user");
        user.setEmail("fake@user.com");
        userDao.saveUser(user);
        Response response = userResource.getUsers();
        Assert.assertEquals(200, response.getStatus());
    }
}
