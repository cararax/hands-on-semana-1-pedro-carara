package com.carara;

import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.carara.reader.FileReader.faturamentoReader;
import static com.carara.reader.FileReader.notaReader;

public class Main {

    public static void main(String[] args) throws IOException {


//        ArrayList<Faturamento> faturamentoList = new ArrayList<>();
        List<Nota> notaList = new ArrayList<>();
        List<Faturamento> faturamentoList = new ArrayList<>();

        faturamentoList = faturamentoReader(faturamentoList);
        notaList = notaReader(notaList);

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

