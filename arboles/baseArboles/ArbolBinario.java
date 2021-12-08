package arboles.baseArboles;

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

} 
