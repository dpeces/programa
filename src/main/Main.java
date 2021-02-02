package main;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Utilbbdd utilbbdd = new Utilbbdd();
        try {
            String id = args[0];
            char cliente = id.charAt(0);
            if (Character.isDigit(cliente)) {
                utilbbdd.getProveedores(id);
            } else {
                error();
            }
        } catch (Exception e) {
            error();
        }
    }

    public static void error() {
        System.out.println("Introduzca un código de cliente correcto.");
    }

    public static void sinClientes() {
        System.out.println("Introduzca un código de cliente correcto.");
    }
}
