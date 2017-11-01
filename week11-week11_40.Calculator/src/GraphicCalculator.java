
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calc;
    private JTextField output;
    private JTextField input;
    private JButton plus;
    private JButton minus;
    private JButton zero;

    @Override
    public void run() {
        this.calc = new Calculator();
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        this.output = new JTextField();
        output.setEnabled(false);
        this.input = new JTextField();
        input.setEnabled(true);
        this.output.setText("0");
        container.add(this.output);
        container.add(this.input);
        container.add(transports());
    }

    public JFrame getFrame() {
        return frame;
    }
    private JPanel transports() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        this.plus = new JButton("+");
        this.minus = new JButton("-");
        this.zero = new JButton("Z");
        panel.add(plus);
        panel.add(minus);
        panel.add(zero);
        
        ClickListener calcListener = new ClickListener(this.calc, this.input, this.output, this.plus, 
                                                        this.minus, this.zero);
        
        plus.addActionListener(calcListener);
        minus.addActionListener(calcListener);
        zero.addActionListener(calcListener);
        zero.setEnabled(false);
        
        return panel;
    }
}