package co.edu.konradlorenz.controller;

import java.time.LocalDateTime;
import java.util.*;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.Vista;

public class Controlador {

    private Sucursal sucursalSelec;
    private int key;

    public ArrayList<Sucursal> listaSucursales = new ArrayList<>();
    public ArrayList<Pelicula> listaPeliculasGlobales = new ArrayList<>();

    public void run() {
        //PASOS:

        // Crear ejemplos base
            crearEjemplos();
        //*/

        //1.
        key = Vista.menuPrincipal();

        switch (key) {
            case 1:
                
                key = Vista.menuCartelera();

                switch (key) {
                    case 1:
                        sucursalSelec = seleccionarSucursal(listaSucursales);
                        Vista.mostrarCartelera(sucursalSelec.getObjCartelera());
                        break;
                    case 2:

                        Vista.mostrarPeliculas(listaPeliculasGlobales);
                        String nombrePelicula = Vista.pedirString("  >> Ingrese el nombre de la película: ");//se puede implementar equalsIgnoreCase en el futuro

                        recorrerSucursales(nombrePelicula);
                    
                        break;
                    case 0:
                        Vista.mostrarMensaje("ADIÓS");
                        System.exit(0);
                        break;
                    default:
                        Vista.mostrarMensaje("Opción no válida");
                        break;
                }

                break;
            case 2:

                key = Vista.menuPeliculas();

                switch (key) {
                    case 1:
                        byte id = Byte.parseByte(Vista.pedirString(" >> Ingrese el id de la película: "));
                        int duracion = Integer.parseInt(Vista.pedirString(" >> Ingrese la duración de la película: "));
                        String paisOrigen = Vista.pedirString(" >> Ingrese país de origen de la película: ");
                        String año = Vista.pedirString(" >> Ingrese el año de la película: ");
                        String tituloOriginal = Vista.pedirString(" >> Ingrese el título original de la película: ");
                        String idioma = Vista.pedirString(" >> Ingrese el idioma de la película: ");
                        String sinopsis = Vista.pedirString(" >> Ingrese la sinopsis de la película: ");

                        boolean subtitulos = false;
                        String sub = Vista.pedirString(" >> ¿La película tiene subtitulos? (Y/N) ");
                        if (sub.equals("Y")) {
                            subtitulos = true;
                        }else if(sub.equals("N")){
                            subtitulos = false;
                        }else{
                            Vista.mostrarMensaje("Opción no válida");
                        }

                        String nombre = Vista.pedirString(" >> Ingrese el nombre del Director: ");
                        String nacionalidad = Vista.pedirString(" >> Ingrese la nacionalidad del Director: ");
                        int cantPeliculas = Integer.parseInt(Vista.pedirString(" >> Ingrese cantidad de películas del Director: "));
                        Director director = nuevoDirector(nombre, nacionalidad, cantPeliculas);

                        ArrayList<String> personajesActor = new ArrayList<>();
                        String personaje = Vista.pedirString(" >> Ingrese el personaje del actor: ");
                        personajesActor.add(personaje);

                        nombre = Vista.pedirString(" >> Ingrese el nombre del Actor: ");
                        nacionalidad = Vista.pedirString(" >> Ingrese la nacionalidad del Actor: ");
                        cantPeliculas = Integer.parseInt(Vista.pedirString(" >> Ingrese cantidad de películas del Actor: "));
                        Actor actor = new Actor(nombre, nacionalidad, cantPeliculas, personajesActor);

                        ArrayList<Realizador> realizadores = new ArrayList<>();
                        realizadores.add(director);
                        realizadores.add(actor);

                        Pelicula pelicula = nuevaPelicula(id, duracion, paisOrigen, año, tituloOriginal, idioma, sinopsis, subtitulos, realizadores);
                        listaPeliculasGlobales.add(pelicula);

                        break;
                    case 2:
                        Vista.mostrarPeliculas(listaPeliculasGlobales);
                        break;
                    case 0:
                        Vista.mostrarMensaje("ADIÓS");
                        System.exit(0);
                        break;
                    default:
                        Vista.mostrarMensaje("Opción no válida");
                        break;
                }

                break;
            case 3:
                
                Vista.mostrarSalasCine(listaSucursales);

                break;
            case 0:
                Vista.mostrarMensaje("ADIÓS");
                System.exit(0);
                break;
            default:
                Vista.mostrarMensaje("Opción no válida");
                break;

        }
        //switch
    }
    //run

    public Sucursal seleccionarSucursal(ArrayList<Sucursal> lista){
        
        Vista.mostrarSucursales(lista);
        int seleccion = Integer.parseInt(Vista.pedirString(" >> Ingrese una opción: "));

        return lista.get(seleccion-1);
    }

    public Sucursal nuevaSucursal(String nombre, String direccion, String telefono, String descripcion, double descuento,
    Cartelera objCartelera, ArrayList<SalaCine> listaSalasCine, ArrayList<Funcion> listaFunciones){
        
        Sucursal nuevaSucursal = new Sucursal(nombre, direccion, telefono, descripcion, descuento, objCartelera, listaSalasCine, listaFunciones);

        return nuevaSucursal;
    }

    public SalaCine nuevaSalaCine(String numero, String nombre, int cantSillas){
        
        SalaCine nuevaSalaCine = new SalaCine(numero, nombre, cantSillas);

        return nuevaSalaCine;
    }

    public Cartelera nuevaCartelera(LocalDateTime fecha, ArrayList<Pelicula> listaPeliculas){
        
        Cartelera nuevaCartelera = new Cartelera(fecha, listaPeliculas);

        return nuevaCartelera;
    }

