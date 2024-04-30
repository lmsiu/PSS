package GUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    
}
