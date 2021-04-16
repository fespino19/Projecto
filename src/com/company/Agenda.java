package com.company;

public class Agenda {




    //Atributos
    private Contacto[] contactos;

    //Constructores
    public Agenda() {
        this.contactos = new Contacto[10]; //por defecto
    }

    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio]; //tamaño que nosotros queramos
    }

    //Metodos
    /**
     * Añade un contacto a la agenda
     *
     * @param
     */
    public void aniadirContacto(Contacto c) {

        if (existeContacto(c)) { //Indico si existe el contacto
            System.out.println(" ");
            System.out.println("###########################################################");
            System.out.println("El contacto con ese nombre ya existe");
            System.out.println("###########################################################");
            System.out.println(" ");

        } else if (agendaLlena()) { //Indico si la agenda esta o no llena
            System.out.println(" ");
            System.out.println("########################################################");
            System.out.println("La agenda esta llena, no se pueden meter mas contactos");
            System.out.println("########################################################");
            System.out.println(" ");
        } else {

            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) { //controlo los nulos
                    contactos[i] = c; //Inserto el contacto
                    encontrado = true; //Indico que lo he encontrado
                }
            }

            if (encontrado) {
                System.out.println(" ");
                System.out.println("#############");
                System.out.println("Se ha añadido");
                System.out.println("#############");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("##########################");
                System.out.println("No se ha podido añadir");
                System.out.println("##########################");
                System.out.println(" ");
            }
        }

    }

    /**
     * Indica si existe un contacto
     *
     * @param
     * @return
     */
    public boolean existeContacto(Contacto c) {

        for (int i = 0; i < contactos.length; i++) {
            //Controlo nulos e indico si el contacto es el mismo
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }
        }
        return false;

    }

    /**
     * Lista los contactos de la agenda
     */
    public void listarContactos() {

        if (huecosLibre() == contactos.length) {
            System.out.println(" ");
            System.out.println("###########################################################");
            System.out.println("No hay contactos que mostrar");
            System.out.println("###########################################################");
            System.out.println(" ");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) { //Controlo nulos
                    System.out.println(" ");
                    System.out.println("################## Lista de Contactos #####################");
                    System.out.println(contactos[i]);
                    System.out.println("###########################################################");
                    System.out.println(" ");
                }
            }
        }

    }

    /**
     * Busca un contacto por su nombre
     *
     * @param
     */
    public void buscarPorNombre(String nombre) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {

            //Controlo nulos y compruebo que es el contacto buscado (forma mas engorrosa)

            if (contactos[i] != null && contactos[i].getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                System.out.println("");
                System.out.println("Su telefono es " + contactos[i].getTelefono()); //muestro el telefono
                System.out.println("");
                encontrado = true; //Indico que lo he encontrado
            }
        }

        if (!encontrado) {
            System.out.println(" ");
            System.out.println("###########################################################");
            System.out.println("No se ha encontrado el contacto");
            System.out.println("###########################################################");
            System.out.println(" ");

        }

    }

    /**
     * Indica si la agenda esta llena o no
     *
     * @return
     */
    public boolean agendaLlena() {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { //Controlo nulos
                return false; //indico que no esta llena
            }
        }

        return true; //esta llena

    }

    /**
     * Elimina el contacto de la agenda
     *
     * @param
     */
    public void eliminarContacto(Contacto c) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null; //Controlo nulos
                encontrado = true; //Indico que lo he encontrado
            }
        }

        if (encontrado) {
            System.out.println(" ");
            System.out.println("###########################################################");
            System.out.println("Se ha eliminado el contacto");
            System.out.println("###########################################################");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("###########################################################");
            System.out.println("No se ha eliminado el contacto");
            System.out.println("###########################################################");
            System.out.println(" ");

        }

    }

    /**
     * Indica cuantos contactos más podemos meter
     *
     * @return
     */
    public int huecosLibre() {

        int contadorLibres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { //Controlo nulos
                contadorLibres++; //Acumulo
            }
        }

        return contadorLibres;

    }
}
