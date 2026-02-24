package TaskManager;

public interface UserInterface {
    public String getUserName();
    public void setUserName(String userName);
    public String getDob();
    public void setDob(String dob);
    public String getPassword();
    public void setPassword(String password);
    public TaskInterface[] getTasks();
    public void setTasks(TaskInterface[] tasks);


}
