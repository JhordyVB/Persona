package Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Persona {

	private int id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private String dpi;
    private int edad;
    private String ciudad;

    // Constructor
    public Persona(int id, String primerNombre, String segundoNombre, String primerApellido,
                   String segundoApellido, String genero, String dpi, int edad, String ciudad) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.genero = genero;
        this.dpi = dpi;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters
    public int getId() { return id; }
    public String getPrimerNombre() { return primerNombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getPrimerApellido() { return primerApellido; }
    public String getSegundoApellido() { return segundoApellido; }
    public String getGenero() { return genero; }
    public String getDpi() { return dpi; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }

    // Método para obtener el nombre completo
    public String getNombreCompleto() {
        return primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido;
    }

//public class Persona {
    private List<Persona> listaPersonas;

    // Constructor
    public Persona() {
        this.listaPersonas = new ArrayList<>();
    }

    // Método para agregar personas a la lista
    public void agregarPersona(int id, String primerNombre, String segundoNombre,
                               String primerApellido, String segundoApellido,
                               String genero, String dpi, int edad, String ciudad) {
        Persona persona = new Persona(id, primerNombre, segundoNombre, primerApellido,
                                      segundoApellido, genero, dpi, edad, ciudad);
        listaPersonas.add(persona);
    }

    // Método para retornar la lista de personas
    public List<Persona> obtenerListaPersonas() {
        return listaPersonas;
    }

    // Método para imprimir nombres completos usando Streams
    public void imprimirNombresCompletos() {
        listaPersonas.stream()
                     .map(Persona::getNombreCompleto)
                     .forEach(System.out::println);
    }

    // Método para buscar personas mayores de edad usando Streams y Predicados
    public List<Persona> buscarMayoresDeEdad() {
        return listaPersonas.stream()
                            .filter(persona -> persona.getEdad() >= 18)
                            .collect(Collectors.toList());
    }

    // Método para buscar la primera persona que cumpla con las condiciones usando Optional
    public Optional<Persona> buscarPrimeraPersona() {
        return listaPersonas.stream()
                            .filter(persona -> persona.getEdad() >= 18
                                            && persona.getCiudad().equalsIgnoreCase("Guatemala")
                                            && persona.getPrimerNombre().contains("Lu"))
                            .findFirst();
    }

    public static void main(String[] args) {
        Persona app = new Persona();
        Scanner scanner = new Scanner(System.in);

        // Llenar la lista de personas
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese los datos de la persona " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Primer Nombre: ");
            String primerNombre = scanner.next();
            System.out.print("Segundo Nombre: ");
            String segundoNombre = scanner.next();
            System.out.print("Primer Apellido: ");
            String primerApellido = scanner.next();
            System.out.print("Segundo Apellido: ");
            String segundoApellido = scanner.next();
            System.out.print("Género: ");
            String genero = scanner.next();
            System.out.print("DPI: ");
            String dpi = scanner.next();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            System.out.print("Ciudad: ");
            String ciudad = scanner.next();
            app.agregarPersona(id, primerNombre, segundoNombre, primerApellido,
                               segundoApellido, genero, dpi, edad, ciudad);
        }

        System.out.println("\nNombres completos:");
        app.imprimirNombresCompletos();

        System.out.println("\nPersonas mayores de edad:");
        app.buscarMayoresDeEdad().forEach(persona -> System.out.println(persona.getNombreCompleto()));

        Optional<Persona> persona = app.buscarPrimeraPersona();
        if (persona.isPresent()) {
            System.out.println("\nPrimera persona encontrada que cumple con las condiciones: " +
                               persona.get().getNombreCompleto());
        } else {
            System.out.println("\nNo se encontró ninguna persona que cumpla con las condiciones.");
        }

        scanner.close();
    }
}
