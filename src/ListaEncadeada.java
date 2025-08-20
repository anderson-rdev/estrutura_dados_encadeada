public class ListaEncadeada {
    private No<String> cabeca;

    // Adicionando registro na sequencia ordenada
    public void adicionanProximo(No<String> novoNo) {
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
