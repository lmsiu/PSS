package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecurringTaskGUI {
	public JPanel getRecurringTaskGUI() {
		// Frequency
		JLabel frequencyLabel = new JLabel("Frequency: ");
        ButtonGroup frequencyButtonsButtonGroup = new ButtonGroup();
        JRadioButton dailyButton = new JRadioButton("Daily (1)");
        JRadioButton weeklyButton = new JRadioButton("Weekly(1)");
        dailyButton.setOpaque(false);
        weeklyButton.setOpaque(false);
        frequencyButtonsButtonGroup.add(dailyButton);
        frequencyButtonsButtonGroup.add(weeklyButton);
        
        JPanel frequencyPanel = new JPanel();
        frequencyPanel.add(frequencyLabel);
        frequencyPanel.add(dailyButton);
        frequencyPanel.add(weeklyButton);
        
		// Task type
		JLabel taskTypeTLabel = new JLabel("Task Type: ");
        ButtonGroup recurringTaskButtonsButtonGroup = new ButtonGroup();
        JRadioButton classButton = new JRadioButton("Class");
        JRadioButton studyButton = new JRadioButton("Study");
        JRadioButton sleepButton = new JRadioButton("Sleep");
        JRadioButton exerciseButton = new JRadioButton("Exercise");
        JRadioButton workButton = new JRadioButton("Work");
        JRadioButton mealButton = new JRadioButton("Meal");

        // adding to the button group to ensure that only one button at a time can be selected. 
        recurringTaskButtonsButtonGroup.add(classButton);
        recurringTaskButtonsButtonGroup.add(studyButton);
        recurringTaskButtonsButtonGroup.add(sleepButton);
        recurringTaskButtonsButtonGroup.add(exerciseButton);
        recurringTaskButtonsButtonGroup.add(workButton);
        recurringTaskButtonsButtonGroup.add(mealButton);

        taskTypeTLabel.setOpaque(false);
        classButton.setOpaque(false);
        studyButton .setOpaque(false);
        sleepButton.setOpaque(false);
        exerciseButton.setOpaque(false);
        workButton.setOpaque(false);
        mealButton.setOpaque(false);
        JPanel taskTypePanel = new JPanel();
        taskTypePanel.add(taskTypeTLabel);
        taskTypePanel.add(classButton);
        taskTypePanel.add(studyButton);
        taskTypePanel.add(sleepButton);
        taskTypePanel.add(exerciseButton);
        taskTypePanel.add(workButton);
        taskTypePanel.add(mealButton);


        JButton createButton = makeButton("Create Task");
        JButton homeButton = new JButton(("Return Home"));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(createButton);
        buttonsPanel.add(homeButton);



        JPanel recurringTaskPanel = new JPanel();
        recurringTaskPanel.setBackground(new Color(245, 245, 255));
        //recurringTaskPanel.setOpaque(false);
        //taskTypePanel.setBackground(new Color(245, 245, 255));
        //frequencyPanel.setBackground(new Color(245, 245, 255));
            taskTypePanel.setOpaque(false);
            frequencyPanel.setOpaque(false);
        buttonsPanel.setOpaque(false);
        recurringTaskPanel.setLayout(new BoxLayout(recurringTaskPanel,  BoxLayout.Y_AXIS));
        recurringTaskPanel.add(taskTypePanel);
        recurringTaskPanel.add(frequencyPanel);
        recurringTaskPanel.add(buttonsPanel);


        createButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                            if (e.getSource() == createButton){
                                    // Insert code for however we want to get the inputted/selected values below. Pops up with a "Info saved" dialog to verify the button worked

                                    JOptionPane.showMessageDialog(null, "Info Saved");
                            }
                    }
            });

            // Returns to the original panel from the start
            homeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                            // Returns to the original panel
                            Container prevPanel = recurringTaskPanel.getParent();
                            Container topPanel = prevPanel.getParent();
                            CardLayout cardLayout = (CardLayout) topPanel.getLayout();
                            cardLayout.first(topPanel);

                    }
            });

            return recurringTaskPanel;

	}
        private JButton makeButton(String text) {
                JButton button = new JButton(text);
                button.setBounds(150, 200, 220, 50);
                return button;
        }

}
