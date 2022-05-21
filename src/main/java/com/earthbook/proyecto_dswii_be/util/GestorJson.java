package com.earthbook.proyecto_dswii_be.util;

import com.earthbook.proyecto_dswii_be.config.OperacionesArchivos;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GestorJson  implements OperacionesArchivos {
    @Override
    public void escribirArchivo(String ruta, Object contenido) throws Exception {
        //1. Crear una instancia del gestor Gson
        Gson gson = new Gson();
        String json = gson.toJson(contenido);
        System.out.println("JSON: " + json);

        File fileArchivo = new File(ruta);

        try{
            BufferedWriter escritoArchivo = new BufferedWriter(new FileWriter(fileArchivo));
            //ESCRIBE ARCHIVO
            escritoArchivo.write((String)json);
            escritoArchivo.close();

        }catch (Exception e) {
            e.printStackTrace();
        }


        //2. Escribir el objeto en el archivo
        gson.toJson(contenido, new FileWriter(new File(ruta)));
    }

    @Override
    public Object leerArchivo(String ruta, Object contenido) throws Exception {
        // 1. Inicializar objeto a leer
        Object objetoLeido = null;
        // 2. Crear la referencia al archivo que se va a leer
        File refArchivo = new File(ruta);
        // 3. Validar la existencia del archivo
        if (!refArchivo.exists()) {
            throw new Exception("El archivo no existe para la ruta especificada.");
        }


        // 4. Validar el parámetro
        if (contenido == null) {
            throw new Exception("El parámetro enviado para la lectura es null.");
        } else {
            // 5. Crear una instancia del gestor Gson
            Gson gson = new Gson();
            // 6. Utilizar el gestor Gson para la lectura
            objetoLeido = gson.fromJson(new FileReader(refArchivo), contenido.getClass());
        }

        return objetoLeido;
    }
}
