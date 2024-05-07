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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateTaskGUI {
    public CreateTaskGUI() {
    }

    public JFrame getCreateTaskScreen() {
        // Adjusting the JFrame
        JFrame frame = new JFrame("PSS - Task Creation");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        // Panel within the frame to hold the text and buttons
        JPanel panel = new JPanel( );
        panel.setPreferredSize(new java.awt.Dimension (550,300));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        panel.setBackground(new Color(245, 245, 255));
        // Creating the text and aligning it in a certain format
        JLabel createTaskText = new JLabel("What type of task would you like to create?");
        createTaskText.setAlignmentX(Component.CENTER_ALIGNMENT);
        createTaskText.setPreferredSize(new Dimension(350, 100));
        createTaskText.setFont(new Font("Dialog", Font.BOLD, 20));
        createTaskText.setForeground(new Color(140,155, 255));
        // Creating the buttons and aligning them
        JButton transientTaskButton = makeButton("Transient Task");
        JButton recurringTaskButton = makeButton("Recurring Task");
        JButton antiTaskButton = makeButton("Anti Task");
        transientTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        recurringTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        antiTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        transientTaskButton.addActionListener((e) -> {
            JFrame createTransientTaskFrame = new JFrame();
            createTransientTaskFrame.setSize(400, 500);
            createTransientTaskFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //createTransientTaskFrame.setLayout(new FlowLayout());
            createTransientTaskFrame.add(this.createTaskInfoGUIJPanel());
            createTransientTaskFrame.setVisible(true);
            frame.setVisible(false);
        });
        recurringTaskButton.addActionListener((e) -> {
            JFrame createRecurringTaskFrame = new JFrame();
            createRecurringTaskFrame.setSize(400, 500);
            createRecurringTaskFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //createRecurringTaskFrame.setLayout(new FlowLayout());
            createRecurringTaskFrame.add(this.createTaskInfoGUIJPanel());
            createRecurringTaskFrame.setVisible(true);
            frame.setVisible(false);
        });
        antiTaskButton.addActionListener((e) -> {
            JFrame createantiTaskFrame = new JFrame();
            createantiTaskFrame.setSize(400, 500);
            createantiTaskFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //createantiTaskFrame.setLayout(new FlowLayout());
            createantiTaskFrame.add(this.createTaskInfoGUIJPanel());
            createantiTaskFrame.setVisible(true);
            frame.setVisible(false);
        });
        // Adding each component to the panel and the panel to the frame
        panel.add(Box.createVerticalStrut(20));
        panel.add(createTaskText);
        panel.add(Box.createVerticalStrut(40));
        panel.add(transientTaskButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(recurringTaskButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(antiTaskButton);
        frame.add(panel);

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
        JLabel dateText = new JLabel("Task Date:    Year: ");
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

        // Create Task Button to save information
        JPanel savePanel = new JPanel();
        JButton createButton = makeButton("Create Task");
        savePanel.add(createButton);
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == createButton){
                    // Insert code for however we want to get the inputted/selected values below. Pops up with a "Info saved" dialog to verify the button worked

                    JOptionPane.showMessageDialog(null, "Info Saved");
                }
            }
        });
        // panel for everything
        JPanel generalInfoPanel = new JPanel();
        generalInfoPanel.setLayout(new BoxLayout(generalInfoPanel,  BoxLayout.Y_AXIS));
        generalInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        generalInfoPanel.add(namePanel);
        generalInfoPanel.add(datePanel);
        generalInfoPanel.add(durationPanel);
        generalInfoPanel.add(startTimePanel);
        generalInfoPanel.add(savePanel);

        return generalInfoPanel;

    }
}
