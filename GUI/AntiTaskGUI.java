package GUI;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Tasks.Controller;

public class AntiTaskGUI extends CreateTaskInfoGeneralGUI{
    Controller controller;
    public AntiTaskGUI(Controller controller){
        this.controller = controller;
    }

    public JPanel createAntiTaskJPanel(){
        JPanel antiTaskPanel = new JPanel();
        JPanel panel = createTaskInfoGUIJPanel();

        JButton createButton = makeButton("Create Task");
        JButton homeButton = new JButton(("Return Home"));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        antiTaskPanel.add(panel);
        antiTaskPanel.add(createButton);
        antiTaskPanel.add(homeButton);
                antiTaskPanel.setOpaque(false);
        antiTaskPanel.setLayout(new BoxLayout(antiTaskPanel,  BoxLayout.Y_AXIS));

         createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == createButton){
                    // Insert code for however we want to get the inputted/selected values below. Pops up with a "Info saved" dialog to verify the button worked
                    try {
                        createAntiTask();
                        JOptionPane.showMessageDialog(null, "Info Saved");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }
        });

        // Returns to the original panel from the start
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // Returns to the original panel
                Container prevPanel = antiTaskPanel.getParent();
                Container topPanel = prevPanel.getParent();
                CardLayout cardLayout = (CardLayout) topPanel.getLayout();
                cardLayout.first(topPanel);

            }
        });

        return antiTaskPanel;
    }

    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setBounds(150, 200, 220, 50);
        return button;
    }

    private void createAntiTask() throws Exception{
        // general info 
        String name = taskNameTextArea.getText();
        int startTimeMinute = Integer.parseInt(startTimeMinArea.getText().trim());
        int startTimeHour = Integer.parseInt(startTimeHourTextArea.getText().trim());
        int durationHour = Integer.parseInt(durationHourArea.getText().trim());
        int durationMinutes = Integer.parseInt(durationMinArea.getText().trim());
        int dateYear = Integer.parseInt(dateYearTextArea.getText().trim());
        int dateMonth = Integer.parseInt(dateMonthTextArea.getText().trim());
        int dateDay = Integer.parseInt(dateDayTextArea.getText().trim());
        boolean am = ampm.getSelection().toString().equals("AM"); // default is false if nothing is selected

        controller.createAntiTask(name, startTimeMinute, startTimeHour, am, durationHour, durationMinutes, dateYear, dateMonth, dateDay);

    }
}
