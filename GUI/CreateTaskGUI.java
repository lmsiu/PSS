package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateTaskGUI {

    // return the JFrame for the create task screen
    public JFrame getCreateTaskScreen(){
        // Adjusting the JFrame
        JFrame frame = new JFrame("PSS");
        frame.setSize(700, 400);
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
    // create button method to ensure uniform buttons are created
    private JButton makeButton(String text){
        JButton button = new JButton(text);

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        return button;

    }

}
