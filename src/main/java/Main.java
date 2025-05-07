import Model.Monedas;
import Service.ConversorApi;
import Util.Mensajes;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Monedas monedas = new Monedas();
        ConversorApi conversor = new ConversorApi();
        Integer opcion = 0;
        Scanner scanner = new Scanner(System.in);
        //solo finaliza el bucle cuando opcion sea 2
        while(!opcion.equals(2)){

            seleccionMonedasAconvertir(monedas, scanner, conversor);
            convertirMonedas(monedas, scanner);
            System.out.println(monedas.toString());
            //manejo de errores por datos erroneos a la hora se solicitar datos
            do {
                System.out.println("""
                    Desea continuar?
                    1 - SI
                    2 - NO
                """);
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion != 1 && opcion != 2) {
                        System.out.println("Opción inválida. Por favor ingrese 1 o 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número (1 o 2).");
                    scanner.next(); // limpiar buffer
                    opcion = 0; // para seguir en el bucle
                }
            } while (opcion != 1 && opcion != 2);
        }
    }


    private static void seleccionMonedasAconvertir(Monedas monedas, Scanner scanner , ConversorApi conversor){
        boolean entradaValida2 = false;
        //manejo de errores por datos erroneos a la hora se solicitar datos
        while(!entradaValida2){
            try{
                Mensajes.mensajeMonedaAconvertir();
                monedas.setMonedaACambiar(scanner.nextLine().toUpperCase()); //ingreso de sigla de moneda a cambiar
                Mensajes.mensajeConvertirA();
                monedas.setMonedaCambio(scanner.nextLine().toUpperCase()); //ingreso de sigla de moneda de cambio
                monedas.setMonedaConvertida(conversor.conversion(monedas.getMonedaACambiar(), monedas.getMonedaCambio())); // Request de API
                entradaValida2 = true;
            }catch (NullPointerException | IOException e){
                System.out.println("Error, ingrese una sigla correcta por favor");
            }
        }
    }

    public static void convertirMonedas(Monedas monedas, Scanner scanner){
        boolean entradaValida = false;
        //manejo de errores por datos erroneos a la hora se solicitar datos
        while (!entradaValida) {
            try {
                System.out.println("Ahora ingrese cuantos " + monedas.getMonedaACambiar().toUpperCase() + " quiere cambiar a " + monedas.getMonedaCambio().toUpperCase());
                monedas.setCambioIngresoUsuario(scanner.nextInt());
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                scanner.nextLine();
            }
        }
        monedas.setCambioFinal(monedas.getCambioIngresoUsuario() * monedas.getMonedaConvertida());
    }
}
