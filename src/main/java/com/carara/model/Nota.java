package com.carara.model;

import com.carara.util.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import static com.carara.util.NumberUtil.parseNumber;

public class Nota {
    private String company;
    private Integer mes;
    private Integer ano;
    private BigDecimal valor;
    private Date dataEmissao;
    private Integer numeroNota;

    public Nota(String company, String mes, String ano, String valor, String dataEmissao, String numeroNota)
            throws ParseException {

        this.company = company;
        this.mes = Integer.valueOf(mes);
        this.ano = Integer.valueOf(ano);
        this.valor = BigDecimal.valueOf(parseNumber(valor));
        this.dataEmissao = DateUtil.getDateFormat().parse(dataEmissao);
        this.numeroNota = Integer.valueOf(numeroNota);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
