package com.carara.calculator;

import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.carara.reader.FileReader.*;

public class ComplianceCalculator {

//    public static void complianceCalculator(List<Faturamento> faturamentoList, List<Nota> notaList) throws IOException {
//
//        faturamentoReader(faturamentoList);
//
//        List<String> complianceList = new ArrayList<>();
//
//        for(Faturamento faturamento : faturamentoList){
//            for(Nota nota : notaList){
//                if(faturamento.getCompany().equals(nota.getCompany())){
//                    if(faturamento.getAno() == nota.getAno()){
//                        if(faturamento.getMes() == nota.getMes()){
//                            if(faturamento.valorTotalParcelas().compareTo(nota.getValor()) == 0){
//                                complianceList.add(faturamento.getCompany() + ";" + faturamento.getAno() + ";" + faturamento.getMes() + ";" + "OK");
//                            } else {
//                                complianceList.add(faturamento.getCompany() + ";" + faturamento.getAno() + ";" + faturamento.getMes() + ";" + "NOK");
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/compliance.txt"))) {
//            writer.write("Empresa;Ano;Mês;Compliance");
//            writer.newLine();
//            for(String compliance : complianceList){
//                writer.write(compliance);
//                writer.newLine();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }


    public static void calculateComliance(List<Faturamento> faturamentoList, List<Nota> notaList) throws IOException {

//        List<Nota> notaList = new ArrayList<>();
//        List<Faturamento> faturamentoList = new ArrayList<>();
        List<String> empresas = new ArrayList<>();

//        faturamentoList = faturamentoReader(faturamentoList, 2022);
//        notaList = notaReader(notaList, 2022);
        empresas = faturamentoList.stream().map(Faturamento::getCompany).toList();


//        try(
//                BufferedWriter writerConformidade = new BufferedWriter(new FileWriter(basePath + "EmpresasEmConformidade.txt")))
//
//                BufferedWriter writerNaoConformidade = new BufferedWriter(new FileWriter(basePath + "EmpresasEmNaoConformidade.txt"))
//
//                }
        BufferedWriter writerConformidade = new BufferedWriter(new FileWriter(basePath + "EmpresasEmConformidade.txt"));
        writerConformidade.write("Empresa;Conformidade;");
        writerConformidade.newLine();

        BufferedWriter writerNaoConformidade = new BufferedWriter(new FileWriter(basePath + "EmpresasEmNaoConformidade.txt"));
        writerNaoConformidade.write("Empresa;Conformidade;");
        writerNaoConformidade.newLine();


        for (String empresa : empresas) {
            BigDecimal valorTotalFaturamento = BigDecimal.ZERO;
            BigDecimal valorTotalNotas = BigDecimal.ZERO;
//                var listaFaturamentos = faturamentos.get(empresa);
            var faturamentoListByCompany = faturamentoList.stream()
                    .filter(f -> f.getCompany().equals(empresa))
                    .collect(Collectors.toList());

            var notasByCompany = notaList.stream()
                    .filter(n -> n.getCompany().equals(empresa))
                    .collect(Collectors.toList());
            ;

            if (!faturamentoListByCompany.isEmpty() && !notasByCompany.isEmpty()) {
                for (Faturamento faturmento : faturamentoListByCompany) {
                    valorTotalFaturamento = valorTotalFaturamento.add(faturmento.getValorTotalParcelas());
                }
                for (Nota nota : notasByCompany) {
                    valorTotalNotas = valorTotalNotas.add(nota.getValor());
                }
            }

            if (valorTotalNotas.equals(valorTotalFaturamento)) {
                writerConformidade.write( empresa + "; EM CONFORMIDADE;");
                writerConformidade.newLine();

            } else {
                writerNaoConformidade.write(empresa + "; EM NÃO CONFORMIDADE;");
                writerNaoConformidade.newLine();

            }
        }
//        } catch (Exception e) {
//            throw new IOException(e);
//        }
    }
}
