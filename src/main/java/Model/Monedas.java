package Model;
public class Monedas {
    private String monedaACambiar = "";
    private String monedaCambio = "";
    private Double monedaConvertida;
    private Integer cambioIngresoUsuario = 0;
    private Double cambioFinal;

    public Monedas() {
    }

    public Monedas(String monedaACambiar, String monedaCambio, Double monedaConvertida, Integer cambioIngresoUsuario, Double cambioFinal) {
        this.monedaACambiar = monedaACambiar;
        this.monedaCambio = monedaCambio;
        this.monedaConvertida = monedaConvertida;
        this.cambioIngresoUsuario = cambioIngresoUsuario;
        this.cambioFinal = cambioFinal;
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

    public Double getMonedaConvertida() {
        return monedaConvertida;
    }

    public void setMonedaConvertida(Double monedaConvertida) {
        this.monedaConvertida = monedaConvertida;
    }

    public Integer getCambioIngresoUsuario() {
        return cambioIngresoUsuario;
    }

    public void setCambioIngresoUsuario(Integer cambioIngresoUsuario) {
        this.cambioIngresoUsuario = cambioIngresoUsuario;
    }

    public Double getCambioFinal() {
        return cambioFinal;
    }

    public void setCambioFinal(Double cambioFinal) {
        this.cambioFinal = cambioFinal;
    }

    @Override
    public String toString() {
        return "1" + monedaACambiar + " = " +monedaConvertida+monedaCambio + "\n" + cambioIngresoUsuario + monedaACambiar + " = " + cambioFinal + monedaCambio;
    }
}
