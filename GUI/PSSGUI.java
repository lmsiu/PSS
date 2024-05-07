package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class PSSGUI {
    public static void main(String args[]){
        // Creating instance of JFrame
        JFrame frame = new JFrame("PSS");
        frame.setSize(500, 600);
        frame.setLayout(new FlowLayout());
        // Creating Prompt text
        JLabel createTaskText = new JLabel("What would you like to do?", SwingConstants.CENTER);
        createTaskText.setPreferredSize(new Dimension(350, 50));
        createTaskText.setFont(new Font("Dialog", Font.BOLD, 18));
        // Creating instance of JButton
        JButton createTaskButton = makeButton(" Create a Task");
        JButton viewScheduleButton = makeButton("View Schedule");

        // Panel setup
        JPanel panel = new JPanel( );
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        panel.setPreferredSize(new java.awt.Dimension(300,200));
        panel.setBackground(new Color(150, 155, 230));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        // Adding Text and Buttons to the panel
        panel.add(createTaskText);
        panel.add(createTaskButton);
        panel.add(viewScheduleButton);

        frame.add(panel);


        viewScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                viewScheduleButtonAction(ae);
            }
        });

        // making the frame visible
        frame.setVisible(true);

        createTaskButton.addActionListener(e ->
        {
            CreateTaskGUI createTaskGUI = new CreateTaskGUI();
            JFrame createTaskFrame = createTaskGUI.getCreateTaskScreen();
            frame.setVisible(false);
            createTaskFrame.setVisible(true);
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
                System.out.println("This file is verified as a JSON File");
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