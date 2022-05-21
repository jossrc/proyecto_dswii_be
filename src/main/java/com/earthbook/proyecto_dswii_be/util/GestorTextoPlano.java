package com.earthbook.proyecto_dswii_be.util;

import com.earthbook.proyecto_dswii_be.config.OperacionesArchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GestorTextoPlano implements OperacionesArchivos {

    @Override
    public void escribirArchivo(String ruta, Object contenido) throws Exception {

        File fileArchivo = new File(ruta);

        // SI NO ES UN STRING
        if(!(contenido instanceof String)){
            throw new Exception("El contenido debe ser String!!");
        }

        try{
            BufferedWriter escritoArchivo = new BufferedWriter(new FileWriter(fileArchivo));
            //ESCRIBE ARCHIVO
            escritoArchivo.write((String)contenido);
            escritoArchivo.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public Object leerArchivo(String ruta, Object contenido) throws Exception {
        //1. Crear un componente que permite guardar contenido de texto (cadenas) de forma ordenada
        StringBuilder contenidoLeido = new StringBuilder();

        //2. Crear la referencia al archivo usando NIO
        Path refArchivo = Paths.get(ruta);

        //3. Verificar si el archivo existe, si no existe se lanza una excepción.
        if (!refArchivo.toFile().exists()) {
            throw new Exception("El archivo no existe para la ruta especificada.");
        }

        try {
            //4. Utilizar los mecanismos de lectura de archivos de texto de NIO
            List<String> lineasLeidas = Files.readAllLines(refArchivo);
            //5. Si hay contenido en el archivo, copiamos las líneas en el componente separando apropiadamente
            if (lineasLeidas != null && !lineasLeidas.isEmpty()) {
                lineasLeidas.forEach(linea -> contenidoLeido.append(linea).append(System.lineSeparator()));
            }

        } catch (Exception e) {
            throw e;
        }

        //5. Se retorna el contenido
        return contenidoLeido.toString();
    }
}
