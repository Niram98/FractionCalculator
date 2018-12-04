import  java.util.Scanner;

public class FractionCalculator {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
       intro();
       while(true) {
            String operation = getOperation(input);
            if (operation.equalsIgnoreCase("q")) {
                break;
            }
            Fraction fraction1 = getFraction(input);
            Fraction fraction2 = getFraction(input);
            System.out.print(fraction1.toString() + " " + operation + " " + fraction2.toString());
            if (operation.equals("+")) {
                Fraction result = fraction1.add(fraction2);
                result.toLowestTerms();
                System.out.println(" = " + result.toString());
            }
            if (operation.equals("-")) {
                Fraction result = fraction2.subtract(fraction1);
                result.toLowestTerms();
                System.out.println(" = " + result.toString());
            }
            if (operation.equals("*")) {
                Fraction result = fraction1.multiply(fraction2);
                result.toLowestTerms();
                System.out.println(" = " + result.toString());
            }
            if (operation.equals("/")) {
                Fraction result = fraction2.divide(fraction1);
                result.toLowestTerms();
                System.out.println(" = " + result.toString());
            }
            if (operation.equals("=")) {
                boolean result = fraction1.equals(fraction2);
                System.out.println(" is " + result);
            }
           System.out.println("--------------------------------------------------------------------------------");
       }
    }

    public static  void  intro() {

        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static  String getOperation(Scanner input) {

        System.out.print("Please enter an operation (+, -, *, /, = or Q to quit): ");
        String operation = input.next();
        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")
                && !operation.equals("=") && !operation.equalsIgnoreCase("Q")) {
            System.out.print("Invalid input (+, -, *, /, = or Q to quit): ");
            operation = input.next();
        }
        return operation;
    }

    public  static Fraction getFraction(Scanner input) {

        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String fraction = input.next();
        while (!validFraction(fraction)) {
            System.out.print("Invalid fraction. ");
            System.out.print("Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            fraction = input.next();
        }
         if (fraction.contains("/")) {
            Integer numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
            Integer denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
            return new Fraction(numerator, denominator);
        } else {
            Integer numerator = Integer.parseInt(fraction);
            return new Fraction(numerator);
        }
    }

    public static boolean validFraction(String input) {

        if (!input.contains("-") || input.indexOf("-") == 0) {
            if (input.contains("-")) {
                input = input.substring(1);
                if (!input.contains("/")){
                    if (isNumber(input)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    String numerator = input.substring(0, input.indexOf("/"));
                    String denominator = input.substring(input.indexOf("/") + 1);
                    if (isNumber(numerator) && isNumber(denominator) && !denominator.equals("0")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                if (!input.contains("/")){
                    if (isNumber(input)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    String numerator = input.substring(0, input.indexOf("/"));
                    String denominator = input.substring(input.indexOf("/") + 1);
                    if (isNumber(numerator) && isNumber(denominator) && !denominator.equals("0")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isNumber(String input) {

        if (input.matches("[0-9]+")) {
            return true;
        }
        return  false;
    }


}
