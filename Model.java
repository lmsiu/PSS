import java.util.LinkedList;
import org.json.simple.JSONObject;

public class Model {
    LinkedList<Task> taskList;

    Model() {
        taskList = new LinkedList<Task>();
    }

    public void createTask(String name, String typeCategory, int duration, int date) {
    	for(Task task : taskList) {
    		//Verify if name is unique
    		if(task.getName() == name) {
    			throw new Exception("A task with name" + name + "already exists!");
    		}
    		
    		//Verify that task does not overlap with any other task
    		//STUB
    	}
    	
    	//Create task
    	taskList.add(new Task(name, typeCategory, duration, date);
    }

    public void editTask() {
        //stub
    }

    public void deleteTask() {
        //stub
    }

    public void writeData() {
        //stub
    }

    public void readData() {
        //stub
    }

    public LinkedList<Task> returnTaskList() {
        return taskList;
    }
}