package TaskManager;


import java.util.Scanner;


public class TaskManager implements TaskManagerInterFace{
    Scanner sc=new Scanner(System.in);



    public void  addTask(UserInterface currentUser){
        boolean createTask = false;

        boolean titleIsEmpty = false;
        while (!titleIsEmpty) {
            for (int i = 0; i < currentUser.getTasks().length; i++)
            {
                if (currentUser.getTasks()[i] == null) {
                    createTask = true;
                    break;
                }
            }
            System.out.println("New Task ");
            //display the titles
            TaskManagerUtils.displayTitle(currentUser);

            if (createTask) {
                String title = null;
                Task task = null;

                boolean titleFlag = false;
                while (!titleFlag) {
                    System.out.println("Enter the New Title");
                    title = sc.nextLine();
                    try {
                        if (title.isEmpty()) {
                            System.out.println("Title should not empty");
                            continue;
                        }
                        if (title.equals("exit")) {
                            throw new Exception();
                        }

                    } catch (Exception e) {
                        if (title.equals("exit")) {
                            System.out.println("=== Exit ===");
                            titleFlag = true;
                            titleIsEmpty = true;
                            break;
                        }
                    }
                    task = new Task(title);
                    for (int i = 0; i < currentUser.getTasks().length; i++) {
                        if (currentUser.getTasks()[i] == null) {
                            currentUser.getTasks()[i] = task;
                            break;
                        }
                    }
                    titleFlag = true;
                    if (titleFlag == true) {
                        System.out.print("If add Description enter Yes || No ");
                        String descriptionOption = null;
                        boolean descriptionOptionIsEmpty = false;
                        while (!descriptionOptionIsEmpty) {
                            try {
                                descriptionOption = sc.nextLine();
                                if (descriptionOption.isEmpty()) {
                                    System.out.println("Enter ( Yes || No )");
                                    continue;
                                } else if (descriptionOption.equals("exit")) {
                                    throw new Exception();
                                } else if (descriptionOption.equals("No") || descriptionOption.equals("no")) {
                                    throw new Exception();
                                } else if (descriptionOption.equals("yes") || descriptionOption.equals("Yes")) {
                                    System.out.println("Enter the New Description");
                                    String description = null;
                                    boolean descriptionIsEmpty = false;
                                    while (!descriptionIsEmpty) {
                                        try {
                                            description = sc.nextLine();
                                            if (description.isEmpty()) {
                                                System.out.println("Enter some description");
                                                continue;
                                            }
                                            if (description.equals("exit")) {
                                                throw new Exception();
                                            }

                                        } catch (Exception e) {
                                            if (description.equals("exit")) {
                                                System.out.println("=== Exit ===");
                                                descriptionIsEmpty = true;
                                                descriptionOptionIsEmpty = true;
                                                titleIsEmpty = true;
                                                break;
                                            }
                                        }
                                        descriptionIsEmpty = true;
                                        task.setDescription(description);
                                        System.out.println("Description is added ");

                                    }
                                    descriptionOptionIsEmpty = true;
                                    titleFlag = true;
                                } else {
                                    System.out.println("Enter Yes Or No");
                                }
                            } catch (Exception e) {
                                if (descriptionOption.equals("exit")) {
                                    System.out.println("=== Exit ===");
                                    descriptionOptionIsEmpty = true;
                                    titleIsEmpty = true;
                                    break;
                                }
                                if (descriptionOption.equals("No") || descriptionOption.equals("no")) {
                                    descriptionOptionIsEmpty = true;
                                    titleIsEmpty = false;
                                }
                            }

                        }
                    } else {
                        System.out.println("Task is added ");
                        titleFlag = true;
                    }
                }
            } else {
                System.out.println("Task is full !!! ");
            }
        }

    }
    public void showTask(UserInterface currentUser) {
        System.out.println("All Available Tasks");
        boolean listFlag = false;
        while (!listFlag) {
            String listOption = null;
            Integer listOptionNumber = 0;
            boolean correctOption=false;
            try{
                System.out.println("Availabe Tasks ");
            if (TaskManagerUtils.emptyTask(currentUser)) {
                TaskManagerUtils.displayTitle(currentUser);
            }
            else{
                System.out.println("No Task here to show");
                break;
            }
            if (TaskManagerUtils.emptyTask(currentUser)) {

                System.out.println("Pick the any One Option: ");
                System.out.println("1.Show title");
                System.out.println("2.Show Todo");
                System.out.println("3.Show In-Progress");
                System.out.println("4.Show Done");


                while(!correctOption){
                try {
                    listOption = sc.nextLine();
                    listOptionNumber = new Integer(listOptionNumber);
                    if (listOption.isEmpty()) {
                        System.out.println("Enter ( 1 to 4 )");
                        continue;
                    }
                    if (listOption.equals("exit")) {
                        throw new Exception();
                    }
                    if (!listOption.equals("1") && !listOption.equals("2") && !listOption.equals("3") && !listOption.equals("4")) {
                        System.out.println("Enter correct number (1 to 4)");
                        continue;
                    }


                } catch (Exception e) {
                    if (listOption.equals("exit")) {
                        listFlag = true;
                        System.out.println("=== Exit ===");
                        break;
                    }
                }
                    if (listOption.equals("1")) {
                        System.out.println("List of All tasks! ");
                        TaskManagerUtils.displayTitle(currentUser);
                        correctOption = true;


                    }
                 else  if (listOption.equals("2")) {
                        System.out.println("List of Todo");
                        TaskManagerUtils.displayStatus(currentUser, "Todo");
                        correctOption = true;

                    }
                 else  if (listOption.equals("3")) {
                        System.out.println("List of In-progress");
                        TaskManagerUtils.displayStatus(currentUser, "In-progress");
                        correctOption = true;

                    }
                 else  if (listOption.equals("4")) {
                        System.out.println("List of Done");
                        TaskManagerUtils.displayStatus(currentUser, "Done");
                        correctOption = true;
                    }
                    else{
                        System.out.println("Enter the correct number");
                    }
                }
                }else{
                        System.out.println("Task is not here to show");
                    }


                } catch (Exception e) {
                    if (listOption.equals("exit")) {
                        System.out.println("=== Exit ===");
                        correctOption=true;
                        listFlag = true;
                        break;
                    }

                }
    }

    }
    public void updateTask(UserInterface currentUser) {
        System.out.println("Available Tasks");

        if(TaskManagerUtils.emptyTask(currentUser))
        {
          //title
            TaskManagerUtils.displayTitle(currentUser);

               boolean updateOptionFlag = false;
           while (!updateOptionFlag)
          {

            System.out.println("pick Which option to Update");
            System.out.println("1.Update Title");
            System.out.println("2.Update Description");
            System.out.println("3.Update Status");
            String updateOption = null;


            try {
                updateOption = sc.nextLine();
                if (updateOption.equals("exit")) {
                    throw new Exception();
                }
                if (updateOption.isEmpty()) {
                    System.out.println("Option should not empty ");
                    continue;
                }
                if (!updateOption.equals("1") && !updateOption.equals("2") && !updateOption.equals("3")) {
                    System.out.println("Enter ( 1 to 3 )");
                    continue;
                }

            } catch (Exception e) {
                if (updateOption.equals("exit")) {
                    updateOptionFlag = true;
                    break;
                }
            }

            if (updateOption.equals("1")) {
                if(TaskManagerUtils.emptyTask(currentUser)) {
                    TaskManagerUtils.displayTitle(currentUser);
                }else{
                    System.out.println("Title is Empty Here ");
                    break;
                }
                if(TaskManagerUtils.emptyTask(currentUser)) {
                    String titleUpdateOption = null;
                    Integer titleUpdateOptionNumber = 0;
                    String titleUpdate = null;
                    boolean updateTitle = false;
                    boolean updateOptionCorrect = false;
                    while (!updateOptionCorrect) {
                        System.out.println("Pick any one Option: ");

                        try {
                            titleUpdateOption = sc.nextLine();

                            if (titleUpdateOption.isEmpty()) {
                                System.out.println("Pick any option");
                                continue;
                            } else if (titleUpdateOption.equals("exit")) {
                                throw new Exception();
                            } else if (titleUpdateOption != null) {
                                int checkTheNumber = 0;
                                for (int i = 0; i < currentUser.getTasks().length; i++) {
                                    if (currentUser.getTasks()[i] != null) {
                                        checkTheNumber = checkTheNumber + 1;
                                    }
                                    titleUpdateOptionNumber = new Integer(titleUpdateOption);
                                }
                                if (titleUpdateOptionNumber <= checkTheNumber) {
                                    System.out.println("Enter the New Title For Update!");

                                    boolean emptyTitle = false;
                                    while (!emptyTitle) {
                                        try {

                                            titleUpdate = sc.nextLine();
                                            if (titleUpdate.equals("exit")) {
                                                throw new Exception();
                                            } else if (titleUpdate.isEmpty()) {
                                                System.out.println("Enter some thing to update ");
                                                continue;
                                            } else if (titleUpdateOption != null) {
                                                currentUser.getTasks()[titleUpdateOptionNumber - 1].setTitle(titleUpdate);
                                                System.out.println("Title update  successfully");
                                                emptyTitle = true;
                                                updateOptionCorrect = true;
                                            } else {
                                                System.out.println("Enter something ");
                                            }


                                        } catch (Exception e) {
                                            if (titleUpdate.equals("exit")) {
                                                System.out.println("=== Exit ===");
                                                updateOptionCorrect = true;
                                                updateOptionFlag = true;
                                                break;
                                            }
                                            if (titleUpdateOptionNumber != checkTheNumber) {
                                                System.out.println("Enter correct number");
                                                continue;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Enter the correct number ");
                                    continue;
                                }
                            } else {
                                System.out.println("Enter the correct option");
                            }

                        } catch (Exception e) {
                            if (titleUpdateOption.equals("exit")) {
                                System.out.println("=== Exit ===");
                                updateOptionCorrect = true;
                                updateOptionFlag = true;
                                break;
                            }
                            System.out.println("Mismatch ");
                            continue;
                        }
                        updateOptionCorrect = true;

                    }
                }

            } else if (updateOption.equals("2")) {
                System.out.println("Available Description ");
                boolean descritionFg = false;
                for (int i = 0; i < currentUser.getTasks().length; i++) {
                    if (currentUser.getTasks()[i] != null) {
                        descritionFg = true;
                        System.out.print(i + 1 + ". " + currentUser.getTasks()[i].getTitle() + " [ ");
                        System.out.println(currentUser.getTasks()[i].getDescription() + " ]");
                    }
                }
                if(!descritionFg){
                    System.out.println("Description is Empty Here");
                    break;
                }
if(descritionFg) {
    String updateDescriptionOption = null;
    Integer updateDescriptionOptionNumber = 0;
    String descriptionUpdate = null;
    boolean descriptionFlag = false;
    while (!descriptionFlag) {
        System.out.println("Pick any Description: ");
        try {
            updateDescriptionOption = sc.nextLine();
            if (updateDescriptionOption.equals("exit")) {
                throw new Exception();
            }
            if (updateDescriptionOption.isEmpty()) {
                System.out.println("Pick any option");
                continue;
            } else if (updateDescriptionOption != null) {
                int checkNumber = 0;
                for (int i = 0; i < currentUser.getTasks().length; i++) {
                    if (currentUser.getTasks()[i] != null) {
                        checkNumber = checkNumber + 1;
                    }
                    updateDescriptionOptionNumber = new Integer(updateDescriptionOption);

                }
                if (updateDescriptionOptionNumber <= checkNumber) {
                    System.out.println("Enter the New Description for Update!");

                    boolean descriptionIsEmpty = false;
                    while (!descriptionIsEmpty) {
                        try {

                            descriptionUpdate = sc.nextLine();
                            if (descriptionUpdate.equals("exit")) {
                                throw new Exception();
                            } else if (descriptionUpdate.isEmpty()) {
                                System.out.println("Description should not empty write something ");
                                continue;
                            } else if (descriptionUpdate != null) {
                                currentUser.getTasks()[updateDescriptionOptionNumber - 1].setDescription(descriptionUpdate);
                                System.out.println("Description is added");
                                descriptionIsEmpty = true;
                                descriptionFlag = true;
                            } else {
                                System.out.println("Enter something");
                            }

                        } catch (Exception e) {
                            if (descriptionUpdate.equals("exit")) {
                                System.out.println("=== Exit ===");
                                descriptionFlag = true;
                                updateOptionFlag = true;
                                break;
                            }
                            if (updateDescriptionOptionNumber != checkNumber) {
                                System.out.println("Enter the correct number");
                                continue;
                            }
                        }
                    }
                } else {
                    System.out.println("Enter the correct number ");
                    continue;
                }


            } else {
                System.out.println("Enter thr correct option ");
            }

        } catch (Exception e) {
            if (updateDescriptionOption.equals("exit")) {
                System.out.println("=== Exit ===");
                descriptionFlag = true;
                updateOptionFlag = true;
                break;
            }
            System.out.println("Mismatch ");
            continue;
        }

        descriptionFlag = true;


    }
}

            }
            else if (updateOption.equals("3")) {
                boolean statusFg = false;
                System.out.println("Select the any number to add the status ");
                if(TaskManagerUtils.emptyTask(currentUser)){
                    TaskManagerUtils.displayTitle(currentUser);
                }
                else{
                    System.out.println("Status is Empty Here ");
                    break;
                }
                if (TaskManagerUtils.emptyTask(currentUser)) {
                    String statusUpdateChoice = null;

                    boolean updateStatus = false;
                    String statusOption = null;
                    Integer statusUpdateChoiceNumber = 0;
                    while (!updateStatus) {
                        System.out.println("Pick any on to update the Task Status ");

                        try {
                            statusUpdateChoice = sc.nextLine();
                            if (statusUpdateChoice.equals("exit")) {
                                throw new Exception();
                            }
                            if (statusUpdateChoice.isEmpty()) {
                                System.out.println("Pick any option");
                                continue;
                            }
                            if (statusUpdateChoice != null) {
                                int checkNumber = 0;
                                for (int i = 0; i < currentUser.getTasks().length; i++) {
                                    if (currentUser.getTasks()[i] != null) {
                                        checkNumber = checkNumber + 1;
                                    }
                                    statusUpdateChoiceNumber = new Integer(statusUpdateChoice);

                                }
                                if (statusUpdateChoiceNumber <= checkNumber) {
                                    boolean emptyStatus = false;
                                    while (!emptyStatus) {
                                        System.out.println("1.Todo");
                                        System.out.println("2.In-Progress");
                                        System.out.println("3.Done");

                                        try {
                                            statusOption = sc.nextLine();
                                            if (statusOption.equals("exit")) {
                                                throw new Exception();
                                            } else if (statusOption.isEmpty()) {
                                                System.out.println("enter something number ");
                                                continue;
                                            } else if (statusOption != null) {
                                                if (statusOption.equals("1")) {
                                                    String todo = "Todo";
                                                    currentUser.getTasks()[statusUpdateChoiceNumber - 1].setStatus(todo);
                                                    emptyStatus = true;
                                                    updateStatus = true;
                                                    System.out.println("Status is updated! ");

                                                } else if (statusOption.equals("2")) {
                                                    String inProgress = "In-Progress";
                                                    currentUser.getTasks()[statusUpdateChoiceNumber - 1].setStatus(inProgress);
                                                    emptyStatus = true;
                                                    updateStatus = true;
                                                    System.out.println("Status is updated! ");


                                                } else if (statusOption.equals("3")) {
                                                    String done = "Done";
                                                    currentUser.getTasks()[statusUpdateChoiceNumber - 1].setStatus(done);
                                                    emptyStatus = true;
                                                    updateStatus = true;
                                                    System.out.println("Status is updated! ");

                                                }
                                            }

                                        } catch (Exception e) {
                                            if (statusOption.equals("exit")) {
                                                System.out.println("=== Exit ===");
                                                emptyStatus = true;
                                                updateStatus = true;
                                                updateOptionFlag = true;
                                                break;
                                            }
                                        }
                                    }

                                } else {
                                    System.out.println("Enter correct option ");
                                }
                            } else {
                                System.out.println("Invalid choice");
                            }
                        } catch (Exception e) {
                            if (statusUpdateChoice.equals("exit")) {
                                System.out.println("=== Exit ===");
                                updateStatus = true;
                                updateOptionFlag = true;
                                break;

                            }

                        }
                    }
                }
            }
         }

        }
        else{
            System.out.println("No Title is available");

        }
    }





    public void deleteOption(UserInterface currentUser) {
        boolean delete = false;
        System.out.println("Available Tasks to delete");
       if(TaskManagerUtils.emptyTask(currentUser)){
           TaskManagerUtils.displayTitle(currentUser);
        if (!delete)
        {
            boolean deleteFlag = false;
            String deleteOption = null;
            while (!deleteFlag) {

                System.out.println("Pick any one to delete: ");
                try {
                    deleteOption = sc.nextLine();
                    if (deleteOption.equals("exit")) {
                        throw new Exception();
                    } else if (deleteOption.isEmpty()) {
                        System.out.println("Option should not bee empty!");
                        continue;

                    } else if (deleteOption != null) {
                        Integer deleteOptionNumber = 0;
                        try{
                            deleteOptionNumber = new Integer(deleteOption);
                        }
                        catch (Exception e){
                            System.out.println("Invalid choice");
                            continue;
                        }

                            int checkNumber = 0;
                            for (int i = 0; i < currentUser.getTasks().length; i++) {
                                if (currentUser.getTasks()[i] != null) {
                                    checkNumber = checkNumber + 1;
                                }

                            }


                            if (deleteOptionNumber > 0 && deleteOptionNumber <= checkNumber) {

                                currentUser.getTasks()[deleteOptionNumber - 1] = null;

                                TaskInterface[] tempTask = new Task[currentUser.getTasks().length];
                                int num = 0;
                                for (int i = 0; i < tempTask.length; i++) {
                                    if (currentUser.getTasks()[i] != null) {
                                        tempTask[num] = currentUser.getTasks()[i];
                                        currentUser.getTasks()[num] = tempTask[num];
                                        num++;
                                    }

                                }
                                currentUser.setTasks(tempTask);
                                System.out.println("deleted Succesfully");

                            } else {
                                System.out.println("Enter the correct number ");
                                continue;
                            }

                    }
                }
                catch (Exception e) {
                    if (deleteOption.equals("exit")) {
                        System.out.println("=== Exit ===");
                        deleteFlag = true;
                        break;
                    }

                }
                deleteFlag = true;
            }
        } else {
            System.out.println("Noting  have to delete ");
        }
       }else{
           System.out.println("There is no Title! ");
       }
    }




}

