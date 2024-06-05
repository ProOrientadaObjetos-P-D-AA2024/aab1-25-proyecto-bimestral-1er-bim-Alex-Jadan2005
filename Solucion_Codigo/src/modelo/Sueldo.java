
package modelo;

import java.io.Serializable;

public class Sueldo implements Serializable{
    private double sueldo;

    public Sueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        sueldo=sueldo*12;
    }
    
    
}
