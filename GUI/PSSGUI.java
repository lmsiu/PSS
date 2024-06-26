package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import Tasks.Controller;
import Tasks.Model;
import Tasks.Viewer;


public class PSSGUI{
    // controller that will control everything

    public static void main(String args[]){
        // model, controller, and viewer variables for their use. there should only be one for each run to save all the current data
        Model model = new Model();
        Controller controller = new Controller(model);
        Viewer viewer = new Viewer(model);

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
        JButton printDayButton = makeButton("Print Day");
        JButton printWeekButton = makeButton("Print Week");
        JButton printMonthButton = makeButton("Print Month");
        JButton editTaskButton = makeButton("Edit Task");
        JButton searchTaskButton = makeButton("Search Task");
        JButton deleteTaskButton = makeButton("Delete Task");
        printScheduleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printDayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printWeekButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printMonthButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Can't write to schedule until a schedule has been selected
        writeToScheduleButton.setEnabled(false);
        printScheduleButton.setEnabled(false);
        printWeekButton.setEnabled(false);
        printMonthButton.setEnabled(false);
        printDayButton.setEnabled(false);
        editTaskButton.setEnabled(false);
        searchTaskButton.setEnabled(false);
        deleteTaskButton.setEnabled(false);

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
        schedulePanel.add(printDayButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(printWeekButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(printMonthButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(editTaskButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(searchTaskButton);
        schedulePanel.add(Box.createVerticalStrut(5));
        schedulePanel.add(deleteTaskButton);
        

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
                printDayButton.setEnabled(true);
                printWeekButton.setEnabled(true);
                printMonthButton.setEnabled(true);
                editTaskButton.setEnabled(true);
                searchTaskButton.setEnabled(true);
                deleteTaskButton.setEnabled(true);
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

        deleteTaskButton.addActionListener(e->{
            CardLayout cardLayout = (CardLayout) panelHolder.getLayout();
            JPanel deleteTaskPanel = new DeleteTaskGUI(controller).creatDeleteTaskPanel();
            panelHolder.add(deleteTaskPanel, "4");
            cardLayout.show(panelHolder, "4");

        });

        printScheduleButton.addActionListener(e->{
            // displays the schedule on the command line
            viewer.displayAllSchedule();
            
            // uncomment this code to display the schedule on a pop up
            //JOptionPane.showMessageDialog(null, viewer.displayAllSchedule());
            // to do this, displayAllSchedule will need to return a string of the scheudle written out

        });

        printWeekButton.addActionListener(e->{
            // display for what week to show
            CardLayout cardLayout = (CardLayout) panelHolder.getLayout();

            // panel format
            JPanel printWeekPanel = new JPanel();
            printWeekPanel.setLayout(new BoxLayout(printWeekPanel, BoxLayout.Y_AXIS));
            printWeekPanel.setPreferredSize(new java.awt.Dimension(300,200));
            printWeekPanel.setBackground(new Color(245, 245, 255));
            panelHolder.add(printWeekPanel, "5");
            cardLayout.show(panelHolder, "5");

            // text 
            JLabel printWeekTextLabel = new JLabel("What week would you like to see?");
            JTextArea printWeekTextArea = new JTextArea("Exp. 3");
            JButton printWeekExcecutionButton = new JButton("See schedule");

            printWeekTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            printWeekTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            printWeekExcecutionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            printWeekPanel.add(printWeekTextLabel);
            printWeekPanel.add(printWeekTextArea);
            printWeekPanel.add(printWeekExcecutionButton);

            printWeekExcecutionButton.addActionListener(e1->{
                //prints the schedule based on the week to the screen
                viewer.displayWeekSchedule(Integer.parseInt(printWeekTextArea.getText()));

                 // uncomment this code to display the schedule on a pop up
            //JOptionPane.showMessageDialog(null, viewer.displayWeekSchedule(Integer.parseInt(printWeekTextArea.getText())));
            // to do this, displayAllSchedule will need to return a string of the scheudle written out
            });

        });

        printMonthButton.addActionListener(e->{
            // display for what week to show
            CardLayout cardLayout = (CardLayout) panelHolder.getLayout();

            // panel format
            JPanel printMonthPanel = new JPanel();
            printMonthPanel.setLayout(new BoxLayout(printMonthPanel, BoxLayout.Y_AXIS));
            printMonthPanel.setPreferredSize(new java.awt.Dimension(300,200));
            printMonthPanel.setBackground(new Color(245, 245, 255));
            panelHolder.add(printMonthPanel, "6");
            cardLayout.show(panelHolder, "6");

            // text 
            JLabel printMonthTextLabel = new JLabel("What month would you like to see?");
            JTextArea printMonthTextArea = new JTextArea("Exp. 3");
            JButton printMonthExcecutionButton = new JButton("See schedule");

            printMonthTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            printMonthTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            printMonthExcecutionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            printMonthPanel.add(printMonthTextLabel);
            printMonthPanel.add(printMonthTextArea);
            printMonthPanel.add(printMonthExcecutionButton);

            printMonthExcecutionButton.addActionListener(e1->{
                //prints the schedule based on the week to the screen
                viewer.displayMonthSchedule(Integer.parseInt(printMonthTextArea.getText()));

                 // uncomment this code to display the schedule on a pop up
            //JOptionPane.showMessageDialog(null, viewer.displayMonthSchedule(Integer.parseInt(printMonthTextArea.getText()));
            // to do this, displayAllSchedule will need to return a string of the scheudle written out
            });

        });

        printDayButton.addActionListener(e->{
            // display for what week to show
            CardLayout cardLayout = (CardLayout) panelHolder.getLayout();

            // panel format
            JPanel printDayPanel = new JPanel();
            printDayPanel.setLayout(new BoxLayout(printDayPanel, BoxLayout.Y_AXIS));
            printDayPanel.setPreferredSize(new java.awt.Dimension(300,200));
            printDayPanel.setBackground(new Color(245, 245, 255));
            panelHolder.add(printDayPanel, "7");
            cardLayout.show(panelHolder, "7");

            // text 
            JLabel printDayTextLabel = new JLabel("What month would you like to see?");
            JTextArea printDayTextArea = new JTextArea("Exp. 3");
            JButton printDayExcecutionButton = new JButton("See schedule");

            printDayTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            printDayTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            printDayExcecutionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            printDayPanel.add(printDayTextLabel);
            printDayPanel.add(printDayTextArea);
            printDayPanel.add(printDayExcecutionButton);

            printDayExcecutionButton.addActionListener(e1->{
                //prints the schedule based on the week to the screen
                viewer.displayDaySchedule(Integer.parseInt(printDayTextArea.getText()));

                 // uncomment this code to display the schedule on a pop up
            //JOptionPane.showMessageDialog(null, viewer.displayDaySchedule(Integer.parseInt(printDayTextArea.getText()));
            // to do this, displayAllSchedule will need to return a string of the scheudle written out
            });

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