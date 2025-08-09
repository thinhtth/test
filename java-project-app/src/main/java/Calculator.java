import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true; 

        System.out.println("=== Simple Calculator ===");
        System.out.println("Note: All numbers must be integers within the given range.");

        // Đặt cận dưới và cận trên (có thể đổi tùy ý)
        int lowerLimit = -10;
        int upperLimit = 10;

        while (continueCalc) {
            int num1 = readIntInRange(scanner, "Enter first number", lowerLimit, upperLimit);

            char operator = readOperator(scanner);

            int num2;
            while (true) {
                num2 = readIntInRange(scanner, "Enter second number", lowerLimit, upperLimit);
                if (operator == '/' && num2 == 0) {
                    System.out.println("Error: Division by zero! Please enter a non-zero number.");
                } else {
                    break;
                }
            }

            // ===== Tính toán =====
            double result = 0; 
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = (double) num1 / num2; break;
            }

            System.out.println("Result: " + result);

            // ===== Hỏi tiếp tục =====
            System.out.print("Do you want to continue? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice == 'n' || choice == 'N') {
                continueCalc = false;
            }
        }

        scanner.close();
        System.out.println("Calculator exited.");
    }

    // Hàm đọc số nguyên trong khoảng [min, max]
    private static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.printf("%s (%d to %d): ", prompt, min, max);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Error: Number out of range. Please try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // bỏ dữ liệu sai
            }
        }
    }

    // Hàm đọc toán tử hợp lệ
    private static char readOperator(Scanner scanner) {
        while (true) {
            System.out.print("Enter operator (+, -, *, /): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("Invalid operator! Please enter one of +, -, *, /.");
        }
    }
}