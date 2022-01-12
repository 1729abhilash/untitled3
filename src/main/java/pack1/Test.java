package pack1;//hibernate is a java framwrork that simplifies the development of java
//application to interact iwth the database.
//hibernate is a orm tool
//hibernate is an open source,lightweight
//hibernate is a non-invaisv3e frameowrk ,means it wont;t forces
//the programmers to extend/implment any class/interface
//ant type of application can build with hibernate framwork
//traditional way to save data (jdbc)_
//@Entity use to mark any class as Entity
//@Table use to change the table details
//@id use to mark column as id(primary key)
//  @Column can be used to specify column mappings.for  to change the column name in the associated table in database
//@Transient this tells hibernate not to save field
//@Temporal over a date field tells hibernate the format in which the date
//needws to be saved
//@Lob tells hibernate that this is a large object not a simpleo obhject   /blob/clog
//@onetoone,@onetomanyy,@manytoone,@joincolumn
//fetch data

//get()
//get method of hibernate session

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {
        Configuration cfg=new Configuration();
      cfg.configure("hibernate.cfg.xml");
      SessionFactory factory=cfg.buildSessionFactory();

     //creating student
        Student st=new Student(101,"John","delhi");
       ///
//   session.beginTransaction();
//   session.save(st);
//   session.getTransaction().commit();
//   session.close();

        //or
        //creating address object
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(213);
        //reading image
//      FileInputStream fis=new FileInputStream("src/main");
//      byte [] data=new byte[fis.available()];
//     fis.read(data);
//     ad.setImage(data);
        Session session= factory.openSession();

        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();

        //



    }

}
