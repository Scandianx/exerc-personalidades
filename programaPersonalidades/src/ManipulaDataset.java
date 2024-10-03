import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class ManipulaDataset {

    public static ColecaoDePersonalidades lerDoArquivoCsv(ColecaoDePersonalidades c) {
        String filePath = "C:\\Users\\Filipe\\Desktop\\Git repositories\\exercs\\lista-encadeada-exerc\\AgeDataset-V1.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String linha;
            boolean primeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; 
                }
                String[] campos = processarLinha(linha);
                if (campos.length>7) {
                    Personalidade pessoa = new Personalidade(
                        campos[7], 
                        campos[1], 
                        campos[2], 
                        campos[3], 
                        campos[4], 
                        campos[5], 
                        campos[6]
                );
                c.adicionarPersonalidade(pessoa);
                } else {
                    Personalidade pessoa = new Personalidade(
                        null, 
                        campos[1], 
                        campos[2], 
                        campos[3], 
                        campos[4], 
                        campos[5], 
                        campos[6]
                );
                c.adicionarPersonalidade(pessoa);
                }
                
            }
            br.close();
            return c;
        } catch (Exception e) {
            System.out.println("Não foi possível ler o arquivo csv devido à: " + e.getMessage());
            return c;
        }

    }

    public static void escreverNoArquivoCsv(ColecaoDePersonalidades c) {

        String filePath = "resultadoOrdenacao.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write("Nome,Descricao,Genero,Pais,Emprego,Ano nasc,Ano morte\n");
            int total = c.obterTotalDePersonalidades();
            for (int i = 0; i < total; i++) {
                Personalidade p = c.obterPersonalidade(i);
                bw.write(
                        p.getNome() + "," +
                                p.getShortDescription() + "," +
                                p.getGender() + "," +
                                p.getCountry() + "," +
                                p.getOccupation() + "," +
                                p.getBirthYear() + "," +
                                p.getDeathYear()
                                + "\n");
            }
            bw.close();
            System.out.println("Novo arquivo escrito com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível escrever o arquivo csv devido à: " + e.getMessage());
        }
    }

    private static String[] processarLinha(String linha) {
        String[] retornoArray = new String[200];
        retornoArray[0] = "";
        int tamanho = linha.length();
        char v = ',';
        char asp = '"';
        int colunas = 0;
        if (!linha.contains("\"")) {
            return linha.split(",");
        } else {
            for(int i=0; i< tamanho; i++) {
                if(linha.charAt(i)==v) {
                    colunas++;
                    retornoArray[colunas] = "";
                } else {
                    if (linha.charAt(i)==asp) {
                        
                        String retorno = processarAspas(linha.substring(i + 1));
                        retornoArray[colunas] = retorno;
                        i = i + retorno.length() -1;
                        
                    }  else {
                        retornoArray[colunas] = retornoArray[colunas] + linha.charAt(i);
                    }
                }
            }
        }
        
        return retornoArray;
    }
    private static String processarAspas(String linha) {
        
        int tamanho = linha.length();
        char asp = '"';
        StringBuilder retorno = new StringBuilder();
        retorno.append("\"");
        for(int i=0; i< tamanho; i++) {
            if (linha.charAt(i)==asp) {
                return retorno.append("\"").toString();
            }
            retorno.append(linha.charAt(i));
        }
        return retorno.append("\"").toString();
    }
}
