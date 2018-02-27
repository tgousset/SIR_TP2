package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice extends IntelligentPeripheral{

    private Long id;
    private Double cons;
    private Home home;

    public ElectronicDevice(Double cons){
        this.cons = cons;
    }

    public ElectronicDevice(){}

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
