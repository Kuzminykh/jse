package ru.kuzminykh.tm.entity;


import ru.kuzminykh.tm.enumerated.RoleEnam;
import ru.kuzminykh.tm.utils.MD5Hash;

public class User {

    private String login = "";

    private String hashPassword = "";

    private String firstName = "";

    private String secondName = "";

    private String middleName = "";

    private RoleEnam.Role userRole;

    public User() {
    }

   public User(String login, String password, String firstName, String secondName, String middleName, RoleEnam.Role userRole) {
        this.login = login;
        this.hashPassword = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.userRole = userRole;
    }

    public User(final String login, final String password, final String firstName, final String secondName, final String middleName) {
        this.login = login;
        this.hashPassword = MD5Hash.getHash(password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.userRole = RoleEnam.Role.USER;
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
        this.hashPassword = MD5Hash.getHash(hashPassword);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fisrtName) {
        this.firstName = fisrtName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public RoleEnam.Role getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleEnam roleEnam) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return login;
    }

}
