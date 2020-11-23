package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Student;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        if (student != null)
            entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findStudentByLastName(String lastName) {
        var query = entityManager
                .createQuery("SELECT s from Student s WHERE s.lastname = :lastname", Student.class);
        return query.setParameter("lastname", lastName).getResultList();
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public boolean deleteStudent(Long id) {
        Student studentToBeDeleted = findStudentById(id);
        if (studentToBeDeleted != null)
            entityManager.remove(studentToBeDeleted);
        return studentToBeDeleted != null;
    }
}
