public class Calculator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Welcome to the Java Calculator!");
        
        while (true) {
            System.out.print("Enter first number (or 'exit' to quit): ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("exit")) {
                break;
            }
            
            System.out.print("Enter second number: ");
            String input2 = scanner.nextLine();
            
            System.out.print("Enter an operator (+, -, *, /): ");
            String operator = scanner.nextLine();
            
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = 0;
            
            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = divide(num1, num2);
                    } else {
                        System.out.println("Error: Division by zero.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    continue;
            }
            
            System.out.println("Result: " + result);
        }
        
        scanner.close();
        System.out.println("Thank you for using the Java Calculator!");
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}