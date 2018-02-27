package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class IntelligentPeripheral {

    private long id;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
