import java.util.Scanner;

public class name {
    public static String calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Ошибка: неверный ввод. Ожидается: <число> <операция> <число>");   /// Проверка на корректное количество символов
        }

        int num1;
        int num2;
        String operator = parts[1];

        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка: вводите числа корректно.");   /// ошибка при введении числа с буквами и символами
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Упс, ошибка: числа должны быть от 1 до 10.");   /// Числа в пределах от 1 до 10
        }

        switch (operator) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Ошибка: деление на ноль.");
                }
                return String.valueOf(num1 / num2);
            default:
                throw new IllegalArgumentException("Ошибка: неизвестная операция. Поддерживаются: +, -, *, /.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ты в калькуляторе, пожалуйста, введи свой пример");

        try {
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

