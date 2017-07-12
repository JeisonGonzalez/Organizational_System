package Entidades;
public class Areas {
    
    private String IdArea ;
    private String Nombre;
    private String Descripcion;
    private String Area_Padre;
    private String Nombre_Padre;

    public Areas() {
    }

    public Areas(String IdArea, String Nombre, String Descripcion, String Area_Padre, String Nombre_Padre) {
        this.IdArea = IdArea;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Area_Padre = Area_Padre;
        this.Nombre_Padre = Nombre_Padre;
    }

    public String getIdArea() {
        return IdArea;
    }

    public void setIdArea(String IdArea) {
        this.IdArea = IdArea;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getArea_Padre() {
        return Area_Padre;
    }

    public void setArea_Padre(String Area_Padre) {
        this.Area_Padre = Area_Padre;
    }

    public String getNombre_Padre() {
        return Nombre_Padre;
    }

    public void setNombre_Padre(String Nombre_Padre) {
        this.Nombre_Padre = Nombre_Padre;
    }
    
}