package com.sysparking.proyecto_dswii_be.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UtilArchivos {

    private static UtilArchivos instancia;

    private UtilArchivos() {

    }

    public static UtilArchivos getInstancia() {
        // Primera vez
        if (instancia == null) {
            instancia = new UtilArchivos();
        }
        return instancia;
    }

    public void crearCarpetaSiNoExiste(String rutaCarpeta) {
        System.out.println("Ruta Carpeta: " + rutaCarpeta);

        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists()) {
            System.out.println("Carpeta ya existe");
        } else {
            boolean seCreo = carpeta.mkdir();
            if (seCreo) {
                System.out.println("Carpeta generada correctamente");
            } else {
                System.out.println("No se pudo generar la carpeta");
            }

        }
    }

    public void copiarArchivo(String rutaCompletaOrigen, String rutaCompletaDestino) throws Exception {

        File refArchivoOrigen = new File(rutaCompletaOrigen);

        if (!refArchivoOrigen.exists()) {
            throw new Exception("No se encuentra el archivo de origen en la ruta especificada.");
        }

        File refArchivoDestino = new File(rutaCompletaDestino);
        FileInputStream fis = new FileInputStream(refArchivoOrigen);
        FileOutputStream fos = new FileOutputStream(refArchivoDestino);

        byte[] bloque = new byte[1024];

        int leido = 0;
        while ((leido = fis.read(bloque, 0, bloque.length)) != -1) {
            fos.write(bloque, 0, leido);
        }

    }

    private List<File> fileList = new ArrayList<>();
    private List<String> paths = new ArrayList<>(25);

    protected void generateFileList(File node) {

        // Agregamos solo archivos
        if (node.isFile()) {
            fileList.add(node);
        }
        if (node.isDirectory()) {
            File[] subNote = node.listFiles();
            for (File filename : subNote) {
                generateFileList(filename);
            }
        }
    }

    public void zipear(File sourceFile, File zipFile) {
        if (sourceFile.isDirectory()) {
            byte[] buffer = new byte[1024];
            FileOutputStream fos = null;
            ZipOutputStream zos = null;

            try {

                String sourcePath = sourceFile.getParentFile().getPath();
                generateFileList(sourceFile);
                fos = new FileOutputStream(zipFile);
                zos = new ZipOutputStream(fos);

                System.out.println("Zip resultado : " + zipFile);
                FileInputStream in = null;

                for (File file : fileList) {
                    String path = file.getParent().trim();
                    path = path.substring(sourcePath.length());
                    if (path.startsWith(File.separator)) {
                        path = path.substring(1);
                    }

                    if (path.length() > 0) {
                        if (!paths.contains(path)) {
                            paths.add(path);
                            ZipEntry ze = new ZipEntry(path + "/");
                            zos.putNextEntry(ze);
                            zos.closeEntry();
                        }
                        path += "/";
                    }

                    String entryName = path + file.getName();
                    System.out.println("Archivo procesado : " + entryName);
                    ZipEntry ze = new ZipEntry(entryName);

                    zos.putNextEntry(ze);
                    try {
                        in = new FileInputStream(file);
                        int len;
                        while ((len = in.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }
                    } finally {
                        in.close();
                    }
                }

                zos.closeEntry();

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }

}

