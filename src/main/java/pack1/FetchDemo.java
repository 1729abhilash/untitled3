package pack1;

//difference between get and load
//get mehtod of hibernate session return s null
//if object is not found in cache as well as on databaase
//but in load case load method throws objectnotfoundexception
//if object is not found on cache as well as on database
//but never return null

//get()   use of you are not sure that object exists in db or not
//load use if you are sure that object exists

//get (() involves database hit if objeddct doesn;t exists
//in session cache and returns a fully initialized object
//whihch may involve several databases call

//load method can return proxy in place and only
//initialize the object or hit the database
//if any method other than getId() iss called on persistent
//or entity object.This lazy initialization
//increases the performance 


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        //get //load
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

   SessionFactory factory4=cfg.buildSessionFactory();

Session session=factory4.openSession();
//get student 101
   //  Student student=(Student)   session.get(Student.class,101);
        Student student=(Student)   session.load(Student.class,101);
       Address address=(Address) session.load(Address.class,1);

        System.out.println(student);
        System.out.println(address);

session.close();
   factory4.close();
    }
}
