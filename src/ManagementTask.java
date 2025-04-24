/* 
 * Manages the tasks by adding, viewing, marking as completed,
 * deleting, and saving tasks to a file.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class ManagementTask {

    
    // List to store all tasks
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Adds a new task to the task list.
     *
     * @param task The task to be added
     */
    public void addTask(Task task){
        tasks.add(task);
    }

    /**
     * Displays all tasks in the list.
     * If the list is empty, notifies the user.
     */
    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("There are no tasks yet.");
        } else {
            // Iterate through the tasks and print their details
            for(Task task: tasks){
                System.out.println(task.toString());
            }
        }
    }

    /**
     * Marks a task as completed based on its task number.
     *
     * @param number The task number to mark as completed
     */
    public void markTaskAsCompleted(int number){
        Iterator<Task> iterator = tasks.iterator();
        while(iterator.hasNext()){
            Task task = iterator.next();
            if(number == task.getNumberTask()) {
                System.out.printf("Task %s marked as completed!\n", task.getDescription());
                task.setState("[Done]");  // Update task state to "Done"
            }
        }
    }

    /**
     * Deletes a task from the list based on its task number.
     *
     * @param number The task number to delete
     */
    public void deleteTask(int number){
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task t = iterator.next();
            if (t.getNumberTask() == number) {
                System.out.printf("Task %s is deleted!\n", t.getDescription());
                iterator.remove();  // Remove the task from the list
            }
        }
    }

    /**
     * Saves all tasks to a file.
     * Appends new tasks to the file if it already exists.
     *
     * @param file The file to which tasks should be saved
     */
    public void saveTaskFile(File file){
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for(Task task : tasks){
                // Write task information to the file
                fileWriter.write("ID : [Date] - Description\n");
                fileWriter.write(String.format("%d : [%s] - %s\n", 
                        task.getNumberTask(), task.getDate(), task.getDescription()));
            }
        } catch (IOException e) {
            System.out.println("Could not save the task to the file.");
        }
    }


}







