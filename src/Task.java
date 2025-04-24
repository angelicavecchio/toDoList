import java.time.LocalDate;
/**
 * Represents a task that needs to be completed by a specific date.
 */

public class Task {

    // a short description of the task
    String description;
    //the due date of the task
    LocalDate date;
    private static int number = 0;
    private int id;
    String state;

 
    public Task(String description, LocalDate date){
        this.description = description;
        this.date = date;
        number++;
        this.id = number;
        this.state = "[Pending]";
    }


    public String getDescription(){
        return this.description;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public int getNumberTask(){
        return this.id;
    }
    

    public String getState(){
        return this.state;
    }


    public void setState(String state){
        this.state = state;
    }




    /**
     * Returns a formatted string representation of the task.
     *
     * @return A string showing the description and due date
     */
    public String toString(){
        return String.format(" %s  %d. %s  (Due: %s)",state,id,description,date);
    }


}
