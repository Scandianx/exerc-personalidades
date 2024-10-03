public class ProgramaPersonalidades2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Comecando");
        ColecaoDePersonalidades colecao = new VetorDePersonalidades(125);
        ManipulaDataset.lerDoArquivoCsv(colecao);
        System.out.println(colecao.obterTotalDePersonalidades());
        Ordenador ordenador = new OrdenarPorAnoDeNascimentoComQuickSort();
        colecao.ordenarPersonalidades(ordenador);
        ManipulaDataset.escreverNoArquivoCsv(colecao);
    }
}
