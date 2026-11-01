package com.sandra.tarot.base;

import java.time.LocalDate;

public class Tarot extends Consulta {


    public Tarot() {
        super();
    }


    public Tarot(String nombre, String apellido,
                 LocalDate fechaNacimiento, int numeroSuerte) {

        super(nombre, apellido, fechaNacimiento, numeroSuerte);
    }

    public boolean esEspecial() {
        return getNombre().trim().equalsIgnoreCase("Elena");
    }

    @Override
    public String consultarAmor() {

        if (esEspecial()) {
            return "Hoy te sentirás desbordante de amor y generosidad. "
                    + "Las cartas revelan que tus alumnos han trabajado con tanta ilusión "
                    + "que tu corazón no podrá resistirse. Déjate llevar por tus sentimientos… "
                    + "¡y no pares de repartir dieces!";
        }


        int opcion = (int) (Math.random() * 3);

        switch (opcion) {

            case 0:
                return "Las cartas revelan que el amor está más cerca de lo que imaginas. "
                        + "Alguien podría sorprenderte cuando menos te lo esperes. "
                        + "Abre tu corazón, porque las mejores historias "
                        + "a veces comienzan sin buscarlas. 💕";

            case 1:
                return "El universo te recomienda dejar de buscar señales "
                        + "donde no las hay. A veces un mensaje es solo un mensaje… "
                        + "aunque las cartas anuncian que pronto podrías "
                        + "llevarte una sorpresa inesperada. 🔮";

            case 2:
                return "Tu energía amorosa está cambiando. "
                        + "Se acercan momentos bonitos y nuevas oportunidades. "
                        + "El destino puede abrirte muchas puertas, "
                        + "pero tendrás que atreverte a cruzarlas. ❤️";

            default:
                return "Las cartas no han podido revelar tu futuro amoroso.";
        }
    }

    @Override
    public String consultarTrabajo() {

        // Predicción especial para Elena
        if (esEspecial()) {
            return "Hoy será un día maravilloso en el trabajo. "
                    + "Tus alumnos te sorprenderán con proyectos increíbles, "
                    + "fruto de tu paciencia y tu magnífica forma de enseñar. "
                    + "Las cartas son claras: tu esfuerzo merece una recompensa… "
                    + "¡y el suyo, una nota de 10!";
        }

        int opcion = (int) (Math.random() * 3);

        switch (opcion) {

            case 0:
                return "Las cartas anuncian nuevas oportunidades profesionales. "
                        + "Tu esfuerzo y dedicación podrían empezar a dar resultados "
                        + "antes de lo que imaginas. Sigue trabajando por tus objetivos, "
                        + "porque el universo parece estar de tu parte. ✨";

            case 1:
                return "El universo te pide paciencia. "
                        + "Ese proyecto que parecía imposible podría terminar "
                        + "convirtiéndose en uno de tus mayores logros. "
                        + "Confía en tus capacidades y no te rindas ahora. 🔮";

            case 2:
                return "Se avecinan cambios en tu vida laboral. "
                        + "Las cartas revelan que una oportunidad inesperada "
                        + "podría aparecer muy pronto. "
                        + "No dejes que el miedo te impida aprovecharla. 💼";

            default:
                return "Las cartas no han podido revelar tu futuro laboral.";
        }
    }

    @Override
    public String consultarSuerte() {

        // Predicción especial para Elena
        if (esEspecial()) {
            return "Las cartas revelan que hoy la suerte está de tu lado, "
                    + "pero hay un pequeño detalle… "
                    + "¡está directamente relacionada con las notas que pongas! "
                    + "Recuerda que el karma siempre vuelve: un 5 atrae suerte normalita, "
                    + "un 7 trae buenas vibraciones y un 10… "
                    + "¡quién sabe, quizás hasta te toque la lotería! "
                    + "Tú decides cuánta suerte quieres atraer. 🔮✨";
        }

        int opcion = (int) (Math.random() * 3);

        switch (opcion) {

            case 0:
                return "Hoy los astros están de tu parte. "
                        + "Las cartas anuncian que podrías encontrarte "
                        + "con una oportunidad inesperada. "
                        + "Confía en tu intuición y aprovecha el momento. 🍀";

            case 1:
                return "Las cartas anuncian un día lleno de pequeñas sorpresas. "
                        + "Puede que la suerte aparezca donde menos la esperas. "
                        + "Mantén los ojos abiertos, porque el universo "
                        + "podría tener algo especial preparado para ti. ✨";

            case 2:
                return "Tu suerte está despertando… "
                        + "aunque quizá necesite cinco minutos más y un café. "
                        + "Los astros recomiendan tener paciencia, "
                        + "porque las cosas buenas podrían estar a punto de llegar. 🔮";

            default:
                return "Las cartas no han podido revelar tu suerte.";
        }
    }
}
