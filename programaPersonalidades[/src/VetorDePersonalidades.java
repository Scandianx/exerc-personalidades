public class VetorDePersonalidades implements ColecaoDePersonalidades{

    private Personalidade[] personalidades;
    private int totalDePersonalidades;

    public VetorDePersonalidades(int capacidade) {
        this.personalidades = new Personalidade[capacidade];
        this.totalDePersonalidades = 0;
    }
    @Override
    public void adicionarPersonalidade(Personalidade personalidade) {
        if (totalDePersonalidades < personalidades.length) {
            personalidades[totalDePersonalidades] = personalidade;
            totalDePersonalidades++;
        } else {
            System.out.println("Capacidade do vetor de personalidades atingida.");
        }
    }

    @Override
    public void excluirPersonalidade(String nomeDaPersonalidade) {
        for (int i = 0; i < totalDePersonalidades; i++) {
            if (personalidades[i].getNome().equals(nomeDaPersonalidade)) {
                personalidades[i] = null;
                totalDePersonalidades--;
                break;
            }
        }
    }

    @Override
    public Personalidade obterPersonalidade(int posicaoDaPersonalidade) {
        if (posicaoDaPersonalidade >= 0 && posicaoDaPersonalidade < totalDePersonalidades) {
            return personalidades[posicaoDaPersonalidade];
        }
        return null; 
    }

    @Override
    public int obterTotalDePersonalidades() {
        return totalDePersonalidades;
    }

    @Override
    public void trocarPosicaoEntrePersonalidades(int posicaoDaPersonalidade1, int posicaoDaPersonalidade2) {
        if (posicaoDaPersonalidade1 >= 0 && posicaoDaPersonalidade1 < totalDePersonalidades &&
            posicaoDaPersonalidade2 >= 0 && posicaoDaPersonalidade2 < totalDePersonalidades) {
            Personalidade temp = personalidades[posicaoDaPersonalidade1];
            personalidades[posicaoDaPersonalidade1] = personalidades[posicaoDaPersonalidade2];
            personalidades[posicaoDaPersonalidade2] = temp;
        }
    }

    @Override
    public void alterarPersonalidade(int posicaoDaPersonalidade, Personalidade novaPersonalidade) {
        if (posicaoDaPersonalidade >= 0 && posicaoDaPersonalidade < totalDePersonalidades) {
            personalidades[posicaoDaPersonalidade] = novaPersonalidade;
        }
    }

    @Override
    public void ordenarPersonalidades(Ordenador ordenador) {
        
    }
    
}
