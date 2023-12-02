import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaPrincipal {

    public static void Msj(String texto) {

        System.out.println(texto);
    
    } //CIERRE METODO.

    public static void IniciarProgramaPrincipal() {

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //VARIABLES PARA EL INICIO DE SESION.
        String usuario = "";
        String usuarioGuardado = "";
        String clave = "";
        String claveGuardada = "";

        String colorVerde = "\u001B[32m";
        String colorRojo = "\u001B[31m";
        String resetColor = "\u001B[0m";
        String colorVioleta = "\u001B[35m";
        String colorAmarillo = "\u001B[33m";

        Msj(colorVioleta + "Bienvenido a nuestro cine." + resetColor);

        Msj(colorVioleta + "Al ser su primera vez con nosotros, necesitamos que se registre." + resetColor);

        Msj(colorVioleta + "Por favor, registre su usuario:" + resetColor);
        usuarioGuardado = scanner.nextLine();

        Msj(colorVioleta + "Por favor, registre su clave:" + resetColor);
        claveGuardada = scanner.nextLine();

        Msj(colorVerde + "Se registró con éxito." + resetColor);

        Msj(colorVioleta + "Bienvenido al inicio de sesión." + resetColor);

        Msj(colorVioleta + "Por favor, ingrese su usuario:" + resetColor);
        usuario = scanner.nextLine();

        Msj(colorVioleta + "Por favor, ingrese su clave:" + resetColor);
        clave = scanner.nextLine();

        while (!usuario.equals(usuarioGuardado) || !clave.equals(claveGuardada)) {
            
            Msj(colorRojo + "Por favor, inténtelo nuevamente, su usuario o clave son inválidos." + resetColor);


            Msj(colorVioleta + "Por favor, ingrese su usuario: " + resetColor);
            usuario = scanner.nextLine();

            Msj(colorVioleta + "Por favor, ingrese su clave: " + resetColor);
            clave = scanner.nextLine();
        
        } //CIERRE WHILE DE INICIO DE SESION.

        //BIENVENIDA.
        Msj(colorVerde + "Buenos días, bienvenido a su cuenta." + resetColor);

        //LISTA PRECARGADA DE PELICULAS.
        Pelicula peliculaUno = new Pelicula("Thor: Amor y Trueno", 2022, "NO DISPONIBLE");
        Pelicula peliculaDos = new Pelicula("Avatar: El Camino del Agua", 2022, "NO DISPONIBLE");
        Pelicula peliculaTres = new Pelicula("Ant-Man y la Avispa", 2023, "DISPONIBLE");
        Pelicula peliculaCuatro = new Pelicula("Barbie", 2023, "DISPONIBLE");
        Pelicula peliculaCinco = new Pelicula("Super Mario Bros: La película", 2023, "DISPONIBLE");
        Pelicula peliculaSeis = new Pelicula("Rápidos y Furiosos 10", 2023, "DISPONIBLE");

        listaPeliculas.add(peliculaUno);
        listaPeliculas.add(peliculaDos);
        listaPeliculas.add(peliculaTres);
        listaPeliculas.add(peliculaCuatro);
        listaPeliculas.add(peliculaCinco);
        listaPeliculas.add(peliculaSeis);

        while (true) {

            try {

                Msj("");
                Msj(colorVioleta + "Bienvenidos al Menú de películas." + resetColor);
                Msj(colorVioleta + "1. " + resetColor + "Agregar Película.");
                Msj(colorVioleta + "2. " + resetColor + "Editar Película.");
                Msj(colorVioleta + "3. " + resetColor + "Eliminar Película.");
                Msj(colorVioleta + "4. " + resetColor + "Mostrar Lista de películas.");
                Msj(colorVioleta + "5. " + resetColor + "Salir");
                Msj(colorAmarillo + "Por favor, seleccione una opción." + resetColor);

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1:

                        //AGREGAR PELÍCULAS A LA LISTA.
                        Msj(colorAmarillo + "Ingrese el nombre de la nueva película" + resetColor);
                        String nombreNuevo = scanner.nextLine();

                        Msj(colorAmarillo + "Ingrese la fecha de la nueva película" + resetColor);
                        int fechaNueva = scanner.nextInt();
                        scanner.nextLine();

                        Msj(colorAmarillo + "Ingrese el status de la nueva película (DISPONIBLE) O (NO DISPONIBLE)" + resetColor);
                        Msj(colorAmarillo + "Por favor, ingrese el status en mayúsculas." + resetColor);
                        String statusNuevo = scanner.nextLine();

                        Pelicula nuevaPelicula = new Pelicula(nombreNuevo, fechaNueva, statusNuevo);
                        listaPeliculas.add(nuevaPelicula);

                        Msj(colorVerde + "Película agregada con éxito" + resetColor);
                        
                    break;

                    case 2:

                        //EDITAR STATUS DE LAS PELÍCULAS.
                        if (listaPeliculas.size() > 0) {

                            Msj(colorAmarillo + "Esta es tu lista actual de películas." + resetColor);                            
                            
                            Msj(colorAmarillo + "-----LISTADO DE PELÍCULAS-----" + resetColor);
                            for (int i = 0; i < listaPeliculas.size(); i++) {

                                Pelicula pelicula = listaPeliculas.get(i);                                                                          
                                Msj(colorAmarillo + i + resetColor + ": " + pelicula.toString() + resetColor);                            
                                
                            } //CIERRE DEL FOR.
                            Msj(colorAmarillo + "---------------------------" + resetColor);
                    
                            Msj(colorAmarillo + "Seleccione el índice de la película para cambiar su status (0 para la primera película):" + resetColor);
                            int indicePelicula = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (indicePelicula >= 0 && indicePelicula < listaPeliculas.size()) {

                                Pelicula peliculaAEditar = listaPeliculas.get(indicePelicula);

                                Msj(colorAmarillo + "Status actual de la película: " + resetColor + peliculaAEditar.getStatus());
                                Msj(colorAmarillo + "¿Desea cambiar el status de la película? Ingrese 'DISPONIBLE' o 'NO DISPONIBLE':" + resetColor);
                                Msj(colorAmarillo + "Por favor, ingrese el nuevo status en mayúsculas." + resetColor);
                                String editarStatus = scanner.nextLine();
                                editarStatus = editarStatus.toUpperCase();

                                if (editarStatus.equalsIgnoreCase("DISPONIBLE") || editarStatus.equalsIgnoreCase("NO DISPONIBLE")) {

                                    peliculaAEditar.setStatus(editarStatus);
                                    Msj(colorAmarillo + "El nuevo status de la película es: " + resetColor + peliculaAEditar.getStatus());
                                    Msj(colorVerde + "Status de la película actualizado con éxito." + resetColor);
                                
                                } else {

                                    Msj(colorRojo + "Opción de status no válida." + resetColor);
                                
                                } //CIERRE DEL IF-ELSE.

                            } else {
                                
                                Msj(colorRojo + "Índice de película no válido." + resetColor);
                            
                            } //CIERRE DEL IF-ELSE.

                        } else {

                            Msj(colorRojo + "No tienes películas para editar." + resetColor);
                        
                        } //CIERRE DEL IF-ELSE.
                        
                    break;

                    case 3:

                        //ELIMINAR PELÍCULAS.
                        Msj(colorVioleta + "Para ELIMINAR una película necesitamos validar su clave." + resetColor);
                        Msj(colorVioleta + "Por favor, ingrese nuevamente su clave." + resetColor);
                        String claveSwitch = scanner.nextLine();

                        if (claveSwitch.equals(claveGuardada)) {

                            Msj(colorVerde + "Su clave se ha verificado con éxito." + resetColor);
                            Msj(colorAmarillo + "Estas son las películas de la cartelera" + resetColor);

                            //MOSTRAR PELÍCULAS.
                            Msj(colorAmarillo + "-----LISTADO DE PELÍCULAS-----" + resetColor);
                            for (Pelicula pelicula : listaPeliculas) {
                                
                                Msj(pelicula.toString());
                            
                            } //CIERRE DEL FOREACH.
                            Msj(colorAmarillo + "---------------------------" + resetColor);

                            //REQUISITOS PARA ELIMINAR UNA PELÍCULA.
                            Msj(colorAmarillo + "Ingrese el NOMBRE de la película a ELIMINAR" + resetColor);
                            String nombreAQuitar = scanner.nextLine();

                            Pelicula peliculaAQuitar = null;
                            
                            for (Pelicula pelicula : listaPeliculas) {
                                
                                if (pelicula.getNombre().equalsIgnoreCase(nombreAQuitar)) {
                                    
                                    peliculaAQuitar = pelicula;
                                    break;
                                
                                } //CIERRE DEL IF.
                            
                            } //CIERRE DEL FOREACH.
                            
                            if (peliculaAQuitar != null) {
                                
                                listaPeliculas.remove(peliculaAQuitar);
                                Msj(colorVerde + "Película removida con éxito" + resetColor);
                            
                            } else {
                                
                                Msj(colorRojo + "Película NO ENCONTRADA" + resetColor);
                            
                            } //CIERRE DEL IF-ELSE.

                        } else {
                            
                            Msj(colorRojo + "Clave no válida." + resetColor);

                        } //CIERRE IF-ELSE DE CLAVE.
                    
                    break;

                    case 4:

                        //MOSTRAR LISTA DE PELÍCULAS.
                        if (listaPeliculas.size() > 0) {
                           
                            Msj(colorAmarillo + "-----LISTADO DE PELÍCULAS-----" + resetColor);
                    
                            for (Pelicula pelicula : listaPeliculas) {                                
                    
                                if (pelicula.getStatus().equalsIgnoreCase("DISPONIBLE")) {
                                  
                                    System.out.print(colorVerde);
                                
                                } else if (pelicula.getStatus().equalsIgnoreCase("NO DISPONIBLE")) {
                                   
                                    System.out.print(colorRojo);
                                
                                }
                    
                                Msj(pelicula.toString() + resetColor);

                            } // CIERRE DEL FOREACH.
                    
                            Msj(colorAmarillo + "---------------------------" + resetColor);
                       
                        } else {

                            Msj(colorRojo + "Aún no tienes películas en la lista" + resetColor);
                        
                        } //CIERRE DEL IF-ELSE.
                        
                    break;

                    case 5:

                        //SALIR.
                        Msj(colorAmarillo + "¿Estás seguro que quieres salir? (Y/N)" + resetColor);
                        String seleccion = scanner.nextLine();
                        
                        if (seleccion.equalsIgnoreCase("Y")) {
                            
                            Msj(colorRojo + "Saliendo del programa" + resetColor);
                            
                            //CIERRE DEL SCANNER.
                            scanner.close();

                            System.exit(0);
                        
                        } else if (seleccion.equalsIgnoreCase("N")) {
                            
                            break;
                        
                        } //CIERRE DEL IF-ELSE.
                        
                    break;

                    default:

                        //OPCIÓN NO VALIDA.
                        Msj(colorRojo + "Opción ingresada incorrecta" + resetColor);
                        
                    break;

                } //CIERRE DEL SWITCH.

            } catch (Exception e) {

                Msj(colorRojo + "POR FAVOR, INGRESA UNA OPCION VALIDA" + resetColor);
                scanner.nextLine();

            } //CIERRE DEL CATCH.

        } //CIERRE DEL WHILE.

    } //CIERRE DEL METODO INICIAR CINE.

} //CIERRE DE LA CLASE PROGRAMA PRINCIPAL.