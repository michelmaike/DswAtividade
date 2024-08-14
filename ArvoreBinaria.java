class ArvoreBinaria {
    No raiz;

    ArvoreBinaria(){
        this.raiz = null;
    }

    void inserir(int valor){
        raiz = inserirRecursiva(raiz, valor);
    }

    private No inserirRecursiva(No atual, int valor) {
        if(atual == null){
            return new No(valor);
        }
        if(valor < atual.valor){
            atual.esquerdo = inserirRecursiva(atual.esquerdo, valor);
        }else if (valor > atual.valor){
            atual.direito = inserirRecursiva(atual.direito, valor);
        }
        return atual;
    }

    void balancearDsw(){
        criarEspinhaDorsal();
        balancearArvore();
    }

    private void criarEspinhaDorsal(){
        No temp = raiz;
        while(temp != null){
            if(temp.esquerdo != null){
                rotacaoDireita(temp);
            }
            temp = temp.direito;
        }
    }

    private void rotacaoDireita(No no){
        if(no.esquerdo != null){
            No esquerdo = no.esquerdo;
            no.esquerdo = esquerdo.direito;
            esquerdo.direito = no;
            no = esquerdo;
        }
    }

    private void balancearArvore(){
        int n = contarNos(raiz);
        int m = (int) Math.pow(2, log2(n + 1))- 1;
        realizarRotacoes(n - m);
        while (m > 1){
            m /= 2;
            realizarRotacoes(m);
        }
    }

    private int contarNos(No no){
        if(no == null){
            return 0;
        }
        return 1+ contarNos(no.esquerdo) + contarNos(no.direito);
    }

    private void realizarRotacoes(int quantidade) {
        No temp = raiz;
        for (int i = 0; i < quantidade;i++) {
            if (temp != null && temp.direito != null) { //parte feita com ajuda de IA
                rotacaoEsquerda(temp);
                if (temp.direito != null) {
                    temp = temp.direito.direito;
                }
            }
        }
    }
    private void rotacaoEsquerda(No no){
        if (no.direito != null){
            No direito = no.direito;
            no.direito = direito.esquerdo;
            direito.esquerdo = no;
            no = direito;
        }
    }

    private int log2(int n){
        int log = 0;
        while(n> 1){
            n /= 2;
            log++;
        }
        return log;
    }

    void EmOrdem() {
        EmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void EmOrdemRecursivo(No atual) {
        if (atual != null) {
            EmOrdemRecursivo(atual.esquerdo);
            System.out.print(atual.valor+" ");
            EmOrdemRecursivo(atual.direito);
        }
    }
}