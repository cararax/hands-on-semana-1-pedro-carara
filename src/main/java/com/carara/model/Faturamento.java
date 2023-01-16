package com.carara.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import static com.carara.util.DateUtil.dateFormat;
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
        this.dataParcela1 = dateFormat.parse(dataParcela1);
        this.parcela1 = BigDecimal.valueOf(parseNumber(parcela1));
        this.dataParcela2 = dateFormat.parse(String.valueOf(dataParcela2));
        this.parcela2 = BigDecimal.valueOf(parseNumber(parcela2));
        this.dataParcela3 = dateFormat.parse(String.valueOf(dataParcela3));
        this.parcela3 = BigDecimal.valueOf(parseNumber(parcela3));
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

    public Date getDataParcela1() {
        return dataParcela1;
    }

    public void setDataParcela1(Date dataParcela1) {
        this.dataParcela1 = dataParcela1;
    }

    public BigDecimal getParcela1() {
        return parcela1;
    }

    public void setParcela1(BigDecimal parcela1) {
        this.parcela1 = parcela1;
    }

    public Date getDataParcela2() {
        return dataParcela2;
    }

    public void setDataParcela2(Date dataParcela2) {
        this.dataParcela2 = dataParcela2;
    }

    public BigDecimal getParcela2() {
        return parcela2;
    }

    public void setParcela2(BigDecimal parcela2) {
        this.parcela2 = parcela2;
    }

    public Date getDataParcela3() {
        return dataParcela3;
    }

    public void setDataParcela3(Date dataParcela3) {
        this.dataParcela3 = dataParcela3;
    }

    public BigDecimal getParcela3() {
        return parcela3;
    }

    public void setParcela3(BigDecimal parcela3) {
        this.parcela3 = parcela3;
    }
}
