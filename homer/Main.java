public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        //teste 1 a 18 removendo e adicionando elementos na lista duplamente encadeada
        System.out.println("--- Teste 1 ---");
        lista.inserir("Homer");
        lista.inserir("Marge");
        lista.exibir();

       
        System.out.println("\n--- Teste 2 ---");
        lista.esvaziar();   
        lista.exibir();

        
        System.out.println("\n--- Teste 3 ---");
        lista.inserir("Homer");
        lista.inserirNaPosicao(0, "Bart");
        lista.inserirNaPosicao(1, "Moll");
        lista.exibir();

        
        System.out.println("\n--- Teste 4 ---");
        lista.esvaziar();

        
        System.out.println("\n--- Teste 5 ---");
        lista.inserir("Homer");
        lista.inserir("Bart");
        lista.inserirNoInicio("Lisa");
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

       
        System.out.println("\n--- Teste 6 ---");
        lista.esvaziar();
        lista.exibir();

        
        System.out.println("\n--- Teste 7 ---");
        lista.inserir("Homer");
        lista.inserir("Maggie");
        lista.inserirNaPosicao(0, "Bart");
        lista.inserirNaPosicao(1, "Marge");
        lista.exibir();
        System.out.println("Lisa está na lista? " + lista.contem("Lisa"));

        
        System.out.println("\n--- Teste 8 ---");
        lista.esvaziar();

        
        System.out.println("\n--- Teste 9 ---");
        lista.inserir("Homer");
        lista.inserir("Bart");
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

        
        System.out.println("\n--- Teste 10 ---");
        verificarPersonagens(lista);
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

        
        System.out.println("\n--- Teste 11 ---");
        lista.esvaziar();

        
        System.out.println("\n--- Teste 12 ---");
        lista.inserirNoInicio("Homer");
        lista.inserirNoInicio("Bart");
        lista.inserir("Marge");
        lista.inserirNaPosicao(1, "Maggie");
        lista.inserirNoInicio("Ned Flanders");
        lista.inserir("Sr. Burns");
        lista.exibir();

        
        System.out.println("\n--- Teste 13 ---");
        lista.removerDoFim();
        lista.exibir();

        
        System.out.println("\n--- Teste 14 ---");
        lista.removerNaPosicao(1);
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

        
        System.out.println("\n--- Teste 15 ---");
        verificarPersonagens(lista);
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

        
        System.out.println("\n--- Teste 16 ---");
        lista.removerDoInicio();
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

        
        System.out.println("\n--- Teste 17 ---");
        verificarPersonagens(lista);
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

  
        System.out.println("\n--- Teste 18 ---");
        lista.esvaziar();
        lista.exibir();
    }

    private static void verificarPersonagens(ListaDuplamenteEncadeada<String> lista) {
        String[] nomes = {"Marge", "Homer", "Bart", "Maggie"};
        for (String nome : nomes) {
            System.out.println(nome + " está na lista? " + lista.contem(nome));
        }
    }
}