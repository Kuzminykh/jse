package ru.kuzminykh.tm.entity;


import ru.kuzminykh.tm.enumerated.Role;
import ru.kuzminykh.tm.utils.HashMD5;

public class User {

    private Long id = System.nanoTime();

    private String login;

    private String hashPassword;

    private String firstName = "";

    private String lastName = "";

    private String middleName = "";

    private Role userRole = Role.USER;

    public User() {
    }

    public User(final String login, final String userPassword, final String firstName,
                final String lastName, final String middleName, final Role userRole

    ) {
        this.login = login;
        this.hashPassword = HashMD5.getHash(userPassword);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.userRole = userRole;
    }

    public User(final String login, final String userPassword, final String firstName,
                final String lastName, final String middleName
    ) {
        this.login = login;
        this.hashPassword = HashMD5.getHash(userPassword);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = HashMD5.getHash(hashPassword);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fisrtName) {
        this.firstName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return login;
    }

}
