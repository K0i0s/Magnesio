package arboles.trabajadores;

public class Persona {
    public String nombre;
    public String apellidoP;
    public String apellidoM;
    public int edad;
    public String genero;

    public Persona(String nombre, String apellidoP, String apellidoM, int edad, String genero) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
<<<<<<< HEAD
=======
        this.genero = genero;
    } 
>>>>>>> 839a91b690a8145643c2d9bfa43716061591b088
}