    public Funcion nuevaFuncion(String hora, int dia, Pelicula objPelicula, SalaCine objSalaCine){
        
        Funcion nuevaFuncion = new Funcion(hora, dia, objPelicula, objSalaCine);

        return nuevaFuncion;
    }   

    public Pelicula nuevaPelicula(byte id, int duracion, String paisOrigen, String año, String tituloOriginal, String idioma,
    String sinopsis, boolean subtitulos, ArrayList<Realizador> listaRealizadores){
        
        Pelicula nuevaPelicula = new Pelicula(id, duracion, paisOrigen, año, tituloOriginal, idioma, sinopsis, subtitulos, listaRealizadores);

        return nuevaPelicula;
    }

    public Director nuevoDirector(String nombre, String nacioalidad, int cantPeliculas){
        
        Director nuevoDirector = new Director(nombre, nacioalidad, cantPeliculas);

        return nuevoDirector;
    }

    public Actor nuevoActor(String nombre, String nacioalidad, int cantPeliculas){
        
        Actor nuevoActor = new Actor(nombre, nacioalidad, cantPeliculas);

        return nuevoActor;
    }

    public void recorrerSucursales(String nombrePelicula) {
        boolean peliculaEncontrada = false;
        
        for (Sucursal sucursal : listaSucursales) {
            ArrayList<Funcion> funciones = sucursal.getListaFunciones();
            
            if (funciones != null && !funciones.isEmpty()) {
                boolean peliculaEnSucursal = false;
                
                String horario = "No hay funciones de esta película en esta sucursal.";
                
                for (Funcion funcion : funciones) {
                    Pelicula pelicula = funcion.getObjPelicula();
                    
                    if (pelicula != null && pelicula.getTituloOriginal().equalsIgnoreCase(nombrePelicula.trim())) {
                        peliculaEnSucursal = true;
                        peliculaEncontrada = true;
                        horario = "Hora de Inicio: " + funcion.getHora() + "\n";
                    }
                }
                
                if (peliculaEnSucursal) {
                    Vista.mostrarMensaje(nombrePelicula + "\n" + "Sucursal: " + sucursal.getNombre() +"\n"+ horario);
                }
            }
        }
    
        if (!peliculaEncontrada) {
            Vista.mostrarMensaje("La película '" + nombrePelicula + "' no está disponible en ninguna sucursal.");
        }
    }
    //mostrarSucursalesConPelicula

    public void crearEjemplos() {

        // Crear Director y Actor
        Director director1 = nuevoDirector("Christopher Nolan", "Reino Unido", 10);
        ArrayList<String> personajesActor1 = new ArrayList<>();
        personajesActor1.add("Batman");
        Actor actor1 = new Actor("Christian Bale", "Reino Unido", 30, personajesActor1);

        ArrayList<Realizador> realizadores1 = new ArrayList<>();
        realizadores1.add(director1);
        realizadores1.add(actor1);

        // Crear Películas
        Pelicula pelicula1 = nuevaPelicula((byte) 1, 120, "Estados Unidos", "2023", "Inception", "Inglés", "Sueños dentro de sueños", true, realizadores1);
        Pelicula pelicula2 = nuevaPelicula((byte) 2, 150, "Reino Unido", "2020", "Tenet", "Inglés", "Inversión del tiempo", true, realizadores1);
        Pelicula pelicula3 = nuevaPelicula((byte) 3, 140, "Estados Unidos", "2019", "Interstellar", "Inglés", "Viaje espacial", true, realizadores1);

        // Añadir películas a la lista global
        listaPeliculasGlobales.add(pelicula1);
        listaPeliculasGlobales.add(pelicula2);
        listaPeliculasGlobales.add(pelicula3);

        String nombreSucursales[] = {"Plus","Mayor","Atlantis","Eden","Plaza Mayor","Embajador","Tron"};
        
        // Crear 7 Sucursales
        for (int i = 1; i <= 7; i++) {
            // Crear 3 SalaCine por Sucursal
            ArrayList<SalaCine> listaSalas = new ArrayList<>();
            listaSalas.add(nuevaSalaCine("1", "Sala 2D", 100));
            listaSalas.add(nuevaSalaCine("2", "Sala 3D", 120));
            listaSalas.add(nuevaSalaCine("3", "Sala 4D BOX", 80));

            // Crear Cartelera para cada sucursal con las películas
            ArrayList<Pelicula> peliculasCartelera = new ArrayList<>();
            peliculasCartelera.add(pelicula1);
            peliculasCartelera.add(pelicula2);
            peliculasCartelera.add(pelicula3);
            Cartelera cartelera = nuevaCartelera(LocalDateTime.now(), peliculasCartelera);

            // Crear Funciones por sucursal
            ArrayList<Funcion> listaFunciones = new ArrayList<>();
            listaFunciones.add(nuevaFuncion("15:00", 1, pelicula1, listaSalas.get(0)));
            listaFunciones.add(nuevaFuncion("18:00", 1, pelicula2, listaSalas.get(1)));
            listaFunciones.add(nuevaFuncion("21:00", 1, pelicula3, listaSalas.get(2)));

            // Crear Sucursal con los datos
            Sucursal nuevaSucursal = nuevaSucursal("CineMoc " + nombreSucursales[i-1], "Dirección " + i, "Teléfono " + i, "Descripción " + i, 0.1 * i, cartelera, listaSalas, listaFunciones);
            listaSucursales.add(nuevaSucursal);
            
        }
        //for
    }
    //crearEjemplosCine
}
//class
