import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EjemploLibreria {
    public static void main(String[] args) throws ParseException {

        List<Usuario> admins = new ArrayList<>();
        admins.add(new Usuario("Samuel", "1234"));
        admins.add(new Usuario("Ivonnet", "9532"));

        String tituloLibros, autorLibro, fechaPublicacion, categoriaNuevo;
        Integer numeropaginas;

        Scanner s = new Scanner(System.in);
        Integer acceso, size = 0;
        Integer accesoCliente;
        Integer accesoAdmins;
        String usuario;
        String contraseña;
        DateFormat df = new SimpleDateFormat("yyyy");
        String genero = null, autor, tituloLibro;
        Categoria categoria;
        boolean salir = false, programaActivo = true, existe = false;


        Map<String, Libro> libros = new TreeMap<>();

        libros.put("El maravilloso mago de oz", new Libro("El maravilloso mago de oz", "Lyam Frank Baum", df.parse("1900"), 200, Categoria.INFANTIL_JUVENIL));
        libros.put("El resplandor", new Libro("El resplandor", "Stephen King", df.parse("1977"), 190, Categoria.CIENCIA_FICCION));
        libros.put("Cien años de soledad", new Libro("Cien años de soledad", "Gabriel García Marquez", df.parse("1829-10-12"), 150, Categoria.LITERATURA_COLOMBIANA));
        libros.put("Una tierra prometida", new Libro("Una tierra prometida", "Barack Obama", df.parse("2020"), 150, Categoria.BIOGRAFIAS));
        libros.put("Matilda", new Libro("Matilda", "Roald Dahl", df.parse("1988"), 150, Categoria.INFANTIL_JUVENIL));


        do {
            salir = false;
            System.out.println("\nBienvenido al Cafe Librería QA" + "\n1- Acceso para administradores \n2- Acceso para clientes");
            acceso = s.nextInt();
            s.nextLine();
            System.out.println(admins.size());

            switch (acceso) {
                case 1:
                    existe = false;
                    System.out.printf("Ingrese su Usuario: ");
                    usuario = s.nextLine();
                    System.out.printf("Ingrese su Contraseña: ");
                    contraseña = s.nextLine();
                    for (Usuario usr : admins) {
                        size++;
                        if (usr.getUsuario().equals(usuario) && usr.getContraseña().equals(contraseña)) {
                            existe = true;
                        }
                    }
                    if(size == admins.size() && existe == false){
                    System.out.println("***** EL USUARIO Y LA CONTRASEÑA NO CORRESPONDEN *****");
                    break;
                    }
                        while (!salir) {
                            if (existe) {
                                System.out.println("\nBienvenido " + usuario + " ¿Que deseas hacer?");
                                System.out.println("\n1. Agregar un nuevo libro " +
                                        "\n2. Ver la lista de libros disponibles " +
                                        "\n3. Salir.");
                                accesoAdmins = s.nextInt();
                                s.nextLine();
                                switch (accesoAdmins) {
                                    case 1:
                                        System.out.printf("Ingrese el titulo del libro: ");
                                        tituloLibros = s.nextLine();
                                        System.out.printf("Ingrese el nombre del autor: ");
                                        autorLibro = s.nextLine();
                                        System.out.printf("Ingrese la fecha de publicacón: ");
                                        fechaPublicacion = s.nextLine();
                                        System.out.printf("Ingrese el número de páginas: ");
                                        numeropaginas = s.nextInt();
                                        s.nextLine();
                                        System.out.printf("Ingrese la categoría: ");
                                        categoriaNuevo = s.nextLine();
                                        categoria = Categoria.valueOf(categoriaNuevo);
                                        libros.put(tituloLibros, new Libro(tituloLibros, autorLibro, df.parse(fechaPublicacion), numeropaginas, categoria));
                                        System.out.println("El Libro ha sido agregado");
                                        break;
                                    case 2:
                                        System.out.println("\n****** LISTA DE LIBROS DISPONIBLES ******");
                                        for (Map.Entry<String, Libro> admall : libros.entrySet()) {
                                            System.out.println(admall.getValue().getIndice() + " ---> " + admall.getKey());
                                        }
                                        break;
                                    case 3:
                                        salir = true;
                                        break;
                                }
                            } else {
                                continue;

                            }
                        }


                    break;
                case 2:
                    while (!salir) {
                        System.out.println("\nBienvenido al Café Libreía QA, ¿Que libro estás buscando el día de hoy?");
                        System.out.println("\n1. Para ver el listado de libros por categoría" +
                                "\n2. Para ver el listado de libros de libros por Autor" +
                                "\n3. Para buscar un titulo en especifico" +
                                "\n4. Para ver todos los libros disponibles" +
                                "\n5. Salir");
                        accesoCliente = s.nextInt();
                        s.nextLine();
                        switch (accesoCliente) {
                            case 1:
                                System.out.printf("\nIngrese la categoría: ");
                                genero = s.nextLine().toUpperCase(Locale.ROOT);
                                categoria = Categoria.valueOf(genero);
                                System.out.println("\nLibros disponibles en la categoría " + "\"" + categoria + "\"" + "\n");
                                for (Map.Entry<String, Libro> cat : libros.entrySet()) {
                                    if (cat.getValue().getCategoria().equals(categoria)) {
                                        Categoria categorias = cat.getValue().getCategoria();
                                        String coleccionLibros = cat.getValue().getTitulo();
                                        System.out.println(coleccionLibros + " ---> " + categorias);
                                    } else {
                                        continue;
                                    }
                                }
                                break;
                            case 2:
                                System.out.printf("\nIngrese el nombre del autor: ");
                                autor = s.nextLine().toLowerCase(Locale.ROOT);
                                System.out.println("\nLos libros disponibles de " + "\"" + autor.toUpperCase(Locale.ROOT) + "\"" + " son: ");
                                for (Map.Entry<String, Libro> aut : libros.entrySet()) {
                                    if (aut.getValue().getAutor().toLowerCase(Locale.ROOT).equals(autor)) {
                                        String autores = aut.getValue().getAutor();
                                        String coleccionLibros = aut.getValue().getTitulo();
                                        System.out.println(autores + " ---> " + coleccionLibros);
                                    } else {
                                        continue;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("\nIngrese el titulo de libro: ");
                                tituloLibro = s.nextLine();
                                for (Map.Entry<String, Libro> lib : libros.entrySet()) {
                                    if (lib.getKey().equalsIgnoreCase(tituloLibro)) {
                                        String titulo = lib.getKey();
                                        System.out.println("\n" + lib.getValue().toString() + " está disponible");
                                        break;
                                    } else {
                                        System.out.println("\nEl libro no está disponible ");
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("\n****** LISTA DE LIBROS DISPONIBLES ******");
                                for (Map.Entry<String, Libro> all : libros.entrySet()) {
                                    System.out.println(all.getValue().getIndice() + " ---> " + all.getKey());
                                }
                                break;
                            case 5:
                                salir = true;
                                break;
                        }
                    }
                    break;
            }
        } while (programaActivo);
    }
}

