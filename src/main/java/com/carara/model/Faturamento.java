package com.carara.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import static com.carara.util.DateUtil.getDateFormat;
import static com.carara.util.NumberUtil.parseNumber;

public class Faturamento {
    private String company;
    private Integer mes;
    private Integer ano;
    private Date dataParcela1;
    private BigDecimal parcela1;
    private Date dataParcela2;
    private BigDecimal parcela2;
    private Date dataParcela3;
    private BigDecimal parcela3;

    public Faturamento(String company, String mes, String ano, String dataParcela1, String parcela1,
                       String dataParcela2, String parcela2, String dataParcela3, String parcela3)
            throws ParseException {

        this.company = company;
        this.mes = Integer.valueOf(mes);
        this.ano = Integer.valueOf(ano);
        this.dataParcela1 = getDateFormat().parse(dataParcela1);
        this.parcela1 = BigDecimal.valueOf(parseNumber(parcela1));
        this.dataParcela2 = getDateFormat().parse(String.valueOf(dataParcela2));
        this.parcela2 = BigDecimal.valueOf(parseNumber(parcela2));
        this.dataParcela3 = getDateFormat().parse(String.valueOf(dataParcela3));
        this.parcela3 = BigDecimal.valueOf(parseNumber(parcela3));
    }

    public BigDecimal getValorTotalParcelas() {
        return getParcela1().add(getParcela2()).add(getParcela3());
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public BigDecimal getParcela1() {
        return parcela1;
    }

    public void setParcela1(BigDecimal parcela1) {
        this.parcela1 = parcela1;
    }


    public BigDecimal getParcela2() {
        return parcela2;
    }


    public BigDecimal getParcela3() {
        return parcela3;
    }

}
