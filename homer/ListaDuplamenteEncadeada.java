public class ListaDuplamenteEncadeada<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // Insere no final da lista (conforme o pseudocódigo)
    public void inserir(T valor) {
        No<T> novoNo = new No<>(valor);
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
        this.tamanho++;
    }

    // Insere no início da lista
    public void inserirNoInicio(T valor) {
        No<T> novoNo = new No<>(valor);
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            novoNo.proximo = this.inicio;
            this.inicio.anterior = novoNo;
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    // Insere em uma posição específica (base 0)
    public void inserirNaPosicao(int posicao, T valor) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }
        if (posicao == this.tamanho) {
            inserir(valor);
            return;
        }

        No<T> atual = buscarNo(posicao);
        No<T> novoNo = new No<>(valor);

        novoNo.proximo = atual;
        novoNo.anterior = atual.anterior;
        atual.anterior.proximo = novoNo;
        atual.anterior = novoNo;
        this.tamanho++;
    }

    // Remove por valor (conforme o pseudocódigo)
    public boolean remover(T valor) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    this.inicio = atual.proximo;
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    this.fim = atual.anterior;
                }

                this.tamanho--;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Remove do início da lista
    public T removerDoInicio() {
        if (this.inicio == null) {
            return null;
        }
        T valorRemovido = this.inicio.valor;
        this.inicio = this.inicio.proximo;

        if (this.inicio != null) {
            this.inicio.anterior = null;
        } else {
            this.fim = null;
        }
        this.tamanho--;
        return valorRemovido;
    }

    // Remove do final da lista
    public T removerDoFim() {
        if (this.fim == null) {
            return null;
        }
        T valorRemovido = this.fim.valor;
        this.fim = this.fim.anterior;

        if (this.fim != null) {
            this.fim.proximo = null;
        } else {
            this.inicio = null;
        }
        this.tamanho--;
        return valorRemovido;
    }

    // Remove de uma posição específica (base 0)
    public T removerNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        if (posicao == 0) {
            return removerDoInicio();
        }
        if (posicao == this.tamanho - 1) {
            return removerDoFim();
        }

        No<T> atual = buscarNo(posicao);
        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;
        this.tamanho--;
        return atual.valor;
    }

    // Verifica se um elemento existe na lista
    public boolean contem(T valor) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Esvazia toda a lista
    public void esvaziar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    // Exibe os valores da lista (conforme o pseudocódigo)
    public void exibir() {
        if (this.inicio == null) {
            System.out.println("[Lista vazia]");
            return;
        }
        No<T> atual = this.inicio;
        while (atual != null) {
            System.out.print(atual.valor + (atual.proximo != null ? " <-> " : ""));
            atual = atual.proximo;
        }
        System.out.println();
    }

    private No<T> buscarNo(int posicao) {
        No<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual;
    }
}