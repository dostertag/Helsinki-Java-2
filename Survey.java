package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        this.frame = new JFrame("Survey");
        this.frame.setPreferredSize(new Dimension(200, 300));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
        
    }
    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        ButtonGroup groupOne = new ButtonGroup();
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton because = new JRadioButton("Because it is fun!");
        container.add(new JLabel("Are you?"));
        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));
        container.add(new JLabel("Why?"));
        groupOne.add(noReason);
        groupOne.add(because);
        container.add(noReason);
        container.add(because);
        container.add(new JButton("Done!"));
    }

    public JFrame getFrame() {
        return frame;
    }
}
