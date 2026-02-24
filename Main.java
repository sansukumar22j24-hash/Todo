package TaskManager;



import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserInterface[] users = new User[5];

        UserManagerInterface userManager = new UserManager();
        while (true) {
            UserInterface currentUser = userManager.loginUser();

            boolean options = false;
            String option = null;
            Integer optionNumber = 0;
            while (!options) {
                System.out.println(" ");
                System.out.println("Select the Option to perform the Task");
                System.out.println("1.Create New Task ");
                System.out.println("2.Show all List ");
                System.out.println("3.Update Task");
                System.out.println("4.Delete Task");
                System.out.println("5.Exit");
                System.out.println("6.Profile");
                try {
                    option = sc.nextLine();

                    if (option.isEmpty()) {
                        System.out.println("Pick the correct option");
                        System.out.println("Option should not be empty");
                        continue;
                    }
                    if (option.equals("exit")) {
                        throw new Exception();
                    }
                    try {
                        optionNumber = new Integer(option);

                        if (optionNumber < 1 || optionNumber > 6) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("=== Enter the valid option first ===");
                        continue;
                    }

                    TaskManagerInterFace taskManager = new TaskManager();
                    if (option.equals("1")) {
                        taskManager.addTask(currentUser);
                    } else if (option.equals("2")) {
                        taskManager.showTask(currentUser);

                    } else if (option.equals("3")) {
                        taskManager.updateTask(currentUser);

                    } else if (option.equals("4")) {
                        taskManager.deleteOption(currentUser);
                    } else if (option.equals("5")) {
                        throw new Exception();
                    } else if (option.equals("6")) {

                        System.out.println("User name: " + currentUser.getUserName());
                        System.out.println("Password: " + currentUser.getPassword());
                        System.out.println("D.o.b " + currentUser.getDob());

                    }
                } catch (Exception e) {
                    if (option.equals("exit") || option.equals("5")) {
                        System.out.println("=== Exit ===");
                        System.out.println("Come Again! NextTime ");
                        break;
                    }

                }
            }
        }
    }
}
