package se.iths.rest;


import se.iths.entity.Student;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.service.SchoolService;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolRest {

    @Inject
    StudentService studentService;
    @Inject
    SubjectService subjectService;
    @Inject
    TeacherService teacherService;

    @Inject
    SchoolService schoolService;


    @Path("getstudentsandsubjects/{lastname}/")
    @GET
    public Response getPlayerById(@PathParam("lastname") String name) {
        List<Student> player = schoolService.getStudentsAndTheirSubjectsByLastName(name);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new StudentNotFoundException("Student with name " + name + " not found.");
        }
    }


}