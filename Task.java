package Task1;

public class Task {
    private String description;
    private String status;
    public Task(String description){
        this.description=description;
        this.status="Todo";
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
}
