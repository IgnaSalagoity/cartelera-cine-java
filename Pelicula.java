public class Pelicula {
    
    //VARIABLES.
    private String nombre;
    private int fecha;
    private String status;

    public Pelicula(String n, int a, String s) {
       
        this.nombre = n;
        this.fecha = a;
        this.status = s;
    
    }

    //------------------------GETTERS------------------------

    //GETTER DEL NOMBRE.
    public String getNombre() {
        
        return nombre;
    
    }

    //GETTER DEL AÑO.
    public int getFecha() {
        
        return fecha;
    
    }

    //GETTER DEL STATUS.
    public String getStatus() {
        
        return status;
    
    }

    //------------------------SETTERS------------------------

    //SETTER DEL NOMBRE.
    public void setNombre(String n) {
        
        this.nombre = n;
    
    }

    //SETTER DEL AÑO.
    public void setFecha(int a) {
        
        this.fecha = a;
    
    }

    //SETTER DEL STATUS.
    public void setStatus(String s) {
        
        this.status = s;
    
    }

    //------------------------OVERRITE------------------------

    @Override
    public String toString() {
        
        return "Nombre [" + nombre + "], Fecha [" + fecha + "], Status [" + status + "]";
    
    } //CIERRE DEL OVERRITE.

} //CIERRE DE LA CLASE PELICULA.