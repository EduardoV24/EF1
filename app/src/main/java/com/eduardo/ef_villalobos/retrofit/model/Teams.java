package com.eduardo.ef_villalobos.retrofit.model;

public class Teams {

    private String logo_url;
    private String name;


    public Teams(String logo_url, String name) {
        this.logo_url = logo_url;
        this.name = name;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
