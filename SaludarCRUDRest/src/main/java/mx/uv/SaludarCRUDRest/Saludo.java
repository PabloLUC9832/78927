package mx.uv.SaludarCRUDRest;

public class Saludo {

    private int id;
    private String nombre;

    public Saludo(){
        
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
