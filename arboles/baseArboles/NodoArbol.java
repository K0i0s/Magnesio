package arboles.baseArboles;

import arboles.trabajadores.Trabajador;

public class NodoArbol{ 
public Trabajador dato; 
    protected NodoArbol izq;
    protected NodoArbol der; 

    public NodoArbol(Trabajador valor) {
        this.dato = valor;
        this.izq = null;
        this.der = null;
    } 

    public NodoArbol(NodoArbol ramaIzdo, Trabajador valor, NodoArbol ramaDcho) { 
        dato = valor; 
        izq = ramaIzdo; 
        der = ramaDcho; 
    } 

    public Object valorNodo() { 
        return dato; 
    } 

    public NodoArbol subarbolIzdo() { 
        return izq; 
    } 

    public NodoArbol subarbolDecho() { 
        return der; 
    } 

    public void nuevoValor(Trabajador valor) { 
        this.dato = valor; 
    } 

    public void ramaIzdo(NodoArbol izq) { 
        this.izq = izq; 
    } 

    public void ramaDcho(NodoArbol der) { 
        this.der = der; 
    }
    
    public Trabajador getDato() {
        return dato;
    }

    public void setDato(Trabajador dato) {
        this.dato = dato;
    }
   
} 
