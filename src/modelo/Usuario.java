package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Usuario {

    private String nombre;
    private String apellido;
    private String documento;

    List<Transaccion> listaTransacciones = new ArrayList<>();

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void agregarTransaccion(Transaccion transaccion)
    {
        listaTransacciones.add(transaccion);
    }

    public void mostrarLista()
    {
        for(Transaccion transa : listaTransacciones)
        {
            System.out.println(transa);
        }
    }

    public void ordenaPorFechaProxima()
    {
        listaTransacciones.sort(Comparator.comparing(Transaccion::getFecha).reversed());
    }
    public void ordenaPorFechaAntigua()
    {
        listaTransacciones.sort(Comparator.comparing(Transaccion::getFecha));
    }


    public void ordenaPorMontoMonedaOrigen()
    {
        listaTransacciones.sort(Comparator.comparing(Transaccion::getMontoOrigen));
    }

    public void ordenaPorMontoMonedaDestino()
    {
        listaTransacciones.sort(Comparator.comparing(Transaccion::getMontoDestino));
    }

    public void ordenaPorNombreMonedaOrigen()
    {
        listaTransacciones.sort(Comparator.comparing(Transaccion::getMonedaOrigen));
    }

    public void ordenaPorNombreMonedaDestino()
    {
        listaTransacciones.sort(Comparator.comparing(Transaccion::getMonedaDestino));
    }
}
