import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a tu agenda");
        int tamanioEntrada;
        System.out.println("Ingresa el tamaño de tu agenda");
        Agenda agenda;
        while(true){
            try{
                tamanioEntrada = sc.nextInt();
                sc.nextLine();
                agenda = new Agenda(tamanioEntrada);
                break;
            }catch (InputMismatchException e){
                System.out.println("Por favor ingrese un número");
                sc.nextLine();
            }
        }

        int opcion = 0;
        while (opcion != 8){
            menuOpciones();
            try{
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1:{
                        System.out.println("Por favor ingrese el nombre del nuevo contacto");
                        String nombre = sc.nextLine();
                        System.out.println("Por favor ingrese el número del nuevo contacto");
                        Long numero = sc.nextLong();
                        if(agenda.aniadirContacto(new Contacto(nombre,numero))){
                            System.out.println("Contacto añadido con exito");
                        }else{
                            System.out.println("El usuario ya existe o la agenda esta llena, intente de nuevo");
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("Por favor ingrese el nombre del contacto a validar");
                        String nombre = sc.nextLine();
                        System.out.println("Por favor ingrese el número del contacto a validar");
                        Long numero = sc.nextLong();
                        if(agenda.existeContacto(new Contacto(nombre, numero))){
                            System.out.println("El contacto si existe");
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        break;
                    }

                    case 3:{
                        agenda.listarContacto();
                        break;
                    }

                    case 4:{
                        System.out.println("Por favor ingrese el nombre del contacto buscado");
                        String nombre = sc.nextLine();
                        try{
                            Contacto nuevoContacto = agenda.buscaContacto(nombre);
                            System.out.println("El número del contacto " + nuevoContacto.getNombre() + " es " + nuevoContacto.getNumero());
                        }catch(MyException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("Por favor ingrese el nombre del contacto a eliminar");
                        String nombre = sc.nextLine();
                        try{
                            Contacto contactoEliminar = agenda.buscaContacto(nombre);
                            agenda.eliminarContacto(contactoEliminar);
                            System.out.println("El contacto fue eliminado con exito");

                        }catch(MyException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }

                    case 6:{
                        if(agenda.agendaLlena()){
                            System.out.println("Su agenda esta llena");
                        }else{
                            System.out.println("Su agenda no esta llena");
                        }
                        break;
                    }

                    case 7:{
                        System.out.println("Los espacios disponibles en su agenda son " + agenda.espacioLibres());
                        break;
                    }

                    case 8:{
                        System.out.println("Usted salió de su agenda \nMuchas gracias");
                        break;
                    }

                    default: {
                        System.out.println("Por favor ingrese una opción valida del menu");

                    }
                }
                System.out.println("\n");

            }catch(InputMismatchException e){
                System.out.println("Por favor ingrese un número");
                sc.nextLine();
            }
        }





    }

    public static void menuOpciones(){
        System.out.println("Ingresa el número de la opción que deseas \n1.Añadir contacto \n2.Ver si un contacto existe\n3.Ver contactos en la agenda\n4.Buscar un contacto\n5.Eliminar un contacto\n6.Mira si tu agenda esta llena\n7.Ver espacios disponibles en tu agenda\n8.Salir");
    }
}