import java.time.LocalDate;
/**
 * Represents a task that needs to be completed by a specific date.
 */

public class Task {

    // a short description of the task
    String description;
    //the due date of the task
    LocalDate date;

 
    public Task(String description, LocalDate date){
        this.description = description;
        this.date = date;
    }


    public String getDescription(){
        return this.description;
    }

    public LocalDate getDate(){
        return this.date;
    }

    /**
     * Returns a formatted string representation of the task.
     *
     * @return A string showing the description and due date
     */
    public String toString(){
        return String.format("%s  (Due: %s)", description,date);
    }


}
