package com.carara.model;

public class Conformidade {
    private String empresa;
    private String conformidade;

    public Conformidade(String empresa, String conformidade) {
        this.empresa = empresa;
        this.conformidade = conformidade;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getConformidade() {
        return conformidade;
    }

    public void setConformidade(String conformidade) {
        this.conformidade = conformidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conformidade that = (Conformidade) o;

        return empresa.equals(that.empresa);
    }

    @Override
    public int hashCode() {
        return empresa.hashCode();
    }
}
