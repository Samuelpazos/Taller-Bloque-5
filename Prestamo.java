import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrestamo;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public static class Renovacion {
        private LocalDate fechaRenovacion;
        private LocalDate fechaAnterior;
        private LocalDate nuevaFecha;

        public Renovacion(LocalDate fechaAnterior, LocalDate nuevaFecha) {
            this.fechaRenovacion = LocalDate.now();
            this.fechaAnterior = fechaAnterior;
            this.nuevaFecha = nuevaFecha;
        }

        public LocalDate getFechaRenovacion() {
            return fechaRenovacion;
        }

        public LocalDate getFechaAnterior() {
            return fechaAnterior;
        }

        public LocalDate getNuevaFecha() {
            return nuevaFecha;
        }
    }

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrestamo, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        if (nuevaFecha == null || !nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException("La nueva fecha debe ser posterior a la fecha actual de devolución.");
        }

        Renovacion renovacion = new Renovacion(fechaPrevistaDevolucion, nuevaFecha);
        renovaciones.add(renovacion);
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public List<Renovacion> getRenovaciones() {
        return renovaciones;
    }

    public int getCantidadRenovaciones() {
        return renovaciones.size();
    }
}