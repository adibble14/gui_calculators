import javax.swing.*;
import java.awt.*;

/**
 * The Welcome class creates the first screen of the program which disp[ays instructions for the user and provides
 * a menu to access the calculators. This class extends JFrame and has one constructor.
 */
public class Welcome extends JFrame {
    /**
     * The Welcome class constructor which creates the welcome screen
     */
    Welcome() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);  //creating the panel
        this.add(panel);

        panel.add(Layout.createMenu("welcome"), BorderLayout.NORTH);//adding the menu

        //the welcome screen and instructions
        var text = new JLabel("Welcome to the GUI Calculator");
        var instructions = new JLabel("                             Instructions:                           ");
        var num1 = new JLabel("1. Click on the above tabs to navigate to a calculator.");
        var num2 = new JLabel("                           2. Enter the appropriate values and follow the prompts.                           ");
        var num3 = new JLabel("                                           3. Watch the results appear!                                            ");
        var num4 = new JLabel("      Have fun calculating!");

        panel.add(text);
        panel.add(instructions);
        panel.add(num1);
        panel.add(num2);
        panel.add(num3);
        panel.add(num4);

        text.setFont(new Font("Serif", Font.PLAIN, 40));
        instructions.setFont(new Font("Serif", Font.PLAIN, 30));
    }
}
