package com.company.view;

import com.company.controller.GraphCreatorController;
import com.company.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Constants.Algorithms.*;
import static com.company.Constants.NameButton.*;

class ToolBar extends JPanel {

    private static final String[] ITEMS = new String[]{DIJKSTRA, FORD_BELLMAN, ASTAR};
    private final GraphCreatorController controller;
    private JComboBox comboBoxAlgorithms;
    private JLabel labelHelp;
    private JButton backStepButton;
    private JButton nextStepButton;

    public ToolBar(GraphCreatorController controller) {
        this.controller = controller;
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        initButtons();
        initLabelHelpAndNextBack();
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
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.X_AXIS));
        panelLabel.setBackground(new Color(222, 239, 216));
        labelHelp = new JLabel();
        labelHelp.setHorizontalAlignment(JLabel.CENTER);
        labelHelp.setVerticalAlignment(JLabel.CENTER);
        labelHelp.setForeground(new Color(106, 119, 61));
        backStepButton = new JButton(BACK);
        backStepButton.setEnabled(false);
        backStepButton.addActionListener(e -> controller.backStep());
        nextStepButton = new JButton(NEXT);
        nextStepButton.setEnabled(false);
        nextStepButton.addActionListener(e -> controller.nextStep());

        panelLabel.add(backStepButton);
        panelLabel.add(Box.createHorizontalGlue());
        panelLabel.add(labelHelp);
        panelLabel.add(Box.createHorizontalGlue());
        panelLabel.add(nextStepButton);
        add(panelLabel, BorderLayout.CENTER);
    }

    public void setLabelHelp(String text) {
        labelHelp.setText(text);
    }

    public void setEnabledControlStepButton(boolean show) {
        nextStepButton.setEnabled(show);
        backStepButton.setEnabled(show);
    }

    public String getSelectAlgorithm() {
        return comboBoxAlgorithms.getSelectedItem() != null ? comboBoxAlgorithms.getSelectedItem().toString() : null;
    }
}
