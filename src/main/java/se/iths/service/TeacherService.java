package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;


    public Set<Student> getStudentsForSubject(String teacherName, String subjectName) {
        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT i FROM Subject i INNER JOIN i.teacher t INNER JOIN i.students s WHERE t.name = :teacherName AND i.name =:subjectName")
                .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();
        Set<Student> studentsResult = subject.getStudents();
        return studentsResult;
    }
}
