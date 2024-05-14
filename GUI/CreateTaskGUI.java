//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package GUI;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class CreateTaskGUI {
    public CreateTaskGUI() {
    }

    public JFrame getCreateTaskScreen() {
        JFrame frame = new JFrame();
        JLabel createTaskText = new JLabel("What type of task would you like to create?");

        // buttons
        JPanel panel = new JPanel( );
        panel.setLayout(new BoxLayout(panel,  BoxLayout.Y_AXIS));

        JButton transientTaskButton = this.makeButton("Transient Task");
        JButton recurringTaskButton = this.makeButton("Recurring Task");
        JButton antiTaskButton = this.makeButton("Anti Task");
        transientTaskButton.addActionListener((e) -> {
            JFrame createTransientTaskFrame = new JFrame();
            JPanel transientTaskPanel = new JPanel();
            transientTaskPanel.add(this.createTaskInfoGUIJPanel());
            transientTaskPanel.add(new TransientTaskGUI().getTransientTaskGUI());
            createTransientTaskFrame.add(transientTaskPanel);
            createTransientTaskFrame.setSize(500, 600);
            createTransientTaskFrame.setVisible(true);
            frame.setVisible(false);
        });
        recurringTaskButton.addActionListener((e) -> {
            JFrame createRecurringTaskFrame = new JFrame();
            JPanel recurringTaskPanel = new JPanel();
            recurringTaskPanel.add(this.createTaskInfoGUIJPanel());
            recurringTaskPanel.add(new RecurringTaskGUI().getRecurringTaskGUI());
            createRecurringTaskFrame.add(recurringTaskPanel);
            createRecurringTaskFrame.setSize(500, 600);
            createRecurringTaskFrame.setVisible(true);
            frame.setVisible(false);
        });
        antiTaskButton.addActionListener((e) -> {
            JFrame createantiTaskFrame = new JFrame();
            createantiTaskFrame.add(this.createTaskInfoGUIJPanel());
            createantiTaskFrame.setSize(500, 600);
            createantiTaskFrame.setVisible(true);
            frame.setVisible(false);
        });
        panel.setLayout(new BoxLayout(panel, 1));
        panel.add(createTaskText);
        panel.add(transientTaskButton);
        panel.add(recurringTaskButton);
        panel.add(antiTaskButton);
        frame.add(panel);
        frame.setSize(500, 600);
        return frame;
    }

    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setBounds(150, 200, 220, 50);
        return button;
    }


    // returns gui for basic values needed for a general task
    public JPanel createTaskInfoGUIJPanel() {
    	// Name
        JLabel createTaskText = new JLabel("Task name: ");
        JTextArea taskNameTextArea = new JTextArea("Enter a task name");
        JPanel namePanel = new JPanel();
        namePanel.add(createTaskText);
        namePanel.add(taskNameTextArea);

        //  date
        JLabel dateText = new JLabel("Task name: Year: ");
        JTextArea dateYearTextArea = new JTextArea("Year");
        JLabel dateMonthText = new JLabel(" Month: ");
        JTextArea dateMonthTextArea = new JTextArea("Month");
        JLabel dateDayText = new JLabel(" Day: ");
        JTextArea dateDayTextArea = new JTextArea("Day");
        JPanel datePanel = new JPanel();
        datePanel.add(dateText);
        datePanel.add(dateYearTextArea);
        datePanel.add(dateMonthText);
        datePanel.add(dateMonthTextArea);
        datePanel.add(dateDayText);
        datePanel.add(dateDayTextArea);
        
        // duration
        JLabel durationText = new JLabel("Duration: Hours: ");
        JTextArea durationHour = new JTextArea("Hours: ");
        JLabel durationMinuteText = new JLabel(" Minutes: ");
        JTextArea durationMinArea = new JTextArea(" Minutes: ");
        JPanel durationPanel = new JPanel();
        durationPanel.add(durationText);
        durationPanel.add(durationHour);
        durationPanel.add(durationMinuteText);
        durationPanel.add(durationMinArea);
        
        // start time
        JLabel startTimeText = new JLabel("Start time: Hour: ");
        JTextArea startTimeHour = new JTextArea("Hour: ");
        JLabel startTimeMinuteText = new JLabel(" Minute: ");
        JTextArea startTimeMinArea = new JTextArea(" Minutes: ");

        // am or pm radion buttons
        ButtonGroup ampm = new ButtonGroup();
        JRadioButton amButton = new JRadioButton("AM");
        JRadioButton pmButton = new JRadioButton("PM");
        // adding to the button group to ensure that only one button at a time can be selected. 
        ampm.add(amButton);
        ampm.add(pmButton);

        JPanel startTimePanel = new JPanel();
        startTimePanel.add(startTimeText);
        startTimePanel.add(startTimeHour);
        startTimePanel.add(startTimeMinuteText);
        startTimePanel.add(startTimeMinArea);
        startTimePanel.add(amButton);
        startTimePanel.add(pmButton);

        // panel for everything
        JPanel generalInfoPanel = new JPanel();
        generalInfoPanel.setLayout(new BoxLayout(generalInfoPanel,  BoxLayout.Y_AXIS));
        generalInfoPanel.add(namePanel);
        generalInfoPanel.add(datePanel);
        generalInfoPanel.add(durationPanel);
        generalInfoPanel.add(startTimePanel);

        return generalInfoPanel;
    }
}
