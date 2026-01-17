package Task1;

public class User {
    private  String name;

Task[] tasks=new Task[5];
    public User(String name){
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }


}
