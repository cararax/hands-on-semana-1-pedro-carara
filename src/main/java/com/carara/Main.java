package com.carara;

import java.io.IOException;
import java.util.Scanner;

import static com.carara.calculator.ComplianceCalculator.calculateCompliance;

public class Main {

    public static void main(String[] args) throws IOException {

        String isContinue = null;
        Integer referenceYear = null;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Informe o ano fiscal de referencia para consultar e gerar os arquivos:");
                referenceYear = scanner.nextInt();
                if (referenceYear > 2022) {
                    System.out.println("Ano fiscal de referencia invalido");
                } else {
                    System.out.println("Relatorio gerado e disponível na pasta export.");
                }
                System.out.println("Deseja gerar o relatório novamente? SIM ou NAO");
                isContinue = scanner.next();

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } while (isContinue.equalsIgnoreCase("SIM"));
        System.out.println("Fim do programa.");

    }
}


