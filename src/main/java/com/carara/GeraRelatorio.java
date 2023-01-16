package com.carara;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GeraRelatorio {
    public static void teste() throws IOException {
        // Leitura dos arquivos CSV
        BufferedReader faturamento = new BufferedReader(new FileReader("src/main/resources/faturamento.txt"));
        BufferedReader notas = new BufferedReader(new FileReader("src/main/resources/nota.txt"));

        // Mapa para armazenar os valores faturados por empresa
        Map<String, Double> valoresFaturados = new HashMap<>();

        // Leitura dos dados dos arquivos de faturamento
        String linha;
        while ((linha = faturamento.readLine()) != null) {
            String[] dados = linha.split(";");
            String empresa = dados[0];
            try {
                double valor = Double.parseDouble(dados[3]) + Double.parseDouble(dados[5]) + Double.parseDouble(dados[7]);
                valoresFaturados.put(empresa, valor);
            } catch (NumberFormatException e) {
                // Pula a linha se os dados não são números
            }
//            double valor = Double.parseDouble(dados[3]) + Double.parseDouble(dados[5]) + Double.parseDouble(dados[7]);
//            valoresFaturados.put(empresa, valor);
        }

        // Criação dos arquivos de saída
        FileWriter emConformidade = new FileWriter("emConformidade.csv");
        FileWriter emNaoConformidade = new FileWriter("emNaoConformidade.csv");

        // Verificação de conformidade e escrita dos dados nos arquivos de saída
        notas.readLine(); // Pula a primeira linha
        int i = 1;
        while ((linha = notas.readLine()) != null) {
            String[] dados = linha.split(";");
            String empresa = dados[0];
            //skip first line
//            if (empresa.equals("Empresa")) {
//                continue;
//            }
            try {
                if(dados.length>=3){
                    double valorNotas = Double.parseDouble(dados[3]);
                    i=i++;
                    if (valoresFaturados.containsKey(empresa) && valoresFaturados.get(empresa) == valorNotas) {
                        emConformidade.write(empresa + ";" + valorNotas + "\n");
                    } else {
                        emNaoConformidade.write(empresa + ";" + valorNotas + "\n");
                    }
                }
            } catch (NumberFormatException e) {
                // Pula a linha se os dados não são números
//                continue;
            }

        }
        emConformidade.close();
        emNaoConformidade.close();
    }
}