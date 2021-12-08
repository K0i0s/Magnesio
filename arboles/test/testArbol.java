package arboles.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arboles.baseArboles.ArbolBinario;
import arboles.baseArboles.NodoArbol;

public class testArbol {
    public static void main(String[] args) throws IOException, NumberFormatException{
        int a;
        int x = 1;
        boolean continuar = true;
        ArbolBinario arbol;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nIntroduzca la raíz del árbol:");
        a = Integer.parseInt(lector.readLine());
        arbol = new ArbolBinario(new NodoArbol(a));
        
        while (continuar == true) {
            System.out.println("\nSi desea agregar otro valor presione 1:");
            x = Integer.parseInt(lector.readLine());
            if(x == 1){
                continuar=true;
            }
            else{
                continuar=false;
            }
            if(continuar==true){
                System.out.println("\nIntroduzca el valor a agregar:");
                x = Integer.parseInt(lector.readLine());
                arbol.agregarNodo(x);
            }
        }
        
        System.out.println("\nIntroduzca el nodo a buscar:");
        int i = Integer.parseInt(lector.readLine());
        if (arbol.buscarNodo(i) != null) {
            System.out.println("\nSe encontró el nodo con valor de "+ i +".");
        } else {
            System.out.println("\nNo se encontró el nodo con valor de "+ i +".");
        }

        System.out.println("\nPreorden del árbol:");
        ArbolBinario.preorden(arbol.raiz);

        System.out.println("\nInorden del árbol:");
        ArbolBinario.inorden(arbol.raiz);

        System.out.println("\nPostorden del árbol:");
        ArbolBinario.postorden(arbol.raiz);
        //pir ddsfdsfdsfsdfsdfsdf
        System.out.println("Estructuras ");
    }
    
}
