import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The Computation class provides many methods that the calculators use to produce their
 * desired output.
 */
public abstract class Computation {


    /**
     * The compute method makes calculations for the Decimal calculator
     *
     * @param num1     The first input value
     * @param num2     The second input value
     * @param operator The operation selected by user
     * @return double[]{total, remainder} an array of the answer to the calculation and the remainder if the user specified division
     */
    public static double[] compute(double num1, double num2, String operator) {  //compute method for decimal

        double total = 0;
        double remainder = 0;

        switch (operator) {
            case "+" -> total = num1 + num2;
            case "-" -> total = num1 - num2;
            case "*" -> total = num1 * num2;
            case "/" -> {
                if (num2 == 0)
                    throw new NumberFormatException("Cannot Divide by Zero");
                total = num1 / num2;
                remainder = num1 % num2;
            }
        }

        return new double[]{total, remainder};
    }

    /**
     * The compute method does calculations for the Binary and Hex calculators
     *
     * @param num1     The first input value
     * @param num2     The second input value
     * @param operator The operation selected
     * @return int[]{total, remainder} an array containing the answer to the calculation and the remainder if the operation was division
     */
    public static int[] compute(int num1, int num2, String operator) {   //compute method for binary and hex  //overloading the decimal compute method

        int total = 0;
        int remainder = 0;

        switch (operator) {
            case "+" -> total = num1 + num2;
            case "-" -> total = num1 - num2;
            case "*" -> total = num1 * num2;
            case "/" -> {
                total = num1 / num2;
                remainder = num1 % num2;
            }
        }

        return new int[]{total, remainder};
    }

    /**
     * the compute method does a calculation for the Big Integer calculator
     *
     * @param num1      the first input value
     * @param num2      the second input value
     * @param operation the operation selected
     * @return output the BigDecimal output
     */
    public static String compute(String num1, String num2, String operation) {   //computing the output for Big Integer //overloading compute method
        String output = "";
        switch (operation) {    //choosing which operation to do
            case "X + Y":
                BigDecimal bigNum1 = new BigDecimal(num1);
                BigDecimal bigNum2 = new BigDecimal(num2);

                BigDecimal total = bigNum1.add(bigNum2);
                output = total.toString();
                break;
            case "X - Y":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);

                total = bigNum1.subtract(bigNum2);
                output = total.toString();
                break;
            case "X * Y":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);

                total = bigNum1.multiply(bigNum2);
                output = total.toString();
                break;
            case "X / Y":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);

                total = bigNum1.divide(bigNum2, RoundingMode.HALF_UP);
                output = total.toString();
                break;
            case "X^Y":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);
                int intNum2 = bigNum2.intValue();

                total = bigNum1.pow(intNum2);
                output = total.toString();
                break;
            case "sqrt(X)":
                bigNum1 = new BigDecimal(num1);
                total = bigNum1.sqrt(MathContext.DECIMAL32);

                output = total.toString();
                break;
            case "X^2":
                bigNum1 = new BigDecimal(num1);
                total = bigNum1.pow(2);
                output = total.toString();
                break;
            case "X!":
                int val1 = Integer.parseInt(num1);
                BigInteger fac = Computation.factorial(val1);
                output = fac.toString();
                break;
            case "MOD":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);

                BigInteger bigInt1 = bigNum1.toBigInteger();
                BigInteger bigInt2 = bigNum2.toBigInteger();

                BigInteger totalInt = bigInt1.mod(bigInt2);
                output = totalInt.toString();
                break;
            case "GCD":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);

                bigInt1 = bigNum1.toBigInteger();
                bigInt2 = bigNum2.toBigInteger();

                totalInt = bigInt1.gcd(bigInt2);
                output = totalInt.toString();
                break;
            case "LCM":
                bigNum1 = new BigDecimal(num1);
                bigNum2 = new BigDecimal(num2);

                bigInt1 = bigNum1.toBigInteger();
                bigInt2 = bigNum2.toBigInteger();

                totalInt = Computation.lcm(bigInt1, bigInt2);
                output = totalInt.toString();
                break;
        }

        return output;
    }


    /**
     * factorial calculates the factorial of a BigDecimal
     *
     * @param number the input value to be converted to factorial
     * @return factorial the factorial of number
     */
    public static BigInteger factorial(int number) {  //calculates factorial for Big Integer
        BigInteger factorial = BigInteger.ONE;
        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


    /**
     * lcm calculates the least common multiple of two BigIntegers
     *
     * @param values the BigInteger values inputted
     * @return lcm the least common multiple of the input values
     */
    public static BigInteger lcm(BigInteger... values) {  //finds the LCM for Big Integer
        if (values.length == 0)
            return BigInteger.ONE;
        BigInteger lcm = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i].signum() != 0) {
                final BigInteger gcd = lcm.gcd(values[i]);
                if (gcd.equals(BigInteger.ONE)) {
                    lcm = lcm.multiply(values[i]);
                } else {
                    if (!values[i].equals(gcd)) {
                        lcm = lcm.multiply(values[i].divide(gcd));
                    }
                }
            }
        }
        return lcm;
    }


}
