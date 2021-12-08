package arboles.baseArboles;

public class NodoArbol{ 

    public int dato; 
    protected NodoArbol izq;
    protected NodoArbol der; 

    public NodoArbol(int valor) {
        this.dato = valor;
        this.izq = null;
        this.der = null;
    } 

    public NodoArbol(NodoArbol ramaIzdo, int valor, NodoArbol ramaDcho) { 
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

    public void nuevoValor(int valor) { 
        this.dato = valor; 
    } 

    public void ramaIzdo(NodoArbol izq) { 
        this.izq = izq; 
    } 

    public void ramaDcho(NodoArbol der) { 
        this.der = der; 
    }

    
    public Object getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    void visitar(){
        System.out.print(getDato() + " ");
    }
} 