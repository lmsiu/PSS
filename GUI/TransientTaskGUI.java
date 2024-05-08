package GUI;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TransientTaskGUI {
    public JPanel getTransientTaskGUI(){

        JLabel taskTypeTLabel = new JLabel("Task Type: ");
        ButtonGroup transientTaskButtonsButtonGroup = new ButtonGroup();
        JRadioButton appointmentButton = new JRadioButton("Appointment");
        JRadioButton shoppingButton = new JRadioButton("Shopping");
        JRadioButton visitButton = new JRadioButton("Visit");

        // adding to the button group to ensure that only one button at a time can be selected. 
        transientTaskButtonsButtonGroup.add(appointmentButton);
        transientTaskButtonsButtonGroup.add(shoppingButton);
        transientTaskButtonsButtonGroup.add(visitButton);


        JPanel taskTypePanel = new JPanel();
        taskTypePanel.add(taskTypeTLabel);
        taskTypePanel.add(appointmentButton);
        taskTypePanel.add(shoppingButton);
        taskTypePanel.add(visitButton);

        return taskTypePanel;

    }

    
}
