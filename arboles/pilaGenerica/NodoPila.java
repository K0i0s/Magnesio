package arboles.pilaGenerica;

public class NodoPila {
    private NodoPila nodo;
    private Object data;

    public NodoPila() {
        this.nodo = null;
        this.data = 0;
    }

    public NodoPila(Object data2){
        this.nodo = null;
        this.data = data2;
    }

    public NodoPila getNodo() {
        return nodo;
    }

    public void setNodo(NodoPila nodo) {
        this.nodo = nodo;
    }

    public Object getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
