package co.edu.konradlorenz.controller;

import java.time.LocalDateTime;
import java.util.*;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.Vista;

public class Controlador {

    private Sucursal sucursalSelec;
    private Pelicula peliSelec;
    private Funcion funcionSelec;
    private int key;

    public ArrayList<Sucursal> listaSucursales = new ArrayList<>();
    public ArrayList<Pelicula> listaPeliculasGlobales = new ArrayList<>();

    //private Sucursal objSucursal = new Sucursal();
    private Funcion objFuncion = new Funcion();


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
                        Vista.mostrarCartelera(sucursalSelec. getObjCartelera());
                        break;
                    case 2:

                        Vista.mostrarPeliculas(listaPeliculasGlobales);
                        String nombrePelicula = Vista.pedirString("  >> Ingrese el nombre de la película: ");//se puede implementar equalsIgnoreCase en el futuro
                        
                        ArrayList<Sucursal> sucursalesTemp = new ArrayList<>();
                        
                        sucursalesTemp = recorrerSucursales(listaSucursales, nombrePelicula);
                        
                        //TODO: mostrar sucursales donde está la peli con fecha

                        for (int i = 0; i < sucursalesTemp.size() ; i++) {
                            for (int j = 0; j < sucursalesTemp.size() ; j++) {
                                
                                ///FIXME: Error en el if porque no hay funciones creadas, entonces agregué método crearFunciones() al final
                                if(sucursalesTemp.get(i).getListaFunciones().get(j).getObjPelicula().getTituloOriginal().equals(nombrePelicula)){
                                    String imprimirFuncion = sucursalesTemp.get(i).getListaFunciones().toString();
                                    Vista.mostrarMensaje(imprimirFuncion);
                                }
                                //*/

                                Vista.mostrarMensaje("Se supone que ya imprimió las funciones"); //TODO: Borrar después
                            }
                        }

                        //peliSelec = seleccionarPelicula();
                        
                        //sucursalSelec = seleccionarSucursal(sucursalesTemp);
                    
                        break;
                    default:
                        break;
                }

                break;
            case 2:

                //seleccionarPelicula();
                Vista.mostrarSucursales(listaSucursales);

                break;
            case 3:
                
                break;
            case 0:
                
                break;
            default:
                
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

    /*/
    public Pelicula seleccionarPelicula(){
        
        for (int i = 0; i < listaSucursales.size(); i++) {
            if(listaSucursales.get(i).getObjCartelera().getListaPeliculas().contains()){
                Vista.mostrarPeliculas(listaSucursales.get(i).getObjCartelera().getListaPeliculas());
            }
            
        int seleccion = Integer.parseInt(Vista.pedirString(" >> Ingrese una opción: "));
        }
        

        return objSucursal.getObjCartelera().getListaPeliculas().get(seleccion-1);

    }
    //*/

    /*/
    public Funcion seleccionarFuncion(Sucursal sucursal){

        Vista.mostrarFunciones(objSucursal.getListaPeliculas());
        Funcion funcionSelec = null;
        return funcionSelec;
    }
    //*/

    //¿Se escoge Sala de cine?

    public ArrayList<Sucursal> recorrerSucursales(ArrayList<Sucursal> listaSucursales, String tituloPeliculaSelec){

        ArrayList<Sucursal> sucursalesTemp = new ArrayList<>();

        for (int i = 0 ; i < listaSucursales.get(i).getObjCartelera().getListaPeliculas().size() ; i++) {
            for (int j = 0 ; j < listaSucursales.get(i).getObjCartelera().getListaPeliculas().size() ; j++) {
                if(listaSucursales.get(i).getObjCartelera().getListaPeliculas().get(j).getTituloOriginal().equals(tituloPeliculaSelec)){
                    sucursalesTemp.add(listaSucursales.get(i));
                }
            }
        }

        return sucursalesTemp;
    }
    //recorrerSucursales

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

    public void crearEjemplos() {//AI Generated
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

        // Crear 7 Sucursales
        for (int i = 1; i <= 7; i++) {
            // Crear 3 SalaCine por Sucursal
            ArrayList<SalaCine> listaSalas = new ArrayList<>();
            listaSalas.add(nuevaSalaCine("Sala 1", "Sala A", 100));
            listaSalas.add(nuevaSalaCine("Sala 2", "Sala B", 120));
            listaSalas.add(nuevaSalaCine("Sala 3", "Sala C", 80));

            // Crear Cartelera para cada sucursal con las películas
            ArrayList<Pelicula> peliculasCartelera = new ArrayList<>();
            peliculasCartelera.add(pelicula1);
            peliculasCartelera.add(pelicula2);
            peliculasCartelera.add(pelicula3);
            Cartelera cartelera = nuevaCartelera(LocalDateTime.now(), peliculasCartelera);

            // Crear 3 Funciones por sucursal
            ArrayList<Funcion> listaFunciones = new ArrayList<>();
            listaFunciones.add(nuevaFuncion("15:00", 1, pelicula1, listaSalas.get(0)));
            listaFunciones.add(nuevaFuncion("18:00", 1, pelicula2, listaSalas.get(1)));
            listaFunciones.add(nuevaFuncion("21:00", 1, pelicula3, listaSalas.get(2)));

            // Crear Sucursal con los datos
            Sucursal nuevaSucursal = nuevaSucursal("Sucursal " + i, "Dirección " + i, "Teléfono " + i, "Descripción " + i, 0.1 * i, cartelera, listaSalas, listaFunciones);
            listaSucursales.add(nuevaSucursal);
        }
        //for
    }
    //crearEjemplosCine
}
//class
