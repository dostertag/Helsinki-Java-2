package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new PersonalCalculator());
        SwingUtilities.invokeLater(ui);
//        Calculator calc = new PersonalCalculator();
//        System.out.println("Value: " + calc.giveValue());
//        calc.increase();
//        System.out.println("Value: " + calc.giveValue());
//        calc.increase();
//        System.out.println("Value: " + calc.giveValue());
    }
}
