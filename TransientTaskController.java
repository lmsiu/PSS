public class TransientTaskController {
    private Model model;
    
    class TaskNotCreatedException extends Exception {
        public TaskNotCreatedException(String errorMessage) {
            super(errorMessage);
        }
    }
    
    // Constructor: Initializes the TransientTaskController with a reference to the Model
    public TransientTaskController(Model model) {
        this.model = model;
    }

   // Method to create a transient task
   public void createTransientTask(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
    try {
        // Create a new TransientTask object with the provided parameters
        TransientTask task = new TransientTask(name, typeCategory, startTime, duration, date);
        
        // Delegate task creation to the model
        model.createTask(task);
        
        // Print a success message if the task is created successfully
        System.out.println("Transient task created successfully.");
    } catch (TaskNotCreatedException e) {
        // Print an error message if a TaskNotCreatedException is caught
        System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
        // Print a generic error message if any unexpected exception occurs
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
}

    
    // Method to edit a transient task
    public void editTransientTask(String name, TypeCategory typeCategory, float startTime, float duration, int date) {
        try {
            TransientTask editedTask = new TransientTask(name, typeCategory, startTime, duration, date);
            model.editTask(editedTask); // Delegate task editing to the model
            System.out.println("Transient task edited successfully.");
        } catch (Exception e) {
            System.out.println("Error editing transient task: " + e.getMessage());
        }
    }

    // Method to find a task by name
public void findTaskByName(String name) {
    // Call the findTask method in the Model class to search for a task by name
    Task foundTask = model.findTask(name);
    
    // Check if the task is found
    if (foundTask != null) {
        // Print task information if found
        System.out.println("Task found:");
        System.out.println("Name: " + foundTask.getName()); // Print task name
        System.out.println("Type: " + foundTask.getTypeCategory()); // Print task type
        System.out.println("Start Time: " + foundTask.getStartTime()); // Print task start time
        System.out.println("Duration: " + foundTask.getDuration()); // Print task duration
        System.out.println("Date: " + foundTask.getDate()); // Print task date
    } else {
        // Print message if task is not found
        System.out.println("Task not found with the name: " + name);
    }
}



}
