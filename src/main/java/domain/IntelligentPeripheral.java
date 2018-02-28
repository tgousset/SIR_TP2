package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class IntelligentPeripheral {

    private long id;
    private Double cons;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getCons() {
        return this.cons;
    }

    public void setCons(Double cons) {
        this.cons = cons;
    }
}
