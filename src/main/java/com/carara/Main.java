package com.carara;

import java.util.Scanner;
import java.util.logging.Logger;

import static com.carara.calculator.ComplianceCalculator.calculateCompliance;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String isContinue = "";
        Integer referenceYear;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                LOGGER.info("Informe o ano fiscal de referencia para consultar e gerar os arquivos:");
                referenceYear = scanner.nextInt();
                if (referenceYear > 2022) {
                    LOGGER.info("Ano fiscal de referencia invalido");
                } else {
                    calculateCompliance(referenceYear);
                    LOGGER.info("Relatorio gerado e disponível na pasta export.");
                }
                LOGGER.info("Deseja gerar o relatório novamente? SIM ou NAO");
                isContinue = scanner.next();

            } catch (Exception exception) {
                LOGGER.info(exception.getMessage());
            }
        } while (isContinue.equalsIgnoreCase("SIM"));
        LOGGER.info("Fim do programa.");

    }
}


