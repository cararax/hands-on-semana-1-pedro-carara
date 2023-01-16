package com.carara;

import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        final String basePath = "src/main/resources/";


//        ArrayList<Faturamento> faturamentoList = new ArrayList<>();
        ArrayList<Nota> notaList = new ArrayList<>();
        List<Faturamento> faturamentoList = new ArrayList<>();

        //metodo de leitura de faturamento, adicionar filtro por ano
        try (BufferedReader reader = new BufferedReader(new FileReader(basePath + "faturamento.txt"))) {

            //remove linhas em branco
            var linha = reader.lines().filter(l -> !l.isEmpty()).toList();
            //pula primeira linha (cabeçalho)
            linha = linha.subList(1, linha.size());
            String[] dados /*= new String[9]*/;

//            String linha;
            for (String line : linha) {
                /*String[]*/
                dados = line.split(";");
                String company = dados[0];
                String mes = dados[1];
                String ano = dados[2];
                String dataParcela1 = dados[3];
                String parcela1 = /*Double.parseDouble(*/dados[4];
                String dataParcela2 = dados[5];
                String parcela2 = /*Double.parseDouble(*/dados[6];
                String dataParcela3 = dados[7];
                String parcela3 = /*Double.parseDouble(*/dados[8];

                Faturamento faturamento = new Faturamento(company, mes, ano, dataParcela1, parcela1, dataParcela2, parcela2, dataParcela3, parcela3);
                faturamentoList.add(faturamento);
                //return faturamentos.stream().collect(Collectors.groupingBy(Faturamento::getCompany));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        //metodo de leitura de faturamento, adicionar filtro por ano
        try (BufferedReader reader = new BufferedReader(new FileReader(basePath + "nota.txt"))) {

            //remove linhas em branco
            var linha = reader.lines().filter(l -> !l.isEmpty()).toList();
            //pula primeira linha (cabeçalho)
            linha = linha.subList(1, linha.size());
            String[] dados /*= new String[9]*/;

//            String linha;
            for (String line : linha) {
                /*String[]*/
                dados = line.split(";");
                String company = dados[0];
                String mes = dados[1];
                String ano = dados[2];
                String valor = dados[3];
                String dataEmissao = /*Double.parseDouble(*/dados[4];
                String numeroNota = dados[5];


                Nota nota = new Nota(company, mes, ano, valor, dataEmissao, numeroNota);
                notaList.add(nota);
//                return notas.stream().collect(Collectors.groupingBy(Notas::getCompany));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        faturamentoList.forEach(System.out::println);
        notaList.forEach(System.out::println);

    }
}

//        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/faturamento.txt"))) {
//
//            var lines = reader.lines().filter(l -> !l.isEmpty()).toList();
//            lines = lines.subList(1, lines.size());
//            var values = new String[9];
//
//            for(String line : lines) {
//                values = line.split(";");
//
////                if(Integer.parseInt(values[2]) == ano){
//                    var faturamento = new Faturamento(values[0],
//                            Integer.parseInt(values[1]), Integer.parseInt(values[2]));
//                    faturamento.popular(values);
//                    faturamentoList.add(faturamento);
////                }
//            }
//
//        } catch (Exception e) {
//            LOGGER.info(e.getMessage());
//        }
//
//        return faturamentoList.stream().collect(Collectors.groupingBy(Faturamento::getCompany));

