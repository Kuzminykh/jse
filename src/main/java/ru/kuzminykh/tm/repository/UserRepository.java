package ru.kuzminykh.tm.repository;

import ru.kuzminykh.tm.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public User create(final String login, final String password, final String firstName, final String secondName, final String middleName) {
        final User user = new User(login, password, firstName, secondName, middleName);
        users.add(user);
        return user;
    }

    public User createAsAdmin(final String login, final String userPassword, final String firstName, final String secondName, final String middleName){
        final User user = new User(login, userPassword, firstName, secondName, middleName, User.Role.ADMIN);
        users.add(user);
        return user;
    }

    public User findByLogin(final String login) {
        for (final User user: users) {
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public User update(final String login, final String password, final String firstName, final String secondName, final String middleName) {
        final User user = findByLogin(login);
        user.setHashPassword(password);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        return user;
    }

    public User removeByLogin(final String login) {
        final User user = findByLogin(login);
        if (user == null) return null;
        users.remove(user);
        return user;
    }

    public List<User> findALL() {
        return users;
    }

    public int getSize() {
        return users.size();
    }

    public void clear(){
        users.clear();
    }

}
