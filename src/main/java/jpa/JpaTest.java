package jpa;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	/**
	 * @param args
	 */

	private EntityManager manager;

	public JpaTest(EntityManager manager){
	    this.manager = manager;
    }

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			
			/*Person p = new Person();
			p.setLastName("martin");
			manager.persist(p);*/

	        //test.createPerson("Jack");
			//test.removePerson("Tifenn");
			//test.createPerson("Gousset", "Tifenn", "tifenn.gousset@gmail.com");
            test.removePerson("Gousset", "Tifenn", "tifenn.gousset@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";
		
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin"); 
//		List<Person> res = q.getResultList();
		
//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();
	}

	public void createPerson(String name){
	    int numOfPerson = manager.createQuery("Select p From Person p", Person.class).getResultList().size();
	    //if(numOfPerson == 0){
            manager.persist(new Person(name));
        //}
    }

    public void createPerson(String lastName, String firstName, String mail){

        manager.persist(new Person(lastName, firstName, mail));

    }

    public void removePerson(String name){
		int numOfPerson = manager.createQuery("Select p From Person p", Person.class).getResultList().size();
		if(numOfPerson > 0){
		    /*l0ong id = manager.createQuery("Select id from Person where LastName=" + name, Person.class).getFirstResult();
			*/
            long id = manager.createQuery("Select p from Person p where LastName="+"'"+name+"'" , Person.class).getSingleResult().getId();
            Person p = manager.find(Person.class, id);
            manager.remove(p);
		}
	}

	public void removePerson(String lastName, String firstName, String mail){
        int numOfPerson = manager.createQuery("Select p From Person p", Person.class).getResultList().size();
        if(numOfPerson > 0){
            /*l0ong id = manager.createQuery("Select id from Person where LastName=" + name, Person.class).getFirstResult();
             */
            long id = manager.createQuery("Select p from Person p where LastName='"+lastName+"' and FirstName='" + firstName + "' and mail='"+mail +"'" , Person.class).getSingleResult().getId();
            Person p = manager.find(Person.class, id);
            manager.remove(p);
        }
    }





}
