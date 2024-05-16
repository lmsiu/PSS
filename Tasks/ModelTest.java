package Tasks;

import java.util.List;

import org.json.simple.JSONObject;

public class ModelTest {
	public static void main(String[] args) throws Exception {
		Model model = new Model();
		model.readData("Tasks");
		List<Task> taskList = model.returnTaskList();
		
		for(Task task : taskList) {
			System.out.println(task);
		}
	}
}
