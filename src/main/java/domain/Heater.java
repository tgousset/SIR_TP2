package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater {

    private Long Id;
    private Double cons;
    private Home home;

    public Heater(Double cons){
        this.cons = cons;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getCons() {
        return cons;
    }

    public void setCons(Double cons) {
        this.cons = cons;
    }

    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
