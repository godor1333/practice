package com.company.view;

import com.company.controller.GraphCreatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private JButton resetButton;
    private JButton moveButton;
    private JButton addVertexButton;
    private JButton connectVertexButton;
    private JButton deleteButton;

    public ToolBar(GraphCreatorController controller) {
        this.controller = controller;
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        initButtons();
        initLabelHelp();
        initButtonControlAlgorithms();
    }

    private void initButtons() {
        JPanel panelButton = new JPanel();
        List<JButton> buttonList = new ArrayList<>();
        createButton(SAVE,e->controller.saveGraph(),buttonList,true);
        createButton(LOAD,e->controller.loadGraph(),buttonList,true);
        moveButton = createButton(MOVE,e->controller.setStateOfMotion(),buttonList,true);
        addVertexButton = createButton(ADD_VERTEX,e->controller.setStateOfAddingVertices(),buttonList,true);
        connectVertexButton = createButton(CONNECT_VERTEX,e->controller.setStateOfConnectionVertices(),buttonList,true);
        deleteButton = createButton(DELETE,e->controller.setStateOfDelete(),buttonList,true);
        comboBoxAlgorithms = new JComboBox(ITEMS);
        comboBoxAlgorithms.addActionListener(e -> controller.setStateOfAlgorithm());
        buttonList.forEach(button->panelButton.add(button));
        panelButton.add(comboBoxAlgorithms);
        add(panelButton, BorderLayout.NORTH);
    }

    private void initLabelHelp() {
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
        List<JButton> buttonList = new ArrayList<>();
        backStepButton = createButton(BACK,e->controller.backStep(),buttonList,false);
        startButton = createButton(START, e -> controller.startAlgorithm(),buttonList,false);
        resetButton = createButton(RESET,e->controller.resetAlgorithm(),buttonList,false);
        finishButton =createButton(FINISH,e->controller.finishAlgorithm(),buttonList,false);
        nextStepButton =createButton(NEXT,e->controller.nextStep(),buttonList,false);
        buttonList.forEach(button->panel.add(button));
        add(panel, BorderLayout.SOUTH);
    }

    private JButton createButton(String name, ActionListener listener,List<JButton> container,boolean enabled){
        JButton button = new JButton(name);
        button.addActionListener(listener);
        button.setEnabled(enabled);
        container.add(button);
        return button;
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

    public void setEnabledResetButton(boolean show){resetButton.setEnabled(show);}

    public String getSelectAlgorithm() {
        return comboBoxAlgorithms.getSelectedItem() != null ? comboBoxAlgorithms.getSelectedItem().toString() : null;
    }

    public JLabel getLabelHelp() {
        return labelHelp;
    }

    public JButton getMoveButton() {
        return moveButton;
    }

    public JButton getAddVertexButton() {
        return addVertexButton;
    }

    public JButton getConnectVertexButton() {
        return connectVertexButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
