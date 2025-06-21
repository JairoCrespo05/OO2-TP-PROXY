package org.example.ej1;


import java.sql.SQLException;

public class MainEj1 {
    public static void main(String[] args) {

        PersonaDao dao = new PersonaDao();
        Persona p = null;
        try {
            p = dao.personaPorId(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(p.nombre());

        for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
        }

    }
}