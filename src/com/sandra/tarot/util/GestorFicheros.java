
package com.sandra.tarot.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

public class GestorFicheros {


    public static boolean exportar(File archivo, String nombre,
                                   String apellido, LocalDate fecha,
                                   int numero, String tipo,
                                   String tema, String prediccion) {

        try (BufferedWriter escritor = Files.newBufferedWriter(
                archivo.toPath(), StandardCharsets.UTF_8)) {

            // GUARDAR DATOS EN EL FORMULARIO
            escritor.write(nombre);
            escritor.newLine();

            escritor.write(apellido);
            escritor.newLine();

            escritor.write(fecha.toString());
            escritor.newLine();

            escritor.write(String.valueOf(numero));
            escritor.newLine();

            escritor.write(tipo);
            escritor.newLine();

            escritor.write(tema);
            escritor.newLine();

            // Guardamos la predicción
            escritor.write(prediccion);

            return true;

        } catch (IOException e) {
            return false;
        }
    }



    // IMPORTAR
    public static String[] importar(File archivo) {

        try (BufferedReader lector = Files.newBufferedReader(
                archivo.toPath(), StandardCharsets.UTF_8)) {

            // LEER LOS DATOS EN EL MISMO ORDEN
            String nombre = lector.readLine();
            String apellido = lector.readLine();
            String fecha = lector.readLine();
            String numero = lector.readLine();
            String tipo = lector.readLine();
            String tema = lector.readLine();

            // COMPROBAR QUE EL ARCHIVO TIENE LOS DATOS NECESARIOS
            if (nombre == null || apellido == null || fecha == null
                    || numero == null || tipo == null || tema == null) {
                return null;
            }

            // SE RECUPERA AL PREDICCION
            StringBuilder prediccion = new StringBuilder();
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (prediccion.length() > 0) {
                    prediccion.append("\n");
                }
                prediccion.append(linea);
            }

            // LO DEVUELVE
            return new String[]{
                    nombre, apellido, fecha, numero,
                    tipo, tema, prediccion.toString()
            };

        } catch (IOException e) {
            return null;
        }
    }

}
