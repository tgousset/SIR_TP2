package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home {

    private Long id;
    private int height;
    private int nbRoom;
    private Person owner;
    private List<Heater> heaterList;
    private List<ElectronicDevice> electronicDeviceList;

    public Home(int height, int nbRoom){
        this.height = height;
        this.nbRoom = nbRoom;
        this.heaterList = new ArrayList<Heater>();
        this.electronicDeviceList = new ArrayList<ElectronicDevice>();

    }

    public Home(){
        this.heaterList = new ArrayList<Heater>();
        this.electronicDeviceList = new ArrayList<ElectronicDevice>();
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNbRoom() {
        return nbRoom;
    }

    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    @ManyToOne
    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "home")
    public List<Heater> getHeaterList() {
        return heaterList;
    }

    public void setHeaterList(List<Heater> heaterList) {
        this.heaterList = heaterList;
    }

    @OneToMany(mappedBy = "home")
    public List<ElectronicDevice> getElectronicDeviceList() {
        return electronicDeviceList;
    }

    public void setElectronicDeviceList(List<ElectronicDevice> electronicDeviceList) {
        this.electronicDeviceList = electronicDeviceList;
    }
}
