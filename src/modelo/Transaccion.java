package modelo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import excepcion.ErrorNAException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Transaccion {

    private String monedaOrigen;
    private String monedaDestino;
    private double montoOrigen;
    private double tasaCambio;
    private double montoDestino;

    private LocalDateTime fecha;
    private Usuario usuario;

    public Transaccion() {

    }

    public Transaccion(String monedaOrigen, String monedaDestino, double montoOrigen, double tasaCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoOrigen = montoOrigen;
        this.tasaCambio = tasaCambio;
        this.montoDestino = montoOrigen*tasaCambio;
        this.fecha = LocalDateTime.now();
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getMontoOrigen() {
        return montoOrigen;
    }

    public double getMontoDestino() {
        return montoDestino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double obtenerTasa(String monedaOrigen, String monedaDestino)
    {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ApiKey.getApiKey()+"/pair/"+monedaOrigen+"/"+monedaDestino);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response = null;
        try
        {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();

        // Parse JSON string to JsonObject
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        // Get the value of "conversion_rate"
        double tasaConversion = 0;
        try {
            tasaConversion = jsonObject.get("conversion_rate").getAsDouble();

        }
        catch (NumberFormatException e)
        {
            System.out.println("No fue posible convertir a dato numérico");
            System.out.println(e.getMessage());
            String tasaString = jsonObject.get("conversion_rate").getAsString();
            if (tasaString.contains("N/A"))
            {
                throw new ErrorNAException("No se pudo convertir por que apareció N/A ");
            }
        }

        catch (ErrorNAException e)
        {
            System.out.println(e.getMessage());
        }

        return tasaConversion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "monedaOrigen='" + monedaOrigen + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                ", montoOrigen=" + montoOrigen +
                ", tasaCambio=" + tasaCambio +
                ", montoDestino=" + montoDestino +
                ", fecha=" + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+
                ", usuario=" + usuario +
                '}';
    }
}
