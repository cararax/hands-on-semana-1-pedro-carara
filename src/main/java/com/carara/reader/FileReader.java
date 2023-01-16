package com.carara.reader;

import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public static final String BASE_PATH = "src/main/resources/";

    private FileReader() {
    }

    public static List<Faturamento> faturamentoReader(Integer referenceYear) {

        List<Faturamento> faturamentoList = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new java.io.FileReader(BASE_PATH + "faturamento.txt"))) {

            var linha = reader.lines().filter(l -> !l.isEmpty()).toList();
            linha = linha.subList(1, linha.size());

            String[] dados;

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
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return faturamentoList.stream().collect(Collectors.groupingBy(Faturamento::getCompany)).values().stream().flatMap(List::stream).toList();
    }

    public static List<Nota> notaReader(Integer referenceYear) {

        List<Nota> notaList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(BASE_PATH + "nota.txt"))) {

            var linha = reader.lines().filter(l -> !l.isEmpty()).toList();
            linha = linha.subList(1, linha.size());

            String[] dados;

            for (String line : linha) {
                dados = line.split(";");
                if (Integer.parseInt(dados[2]) == referenceYear) {
                    String company = dados[0];
                    String mes = dados[1];
                    String ano = dados[2];
                    String valor = dados[3];
                    String dataEmissao = dados[4];
                    String numeroNota = dados[5];
                    Nota nota = new Nota(company, mes, ano, valor, dataEmissao, numeroNota);
                    notaList.add(nota);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return notaList.stream().collect(Collectors.groupingBy(Nota::getCompany)).values().stream().flatMap(List::stream).toList();
    }
}
