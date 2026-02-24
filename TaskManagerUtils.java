package TaskManager;

public abstract class TaskManagerUtils {
    
    public static boolean emptyTask(UserInterface currentUser){
        for (int i = 0; i < currentUser.getTasks().length; i++) {
            if(currentUser.getTasks()[i]!=null){
              return   true;
            }
         
            
        }  return false;
    }
    
    
    public static  void displayTitle(UserInterface currentUser){
        for (int i = 0; i < currentUser.getTasks().length; i++) {
            if (currentUser.getTasks()[i]!=null){
                System.out.print(1+i);
                System.out.println(currentUser.getTasks()[i].getTitle());
            }
        }
        
    }
    public static void displayStatus(UserInterface currentUser,String  status){
        int n=1;
        for (int i = 0; i < currentUser.getTasks().length; i++) {
            if (currentUser.getTasks()[i].getStatus().equals(status))
            {
                System.out.print(n +" ");
                System.out.println(currentUser.getTasks()[i].getTitle());
                System.out.println(currentUser.getTasks()[i].getDescription());;
                System.out.println(currentUser.getTasks()[i].getStatus());
                n++;
            }
        }
    }
    
}
