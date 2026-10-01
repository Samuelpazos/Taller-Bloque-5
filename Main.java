import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante(
                "E-2026-001",
                "Ana García",
                "ana.garcia@universidad.edu",
                "2026001",
                "Ingeniería de Sistemas"
        );

        Ejemplar ejemplar = new Ejemplar("BK-1001", "Estructura de Datos");

        Prestamo prestamo = new Prestamo(
                estudiante,
                ejemplar,
                LocalDate.of(2026, 9, 30),
                LocalDate.of(2026, 10, 10)
        );

        prestamo.renovar(LocalDate.of(2026, 10, 15));
        estudiante.notificar("Su préstamo fue renovado.");

        System.out.println("Nueva fecha de devolución: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());
    }
}
