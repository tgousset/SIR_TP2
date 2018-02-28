package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private List<Person> friends;
    private List<Home> homeList;

    public Person(String lastName, String firstName, String mail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.homeList = new ArrayList<Home>();
        this.friends = new ArrayList<Person>();
    }

    public Person(String lastName){
        this.lastName = lastName;
    }

    public Person(){
        homeList = new ArrayList<Home>();
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @OneToMany
    @JsonIgnore
    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public void addFriend(Person p){
        friends.add(p);
    }

    public void removeFriend(int index){
        friends.remove(index);
    }

    public void removeFriend(Person p){
        friends.remove(p);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    public List<Home> getHomeList() {
        return homeList;
    }

    public void setHomeList(List<Home> homeList) {
        this.homeList = homeList;
    }

    public void addHome(Home home){
        this.homeList.add(home);
    }

    public void removeHome(int index){
        this.homeList.remove(index);
    }

    public void removeHome(Home home){
        this.homeList.remove(home);
    }


}
