package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario

            Agenda agendaTelefonica = new Agenda(17);//tamaño de contacto
            String nombre;
            int telefono;

            Contacto c;
        System.out.println(" ");
        System.out.println(" ╭━┻━┻╮");
        System.out.println(" ┃╭╮╭╮┃");
        System.out.println("╭┫▕▎▕▎┣╮");
        System.out.println("╰┓┳╰╯┳┏╯ For You");
        System.out.println("╭┛╰━━╯┗━━━╮");
        System.out.println("┃┃    ┏━╭╰╯╮");
        System.out.println("┃┃    ┃┏┻━━┻┓");
        System.out.println("╰┫ ╭╮ ┃┃JAVA┃");
        System.out.println(" ┃ ┃┃ ┃╰━━━━╯");
        System.out.println(" ");

            while (!salir) {
                System.out.println("---------------------------------");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Listar contactos");
                System.out.println("3. Buscar contacto");
                System.out.println("4. Existe contacto");
                System.out.println("5. Eliminar contacto");
                System.out.println("6. Contactos disponibles");
                System.out.println("7. Agenda llena");
                System.out.println("8. Salir");
                System.out.println("---------------------------------");
                try {
                    System.out.println("---------------------------------");
                    System.out.println("Escribe una de las opciones");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:

                            //Pido valores

                            System.out.println("Escribe un nombre:");
                            nombre = sn.next();

                            System.out.println("Escribe un telefono:");
                            telefono = sn.nextInt();
                            System.out.println("---------------------------------");

                            //Creo el contacto
                            c = new Contacto(nombre, telefono);

                            agendaTelefonica.aniadirContacto(c);

                            break;
                        case 2:

                            agendaTelefonica.listarContactos();

                            break;
                        case 3:

                            //pido el nombre
                            System.out.println("---------------------------------");
                            System.out.println("Escribe un nombre:");
                            nombre = sn.next();
                            System.out.println("---------------------------------");

                            agendaTelefonica.buscarPorNombre(nombre);

                            break;
                        case 4:

                            //pido el nombre
                            System.out.println("---------------------------------");
                            System.out.println("Escribe un nombre");
                            nombre = sn.next();


                            //Creo el contacto auxiliar
                            c = new Contacto(nombre, 0);

                            if (agendaTelefonica.existeContacto(c)) {

                                System.out.println("Existe contacto");
                            } else {
                                System.out.println("No existe contacto");
                                System.out.println("---------------------------------");
                            }

                            break;
                        case 5:

                            //pido el nombre
                            System.out.println("---------------------------------");
                            System.out.println("Escribe un nombre");
                            nombre = sn.next();
                            System.out.println("---------------------------------");

                            //Creo el contacto auxiliar
                            c = new Contacto(nombre, 0);

                            agendaTelefonica.eliminarContacto(c);

                            break;
                        case 6:

                            System.out.println("Hay " + agendaTelefonica.huecosLibre() + " contactos libre");

                            break;
                        case 7:

                            //como devuelve un booleano, lo meto en un if
                            if (agendaTelefonica.agendaLlena()) {
                                System.out.println("La agenda esta llena");
                            } else {
                                System.out.println("Aun puedes meter contactoss");
                            }

                            break;
                        case 8:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 8");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sn.next();
                }

            }

        }


    }

