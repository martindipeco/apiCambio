package principal;

import modelo.ApiKey;

public class Principal {

    public static void main(String[] args) {

        String clave = ApiKey.getApiKey();

        System.out.println("Bienvenidos a Cambio Alura");
    }
}
