package com.sysparking.proyecto_dswii_be.util;

import edu.cibertec.config.OperacionesArchivos;
import javax.xml.bind.JAXBContext;

import javax.xml.bind.Marshaller;

import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GestorXml implements OperacionesArchivos {
    @Override
    public void escribirArchivo(String ruta, Object contenido) throws Exception {

        if(contenido == null){
            throw new Exception("NO HAY CONTENIDO PARA GUARDAR");
        }

        JAXBContext contextoXml  = JAXBContext.newInstance(contenido.getClass());
        //CREAMOS EL CONVERTIDOR DE OBJETOS A XML
        Marshaller excritorXML =  contextoXml.createMarshaller();
        excritorXML.marshal(contenido, new File(ruta));

        System.out.println("ARCHIVO XML CREADO CORRECTAMENTE!");
    }


    @Override
    public Object leerArchivo(String ruta, Object param) throws Exception {
        //1. Iniciar el contexto JAXB y el valor de retorno
        JAXBContext contextoXml = null;
        Object objetoLeido = null;
        //2. Validar la existencia del archivo que se quiere leer
        File refArchivo = new File(ruta);
        if (!refArchivo.exists()) {
            throw new Exception("El archivo no existe para la ruta especificada.");
        }

        //3. Validar el parámetro
        if (param == null) {
            throw new Exception("El parámetro enviado para la lectura es null.");
        } else {
            //4. Crear el contexto para la clase soportada
            contextoXml = JAXBContext.newInstance(param.getClass());
            //5. Crear un convertidor de data de archivo XML a objeto
            Unmarshaller lectorXml = contextoXml.createUnmarshaller();
            //6. Leer el contenido hacia un objeto.
            objetoLeido = lectorXml.unmarshal(refArchivo);
        }
        //7. Se retorna el objeto
        return objetoLeido;
    }
}
