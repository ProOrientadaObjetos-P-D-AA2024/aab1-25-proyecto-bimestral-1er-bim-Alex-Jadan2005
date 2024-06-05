
package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.categorias;

public class escritura {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private categorias c;
    private ArrayList<categorias> cate;
    
    public escritura(String nombreArc) {
        nombreArchivo=nombreArc;
        setCate();
        try{
            salida=new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if(getCate().size() >0){
                for(int i=0;i<getCate().size();i++){
                    setC(getCate().get(i));
                    setSalida();
                }
            }
            
            
        }catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } 
        
    }

    public void setNombreArchivo(String m) {
        nombreArchivo=m;
    }

    public void setC(categorias p) {
        c = p;
    }
    
    
    
    public void setSalida() {
        try{
            salida.writeObject(c);
            
        }catch(IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    
    

    public void setCate() {
        lectura l=new lectura(getNombreArchivo());
        l.setCat();
        cate=l.getCat();
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public ArrayList<categorias> getCate() {
        return cate;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
    
    public void cerrarArchivo() {
        try{
            if (salida != null) {
                salida.close();
            }
        }catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } 
    } 
}
