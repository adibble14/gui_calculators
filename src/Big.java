import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Big class creates a BigInteger Calculator that provides many operations for very large values.
 * This class extends JFrame and has one constructor. It also has three private fields of num1, num2, and operationChosen.
 */
public class Big extends JFrame {
    private static String num1 = "";
    private static String num2 = "";
    private static String operationChosen = "";

    /**
     * The Big constructor which creates the Big Integer calculator
     */
    Big() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);  //creating the panel
        this.add(panel);

        panel.add(Layout.createMenu("big"), BorderLayout.NORTH);//adding the menu

        //adding the calculator
        var title = new JLabel("Big Number Calculator");
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.add(title);

        var instructions = new JLabel("Big Numbers can be very large numbers in the form of integers, decimals,");
        var instructions2 = new JLabel("                                              or scientific notation in the form '23E18'                                        ");
        instructions.setFont(new Font("Serif", Font.PLAIN, 15));
        instructions2.setFont(new Font("Serif", Font.PLAIN, 15));
        panel.add(instructions);
        panel.add(instructions2);

        var x = new JLabel("X = ");
        panel.add(x);
        var input1 = new TextField(15);  //adding text fields
        panel.add(input1);

        var y = new JLabel("Y = ");
        panel.add(y);
        var input2 = new TextField(15);  //adding text fields
        panel.add(input2);

        //adding the operation options
        var operation = new JComboBox<String>();   //adding operation choices
        operation.addItem("X + Y");
        operation.addItem("X - Y");
        operation.addItem("X * Y");
        operation.addItem("X / Y");
        operation.addItem("X^Y");
        operation.addItem("sqrt(X)");
        operation.addItem("X^2");
        operation.addItem("X!");
        operation.addItem("MOD");
        operation.addItem("GCD");
        operation.addItem("LCM");
        panel.add(operation);

        var equalsButton = new JButton("="); //adding equals button
        panel.add(equalsButton);

        var output = new JLabel("");  //adding output label
        panel.add(output);

        var message = new JLabel();  //adding the label for errors

        equalsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        num1 = input1.getText(); //getting input
                        num2 = input2.getText();

                        operationChosen = operation.getItemAt(operation.getSelectedIndex());

                        try {
                            if (num2.equals("0") && operationChosen.equals("X / Y")) { //checking for division by zero
                                throw new ArithmeticException("division by zero");
                            } else if (num1.charAt(0) == '-' && operationChosen.equals("sqrt(x)")) {
                                throw new ArithmeticException("Attempted square root of negative BigDecimal");
                            } else if (num1.charAt(0) == '-' && operationChosen.equals("X!")) {
                                throw new ArithmeticException("negative factorial");
                            }


                            message.setText("");

                            num1 = checkScientific(num1);
                            num2 = checkScientific(num2);

                            String answer = Computation.compute(num1, num2, operationChosen);  //calling compute method in class Computation

                            output.setText("Result: " + answer);  //displaying the result
                            output.setFont(new Font("Serif", Font.PLAIN, 35));
                        } catch (NumberFormatException n) {
                            output.setText("");
                            message.setText("Please enter a valid value");
                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        } catch (ArithmeticException a) {
                            output.setText("");

                            if (a.getMessage().equals("division by zero")) {
                              message.setText("Cannot Divide By Zero");
                            }else if (a.getMessage().equals("Attempted square root of negative BigDecimal")) {
                                message.setText("Value must be positive");
                            } else if (a.getMessage().equals("negative factorial")) {
                                message.setText("Value must be positive");
                            }else if(a.getMessage().equals("Invalid operation")){
                                message.setText("Value is too Large");
                            }

                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        }
                    }
                });
    }


    /**
     * the checkScientific method checks to see if the user entered numbers in using scientific notation
     *
     * @param num The input by the user
     * @return num The formatted number as a Big Decimal
     */
    public String checkScientific(String num) {  //checks if user used scientific notation and converts to BigDecimal
        int eIndex = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == 'E') {
                eIndex = i;
            }
        }

        if (eIndex > 0) {
            String beforeE = num.substring(0, eIndex);
            String afterE = num.substring(eIndex + 1);
            int numAfterE = Integer.parseInt(afterE);
            String zeros = "";
            int i = 0;

            while (i < numAfterE) {  //adding zeros to the String
                zeros += "0";
                i++;
            }

            num = beforeE + zeros;
        }

        return num;
    }
}
