package burbujas;

public class Trabajador extends Persona{
    public int id;
    public int orden;
    public double sueldo;
    public String puesto;

    public Trabajador(String nombre, String apellidoP, String apellidoM, int edad, String genero, int id, int orden, double sueldo, String puesto) {
        super(nombre, apellidoP, apellidoM, edad, genero);
        this.id = id;
        this.orden = orden;
        this.sueldo = sueldo;
        this.puesto = puesto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void mostrarDatos(){
        System.out.println("--------------------------------------------------------");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre completo: " + this.nombre + " " + this.apellidoP + " " + this.apellidoM);
        System.out.println("Edad: " + this.edad);
        System.out.println("Género: " + this.genero);
        System.out.println("Puesto: " + this.puesto);
        System.out.println("Sueldo: $" + this.sueldo);
        System.out.println("--------------------------------------------------------");
    }
}
