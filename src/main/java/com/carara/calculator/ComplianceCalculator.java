package com.carara.calculator;

import com.carara.model.Conformidade;
import com.carara.model.Faturamento;
import com.carara.model.Nota;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.carara.reader.FileReader.faturamentoReader;
import static com.carara.reader.FileReader.notaReader;

public class ComplianceCalculator {
    public static final String EXPORT_PATH = "src/export/";

    private ComplianceCalculator() {
    }

    public static void calculateCompliance(Integer referenceYear) throws IOException {
        List<Conformidade> empresasConformidade = new ArrayList<>();
        List<Conformidade> empresasNaoConformidade = new ArrayList<>();

        List<Faturamento> faturamentoList = faturamentoReader(referenceYear);
        List<Nota> notaList = notaReader(referenceYear);

        List<String> empresas = faturamentoList.stream().map(Faturamento::getCompany).toList();

        for (String empresa : empresas) {
            BigDecimal valorTotalFaturamento = BigDecimal.ZERO;
            BigDecimal valorTotalNotas = BigDecimal.ZERO;

            List<Faturamento> faturamentoListByCompany = faturamentoList.stream()
                    .filter(f -> f.getCompany().equals(empresa))
                    .toList();

            List<Nota> notasByCompany = notaList.stream()
                    .filter(n -> n.getCompany().equals(empresa))
                    .toList();

            if (!faturamentoListByCompany.isEmpty() && !notasByCompany.isEmpty()) {
                for (Faturamento faturmento : faturamentoListByCompany) {
                    valorTotalFaturamento = valorTotalFaturamento.add(faturmento.getValorTotalParcelas());
                }
                for (Nota nota : notasByCompany) {
                    valorTotalNotas = valorTotalNotas.add(nota.getValor());
                }
            }

            if (valorTotalNotas.equals(valorTotalFaturamento)) {
                empresasConformidade.add(new Conformidade(empresa, "EM CONFORMIDADE"));
            } else {
                empresasNaoConformidade.add(new Conformidade(empresa, "EM NÃO CONFORMIDADE"));
            }
        }
        printToFile(empresasConformidade, empresasNaoConformidade, String.valueOf(referenceYear));
    }

    private static void printToFile(List<Conformidade> empresasConformidade, List<Conformidade> empresasNaoConformidade, String referenceYear) throws IOException {
        try (BufferedWriter writerConformidade = new BufferedWriter(new FileWriter(EXPORT_PATH + "EmpresasEmConformidade" + referenceYear + ".txt"))) {
            writerConformidade.write("Empresa;Conformidade;");
            writerConformidade.newLine();

            empresasNaoConformidade = empresasNaoConformidade.stream().distinct().toList();
            empresasConformidade = empresasConformidade.stream().distinct().toList();

            for (Conformidade conformidade : empresasConformidade) {
                writerConformidade.write(conformidade.getEmpresa() + ";" + conformidade.getConformidadeStatus() + ";");
                writerConformidade.newLine();
            }
        }

        try (BufferedWriter writerNaoConformidade = new BufferedWriter(new FileWriter(EXPORT_PATH + "EmpresasEmNaoConformidade" + referenceYear + ".txt"))) {
            writerNaoConformidade.write("Empresa;Conformidade;");
            writerNaoConformidade.newLine();

            for (Conformidade conformidade : empresasNaoConformidade) {
                writerNaoConformidade.write(conformidade.getEmpresa() + ";" + conformidade.getConformidadeStatus() + ";");
                writerNaoConformidade.newLine();
            }
        }
    }
}
