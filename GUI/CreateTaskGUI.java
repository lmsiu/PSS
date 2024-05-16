//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package GUI;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import Tasks.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateTaskGUI {
    public Controller controller;


    public CreateTaskGUI() {
    }

    public CreateTaskGUI(Controller controller) {
        this.controller = controller;
    }
    // Panel that prompts for task selection
    public JPanel getCreateTaskScreen() {

        // Panel within the frame to hold the text and buttons
        JPanel panel = new JPanel( );
        panel.setSize(new java.awt.Dimension (900,700));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        panel.setBackground(new Color(245, 245, 255));
        // Creating the text and aligning it in a certain format
        JLabel createTaskText = new JLabel("Select the task type");
        createTaskText.setAlignmentX(Component.CENTER_ALIGNMENT);
        createTaskText.setPreferredSize(new Dimension(200, 50));
        createTaskText.setFont(new Font("Dialog", Font.BOLD, 18));

        JLabel transientText = new JLabel("Transient Task");
        transientText.setAlignmentX(Component.CENTER_ALIGNMENT);
        transientText.setPreferredSize(new Dimension(200, 50));
        transientText.setFont(new Font("Dialog", Font.BOLD, 18));

        JLabel recurringText = new JLabel("Recurring Task");
        recurringText.setAlignmentX(Component.CENTER_ALIGNMENT);
        recurringText.setPreferredSize(new Dimension(200, 50));
        recurringText.setFont(new Font("Dialog", Font.BOLD, 18));

        JLabel antiText = new JLabel("Anti Task");
        antiText.setAlignmentX(Component.CENTER_ALIGNMENT);
        antiText.setPreferredSize(new Dimension(200, 50));
        antiText.setFont(new Font("Dialog", Font.BOLD, 18));


        // Creating the buttons and aligning them
        JButton transientTaskButton = makeButton("Transient Task");
        JButton recurringTaskButton = makeButton("Recurring Task");
        JButton antiTaskButton = makeButton("Anti Task");
        JButton backButton = makeButton("Back");
        transientTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        recurringTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        antiTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        JButton homeButton = new JButton(("Return Home"));
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton createButton = new JButton(("Create Task"));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Creates the panel for transient task creation
        transientTaskButton.addActionListener((e) -> {
            Container topPanel = panel.getParent();
            CardLayout cardLayout = (CardLayout) topPanel.getLayout();
            JPanel transientTaskPanel = new JPanel();
            transientTaskPanel.setBackground(new Color(245, 245, 255));
            transientTaskPanel.add(transientText);
            transientTaskPanel.add(new TransientTaskGUI(controller).getTransientTaskGUI());
            transientTaskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));

            topPanel.add(transientTaskPanel,"3");
            cardLayout.show(topPanel,"3");

        });
        // Creates the panel for recurring Task creation
        recurringTaskButton.addActionListener((e) -> {
            Container topPanel = panel.getParent();
            CardLayout cardLayout = (CardLayout) topPanel.getLayout();
            JPanel recurringTaskPanel = new JPanel();
            recurringTaskPanel.add(recurringText);
            //recurringTaskPanel.add(this.createTaskInfoGUIJPanel());
            recurringTaskPanel.add(new RecurringTaskGUI(controller).getRecurringTaskGUI());
            recurringTaskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
            recurringTaskPanel.setBackground(new Color(245, 245, 255));
            topPanel.add(recurringTaskPanel, "4");
            cardLayout.show(topPanel, "4");
        });
        // Creates the panel for anti task creation
        antiTaskButton.addActionListener((e) -> {
            Container topPanel = panel.getParent();
            CardLayout cardLayout = (CardLayout) topPanel.getLayout();
            JPanel antiTaskPanel = new JPanel();
            antiTaskPanel.add(antiText);
            antiTaskPanel.setLayout(new BoxLayout(antiTaskPanel,  BoxLayout.Y_AXIS));
            antiTaskPanel.add(new AntiTaskGUI(controller).createAntiTaskJPanel());
            antiTaskPanel.setBackground(new Color(245, 245, 255));
            antiTaskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
            topPanel.add(antiTaskPanel, "5");
            cardLayout.show(topPanel, "5");

        });
        backButton.addActionListener((e) -> {
            Container topPanel = panel.getParent();
            CardLayout cardLayout = (CardLayout) topPanel.getLayout();
            cardLayout.previous(topPanel);
        });

        // Adding each component to the panel and the panel to the frame with spacing in between
        panel.add(Box.createVerticalStrut(20));
        panel.add(createTaskText);
        panel.add(Box.createVerticalStrut(40));
        panel.add(transientTaskButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(recurringTaskButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(antiTaskButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);
        return panel;
    }

    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setBounds(150, 200, 220, 50);
        return button;
    }


}
