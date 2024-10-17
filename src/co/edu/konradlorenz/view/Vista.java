package co.edu.konradlorenz.view;

import java.util.*;

public class Vista {
    private Scanner sc = new Scanner(System.in);
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static String pedirString(String info){
    	Vista v = new Vista();
        System.out.println(info);
        return v.sc.nextLine();
    }
    
    public static void espacioVisual(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public static int menuPrincipal(){
        espacioVisual();
        System.out.println(
                        " <> <> <> <> CINE-MOC <> <> <> <> \n" +
                        "       [1] | Cartelera            \n" +
                        "       [2] | Películas            \n" +
                        "       [3] | Sucursales           \n" +
                        "       [0] | Salir                \n" +
                        " <> <> <> <> <> <> <> <> <> <> <> \n");
        return Integer.parseInt(Vista.pedirString(" >> Ingrese una opción: "));
    }

    public static int menuCartelera(){
        espacioVisual();
        System.out.println(
                        " <> <> <> <>  Cartelera  <> <> <> \n" +
                        "    [1] | Cartelera por sucursal  \n" +
                        "    [2] | Seleccionar Película    \n" +
                        "    [0] | Salir                   \n" +
                        " <> <> <> <> <> <> <> <> <> <> <> \n");
        return Integer.parseInt(Vista.pedirString(" >> Ingrese una opción: "));
    }

    public static int menuPeliculas(){
        espacioVisual();
        System.out.println(
                        " <> <> <> <> Película <> <> <> <> \n" +
                        "    [1] | Agregar nueva película  \n" +
                        "    [2] | Mostrar películas       \n" +
                        "    [0] | Salir                   \n" +
                        " <> <> <> <> <> <> <> <> <> <> <> \n");
        return Integer.parseInt(Vista.pedirString(" >> Ingrese una opción: "));
    }
    
}
