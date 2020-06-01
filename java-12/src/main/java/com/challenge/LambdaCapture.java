package com.challenge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdaCapture {

    private final static int FIELD_WIDTH = 20;
    private static JTextField staticTextField;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        staticTextField = new JTextField(FIELD_WIDTH);
        staticTextField.setText("Static Field");

        JTextField localTextField = new JTextField(FIELD_WIDTH);
        localTextField.setText("Local Varible");

        JButton helloButton = new JButton("Say Hello");
        JButton goodbyButton = new JButton("Say Goodbye");

        //Using regular anonymous class
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staticTextField.setText("Hello, world!");
                localTextField.setText("Hello, world!");
            }
        });

        //Using lambda expression
        goodbyButton.addActionListener(event -> {
            staticTextField.setText("Goodbye world!");
            localTextField.setText("Goodbye, world!");
        });

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(staticTextField);
        contentPane.add(localTextField);
        contentPane.add(helloButton);
        contentPane.add(goodbyButton);

        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

}
