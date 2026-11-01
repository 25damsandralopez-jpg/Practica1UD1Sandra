package com.sandra.tarot.base;

public class NumeroSuerte {

    public String obtenerMensaje(int numero, String nombre) {


        if (nombre.trim().equalsIgnoreCase("Elena")) {

            switch (numero) {

                case 0:
                    return "Cero dudas tiene el universo: eres una profesora de diez.";

                case 1:
                    return "Eres la número uno enseñando. También la número uno en conseguir que nadie se atreva a levantar las manos del teclado.";

                case 2:
                    return "Dos segundos has tardado en explicar el ejercicio. Tus alumnos todavía están buscando dónde está el botón de ejecutar.";

                case 3:
                    return "A la tercera va la vencida. Aunque contigo, cuando llegamos al tercer intento, ya estamos en el tema siete.";

                case 4:
                    return "Cuatro velocidades tiene tu clase: rápida, muy rápida, turbo y «Elena, espera, por favor».";

                case 5:
                    return "Cinco estrellas merecidísimas. En las reseñas pondría: "
                            + "«Explica genial, tiene una paciencia infinita y una velocidad "
                            + "que todavía no ha conseguido alcanzar la fibra óptica».";

                case 6:
                    return "Dicen que existe un sexto sentido. Tus alumnos lo están desarrollando para seguir el ritmo de tus clases.";

                case 7:
                    return "Siete de cada diez alumnos recomiendan tus clases. Los otros tres todavía están intentando terminar de copiar el código de la última clase.";

                case 8:
                    return "El ocho tumbado representa el infinito. Como tu paciencia para enseñar... aunque el tiempo para copiar el código sea más bien limitado.";

                case 9:
                    return "Nueve razones para sonreír y una más para darte las gracias por todo lo que enseñas.";
            }
        }


        switch (numero) {

            case 0:
                return "El cero representa la nada. Curiosamente, también lo que has conseguido con esta consulta.";

            case 1:
                return "Eres el número uno... en tomar malas decisiones.";

            case 2:
                return "Dos caminos se abren ante ti, pero seguro que escoges el equivocado.";

            case 3:
                return "A la tercera va la vencida, pero tú ya la dejaste atrás hace tiempo.";

            case 4:
                return "Cuatro estaciones tiene el año y tú llevas todas esperando a que te cambie la suerte.";

            case 5:
                return "Por el culo te la hinco. ¿Pensabas que este número te iba a dar suerte? JAJAJA.";

            case 6:
                return "Seis es el número que has elegido. El sentido común era el sexto sentido, pero parece que ese no iba contigo.";

            case 7:
                return "Dicen que el siete da suerte. Contigo vamos a poner esa teoría a prueba.";

            case 8:
                return "Ocho tumbado es infinito. Como la cantidad de tonterías que haces al día.";

            case 9:
                return "El nueve es un seis que ha dado la vuelta. Prueba tú a darle una vuelta a tu vida.";

            default:
                return "El número de la suerte debe estar entre 0 y 9.";
        }
    }
}
