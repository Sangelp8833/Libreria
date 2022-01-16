import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaContactos {
    public static void main(String[] args) {

        // Añadir contactos, Listar contactos
        // Buscar contactos, Existe contacto
        // Eliminar conctao, salir

        Scanner s = new Scanner(System.in);
        boolean Salir = false;
        int instruccion = 0;
        String nombre = null;
        String telefono = null;
        String Buscado = null;
        String eliminar = null;
        Map<String, String> contacto = new HashMap<>();


        System.out.println("\n******* Bienvenido a su agenda telefonica ******");

        while(!Salir){
            System.out.println("\n1. Añadir contacto" +
                    "\n2. Listar contactos" +
                    "\n3. Buscar contacto" +
                    "\n4. Eliminar contacto" +
                    "\n5. Salir");
            instruccion = s.nextInt();
            s.nextLine();
            switch (instruccion){
                case 1:
                    System.out.printf("Ingrese el nombre: ");;
                    nombre = s.nextLine();
                    if(contacto.containsKey(nombre)){
                        System.out.println("El contacto ya existe" + "\n .... Volviendo al menu principal ....");
                        break;
                    } else {
                        System.out.printf("Ingrese el telefono: ");
                        telefono = s.nextLine();
                        contacto.put(nombre, telefono);
                        System.out.println("..... Contacto añadido .....");
                        break;
                    }
                case 2:
                    System.out.println("\n------ LISTADO CONTACTO ------");
                    for(Map.Entry<String,String> contactos: contacto.entrySet()){
                        String nombreContacto = contactos.getKey();
                        String numeroContacto = contactos.getValue();
                        System.out.println("Nombre: " + nombreContacto + " --> Telefono: " + contactos.getValue());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del contacto: ");
                    Buscado = s.nextLine();
                    if (contacto.containsKey(Buscado)){
                        System.out.println("Información del contacto");
                        System.out.println("Nombre: " + Buscado + " --> Telefono: " + contacto.get(Buscado));
                    } else{
                        System.out.println("El contacto no existe en la lista, marque (1) en el menù principal si desea agregar un nuevo contacto");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del contacto que desea eliminar: ");
                    eliminar = s.nextLine();
                    if (contacto.containsKey(eliminar)){
                        contacto.remove(eliminar);
                        System.out.println("..... El contacto se ha eliminado ......");
                    }else{
                        System.out.println("El contacto no existe. Porfavor verifique el nombre y vuela a intentar. ");
                    }
                    break;
                case 5:
                    Salir = true;
                    break;
            }

        }

    }
}
