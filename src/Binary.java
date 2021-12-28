import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Binary class creates a Binary calculator that does the same operations as Decimal
 * but with binary numbers. It also has two converters to allow the user to convert
 * decimals to binary and binary to decimals. This class extends JFrame and has one constructor.
 * Additionally, it has three private fields of num1, num2, and operator.
 */
public class Binary extends JFrame {
    private static String operator = "";
    private static String num1 = "";
    private static String num2 = "";

    /**
     * The Binary constructor which creates the binary calculator screen
     */
    Binary() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);  //creating the panel
        this.add(panel);

        panel.add(Layout.createMenu("bin"), BorderLayout.NORTH);//adding the menu


        //adding the calculator
        var title = new JLabel("Binary Calculator");
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.add(title);

        var instructions = new JLabel("Binary Numbers contain 0's and 1's (i.e. 1101)");
        instructions.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(instructions);

        var input1 = new TextField(20);  //adding text fields
        panel.add(input1);

        var symbol = new JComboBox<String>();   //adding symbol choices
        symbol.addItem("+");
        symbol.addItem("-");
        symbol.addItem("*");
        symbol.addItem("/");
        panel.add(symbol);

        var input2 = new TextField(20);  //another text field
        panel.add(input2);

        var buttonEquals = new JButton("=");   //adding equals button
        panel.add(buttonEquals);

        var output = new JLabel("");   //the output
        panel.add(output);

        var message = new JLabel();  //adding the error label

        buttonEquals.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        num1 = input1.getText();  //getting input
                        num2 = input2.getText();

                        operator = symbol.getItemAt(symbol.getSelectedIndex());  //getting operator

                        try {
                            if (num2.equals("0") && operator.equals("/")) {  //checking for division by zero
                                throw new ArithmeticException();
                            }
                            message.setText("");
                            int val1 = Integer.parseInt(num1, 2);  //converting from Bin String to decimal
                            int val2 = Integer.parseInt(num2, 2);


                            int[] answer = Computation.compute(val1, val2, operator); //calling computation method
                            int total = answer[0];


                            String totalBin = Integer.toBinaryString(total);   //converting int to binary
                            if (operator.equals("/")) {  //accounting for remainder if division
                                int remainder = answer[1];
                                String remainderBin = Integer.toBinaryString(remainder);
                                output.setText("Result: " + totalBin + " remainder " + remainderBin); //displaying the output
                            } else {
                                output.setText("Result: " + totalBin); //displaying the output
                            }
                            output.setFont(new Font("Serif", Font.PLAIN, 35));
                        } catch (NumberFormatException n) {
                            output.setText("");
                            message.setText("Please enter a valid value");
                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        } catch (ArithmeticException a) {
                            output.setText("");
                            message.setText("Cannot Divide By Zero");
                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        }
                    }
                });

        //adding the conversion from Binary to Decimal
        var title2 = new JLabel("Convert Binary to Decimal");
        title2.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title2);

        var conversionInput1 = new TextField(20);  //adding text field
        panel.add(conversionInput1);

        var equalsButton = new JButton("=");   //adding equals button
        panel.add(equalsButton);

        var outputConversion = new JLabel("");   //the output
        panel.add(outputConversion);

        equalsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        num1 = conversionInput1.getText();  //getting input

                        try {
                            message.setText("");
                            int decNum = Integer.parseInt(num1, 2);

                            outputConversion.setText("                Result: " + decNum + "                ");
                            outputConversion.setFont(new Font("Serif", Font.PLAIN, 35));
                        } catch (NumberFormatException n) {
                            output.setText("");
                            message.setText("Please enter a valid value");
                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        }

                    }
                });


        //adding the conversion from Decimal to Binary
        var title3 = new JLabel("Convert Decimal to Binary");
        title3.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title3);

        var conversionInput2 = new TextField(20);  //adding text field
        panel.add(conversionInput2);

        var equalsButton2 = new JButton("=");   //adding equals button
        panel.add(equalsButton2);

        var outputConversion2 = new JLabel("");   //the output
        panel.add(outputConversion2);

        equalsButton2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        num1 = conversionInput2.getText();  //getting input
                        try {
                            message.setText("");
                            int decimalNum = Integer.parseInt(num1);
                            String binaryNum = Integer.toBinaryString(decimalNum);

                            outputConversion2.setText("                Result: " + binaryNum + "                ");
                            outputConversion2.setFont(new Font("Serif", Font.PLAIN, 35));
                        } catch (NumberFormatException n) {
                            output.setText("");
                            message.setText("Please enter a valid value");
                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        }


                    }
                });


    }
}
