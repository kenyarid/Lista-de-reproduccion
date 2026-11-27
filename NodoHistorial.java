package listareproduccion;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NodoHistorial {
    private String url;
    private LocalTime horaVisita;
    private NodoHistorial anterior;
    private NodoHistorial siguiente;

    public NodoHistorial(String url) {
        this.url = url;
        this.horaVisita = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.anterior = null;
        this.siguiente = null;
    }

    // Getters y Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalTime getHoraVisita() {
        return horaVisita;
    }

    public NodoHistorial getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoHistorial anterior) {
        this.anterior = anterior;
    }

    public NodoHistorial getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHistorial siguiente) {
        this.siguiente = siguiente;
    }
}