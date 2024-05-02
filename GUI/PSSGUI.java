package GUI;

import javax.swing.*;


public class PSSGUI {
    public static void main(String args[]){
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        JLabel createTaskText = new JLabel("What would you like to do?");

        // Creating instance of JButton
        JButton createTaskButton = makeButton(" Create a Task");
        JButton viewScheduleButton = makeButton("View Schedule");

        // x axis, y axis, width, height
        createTaskButton.setBounds(150, 200, 220, 50);

        // adding button
        JPanel panel = new JPanel( );
        panel.setLayout(new BoxLayout(panel,  BoxLayout.Y_AXIS));

        panel.add(createTaskText);
        panel.add(createTaskButton);
        panel.add(viewScheduleButton);

        frame.add(panel);

        // 400 width and 500 height
        frame.setSize(500, 600);

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

    // create button method to ensure uniform buttons are created
    private static JButton makeButton(String text){
        JButton button = new JButton(text);

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        return button;

    }
}