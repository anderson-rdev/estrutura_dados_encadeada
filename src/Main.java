import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instanciando Classes
        Scanner cs = new Scanner(System.in);
        ListaEncadeada l = new ListaEncadeada();

        // Inserindo Manualmente 
        No<String> a = new No<>("A");
        No<String> b = new No<>("B");
        No<String> c = new No<>("C");
        No<String> d = new No<>("D");

        // Setando Valores
        a.setProximo(b);
        b.setProximo(c);
        c.setProximo(d);

        No<String> atual = a;

        while (atual != null) {
            System.out.print(atual.getValor());
            if (atual.getProximo() != null) System.out.print(" -> ");
            atual = atual.getProximo();
        }

    }
}