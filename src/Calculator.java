import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        boolean isFristOperation = true;

        while (true) {
            System.out.print("Введите число (или 's' для выхода):");
            if (scanner.hasNextDouble()) {
                int number = scanner.nextInt();

                if (isFristOperation) {
                    result = number;
                    isFristOperation = false;
                } else {
                    System.out.print("Введите операцию (+, -, *, /, C):");
                    String operation = scanner.next();
                    if (operation.equals("C")) {
                        result = 0;
                        isFristOperation = true;

                        System.out.println("Результат сброшен.");
                        continue;
                    }
                    if (operation.equals("s")) {

                        System.out.println("Выход из программы.");
                        break;
                    }
                    result = performOperation(result, number, operation);
                    System.out.println("Результат: " + result);
                }
            } else {
                String input = scanner.next();
                if (input.equals("s")) {
                    System.out.println("Выход из программы.");
                    break;
                } else {

                    System.out.println("Неправильный ввод числа!");
                }
            }
        }
        scanner.close();
    }

    private static int performOperation(int num1, int num2, String operation) {
        int result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                }
                break;
            default:
                System.out.println("Неправильная операция!");
        }

        return result;
    }
}

