package com.sandra.tarot;

import com.sandra.tarot.gui.Ventana;
import javax.swing.*;
import com.sandra.tarot.util.Util;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal {

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Iniciamos la aplicación
        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Tarot y Horóscopo");

            // Cargamos nuestro diseño
            Ventana formulario = new Ventana();
            ventana.setContentPane(formulario.getPanelPrincipal());

            // VENTANA AJUSTADA
            ventana.pack();

            // VENTANA SE ABRE CON EL TAMAÑO  FIJO
            ventana.setSize(935, 915);

            // LA VENTANA NO SE CIERRA SIN CONFIRMAR
            ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            // Preguntamos antes de cerrar la ventana con la X
            ventana.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {

                    int respuesta = Util.mensajeConfirmacion(
                            "🌙 ¿Seguro que quieres abandonar tu destino?",
                            "Cerrar Tarot y Horóscopo");

                    if (respuesta == JOptionPane.YES_OPTION) {
                        ventana.dispose();
                    }
                }
            });

            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

        });
    }
}
