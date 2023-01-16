package com.carara.reader;

import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public static final String basePath = "src/main/resources/";

    public static List<Faturamento> faturamentoReader(List<Faturamento> faturamentoList, Integer referenceYear) throws IOException {
        //metodo de leitura de faturamento, adicionar filtro por ano
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(basePath + "faturamento.txt"))) {

            //remove linhas em branco
            var linha = reader.lines().filter(l -> !l.isEmpty()).toList();
            //pula primeira linha (cabeçalho)
            linha = linha.subList(1, linha.size());
            String[] dados;

//            String linha;
            for (String line : linha) {
                dados = line.split(";");
                if (Integer.parseInt(dados[2]) == referenceYear) {
                    String company = dados[0];
                    String mes = dados[1];
                    String ano = dados[2];
                    String dataParcela1 = dados[3];
                    String parcela1 = dados[4];
                    String dataParcela2 = dados[5];
                    String parcela2 = dados[6];
                    String dataParcela3 = dados[7];
                    String parcela3 = dados[8];

                    Faturamento faturamento = new Faturamento(company, mes, ano, dataParcela1, parcela1, dataParcela2,
                            parcela2, dataParcela3, parcela3);
                    faturamentoList.add(faturamento);
                }
//                return faturamentoList.stream().collect(Collectors.groupingBy(Faturamento::getCompany)).values().stream().flatMap(List::stream).collect(Collectors.toList());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return faturamentoList.stream().collect(Collectors.groupingBy(Faturamento::getCompany)).values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public static List<Nota> notaReader(List<Nota> notaList, Integer referenceYear) throws IOException {
        //metodo de leitura de faturamento, adicionar filtro por ano
        //metodo de leitura de faturamento, adicionar filtro por ano
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(basePath + "nota.txt"))) {

            //remove linhas em branco
            var linha = reader.lines().filter(l -> !l.isEmpty()).toList();
            //pula primeira linha (cabeçalho)
            linha = linha.subList(1, linha.size());
            String[] dados /*= new String[9]*/;

//            String linha;
            for (String line : linha) {
                /*String[]*/
                dados = line.split(";");
                if(Integer.parseInt(dados[2]) == referenceYear) {
                String company = dados[0];
                String mes = dados[1];
                String ano = dados[2];
                String valor = dados[3];
                String dataEmissao = /*Double.parseDouble(*/dados[4];
                String numeroNota = dados[5];


                Nota nota = new Nota(company, mes, ano, valor, dataEmissao, numeroNota);
                notaList.add(nota);
                }

//                return notaList.stream().collect(Collectors.groupingBy(Nota::getCompany));
//                return notaList.stream().collect(Collectors.groupingBy(Nota::getCompany)).values().stream().flatMap(List::stream).collect(Collectors.toList());

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return notaList.stream().collect(Collectors.groupingBy(Nota::getCompany)).values().stream().flatMap(List::stream).collect(Collectors.toList());

    }
}
