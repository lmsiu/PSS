package GUI;

import javax.swing.*;

import Tasks.Controller;
import Tasks.RecurringTask;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class RecurringTaskGUI extends CreateTaskInfoGeneralGUI {
        private Controller controller;
        private ButtonGroup recurringTaskButtonsButtonGroup = new ButtonGroup();
        private ButtonGroup frequencyButtonsButtonGroup = new ButtonGroup();

        public RecurringTaskGUI(Controller controller){
                this.controller = controller; // the controller should be the one from the main PSS cuz it has all the info
        }


	public JPanel getRecurringTaskGUI() {
		// Frequency
		JLabel frequencyLabel = new JLabel("Frequency: ");
        JRadioButton dailyButton = new JRadioButton("Daily (1)");
        JRadioButton weeklyButton = new JRadioButton("Weekly(7)");
        dailyButton.setOpaque(false);
        weeklyButton.setOpaque(false);
        frequencyButtonsButtonGroup.add(dailyButton);
        frequencyButtonsButtonGroup.add(weeklyButton);
        
        JPanel frequencyPanel = new JPanel();
        frequencyPanel.add(frequencyLabel);
        frequencyPanel.add(dailyButton);
        frequencyPanel.add(weeklyButton);
        
		// Task type
		JLabel taskTypeTLabel = new JLabel("Task Type: ");
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

        taskTypeTLabel.setOpaque(false);
        classButton.setOpaque(false);
        studyButton .setOpaque(false);
        sleepButton.setOpaque(false);
        exerciseButton.setOpaque(false);
        workButton.setOpaque(false);
        mealButton.setOpaque(false);
        JPanel taskTypePanel = new JPanel();
        taskTypePanel.add(taskTypeTLabel);
        taskTypePanel.add(classButton);
        taskTypePanel.add(studyButton);
        taskTypePanel.add(sleepButton);
        taskTypePanel.add(exerciseButton);
        taskTypePanel.add(workButton);
        taskTypePanel.add(mealButton);


        JButton createButton = makeButton("Create Task");
        JButton homeButton = new JButton(("Return Home"));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(createButton);
        buttonsPanel.add(homeButton);



        JPanel recurringTaskPanel = new JPanel();
        recurringTaskPanel.setBackground(new Color(245, 245, 255));
        //recurringTaskPanel.setOpaque(false);
        //taskTypePanel.setBackground(new Color(245, 245, 255));
        //frequencyPanel.setBackground(new Color(245, 245, 255));
            taskTypePanel.setOpaque(false);
            frequencyPanel.setOpaque(false);
        buttonsPanel.setOpaque(false);
        recurringTaskPanel.setLayout(new BoxLayout(recurringTaskPanel,  BoxLayout.Y_AXIS));
        recurringTaskPanel.add(this.createTaskInfoGUIJPanel());
        recurringTaskPanel.add(taskTypePanel);
        recurringTaskPanel.add(frequencyPanel);
        recurringTaskPanel.add(buttonsPanel);


        createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                            if (e.getSource() == createButton){
                                    // Insert code for however we want to get the inputted/selected values below. Pops up with a "Info saved" dialog to verify the button worked
                                   
                                try {
                                        createRecurringTask();
                                        JOptionPane.showMessageDialog(null, "Info Saved");
                                } catch (Exception e1) {
                                        JOptionPane.showMessageDialog(null, e1.getMessage());

                                }

                
                            }
                    }
            });

            // Returns to the original panel from the start
            homeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                            // Returns to the original panel
                            Container prevPanel = recurringTaskPanel.getParent();
                            Container topPanel = prevPanel.getParent();
                            CardLayout cardLayout = (CardLayout) topPanel.getLayout();
                            cardLayout.first(topPanel);

                    }
            });

            return recurringTaskPanel;

	}
        private JButton makeButton(String text) {
                JButton button = new JButton(text);
                button.setBounds(150, 200, 220, 50);
                return button;
        }

private void createRecurringTask() throws Exception{
                // general info 
        String name = taskNameTextArea.getText();
        int startTimeMinute = Integer.parseInt(startTimeMinArea.getText().trim());
        int startTimeHour = Integer.parseInt(startTimeHourTextArea.getText().trim());
        int durationHour = Integer.parseInt(durationHourArea.getText().trim());
        int durationMinutes = Integer.parseInt(durationMinArea.getText().trim());
        int dateYear = Integer.parseInt(dateYearTextArea.getText().trim());
        int dateMonth = Integer.parseInt(dateMonthTextArea.getText().trim());
        int dateDay = Integer.parseInt(dateDayTextArea.getText().trim());
        boolean am = ampm.getSelection().toString().equals("AM"); // default is false if nothing is selected

        boolean found = false;
        String taskTypeString = "";
        for (Enumeration<AbstractButton> buttons = recurringTaskButtonsButtonGroup.getElements(); buttons.hasMoreElements() && found == false;) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                taskTypeString = button.getText();
                found = true;
                
            }
        }

        // transient task
        RecurringTask.TaskType typeCategory;
        switch (taskTypeString) {
            case("Class"):
                typeCategory = RecurringTask.TaskType.CLASS;
                break;
            case("Study"):
                typeCategory = RecurringTask.TaskType.STUDY;
                break;
            case("Sleep"):
                typeCategory = RecurringTask.TaskType.SLEEP;
                break;
            case("Exercise"):
                typeCategory = RecurringTask.TaskType.EXERCISE;
                break;
           case("Work"):
                typeCategory = RecurringTask.TaskType.WORK;
                break;
            case("Meal"):
                typeCategory = RecurringTask.TaskType.MEAL;
                break;
            default:
                typeCategory = null;
                break;
        }

        int frequency;
        String frequencyString = "";

        for (Enumeration<AbstractButton> buttons = recurringTaskButtonsButtonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
    
                if (button.isSelected()) {
                        frequencyString = button.getText();
                }
        }
    
        if( frequencyString.equals("Daily (1)")){
                frequency = 1;
        }else{
                frequency = 7;
        }

        controller.createRecurringTask(name, startTimeMinute, startTimeHour, am, durationHour, durationMinutes, dateYear, dateMonth, dateDay, dateMonth, dateDay, frequency, typeCategory);
        }
}
