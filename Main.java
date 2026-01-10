package TaskManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       User[] userArray = new User[10];
       Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("WELCOME TO TASK SYSTEM");
            System.out.println("Enter the your username ");
            boolean isExistingUser=false;
            String userName = sc.nextLine();
            int currentUserPosition=0;
            for(int i=0;i<5;i++){

                if(userArray[i]==null){
                    continue;
                }
                if(userArray[i].getUserName().equals(userName)){
                    isExistingUser=true;
                    currentUserPosition=i;
                    break;
            }

            }
            User currentUser;
            if(!isExistingUser){
                 currentUser =new User(userName);
//
                for (int i = 0; i < userArray.length; i++) {
                 if(userArray[i]!=null){
                     userArray[i]=currentUser;
                     break;
                 }


                }
            }
            else{
           currentUser= userArray[currentUserPosition];

            }
//            currentUser = new User(userName);

            Integer choice = 0;
            while (choice != 5) {
                System.out.print("Welcome ");
                System.out.println(currentUser.getUserName());
                System.out.println("1. Add Task");
                System.out.println("2. List of Tasks");
                System.out.println("3 update");
                System.out.println("4 Delete");
                System.out.println("5 Exit");

                System.out.println("Enter your choice ");
                choice = new Integer(sc.nextInt());
sc.nextLine();
                if (choice == 1) {
                    System.out.println("Enter your task Description ");
                    String taskDescription = sc.nextLine();
                    Task userTask = new Task(taskDescription);
                    currentUser.getTaskArray()[0] = userTask;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if(currentUser.getTaskArray()[i]==null){
                            currentUser.getTaskArray()[i]=userTask;
                            break;
                    }
                    }
                    System.out.println("Task is Added Successfully ");
                }
                else if (choice == 2) {
                    boolean isThereAnyTask=false;
                    for (int i = 0; i <currentUser.getTaskArray().length; i++)
                    {if(currentUser.getTaskArray()[i]!=null){
                        String taskDescription
                                =  currentUser.getTaskArray()[i].getTaskDescription();
                        System.out.println("Completed tasks:");
                        System.out.println(taskDescription);
                        isThereAnyTask=true;
                    }
                    if (isThereAnyTask==false)
                    {
                        System.out.println("There is any no task ");
                    }
                    }
                }else if (choice == 3) {
                    System.out.println("Task Is Updated");
                    boolean update = false;
                    int replacement = 0;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i] != null) {
                            replacement += i;
                            //replacement= i+1
                            System.out.print(i + 1);
                            System.out.print(": ");
                            System.out.println(currentUser.getTaskArray()[i].getTaskDescription());
                            update = true;

                        }
                    }
                    if (update == false) {
                        System.out.println("no task is available ");
                        break;
                    }
                    while (true){

                    System.out.println("Enter the task number what you want to update: ");
                    Integer option = new Integer(sc.next());
                    if (option <= replacement) {
                        int i = option - 1;
                        System.out.println("Update the task");
                        String updateNow = new String(sc.nextLine());
                        currentUser.getTaskArray()[i].setTaskDescription(updateNow);
                        System.out.println("task is updated ");
                        break;
                    } else {
                        System.out.println("Enter correct Task");
                    }
                }


                }

else if(choice==4) {

boolean delete=false;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if(currentUser.getTaskArray()[i]!=null){
                            System.out.print(i+1);
                            System.out.print(" : ");
                            System.out.println(currentUser.getTaskArray()[i].getTaskDescription());
                            delete=true;

                    }

}
                }else if (choice == 5) {

                    System.out.println("Task Is Exit");
                }

            }
        }
    }
}
