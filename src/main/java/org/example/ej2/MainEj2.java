package org.example.ej2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEj2 {
    public static void main(String[] args) {

        var permisosLucas = new ArrayList<Permiso>();
        permisosLucas.add(Permiso.BASICO);
        permisosLucas.add(Permiso.INTERMEDIO);
//        permisosLucas.add(Permiso.ADMIN);


        var usuario = new Usuario("Lucas", permisosLucas);
        var archivo = new ProxyAcceso(new FileAccess("src/main/resources","importante.txt"), usuario);

        var archivo2 = new ProxyAcceso(new FileAccess("src/main/resources","motivos.txt"), usuario);


        try {
            System.out.println(archivo2.readFile());

            System.out.println(archivo.readFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
