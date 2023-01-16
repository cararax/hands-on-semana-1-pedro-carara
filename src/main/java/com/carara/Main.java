package com.carara;

import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.carara.calculator.ComplianceCalculator.calculateComliance;
import static com.carara.reader.FileReader.faturamentoReader;
import static com.carara.reader.FileReader.notaReader;

public class Main {

    public static void main(String[] args) throws IOException {


//        ArrayList<Faturamento> faturamentoList = new ArrayList<>();
        List<Nota> notaList = new ArrayList<>();
        List<Faturamento> faturamentoList = new ArrayList<>();

        faturamentoList = faturamentoReader(faturamentoList, 2022);
        notaList = notaReader(notaList, 2022);
//        complianceCalculator(faturamentoList, notaList);
        for(Faturamento faturamento : faturamentoList){
            System.out.println(faturamento.getAno());
        }
        for(Nota nota : notaList){
            System.out.println(nota.getAno());
        }

        calculateComliance(faturamentoList, notaList);

    }
}


