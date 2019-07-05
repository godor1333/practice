package com.company.view;

import com.company.controller.GraphCreatorController;

import javax.swing.*;
import java.awt.*;

import static com.company.Constants.Algorithms.*;
import static com.company.Constants.NameButton.*;

class ToolBar extends JPanel {

    private static final String[] ITEMS = new String[]{DIJKSTRA, FORD_BELLMAN, ASTAR};
    private final GraphCreatorController controller;
    private JComboBox comboBoxAlgorithms;
    private JLabel labelHelp;
    private JButton backStepButton;
    private JButton nextStepButton;
    private JButton startButton;
    private JButton finishButton;

    public ToolBar(GraphCreatorController controller) {
        this.controller = controller;
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        initButtons();
        initLabelHelpAndNextBack();
        initButtonControlAlgorithms();
    }

    private void initButtons() {
        JPanel panelButton = new JPanel();
        JButton saveBtn = new JButton(SAVE);
        saveBtn.addActionListener(e -> controller.saveGraph());

        JButton loadBtn = new JButton(LOAD);
        loadBtn.addActionListener(e -> controller.loadGraph());

        JButton moveBtn = new JButton(MOVE);
        moveBtn.addActionListener(e -> controller.setStateOfMotion());

        JButton addVertexBtn = new JButton(ADD_VERTEX);
        addVertexBtn.addActionListener(e -> controller.setStateOfAddingVertices());

        JButton connectVertexBtn = new JButton(CONNECT_VERTEX);
        connectVertexBtn.addActionListener(e -> controller.setStateOfConnectionVertices());

        comboBoxAlgorithms = new JComboBox(ITEMS);
        comboBoxAlgorithms.addActionListener(e -> controller.setStateOfAlgorithm());

        JButton deleteBtn = new JButton(DELETE);
        deleteBtn.addActionListener(e -> controller.setStateOfDelete());

        panelButton.add(saveBtn);
        panelButton.add(loadBtn);
        panelButton.add(moveBtn);
        panelButton.add(addVertexBtn);
        panelButton.add(connectVertexBtn);
        panelButton.add(comboBoxAlgorithms);
        panelButton.add(deleteBtn);
        add(panelButton, BorderLayout.NORTH);
    }

     private void initLabelHelpAndNextBack() {
        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new GridBagLayout());
        panelLabel.setBackground(new Color(222, 239, 216));
        labelHelp = new JLabel();
        labelHelp.setHorizontalAlignment(JLabel.CENTER);
        labelHelp.setVerticalAlignment(JLabel.CENTER);
        labelHelp.setForeground(new Color(106, 119, 61));
        panelLabel.add(labelHelp);
        add(panelLabel, BorderLayout.CENTER);
    }

    private void initButtonControlAlgorithms() {
        JPanel panel = new JPanel();
        startButton = new JButton(START);
        startButton.setEnabled(false);
        startButton.addActionListener(e -> controller.startAlgorithm());
        finishButton = new JButton(FINISH);
        finishButton.setEnabled(false);
        finishButton.addActionListener(e -> controller.finishAlgorithm());
        backStepButton = new JButton(BACK);
        backStepButton.setEnabled(false);
        backStepButton.addActionListener(e -> controller.backStep());
        nextStepButton = new JButton(NEXT);
        nextStepButton.setEnabled(false);
        nextStepButton.addActionListener(e -> controller.nextStep());

        panel.add(backStepButton);
        panel.add(startButton);
        panel.add(finishButton);
        panel.add(nextStepButton);
        add(panel, BorderLayout.SOUTH);
    }

    public void setLabelHelp(String text) {
        labelHelp.setText(text);
    }

    public void setEnabledNextButton(boolean show) {
        nextStepButton.setEnabled(show);
    }

    public void setEnabledBackButton(boolean show) {
        backStepButton.setEnabled(show);
    }

    public void setEnabledStartButton(boolean show) {
        startButton.setEnabled(show);
    }

    public void setEnabledFinishButton(boolean show) {
        finishButton.setEnabled(show);
    }

    public String getSelectAlgorithm() {
        return comboBoxAlgorithms.getSelectedItem() != null ? comboBoxAlgorithms.getSelectedItem().toString() : null;
    }
}
 
