package fr.istic.sir.rest;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/api")
public class SampleWebService {

    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public SampleWebService(){

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hi, how are you today ?";
    }

    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getPerson(){
       return manager.createQuery("Select p from Person p", Person.class).getResultList();
    }

    @GET
    @Path("/persons/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") long id) {
        return manager.createQuery("Select p from Person p where p.id = :id", Person.class).setParameter("id", id).getResultList().get(0);
    }

    @POST
    @Path("/createPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
                                 @QueryParam("mail") String mail) {
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setMail(mail);

        tx.begin();
        manager.persist(p);
        tx.commit();

        String result = "LastName: " + lastName + "\n FirstName : " + firstName + "\n Mail : " + mail;
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/homes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Home> getHome(){
        return manager.createQuery("Select h from Home h", Home.class).getResultList();
    }

    @POST
    @Path("/homes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHome(@QueryParam("height") int height,
                                 @QueryParam("nbRoom") int nbRoom, @QueryParam("idOwner") long idO) {
        Home home = new Home();

        home.setHeight(height);
        home.setNbRoom(nbRoom);

        Person owner = manager.createQuery("Select p from Person p where p.id = :id", Person.class)
                .setParameter("id", idO).getResultList().get(0);

        home.setOwner(owner);

        tx.begin();
        manager.persist(home);
        tx.commit();

        String result = "Height : " + height + "; Number of room : " + nbRoom + "; Home ID : " + idO;
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome2() {
        Home h = new Home();
        h.setNbRoom(5);
        Heater h1 = new Heater();
        h1.setCons((double) 500);
        Heater h2 = new Heater();
        h2.setCons((double) 600);
        h.addHeater(h1);
        h.addHeater(h2);
        return h;
    }

    @GET
    @Path("/device")
    @Produces(MediaType.APPLICATION_JSON)
    public ElectronicDevice getDevice(){
        ElectronicDevice eDevice = new ElectronicDevice((double) 50);
        eDevice.setId(1);
        return eDevice;
    }

    @GET
    @Path("/heater")
    @Produces(MediaType.APPLICATION_JSON)
    public Heater getHeater(){
        Heater heater = new Heater();
        heater.setCons((double) 25);
        return heater;
    }

}
