package com.company.view;

import com.company.Constants;
import com.company.controller.GraphCreatorController;
import com.company.model.GraphCreatorModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import static com.company.Constants.Size.*;

public class GraphCreatorViewImpl extends JFrame implements GraphCreatorView {

    private final GraphCreatorController controller;
    private final GraphCreatorModel model;
    private ToolBar toolBar;
    private JTextArea textArea;

    public GraphCreatorViewImpl(GraphCreatorController controller, GraphCreatorModel model) {
        super("Graph creator");
        this.controller = controller;
        this.model = model;
        initGUI();
        controller.setView(this);

    }

    private void initGUI() {
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(sSize.width, sSize.height);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(INTEND, INTEND));
        panel.setBorder(new EmptyBorder(INTEND, INTEND, INTEND, INTEND));
        toolBar = new ToolBar(controller);
        toolBar.setPreferredSize(new Dimension((int) (sSize.width * 0.95), (int) (sSize.height * 0.12)));
        Creator creator = new Creator(controller, model);
        creator.setPreferredSize(new Dimension((int) (sSize.width * 0.7), (int) (sSize.height * 0.75)));
        textArea = new JTextArea(100, 50);
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension((int) (sSize.width * 0.25), (int) (sSize.height * 0.75)));
        panel.add(scrollPane, BorderLayout.WEST);
        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(creator, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    @Override
    public void setEnabledStartButton(boolean show) {
        toolBar.setEnabledStartButton(show);
    }

    @Override
    public void setEnabledFinishButton(boolean show) {
        toolBar.setEnabledFinishButton(show);
    }

    @Override
    public void setEnabledNextButton(boolean show) {
        toolBar.setEnabledNextButton(show);
    }

    @Override
    public void setEnabledBackButton(boolean show) {
        toolBar.setEnabledBackButton(show);
    }

    @Override
    public void setEnabledResetButton(boolean show) {
        toolBar.setEnabledResetButton(show);
    }

    @Override
    public void setLabelHelp(String strHelp) {
        toolBar.setLabelHelp(strHelp);
    }

    @Override
    public void setLog(String message) {
        textArea.append(message + "\n");
    }

    @Override
    public void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String showInputDialog(String title, String message) {
        return JOptionPane.showInputDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public File showFileChooserDialog(String title) {
        JFileChooser fileOpen = new JFileChooser();
        int ret = fileOpen.showDialog(null, title);
        if (ret == JFileChooser.APPROVE_OPTION)
            return fileOpen.getSelectedFile();
        else
            return null;
    }

    @Override
    public String getSelectAlgorithm() {
        return toolBar.getSelectAlgorithm();
    }

    public ToolBar getToolBar() {
        return toolBar;
    }
}
