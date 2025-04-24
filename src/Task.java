import java.time.LocalDate;

/**
 * Represents a task that needs to be completed by a specific date.
 * Each task has a description, a due date, and a unique identifier.
 */
public class Task {

    
    String description;
    
   
    LocalDate date;

    // Static variable to generate unique task IDs
    private static int number = 0;
    

    private int id;
    
    // The current state of the task (e.g., Pending, Done)
    String state;

    /**
     * Constructor to create a new task with a description and a due date.
     * Each new task is assigned a unique ID and a default state of "[Pending]".
     *
     * @param description The description of the task
     * @param date The due date for the task
     */
    public Task(String description, LocalDate date){
        this.description = description;
        this.date = date;
        number++;  
        this.id = number;  // Assign a unique ID to the task
        this.state = "[Pending]";  // Set the default state to "Pending"
    }

    /**
     * Returns the description of the task.
     *
     * @return The description of the task
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Returns the due date of the task.
     *
     * @return The due date of the task
     */
    public LocalDate getDate(){
        return this.date;
    }

    /**
     * Returns the unique ID of the task.
     *
     * @return The unique task ID
     */
    public int getNumberTask(){
        return this.id;
    }

    /**
     * Returns the current state of the task (e.g., Pending, Done).
     *
     * @return The current state of the task
     */
    public String getState(){
        return this.state;
    }

    /**
     * Sets the state of the task (e.g., "[Pending]", "[Done]").
     *
     * @param state The new state of the task
     */
    public void setState(String state){
        this.state = state;
    }

   
    @Override
    public String toString(){
        return String.format(" %s  %d. %s  (Due: %s)", state, id, description, date);
    }
}
