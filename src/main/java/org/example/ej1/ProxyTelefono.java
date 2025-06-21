package org.example.ej1;

import java.sql.SQLException;
import java.util.*;

public class ProxyTelefono implements Set {

    private PersonaDao personaDao;
    private int idPersona;

    public ProxyTelefono(PersonaDao personaDao, int idPersona){

        this.personaDao = personaDao;
        this.idPersona = idPersona;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {

        try {
            ///telefonos.toArray(a). Devuelve correctamente un Telefono[] si 'a' es de tipo Telefono[].
            return personaDao.telefonosDe(this.idPersona).toArray(a);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
