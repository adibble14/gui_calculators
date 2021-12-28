import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Decimal class creates a decimal calculator that does basic computations such as
 * add, subtract, multiply and divide. This class extends JFrame and has one constructor.
 * It also contains three private fields that are used throughout the program (num1, num2, operator).
 */
public class Decimal extends JFrame {
    private static String operator = "";
    private static String num1 = "";
    private static String num2 = "";

    /**
     * The Decimal class constructor which creates the Decimal calculator screen
     */
    Decimal() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);  //creating the panel
        this.add(panel);

        panel.add(Layout.createMenu("dec"), BorderLayout.NORTH);//adding the menu


        //adding the calculator
        var title = new JLabel("Decimal Calculator");
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.add(title);

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
                        num1 = input1.getText();
                        num2 = input2.getText();

                        operator = symbol.getItemAt(symbol.getSelectedIndex());

                        try {  //checking for errors
                            message.setText("");  //setting error text back to ""
                            double val1 = Double.parseDouble(num1);
                            double val2 = Double.parseDouble(num2);

                            double[] answer = Computation.compute(val1, val2, operator);
                            double total = answer[0];

                            String totalStr;
                            if (total % 1 == 0) {    //formatting String
                                long totalLong = Math.round(total);
                                totalStr = totalLong + "";
                            } else {
                                totalStr = String.format("%,.2f", total);
                            }

                            output.setText("Result: " + totalStr); //displaying the output
                            output.setFont(new Font("Serif", Font.PLAIN, 35));
                        } catch (NumberFormatException n) {
                            output.setText("");
                            message.setText("Please enter a valid decimal");
                            panel.add(message);
                            message.setFont(new Font("Serif", Font.PLAIN, 20));
                            message.setForeground(Color.RED);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
    }
}
