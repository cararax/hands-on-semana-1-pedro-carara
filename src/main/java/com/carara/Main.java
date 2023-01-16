package com.carara;

import java.io.IOException;

import static com.carara.GeraRelatorio.teste;

public class Main {

    public static void main(String[] args) throws IOException {
        teste();
    }
//    public class GeraRelatorio {
//        public static void main(String[] args) throws IOException {
//            // Leitura dos arquivos CSV
//            BufferedReader faturamento = new BufferedReader(new FileReader("src/main/resources/faturamento.txt"));
//            BufferedReader notas = new BufferedReader(new FileReader("src/main/resources/notas.txt"));
//
//            // Mapa para armazenar os valores faturados por empresa
//            Map<String, Double> valoresFaturados = new HashMap<>();
//
//            // Leitura dos dados dos arquivos de faturamento
//            String linha;
//            while ((linha = faturamento.readLine()) != null) {
//                String[] dados = linha.split(";");
//                String empresa = dados[0];
//                double valor = Double.parseDouble(dados[3]) + Double.parseDouble(dados[5]) + Double.parseDouble(dados[7]);
//                valoresFaturados.put(empresa, valor);
//            }
//
//            // Criação dos arquivos de saída
//            FileWriter emConformidade = new FileWriter("emConformidade.csv");
//            FileWriter emNaoConformidade = new FileWriter("emNaoConformidade.csv");
//
//            // Verificação de conformidade e escrita dos dados nos arquivos de saída
//            while ((linha = notas.readLine()) != null) {
//                String[] dados = linha.split(";");
//                String empresa = dados[0];
//                double valorNotas = Double.parseDouble(dados[3]);
//                if (valoresFaturados.containsKey(empresa) && valoresFaturados.get(empresa) == valorNotas) {
//                    emConformidade.write(empresa + ";" + valorNotas + "\n");
//                } else {
//                    emNaoConformidade.write(empresa + ";" + valorNotas + "\n");
//                }
//            }
//            emConformidade.close();
//            emNaoConformidade.close();
//        }
//    }
}