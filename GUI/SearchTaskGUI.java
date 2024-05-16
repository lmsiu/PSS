package GUI;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JButton homeButton = new JButton(("Return Home"));

        taskNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        taskNameArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchTaskPanel.add(taskNameLabel);
        searchTaskPanel.add(taskNameArea);
        searchTaskPanel.add(searchButton);
        searchTaskPanel.add(homeButton);

        searchButton.addActionListener(e -> {
            Task task = controller.searchTask(taskNameArea.getText());

            if(task == null){
                JOptionPane.showMessageDialog(null, "Could not find a task with the name: " + taskNameArea.getText());

            }else{
                JOptionPane.showMessageDialog(null, task.getTaskDetails());

            }
        });

         // Returns to the original panel from the start
         homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // Returns to the original panel
                Container prevPanel = searchTaskPanel.getParent();
                Container topPanel = prevPanel.getParent();
                CardLayout cardLayout = (CardLayout) topPanel.getLayout();
                cardLayout.first(topPanel);

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
