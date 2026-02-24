package TaskManager;

public class User implements UserInterface {
    private String userName;
    private String dob;
    private String password;

    private  TaskInterface[] tasks=new Task[10];

    public User(String userName){
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaskInterface[] getTasks() {
        return tasks;
    }

    public void setTasks(TaskInterface[] tasks) {
        this.tasks = tasks;
    }
}
