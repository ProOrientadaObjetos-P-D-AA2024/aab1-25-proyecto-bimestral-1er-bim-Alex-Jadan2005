
package controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import modelo.categorias;

public class lectura {
    private ObjectInputStream entrada;
    private ArrayList<categorias> cat;
    private String nombreArchivo;
    
    public lectura(String n){
        nombreArchivo=n;
        File f=new File(nombreArchivo);
        if(f.exists()){
            try{
                entrada=new ObjectInputStream(new FileInputStream(n));
            }catch(IOException ioException){
                System.out.println("Error al abrir el archvio: "+ioException);
            }
            
        }
        
    }

    public void setNombreArchivo(String n) {
        nombreArchivo=n;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
    
    public void setCat() {
        cat=new ArrayList<>();
        File f=new File(getNombreArchivo());
        if(f.exists()){
            while(true){
                try{
                    categorias c=(categorias) entrada.readObject();
                    cat.add(c);
                }catch(EOFException endOfFileException){
                    return;
                    
                }catch(IOException ex){
                    System.err.println("Error al leer el archivo: " + ex);
                }catch(ClassNotFoundException  ex){
                    System.err.println("No se pudo crear el objeto: " + ex);
                }catch(Exception ex){
                    System.err.println("No hay datos en el archivo: " + ex);
                }
            }
        }
        
    }

    public ArrayList<categorias> getCat() {
        return cat;
    }
    
    public void cerrarArchivo(){
        try{
            if(entrada!=null){
                entrada.close();
            }
            System.exit(0);
        }catch(IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
    
    
    
    
}
