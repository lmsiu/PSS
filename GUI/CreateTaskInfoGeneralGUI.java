package GUI;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class CreateTaskInfoGeneralGUI {
    public JPanel generalInfoPanel = new JPanel();
    //public JTextArea taskNameTextArea = new JTextArea("Enter a task name");

    // Name
    private JLabel createTaskText = new JLabel("Task name: ");
    public JTextArea taskNameTextArea = new JTextArea("Enter a task name");

    // Date
    private JLabel dateText = new JLabel("Task Date:    Year: ");
        public JTextArea dateYearTextArea = new JTextArea("Year");
        private JLabel dateMonthText = new JLabel(" Month: ");
        public JTextArea dateMonthTextArea = new JTextArea("Month");
        private JLabel dateDayText = new JLabel(" Day: ");
        JTextArea dateDayTextArea = new JTextArea("Day");

    // Duration
    private JLabel durationText = new JLabel("Duration: Hours: ");
    public JTextArea durationHourArea = new JTextArea("Hours: ");
        private JLabel durationMinuteText = new JLabel(" Minutes: ");
        public JTextArea durationMinArea = new JTextArea(" Minutes: ");
        private JPanel durationPanel = new JPanel();

    // start time
    private JLabel startTimeText = new JLabel("Start time: Hour: ");
    public JTextArea startTimeHourTextArea = new JTextArea("Hour: ");
    private JLabel startTimeMinuteText = new JLabel(" Minute: ");
    public JTextArea startTimeMinArea = new JTextArea(" Minutes: ");

    // am or pm radio buttons
    public ButtonGroup ampm = new ButtonGroup();
    public JRadioButton amButton = new JRadioButton("AM");
    public JRadioButton pmButton = new JRadioButton("PM");

    public JPanel createTaskInfoGUIJPanel() {
        // panel for everything
        
        generalInfoPanel.setLayout(new BoxLayout(generalInfoPanel,  BoxLayout.Y_AXIS));
        //generalInfoPanel.setBackground(new Color(245, 245, 255));

        // Name
        // JLabel createTaskText = new JLabel("Task name: ");
        // JTextArea taskNameTextArea = new JTextArea("Enter a task name");
        // JPanel namePanel = new JPanel();
        JPanel namePanel = new JPanel();
        namePanel.add(createTaskText);
        namePanel.add(taskNameTextArea);

        //  date
        
        dateText.setOpaque(false);
        dateMonthText.setOpaque(false);
        dateDayText.setOpaque(false);
        JPanel datePanel = new JPanel();
        datePanel.add(dateText);
        datePanel.add(dateYearTextArea);
        datePanel.add(dateMonthText);
        datePanel.add(dateMonthTextArea);
        datePanel.add(dateDayText);
        datePanel.add(dateDayTextArea);

        // duration
        
        durationPanel.add(durationText);
        durationPanel.add(durationHourArea);
        durationPanel.add(durationMinuteText);
        durationPanel.add(durationMinArea);

        

        //ampm
        // adding to the button group to ensure that only one button at a time can be selected.
        ampm.add(amButton);
        ampm.add(pmButton);

        // start time
        JPanel startTimePanel = new JPanel();
        startTimePanel.add(startTimeText);
        startTimePanel.add(startTimeHourTextArea);
        startTimePanel.add(startTimeMinuteText);
        startTimePanel.add(startTimeMinArea);
        startTimePanel.add(amButton);
        startTimePanel.add(pmButton);

        // Adding each panel to the main generalinfo panel
        generalInfoPanel.add(namePanel);
        generalInfoPanel.add(datePanel);
        generalInfoPanel.add(durationPanel);
        generalInfoPanel.add(startTimePanel);
        namePanel.setOpaque(false);
        datePanel.setOpaque(false);
        durationPanel.setOpaque(false);
        startTimePanel.setOpaque(false);

        return generalInfoPanel;

    }
}
