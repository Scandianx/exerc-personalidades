public class ProgramaPersonalidades {
    public static void main(String[] args) throws Exception {
        System.out.println("Comecando");
        ColecaoDePersonalidades colecao = new ListaDePersonalidades();
        ManipulaDataset.lerDoArquivoCsv(colecao);
        System.out.println(colecao.obterTotalDePersonalidades());
        Ordenador ordenador = new OrdenarPorNomeComBubbleSort();
        colecao.ordenarPersonalidades(ordenador);
        ManipulaDataset.escreverNoArquivoCsv(colecao);
    }
}
