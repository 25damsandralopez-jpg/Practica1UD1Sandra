package com.sandra.tarot.gui;

import com.sandra.tarot.util.GestorFicheros;
import com.sandra.tarot.util.Util;
import com.sandra.tarot.controlador.ControladorConsulta;

import javax.swing.*;
import java.awt.*;
import java.io.File;
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
    private JButton btnNuevo;
    private JButton btnExportar;
    private JButton btnImportar;
    private JButton btnCerrar;

    public Ventana() {

        // ESTE CONTROLADOR GESTIONA LAS CONSULTASS
        ControladorConsulta controlador = new ControladorConsulta();


        // IMAGENES DE  BOTON REVELAR
        ImageIcon imagenBola = new ImageIcon(
                getClass().getResource("/imagenes/bola.png"));

        ImageIcon imagenEstrellas = new ImageIcon(
                getClass().getResource("/imagenes/estrellas.png"));

        Image bolaPequena = imagenBola.getImage().getScaledInstance(
                42, 42, Image.SCALE_SMOOTH);

        Image estrellasPequenas = imagenEstrellas.getImage().getScaledInstance(
                42, 42, Image.SCALE_SMOOTH);

        // ETIQUETAS DE LAS IMAGENES
        JLabel lblBola = new JLabel(new ImageIcon(bolaPequena));
        JLabel lblEstrellas = new JLabel(new ImageIcon(estrellasPequenas));

        // PARA QUE LAS IMAGENES SALGAN A LOS LADOS DEL TEXTO
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        panelBoton.setOpaque(false);

        panelBoton.add(lblBola);

        JLabel lblTextoBoton = new JLabel("Revelar mi destino");
        lblTextoBoton.setFont(btnRevelar.getFont());
        lblTextoBoton.setForeground(btnRevelar.getForeground());
        panelBoton.add(lblTextoBoton);
        panelBoton.add(lblEstrellas);

        btnRevelar.setLayout(new BorderLayout());
        btnRevelar.add(panelBoton, BorderLayout.CENTER);

        // ICONOS DE LOS TEMAS DE CONSULTA
        ImageIcon imagenAmor = new ImageIcon(
                getClass().getResource("/imagenes/amor.png"));

        ImageIcon imagenTrabajo = new ImageIcon(
                getClass().getResource("/imagenes/trabajo.png"));

        ImageIcon imagenSuerte = new ImageIcon(
                getClass().getResource("/imagenes/suerte.png"));

        Image amorPequeno = imagenAmor.getImage().getScaledInstance(
                28, 28, Image.SCALE_SMOOTH);

        Image trabajoPequeno = imagenTrabajo.getImage().getScaledInstance(
                28, 28, Image.SCALE_SMOOTH);

        Image suertePequena = imagenSuerte.getImage().getScaledInstance(
                28, 28, Image.SCALE_SMOOTH);

        rbAmor.setText("Amor");
        rbTrabajo.setText("Trabajo");
        rbSuerte.setText("Suerte");

        rbAmor.setIcon(new ImageIcon(amorPequeno));
        rbTrabajo.setIcon(new ImageIcon(trabajoPequeno));
        rbSuerte.setIcon(new ImageIcon(suertePequena));

        // ICONOS DE TAROT Y HOROSCOPO
        ImageIcon imagenTarot = new ImageIcon(
                getClass().getResource("/imagenes/tarot.png"));

        ImageIcon imagenHoroscopo = new ImageIcon(
                getClass().getResource("/imagenes/horoscopo.png"));

        Image tarotPequeno = imagenTarot.getImage().getScaledInstance(
                28, 28, Image.SCALE_SMOOTH);

        Image horoscopoPequeno = imagenHoroscopo.getImage().getScaledInstance(
                28, 28, Image.SCALE_SMOOTH);

        radioTarot.setText("Tarot");
        radioHoroscopo.setText("Horóscopo");
        radioTarot.setIcon(new ImageIcon(tarotPequeno));
        radioHoroscopo.setIcon(new ImageIcon(horoscopoPequeno));

        // FONNDO CAMBIA DE COLOR AL SELECCIONAR EL RADIOBTN
        JRadioButton[] botones = {
                radioTarot, radioHoroscopo,
                rbAmor, rbTrabajo, rbSuerte
        };

        for (JRadioButton boton : botones) {
            boton.addItemListener(e -> {
                for (JRadioButton b : botones) {
                    colorearRadioButton(b);
                }
            });
            colorearRadioButton(boton);
        }


        // CALENDARIO
        datePickerNacimiento = new DatePicker();
        panelFechaNacimiento.setLayout(new BorderLayout());
        panelFechaNacimiento.add(datePickerNacimiento, BorderLayout.CENTER);

        // NUMERO DE LA SUERTE
        spinnerSuerte.setModel(new SpinnerNumberModel(0, 0, 9, 1));

        Color lila = new Color(33, 24, 49);
        Color blanco = Color.WHITE;

        // LO LIMITAMOS DEL 0 AL 9
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinnerSuerte, "0");
        spinnerSuerte.setEditor(editor);

        JFormattedTextField campoNumero = editor.getTextField();
        campoNumero.setColumns(1);
        campoNumero.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);

        // NUMERO EN OSCURO
        campoNumero.setForeground(Color.BLACK);
        campoNumero.setCaretColor(Color.BLACK);

        ((javax.swing.text.NumberFormatter) campoNumero.getFormatter())
                .setAllowsInvalid(false);

        // CAMPO FECHA
        datePickerNacimiento.getComponentDateTextField().setBackground(lila);
        datePickerNacimiento.getComponentDateTextField().setForeground(blanco);

        //HOROSCOPO
        radioHoroscopo.addActionListener(e -> {
            lblTemaConsulta.setVisible(false);
            rbAmor.setVisible(false);
            rbTrabajo.setVisible(false);
            rbSuerte.setVisible(false);
        });

        // TAROT
        radioTarot.addActionListener(e -> {
            lblTemaConsulta.setVisible(true);
            rbAmor.setVisible(true);
            rbTrabajo.setVisible(true);
            rbSuerte.setVisible(true);
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

            // TIPO Y TEMA DE CONSULTA
            String tipo = obtenerTipoConsulta();
            String tema = obtenerTemaConsulta();


            // EL CONTROLADOR GENERA PREDICCION
            String resultado = controlador.generarPrediccion(
                    nombre, apellido, fecha, numero, tipo, tema);

            // LA MOSTRAMOS
            txtResultado.setText(resultado);

        });

        // NUEVA CONSULTA
        btnNuevo.addActionListener(e -> {

            txtNombre.setText("");
            txtApellido.setText("");

            datePickerNacimiento.setDate(null);

            spinnerSuerte.setValue(0);

            radioTarot.setSelected(true);
            radioHoroscopo.setSelected(false);

            rbAmor.setSelected(false);
            rbTrabajo.setSelected(false);
            rbSuerte.setSelected(false);

            lblTemaConsulta.setVisible(true);
            rbAmor.setVisible(true);
            rbTrabajo.setVisible(true);
            rbSuerte.setVisible(true);

            txtResultado.setText("");

            txtNombre.requestFocusInWindow();
        });

        // EXPORTAR PREDICCIÓN
        btnExportar.addActionListener(e -> {

            // COMPROBAMOS QUE EXISTA LA PREDICCION PARA PODER GUARDARLA
            if (txtResultado.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "🔮 Primero debes consultar tu destino.");
                return;
            }

            // DATOS DEL FORMULARIO VALIDOS
            if (!validarCampos()) {
                return;
            }

            // SELECTOR DE ARCHIVOS QUE UTILIZA UTIL
            JFileChooser selector = Util.crearSelectorFichero(
                    null, "Archivos de texto", "txt");

            selector.setSelectedFile(new File("MiDestino.txt"));

            int opcion = selector.showSaveDialog(panelPrincipal);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                File archivo = selector.getSelectedFile();

                if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                    archivo = new File(archivo.getAbsolutePath() + ".txt");
                }

                if (archivo.exists()) {

                    int respuesta = JOptionPane.showConfirmDialog(
                            panelPrincipal,
                            "✨ Este destino ya está escrito. ¿Quieres reemplazarlo?",
                            "Confirmar",
                            JOptionPane.YES_NO_OPTION);

                    if (respuesta != JOptionPane.YES_OPTION) {
                        return;
                    }
                }

                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                LocalDate fecha = datePickerNacimiento.getDate();
                int numero = (Integer) spinnerSuerte.getValue();


                String tipo = obtenerTipoConsulta();
                String tema = obtenerTemaConsulta();


                boolean guardado = GestorFicheros.exportar(
                        archivo, nombre, apellido, fecha,
                        numero, tipo, tema, txtResultado.getText());

                if (guardado) {
                    JOptionPane.showMessageDialog(panelPrincipal,
                            "✨ ¡Tu destino ha quedado escrito en las estrellas!");
                } else {
                    JOptionPane.showMessageDialog(panelPrincipal,
                            "🌑 Las estrellas no han podido guardar tu predicción.");
                }
            }
        });


        // PREGUNTA AL CERRAR APLICACIÓN
        btnCerrar.addActionListener(e -> {


            int respuesta = Util.mensajeConfirmacion(
                    "🌙 ¿Seguro que quieres abandonar tu destino?",
                    "Cerrar Tarot y Horóscopo");


            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });


        // IMPORTAR PREDICCIÓN
        btnImportar.addActionListener(e -> {

            // Creamos el selector para importar archivos de texto
            JFileChooser selector = Util.crearSelectorFichero(
                    null, "Archivos de texto", "txt");

            int opcion = selector.showOpenDialog(panelPrincipal);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                File archivo = selector.getSelectedFile();

                // Leemos el contenido del archivo
                String[] datos = GestorFicheros.importar(archivo);

                if (datos == null) {

                    JOptionPane.showMessageDialog(panelPrincipal,
                            "🌑 No hemos podido recuperar tu predicción.");
                    return;
                }

                if (datos[6].trim().isEmpty()) {

                    JOptionPane.showMessageDialog(panelPrincipal,
                            "🌌 Este pergamino todavía no tiene ningún destino escrito.");
                    return;
                }

                try {

                    // Convertimos la fecha y el número a sus tipos originales
                    LocalDate fecha = LocalDate.parse(datos[2]);
                    int numero = Integer.parseInt(datos[3]);

                    // Comprobamos que los datos recuperados sean válidos
                    if (fecha.isAfter(LocalDate.now())
                            || numero < 0 || numero > 9
                            || datos[0].trim().isEmpty()
                            || datos[1].trim().isEmpty()) {

                        JOptionPane.showMessageDialog(panelPrincipal,
                                "🌑 No hemos podido recuperar tu predicción.");
                        return;
                    }

                    String tipo = datos[4];
                    String tema = datos[5];

                    if (!tipo.equals("TAROT") && !tipo.equals("HOROSCOPO")) {

                        JOptionPane.showMessageDialog(panelPrincipal,
                                "🌑 No hemos podido recuperar tu predicción.");
                        return;
                    }

                    if (tipo.equals("TAROT")
                            && !tema.equals("AMOR")
                            && !tema.equals("TRABAJO")
                            && !tema.equals("SUERTE")) {

                        JOptionPane.showMessageDialog(panelPrincipal,
                                "🌑 No hemos podido recuperar tu predicción.");
                        return;
                    }

                    txtNombre.setText(datos[0]);
                    txtApellido.setText(datos[1]);
                    datePickerNacimiento.setDate(fecha);
                    spinnerSuerte.setValue(numero);

                    if (tipo.equals("TAROT")) {

                        radioTarot.setSelected(true);
                        radioHoroscopo.setSelected(false);

                        lblTemaConsulta.setVisible(true);
                        rbAmor.setVisible(true);
                        rbTrabajo.setVisible(true);
                        rbSuerte.setVisible(true);

                        rbAmor.setSelected(tema.equals("AMOR"));
                        rbTrabajo.setSelected(tema.equals("TRABAJO"));
                        rbSuerte.setSelected(tema.equals("SUERTE"));

                    } else {

                        radioHoroscopo.setSelected(true);
                        radioTarot.setSelected(false);

                        lblTemaConsulta.setVisible(false);
                        rbAmor.setVisible(false);
                        rbTrabajo.setVisible(false);
                        rbSuerte.setVisible(false);
                    }

                    // MOSTRAMOS PREDICCION RECUPERADA
                    txtResultado.setText(datos[6]);

                    JOptionPane.showMessageDialog(panelPrincipal,
                            "✨ Las estrellas han recuperado tu destino.");

                } catch (RuntimeException ex) {

                    // CONTROL DE ERRORES DE ARCHIVO
                    JOptionPane.showMessageDialog(panelPrincipal,
                            "🌑 No hemos podido recuperar tu predicción.");
                }
            }
        });
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    // CAMBIA EL FONDO DEL BOTON SI ESTA SELECCIONADO
    private void colorearRadioButton(JRadioButton boton) {
        Color colorSeleccionado = new Color(105, 45, 155);
        Color colorNormal = new Color(33, 24, 49);

        boton.setOpaque(true);
        if (boton.isSelected()) {
            boton.setBackground(colorSeleccionado);
        } else {
            boton.setBackground(colorNormal);
        }
    }

    // OBTIENE LA CONSULTA SELECCIONADA
    private String obtenerTipoConsulta() {
        if (radioTarot.isSelected()) {
            return "TAROT";
        } else {
            return "HOROSCOPO";
        }
    }

    // OBTIENE EL TEMA SELECCIONADO
    private String obtenerTemaConsulta() {
        if (radioTarot.isSelected()) {
            if (rbAmor.isSelected()) {
                return "AMOR";
            } else if (rbTrabajo.isSelected()) {
                return "TRABAJO";
            } else {
                return "SUERTE";
            }
        } else {
            return "NINGUNO";
        }
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
