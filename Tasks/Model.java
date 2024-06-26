package Tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Tasks.RecurringTask.TaskType;
import Tasks.TransientTask.TypeCategory;

public class Model {
    private List<Task> taskList = new LinkedList<>();

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
    		if(task.getName().equals(newTask.getName()))
    			throw new Exception("A task with name \"" + newTask.getName() + "\" already exists!");
    		
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
    		if(task.getName().equals(name)) {
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
    		if(task.getName().equals(editedTask.getName())) {
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
 * @param   name     Name of the task to be deleted
 * @throws Exception Task to delete does not match names with any tasks in the schedule!
 */
public void deleteTask(String name) throws Exception {
    Task taskToDelete = findTask(name);
    if(taskToDelete == null) throw new Exception("Task to delete does not match names with any tasks in the schedule!");

    if(taskToDelete instanceof RecurringTask){
        // Delete associated anti-tasks
        for(Task task : taskList) {
            if(task instanceof AntiTask && ((AntiTask) task).correspondsToRecurringTask((RecurringTask) taskToDelete)) {
                taskList.remove(task);
            }
        }
    } else if(taskToDelete instanceof AntiTask){
        // Check for conflicts before deleting anti-task
        if(((AntiTask) taskToDelete).hasConflictsAfterDeletion(this)) {
            throw new Exception("Deleting this anti-task would leave a conflict between tasks!");
        } else {
            taskList.remove(taskToDelete);
        }
    } else if(taskToDelete instanceof TransientTask){
        taskList.remove(taskToDelete);
    }
}


    /**
     * Write schedule to a json file
     *
     * @param	fileName	 Name of the json file to create
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	public void writeData(String fileName) throws Exception {        
        PrintWriter writer = null;
        try {
        	writer = new PrintWriter(fileName+".json");
        	for(Task task : taskList) {
        		JSONObject jo = new JSONObject();
        		jo.put("Name", task.getName());
        		jo.put("StartTime", task.getStartTime());
        		jo.put("Duration", task.getDuration());
        		
        		if(task instanceof RecurringTask) {
        			jo.put("Type", ((RecurringTask)task).getTaskType());
        			jo.put("Frequency", ((RecurringTask)task).getFrequency());
        			jo.put("StartDate", task.getDate());
        			jo.put("EndDate", ((RecurringTask)task).getEndDate());
        		} else if (task instanceof TransientTask) {
        			jo.put("Date", task.getDate());
        			jo.put("Type", ((TransientTask)task).getTaskType());
        		} else if (task instanceof AntiTask) {
        			jo.put("Date", task.getDate());
        			jo.put("Type", "Cancellation");
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
    		System.out.println(fileName+".json");
    	} catch(FileNotFoundException e) {
    		throw new Exception("File " + fileName + " not found!");
    	}
        
        for(Object o : ja) {
        	JSONObject jo = (JSONObject) o;
        	System.out.println(jo);
        	try {
        		String type = (String)jo.get("Type");
        		switch(type) {
        		case "Class":
        		case "Study":
        		case "Sleep":
        		case "Exercise":
        		case "Work":
        		case "Meal":
        			createTask(new RecurringTask(
        					(String)jo.get("Name"),
        					TaskType.valueOf(type),
        					(double)jo.get("StartTime"),
        					(double)jo.get("Duration"),
        					(int)(long)jo.get("StartDate"),
        					(int)(long)jo.get("EndDate"),
        					(int)(long)jo.get("Frequency")
        				));
        			break;
        		case "Appointment":
        		case "Shopping":
        		case "Visit":
        			createTask(new TransientTask(
        					(String)jo.get("Name"),
        					TypeCategory.valueOf(type),
        					(double)jo.get("StartTime"),
        					(double)jo.get("Duration"),
        					(int)(long)jo.get("Date")
        				));
        			break;
        		case "Cancellation":
        			createTask(new AntiTask(
        					(String)jo.get("Name"),
        					(double)jo.get("StartTime"),
        					(double)jo.get("Duration"),
        					(int)(long)jo.get("Date")
        				));
        			break;
        		}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }

    public List<Task> returnTaskList() {
        return taskList;
    }
    
    private boolean verifyTask(Task taskToVerify) {
		for(Task task : taskList) {
			if(taskToVerify instanceof TransientTask) {
				//stub
			} else if (taskToVerify instanceof RecurringTask) {
				//stub
			} else if (taskToVerify instanceof AntiTask) {
				//stub
			}
		}
    	return true;
    }
}
