package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Tasks.TransientTask;

public class TransientTaskGUI extends CreateTaskInfoGeneralGUI {
    
    private ButtonGroup transientTaskButtonsButtonGroup = new ButtonGroup();

    public JPanel getTransientTaskGUI(){
        JLabel taskTypeTLabel = new JLabel("Task Type: ");

        JRadioButton appointmentButton = new JRadioButton("Appointment");
        JRadioButton shoppingButton = new JRadioButton("Shopping");
        JRadioButton visitButton = new JRadioButton("Visit");
        taskTypeTLabel.setOpaque(false);
        appointmentButton.setOpaque(false);
        shoppingButton.setOpaque(false);
        visitButton.setOpaque(false);
        // adding to the button group to ensure that only one button at a time can be selected. 
        transientTaskButtonsButtonGroup.add(appointmentButton);
        transientTaskButtonsButtonGroup.add(shoppingButton);
        transientTaskButtonsButtonGroup.add(visitButton);


        JPanel taskTypePanel = new JPanel();
        taskTypePanel.setOpaque(false);
        taskTypePanel.setLayout(new BoxLayout(taskTypePanel,  BoxLayout.Y_AXIS));

        taskTypePanel.add(this.createTaskInfoGUIJPanel());

        taskTypePanel.add(taskTypeTLabel);
        taskTypePanel.add(appointmentButton);
        taskTypePanel.add(shoppingButton);
        taskTypePanel.add(visitButton);
        taskTypePanel.setOpaque(false);
        JButton createButton = makeButton("Create Task");
        JButton homeButton = new JButton(("Return Home"));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(createButton);
        buttonsPanel.add(homeButton);
        taskTypePanel.add(buttonsPanel);


        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == createButton){
                    // Insert code for however we want to get the inputted/selected values below. Pops up with a "Info saved" dialog to verify the button worked
                    createTransientTask();
                    //createTaskPanel.getComponent(dateDayTextArea)
                    JOptionPane.showMessageDialog(null, "Info Saved");
                }
            }
        });

        // Returns to the original panel from the start
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // Returns to the original panel
                Container prevPanel = taskTypePanel.getParent();
                Container topPanel = prevPanel.getParent();
                CardLayout cardLayout = (CardLayout) topPanel.getLayout();
                cardLayout.first(topPanel);

            }
        });
        return taskTypePanel;

    }
    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setBounds(150, 200, 220, 50);
        return button;
    }

    private Exception createTransientTask(){

        // general info 
        String name = taskNameTextArea.getText();
        int startTimeMinute = Integer.parseInt(startTimeMinArea.getText());
        int startTimeHour = Integer.parseInt(startTimeHourTextArea.getText());
        int durationHour = Integer.parseInt(durationHourArea.getText());
        int durationMinutes = Integer.parseInt(durationMinArea.getText());
        int dateYear = Integer.parseInt(dateYearTextArea.getText());
        int dateMonth = Integer.parseInt(dateMonthTextArea.getText());
        int dateDay = Integer.parseInt(dateDayTextArea.getText());
        boolean am = ampm.getSelection().toString().equals("AM");

        // transient task
        TransientTask.TypeCategory typeCategory;
        switch (transientTaskButtonsButtonGroup.getSelection().toString()) {
            case("Appointment"):
                typeCategory = TransientTask.TypeCategory.APPOINTMENT;
                break;
            case("Shopping"):
                typeCategory = TransientTask.TypeCategory.SHOPPING;
                break;
            case("Visit"):
                typeCategory = TransientTask.TypeCategory.VISIT;
                break;
            default:
                break;
        }


        return null;
    }
    
}
