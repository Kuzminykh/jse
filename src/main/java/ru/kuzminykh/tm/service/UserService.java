package ru.kuzminykh.tm.service;

import ru.kuzminykh.tm.entity.User;
import ru.kuzminykh.tm.repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(final String login, final String password, final String firstName, final String secondName, final String middleName) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (secondName == null || secondName.isEmpty()) return null;
        if (middleName == null || middleName.isEmpty()) return null;
        return userRepository.create(login, password, firstName, secondName, middleName);
    }

    public User createAsAdmin(String login, String password, String firstName, String secondName, String middleName) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (secondName == null || secondName.isEmpty()) return null;
        if (middleName == null || middleName.isEmpty()) return null;
        return userRepository.createAsAdmin(login, password, firstName, secondName, middleName);
    }

    public User findByLogin(String login) {
        if (login == null || login.isEmpty()) return null;
        return userRepository.findByLogin(login);
    }

    public User update(String login, String password, String firstName, String secondName, String middleName) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (secondName == null || secondName.isEmpty()) return null;
        if (middleName == null || middleName.isEmpty()) return null;
        return userRepository.update(login, password, firstName, secondName, middleName);
    }

    public User removeByLogin(String login) {
        if (login == null || login.isEmpty()) return null;
        return userRepository.removeByLogin(login);
    }

    public List<User> findALL() {
        return userRepository.findALL();
    }

    public int getSize() {
        return userRepository.getSize();
    }

    public void clear() {
        userRepository.clear();
    }

}
