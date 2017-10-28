package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("");
        this.frame.setPreferredSize(new Dimension(400, 200));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JTextField textField = new JTextField();
        JButton copyButton = new JButton("Copy!");
        JLabel label = new JLabel("I was copied here from the JTextArea");
        
        ActionEventListener listener = new ActionEventListener(textField, label);
        copyButton.addActionListener(listener);
        
        container.add(textField);
        container.add(copyButton);
        container.add(label);
    }
}
