
public interface ColecaoDePersonalidades {
    void adicionarPersonalidade(Personalidade personalidade);

    void excluirPersonalidade(String nomeDaPersonalidade);

    Personalidade obterPersonalidade(int posicaoDaPersonalidade);

    int obterTotalDePersonalidades();

    void trocarPosicaoEntrePersonalidades(int posicaoDaPersonalidade1, int posicaoDaPersonalidade2);

    void alterarPersonalidade(int posicaoDaPersonalidade, Personalidade novaPersonalidade);

    void ordenarPersonalidades(Ordenador ordenador);
}
