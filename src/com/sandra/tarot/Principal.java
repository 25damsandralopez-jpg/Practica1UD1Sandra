
package com.sandra.tarot;

import com.sandra.tarot.gui.Ventana;
import javax.swing.*;

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

            ventana.setSize(800, 650);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

        });
    }
}
