package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;


import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.StopsEntity;
import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.TransportCompanyEntity;

import java.time.LocalTime;


public class FramesDTO {

    private Integer id;
    private LocalTime arrival_datetime;
    private LocalTime departure_datetime;
    private String category;
    private Float price;
    private StopsEntity id_stop_arrival;
    private StopsEntity id_stop_departure;
    private TransportCompanyEntity id_stop_company;



    public Integer getId() {
        return id;
    }

    public LocalTime getArrival_datetime() {
        return arrival_datetime;
    }

    public LocalTime getDeparture_datetime() {
        return departure_datetime;
    }

    public String getCategory() {
        return category;
    }

    public Float getPrice() {
        return price;
    }

    public StopsEntity getId_stop_arrival() {
        return id_stop_arrival;
    }

    public StopsEntity getId_stop_departure() {
        return id_stop_departure;
    }

    public TransportCompanyEntity getId_stop_company() {
        return id_stop_company;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setArrival_datetime(LocalTime arrival_datetime) {
        this.arrival_datetime = arrival_datetime;
    }

    public void setDeparture_datetime(LocalTime departure_datetime) {
        this.departure_datetime = departure_datetime;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setId_stop_arrival(StopsEntity id_stop_arrival) {
        this.id_stop_arrival = id_stop_arrival;
    }

    public void setId_stop_departure(StopsEntity id_stop_departure) {
        this.id_stop_departure = id_stop_departure;
    }

    public void setId_stop_company(TransportCompanyEntity id_stop_company) {
        this.id_stop_company = id_stop_company;
    }
}
