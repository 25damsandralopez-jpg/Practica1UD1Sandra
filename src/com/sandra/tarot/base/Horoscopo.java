package com.sandra.tarot.base;

import java.time.LocalDate;

public class Horoscopo extends Consulta {

    private String signoZodiacal;


    public Horoscopo() {
        super();
    }


    public Horoscopo(String nombre, String apellido,
                     LocalDate fechaNacimiento, int numeroSuerte,
                     String signoZodiacal) {

        super(nombre, apellido, fechaNacimiento, numeroSuerte);
        this.signoZodiacal = signoZodiacal;
    }


    public String getSignoZodiacal() {
        return signoZodiacal;
    }

    public void setSignoZodiacal(String signoZodiacal) {
        this.signoZodiacal = signoZodiacal;
    }


    public String calcularSigno() {

        int dia = getFechaNacimiento().getDayOfMonth();
        int mes = getFechaNacimiento().getMonthValue();

        if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
            return "Aries";
        } else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
            return "Tauro";
        } else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
            return "Geminis";
        } else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
            return "Cancer";
        } else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
            return "Leo";
        } else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
            return "Virgo";
        } else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
            return "Libra";
        } else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
            return "Escorpio";
        } else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
            return "Sagitario";
        } else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
            return "Capricornio";
        } else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            return "Acuario";
        } else {
            return "Piscis";
        }
    }


    public String obtenerDescripcion() {

        signoZodiacal = calcularSigno();

        switch (signoZodiacal) {

            case "Aries":
                return "Eres una persona valiente, apasionada y llena de energia. "
                        + "Te gustan los retos y no tienes miedo de tomar la iniciativa. "
                        + "A veces puedes ser algo impaciente, pero tu entusiasmo es contagioso.";

            case "Tauro":
                return "Eres una persona leal, paciente y muy constante. "
                        + "Valoras la tranquilidad, la seguridad y las pequeñas cosas de la vida. "
                        + "Aunque puedes ser algo cabezota, siempre luchas por lo que quieres.";

            case "Geminis":
                return "Eres una persona curiosa, divertida y muy comunicativa. "
                        + "Te encanta aprender cosas nuevas y conocer gente diferente. "
                        + "Tu mente nunca descansa y siempre tienes alguna idea en marcha.";

            case "Cancer":
                return "Eres una persona sensible, cariñosa y muy intuitiva. "
                        + "Tu familia y tus seres queridos son muy importantes para ti. "
                        + "Aunque a veces te cuesta mostrar lo que sientes, tienes un gran corazon.";

            case "Leo":
                return "Eres una persona segura, generosa y con mucha personalidad. "
                        + "Te gusta destacar y transmitir alegria a los demas. "
                        + "Tienes un gran corazon y siempre proteges a quienes quieres.";

            case "Virgo":
                return "Eres una persona responsable, observadora y perfeccionista. "
                        + "Te gusta tener las cosas organizadas y cuidar los pequeños detalles. "
                        + "Aunque a veces te exiges demasiado, siempre intentas dar lo mejor de ti.";

            case "Libra":
                return "Eres una persona sociable, amable y amante del equilibrio. "
                        + "Buscas la armonia en tus relaciones y no te gustan los conflictos. "
                        + "A veces te cuesta decidirte porque buscas la mejor opcion.";

            case "Escorpio":
                return "Eres una persona intensa, misteriosa y muy apasionada. "
                        + "Cuando quieres a alguien, lo haces de verdad. "
                        + "Tienes una gran intuicion y una fuerza interior sorprendente.";

            case "Sagitario":
                return "Eres una persona aventurera, optimista y muy independiente. "
                        + "Te encanta descubrir lugares nuevos y vivir experiencias diferentes. "
                        + "Tu sinceridad y tu sentido del humor son parte de tu encanto.";

            case "Capricornio":
                return "Eres una persona trabajadora, responsable y perseverante. "
                        + "Cuando te propones algo, haces todo lo posible por conseguirlo. "
                        + "Aunque a veces pareces seria, tienes un lado muy cariñoso.";

            case "Acuario":
                return "Eres una persona original, creativa y muy independiente. "
                        + "Te gusta pensar de forma diferente y seguir tu propio camino. "
                        + "Valoras mucho la amistad y siempre tienes ideas sorprendentes.";

            case "Piscis":
                return "Eres una persona soñadora, sensible y muy empatica. "
                        + "Tienes una gran imaginacion y conectas facilmente con las emociones. "
                        + "Tu creatividad y tu bondad hacen que los demas se sientan bien contigo.";

            default:
                return "No se ha encontrado tu signo zodiacal.";
        }
    }

    @Override
    public String consultarAmor() {
        return "";
    }

    @Override
    public String consultarTrabajo() {
        return "";
    }

    @Override
    public String consultarSuerte() {
        return "";
    }
}
