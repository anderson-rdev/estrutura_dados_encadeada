class ListaEncadeada<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListaEncadeada() {
        this.head = null;
        this.size = 0;
    }

    public void adicionar(T elemento) {
        Node<T> newNode = new Node<>(elemento);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void adicionarNaPosicao(int posicao, T elemento) {
        if (posicao < 0 || posicao > size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao + ", Tamanho da lista: " + size);
        }
        Node<T> newNode = new Node<>(elemento);
        if (posicao == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < posicao - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T removerPrimeiro() {
        if (head == null) {
            throw new IllegalStateException("A lista está vazia.");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T removerUltimo() {
        if (head == null) {
            throw new IllegalStateException("A lista está vazia.");
        }
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    public T removerNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao + ", Tamanho da lista: " + size);
        }
        T data;
        if (posicao == 0) {
            data = removerPrimeiro();
        } else {
            Node<T> current = head;
            for (int i = 0; i < posicao - 1; i++) {
                current = current.next;
            }
            data = current.next.data;
            current.next = current.next.next;
            size--;
        }
        return data;
    }

    public int buscar(T valor) {
        Node<T> current = head;
        int posicao = 0;
        while (current != null) {
            if (current.data.equals(valor)) {
                return posicao;
            }
            current = current.next;
            posicao++;
        }
        return -1; // Elemento não encontrado
    }

    public void imprimirLista() {
        Node<T> current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null (Tamanho: " + size + ")");
    }

    public boolean estaVazia() {
        return size == 0;
    }

    public int tamanho() {
        return size;
    }
}
