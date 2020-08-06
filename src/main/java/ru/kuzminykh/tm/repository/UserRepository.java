package ru.kuzminykh.tm.repository;

import ru.kuzminykh.tm.entity.Task;
import ru.kuzminykh.tm.entity.User;
import ru.kuzminykh.tm.enumerated.Role;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public User create(
            final String login, final String userPassword, final String firstName,
            final String lastName, final String middleName
    ){
        if (existsByLogin(login)) return null;
        final User user = new User(login, userPassword, firstName, lastName, middleName);
        users.add(user);
        return user;
    }

    public User create(
            final String login, final String userPassword, final String firstName,
            final String lastName, final String middleName, Role userRole
    ){
        if (existsByLogin(login)) return null;
        final User user = new User(login, userPassword, firstName, lastName, middleName, userRole);
        users.add(user);
        return user;
    }

    public boolean existsByLogin(final String login){
        final User user = findByLogin(login);
        return user != null;
    }

    public boolean existsById(final Long id){
        final User user = findById(id);
        return user != null;
    }

    public User findByIndex(final int index) {
        if (index < 0 || index > users.size() - 1) return null;
        return users.get(index);
    }

    public User findById(final Long id) {
        if (id == null) return null;
        for (final User user: users) {
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    public User findByLogin(final String login) {
        for (final User user: users) {
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public User removeByIndex(final int index) {
        final User user = findByIndex(index);
        if (user == null) return null;
        users.remove(user);
        return user;
    }

     public User removeById(final Long id) {
        final User user = findById(id);
        if (user == null) return null;
        users.remove(user);
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
