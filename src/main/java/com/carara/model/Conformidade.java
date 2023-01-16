package com.carara.model;

public class Conformidade {
    private String company;
    private String Compliance;

    public Conformidade(String company, String compliance) {
        this.company = company;
        Compliance = compliance;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompliance() {
        return Compliance;
    }

    public void setCompliance(String compliance) {
        Compliance = compliance;
    }
}
