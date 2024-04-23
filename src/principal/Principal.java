package principal;

import modelo.ApiKey;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String clave = ApiKey.getApiKey();
        System.out.println("Bienvenidos a Cambio Alura");
        String opcion;
        do {
            System.out.println("\n1: Hacer consulta/ operación");
            System.out.println("2: Ver historial");
            System.out.println("3: Guardar/ Imprimir");
            System.out.println("x: Salir");

            opcion = scanner.nextLine().toLowerCase();

            switch (opcion)
            {
                //Comprar
                case "1":
                    String eleccionMoneda;
                    do {
                        System.out.println("Opciones disponibles:");
                        System.out.println("1: Pesos Argentinos ARS -> Dólares USD");
                        System.out.println("2: Dólares USD -> Pesos Argentinos ARS");
                        System.out.println("3: Reales Brasileños BRL -> Dólares USD");
                        System.out.println("4: Dólares USD -> Reales Brasileños BRL");
                        System.out.println("5: Pesos Colombianos COP -> Dólares USD");
                        System.out.println("6: Dólares USD -> Pesos Colombianos COP");
                        System.out.println("x: atrás");

                        eleccionMoneda = scanner.nextLine().toLowerCase();

                        switch (eleccionMoneda)
                        {
                            case "1":
                                System.out.println("ARS a USD");
                                break;
                            case "2":
                                System.out.println("USD a ARS");
                                break;
                            case "3":
                                System.out.println("BRL a USD");
                                break;
                            case "4":
                                System.out.println("USD a BRL");
                                break;
                            case "5":
                                System.out.println("COP a USD");
                                break;
                            case "6":
                                System.out.println("USD a COP");
                                break;
                            case "x":
                                System.out.println("Volviendo atrás");
                                break;
                            default:
                                System.out.println("Por favor ingrese una opción válida");
                        }
                    }
                    while (!"x".equalsIgnoreCase(eleccionMoneda));
                    break;

                //Historial
                case "2":
                    System.out.println("Vemos el historial");
                    String eleccionOrden;
                    do {
                        System.out.println("1: Ordenar por Fecha más próxima");
                        System.out.println("2: Ordenar por Fecha más antigua");
                        System.out.println("3: Ordenar por Monto Moneda Origen");
                        System.out.println("4: Ordenar por Monto Moneda Destino");
                        System.out.println("5: Ordenar por Nombre Moneda Origen");
                        System.out.println("6: Ordenar por Nombre Moneda Destino");
                        System.out.println("x: Volver atrás");

                        eleccionOrden = scanner.nextLine();

                        switch (eleccionOrden)
                        {
                            case "1":
                                System.out.println("Ordenada por Fecha próxima");
                                break;
                            case "2":
                                System.out.println("Ordenada por Fecha más antigua");
                                break;
                            case "3":
                                System.out.println("Ordenada por Monto Moneda Origen");
                                break;
                            case "4":
                                System.out.println("Ordenada por Monto Moneda Destino");
                                break;
                            case "5":
                                System.out.println("Ordenada por Nombre Moneda Origen");
                                break;
                            case "6":
                                System.out.println("Ordenada por Nombre Moneda Destino");
                                break;
                            case "x":
                                System.out.println("Volviendo atrás");
                                break;
                            default:
                                System.out.println("Por favor ingrese una opción válida");
                        }
                    }
                    while (!eleccionOrden.equalsIgnoreCase("x"));
                    break;

                //Guardar
                case "3":
                    System.out.println("Guardamos la info");
                    System.out.println("Presione cualquier tecla para continuar");
                    scanner.nextLine();
                    break;
                case "x":
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
            }
        }
        while (!"x".equalsIgnoreCase(opcion));
        scanner.close();
    }
}
