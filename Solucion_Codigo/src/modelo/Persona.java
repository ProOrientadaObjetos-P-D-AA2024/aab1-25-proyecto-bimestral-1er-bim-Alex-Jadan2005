
package modelo;
public class Persona {
    private String nombre;
    private double sueldo;
    private Factura[] facturas;

    public Persona(String nombre, double sueldo, Factura[] facturas) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.facturas = facturas;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Factura[] getFacturas() {
        return facturas;
    }

    public double calcularTotalGastos() {
        double total = 0;
        for (Factura factura : facturas) {
            total += factura.getMonto();
        }
        return total;
    }

    public double calcularImpuestoRentaAnual() {
        double sueldoAnual = sueldo * 12;
        double totalGastos = calcularTotalGastos();
        double impuestoRentaAnual = sueldoAnual - totalGastos;
        return Math.max(0, impuestoRentaAnual);
    }
    
    public double calcularTotalAPagar() {
        return sueldo * 12 - calcularImpuestoRentaAnual();
    }
}

    
}
