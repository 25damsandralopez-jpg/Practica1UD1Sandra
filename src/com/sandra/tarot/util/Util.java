package com.sandra.tarot.util;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Util {

    // Preguntar si queremos cerrar la aplicación o reemplazar un archivo.
    public static int mensajeConfirmacion(String mensaje, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensaje,
                titulo, JOptionPane.YES_NO_OPTION);
    }

    // Crea una ventana para seleccionar archivos
    public static JFileChooser crearSelectorFichero(File rutaDefecto,
                                                    String tipoArchivos,
                                                    String extension) {

        JFileChooser selectorFichero = new JFileChooser();

        // Si tenemos una ruta anterior, abrimos esa carpeta
        if (rutaDefecto != null) {
            selectorFichero.setCurrentDirectory(rutaDefecto);
        }

        // Filtramos los archivos por su extensión
        if (extension != null) {
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter(tipoArchivos, extension);

            selectorFichero.setFileFilter(filtro);
        }

        return selectorFichero;
    }
}

