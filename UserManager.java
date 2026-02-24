package TaskManager;

import java.util.Scanner;

public class UserManager implements UserManagerInterface{
    Scanner sc = new Scanner(System.in);
    User[] users = new User[5];

    public User loginUser() {
        System.out.println("Welcome to the Task Manager ");
        boolean isExistUser = false;
        User currentUser=null;

        while (!isExistUser) {
            System.out.println("Enter the  username:");
            String username = null;
            try {
                username = sc.nextLine();
                if (username.isEmpty()) {
                    System.out.println("It username not be empty ");
                    continue;
                }
                if (username.equals("exit")) {
                    throw new Exception();
                }

            } catch (Exception e) {
                if (username.equals("exit")) {
                    System.out.println("=== Exit ===");
                    isExistUser = true;
                    continue;
                }
            }


            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    continue;
                }
                if (users[i].getUserName().equals(username) && users[i]!=null) {
                    currentUser = users[i];
                    System.out.println("User is Already Exist");
                    isExistUser = true;
                    break;
                }
            }
            if (currentUser == null) {
                currentUser = new User(username);
                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        users[i] = currentUser;
                        System.out.print("Created a new User: ");
                        System.out.println(currentUser.getUserName());
                        System.out.println("Enter the Password ");
                        String password = null;

                        try {
                            password = sc.nextLine();
                            if (password.isEmpty()) {
                                System.out.println("Password should not empty ");
                            }
                            if (password.equals("exit")) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            if (password.equals("exit")) {
                                System.out.println("=== Exit ===");
                            }
                        }
                        currentUser.setPassword(password);
                        System.out.println("Enter the Dob ");
                        String dob = null;
                        try {
                            dob = sc.nextLine();
                            if (dob.isEmpty()) {
                                System.out.println("D.o.B should not empty ");
                            }
                            if (dob.equals("exit")) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            if (dob.equals("exit")) {
                                System.out.println("=== Exit ===");
                            }
                        }
                        currentUser.setDob(dob);
                        isExistUser = true;
                        break;
                    }
                }
            } else if (currentUser != null) {
                System.out.print("Welcome Back! ");
                System.out.println(currentUser.getUserName());
            }

        }
        return currentUser;
    }
}
