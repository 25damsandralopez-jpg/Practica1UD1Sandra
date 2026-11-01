package com.sandra.tarot.gui;

import com.sandra.tarot.base.NumeroSuerte;
import com.sandra.tarot.base.Tarot;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;

import com.github.lgooddatepicker.components.DatePicker;

public class Ventana {

    private JPanel panelPrincipal;
    private JLabel lblTitulo;
    private JLabel lblLuna;
    private JLabel lblDatosAstrales;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JLabel lblFechaNacimiento;
    private DatePicker datePickerNacimiento;
    private JLabel lblNumeroSuerte;
    private JSpinner spinnerSuerte;
    private JLabel lblTipoConsulta;
    private JRadioButton radioTarot;
    private JRadioButton radioHoroscopo;
    private JLabel lblTemaConsulta;
    private JRadioButton rbAmor;
    private JRadioButton rbTrabajo;
    private JRadioButton rbSuerte;
    private JButton btnRevelar;
    private JPanel panelDatos;
    private JPanel panelResultado;
    private JTextArea txtResultado;
    private JPanel panelFechaNacimiento;

    public Ventana() {

        // CALENDARIO
        datePickerNacimiento = new DatePicker();
        panelFechaNacimiento.setLayout(new BorderLayout());
        panelFechaNacimiento.add(datePickerNacimiento, BorderLayout.CENTER);

        // NUMERO DE LA SUERTE
        spinnerSuerte.setModel(new SpinnerNumberModel(0, 0, 9, 1));

        //TAROT
        radioTarot.addActionListener(e -> {
            lblTemaConsulta.setVisible(true);
            rbAmor.setVisible(true);
            rbTrabajo.setVisible(true);
            rbSuerte.setVisible(true);
        });

        //HOROSCOPO
        radioHoroscopo.addActionListener(e -> {
            lblTemaConsulta.setVisible(false);
            rbAmor.setVisible(false);
            rbTrabajo.setVisible(false);
            rbSuerte.setVisible(false);
        });

        //DESTINO
        btnRevelar.addActionListener(e -> {

            if (!validarCampos()) {
                return;
            }

            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            int numero = (Integer) spinnerSuerte.getValue();
            LocalDate fecha = datePickerNacimiento.getDate();

            if (radioTarot.isSelected()) {

                Tarot tarot = new Tarot(nombre, apellido, fecha, numero);

                String prediccion;

                if (rbAmor.isSelected()) {
                    prediccion = tarot.consultarAmor();

                } else if (rbTrabajo.isSelected()) {
                    prediccion = tarot.consultarTrabajo();

                } else {
                    prediccion = tarot.consultarSuerte();
                }

                txtResultado.setText("🔮 TU PREDICCIÓN DEL TAROT\n\n"
                        + prediccion);

            } else {

                txtResultado.setText("🌙 Has elegido HORÓSCOPO");
            }

            NumeroSuerte numeroSuerte = new NumeroSuerte();
            String mensaje = numeroSuerte.obtenerMensaje(numero, nombre);

            txtResultado.append("\n\n----------------------------------");
            txtResultado.append("\n🍀 TU NÚMERO DE LA SUERTE: " + numero);
            txtResultado.append("\n\n" + mensaje);

        });
    }

        public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private boolean validarCampos() {

        if (txtNombre.getText().trim().isEmpty()
                || txtApellido.getText().trim().isEmpty()) {

            txtResultado.setText("Revisa los campos.");
            return false;
        }

        if (!validarFecha()) {
            return false;
        }


        try {


            spinnerSuerte.commitEdit();

            int numero = (Integer) spinnerSuerte.getValue();

            if (numero < 0 || numero > 9) {
                txtResultado.setText("El número de la suerte debe estar entre 0 y 9.");
                return false;
            }

        } catch (ParseException | ClassCastException e) {
            txtResultado.setText("Introduce un número de la suerte válido.");
            return false;
        }

        if (!radioTarot.isSelected() && !radioHoroscopo.isSelected()) {

            txtResultado.setText("Selecciona el tipo de consulta.");
            return false;
        }


        if (radioTarot.isSelected()
                && !rbAmor.isSelected()
                && !rbTrabajo.isSelected()
                && !rbSuerte.isSelected()) {

            txtResultado.setText("Selecciona el tema de consulta.");
            return false;
        }

        return true;
    }


    // COMPRUEBO LA FECHA
    private boolean validarFecha() {

        LocalDate fecha = datePickerNacimiento.getDate();
        if (fecha == null) {
            txtResultado.setText("Selecciona una fecha de nacimiento válida.");
            return false;
        }

        if (fecha.isAfter(LocalDate.now())) {
            txtResultado.setText("No has nacido en el futuro.");
            return false;
        }

        return true;
    }

}
