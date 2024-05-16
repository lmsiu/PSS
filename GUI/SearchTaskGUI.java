package GUI;

import java.util.jar.JarEntry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Tasks.Controller;
import Tasks.Task;

public class SearchTaskGUI {
    private Controller controller;
    SearchTaskGUI(Controller controller){
        this.controller = controller;
    }

    public JPanel createSearchTaskPanel(){
        JPanel searchTaskPanel = new JPanel();
        searchTaskPanel.setOpaque(false);
        searchTaskPanel.setLayout(new BoxLayout(searchTaskPanel,  BoxLayout.Y_AXIS));

        JLabel taskNameLabel = new JLabel("Task name: ");
        JTextArea taskNameArea = new JTextArea();
        JButton searchButton = makeButton("Search");

        searchTaskPanel.add(taskNameLabel);
        searchTaskPanel.add(taskNameArea);
        searchTaskPanel.add(searchButton);

        searchButton.addActionListener(e -> {
            Task task = controller.searchTask(taskNameArea.getText());

            if(task == null){
                JOptionPane.showMessageDialog(null, "Could not find a task with the name: " + taskNameArea.getText());

            }else{
                JOptionPane.showMessageDialog(null, task.getTaskDetails());

            }
        });


        return searchTaskPanel;
    }

    private JButton makeButton(String text){
        JButton button = new JButton(text);

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        return button;

    }
    
}
