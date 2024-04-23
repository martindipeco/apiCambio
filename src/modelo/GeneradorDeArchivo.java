package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {

    public void guardarTransaccionJson(Transaccion transaccion)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter escritura = new FileWriter(transaccion.getFecha()+".json");
            escritura.write(gson.toJson(transaccion));
            escritura.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void guardarTransaccionTxt(Transaccion transaccion)
    {
        try {
            FileWriter escritura = new FileWriter(transaccion.getFecha()+".txt");
            escritura.write(transaccion.toString());
            escritura.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarListaTransaccionJson(List<Transaccion> listaTransaccion)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter escritura = new FileWriter("listaTransaccion.json");
            escritura.write(gson.toJson(listaTransaccion));
            escritura.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void guardarListaTransaccionTxt(List<Transaccion> listaTransaccion)
    {
        try {
            FileWriter escritura = new FileWriter("listaTransaccion.txt");
            escritura.write(listaTransaccion.toString());
            escritura.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
