package ru.kuzminykh.tm.controller;

import ru.kuzminykh.tm.entity.User;
import ru.kuzminykh.tm.service.UserService;

public class UserController extends AbstractController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public int createUser() {
        System.out.println("[CREATE USER]");
        System.out.println("Please, enter user login:");
        final String login = scanner.nextLine();
        System.out.println("Please, enter password:");
        final String password = scanner.nextLine();
        System.out.println("Please, enter firstname:");
        final String firstName = scanner.nextLine();
        System.out.println("Please, enter secondname:");
        final String secondName = scanner.nextLine();
        System.out.println("Please, enter middlename:");
        final String middleName = scanner.nextLine();
        userService.create(login, password, firstName, secondName, middleName);
        System.out.println("[OK]");
        return 0;
    }

    public int createUserAdmin() {
        System.out.println("[CREATE USER Role]");
        System.out.println("Please, enter user login:");
        final String login = scanner.nextLine();
        System.out.println("Please, enter user password:");
        final String password = scanner.nextLine();
        System.out.println("Please, enter user firstname:");
        final String firstName = scanner.nextLine();
        System.out.println("Please, enter user secondname:");
        final String secondName = scanner.nextLine();
        System.out.println("Please, enter user middlename:");
        final String middleName = scanner.nextLine();
        userService.createAsAdmin(login, password, firstName, secondName, middleName);
        System.out.println("[OK]");
        return 0;
    }

    public void updateUser(User user) {
        System.out.println("Please, enter user firstname:");
        final String firstName = scanner.nextLine();
        System.out.println("Please, enter user secondname:");
        final String secondName = scanner.nextLine();
        System.out.println("Please, enter user middlename:");
        final String middleName = scanner.nextLine();
        userService.update(user.getLogin(), user.getHashPassword(), firstName, secondName, middleName);
        System.out.println("[OK]");
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
        System.out.println("LOGIN: " + user.getLogin());
        System.out.println("PASSWORD HASH: " + user.getHashPassword());
        System.out.println("FIRST NAME: " + user.getFirstName());
        System.out.println("SECOND NAME: " + user.getSecondName());
        System.out.println("MIDDLE NAME: " + user.getMiddleName());
        System.out.println("ROLE: " + user.getUserRole());
        System.out.println("[OK]");
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
           System.out.println(index + ".  login: " + user.getLogin() + "  ( role: " + user.getUserRole() + " )");
            index++;
        }
        System.out.println();
        System.out.println("[OK]");
        return 0;
    }

}
