package modelo;

import java.io.Serializable;

public class categorias implements Serializable {
    private String cat;
    private double gastos;

    public categorias(String cat, double gastos) {
        this.cat = cat;
        this.gastos = gastos;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(int gastos) {
        this.gastos = gastos;
    }
    
    
    
}
