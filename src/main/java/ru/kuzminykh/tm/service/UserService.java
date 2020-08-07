package ru.kuzminykh.tm.service;

import ru.kuzminykh.tm.entity.User;
import ru.kuzminykh.tm.enumerated.Role;
import ru.kuzminykh.tm.repository.UserRepository;
import ru.kuzminykh.tm.utils.HashMD5;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public User user;

    private Long userLogInId;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(final String login, final String password, final String firstName,
                       final String lastName, final String middleName
    ) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (lastName == null || lastName.isEmpty()) return null;
        if (middleName == null || middleName.isEmpty()) return null;
        return userRepository.create(login, HashMD5.getHash(password), firstName, lastName, middleName);
    }

    public User create(String login, String password, String firstName,
                       String lastName, String middleName, Role userRole
    ) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        if (firstName == null || firstName.isEmpty()) return null;
        if (lastName == null || lastName.isEmpty()) return null;
        if (middleName == null || middleName.isEmpty()) return null;
        return userRepository.create(login, HashMD5.getHash(password), firstName, lastName, middleName, userRole);
    }

     public User update(Long id, String login, String password, String firstName, String lastName, String middleName) {
        final User user = findById(id);
        if (user == null) return null;
        user.setLogin(login);
        user.setHashPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        return user;
    }

    public User removeByIndex(int index) {
        return userRepository.removeByIndex(index);
    }

    public User removeById(Long id) {
        if (id == null) return null;
        return userRepository.removeById(id);
    }

    public User removeByLogin(String login) {
        if (login == null || login.isEmpty()) return null;
        return userRepository.removeByLogin(login);
    }

    public User userLogIn(String login, String userPassword) {
        User user = userRepository.findByLogin(login);
        if (user == null) return null;
        if (!user.getHashPassword().equals(HashMD5.getHash(userPassword))) return null;
        this.user = user;
        this.setUserLogInId(user.getId());
        System.out.println(" ");
        System.out.println("Welcome " + user.getFirstName() + " " +user.getLastName() + " " + user.getMiddleName());
        System.out.println(" ");
        return user;
    }

    public void userLogOut(){
        this.userLogInId = null;
        this.user = null;
    }

    public User userChangePassword(String login, String userOldPassword, String userNewPassword) {
        User user = userRepository.findByLogin(login);
        if (user == null) return null;
        if (!user.getHashPassword().equals(HashMD5.getHash(userOldPassword))) return null;
        user.setHashPassword(userNewPassword);
        return user;
    }

    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public User findByIndex(int index) {
        return userRepository.findByIndex(index);
    }

    public User findById(Long id) {
        if (id == null) return null;
        return userRepository.findById(id);
    }

    public User findByLogin(String login) {
        if (login == null || login.isEmpty()) return null;
        return userRepository.findByLogin(login);
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

    public Long getUserLogInId() {
        return userLogInId;
    }

    public void setUserLogInId(Long userLogInId) {
        this.userLogInId = userLogInId;
    }

}
