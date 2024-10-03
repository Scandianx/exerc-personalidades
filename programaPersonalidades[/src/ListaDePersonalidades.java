public class ListaDePersonalidades implements ColecaoDePersonalidades{


    private No noInicial;
    private int tamanho;

    public ListaDePersonalidades() {
        this.noInicial = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionarPersonalidade(Personalidade personalidade) {
        No novoNo = new No(personalidade);
        if (noInicial == null) {
            noInicial = novoNo;
        } else {
            No atual = noInicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(novoNo);
        }
        tamanho++;
    }

    @Override
    public void excluirPersonalidade(String nomeDaPersonalidade) {
        if (noInicial == null) {
            return;
        }
        if (noInicial.obterDado().getNome().equals(nomeDaPersonalidade)) {
            noInicial = noInicial.obterProximo();
            tamanho--;
            return;
        }

        No atual = noInicial;
        No anterior = null;

        while (atual != null && !atual.obterDado().getNome().equals(nomeDaPersonalidade)) {
            anterior = atual;
            atual = atual.obterProximo();
        }

        if (atual != null) {
            anterior.definirProximo(atual.obterProximo());
            tamanho--;
        }
    }

    @Override
    public Personalidade obterPersonalidade(int posicaoDaPersonalidade) {
        if (posicaoDaPersonalidade < 0 || posicaoDaPersonalidade >= tamanho) {
            System.out.println("Indice inválido");
            return null;
        }

        No atual = noInicial;
        for (int i = 0; i < posicaoDaPersonalidade; i++) {
            atual = atual.obterProximo();
        }

        return atual.obterDado();
    }

    @Override
    public int obterTotalDePersonalidades() {
        return tamanho;
    }

    @Override
    public void alterarPersonalidade(int posicaoDaPersonalidade, Personalidade novaPersonalidade) {
        if (posicaoDaPersonalidade < 0 || posicaoDaPersonalidade >= tamanho) {
            System.out.println("Indice inválido");
            return;
        }

        No atual = noInicial;
        for (int i = 0; i < posicaoDaPersonalidade; i++) {
            atual = atual.obterProximo();
        }

        atual.definirDado(novaPersonalidade);
    }

    @Override
    public void ordenarPersonalidades(Ordenador ordenador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarPersonalidades'");
    }

    @Override
    public void trocarPosicaoEntrePersonalidades(int posicaoDaPersonalidade1, int posicaoDaPersonalidade2) {
        if (posicaoDaPersonalidade1 < 0 || posicaoDaPersonalidade1 >= tamanho || 
            posicaoDaPersonalidade2 < 0 || posicaoDaPersonalidade2 >= tamanho) {
            System.out.println("Indice inválido");
            return;
        }

        if (posicaoDaPersonalidade1 == posicaoDaPersonalidade2) {
            System.out.println("Indice inválido");
            return; 
        }
        Personalidade perso1 = obterPersonalidade(posicaoDaPersonalidade1);
        Personalidade perso2 = obterPersonalidade(posicaoDaPersonalidade2);
        alterarPersonalidade(posicaoDaPersonalidade1, perso2);
        alterarPersonalidade(posicaoDaPersonalidade2, perso1);
    }
    
}
