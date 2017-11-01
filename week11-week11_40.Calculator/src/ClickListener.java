
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class ClickListener implements ActionListener {
    
    private Calculator calc;
    private JTextField input;
    private JTextField output;
    private JButton plus;
    private JButton minus;
    private JButton zero;
    
    public ClickListener(Calculator calc, JTextField input, JTextField output, JButton plus,
                            JButton minus, JButton zero) {
        this.calc = calc;
        this.input = input;
        this.output = output;
        this.plus = plus;
        this.minus = minus;
        this.zero = zero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plus) {
            try {
                calc.add(Integer.parseInt(input.getText()));
                zero.setEnabled(true);
                output.setText(Integer.toString(calc.giveValue()));
            } catch (NumberFormatException ex) {}
            
            input.setText("");
           
        } else if (e.getSource() == minus) {
            try {
                calc.subtract(Integer.parseInt(input.getText()));
                zero.setEnabled(true);
                output.setText(Integer.toString(calc.giveValue()));
            } catch (NumberFormatException exception) {}
            input.setText("");
        } else {
            calc.reset();
            zero.setEnabled(false);
            output.setText(Integer.toString(calc.giveValue()));
            input.setText("");
        }
    }
    
}
