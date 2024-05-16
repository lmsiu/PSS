package GUI;

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

        deleteTaskPanel.add(taskNameLabel);
        deleteTaskPanel.add(taskNameArea);
        deleteTaskPanel.add(deleteButton);

        deleteButton.addActionListener(e -> {
            try {
                controller.deleteTask(taskNameArea.getText());
                JOptionPane.showMessageDialog(null, "Task deleted!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
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
