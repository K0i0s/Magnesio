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
    
    public void modificarRegistro(ArbolBinario arbol) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int op = 1;
        int id=0;
        boolean idIntroducida = false;
        boolean salir;
        String nombre;
        String apellidoP;
        String apellidoM;
        int edad = 0;
        String genero;
        double sueldo = 0;
        boolean esNum = false;
        String puesto;
        Trabajador aux;

        while(idIntroducida == false){
            try{
                System.out.println("\nID del Trabajador que desee modificar:");
                id = Integer.parseInt(lector.readLine());
                idIntroducida = true;
            } catch (NumberFormatException e) {
                    System.out.println("\nEntrada no válida..."); // Se imprime este mensaje indicando el error
                }
        }

        aux = arbol.buscarNodo(id).getDato();

        if(arbol.buscarNodo(id) != null){
            while (op > 0) {
                salir = false;
                while (salir == false) {
                    try {// try para verificar que el valor de op sea válido.
                        System.out.println("\n1. Modificar Nombre(s).");
                        System.out.println("2. Modificar Apellido Paterno.");
                        System.out.println("3. Modificar Apellido Materno.");
                        System.out.println("4. Modificar Edad.");
                        System.out.println("5. Modificar Género.");
                        System.out.println("6. Modificar Puesto.");
                        System.out.println("7. Modificar Sueldo.");
                        System.out.println("0. Regresar al Menú Principal.");
    
                        System.out.println("\nOpción:");
                        op = Integer.parseInt(lector.readLine()); // Se pide el número de la acción
                        salir = true;
                    } catch (NumberFormatException e) {
                        System.out.println("\nEntrada no válida..."); // Se imprime este mensaje indicando el error
                        op = 8;
                    }
    
                    switch (op) {
                    case 1:
                        System.out.println("\nNombre(s): ");
                        nombre = lector.readLine();
                        aux.setNombre(nombre);
                        break;
    
                    case 2:
                        System.out.println("\nApellido Paterno: ");
                        apellidoP = lector.readLine();
                        aux.setApellidoP(apellidoP);
                        break;
    
                    case 3:
                        System.out.println("\nApellido Materno: ");
                        apellidoM = lector.readLine();
                        aux.setApellidoM(apellidoM);
                        break;
    
                    case 4:
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
                        aux.setEdad(edad);
                        break;
    
                    case 5:
                        System.out.println("\nGénero: ");
                        genero = lector.readLine();
                        aux.setGenero(genero);
                        break;
    
                    case 6:
                        System.out.println("\nPuesto: ");
                        puesto = lector.readLine();
                        aux.setPuesto(puesto);
                        break;
                    
                    case 7:
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
                        aux.setSueldo(sueldo);
                        break;
    
                    default:
                        salir = true;
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("No se encontró esa ID. Regresando al Menú Principal...");
        }
    }

    public static void menu() throws NumberFormatException, IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int op = 1;
        boolean salir;
        ArbolBinario arbol = new ArbolBinario();

        // Se regresa al menú siempre y cuando op no sea 0
        while (op > 0) {
            salir = false;
            while (salir == false) {
                try {// try para verificar que el valor de op sea válido.
                    System.out.println("\n\t MENÚ REGISTRO EMPLEADOS\n"); // Se muestran las opciones del menú al
                                                                          // usuario
                    System.out.println("1. Agregar registro.");
                    System.out.println("2. Eliminar registro.");
                    System.out.println("3. Modificar registro.");
                    System.out.println("4. Consultar por preorden.");
                    System.out.println("5. Consultar por inorden.");
                    System.out.println("6. Consultar por postorden.");
                    System.out.println("0. Salir.");

                    System.out.println("\nOpción:");
                    op = Integer.parseInt(lector.readLine()); // Se pide el número de la acción
                    salir = true;
                } catch (NumberFormatException e) {
                    System.out.println("\nEntrada no válida..."); // Se imprime este mensaje indicando el error
                    op = 7;
                }

                switch (op) {
                case 1:
                    System.out.println("\n\t AGREGAR TRABAJADOR\n");
                    break;

                case 2:
                    System.out.println("\n\t ELIMINAR TRABAJADOR\n");
                    break;

                case 3:
                    System.out.println("\n\t MODIFICAR REGISTRO");
                    break;

                case 4:
                    System.out.println("\n\t CONSULTA DE REGISTRO EN PREORDEN\n");
                    break;

                case 5:
                    System.out.println("\n\t CONSULTA DE REGISTRO EN INORDEN\n");
                    break;

                case 6:
                    System.out.println("\n\t CONSULTA DE REGISTRO EN POSTORDEN\n");
                    break;

                default:
                    salir = true;
                    break;
                }
            }
        }
    }
} 
