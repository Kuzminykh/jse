package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.entity.User;
import ru.kuzminykh.tm.enumerated.Role;
import ru.kuzminykh.tm.service.UserService;
import ru.kuzminykh.tm.utils.HashMD5;

import java.util.Arrays;

public class UserController extends AbstractController {

    private final UserService userService;

    public User user;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public int createUser() {
        System.out.println("[CREATE USER]");
        System.out.println("Please, enter user login:");
        final String login = scanner.nextLine();
        System.out.println("Please, enter password:");
        final String password = scanner.nextLine();
        System.out.println("Please, enter first name:");
        final String firstName = scanner.nextLine();
        System.out.println("Please, enter last name:");
        final String secondName = scanner.nextLine();
        System.out.println("Please, enter middle name:");
        final String middleName = scanner.nextLine();
        userService.create(login, password, firstName, secondName, middleName);
        System.out.println("[OK]");
        return 0;
    }

    public int createUser(Role userRole) {
        System.out.println("[CREATE USER Role]");
        System.out.println("Please, enter user login:");
        final String login = scanner.nextLine();
        System.out.println("Please, enter user password:");
        final String password = scanner.nextLine();
        System.out.println("Please, enter user first name:");
        final String firstName = scanner.nextLine();
        System.out.println("Please, enter user last name:");
        final String lastName = scanner.nextLine();
        System.out.println("Please, enter user middle name:");
        final String middleName = scanner.nextLine();
        userService.create(login, password, firstName, lastName, middleName, userRole);
        System.out.println("[OK]");
        return 0;
    }

    public void updateUser(User user){
        System.out.println("Please, enter user login:");
        final String login = scanner.nextLine();
        System.out.println("Please, enter user password:");
        final String password = scanner.nextLine();
        System.out.println("Please, enter user first name");
        final String firstName = scanner.nextLine();
        System.out.println("Please, enter user last name");
        final String lastName = scanner.nextLine();
        System.out.println("Please, enter user middle name");
        final String middleName = scanner.nextLine();
        userService.update(user.getId(), login, password, firstName, lastName, middleName);
        System.out.println("[OK]");
    }


    public int updateUserByIndex(){
        System.out.println("[UPDATE USER]");
        System.out.println("Please, enter user index:");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("FAIL! IT'S NOT NUMBER");
            return -1;
        }
        final int index = scanner.nextInt() - 1;
        scanner.nextLine();
        final User user = userService.findByIndex(index);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateUser(user);
        return 0;
    }

    public int updateUserById(){
        System.out.println("[UPDATE USER]");
        System.out.println("Please, enter user id:");
        final long id = Long.parseLong(scanner.nextLine());
        final User user = userService.findById(id);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateUser(user);
        return 0;
    }

    public int updateUserBylogin() {
        System.out.println("[UPDATE USER LOGIN]");
        System.out.println("Enter, user login");
        final String login = scanner.nextLine();
        final User user = userService.findByLogin(login);
        if (login == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        updateUser(user);
        return 0;
    }

    public int removeUserByIndex() {
        System.out.println("[REMOVE USER BY INDEX]");
        System.out.println("Please, enter user index:");
        final int index = scanner.nextInt() - 1;
        final User user = userService.removeByIndex(index);
        if (user == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeUserById() {
        System.out.println("[REMOVE USER BY ID]");
        System.out.println("Please, enter user id:");
        final long id = scanner.nextLong();
        final User user = userService.removeById(id);
        if (user == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

   public int removeUserByLogin() {
        System.out.println("[REMOVE USER BY LOGIN]");
        System.out.println("Please, enter user login:");
        final String login = scanner.nextLine();
        final User user = userService.removeByLogin(login);
        if (login == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public void viewUser(final User user) {
        if (user == null) return;
        System.out.println("[VIEW USER DETAIL]");
        System.out.println(" ");
        System.out.println("Id: "+ user.getId());
        System.out.println("Login: " + user.getLogin());
        System.out.println("Password HASH: " + user.getHashPassword());
        System.out.println("Firstname: " + user.getFirstName());
        System.out.println("Lastname: " + user.getLastName());
        System.out.println("Middlename: " + user.getMiddleName());
        System.out.println("Role: " + user.getUserRole());
        System.out.println(" ");
        System.out.println("[OK]");
    }

    public int viewUserByIndex(){
        System.out.println("[UPDATE USER]");
        System.out.println("Please, enter user index:");
        if (!scanner.hasNextInt()) {

            scanner.nextLine();
            System.out.println("FAIL! IT'S NOT NUMBER");
            return -1;
        }
        final int index = scanner.nextInt() - 1;
        scanner.nextLine();
        final User user = userService.findByIndex(index);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        viewUser(user);
        return 0;
    }

    public int viewUserById() {
        System.out.println("PLEASE, ENTER USER ID:");
        final long id = scanner.nextLong();
        final User user = userService.findById(id);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        viewUser(user);
        return 0;
    }

    public int viewUserByLogin() {
        System.out.println("ENTER LOGIN:");
        final String login = scanner.nextLine();
        final User user = userService.findByLogin(login);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        viewUser(user);
        return 0;
    }

    public int clearUsers() {
        System.out.println("[CLEAR USERS]");
        userService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public int listUser() {
        System.out.println("[LIST USER]");
        int index = 1;
        for (final User user : userService.findALL()) {
           System.out.println(index + ". " + user.getId() + "  login: " + user.getLogin() + "  ( role: " + user.getUserRole() + " )");
            index++;
        }
        System.out.println();
        System.out.println("[OK]");
        return 0;
    }

    public int logIn() {
        System.out.println("ENTER LOGIN: ");
        final User user = userService.findByLogin(scanner.nextLine());
        if (user == null) {
            System.out.println("LOGIN IS NOT FOUND IN SYSTEM.");
            return 0;
        }
        System.out.println("ENTER PASSWORD: ");
        final String password = scanner.nextLine();
        if (userService.userLogIn(user.getLogin(), password) == null){
            System.out.println("[FAIL]");
            return 0;
        }
        return 0;
    }

    public int displayUser() {
        viewUser(userService.user);
        return 0;
    }

    public int changePasswordUser(){
        System.out.println("[CHANGE PASSWORD]");
        System.out.println("Enter, user login:");
        final String login = scanner.nextLine();
        System.out.println("Please, enter OLD password");
        final String oldPassword = scanner.nextLine();
        System.out.println("Please, enter NEW password");
        final String newPassword = scanner.nextLine();
        final User user = userService.findByLogin(login);
        if (user == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        if (!user.getHashPassword().equals(HashMD5.getHash(oldPassword))) {
            System.out.println("[FAIL]");
            return 0;
        }
        user.setHashPassword(newPassword);
        System.out.println("[OK]");
        return 0;
    }

    public int updateUser() {
        if (userService.user == null) {
            System.out.println("[FAIL]");
        } else {
            System.out.println("Please, enter user password:");
            final String password = scanner.nextLine();
            System.out.println("Please, enter user first name");
            final String firstName = scanner.nextLine();
            System.out.println("Please, enter user last name");
            final String lastName = scanner.nextLine();
            System.out.println("Please, enter user middle name");
            final String middleName = scanner.nextLine();
            userService.update(userService.user.getId(), userService.user.getLogin(), password, firstName, lastName, middleName);
            System.out.println("[OK]");
        }
        return 0;
    }

    public int logOut() {
        System.out.println("LOG OUT");
        userService.userLogOut();
        System.out.println("[OK]");
        return 0;
    }

}
