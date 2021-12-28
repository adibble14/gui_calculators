import javax.swing.*;

/**
 * This is the main class of the program that creates a Welcome object
 * and instantiates the Frame
 */
public class Main {
    /**
     * This is the main method that starts the program and creates an instance of the Welcome class.
     *
     * @param args
     */
    public static void main(String[] args) {
        var calc = new Welcome();
        calc.setTitle("Calculator");
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setSize(600, 600);
        calc.setVisible(true);
    }
}