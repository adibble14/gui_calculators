import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Layout class creates the menu for each Frame of the calculator. It also specifies which section
 * of the menu you are at to provide easy transportation between calculators.
 */
public abstract class Layout {

    /**
     * The createMenu method creates the menu tab for each screen. It also assigns which
     * tab is selected based on which frame calls it.
     *
     * @param selected The frame which is calling the menu and tells the method to make its menu item true
     * @return tabs The JPanel of the menu
     */
    public static JPanel createMenu(String selected) {   //creates a menu for panel
        var tabs = new JPanel();
        JRadioButtonMenuItem welcome = new JRadioButtonMenuItem();  //creates radio buttons for menu
        JRadioButtonMenuItem dec = new JRadioButtonMenuItem();
        JRadioButtonMenuItem bin = new JRadioButtonMenuItem();
        JRadioButtonMenuItem hex = new JRadioButtonMenuItem();
        JRadioButtonMenuItem big = new JRadioButtonMenuItem();

        switch (selected) {
            case "welcome" -> {    //checks to see which button should be selected
                welcome = new JRadioButtonMenuItem("Welcome", true);
                dec = new JRadioButtonMenuItem("Decimal");
                bin = new JRadioButtonMenuItem("Binary");
                hex = new JRadioButtonMenuItem("Hex");
                big = new JRadioButtonMenuItem("Big");
                tabs.add(welcome);
                tabs.add(dec);
                tabs.add(bin);
                tabs.add(hex);
                tabs.add(big);
            }
            case "dec" -> {
                welcome = new JRadioButtonMenuItem("Welcome");
                dec = new JRadioButtonMenuItem("Decimal", true);
                bin = new JRadioButtonMenuItem("Binary");
                hex = new JRadioButtonMenuItem("Hex");
                big = new JRadioButtonMenuItem("Big");
                tabs.add(welcome);
                tabs.add(dec);
                tabs.add(bin);
                tabs.add(hex);
                tabs.add(big);
            }
            case "bin" -> {
                welcome = new JRadioButtonMenuItem("Welcome");
                dec = new JRadioButtonMenuItem("Decimal");
                bin = new JRadioButtonMenuItem("Binary", true);
                hex = new JRadioButtonMenuItem("Hex");
                big = new JRadioButtonMenuItem("Big");
                tabs.add(welcome);
                tabs.add(dec);
                tabs.add(bin);
                tabs.add(hex);
                tabs.add(big);
            }
            case "hex" -> {
                welcome = new JRadioButtonMenuItem("Welcome");
                dec = new JRadioButtonMenuItem("Decimal");
                bin = new JRadioButtonMenuItem("Binary");
                hex = new JRadioButtonMenuItem("Hex", true);
                big = new JRadioButtonMenuItem("Big");
                tabs.add(welcome);
                tabs.add(dec);
                tabs.add(bin);
                tabs.add(hex);
                tabs.add(big);
            }
            case "big" -> {
                welcome = new JRadioButtonMenuItem("Welcome");
                dec = new JRadioButtonMenuItem("Decimal");
                bin = new JRadioButtonMenuItem("Binary");
                hex = new JRadioButtonMenuItem("Hex");
                big = new JRadioButtonMenuItem("Big", true);
                tabs.add(welcome);
                tabs.add(dec);
                tabs.add(bin);
                tabs.add(hex);
                tabs.add(big);
            }
        }

        welcome.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        var welcome = new Welcome();
                        welcome.setTitle("Calculator");
                        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        welcome.setSize(600, 600);
                        welcome.setVisible(true);
                    }
                });
        dec.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        var decimal = new Decimal();
                        decimal.setTitle("Calculator");
                        decimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        decimal.setSize(600, 600);
                        decimal.setVisible(true);
                    }
                });
        bin.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        var bin = new Binary();
                        bin.setTitle("Calculator");
                        bin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        bin.setSize(600, 600);
                        bin.setVisible(true);
                    }
                });
        hex.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        var hex = new Hex();
                        hex.setTitle("Calculator");
                        hex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        hex.setSize(600, 600);
                        hex.setVisible(true);
                    }
                });
        big.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        var big = new Big();
                        big.setTitle("Calculator");
                        big.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        big.setSize(600, 600);
                        big.setVisible(true);
                    }
                });
        return tabs;
    }
}
