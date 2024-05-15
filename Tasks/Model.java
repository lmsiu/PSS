package Tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Model {
    LinkedList<Task> taskList = new LinkedList<Task>();

    /**
     * Add a task to the schedule. If the name of the task is not unique, throws an exception. If the task overlaps with
     * any other task, throws an exception. On success, creates the task and adds it to the database
     *
     * @param	Task	 Task to be added to the schedule
     * @throws Exception A task with name __ already exists!
     * @throws Exception Cannot add task to schedule because it conflicts with other task(s)!
     */
    public void createTask(Task newTask) throws Exception {
    	for(Task task : taskList) {
    		//Verify if name is unique
    		if(task.getName() == newTask.getName())
    			throw new Exception("A task with name" + newTask.getName() + "already exists!");
    		
    		//Verify that task doesn't overlap with other tasks
    		if(!verifyTask(task))
    			throw new Exception("Cannot add task to schedule because it conflicts with other task(s)!");
    	}
    	
    	//Add task to schedule
    	taskList.add(newTask);
    }
    
    /**
     * Search for a task given its name. Returns the task if found, null if it doesn't exist.
     *
     * @param	name	 Name of the task to be found
     * @return	Task with matching name. Null if not found
     */
    public Task findTask(String name) {
    	for(Task task : taskList) {
    		if(task.getName() == name) {
    			return task;
    		}
    	}
    	
    	return null;
    }

    /**
     * Search for a task with a matching name in the schedule with the provided task. If names match,
     * verify that new task values are valid. If valid, replace old task with the edited task.
     *
     * @param	task Edited task
     * @throws Exception Edited Task does not match names with any Task in the schedule!
     * @throws Exception Edited task values are not valid!
     */
    public void editTask(Task editedTask) throws Exception {
    	for(Task task : taskList) {
    		if(task.getName() == editedTask.getName()) {
    			if(verifyTask(editedTask)) {
    				taskList.remove(task);
    				taskList.add(editedTask);
    			}
    		}
    	}
    	throw new Exception("Edited Task does not match names with any Task in the schedule!");
    }

    /**
     * Delete a task given its name
     *
     * @param	name	 Name of the task to be deleted
     * @throws Exception Task to delete does not match names with any tasks in the schedule!
     */
    public void deleteTask(String name) throws Exception {
        Task taskToDelete = findTask(name);
        if(taskToDelete == null) throw new Exception("Task to delete does not match names with any tasks in the schedule!");
        
		/*
        switch(taskToDelete.getTypeCategory()) {
        case RECURRING:
        	//any antitasks associated with this recurring task are deleted
        	//STUB
        	break;
        case TRANSIENT:
        	taskList.remove(taskToDelete);
        	break;
        case ANTITASK:
        	//if deleting antitask would leave a conflict between two recurring tasks
        	//or between a recurring and a transient task:
        	//do NOT delete task, and throw an error
        	//STUB
        	break;
        }
		*/
		if(taskToDelete instanceof RecurringTask){
			//any antitasks associated with this recurring task are deleted
        	//STUB
		}else if(taskToDelete instanceof TransientTask){
			taskList.remove(taskToDelete);

		}else if(taskToDelete instanceof AntiTask){
			//if deleting antitask would leave a conflict between two recurring tasks
        	//or between a recurring and a transient task:
        	//do NOT delete task, and throw an error
        	//STUB

		}
    }

    /**
     * Write schedule to a json file
     *
     * @param	fileName	 Name of the json file to create
     * @throws Exception 
     */
    public void writeData(String fileName) throws Exception {        
        PrintWriter writer = null;
        try {
        	writer = new PrintWriter(fileName+".json");
        	for(Task task : taskList) {
        		JSONObject jo = new JSONObject();
        		jo.put("Name", task.getName());
        		jo.put("Date", task.getDate());
        		jo.put("StartTime", task.getStartTime());
        		jo.put("Duration", task.getDuration());
        		
        		switch(task.getClass().toString()) {
        		case "RECURRING":
        			//jo.put("Frequency", task.getFrequency());
        			//jo.put("StartDate", task.getStartDate());
        			//jo.put("EndDate", task.getEndDate())
        			break;
        		case "TRANSIENT":
        			//STUB
        			break;
        		case "ANTITASK":
        			//STUB
        			break;
        		}
        		
        		JSONArray ja = new JSONArray();
        		ja.add(jo);
        		
        		writer.print(ja.toJSONString());
        		writer.close();
        	}
        } catch(IOException e) {
        	throw new Exception("An IO error occurred");
        }
    }

    /**
     * Read json file to local data
     *
     * @param	fileName	 Name of the json file to read from (Note: do not include .json in the fileName)
     * @throws Exception 
     */
    public void readData(String fileName) throws Exception {
    	JSONParser parser = new JSONParser();
    	JSONArray ja;
    	try {
    		ja = (JSONArray) parser.parse(new FileReader(fileName+".json"));
    	} catch(FileNotFoundException e) {
    		throw new Exception("File " + fileName + " not found!");
    	}
        
        for(Object o : ja) {
        	JSONObject jo = (JSONObject) o;
        	try {
				createTask(new Task(
					(String)jo.get("Name"),
					(TypeCategory)jo.get("TypeCategory"),
					(float)jo.get("StartTime"),
					(float)jo.get("Duration"),
					(int)jo.get("Date")
				));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }

    public LinkedList<Task> returnTaskList() {
        return taskList;
    }
    
    private boolean verifyTask(Task taskToVerify) {
		for(Task task : taskList) {
	    	switch(taskToVerify.getTypeCategory()) {
	    	case RECURRING:
	    		//Verify that every instance of taskToVerify does not overlap with any task
	    		
	    		break;
	    	case TRANSIENT:

				if(task.getTypeCategory() == TypeCategory.RECURRING) {
					//Verify that every instance of recurring task does not overlap with taskToVerify
					
				}
	    		break;
	    	case ANTITASK:
	    		//Verify that taskToVerify does not overlap with any transient or antitasks.
	    		//Verify that taskToVerify matches with an instance of a recurring task
	    		break;
			default:
				break;
	    	}
		}
    	return true;
    }
    
    private boolean verifyTransient(int checkDate, double checkStartTime, double checkDuration, int verifyDate, double verifyStartTime, double verifyDuration) {
		if(checkDate == verifyDate) {
			if(checkStartTime == verifyStartTime)
				return false;
			if(checkStartTime < verifyStartTime &&
					checkStartTime + checkDuration > verifyStartTime)
				return false;
			if(verifyStartTime + verifyDuration > checkStartTime)
				return false;
		}
			
		return true;
    }
    
    private boolean verifyReccurring(Task taskToVerify, Task recurringTask) {
    	int firstDate = recurringTask.getDate();
    	
    	for(int currentDate = firstDate; currentDate < taskToVerify.getDate(); currentDate + (RecurringTask)recurringTask.getFrequency()) {
    		if (verifyTransient(
						currentDate,
						recurringTask.getStartTime(),
						recurringTask.getDuration(),
						taskToVerify.getDate(),
						taskToVerify.getStartTime(),
						taskToVerify.getDuration()
					)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}