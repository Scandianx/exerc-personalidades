import java.text.Normalizer;
public class OrdenarPorNomeComBubbleSort implements Ordenador {

    private char[] alfabeto = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    @Override
    public void ordenar(ColecaoDePersonalidades c) {
        int tamanhoVetor = c.obterTotalDePersonalidades();
        boolean trocou;
        ColecaoDePersonalidades colec = c;
        do {
            trocou = false;
            for (int i = 0; i < tamanhoVetor - 1; i++) {
                String nome1 = colec.obterPersonalidade(i).getNome();
                String nome2 = colec.obterPersonalidade(i + 1).getNome();
                if (vemPrimeiro(nome1, nome2)) {
                    colec.trocarPosicaoEntrePersonalidades(i, i + 1);
                    trocou = true;
                }
            }
        } while (trocou);
        
    }

    private boolean vemPrimeiro(String nome1, String nome2) {

        if (nome1 == null || nome2 == null) {
            System.out.println("Nome nulo encontado");
            return false;
        }
        int tamanhoNome1 = nome1.length();
        int tamanhoNome2 = nome2.length();
        int tamanhoFinal = tamanhoNome2 > tamanhoNome1 ? tamanhoNome1 : tamanhoNome2;
        for (int i = 0; i < tamanhoFinal; i++) {
            int pos1 = percorrerAlfabetoRetornarPos(removerAcentos(nome1).toLowerCase().charAt(i));
            int pos2 = percorrerAlfabetoRetornarPos(removerAcentos(nome2).toLowerCase().charAt(i));
            if (pos1 > pos2) {
                return true;
            } else {
                if (pos1 < pos2) {
                    return false;
                }
            }
        }
        return false;
    }

    private int percorrerAlfabetoRetornarPos(char c) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (c == alfabeto[i]) {
                return i;
            }
        }
        return 0;
    }
     private String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoNormalizado.replaceAll("\\p{M}", "");
    }

}
