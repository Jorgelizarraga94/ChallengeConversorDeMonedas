package Model;
public class Monedas {
    private String monedaACambiar = "";
    private String monedaCambio = "";
    private Integer monto;

    public Monedas() {
    }

    public Monedas(String monedaACambiar, String monedaCambio) {
        this.monedaACambiar = monedaACambiar;
        this.monedaCambio = monedaCambio;
    }

    public String getMonedaACambiar() {
        return monedaACambiar;
    }

    public void setMonedaACambiar(String monedaACambiar) {
        this.monedaACambiar = monedaACambiar;
    }

    public String getMonedaCambio() {
        return monedaCambio;
    }

    public void setMonedaCambio(String monedaCambio) {
        this.monedaCambio = monedaCambio;
    }
}
