package fr.istic.sir.rest;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;
import service.PersonDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class SampleWebService {

    private PersonDAO dao;
    public SampleWebService(){
        dao = new PersonDAO();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hi, how are you today ?";
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person findPerson(){
        Person person = new Person();
        person.setId((long) 1);
        person.setFirstName("Tifenn");
        person.setLastName("Gousset");
        person.setMail("tifenn.gousset@gmail.com");
        return person;
    }

    @POST
    @Path("/person2")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person createPerson(Person person){
        return dao.create(person);
    }

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome(){
        Home home = new Home();
        home.setId((long)1);
        home.setHeight(400);
        home.setNbRoom(3);
        Person person = new Person();
        //person.addHome(home);
        home.setOwner(person);
        Heater heater = new Heater((double) 300);
        heater.setId(1);
        heater.setHome(home);
        home.addHeater(heater);
        ElectronicDevice eDevice = new ElectronicDevice((double) 25);
        eDevice.setId(1);
        home.addElectronicDevice(eDevice);
        return home;
    }

    @GET
    @Path("/device")
    @Produces(MediaType.APPLICATION_JSON)
    public ElectronicDevice getDevice(){
        ElectronicDevice eDevice = new ElectronicDevice((double) 50);
        eDevice.setId((long)1);
        Home home = new Home();
        home.addElectronicDevice(eDevice);

        return eDevice;
    }

    @GET
    @Path("/heater")
    @Produces(MediaType.APPLICATION_JSON)
    public Heater getHeater(){
        Heater heater = new Heater((double) 250);
        heater.setId((long)1);
        Home home = new Home();
        home.addHeater(heater);
        return heater;
    }

}
