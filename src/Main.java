public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();

        lista.adicionar("A");
        lista.adicionar("B");
        lista.adicionar("C");
        lista.adicionar("D");

        System.out.println("Lista original:");
        lista.imprimirLista();

        System.out.println("\nAdicionando 'X' na posição 2:");
        lista.adicionarNaPosicao(2, "X");
        lista.imprimirLista();

        System.out.println("\nRemovendo primeiro elemento:");
        lista.removerPrimeiro();
        lista.imprimirLista();

        System.out.println("\nRemovendo último elemento:");
        lista.removerUltimo();
        lista.imprimirLista();

        System.out.println("\nRemovendo elemento da posição 1:");
        lista.removerNaPosicao(1);
        lista.imprimirLista();

        System.out.println("\nBuscando posição de 'X':");
        int pos = lista.buscar("X");
        System.out.println(pos != -1 ? "Encontrado na posição: " + pos : "Não encontrado");
    }
}
