package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private Set<Subject> subjects = new HashSet<>();

    public Teacher(@NotEmpty String name) {
        this.name = name;
    }

    public Teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //   public Set<Subject> getSubjects() {
//       return subjects;
//   }

   public void setSubjects(Set<Subject> subjects) {
       this.subjects = subjects;
   }

    public void addSubject(Subject subject){
        subjects.add(subject);
        subject.setTeacher(this);
    }
}
