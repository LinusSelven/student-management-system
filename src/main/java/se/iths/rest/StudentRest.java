package se.iths.rest;


import se.iths.entity.Student;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("add")
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("all")
    @GET
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty())
            throw new StudentNotFoundException("No students were found");
        return students;
    }


    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null)
            return Response
                    .ok(foundStudent)
                    .build();
        else
            throw new StudentNotFoundException("Student with ID " + id + " not found");

    }
    @Path("name/{lastname}")
    @GET
    public Response getStudent(@PathParam("lastname") String lastName) {
        var foundStudent = studentService.findStudentByLastName(lastName);
        if (!foundStudent.isEmpty())
            return Response
                    .ok(foundStudent)
                    .build();
        else
            throw new StudentNotFoundException("Student with lastname " + lastName + " not found");
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        boolean studentWasDeleted = studentService.deleteStudent(id);
        if (studentWasDeleted)
            return Response
                    .ok()
                    .entity("Student with ID " + id + " was deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        else
            return Response
                    .noContent()
                    .build();

    }


}
