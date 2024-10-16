package co.edu.konradlorenz.controller;

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

        // Crear datos base
        crearSucursales();
        crearPeliculas();
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
                        String nombrePelicula = Vista.pedirString("  >> Ingrese el nombre de la película: ");//notCamel
                        
                        ArrayList<Sucursal> sucursalesTemp = new ArrayList<>();
                        
                        sucursalesTemp = recorrerSucursales(listaSucursales, nombrePelicula);
                        
                        //mostrar sucursales donde está la peli con fecha

                        for (int i = 0; i < sucursalesTemp.size() ; i++) {
                            for (int j = 0; j < sucursalesTemp.size() ; j++) {
                                if(sucursalesTemp.get(i).getListaFunciones().get(j).getObjPelicula().getTituloOriginal().equals(nombrePelicula)){
                                    Vista.mostrarMensaje(objFuncion.toString());
                                }
                            }
                        }

                        //peliSelec = seleccionarPelicula();
                        
                        sucursalSelec = seleccionarSucursal(sucursalesTemp);
                    
                        break;
                    default:
                        break;
                }

                break;
            case 2:

                //seleccionarPelicula();
                Vista.mostrarSucursales(listaSucursales);

                break;
            default:
                break;
        }
    }

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

        for (int i = 0 ; i < listaSucursales.size() ; i++) {
            for (int j = 0 ; j < listaSucursales.size() ; j++) {
                if(listaSucursales.get(i).getObjCartelera().getListaPeliculas().get(j).getTituloOriginal().equals(tituloPeliculaSelec)){
                    sucursalesTemp.add(listaSucursales.get(i));
                }
            }
        }

        return sucursalesTemp;
    }

    public void crearSucursales(){

        listaSucursales.add(new Sucursal(
            "CineMoc Star",                
            "Calle 123",                
            "3001234567",               
            "Gran cine con múltiples salas",
            10.5,                       
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()            
        ));
        
        listaSucursales.add(new Sucursal(
            "CineMoc Max", 
            "Avenida 45", 
            "3007654321", 
            "Cine moderno y cómodo", 
            15.0, 
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()
        ));
        
        listaSucursales.add(new Sucursal(
            "CineMoc Embajador", 
            "Carrera 12", 
            "3101234567", 
            "El cine favorito de la ciudad", 
            12.3, 
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()
        ));
        
        listaSucursales.add(new Sucursal(
            "CineMoc Mega", 
            "Calle 77", 
            "3107654321", 
            "Experiencia de cine de lujo", 
            8.0, 
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()
        ));
        
        listaSucursales.add(new Sucursal(
            "CineMoc Plaza", 
            "Avenida Central", 
            "3151234567", 
            "Cine para toda la familia", 
            14.2, 
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()
        ));
        
        listaSucursales.add(new Sucursal(
            "CineMoc Fest", 
            "Zona Norte", 
            "3201234567", 
            "El cine con la mejor tecnología", 
            9.8, 
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()
        ));
        
        listaSucursales.add(new Sucursal(
            "CineMoc Plus", 
            "Zona Sur", 
            "3211234567", 
            "Cine con las mejores promociones", 
            7.5, 
            new Cartelera(),
            new ArrayList<>(),
            new ArrayList<>()
        ));

    }
    //crearSucursales

    public Pelicula nuevaPelicula(byte id, int duracion, String paisOrigen, String año, String tituloOriginal, String idioma,
    String sinopsis, boolean subtitulos, ArrayList<Realizador> listaRealizadores){
        
        Pelicula nuevaPelicula = new Pelicula(id, duracion, paisOrigen, año, tituloOriginal, idioma, sinopsis, subtitulos, listaRealizadores);

        return nuevaPelicula;
    }

    public void crearPeliculas(){

        Pelicula peli1 = nuevaPelicula((byte) 1, 120, "USA", "2022", "The Last Horizon", "Inglés",
        "En un futuro post-apocalíptico, un grupo de sobrevivientes lucha por encontrar un nuevo hogar.", 
        true, new ArrayList<Realizador>());
            
        listaPeliculasGlobales.add(peli1);

        for (int i = 0; i < listaSucursales.size(); i++) {
            listaSucursales.get(i).getObjCartelera().setListaPeliculas(listaPeliculasGlobales);
        }

        Pelicula peli2 = nuevaPelicula((byte) 2, 95, "Francia", "2020", "L'Art de la Vie", "Francés", "Un pintor solitario encuentra inspiración en una joven con un misterioso pasado.", 
        true, new ArrayList<Realizador>());
            
        listaPeliculasGlobales.add(peli2);
        for (int i = 0; i < listaSucursales.size(); i++) {
            listaSucursales.get(i).getObjCartelera().setListaPeliculas(listaPeliculasGlobales);
        }

        Pelicula peli3 = nuevaPelicula((byte) 3, 110, "Japón", "2019", "Kaze no Tabi", "Japonés",
        "Una joven viaja a través del Japón rural para descubrir sus raíces familiares.", 
        false, new ArrayList<Realizador>());
            
        listaPeliculasGlobales.add(peli3);
        for (int i = 0; i < listaSucursales.size(); i++) {
            listaSucursales.get(i).getObjCartelera().setListaPeliculas(listaPeliculasGlobales);
        }

        /*/
        listaPeliculasGlobales.add(new Pelicula((byte) 4, 150, "México", "2021", "El Último Sueño", "Español",
                "En un México distópico, los sueños se han convertido en una moneda de cambio.", 
                true, new ArrayList<Realizador>()));

        listaPeliculasGlobales.add(new Pelicula((byte) 5, 130, "India", "2023", "Samsara", "Hindi",
                "Un monje budista busca el significado de la vida en un viaje espiritual.", 
                false, new ArrayList<Realizador>()));

        listaPeliculasGlobales.add(new Pelicula((byte) 6, 105, "Reino Unido", "2018", "The Silent Sea", "Inglés",
                "Un submarino británico se enfrenta a misteriosas fuerzas en las profundidades del océano.", 
                true, new ArrayList<Realizador>()));

        listaPeliculasGlobales.add(new Pelicula((byte) 7, 140, "Alemania", "2022", "Der Fall", "Alemán",
                "Un abogado lucha contra un sistema corrupto para exonerar a su cliente inocente.", 
                true, new ArrayList<Realizador>()));

        listaPeliculasGlobales.add(new Pelicula((byte) 8, 90, "España", "2021", "El Eco de las Montañas", "Español",
                "Un grupo de amigos redescubre su pasado en una pequeña aldea de montaña.", 
                true, new ArrayList<Realizador>()));

        listaPeliculasGlobales.add(new Pelicula((byte) 9, 115, "Corea del Sur", "2020", "Yeon", "Coreano",
                "Una bailarina enfrenta las barreras de una sociedad rígida mientras busca su libertad.", 
                true, new ArrayList<Realizador>()));

        listaPeliculasGlobales.add(new Pelicula((byte) 10, 125, "Brasil", "2019", "A Floresta Escondida", "Portugués",
                "Un explorador descubre una tribu olvidada en lo profundo de la selva amazónica.", 
                false, new ArrayList<Realizador>()));
        //*/

    }
    //crearPeliculas
}
