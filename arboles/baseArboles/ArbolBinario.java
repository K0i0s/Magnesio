package arboles.baseArboles;

public class ArbolBinario{
    public NodoArbol raiz;
     
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

    public static NodoArbol nuevoArbol(NodoArbol ramaIzdo, int valor, NodoArbol ramaDcho){ 
        return new NodoArbol(ramaIzdo, valor, ramaDcho); 
    }

    public NodoArbol buscarNodo(int d){
        NodoArbol aux = raiz;
        while ((Integer)aux.dato != d) {
            if(d < (Integer)aux.dato){
                aux = aux.izq;
            }
            else{
                aux = aux.der;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }

    public static void preorden(NodoArbol r){
        if (r != null) {
            r.visitar();
            preorden(r.subarbolIzdo());
            preorden(r.subarbolDecho());
        }
    }

    public static void inorden(NodoArbol r){
        if (r != null) {
            inorden(r.subarbolIzdo());
            r.visitar();
            inorden(r.subarbolDecho());
        }
    }

    public static void postorden(NodoArbol r){
        if (r != null) {
            postorden(r.subarbolIzdo());
            postorden(r.subarbolDecho());
            r.visitar();
        }
    }

    public boolean menorQue(int q) {
        NodoArbol aux = raiz;
        if((Integer)aux.dato < q)
            return true;
        else{
            return false;
        }
    }


    public boolean mayorQue(int q) {
        NodoArbol aux = raiz;
        if((Integer)aux.dato > q)
            return true;
        else{
            return false;
        }
    }
    
    public void agregarNodo(int num){
        NodoArbol nuevo = new NodoArbol(num);
        if (buscarNodo(num) != null){
            System.out.println("Ese nodo ya existe.");
        }
        else{
            if(raiz == null){
                raiz = nuevo;
            }
            else{
                NodoArbol aux = raiz;
                NodoArbol padre;
                while(true){
                    padre = aux;
                    if((Integer)num < (Integer)aux.dato){
                        aux = aux.izq;
                        if (aux == null) {
                            padre.izq = nuevo;
                            System.out.println("Se ha agregado exitosamente.");
                            return;
                        }
                    }
                    else{
                        aux = aux.der;
                        if(aux == null){
                            padre.der = nuevo;
                            System.out.println("Se ha agregado exitosamente.");
                            return;
                        }
                    }
                }
            }
        }
    }
} 
