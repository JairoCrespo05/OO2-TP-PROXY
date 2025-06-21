package org.example.ej1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
    private Connection obtenerConexion() throws SQLException {
        return ConnectionManager.getConnection();
    }



    public Persona personaPorId(int id) throws SQLException {
        String sql = " SELECT p.nombre "
                + " FROM personas p "
                + " WHERE p.id = ? ";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql);) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String nombrePersona = null;

            if (result.next()){
                nombrePersona = result.getString(1);
            }
            return new Persona(id, nombrePersona, new ProxyTelefono(this, id));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

        }
    }

    public Set<Telefono> telefonosDe(int idPersona) throws SQLException {
        String sql = " SELECT * " +
                " FROM telefonos t " +
                " WHERE t.id_persona = ? " +
                " ORDER BY t.id ";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql);) {

            statement.setInt(1, idPersona);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<Telefono>();
            while (result.next()) {
                telefonos.add(new Telefono(result.getString(2)));
            }

            return telefonos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

        }
    }


}



