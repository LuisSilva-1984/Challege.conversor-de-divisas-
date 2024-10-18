import java.util.Scanner;

public class Menu {

    private static final String[][] CURRENCIES = {
            {"ARS", "Peso Argentino"},
            {"BOB", "Boliviano"},
            {"BRL", "Real Brasileño"},
            {"CLP", "Peso Chileno"},
            {"COP", "Peso Colombiano"},
            {"USD", "Dólar Estadounidense"}
    };

    // Método para mostrar el menú de selección de divisa
    public String selectCurrency(Scanner scanner, String tipo) {
        return selectCurrency(scanner, tipo, null);
    }

    // Método sobrecargado para excluir una moneda en la selección (como el caso de origen/destino)
    public String selectCurrency(Scanner scanner, String tipo, String excludeCurrency) {
        int option = -1;

        while (option < 1 || option > CURRENCIES.length) {
            System.out.println("\n Selecciona la moneda de " + tipo + ":\n");
            for (int i = 0; i < CURRENCIES.length; i++) {
                if (!CURRENCIES[i][0].equals(excludeCurrency)) {
                    System.out.println((i + 1) + ". " + CURRENCIES[i][1] + " (" + CURRENCIES[i][0] + ")");
                }
            }

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 1 || option > CURRENCIES.length || CURRENCIES[option - 1][0].equals(excludeCurrency)) {
                    System.out.println("Opción inválida. Por favor selecciona una opción válida.");
                    option = -1; // Reinicia la opción si es inválida
                }
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }

        return CURRENCIES[option - 1][0];
    }
}
