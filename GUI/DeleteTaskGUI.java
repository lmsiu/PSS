package GUI;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Tasks.Controller;
import Tasks.Task;

public class DeleteTaskGUI {
    private Controller controller;

    public DeleteTaskGUI(Controller controller){
        this.controller = controller;
    }

    public JPanel creatDeleteTaskPanel(){
        JPanel deleteTaskPanel = new JPanel();
        deleteTaskPanel.setOpaque(false);
        deleteTaskPanel.setLayout(new BoxLayout(deleteTaskPanel,  BoxLayout.Y_AXIS));

        JLabel taskNameLabel = new JLabel("Task name: ");
        JTextArea taskNameArea = new JTextArea();
        JButton deleteButton = makeButton("Delete");

        JButton homeButton = new JButton(("Return Home"));

        taskNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        taskNameArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        deleteTaskPanel.add(taskNameLabel);
        deleteTaskPanel.add(taskNameArea);
        deleteTaskPanel.add(deleteButton);
        deleteTaskPanel.add(homeButton);

        

        deleteButton.addActionListener(e -> {
            try {
                controller.deleteTask(taskNameArea.getText());
                JOptionPane.showMessageDialog(null, "Task deleted!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
            
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // Returns to the original panel
                Container prevPanel = deleteTaskPanel.getParent();
                Container topPanel = prevPanel.getParent();
                CardLayout cardLayout = (CardLayout) topPanel.getLayout();
                cardLayout.first(topPanel);

            }
        });
        


        return deleteTaskPanel;
    }
    
    private JButton makeButton(String text){
        JButton button = new JButton(text);

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        return button;

    }
}
