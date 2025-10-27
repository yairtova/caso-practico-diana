import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        shell myShell = new shell("/home/user");
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Bienvenido al shell interactivo. Directorio inicial: " + myShell.getDirectorioActual());
        System.out.println("Comandos disponibles: cd <directorio>, back, prev, exit");

        while (true) {
            System.out.print("\n" + myShell.getDirectorioActual() + " > ");
            command = scanner.nextLine();

            if (command.startsWith("cd ")) {
                String newDirectory = command.substring(3).trim();
                myShell.cd(newDirectory);
            } else if (command.equals("back")) {
                myShell.back();
            } else if (command.equals("prev")) {
                String anterior = myShell.prev();
                if (anterior != null) {
                    System.out.println("Directorio anterior: " + anterior);
                }
            } else if (command.equals("exit")) {
                System.out.println("Saliendo del shell.");
                break;
            } else {
                System.out.println("Comando no reconocido. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}