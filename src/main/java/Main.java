import Model.Monedas;
import Service.ConversorApi;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Monedas monedas = new Monedas();
        ConversorApi conversor = new ConversorApi();
        Double numeroConvertido;
        Integer cambioIngresoUsuario = 0;
        Double cambioFinal;
        Integer opcion = 0;
        while(!opcion.equals(2)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("******************************************************");
            System.out.println("Bienvenidos a Cambio Online :)");
            mensajeMonedaAconvertir();
            monedas.setMonedaACambiar(scanner.nextLine().toUpperCase());
            mensajeConvertirA();
            monedas.setMonedaCambio(scanner.nextLine().toUpperCase());
            numeroConvertido = conversor.conversion(monedas.getMonedaACambiar(), monedas.getMonedaCambio());
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.println("1 " + monedas.getMonedaACambiar() + " = " +  df.format(numeroConvertido) + " " + monedas.getMonedaCambio());
            System.out.println("Ahora ingrese cuantos " + monedas.getMonedaACambiar().toUpperCase() + " quiere cambiar a " + monedas.getMonedaCambio().toUpperCase());
            cambioIngresoUsuario = scanner.nextInt();
            cambioFinal = cambioIngresoUsuario * numeroConvertido;
            System.out.println(cambioIngresoUsuario + monedas.getMonedaACambiar() + " = " +  df.format(cambioFinal) + " " + monedas.getMonedaCambio());
            System.out.println("""
                    Desea continuar?
                    1-SI
                    2-NO 
                     """);
            opcion = scanner.nextInt();
        }


    }
    public static void mensajeMonedaAconvertir(){
        System.out.println(""" 
                Ingrese la Sigla de la moneda que desea convertir:
                -ARS-Peso Argentino
                -AUD-Dólar australiano
                -BRL-Real brasileño
                -CAD-Dólar canadiense
                -COP-Colombian Peso
                -CLP-Peso chileno
                -BOB-boliviano boliviano
                -CNY-Yuan chino 
                -EUR-Euro
                -GBP-Libra esterlina (Reino Unido)
                -INR-Rupia india
                -JPY-Yen japonés
                -MXN-Peso mexicano
                -PYG-Guaraní Paraguayo
                -USD-Dólar estadounidense
                    """);
        System.out.println("*********************************");
    }
    public static void mensajeConvertirA (){
        System.out.println("""
                Ingrese la sigla de la moneda a la que desea convertir sus :
                    -ARS-Peso Argentino
                    -AUD-Dólar australiano
                    -BRL-Real brasileño
                    -CAD-Dólar canadiense
                    -COP-Colombian Peso
                    -CLP-Peso chileno
                    -BOB-boliviano boliviano
                    -CNY-Yuan chino 
                    -EUR-Euro
                    -GBP-Libra esterlina (Reino Unido)
                    -INR-Rupia india
                    -JPY-Yen japonés
                    -MXN-Peso mexicano
                    -PYG-Guaraní Paraguayo
                    -USD-Dólar estadounidense
                    """);
    }
}
