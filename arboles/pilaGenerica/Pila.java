package arboles.pilaGenerica;

public class Pila{
    public NodoPila cima;

    public Pila() {
        this.cima = null;
    }

    public void push(Object data) {
        NodoPila nodo = new NodoPila(data);
        nodo.setNodo(cima);
        cima=nodo;
    }

    public Object pop() throws Exception{
        if (esVacia()){
            throw new Exception("La pila esta vacía");
        }
        Object valorCima = this.cima.getData();
        this.cima = this.cima.getNodo();
        return valorCima;
    }

    public boolean esVacia(){
        return cima == null ? true : false;
    }

    /**
     * Método mostrar el contenido
     */
    public void peek(){
        NodoPila tempCima = this.cima;
        while(tempCima != null){
            System.out.println(tempCima.getData());
            tempCima = tempCima.getNodo();
        }
        System.out.println("Fin de la pila");
    }
}
