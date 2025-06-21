package org.example.ej2;

import java.io.IOException;

public class ProxyAcceso implements Acceso{

    static final String NO_PERMISOS_ADMINS = "Acceso denegado: Usted no posee permisos de Administrador";
    static final String  NO_PERMISOS_INTERMEDIOS = "Acceso denegado: Usted no posee permisos de usuario Intermedio";


    private FileAccess access;
    private Usuario usuario;


    public ProxyAcceso(FileAccess access, Usuario usuario) {
        this.access = access;
        this.usuario = usuario;
    }


    @Override
    public String readFile() throws IOException {
        String nombreArch = this.access.elNombreDelArchivo();
        if(nombreArch.startsWith("i")){
            if(!usuario.poseePermiso(Permiso.ADMIN)){
                throw new RuntimeException(NO_PERMISOS_ADMINS);
            }
        }
        if (nombreArch.startsWith("m")){
            if(!usuario.poseePermiso(Permiso.INTERMEDIO)){
                throw new RuntimeException(NO_PERMISOS_INTERMEDIOS);
            }
        }

        return access.readFile();
    }
}
