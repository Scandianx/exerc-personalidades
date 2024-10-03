public class OrdenarPorAnoDeNascimentoComQuickSort implements Ordenador{

    @Override
    public void ordenar(ColecaoDePersonalidades c) {
        int tamanho = c.obterTotalDePersonalidades();
        quickSort(c, 0, tamanho - 1);
    }
    
    private void quickSort(ColecaoDePersonalidades c, int inicio, int fim) {
        if (inicio<fim) {
            int pivo = particionar(c, inicio, fim);
            quickSort(c, inicio, pivo - 1);  
            quickSort(c, pivo + 1, fim);
        }
    }

    private int particionar(ColecaoDePersonalidades c, int inicio, int fim) {
        String pivo = c.obterPersonalidade(fim).getBirthYear();
        int pivoInt = parsePraInteiro(pivo);
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
           String elemento = c.obterPersonalidade(j).getBirthYear();
           int elemInt = parsePraInteiro(elemento);
           if (elemInt <= pivoInt) {
             i++;
             c.trocarPosicaoEntrePersonalidades(i,j);
           }
        }
        c.trocarPosicaoEntrePersonalidades(i + 1,fim);
           return i + 1; 
    }
    private int parsePraInteiro(String ano) {
        try {
            int numeroInt = Integer.parseInt(ano);
            return numeroInt;
        } catch (Exception e) {
            System.out.println("Nao fez parse no elemtno: " + ano);
            return 2000;
        }
    }
}
