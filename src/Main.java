import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Atributos para compor o Menu
        String[] opcoes = {"Opção 1", "Opção 2", "Sair"};
        int escolha;

        // Instanciando Classes
        Scanner cs = new Scanner(System.in);
        ListaEncadeada l = new ListaEncadeada();

        do {
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0:
                    opcao1(); // Corrigido para case 0, pois "Opção 1" é o índice 0
                    break;
                case 1:
                    // opcao2(); // caso deseje implementar
                    break;
            }

        } while (escolha != 2);
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
        System.out.println("<---------------------------------->");
        while (atual != null) {
            System.out.print(atual.getValor());
            if (atual.getProximo() != null) System.out.print(" -> ");
            atual = atual.getProximo();
        }
        System.out.println("\n<---------------------------------->");
    }
}
