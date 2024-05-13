package GUI;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class RecurringTaskGUI {
	public JPanel getRecurringTaskGUI() {
		// Frequency
		JLabel frequencyLabel = new JLabel("Frequency: ");
        ButtonGroup frequencyButtonsButtonGroup = new ButtonGroup();
        JRadioButton dailyButton = new JRadioButton("Daily (1)");
        JRadioButton weeklyButton = new JRadioButton("Weekly(1)");
        frequencyButtonsButtonGroup.add(dailyButton);
        frequencyButtonsButtonGroup.add(weeklyButton);
        
        JPanel frequencyPanel = new JPanel();
        frequencyPanel.add(frequencyLabel);
        frequencyPanel.add(dailyButton);
        frequencyPanel.add(weeklyButton);
        
		// Task type
		JLabel taskTypeTLabel = new JLabel("Task Type: ");
        ButtonGroup recurringTaskButtonsButtonGroup = new ButtonGroup();
        JRadioButton classButton = new JRadioButton("Class");
        JRadioButton studyButton = new JRadioButton("Study");
        JRadioButton sleepButton = new JRadioButton("Sleep");
        JRadioButton exerciseButton = new JRadioButton("Exercise");
        JRadioButton workButton = new JRadioButton("Work");
        JRadioButton mealButton = new JRadioButton("Meal");

        // adding to the button group to ensure that only one button at a time can be selected. 
        recurringTaskButtonsButtonGroup.add(classButton);
        recurringTaskButtonsButtonGroup.add(studyButton);
        recurringTaskButtonsButtonGroup.add(sleepButton);
        recurringTaskButtonsButtonGroup.add(exerciseButton);
        recurringTaskButtonsButtonGroup.add(workButton);
        recurringTaskButtonsButtonGroup.add(mealButton);

        JPanel taskTypePanel = new JPanel();
        taskTypePanel.add(taskTypeTLabel);
        taskTypePanel.add(classButton);
        taskTypePanel.add(studyButton);
        taskTypePanel.add(sleepButton);
        taskTypePanel.add(exerciseButton);
        taskTypePanel.add(workButton);
        taskTypePanel.add(mealButton);

        JPanel recurringTaskPanel = new JPanel();
        recurringTaskPanel.setLayout(new BoxLayout(recurringTaskPanel,  BoxLayout.Y_AXIS));
        
        recurringTaskPanel.add(taskTypePanel);
        recurringTaskPanel.add(frequencyPanel);

        return recurringTaskPanel;
	}

}
