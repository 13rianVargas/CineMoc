package co.edu.konradlorenz.view;

import java.util.*;

import co.edu.konradlorenz.model.Sucursal;
import co.edu.konradlorenz.model.Pelicula;
import co.edu.konradlorenz.model.Cartelera;
import co.edu.konradlorenz.model.Funcion;


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

    public static void mostrarSucursales(ArrayList<Sucursal> lista) {
        espacioVisual();
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> ");
        for (int i = 0; i < lista.size() ; i++) {
            System.out.println("   >> [" + (i+1) +"] " + lista.get(i).getNombre());
        }
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> ");
    }

    public static void mostrarPeliculas(ArrayList<Pelicula> lista) {
        espacioVisual();
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> ");
        for (int i = 0; i < lista.size() ; i++) {
            System.out.println("   >> [" + (i+1) +"] " + lista.get(i).getTituloOriginal());
        }
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> ");
    }

    public static void mostrarFunciones(ArrayList<Funcion> lista) {
        espacioVisual();
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>");
        for (int i = 0; i < lista.size() ; i++) {
            System.out.println("   >> [" + (i+1) +"] Sala No: " + lista.get(i).getObjSalaCine() + ". Película: " + lista.get(i).getObjPelicula().getTituloOriginal() +". Día: "+ lista.get(i).getDia() +". Hora: "+ lista.get(i).getHora() + ".");
        }
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>");
    }

    public static void mostrarCartelera(Cartelera cartelera) {
        
        ArrayList<Pelicula> lista = cartelera.getListaPeliculas();

        espacioVisual();
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>");
        for (int i = 0; i < lista.size() ; i++) {
            System.out.println("   >> [" + (i+1) +"] " + lista.get(i).getTituloOriginal());
        }
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>");
    }

    public static void mostrarSalasCine(ArrayList<Sucursal> listaSucursales){
        espacioVisual();
        System.out.println(" <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>");
        for (int i = 0; i < listaSucursales.size() ; i++) {
            System.out.println("\n[" + listaSucursales.get(i).getNombre() + "]");
            for (int j = 0; j < listaSucursales.get(i).getListaSalasCine().size() ; j++) {
                System.out.println(" >> Número de sala: " + listaSucursales.get(i).getListaSalasCine().get(j).getNumero() + ", Nombre de sala: " + listaSucursales.get(i).getListaSalasCine().get(j).getNombre() + ", Sillas disponibles: " + listaSucursales.get(i).getListaSalasCine().get(j).getCantSillas());
            }
        }
        System.out.println("\n <> <> <> <> <> <> <> <> <> <> <> <> <> <> <>");
    }
    
    public static void espacioVisual(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}
