package arboles.baseArboles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arboles.trabajadores.Trabajador;

public class ArbolBinario{
    
    public NodoArbol raiz;
    private static int nElementos = 0;
    
    public ArbolBinario(){ 
        raiz = null; 
    } 

    public ArbolBinario(NodoArbol raiz){ 
        this.raiz = raiz; 
    } 

    public NodoArbol raizArbol(){ 
        return raiz; 
    } 

    boolean esVacio(){ 
        return raiz == null; 
    } 

    public static NodoArbol nuevoArbol(NodoArbol ramaIzdo, Trabajador valor, NodoArbol ramaDcho){ 
        return new NodoArbol(ramaIzdo, valor, ramaDcho); 
    }

    public NodoArbol buscarNodo(int d){
        NodoArbol aux = raiz;
        if(aux == null){
            return null;
        }
        else{
            while (aux != null && aux.dato.id != d) {
                if(d < aux.dato.id){
                    aux = aux.izq;
                }
                else{
                    aux = aux.der;
                }
            }
        }
        return aux;
    }
    public static void preorden(NodoArbol r){
        if (r != null) {
            r.dato.mostrarDatos();
            preorden(r.subarbolIzdo());
            preorden(r.subarbolDecho());
        }
        else if(nElementos == 0){
            System.out.println("\n\t No hay registros...\n");
        }
    }

    public static void inorden(NodoArbol r){
        if (r != null) {
            inorden(r.subarbolIzdo());
            r.dato.mostrarDatos();
            inorden(r.subarbolDecho());
        }
        else if(nElementos == 0){
            System.out.println("\n\t No hay registros...\n");
        }
    }

    public static void postorden(NodoArbol r){
        if (r != null) {
            postorden(r.subarbolIzdo());
            postorden(r.subarbolDecho());
            r.dato.mostrarDatos();
        }
        else if(nElementos == 0){
            System.out.println("\n\t No hay registros...\n");
        }
    }

    public void agregarNodo(Trabajador num){
        NodoArbol nuevo = new NodoArbol(num);
        if(raiz == null){
            raiz = nuevo;
        }
        else{
            NodoArbol aux = raiz;
            NodoArbol padre;
            while(true){
                padre = aux;
                if(num.id < aux.dato.id){
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nuevo;
                        System.out.println("Se ha agregado exitosamente.");
                        nElementos++;
                        return;
                    }
                }
                else{
                    aux = aux.der;
                    if(aux == null){
                        padre.der = nuevo;
                        System.out.println("Se ha agregado exitosamente.");
                        nElementos++;
                        return;
                    }
                }
            }
        }        
    }

    public int contador() {
        return nElementos;
    }
    public void agregarRegistro(ArbolBinario arbol) throws IOException {
        if (contador() <= 8999) {
            nElementos++;
            arbol.agregarNodo(arbol.pedirDatos());
        }
        else {
            System.out.println("Capacidad llena...");
        }
    }

    public Trabajador pedirDatos() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        String apellidoP;
        String apellidoM;
        int edad = 0;
        String genero;
        int id = 0;
        double sueldo = 0;
        String puesto;
        boolean esNum;
        esNum = false;
        id = (int) (Math.random() * 9000 + 1000);
        while (buscarNodo(id) != null) {
            id = (int) (Math.random() * 1000 + 1);
        }
        System.out.println("La ID es: " + id);

        System.out.println("\nNombre: ");
        nombre = lector.readLine();

        System.out.println("\nApellido Paterno: ");
        apellidoP = lector.readLine();

        System.out.println("\nApellido Materno: ");
        apellidoM = lector.readLine();

        esNum = false;
        while (esNum == false) {
            try {
                System.out.println("\nEdad: ");
                edad = Integer.parseInt(lector.readLine());
                esNum = true;
            } catch (NumberFormatException e) {
                System.out.println("\nEntrada no válida...");
                esNum = false;
            }
        }

        System.out.println("\nGénero: ");
        genero = lector.readLine();

        System.out.println("\nPuesto: ");
        puesto = lector.readLine();

        esNum = false;
        while (esNum == false) {
            try {
                System.out.println("\nSueldo: ");
                sueldo = Double.parseDouble(lector.readLine());
                esNum = true;
            } catch (NumberFormatException e) {
                System.out.println("\nEntrada no válida...");
                esNum = false;
            }
        }

        Trabajador aux = new Trabajador(nombre, apellidoP, apellidoM, edad, genero, id, sueldo, puesto);
        return aux;
    }
} 
