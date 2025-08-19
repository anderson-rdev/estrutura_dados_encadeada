public class No<T> {
    T valor;
    No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getProximo() {
        return this.proximo;
    }

    public T getValor() {
        return valor;
    }
}
