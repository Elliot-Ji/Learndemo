package com.example.testdemo;

/**
 * @author 聂旸
 * @date 2025/03/28
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField textField;
    private JTextArea resultTextArea;
    private String currentExpression = "";

    public Calculator() {
        setTitle("计算器");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "0", "=", "", "/",
                "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-9]")) {
                currentExpression += command;
            } else if (command.matches("[+\\-*/]")) {
                currentExpression += " " + command + " ";
            } else if (command.equals("=")) {
                try {
                    String result = calculate(currentExpression);
                    resultTextArea.append(currentExpression + " = " + result + "\n");
                    currentExpression = result;
                } catch (Exception ex) {
                    resultTextArea.append(currentExpression + " = Error\n");
                    currentExpression = "Error";
                }
            } else if (command.equals("C")) {
                currentExpression = "";
            }
            textField.setText(currentExpression);
        }
    }

    private String calculate(String expression) {
        String[] parts = expression.split(" ");
        double result = Double.parseDouble(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].equals("+")) {
                result += Double.parseDouble(parts[i + 1]);
            } else if (parts[i].equals("-")) {
                result -= Double.parseDouble(parts[i + 1]);
            } else if (parts[i].equals("*")) {
                result *= Double.parseDouble(parts[i + 1]);
            } else if (parts[i].equals("/")) {
                result /= Double.parseDouble(parts[i + 1]);
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}