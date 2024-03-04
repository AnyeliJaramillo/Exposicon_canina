package taller4;




/**
 *
 * @author 54Y1
 */
public class Perros {
   
/**
 * @authors Maria Vallejo, Anyeli Jaramillo
 */

     //Atributos
    private String nombrePerro;
    private int edadMeses;
    private String raza;
    private int puntaje;
    private String foto;

    public Perros() {
    }

    public Perros(String nombrePerro, int edadMeses, String raza, int puntaje, String foto) {
        this.nombrePerro = nombrePerro;
        this.edadMeses = edadMeses;
        this.raza = raza;
        this.puntaje = puntaje;
        this.foto = foto;
    }

    public String getNombrePerros() {
        return nombrePerro;
    }

    public void setNombrePerros(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        this.edadMeses = edadMeses;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
   
    
    
}
    


