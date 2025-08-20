import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Atributos para compor o Menu
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3", "Sair"};
        int escolha;

        // Instanciando Classes
        Scanner cs = new Scanner(System.in);
        // ListaEncadeada lista = new ListaEncadeada();

        do {
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0:
                    opcao1();
                    break;
                case 1:
                    opcao2();
                    break;
                case 3:
                    // opcao3(); // Caso queira implementa um novo trecho
                    break;
            }

        } while (escolha != 3);
    }

    static void opcao1() {
        JOptionPane.showMessageDialog(null, "Você escolheu a opção 1:");

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

        // Imprimindo resultado
        while (atual != null) {
            System.out.print(atual.getValor());
            if (atual.getProximo() != null) System.out.print(" -> ");
            atual = atual.getProximo();
        }
    }

    static void opcao2() {
        // Criando nós manualmente
        No<String> a = new No<>("A");
        No<String> b = new No<>("B");
        No<String> c = new No<>("C");
        No<String> d = new No<>("D");

        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionar(a);
        lista.adicionar(b);
        lista.adicionar(c);
        lista.adicionar(d);

        // Buscar a posição de um nó específico (exemplo: "C")
        int posicao = lista.buscar(a);

        if (posicao != -1) {
            System.out.println("Encontrado na posição: " + posicao);
        } else {
            System.out.println("Não encontrado");
        }
    }


}
