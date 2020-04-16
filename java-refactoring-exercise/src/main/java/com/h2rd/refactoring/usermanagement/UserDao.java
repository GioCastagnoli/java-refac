package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {

    private List<User> users;

    private static UserDao userDao;
    private static Logger logger = LogManager.getLogger(UserDao.class);

    public static UserDao getUserDao() {
    	logger.warn("getUserDao");
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public void saveUser(User user) {
    	logger.info("saveUser");
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(user);
    }

    public List<User> getUsers() {
    	logger.info("getUsers");
        try {
            return users;
        } catch (Throwable e) {
            System.out.println("error");
            return null;
        }
    }

    public void deleteUser(User userToDelete) {
    	logger.info("deleteUser");
        try {
            for (User user : users) {
                if (user.getName() == userToDelete.getName()) {
                    users.remove(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User userToUpdate) {
    	logger.info("updateUser");
        try {
            for (User user : users) {
                if (user.getName() == userToUpdate.getName()) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public User findUser(String name) {
    	logger.info("findUser");
        try {
            for (User user : users) {
                if (user.getName() == name) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
