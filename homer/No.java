public class No<T> {
    T valor;
    No<T> anterior;
    No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}