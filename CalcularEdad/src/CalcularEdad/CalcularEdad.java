package CalcularEdad;


import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalcularEdad {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su fecha de nacimiento (formato: YYYY-MM-DD):");
        String fechaNacimientoInput = scanner.nextLine();

        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoInput);
        LocalDate fechaActual = LocalDate.now();

        int edad = Period.between(fechaNacimiento, fechaActual).getYears();

        System.out.println("Su edad es: " + edad + " años.");

        scanner.close();
        
	}

}
