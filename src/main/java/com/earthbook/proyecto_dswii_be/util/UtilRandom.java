package com.earthbook.proyecto_dswii_be.util;

import java.util.concurrent.ThreadLocalRandom;

public class UtilRandom {

    /**
     * Genera un número entero aleatorio
     * @param minimo Mínimo valor entero
     * @param maximo Máximo valor entero
     * @return Número entero aleatorio
     */
    public static int generarEnteroAleatorio(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

}
