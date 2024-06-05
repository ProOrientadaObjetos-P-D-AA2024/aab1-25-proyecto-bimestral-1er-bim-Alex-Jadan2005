
package vista;

import controlador.escritura;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Factura;
import modelo.Persona;
import modelo.Sueldo;
import modelo.categorias;

public class ej {
    public static void main(String[] args) {
        //
        Scanner scanner = new Scanner(System.in);

        System.out.println("SISTEMA DE DECLARACION DE IMPUESTOS ANUALES");

        System.out.print("Ingrese su sueldo mensual: ");
        double sueldoMensual = scanner.nextDouble();

        Factura[] facturas = new Factura[5];
        String[] nombresGastos = {"Vivienda", "Vestimenta", "Alimentacion", "Salud", "Educacion"};
        for (int i = 0; i < nombresGastos.length; i++) {
            System.out.print("Ingrese el monto de " + nombresGastos[i] + ": ");
            double monto = scanner.nextDouble();
            facturas[i] = new Factura(monto);
        }

        System.out.println("¿Desea ingresar el monto de Turismo?");
        System.out.println("1. Si\t2. No");
        int opcionTurismo = scanner.nextInt();
        if (opcionTurismo == 1) {
            System.out.print("Ingrese el monto de Turismo: ");
            double montoTurismo = scanner.nextDouble();
            facturas[5] = new Factura(montoTurismo);
        }

        Persona persona = new Persona("Nombre", sueldoMensual, facturas);

        guardarDatosPersona(persona);
        leerYCalcularImpuestos();

        scanner.close();
    }
    private static void guardarDatosPersona(Persona persona) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos_persona.txt"))) {
            writer.write(persona.getSueldo() + "\n");
            for (Factura factura : persona.getFacturas()) {
                writer.write(factura.getMonto() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerYCalcularImpuestos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos_persona.txt"))) {
            double sueldo = Double.parseDouble(reader.readLine());
            double[] montos = new double[6];
            for (int i = 0; i < 6; i++) {
                montos[i] = Double.parseDouble(reader.readLine());
            }
            Factura[] facturas = new Factura[5];
            for (int i = 0; i < 5; i++) {
                facturas[i] = new Factura(montos[i]);
            }
            Persona persona = new Persona("Nombre", sueldo, facturas);

            System.out.println("\nIMPUESTOS A LA RENTA 2023");
            for (Factura factura : persona.getFacturas()) {
                System.out.println(factura);
            }
System.out.println("\nTotal de gastos: " + persona.calcularTotalGastos());
            System.out.println("Impuesto a la renta anual: " + persona.calcularImpuestoRentaAnual());
            System.out.println("Total a pagar: " + persona.calcularTotalAPagar());
            System.out.println("Sueldo anual: " + sueldo * 12);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
