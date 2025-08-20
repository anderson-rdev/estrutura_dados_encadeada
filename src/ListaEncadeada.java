public class ListaEncadeada {
    private No<String> cabeca;
    private int tamanho;
    private No<String>[] elementos;

    // Adicionando registro na sequencia
    public void adicionar(No<String> novoNo) {
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No<String> atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
    }

    // Buscando registro
    public int buscar(No<String> novoNo) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].getValor().equals(novoNo.getValor())) {
                return i;
            }
        }
        return -1;
    }

    // Exibindo resultado
    public void imprimirLista() {
        No<String> atual = cabeca;
        while (atual != null) {
            System.out.print(atual.getValor());
            if (atual.getProximo() != null) System.out.print(" -> ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
