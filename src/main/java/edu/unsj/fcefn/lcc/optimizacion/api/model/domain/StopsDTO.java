package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;


public class StopsDTO {

    private Integer id;
    private String name;
    private String city;
    private String category;
    private String province;
    private String country;
    private String latitud;
    private String logitud;
    private Integer ranking;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLogitud() {
        return logitud;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLogitud(String logitud) {
        this.logitud = logitud;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
