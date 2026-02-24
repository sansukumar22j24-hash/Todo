package TaskManager;



public class Task implements TaskInterface {
    private String title;
    private String description;
    private String status;
public Task(String title){
    this.title=title;
    this.description="Empty";
    this.status="Todo";
}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
