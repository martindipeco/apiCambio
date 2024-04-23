package principal;

import modelo.ApiKey;
import modelo.GeneradorDeArchivo;
import modelo.Transaccion;
import modelo.Usuario;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Transaccion transaccion = new Transaccion();
        Usuario usuario = new Usuario();
        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

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
                    String monedaOrigen="";
                    String monedaDestino="";
                    Double tasaConversion;
                    String eleccionMonto;
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
                        boolean convertir = true;
                        switch (eleccionMoneda)
                        {
                            case "1":
                                System.out.println("ARS a USD");
                                monedaOrigen = "ARS";
                                monedaDestino = "USD";
                                break;
                            case "2":
                                System.out.println("USD a ARS");
                                monedaOrigen = "USD";
                                monedaDestino = "ARS";
                                break;
                            case "3":
                                System.out.println("BRL a USD");
                                monedaOrigen = "BRL";
                                monedaDestino = "USD";
                                break;
                            case "4":
                                System.out.println("USD a BRL");
                                monedaOrigen = "USD";
                                monedaDestino = "BRL";
                                break;
                            case "5":
                                System.out.println("COP a USD");
                                monedaOrigen = "COP";
                                monedaDestino = "USD";
                                break;
                            case "6":
                                System.out.println("USD a COP");
                                monedaOrigen = "COP";
                                monedaDestino = "USD";
                                break;
                            case "x":
                                convertir = false;
                                System.out.println("Volviendo atrás");
                                break;
                            default:
                                convertir = false;
                                System.out.println("Por favor ingrese una opción válida");
                        }
                        if (convertir)
                        {
                            tasaConversion = transaccion.obtenerTasa(monedaOrigen, monedaDestino);
                            System.out.println("La tasa de conversión de " + monedaOrigen + " a " + monedaDestino + " es: "
                                    + tasaConversion);
                            System.out.println("Ingrese el monto a convertir o 'x' para volver atrás");
                            eleccionMonto = scanner.nextLine();
                            if (eleccionMonto.equalsIgnoreCase("x"))
                            {
                                System.out.println("Volviendo atrás");
                                break;
                            }
                            try
                            {
                                double montoOrigen = Double.parseDouble(eleccionMonto);
                                if(montoOrigen >= 0)
                                {
                                    Transaccion miTransaccion =
                                            new Transaccion(monedaOrigen, monedaDestino, montoOrigen, tasaConversion);
                                    usuario.agregarTransaccion(miTransaccion);
                                    System.out.println("Se ha realizado la operación: ");
                                    System.out.println(miTransaccion);
                                    System.out.println("Presione cualquier tecla para continuar");
                                    scanner.nextLine();
                                    break;
                                }
                                else
                                {
                                    System.out.println("Ingrese un monto válido");
                                }
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Ingrese un número válido o 'x' para salir");
                            }
                        }
                    }
                    while (!"x".equalsIgnoreCase(eleccionMoneda));
                    break;

                //Historial
                case "2":
                    System.out.println("Vemos el historial");
                    usuario.mostrarLista();
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
                                usuario.ordenaPorFechaProxima();
                                break;
                            case "2":
                                System.out.println("Ordenada por Fecha más antigua");
                                usuario.ordenaPorFechaAntigua();
                                break;
                            case "3":
                                System.out.println("Ordenada por Monto Moneda Origen");
                                usuario.ordenaPorMontoMonedaOrigen();
                                break;
                            case "4":
                                System.out.println("Ordenada por Monto Moneda Destino");
                                usuario.ordenaPorMontoMonedaDestino();
                                break;
                            case "5":
                                System.out.println("Ordenada por Nombre Moneda Origen");
                                usuario.ordenaPorNombreMonedaOrigen();
                                break;
                            case "6":
                                System.out.println("Ordenada por Nombre Moneda Destino");
                                usuario.ordenaPorNombreMonedaDestino();
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
                    generadorDeArchivo.guardarListaTransaccionTxt(usuario.getListaTransacciones());
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
