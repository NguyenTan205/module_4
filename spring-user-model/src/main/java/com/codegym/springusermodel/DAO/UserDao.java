package com.codegym.springusermodel.DAO;

import com.codegym.springusermodel.model.Login;
import com.codegym.springusermodel.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("john", "123456", "John", "john@codegym.vn", 18));
        users.add(new User("bill", "123456", "Bill", "bill@codegym.vn", 20));
        users.add(new User("mike", "123456", "Mike", "mike@codegym.vn", 22));
    }

    public static User checkLogin(Login login) {
        for (User user : users) {
            if (user.getPassword().equals(login.getPassword())
                    && user.getAccount().equals(login.getAccount())) {
                return user;
            }
        }
        return null;
    }
}
