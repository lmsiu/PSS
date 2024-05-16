package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import Tasks.Controller;
import Tasks.Model;


public class PSSGUI{
    // controller that will control everything

    public static void main(String args[]){
        Controller controller = new Controller(new Model());

        // Creating instance of JFrame
        JFrame frame = new JFrame("PSS");
        frame.setSize(800, 800);
        frame.setLayout(new FlowLayout());
        // Creating Prompt text
        JLabel createTaskText = new JLabel("What would you like to do?");
        createTaskText.setPreferredSize(new Dimension(350, 50));
        createTaskText.setFont(new Font("Dialog", Font.BOLD, 18));
        createTaskText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel schedulePanelText = new JLabel("Select a schedule first!");
        schedulePanelText.setAlignmentX(Component.CENTER_ALIGNMENT);
        schedulePanelText.setPreferredSize(new Dimension(350, 50));
        schedulePanelText.setFont(new Font("Dialog", Font.BOLD, 16));

        // Creating buttons for the top panel
        JButton createTaskButton = makeButton(" Create a Task");
        JButton viewScheduleButton = makeButton("View Schedule");
        JButton writeToScheduleButton = makeButton("Write to Schedule");
        createTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewScheduleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        writeToScheduleButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons to list or edit the selected schedule
        JButton printScheduleButton = makeButton("Print Schedule");
        JButton printWeekButton = makeButton("Print Week");
        JButton printMonthButton = makeButton("Print Month");
        JButton editTaskButton = makeButton("Edit Task");
        JButton searchTaskButton = makeButton("Search Task");
        printScheduleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printWeekButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printMonthButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Can't write to schedule until a schedule has been selected
        writeToScheduleButton.setEnabled(false);
        printScheduleButton.setEnabled(false);
        printWeekButton.setEnabled(false);
        printMonthButton.setEnabled(false);
        editTaskButton.setEnabled(false);
        searchTaskButton.setEnabled(false);

        // Panel setup
        JPanel panelHolder = new JPanel();
        panelHolder.setLayout(new CardLayout());
        panelHolder.setPreferredSize(new Dimension(500, 350));
        JPanel panel = new JPanel( );
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new java.awt.Dimension(600,600));
        panel.setBackground(new Color(245, 245, 255));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));

        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
        schedulePanel.setPreferredSize(new java.awt.Dimension(300,200));
        schedulePanel.setBackground(new Color(245, 245, 255));


        // Adding Text and Buttons to the panel
        panel.add(createTaskText);
        panel.add(createTaskButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(viewScheduleButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(writeToScheduleButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JSeparator());
        panel.add(Box.createVerticalStrut(10));
        // Adding text and buttons to the panel involving schedules, which will be inside the main panel
        schedulePanel.add(schedulePanelText);
        schedulePanel.add(Box.createVerticalStrut(10));
        schedulePanel.add(printScheduleButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(printWeekButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(printMonthButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(editTaskButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(searchTaskButton);

        panel.add(schedulePanel);
        panelHolder.add(panel, "1");
        frame.add(panelHolder);

        // making the frame visible
        frame.setVisible(true);


        // Tries to view schedule from filesystem, and if successful, enables buttons that interact with the schedule
        viewScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                viewScheduleButtonAction(ae);
                writeToScheduleButton.setEnabled(true);
                printScheduleButton.setEnabled(true);
                printWeekButton.setEnabled(true);
                printMonthButton.setEnabled(true);
                editTaskButton.setEnabled(true);
                searchTaskButton.setEnabled(true);
                schedulePanelText.setText("Schedule Viewing/Editing");
            }
        });


        // Adds the panel
        createTaskButton.addActionListener(e ->
        {
            CardLayout cardLayout = (CardLayout) panelHolder.getLayout();
            CreateTaskGUI createTaskGUI = new CreateTaskGUI(controller);
            JPanel createTaskPanel = createTaskGUI.getCreateTaskScreen();
            panelHolder.add(createTaskPanel, "2");
            cardLayout.show(panelHolder, "2");

        });

        searchTaskButton.addActionListener(e->{
            CardLayout cardLayout = (CardLayout) panelHolder.getLayout();
            JPanel createTaskPanel = new SearchTaskGUI(controller).createSearchTaskPanel();
            panelHolder.add(createTaskPanel, "3");
            cardLayout.show(panelHolder, "3");
            
        });
    }
    // Prompts user to choose a file from the user's system
    private static void viewScheduleButtonAction(ActionEvent ae) {
        JFileChooser chooseFile = new JFileChooser();
        int check = chooseFile.showOpenDialog(null);
        if(check == JFileChooser.APPROVE_OPTION){
            // Stores the file, the filename, and the filetype
            File scheduleFile = chooseFile.getSelectedFile();
            String filename = scheduleFile.getAbsolutePath();
            String filetype = chooseFile.getTypeDescription(scheduleFile);
            System.out.println(filetype);

            // Verifies that the file is of JSON format
            if (filetype.equals("JSON File")){
                System.out.println("This file is verified as a JSON File\n\n");

                // Perhaps use the model readData method?

            }
        }
    }

    // create button method to ensure uniform buttons are created
    private static JButton makeButton(String text){
        JButton button = new JButton(text);

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        return button;

    }
}