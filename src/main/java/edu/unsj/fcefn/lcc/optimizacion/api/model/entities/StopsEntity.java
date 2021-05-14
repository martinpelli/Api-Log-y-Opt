package edu.unsj.fcefn.lcc.optimizacion.api.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stops")
public class StopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "category")
    private String category;
    @Column(name = "province")
    private String province;
    @Column(name = "country")
    private String country;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "logitud")
    private String logitud;
    @Column(name = "ranking")
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
