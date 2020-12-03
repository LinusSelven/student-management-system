package se.iths.service;


import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SchoolService {

    @PersistenceContext
    EntityManager entityManager;


    public List<Student> getStudentsAndTheirSubjectsByLastName(String name) {
        List<Student> students = entityManager.createQuery("SELECT st.firstName, st.lastname, su.name FROM Subject su inner join Student st WHERE st.lastname  = \'" + name + "\'", Student.class).getResultList();
        return students;
    }
}
