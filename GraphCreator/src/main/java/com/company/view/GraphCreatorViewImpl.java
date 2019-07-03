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

public class GraphCreatorViewImpl extends JFrame implements GraphCreatorView{

    private final GraphCreatorController controller;
    private final GraphCreatorModel model;
    private ToolBar toolBar;

    public GraphCreatorViewImpl(GraphCreatorController controller, GraphCreatorModel model) {
        super("Graph creator");
        this.controller = controller;
        this.model = model;
        initGUI();
        controller.setView(this);

    }

    private void initGUI() {
        setSize(Constants.Size.WIDTH, Constants.Size.HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(INTEND, INTEND));
        panel.setBorder(new EmptyBorder(INTEND, INTEND, INTEND, INTEND));
        toolBar = new ToolBar(controller);
        toolBar.setPreferredSize(new Dimension(Constants.Size.WIDTH, (int) (Constants.Size.HEIGHT * 0.1)));
        Creator creator = new Creator(controller, model);
        creator.setPreferredSize(new Dimension(Constants.Size.WIDTH, (int) (Constants.Size.HEIGHT * 0.85)));
        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(creator, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    @Override
    public void setEnabledControlStepButton(boolean show) {
        toolBar.setEnabledControlStepButton(show);
    }

    @Override
    public void setLabelHelp(String strHelp) {
        toolBar.setLabelHelp(strHelp);
    }

    @Override
    public void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(this, message,title,JOptionPane.ERROR_MESSAGE);
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
}
