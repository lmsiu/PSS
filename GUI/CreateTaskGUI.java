package GUI;

import java.util.Collection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateTaskGUI {

    // return the JFrame for the create task screen
    public JFrame getCreateTaskScreen(){
        JFrame frame = new JFrame();

        // text
        JLabel createTaskText = new JLabel("What type of task would you like to create?");
        // buttons
        JButton transientTaskButton = makeButton("Transient Task");
        JButton recurringTaskButton = makeButton("Recurring Task");
        JButton antiTaskButton = makeButton("Anti Task");

        transientTaskButton.addActionListener(e -> {
            JFrame createTransientTaskFrame = new JFrame();
            createTransientTaskFrame.add(createTaskInfoGUIJPanel());
            createTransientTaskFrame.setVisible(true);
            frame.setVisible(false);
        });

        JPanel panel = new JPanel( );
        panel.setLayout(new BoxLayout(panel,  BoxLayout.Y_AXIS));

        panel.add(createTaskText);
        panel.add(transientTaskButton);
        panel.add(recurringTaskButton);
        panel.add(antiTaskButton);

        frame.add(panel);

        // 400 width and 500 height
        frame.setSize(500, 600);

        return frame;

    }

    // create button method to ensure uniform buttons are created
    private JButton makeButton(String text){
        JButton button = new JButton(text);
 
        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        return button;

    }


    // returns gui for basic values needed for a general task
    public JPanel createTaskInfoGUIJPanel(){
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
