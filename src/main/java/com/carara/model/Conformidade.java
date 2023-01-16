package com.carara.model;

public class Conformidade {
    private String empresa;
    private String conformidadeStatus;

    public Conformidade(String empresa, String conformidade) {
        this.empresa = empresa;
        this.conformidadeStatus = conformidade;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getConformidadeStatus() {
        return conformidadeStatus;
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
