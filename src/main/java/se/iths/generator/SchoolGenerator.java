package se.iths.generator;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SchoolGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Peter", "Persson", "peter.persson@mail.com", "031-010101");
        Student student2 = new Student( "Ludvig", "Larsson", "ludvig.larsson@mail.com", "0708-222333");
        Student student3 = new Student("Anton", "Andersson", "anton.andersson@mail.com", "031-223311");

        Subject subject1 = new Subject("Java");
        Subject subject2 = new Subject("C#");
        Subject subject3 = new Subject("C++");

        Teacher teacher1 = new Teacher("Albert");
        Teacher teacher2 = new Teacher("Sven");
        Teacher teacher3 = new Teacher("Roger");

        // fyll med refferenser

        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);
        student2.addSubject(subject1);
        student2.addSubject(subject2);
        student3.addSubject(subject3);

        teacher1.addSubject(subject3);
        teacher1.addSubject(subject1);
        teacher2.addSubject(subject2);

        // Send to entityManager
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
    }
}