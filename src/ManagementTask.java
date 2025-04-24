/* 
 Rapresents the logic to the management of each task  
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class ManagementTask {

    ArrayList<Task> tasks = new ArrayList<>();


    public void addTask(Task task){
        tasks.add(task);
        }
    


    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("There are no tasks yet.");
        }
        for(Task task: tasks){
            System.out.println(task.toString());
        }
    }


    public void markTaskAsCompleted(int number){
        Iterator<Task> iterator = tasks.iterator();
        while(iterator.hasNext()){
         Task task = iterator.next();
         if(number == task.getNumberTask())
        System.out.printf("Task %s marked as completed!\n",task.getDescription());
        task.setState("[Done]");
        }
        }
       
       
    

    public void deleteTask(int number){
       
        Iterator<Task> iterator = tasks.iterator();
       while (iterator.hasNext()) {
        Task t = iterator.next();
        if (t.getNumberTask() == number) {
            System.out.printf("Task %s is deleted!\n",t.getDescription());
            iterator.remove();  
        }
    }
    
}


    public void saveTaskFile(File file){
        try(FileWriter fileWriter = new FileWriter(file,true)){
            for(Task task : tasks){
                fileWriter.write("ID : [Date] - Description\n");
                fileWriter.write(String.format("%d : [%s] - %s\n", task.getNumberTask(),task.getDate(),task.getDescription()));
                }
        }catch(IOException e){
            System.out.println("Could not save the task on the file");
        }


    
}


}







