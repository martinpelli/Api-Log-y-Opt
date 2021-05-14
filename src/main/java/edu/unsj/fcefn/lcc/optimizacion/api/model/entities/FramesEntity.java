package edu.unsj.fcefn.lcc.optimizacion.api.model.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "frames")
public class FramesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "arrival_datetime")
    private LocalTime arrival_datetime;
    @Column(name = "departure_datetime")
    private LocalTime departure_datetime;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private Float price;
    @OneToOne
    @JoinColumn(name = "id_transport_company")
    @NotFound(action = NotFoundAction.IGNORE)
    private TransportCompanyEntity id_transport_company;
    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name ="id_stop_departure")
    private StopsEntity id_stop_departure;
    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name ="id_stop_arrival")
    private StopsEntity id_stop_arrival;


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
        return id_transport_company;
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
        this.id_transport_company = id_stop_company;
    }
}
