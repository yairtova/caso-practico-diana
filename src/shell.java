import java.util.Stack;

public class shell {
    private Stack<String> historial;
    private String directorioActual;

    public shell(String directorioInicial) {
        this.historial = new Stack<>();
        this.directorioActual = directorioInicial;
    }

    public String getDirectorioActual() {
        return directorioActual;
    }

    public void cd(String nuevoDirectorio) {
        historial.push(directorioActual);
        directorioActual = nuevoDirectorio;
        System.out.println("Ahora se encuantra en: " + directorioActual);
    }

    public String back() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío.");
            return null;
        } else {
            String directorioAnterior = historial.pop();
            directorioActual = directorioAnterior;
            System.out.println("Regresado a: " + directorioActual);
            return directorioAnterior;
        }
    }

    public String peckAnterior() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío. no se han hecho movimientos.");
            return null;
        } else {
            return historial.peek();
        }
    }
}