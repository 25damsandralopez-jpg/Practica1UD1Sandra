
package com.sandra.tarot.controlador;

import com.sandra.tarot.base.Horoscopo;
import com.sandra.tarot.base.NumeroSuerte;
import com.sandra.tarot.base.Tarot;

import java.time.LocalDate;

public class ControladorConsulta {

    public String generarPrediccion(String nombre, String apellido,
                                    LocalDate fecha, int numero,
                                    String tipo, String tema) {

        String resultado;

        if (tipo.equals("TAROT")) {

            Tarot tarot = new Tarot(nombre, apellido, fecha, numero);

            String prediccion;

            if (tema.equals("AMOR")) {
                prediccion = tarot.consultarAmor();

            } else if (tema.equals("TRABAJO")) {
                prediccion = tarot.consultarTrabajo();

            } else {
                prediccion = tarot.consultarSuerte();
            }

            resultado = "🔮 TU PREDICCIÓN DEL TAROT\n\n" + prediccion;

        } else {

            Horoscopo horoscopo = new Horoscopo();
            horoscopo.setNombre(nombre);
            horoscopo.setApellido(apellido);
            horoscopo.setFechaNacimiento(fecha);
            horoscopo.setNumeroSuerte(numero);

            String signo = horoscopo.calcularSigno();
            String descripcion = horoscopo.obtenerDescripcion();

            resultado = "🌙 TU HORÓSCOPO\n\n"
                    + nombre + ", tu signo zodiacal es: " + signo
                    + "\n\n" + descripcion;
        }

        NumeroSuerte numeroSuerte = new NumeroSuerte();
        String mensaje = numeroSuerte.obtenerMensaje(numero, nombre);

        resultado += "\n\n----------------------------------";
        resultado += "\n🍀 TU NÚMERO DE LA SUERTE: " + numero;
        resultado += "\n\n" + mensaje;

        return resultado;
    }
}
