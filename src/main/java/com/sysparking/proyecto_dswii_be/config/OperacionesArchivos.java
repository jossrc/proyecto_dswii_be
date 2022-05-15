package com.sysparking.proyecto_dswii_be.config;

public interface OperacionesArchivos {

    public void escribirArchivo(String ruta, Object contenido) throws Exception;
    public Object leerArchivo(String ruta, Object param) throws Exception;

}
