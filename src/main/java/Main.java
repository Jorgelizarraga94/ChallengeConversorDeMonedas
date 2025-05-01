import Model.Monedas;
import Service.ConversorApi;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Monedas monedas = new Monedas();
        Scanner scanner = new Scanner(System.in);
        Double numeroConvertido;
        String opcion = "";
        while(!opcion.equals("2")){
            System.out.println("******************************************************");
            System.out.println("Bienvenidos a Cambio Online :)");
            System.out.println(""" 
                Ingrese la Sigla de la moneda que desea cambiar:
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
            monedas.setMonedaACambiar(scanner.nextLine());
            System.out.println("""
                Ingrese la sigla de la moneda a la que desea cambiar:
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
            monedas.setMonedaCambio(scanner.nextLine());
            ConversorApi conversor = new ConversorApi();
            numeroConvertido = conversor.conversion(monedas.getMonedaACambiar(), monedas.getMonedaCambio());
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.println("1 " + monedas.getMonedaACambiar() + " = " +  df.format(numeroConvertido) + " " + monedas.getMonedaCambio());
            System.out.println("""
                    Desea continuar?
                    1-SI
                    2-NO 
                     """);
            opcion = scanner.nextLine();
        }

    }
}
