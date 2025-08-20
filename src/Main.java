import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ListaEncadeada<String> lista = new ListaEncadeada<>();

    public static void main(String[] args) {
        inicializarLista(lista);
        exibirMenu();
    }

    private static void inicializarLista(ListaEncadeada<String> lista) {
        System.out.println("Inicializando lista com elementos padrão...");
        lista.adicionar("Elemento A");
        lista.adicionar("Elemento B");
        lista.adicionar("Elemento C");
        imprimirOperacao("Lista inicial", lista);
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Operações da Lista Encadeada ---");
            System.out.println("1. Adicionar elemento no final");
            System.out.println("2. Adicionar elemento em posição específica");
            System.out.println("3. Remover primeiro elemento");
            System.out.println("4. Remover último elemento");
            System.out.println("5. Remover elemento em posição específica");
            System.out.println("6. Buscar elemento");
            System.out.println("7. Imprimir lista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        adicionarElementoNoFinal();
                        break;
                    case 2:
                        adicionarElementoNaPosicao();
                        break;
                    case 3:
                        removerPrimeiroElemento();
                        break;
                    case 4:
                        removerUltimoElemento();
                        break;
                    case 5:
                        removerElementoNaPosicao();
                        break;
                    case 6:
                        buscarElemento();
                        break;
                    case 7:
                        imprimirOperacao("Lista atual", lista);
                        break;
                    case 0:
                        System.out.println("Saindo do programa. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
                opcao = -1; // Para continuar o loop
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                opcao = -1; // Para continuar o loop
            }

        } while (opcao != 0);
        scanner.close();
    }

    private static void imprimirOperacao(String mensagem, ListaEncadeada<String> lista) {
        System.out.println("\n" + mensagem + ":");
        if (lista.estaVazia()) {
            System.out.println("A lista está vazia.");
        } else {
            lista.imprimirLista();
        }
    }

    private static void adicionarElementoNoFinal() {
        System.out.print("Digite o elemento a ser adicionado: ");
        String elemento = scanner.nextLine();
        lista.adicionar(elemento);
        imprimirOperacao("Elemento '" + elemento + "' adicionado no final", lista);
    }

    private static void adicionarElementoNaPosicao() {
        System.out.print("Digite o elemento a ser adicionado: ");
        String elemento = scanner.nextLine();
        System.out.print("Digite a posição (0-base) onde o elemento será adicionado: ");
        try {
            int posicao = scanner.nextInt();
            scanner.nextLine();
            lista.adicionarNaPosicao(posicao, elemento);
            imprimirOperacao("Elemento '" + elemento + "' adicionado na posição " + posicao, lista);
        } catch (InputMismatchException e) {
            System.out.println("Posição inválida. Por favor, digite um número inteiro.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerPrimeiroElemento() {
        if (lista.estaVazia()) {
            System.out.println("A lista está vazia. Não há elementos para remover.");
            return;
        }
        lista.removerPrimeiro();
        imprimirOperacao("Primeiro elemento removido", lista);
    }

    private static void removerUltimoElemento() {
        if (lista.estaVazia()) {
            System.out.println("A lista está vazia. Não há elementos para remover.");
            return;
        }
        lista.removerUltimo();
        imprimirOperacao("Último elemento removido", lista);
    }

    private static void removerElementoNaPosicao() {
        if (lista.estaVazia()) {
            System.out.println("A lista está vazia. Não há elementos para remover.");
            return;
        }
        System.out.print("Digite a posição (0-base) do elemento a ser removido: ");
        try {
            int posicao = scanner.nextInt();
            scanner.nextLine();
            lista.removerNaPosicao(posicao);
            imprimirOperacao("Elemento na posição " + posicao + " removido", lista);
        } catch (InputMismatchException e) {
            System.out.println("Posição inválida. Por favor, digite um número inteiro.");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarElemento() {
        if (lista.estaVazia()) {
            System.out.println("A lista está vazia. Não há elementos para buscar.");
            return;
        }
        System.out.print("Digite o elemento a ser buscado: ");
        String valor = scanner.nextLine();
        int posicao = lista.buscar(valor);
        if (posicao != -1) {
            System.out.println("Elemento '" + valor + "' encontrado na posição: " + posicao);
        } else {
            System.out.println("Elemento '" + valor + "' não encontrado na lista.");
        }
    }
}

