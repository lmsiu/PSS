import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Model {
    LinkedList<Task> taskList;

    Model() {
        taskList = new LinkedList<Task>();
    }

    /**
     * Create a task. If the name of the task is not unique, throws an exception. If the task overlaps with
     * any other task, throws an exception. On success, creates the task and adds it to the database
     *
     * @param	name	 Name of the task to be created
     * @param	typeCategory	Category of the task
     * @param	startTime	Start time of the task
     * @param	duration	Duration of the task
     * @param	date	Date of the task
     */
    public void createTask(String name, TypeCategory typeCategory, float startTime, float duration, int date) throws Exception {
    	for(Task task : taskList) {
    		//Verify if name is unique
    		if(task.getName() == name) {
    			throw new Exception("A task with name" + name + "already exists!");
    		}
    		
    		//Verify that task does not overlap with any other task
    		//STUB
    	}
    	
    	//Create task
    	Task newTask = new Task(name, typeCategory, startTime, duration, date);
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
     * Edit a task with any given parameters
     *
     * @param	name	 Name of the task to be edited
     * @param	typeCategory	Category of the task
     * @param	startTime	Start time of the task
     * @param	duration	Duration of the task
     * @return	Task with matching name. Null if not found
     */
    public void editTask() {
        //stub
    }

    /**
     * Delete a task given its name
     *
     * @param	name	 Name of the task to be deleted
     * @return	Task with matching name. Null if not found
     */
    public void deleteTask(String name) {
        Task taskToDelete = findTask(name);
        
    }

    /**
     * Write schedule to a json file
     *
     * @param	fileName	 Name of the json file to create
     * @throws Exception 
     */
    public void writeData(String fileName) throws Exception {
    	File file = null;    
        try {
        	file = new File(fileName+".json");
        } catch(NullPointerException e) {
        	throw new Exception("File already exists!");
        }
        
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
        		case "RecurringTask":
        			//jo.put("Frequency", task.getFrequency());
        			//jo.put("StartDate", task.getStartDate());
        			//jo.put("EndDate", task.getEndDate())
        			break;
        		case "CancellationTask":
        			//STUB
        			break;
        		case "Transient Task":
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
				createTask(
					(String)jo.get("Name"),
					(TypeCategory)jo.get("TypeCategory"),
					(float)jo.get("StartTime"),
					(float)jo.get("Duration"),
					(int)jo.get("Date")
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }

    public LinkedList<Task> returnTaskList() {
        return taskList;
    }
}