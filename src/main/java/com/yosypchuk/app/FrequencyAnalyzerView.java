package com.yosypchuk.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FrequencyAnalyzerView extends JFrame {

    private JTextArea inputTextArea = new JTextArea(10, 30);
    private JButton analyzeButton = new JButton("Analyze Text");
    private JTextArea outputTextArea = new JTextArea(10, 30);

    public FrequencyAnalyzerView() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);
        analyzeButton.setPreferredSize(new Dimension(200, 30));

        panel.add(new JScrollPane(inputTextArea), BorderLayout.NORTH);
        panel.add(analyzeButton, BorderLayout.CENTER);
        panel.add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.add(panel);
    }

    public String getInputText() {
        return inputTextArea.getText();
    }

    public void setOutputText(String text) {
        outputTextArea.setText(text);
    }

    public void addAnalyzeListener(ActionListener listener) {
        analyzeButton.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
