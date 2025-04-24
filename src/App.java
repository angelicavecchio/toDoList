import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws Exception {
        

 
        System.out.println("-------------------------------");
        System.out.println(RED +"To-Do List Manager"+RESET);
        System.out.println("-------------------------------");
        ManagementTask managementTask = new ManagementTask();

        int choice=0;
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do{
         printMenu();

         while(true){

            try{
                System.out.print("Enter your choice(1-6): ");
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
                if(choice<1 || choice>6){
                    System.out.println("Enter a valid input between 1 and 6.");
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("It is NOT a valid input");

            }catch(InputMismatchException ex){
                System.out.println("It is NOT a valid input");
            }
         }


         switch (choice) {
            case 1:
            LocalDate dueDate = null;
            System.out.println("------------------------------------------------");
            System.out.print("\nEnter task description: ");
            String description = scanner.nextLine();

            while(true){
                try{
            System.out.print("Enter due date (dd/MM/yyyy): ");
            String input = scanner.nextLine();
            dueDate = LocalDate.parse(input, dateFormatter);
            break;
                }catch(DateTimeParseException e){
                         System.out.println("It is not a valid date (dd/MM/yyyy)");
                }
            }
            
            Task task = new Task(description, dueDate);
            managementTask.addTask(task);
            System.out.println("\nTask added!\n");
            System.out.println("------------------------------------------------");
                
                break;
         
                case 2:
                System.out.println("------------------------------------------------");
                System.out.println("\n Current tasks: \n");
                managementTask.viewTask();
                System.out.println("------------------------------------------------");
                break;

                case 3:
                System.out.println("------------------------------------------------");
                System.out.print("\nEnter the task number to mark as completed: ");
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                managementTask.markTaskAsCompleted(number);
                System.out.println("------------------------------------------------");
                break;


                case 4:
                System.out.println("------------------------------------------------");
                System.out.print("\nEnter the task number to delete:");
                String inputtoDelete = scanner.nextLine();
                int numberTask = Integer.parseInt(inputtoDelete);
                managementTask.deleteTask(numberTask);
                System.out.println("------------------------------------------------");
                break;


                case 5:
                System.out.println("------------------------------------------------");
                System.out.print("\nEnter file name to save tasks: ");
                String nameFile = scanner.nextLine();
                File file = new File(nameFile + ".csv");
                managementTask.saveTaskFile(file);
                System.out.printf("\nTasks saved to %s.csv\n",nameFile);
                System.out.println("------------------------------------------------");
                break;

                case 6:
                System.out.println("------------------------------------------------");
                System.out.println("\n Goodbye! Have a productive day!\n");
                System.out.println("------------------------------------------------");
                System.exit(0);
                break;         
            default:
                break;
         }






        }while(choice<=6);
        
        scanner.close();





    }


    public static void printMenu(){
        System.out.println("\n1. Add task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark task as completed");
        System.out.println("4. Delete a task");
        System.out.println("5. Save tasks to file");
        System.out.println("6. Exit\n");
        
    }
}
