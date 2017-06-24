package Entidades;
public class Areas {
    
    String IdAreas ;
    String Nombre;
    String Descripcion;
    String Area_Padre;

    public Areas(String IdAreas, String Nombre, String Descripcion, String Area_Padre) {
        this.IdAreas = IdAreas;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Area_Padre = Area_Padre;
    }

    public Areas() {
        
    }

    public String getIdAreas() {
        return IdAreas;
    }

    public void setIdAreas(String IdAreas) {
        this.IdAreas = IdAreas;
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
}